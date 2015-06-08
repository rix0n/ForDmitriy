package servl;

import DAO.BaseGenericDAO;
import DAO.Entity.User;
import DAO.Test.TestUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 1 on 30.05.2015.
 */
public class Redirect extends HttpServlet {
    private static int count = 0;
    private static int size = 0;
    private static Random rand = new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        size = 6;

        BaseGenericDAO<User> userDao = new TestUserDao();
        List<User> list = userDao.getAll();
        User newUser = userDao.getByPK(1);
        req.setAttribute("User", newUser.toString());
        req.setAttribute("hui", list.toString());


        Date date = new Date();
        req.setAttribute("current_count", count);
        req.setAttribute("date", date.toString());
        req.setAttribute("size", size);
        req.getRequestDispatcher("index.jsp").forward(req, resp);



    }
}
