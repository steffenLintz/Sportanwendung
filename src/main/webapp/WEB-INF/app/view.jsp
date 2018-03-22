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
            <h3>Uhrzeit</h3>
            <div>
                <input type="time" disabled="true" value=${atime}>
            </div>
            <h3>Dauer</h3>
            <div>${activity.duration} Minuten</div>


            <h3><div id="distance">${title}</div> </h3>
            <div>${activity.distance}</div>

            <h3>Sportart</h3>
            <div id="sportname">${activity.sporttype.name}</div>


            <label for="activity_rating">
                Wie war die Aktivität für dich?   Wie hast du dich gefühlt?
            </label>  




            <form method="post">
                <div class="stars" style="width: 150px; ">

                    <input type="radio" name="star" class="star-1" id="star-1" ${star1}  value="1" readonly="readonly"/>
                    <label class="star-1" for="star-1">1</label>
                    <input type="radio" name="star" class="star-2" id="star-2" ${star2}  value="2" readonly="readonly"/>
                    <label class="star-2" for="star-2">2</label>
                    <input type="radio" name="star" class="star-3" id="star-3" ${star3}  value="3" readonly="readonly"/>
                    <label class="star-3" for="star-3">3</label>
                    <input type="radio" name="star" class="star-4" id="star-4" ${star4}  value="4" readonly="readonly"/>
                    <label class="star-4" for="star-4">4</label>
                    <input type="radio" name="star" class="star-5" id="star-5" ${star5}  value="5" readonly="readonly"/>
                    <label class="star-5" for="star-5">5</label>
                    <span></span>
                </div> 


                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <button id="delete" type="submit">Diese Aktivität löschen</button>
            </form>
        </div>

    </jsp:attribute>
</template:base>