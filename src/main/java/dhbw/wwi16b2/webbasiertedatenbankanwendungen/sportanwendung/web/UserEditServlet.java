/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.UserBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb.ValidationBean;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
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
@WebServlet(urlPatterns = {"/app/user-edit/"})
public class UserEditServlet extends HttpServlet {

    @EJB
    UserBean userbean;

    @EJB
    ValidationBean validationBean;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("user_edit");
        session.setAttribute("anlegen", "true");
        User user = this.userbean.getCurrentUser();

        if (session.getAttribute("user_edit_form") == null) {
            request.setAttribute("user_edit_form", this.createUserForm(user));
        }

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/app/user_edit.jsp").forward(request, response);

        session.removeAttribute("user_edit_form");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("user_username");
        String oldpassword = request.getParameter("user_edit_oldpassword");
        String password1 = request.getParameter("user_edit_password1");
        String password2 = request.getParameter("user_edit_password2");
        String email = request.getParameter("user_edit_email");
        String firstname = request.getParameter("user_edit_firstname");
        String lastname = request.getParameter("user_edit_lastname");
        String gender = request.getParameter("user_edit_gender");
        String birthdate = request.getParameter("user_edit_birthdate");
        String weight = request.getParameter("user_edit_weight");
        String height = request.getParameter("user_edit_height");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //   System.out.println("Passwort1:" + password1);
        //   System.out.println("Passwort2:" + password2);
        //   System.out.println("Altes Passwort:" + oldpassword);
        List<String> errors = new ArrayList<>();
        User user = this.userbean.getCurrentUser();

        if (!birthdate.equals("")) {
            try {
                user.setBirthdate(dateFormat.parse(birthdate));
            } catch (ParseException ex) {
            }
        }

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setGender(gender);
        user.setEmail(email);
        user.setWeight(new Integer(weight));
        user.setHeight(new Integer(height));

        if ((!password1.equals("")) || (!password2.equals("")) || (!oldpassword.equals(""))) {

            if (!password1.equals(password2)) {
                errors.add("Passwörter stimmen nicht überein");
            }
            if (!user.checkPassword(oldpassword)) {
                errors.add("Das alte Passwort ist falsch");
            }
            if (password1.length()<6){
                errors.add("Das neue Passwort muss mindestens 6-stellig sein");
            }
            
            if (errors.isEmpty()) {
                user.setPassword(password1);
            }
        }

        this.validationBean.validate(user, errors);

        // Datensatz speichern
        if (errors.isEmpty()) {
            this.userbean.update(user);

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

    private FormValues createUserForm(User user) {
        Map<String, String[]> values = new HashMap<>();

        values.put("user_edit_username", new String[]{
            user.getUsername()
        });

        values.put("user_edit_email", new String[]{
            user.getEmail()
        });

        values.put("user_edit_firstname", new String[]{
            user.getFirstname()
        });

        values.put("user_edit_lastname", new String[]{
            user.getLastname()
        });

        values.put("user_edit_gender", new String[]{
            user.getGender()
        });

        values.put("user_edit_birthdate", new String[]{
            dateFormat.format(user.getBirthdate())
        });

        values.put("user_edit_weight", new String[]{
            "" + user.getWeight()
        });

        values.put("user_edit_height", new String[]{
            "" + user.getHeight()
        });

        FormValues formValues = new FormValues();
        formValues.setValues(values);
        return formValues;
    }

}
