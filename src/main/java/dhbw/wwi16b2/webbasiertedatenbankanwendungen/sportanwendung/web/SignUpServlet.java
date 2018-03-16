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
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ValidationBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet für die Registrierungsseite. Hier kann sich ein neuer Benutzer
 * registrieren. Anschließend wird der auf die Startseite weitergeleitet.
 */
@WebServlet(urlPatterns = {"/signup/"})
public class SignUpServlet extends HttpServlet {
    
    @EJB
    ValidationBean validationBean;
            
    @EJB
    UserBean userBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Anfrage an dazugerhörige JSP weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/signup.jsp");
        dispatcher.forward(request, response);
        
        // Alte Formulardaten aus der Session entfernen
        HttpSession session = request.getSession();
        session.removeAttribute("signup_form");
        
        //Standard-Formulardaten setzen
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Formulareingaben auslesen
        request.setCharacterEncoding("utf-8");
        
        String username =   request.getParameter("signup_username");
        String password1 =  request.getParameter("signup_password1");
        String password2 =  request.getParameter("signup_password2");
        String email =      request.getParameter("signup_email");
        String firstname =  request.getParameter("signup_firstname");
        String lastname=  request.getParameter("signup_lastname");
        String gender=      request.getParameter("signup_gender");
        String birthdate =  request.getParameter("signup_birthdate");
        String weight =     request.getParameter("signup_weight");
        String height =     request.getParameter("signup_height");
        
        int groeße=-1;
        int gewicht=-1;
        Date birth= null; 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         
        if(!birthdate.equals("")){
            try {
                birth = dateFormat.parse(birthdate);
            } catch (ParseException ex) {
            }
        }
        
        if (!weight.equals("")){
             gewicht = Integer.parseInt(weight);
        }
        if (!height.equals("")){
            groeße = Integer.parseInt(height);
        }

        // Eingaben prüfen
        User user = new User(username, password1,email,firstname,lastname,gender,birth,gewicht,groeße);
        List<String> errors = this.validationBean.validate(user);
        this.validationBean.validate(user.getPassword(), errors);
        
        if (password1 != null && password2 != null && !password1.equals(password2)) {
            errors.add("Die beiden Passwörter stimmen nicht überein.");
        }
        
        // Neuen Benutzer anlegen
        if (errors.isEmpty()) {
            try {
                this.userBean.signup(username, password1,email,firstname,lastname,gender,birth,gewicht,groeße);
            } catch (UserBean.UserAlreadyExistsException ex) {
                errors.add(ex.getMessage());
            }
        }
        
        // Weiter zur nächsten Seite
        if (errors.isEmpty()) {
            // Keine Fehler: Startseite aufrufen
            request.login(username, password1);
            response.sendRedirect(WebUtils.appUrl(request, "/app/home/"));
        } else {
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);
            
            HttpSession session = request.getSession();
            session.setAttribute("signup_form", formValues);
            
            response.sendRedirect(request.getRequestURI());
        }
    }
    
}
