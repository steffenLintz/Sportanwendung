<%-- 
    Document   : createNew
    Created on : 14.03.2018, 07:20:21
    Author     : Steffen Lintz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script>
    function getSelectedIndex(value)
    {
        if (value === "Kraftsport")
            document.getElementById('distance').value = "Wiederholungen";
        else
            document.getElementById('distance').value = "Distanz";
    }
</script>

<template:base>

    <jsp:attribute name="title">
        Neue Aktivität anlegen
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
        <div class="container">
            <form method="post" class="stacked">

                <div class="column">
                    <input type="hidden" name="csrf_token" value="${csrf_token}">

                    <h1>Neue Aktivität anlegen</h1>

                    <label for="activity_sporttype">
                        Sportart:
                        <span class="required">*</span>
                    </label>
                    <div>
                        <select name="activity_sporttype" onselect="getSelectedIndex(value)" value="${createNew_form.values["activity_sporttype"][0]}">
                            <option>Fußball</option>
                            <option>Tennis</option>
                            <option>Schwimmen</option>
                            <option>Fahrrad</option>
                            <option>Laufen</option>
                            <option>Kraftsport</option>
                        </select>
                    </div>

                    <label for="activity_duration">
                        Dauer der sportlichen Aktivität in Minuten:
                        <span class="required">*</span>
                    </label>
                    <div>
                        <input type="number" name="activity_duration" placeholder="0" value="${createNew_form.values["activity_duration"][0]}">
                    </div>
                    <label id="distance" for="activity_distance">

                        <span class="required">*</span>
                    </label>
                    <div>
                        <input type="number" name="activity_distance" placeholder="0" value="${createNew_form.values["activity_distance"][0]}">
                    </div>


                    <label for="activity_date">
                        Datum:
                        <span class="required">*</span>
                    </label>
                    <div class="date">
                        <input type="date" name="activity_date" value="${createNew_form.values["activity_date"][0]}">
                    </div>

                    <label for="activity_date">
                        Uhrzeit:
                        <span class="required">*</span>
                    </label>
                    <div class="time">
                        <input type="time" name="activity_time" value="${createNew_form.values["activity_time"][0]}">
                    </div>


                    <label for="activity_rating">
                        Wie war die Aktivität für dich?   Wie hast du dich gefühlt?
                    </label>  

                    <div class="stars" style="width: 150px; ">
                        <input type="radio" name="star" class="star-1" id="star-1" />
                        <label class="star-1" for="star-1">1</label>
                        <input type="radio" name="star" class="star-2" id="star-2" />
                        <label class="star-2" for="star-2">2</label>
                        <input type="radio" name="star" class="star-3" id="star-3" />
                        <label class="star-3" for="star-3">3</label>
                        <input type="radio" name="star" class="star-4" id="star-4" />
                        <label class="star-4" for="star-4">4</label>
                        <input type="radio" name="star" class="star-5" id="star-5" />
                        <label class="star-5" for="star-5">5</label>
                        <span></span>
                    </div>


                    <%-- Button zum Abschicken --%>
                    <div class="side-by-side" style="padding-top: 20px">
                        <button class="icon-pencil" type="submit">
                            Speichern
                        </button>
                    </div>
                </div>

                <%-- Fehlermeldungen --%>
                <c:if test="${!empty createNew_form.errors}">
                    <ul class="errors">
                        <c:forEach items="${createNew_form.errors}" var="error">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </c:if>
            </form>
        </div>

    </jsp:attribute>
</template:base>