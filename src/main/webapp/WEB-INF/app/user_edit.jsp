<%-- 
    Document   : user_edit
    Created on : 18.03.2018, 20:09:07
    Author     : z003ne3b
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>

    <jsp:attribute name="title">
        Benutzer bearbeiten
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">

        <div class="container">
            <form method="post" class="stacked" oninput="x.value=parseInt(user_edit_height.value)">


                <div class="column">
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <h1>Logindaten</h1>

                    <label for="user_edit_username">
                        Benutzername:
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="user_edit_username" placeholder="Benutzername eingeben" value="${user_edit_form.values["user_edit_username"][0]}" readonly="readonly">
                    </div>

                    <label for="user_edit_oldpassword">
                        altes Passwort:
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="user_edit_oldpassword" placeholder="altes Passwort eingeben" value="${user_edit_form.values["user_edit_oldpassword"][0]}">
                    </div>

                    <label for="user_edit_password1">
                        Passwort:
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="user_edit_password1" placeholder="neues Passwort eingeben" value="${user_edit_form.values["user_edit_password1"][0]}">
                    </div>

                    <label for="user_edit_password2">
                        Passwort (wdh.):
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="user_edit_password2" placeholder="neues Passwort wdh." value="${user_edit_form.values["user_edit_password2"][0]}">
                    </div>


                    <%-- Persönliche Daten --%>
                    <h1>Persönliche Daten</h1>

                    <label for="user_edit_realname">
                        Vor- und Nachname:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="user_edit_firstname" placeholder="Max" value="${user_edit_form.values["user_edit_firstname"][0]}">
                        <input type="text" name="user_edit_lastname" placeholder="Mustermann" value="${user_edit_form.values["user_edit_lastname"][0]}">
                    </div>

                    <label for="user_edit_email">
                        Email:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="user_edit_email" placeholder="max@mustermann.de" value="${user_edit_form.values["user_edit_email"][0]}">
                    </div>

                    <label for="user_edit_gender">
                        Geschlecht:
                        <span class="required">*</span>
                    </label>
                    <div class="geschlecht">
                        <select name="user_edit_gender" value="${user_edit_form.values["user_edit_gender"][0]}">
                            <option>männlich</option>
                            <option>weiblich</option>
                        </select>
                    </div>

                    <label for="user_edit_birthdate">
                        Geburtsdatum:
                        <span class="required">*</span>
                    </label>
                    <div class="birthdate">
                        <input type="date" name="user_edit_birthdate" placeholder="01.01.1970" value="${user_edit_form.values["user_edit_birthdate"][0]}">
                    </div>

                    <label for="user_edit_weight">
                        Gewicht (kg):
                        <span class="required">*</span>
                    </label>  
                    <div class="weight">
                        <input type="number" placeholder="60" name="user_edit_weight" value="${user_edit_form.values["user_edit_weight"][0]}"> 
                    </div>

                    <label for="user_edit_height">
                        Größe:
                        <span class="required">*</span>
                    </label>  
                    <div class="height">

                        <label for="user_edit_height" id="n1">0cm</label> 
                        <input class="vertikal" name="user_edit_height" id="user_edit_height" 
                               type="range" min="0" value="${user_edit_form.values["user_edit_height"][0]}" max="250" 
                               orient="vertical" placeholder="167">
                        <label for="user_edit_height" id="n2">250cm</label>
                        <output name="x" for="user_edit_height">${user_edit_form.values["user_edit_height"][0]}</output>

                    </div>




                    <%-- Button zum Abschicken --%>
                    <div class="side-by-side" style="padding-top: 20px">
                        <button class="icon-pencil" type="submit">
                            Benutzerdaten ändern
                        </button>
                        <button class="icon-pencil" type="button">
                            Benutzer löschen
                            
                        </button>
                    </div>
                </div>

                <%-- Fehlermeldungen --%>
                <c:if test="${!empty user_edit_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${user_edit_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </form>
        </div>
    </div>

</jsp:attribute>
</template:base>
