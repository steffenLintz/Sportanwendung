/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.UserBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet, dass den Anwender ausloggt (die Session beendet) und ihn dann
 * auf die Startseite weiterleitet.
 */
@WebServlet(urlPatterns = {"/app/deleteUser/"})
public class DeleteServlet extends HttpServlet {
    @EJB
    UserBean userBean;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user= this.userBean.getCurrentUser();
        request.getSession().invalidate();
        this.userBean.delete(user);
        response.sendRedirect(WebUtils.appUrl(request, "/"));
    
    }
    
    
    

    /**
     * GET-Anfrage: Seite anzeigen
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        
        request.getRequestDispatcher("/WEB-INF/app/deleteUser.jsp").forward(request, response);

    }

}