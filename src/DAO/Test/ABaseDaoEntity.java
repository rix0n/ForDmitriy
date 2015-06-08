package DAO.Test;

import DAO.BaseGenericDAO;
import DAO.Entity.ABaseEntity;
import servl.ConnectionPool;

import java.sql.*;
import java.util.List;

/**
 * Created by 1 on 05.06.2015.
 */
public abstract class ABaseDaoEntity<T extends ABaseEntity> implements BaseGenericDAO<T>{

    private Connection connection;

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract List<T> parseResultSet(ResultSet rs);

    public abstract void prepareQueryForInsert(PreparedStatement statement, T entity) throws SQLException;
    /*
     * собирает sql запрос в соответствии с полями объекта/сущности, создания в БД
     */
    public abstract void prepareQueryForUpdate(PreparedStatement statement, T entity) throws SQLException;

    @Override
    public T getByPK(int key){
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String strSql = getSelectQuery();
        strSql += " WHERE id = ?";
        try {
            connection = ConnectionPool.getConnect();
            statement = connection.prepareStatement(strSql);
            statement.setInt(1, key);
            resultSet = statement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        } /*finally {
            if (connection != null) try {connection.close();} catch (SQLException ignore){}
            if (statement != null) try {statement.close();} catch (SQLException ignore) {}
            if (resultSet != null) try {resultSet.close();} catch (SQLException ignore) {}
        }*/

        return parseResultSet(resultSet).iterator().next();
    }

    @Override
    public T persist(T entity) {

        PreparedStatement statement;
        ResultSet resultSet = null;

        try{
            connection = ConnectionPool.getConnect();
            String strCreateSql = getCreateQuery();
            statement = connection.prepareStatement(strCreateSql);
            prepareQueryForInsert(statement, entity);
            statement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try{
            String strSql = getSelectQuery() + "WHERE id = last_insert_id();";
            statement = connection.prepareStatement(strSql);
            resultSet = statement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return parseResultSet(resultSet).iterator().next();
    }

    @Override
    public void update(T entity) {
        PreparedStatement statement = null;
        String strSql = getUpdateQuery();
        try{
            connection = ConnectionPool.getConnect();
            statement = connection.prepareStatement(strSql);
            prepareQueryForUpdate(statement, entity);
            statement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {

        PreparedStatement statement = null;
        String strSql = getDeleteQuery();
        try {
            connection = ConnectionPool.getConnect();
            statement = connection.prepareStatement(strSql);
            statement.setObject(1, entity.getId());
            statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    @Override
    public List<T> getAll(){

        List<T> list = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getConnect();
            statement = connection.createStatement();
            String strSql = getSelectQuery();
            resultSet = statement.executeQuery(strSql);
            list = parseResultSet(resultSet);
        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
            if (connection != null) try {connection.close();} catch (SQLException ignore){}
            if (statement != null) try {statement.close();} catch (SQLException ignore) {}
            if (resultSet != null) try {resultSet.close();} catch (SQLException ignore) {}
        }
        return list;
    }


}
