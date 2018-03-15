/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ActivityBean;
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
    
    @EJB
    ActivityBean activitybean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       

        //this.activitybean.saveNew(testActivity);

        HttpSession session = request.getSession();
        session.removeAttribute("anlegen");
        session.removeAttribute("activities");
     //   session.setAttribute("activities", test);
       
        List <Activity> activity2= this.activitybean.findAllAcitvities();
        int wholeCalories=0;
        
        for (Activity a : activity2){
            wholeCalories= wholeCalories+ a.getCalories();
        }
        
        
        int ganzepizza = wholeCalories/1000;
        int pizza =  (wholeCalories%1000)/10;
        int nopizza = 100-pizza;
        
        
        session.setAttribute("ganzepizza",ganzepizza);
        session.setAttribute("pizza",pizza);
        session.setAttribute("nopizza",nopizza);

        
        session.setAttribute("activities",this.activitybean.findAllAcitvities());

        // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/app/home.jsp");
        dispatcher.forward(request, response);
    }

}
