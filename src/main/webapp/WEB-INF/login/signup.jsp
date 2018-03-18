<%-- 
    Copyright © 2018 Dennis Schulmeister-Zimolong

    E-Mail: dhbw@windows3.de
    Webseite: https://www.wpvs.de/

    Dieser Quellcode ist lizenziert unter einer
    Creative Commons Namensnennung 4.0 International Lizenz.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="base_url" value="<%=request.getContextPath()%>" />

<template:base>
    <jsp:attribute name="title">
        Registrierung
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/logout/"/>">Einloggen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <form method="post" class="stacked" oninput="x.value=parseInt(signup_height.value)">

                <%-- Benutzerdaten --%>

                <div class="column">
                    <%-- CSRF-Token --%>
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <h1>Logindaten</h1>

                    <label for="signup_username">
                        Benutzername:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="signup_username" placeholder="Benutzername eingeben" value="${signup_form.values["signup_username"][0]}">
                    </div>

                    <label for="signup_password1">
                        Passwort:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="signup_password1" placeholder="Passwort eingeben" value="${signup_form.values["signup_password1"][0]}">
                    </div>

                    <label for="signup_password2">
                        Passwort (wdh.):
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="password" name="signup_password2" placeholder="Passwort wdh." value="${signup_form.values["signup_password2"][0]}">
                    </div>

                    <label for="signup_email">
                        Email:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="signup_email" placeholder="max@mustermann.de" value="${signup_form.values["signup_email"][0]}">
                    </div>

                    <%-- Persönliche Daten --%>
                    <h1>Persönliche Daten</h1>

                    <label for="signup_realname">
                        Vor- und Nachname:
                        <span class="required">*</span>
                    </label>
                    <div class="side-by-side">
                        <input type="text" name="signup_firstname" placeholder="Max" value="${signup_form.values["signup_firstname"][0]}">
                        <input type="text" name="signup_lastname" placeholder="Mustermann" value="${signup_form.values["signup_lastname"][0]}">
                    </div>

                    <label for="signup_gender">
                        Geschlecht:
                        <span class="required">*</span>
                    </label>
                    <div class="geschlecht">
                        <select name="signup_gender" value="${signup_form.values["signup_gender"][0]}">
                            <option>männlich</option>
                            <option>weiblich</option>
                        </select>
                    </div>

                    <label for="signup_birthdate">
                        Geburtsdatum:
                        <span class="required">*</span>
                    </label>
                    <div class="birthdate">
                        <input type="date" name="signup_birthdate" placeholder="01.01.1970" value="${signup_form.values["signup_birthdate"][0]}">
                    </div>

                    <label for="signup_weight">
                        Gewicht (kg):
                        <span class="required">*</span>
                    </label>  
                    <div class="weight">
                        <input type="number" placeholder="60" name="signup_weight" value="${signup_form.values["signup_weight"][0]}"> 
                    </div>

                    <label for="signup_height">
                        Größe:
                        <span class="required">*</span>
                    </label>  
                    <div class="height">

                        <label for="signup_height" id="n1">0cm</label> 
                        <input class="vertikal" name="signup_height" id="signup_height" 
                               type="range" min="0" value=""${signup_form.values["signup_height"][0]}" max="250" 
                               orient="vertical" placeholder="167">
                        <label for="signup_height" id="n2">250cm</label>
                        <output name="x" for="signup_height">167</output>

                    </div>




                    <%-- Button zum Abschicken --%>
                    <div class="side-by-side" style="padding-top: 20px">
                        <button class="icon-pencil" type="submit">
                            Registrieren
                        </button>
                    </div>
                </div>

                <%-- Fehlermeldungen --%>
                <c:if test="${!empty signup_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${signup_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </form>
        </div>
    </jsp:attribute>
</template:base>