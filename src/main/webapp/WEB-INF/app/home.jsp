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
        Hallo ${pageContext.request.getAttribute(Vorname)}
    </jsp:attribute>
</template:base>

<c:forEach items="${activities}" var="activity">
          <div class="activitytile">
              <img src=${activity.sporttype.picture}/>
     
              <div class="footer">
                  <div class="name">${activity.sporttype.name}</div>
                  <div class="calories">${activity.calories}</div>
              </div>
          </div>
</c:forEach>
          <div class="activitytile">
              <img src="src/main/pictures/plus.png"/>
     
              <div class="footer">
                  <div class="name">Aktivität hinzufügen</div>
              </div>
          </div>