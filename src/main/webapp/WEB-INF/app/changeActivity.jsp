<%-- 
    Document   : changeActivity
    Created on : 21.03.2018, 14:54:01
    Author     : z003ne3b
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<template:base>
    <jsp:attribute name="title">
        Aktivität bearbeiten
    </jsp:attribute>
    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">

        <div id="container">
            <form method="post" class="stacked" oninput="activity_edit_calories.value=parseInt(user_edit_height.value)">
                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <h1>Aktivität bearbeiten</h1>

                <label for="activity_edit_date">
                    <h3>Datum
                        <span class="required">*</span>
                    </h3>
                </label>  
                <div class="weight">
                    <input type="date"  name="activity_edit_date" value=${adate}> 
                </div>

                <label for="activity_edit_time">
                    <h3>Uhrzeit
                        <span class="required">*</span>
                    </h3>
                </label>  
                <div class="weight">
                    <input type="time"  name="activity_edit_time" value=${atime}> 
                </div>

                <label for="activity_edit_duration">
                    <h3>Dauer
                        <span class="required">*</span>
                    </h3>
                </label>  
                <div class="weight">
                    <input onchange="calculate()"  id="duration" type="number"  name="activity_edit_duration" value="${changeActivity.values["activity_edit_duration"][0]}"> 
                </div>

                <label for="activity_edit_distance">
                    <h3><div id="distance">${title}<span class='required'>*</span></div>

                    </h3>
                </label>  
                <div class="weight">
                    <input type="number"  name="activity_edit_distance" value="${changeActivity.values["activity_edit_distance"][0]}"> 
                </div>




                <label for="activity_edit_sporttype">
                    <h3>Sportart
                        <span class="required">*</span>
                    </h3>
                </label>  
                <div class="weight">
                    <select  id="Typeselector" name="activity_edit_sporttype" value="${changeActivity.values["activity_edit_sporttype"][0]}">
                        <option ${sporttype1} value="Fußball" >Fußball</option>
                        <option ${sporttype2} value="Tennis">Tennis</option>
                        <option ${sporttype3} value="Schwimmen">Schwimmen</option>
                        <option ${sporttype4} value="Fahrrad">Fahrrad</option>
                        <option ${sporttype5} value="Laufen">Laufen</option>
                        <option ${sporttype6} value="Kraftsport">Kraftsport</option>
                    </select> 
                    <script type="text/javascript">
                        var selector = document.getElementById('Typeselector');
                        selector.onchange = function () {
                            var show = document.getElementById('distance');
                            if (this.value === "Kraftsport") {
                                show.innerHTML = "Anzahl Wiederholungen <span class='required'>*</span>";
                            } else {
                                show.innerHTML = "Zurückgelegte Distanz in km <span class='required'>*</span>";
                            }
                        };
                    </script>
                </div>
                <label for="activity_rating">
                    Wie war die Aktivität für dich?   Wie hast du dich gefühlt?
                </label>  

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




                <button id="delete"  type="submit">Speichern</button>
            </form>

            <c:if test="${!empty user_edit_form.errors}">
                <ul class="errors">
                    <c:forEach items="${user_edit_form.errors}" var="error">
                        <li>${error}</li>
                        </c:forEach>
                </ul>
            </c:if>

        </div>



    </jsp:attribute>
</template:base>