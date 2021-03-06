package main.controllers;

import main.services.LectionService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by smoldyrev on 24.02.17.
 */
public class DeleteLectionServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(DeleteLectionServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (LectionService.deleteLectioOnId(Integer.parseInt(id)) > 0) {
            logger.trace(req.getParameter("id") + " was deleted");
            resp.sendRedirect("/students/lections");
        } else {
            logger.trace(id + " not deleted");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
