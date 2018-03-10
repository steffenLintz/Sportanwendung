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

<template:base>
    <jsp:attribute name="title">
        Login
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/login.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/signup/"/>">Registrieren</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <form action="j_security_check" method="post" class="stacked">
                <div class="column">
                    <h1 class="loginh1">Logindaten</h1>

                    <%-- Eingabefelder h1--%>
                    <label for="j_username" class="logintext">
                        Benutzername:
                        <span class="required">*</span>
                    </label>
                    <input type="text" name="j_username">

                    <label for="j_password" class="logintext">
                        Passwort:
                        <span class="required">*</span>
                    </label>
                    <input type="password" name="j_password">

                    <%-- Button zum Abschicken --%>
                    <button class="icon-login" type="submit" id="loginbutton">
                        Einloggen
                    </button>
                </div>
            </form>
        </div>
    </jsp:attribute>
</template:base>