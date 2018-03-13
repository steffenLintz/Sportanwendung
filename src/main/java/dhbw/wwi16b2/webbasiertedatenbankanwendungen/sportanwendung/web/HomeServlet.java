/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.UserBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Sporttype;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author z003ne3b
 */
@WebServlet(urlPatterns = {"/app/home/"})
public class HomeServlet extends HttpServlet {
    
    @EJB
    UserBean userbean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List<Activity> test= new ArrayList<>();
       
       test.add(new Activity(new Sporttype("fussball"), new Date(System.currentTimeMillis()), 0));
       
        
        HttpSession session = request.getSession();
        session.setAttribute("Vorname", this.userbean.getCurrentUser().getFirstname());
        session.setAttribute("activities",test ); 
            
        // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/app/home.jsp");
        dispatcher.forward(request, response);
    }

}
