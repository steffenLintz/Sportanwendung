/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ActivityBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ValidationBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Sporttype;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/app/changeActivity/*"})
public class changeActivityServlet extends HttpServlet {

    @EJB
    ActivityBean activityBean;
    
    @EJB
    ValidationBean validationBean;
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        request.setCharacterEncoding("utf-8");
        
        Activity activity = this.activityBean.findById(Long.parseLong(request.getRequestURI().substring(35)));
        
        String calories = request.getParameter("activity_edit_calories");
        String date = request.getParameter("activity_edit_date");
        String time = request.getParameter("activity_edit_time");
        String duration = request.getParameter("activity_edit_duration");
        String distance = request.getParameter("activity_edit_distance");
        String sporttype = request.getParameter("activity_edit_sporttype");
        List<String> errors = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        
        
        if(!date.equals("") && !time.equals("")){
            try {
                activity.setDate(dateFormat.parse(date+" "+time));
            } catch (Exception ex) {
             errors.add("Datum angeben");
            }
        }else{
            errors.add("Datum angeben");
        }
        
        if(!duration.equals("")){
           try {
                activity.setDuration(new Integer(duration));
            } catch (Exception ex){
             errors.add("Dauer angeben");
            }
        }else{
            errors.add("Dauer angeben");
        }
        
        if(!distance.equals("")){
            try{
                activity.setDistance(new Integer(distance));
            }catch (Exception ex){
                errors.add("Distanz/Anzahl Wiederholungen angeben");
            }
        }else{
            errors.add("Distanz/Anzahl Wiederholungen angeben");
        }
        
        activity.setSporttype(new Sporttype(sporttype));
        
        activity.setCalories();
        
         this.validationBean.validate(activity, errors);

        // Datensatz speichern
        if (errors.isEmpty()) {
            this.activityBean.update(activity);

        }

        // Weiter zur nächsten Seite
        if (errors.isEmpty()) {
            // Keine Fehler: Startseite aufrufen
            response.sendRedirect(WebUtils.appUrl(request, "/app/home/"));
        } else {
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);

            HttpSession session = request.getSession();
            session.setAttribute("user_edit_form", formValues);

            response.sendRedirect(request.getRequestURI());
        }
        
        
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Activity activity = this.activityBean.findById(Long.parseLong(request.getRequestURI().substring(35)));
        
        Date d = activity.getDate();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");

        String adate = format.format(d);
        String atime = format2.format(d);
        
        HttpSession session = request.getSession();
        
        switch (activity.getSporttype().getName()) {
                case "Fußball":
                 session.removeAttribute("sporttype1");
                 session.removeAttribute("sporttype2");
                 session.removeAttribute("sporttype3");
                 session.removeAttribute("sporttype4");
                 session.removeAttribute("sporttype5");
                 session.removeAttribute("sporttype6");
                 session.setAttribute("title", "Distanz in km");
                 session.setAttribute("sporttype1", "selected");
                 break;
            case "Tennis":
                 session.removeAttribute("sporttype1");
                 session.removeAttribute("sporttype2");
                 session.removeAttribute("sporttype3");
                 session.removeAttribute("sporttype4");
                 session.removeAttribute("sporttype5");
                 session.removeAttribute("sporttype6");
                 session.setAttribute("title", "Distanz in km");
                 session.setAttribute("sporttype2", "selected");
                 break;
            case "Schwimmen":
                 session.removeAttribute("sporttype1");
                 session.removeAttribute("sporttype2");
                 session.removeAttribute("sporttype3");
                 session.removeAttribute("sporttype4");
                 session.removeAttribute("sporttype5");
                 session.removeAttribute("sporttype6");
                 session.setAttribute("title", "Distanz in km");
                 session.setAttribute("sporttype3", "selected");
                break;
            case "Fahrrad":
                 session.removeAttribute("sporttype1");
                 session.removeAttribute("sporttype2");
                 session.removeAttribute("sporttype3");
                 session.removeAttribute("sporttype4");
                 session.removeAttribute("sporttype5");
                 session.removeAttribute("sporttype6");
                 session.setAttribute("title", "Distanz in km");
                 session.setAttribute("sporttype4", "selected");
                break;
            case "Laufen":
                 session.removeAttribute("sporttype1");
                 session.removeAttribute("sporttype2");
                 session.removeAttribute("sporttype3");
                 session.removeAttribute("sporttype4");
                 session.removeAttribute("sporttype5");
                 session.removeAttribute("sporttype6");
                 session.setAttribute("title", "Distanz in km");
                 session.setAttribute("sporttype5", "selected");
                  break;
            case "Kraftsport":
                 session.removeAttribute("sporttype1");
                 session.removeAttribute("sporttype2");
                 session.removeAttribute("sporttype3");
                 session.removeAttribute("sporttype4");
                 session.removeAttribute("sporttype5");
                 session.removeAttribute("sporttype6");
                 session.setAttribute("title", "Anzahl Wiederholungen");
                 session.setAttribute("sporttype6", "selected");
                  break;
            }
 
        session.setAttribute("activity", activity);
        session.setAttribute("adate", adate);
        session.setAttribute("atime", atime);
        session.setAttribute("anlegen", "true");
        session.removeAttribute("changeActivity");
        session.setAttribute("changeActivity", this.createActivityForm(activity));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/app/changeActivity.jsp");
        dispatcher.forward(request, response);

    }
     private FormValues createActivityForm(Activity activity) {
        Map<String, String[]> values = new HashMap<>();

        values.put("activity_edit_calories", new String[]{
            ""+activity.getCalories()
        });

        values.put("activity_edit_duration", new String[]{
            ""+activity.getDuration()
        });
        
        values.put("activity_edit_distance", new String[]{
            ""+activity.getDistance()
        });

        values.put("activity_edit_sporttype", new String[]{
            activity.getSporttype().getName()
        });

       
        FormValues formValues = new FormValues();
        formValues.setValues(values);
        return formValues;
    }

}
