package ru.ramazanov.controllers;

import ru.ramazanov.dbconnect.ConnectionToDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 22.02.2017.
 */
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String sql = "SELECT * FROM users";
        PrintWriter pw = resp.getWriter();
        ArrayList<String> userlist = new ArrayList<>();
        try {
            ResultSet rs =  ConnectionToDB.getInstance().createStatement().executeQuery(sql);
            while(rs.next()){
                userlist.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("userlist", userlist);
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
