<%-- 
    Document   : home
    Created on : 10.03.2018, 20:36:21
    Author     : Steffen Lintz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Übersicht
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/home.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="content">
        Deine letzten Aktivitäten:
        <div class ="tiles">
            <c:forEach items="${activities}" var="activity">
                <div class="activitytile">
                    <a href="<c:url value="/app/view/${activity.id}"/>">
                    <img src=${activity.sporttype.picture}>

                    <div class="footer">
                        <div class="name">${activity.sporttype.name}</div>
                        <div class="calories">Kcal ${activity.calories}</div>
                    </div>
                </div>
            </c:forEach>
            <div class="activitytile" style="background: #ffffff5c">
                <a href="<c:url value="/app/createNew/"/>">
                    <img src="../../img/plus.png" alt=""/>
                    <div class="footer" style="bottom: 0px; text-align: center;">
                        
                        <div class="name">Hinzufügen</div>
                    </div>
                </a>
            </div>
        </div> 
    </jsp:attribute>
</template:base>