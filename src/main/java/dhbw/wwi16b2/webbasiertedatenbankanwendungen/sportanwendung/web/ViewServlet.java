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

        HttpSession session = request.getSession();

        Activity activity = this.activityBean.findById(Long.parseLong(request.getRequestURI().substring(25)));

        if (activity.getSporttype().getName().equals("Kraftsport")) {
            session.setAttribute("title", "Anzahl Wiederholungen");
        } else {
            session.setAttribute("title", "Distanz in km");
        }

        Date d = activity.getDate();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");

        String adate = format.format(d);
        String atime = format2.format(d);

        // Anfrage an dazugerhörige JSP weiterleiten
        session.setAttribute("activity", activity);
        session.setAttribute("adate", adate);
        session.setAttribute("atime", atime);
        session.setAttribute("anlegen", "true");
        session.removeAttribute("user_edit");

        session.removeAttribute("star1");
        session.removeAttribute("star2");
        session.removeAttribute("star3");
        session.removeAttribute("star4");
        session.removeAttribute("star5");

        System.out.println(activity.getRating());

        switch (activity.getRating()) {
            case 1:
                System.out.println("hier1");
                session.setAttribute("star1", "checked= 'checked'");
               
                break;
            case 2:
                System.out.println("hier2");
               session.setAttribute("star2", "checked= 'checked'");
 
                break;
            case 3:
                System.out.println("hier3");

                session.setAttribute("star3", "checked= 'checked'");
               

                break;
            case 4:
                System.out.println("hier4");
               
                session.setAttribute("star4", "checked= 'checked'");

                break;
            case 5:
                System.out.println("hier5");
             
                session.setAttribute("star5", "checked= 'checked'");
                break;
        }

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
