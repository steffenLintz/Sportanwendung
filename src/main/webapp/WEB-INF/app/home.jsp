<%-- 
    Document   : home
    Created on : 10.03.2018, 20:36:21
    Author     : Steffen Lintz
--%>

<%--
 pizza / noPizza setParameters int (100 gesamt) noPizza = 100-pizza
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
        <div class="title">Deine letzten Aktivitäten:</div>
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


                    </div>
                </a>
            </div>
        </div> 

        <div class="pizzas">
            <c:if test="${ganzepizza gt 0}">
                <div class="chart">
                    <head>
                        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                        <script type="text/javascript">
                         

                            google.charts.load('current', {'packages': ['corechart']});
                            google.charts.setOnLoadCallback(drawChart);

                            <%--    function drawChart() {
                                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                                chart.draw(data, options);
                            } --%>
                        </script>
                    </head>
                    <body>
                        <div id="piechart"></div>
                    </body>
                </div>
            </c:if>

            <div class="chart">
                <div class="number">${ganzepizza}x</div>
                <head>
                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                    <script type="text/javascript">
                            window.onresize = function () {
                                location.reload();
                            };

                            google.charts.load('current', {'packages': ['corechart']});
                            google.charts.setOnLoadCallback(drawChart);

                            function drawChart() {

                                var data = google.visualization.arrayToDataTable([
                                    ['Pizza', 'CaloriesNPizza'],
                                    ['NoPizza', ${nopizza}],
                                    ['Pizza', ${pizza}]
                                ]);

                                var options = {
                                    backgroundColor: 'transparent',
                                    pieSliceBorderColor: 'transparent',
                                    legend: 'none',
                                    pieSliceText: 'none',
                                    pieStartAngle: 20,
                                    tooltip: {trigger: 'none'},
                                    slices: {
                                        0: {color: '#8896a3'},
                                        1: {color: 'transparent'},
                                    },
                                    pieStartAngle: 270,
                                    enableInteractivity: false
                                };

                                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                                chart.draw(data, options);
                            }
                    </script>
                </head>
                <body>
                    <div id="piechart"></div>
                </body>
            </div>
        </div>
    </jsp:attribute>
</template:base>