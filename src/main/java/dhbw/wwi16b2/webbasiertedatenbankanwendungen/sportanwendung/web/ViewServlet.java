/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ActivityBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet(urlPatterns = {"/app/view/*"})
public class ViewServlet extends HttpServlet {

    @EJB
    ActivityBean activityBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Activity activity = this.activityBean.findById(Long.parseLong(request.getRequestURI().substring(25)));
        
          Date d =activity.getDate();
          SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
          
          String adate = format.format(d);

        //  Activity current = this.activityBean.findById();
        // Anfrage an dazugerhörige JSP weiterleiten
        HttpSession session = request.getSession();
        session.setAttribute("activity", activity);
        session.setAttribute("adate", adate);
        session.setAttribute("anlegen", "true");
        session.removeAttribute("user_edit");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/app/view.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Activity activity = this.activityBean.findById(Long.parseLong(request.getRequestURI().substring(25)));
        HttpSession session = request.getSession();
        session.removeAttribute("activity");
        this.activityBean.delete(activity);
      

        
        response.sendRedirect("/sportanwendung/app/home/");
       
    }

}
