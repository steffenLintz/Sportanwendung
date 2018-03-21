<%-- 
    Document   : view
    Created on : 14.03.2018, 22:50:03
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

        <div id="container">

            <h1>Details</h1>

            <button id="bearbeiten" onclick="document.location.href = this.getAttribute('href');" href="/sportanwendung/app/changeActivity/${activity.id}"> Aktivität Bearbeiten</button>

            <h3>Verbrannte Kalorien</h3>
            <img id="sportpicture" src=${activity.sporttype.picture}>
            <div>${activity.calories} kcal</div>

            <h3>Datum</h3>
            <div>
                <input type="date" disabled="true" value=${adate}>
            </div>
            <h3>Dauer</h3>
            <div>${activity.duration} Minuten</div>
            

            <h3><div id="distance">${title}</div> </h3>
            <div>${activity.distance}</div>

            <h3>Sportart</h3>
            <div id="sportname">${activity.sporttype.name}</div>


        </div>
        <form method="post">
            <input type="hidden" name="csrf_token" value="${csrf_token}">

            <button id="delete" type="submit">Diese Aktivität löschen</button>
        </form>

    </jsp:attribute>
</template:base>