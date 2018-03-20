<%-- 
    Document   : deleteUser.jsp
    Created on : 20.03.2018, 21:17:39
    Author     : z003ne3b
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<template:base>
    <jsp:attribute name="title">
        Details
    </jsp:attribute>
    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">


        <h1>Soll der Benutzer wirklich gelöscht werden?</h1>

        Alle Nutzerdaten gehen dabei verloren.
    </div>
    <form method="post">
        <input type="hidden" name="csrf_token" value="${csrf_token}">

        <button id="delete" type="submit">Fortfahren</button>
    </form>

</jsp:attribute>
</template:base>