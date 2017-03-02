package main.controllers.listeners;

import main.common.exceptions.UserDAOException;
import main.common.utils.Mailer;
import main.models.dao.UserDAO;
import main.models.pojo.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by smoldyrev on 24.02.17.
 */
//начало работы сессии
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    private static Logger logger = Logger.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        logger.trace(se.getSession().getAttribute("name"));
        logger.trace(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.trace(se.getSession().getAttribute("name"));
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
//        logger.trace(event.getValue());
        if ("id".equals(event.getName())&&event.getValue()!=null){
            try {
                logger.trace("mail is ok");
                User user = UserDAO.getUserById((Integer) event.getValue());
                Mailer.sendMail(user.getEmail(),"youlogined","wow");
            } catch (UserDAOException e) {
                logger.error(e);
            }
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
