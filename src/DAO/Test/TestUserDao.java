package DAO.Test;

import DAO.Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 06.06.2015.
 * Реализованный класс ДАО сущности User
 */
public class TestUserDao extends ABaseDaoEntity<User> {
    @Override
    public String getSelectQuery() {
        return "SELECT * FROM exodb.user";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO exo.db.user (name, email) VALUES (?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE exodb.user SET name = ?, email = ? WHERE id= ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM exodb.user WHERE id= ?";
    }

    @Override
    public List parseResultSet(ResultSet rs) {
        List<User> list = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                list.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void prepareQueryForInsert(PreparedStatement statement, User user) throws SQLException{
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
    }

    @Override
    public void prepareQueryForUpdate(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setInt(3, user.getId());
    }
}
