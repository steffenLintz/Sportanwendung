/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ActivityBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.UserBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ValidationBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Sporttype;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(urlPatterns = {"/app/createNew/"})
public class CreateNewServlet extends HttpServlet {

    @EJB
    UserBean userbean;

    @EJB
    ValidationBean validationBean;

    @EJB
    ActivityBean activitybean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("anlegen", "true");

        // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/app/createNew.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Formulareingaben auslesen
        request.setCharacterEncoding("utf-8");

        String sporttype = request.getParameter("activity_sporttype");
        String duration = request.getParameter("activity_duration");
        String date = request.getParameter("activity_date");
        String time = request.getParameter("activity_time");
        //   String rating = request.getParameter("activity_rating");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Test
        String rating = "";

        int duration2 = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int rating2 = 0;
        Date date2 = null;
        List<String> errors;
        Activity activity;

        if (!duration.equals("")) {
            duration2 = Integer.parseInt(duration);
        }

        if (!date.equals("")) {
            try {
                date2 = dateFormat.parse(date);
            } catch (ParseException ex) {
            }
        }

        if (!time.equals("")) {
            hours = Integer.parseInt(time.substring(0, 1));
            minutes = Integer.parseInt(time.substring(3));
        }

        if (!date.equals("") && !time.equals("")) {
            try {
                date2 = new Date(year, month, day, hours, minutes, seconds);
            } catch (Exception e) {
            }
        }

        if (rating.equals("")) {
            // Eingaben prüfen
            activity = new Activity(new Sporttype(sporttype), date2, duration2, this.userbean.getCurrentUser());
            errors = this.validationBean.validate(activity);
        } else {
            activity = new Activity(new Sporttype(sporttype), date2, duration2, rating2, this.userbean.getCurrentUser());
            errors = this.validationBean.validate(activity);
        }
       
        if (errors.isEmpty()) {
            this.activitybean.saveNew(activity);
            response.sendRedirect(WebUtils.appUrl(request, "/app/home/"));
        } else {
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);
            HttpSession session = request.getSession();
            session.setAttribute("createNew_form", formValues);
            response.sendRedirect(request.getRequestURI());
        }
    }

}
