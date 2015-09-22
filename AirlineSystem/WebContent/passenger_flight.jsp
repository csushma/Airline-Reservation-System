<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passengers FlightS</title>
<link href="../stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class = "imageattr">
	<img src="flight.gif" alt="flight" />
</div>
<div class="welcome">
	Welcome to Airline Reservation System
</div>
<f:view>
<h2>Passenger FLIGHTS</h2>
<font color="Black">
<h:form>
<h3>Please enter the Passenger Name</h3>
<h:panelGrid columns="2" styleClass="panelGridCenter">
<h:outputLabel value="Passenger name" style="font-size: medium"></h:outputLabel>
<h:inputText value="#{PassengerFlightMB.customer_name}" styleClass="inputText"></h:inputText>
<h:commandButton value="Search" action="#{PassengerFlightMB.flightSearch}"></h:commandButton>
<h:commandButton value = "Go to home Page" action="startPage.jsp"></h:commandButton>
</h:panelGrid><br />
<c:if test="${PassengerFlightMB.flightList!=null}">
<h4>Flights Traveled by Passenger</h4>
<div align="center">
<h:dataTable value="#{PassengerFlightMB.flightList}" var="flightList" border="1" styleClass="TABLE" >
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Flight_number"></h:outputText>
         </f:facet>
         <h:outputText value="#{flightList.flight_number}"></h:outputText>    				
         </h:column>
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Date"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.date}"></h:outputText> 
         </h:column>
          <h:column>    				
         <f:facet name="header">
         <h:outputText value="Seat_number"></h:outputText>
         </f:facet>
         <h:outputText value="#{flightList.seat_number}"></h:outputText>    				
         </h:column>
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Customer_name"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.customer_name}"></h:outputText> 
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Customer_phone"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.customer_phone}"></h:outputText>
         </h:column>
</h:dataTable>
</div>
</c:if>
<h:outputText value="#{PassengerFlightMB.message}" style="color: Red; " styleClass="panelGridCenter"></h:outputText>
</h:form>
</font>
</f:view>
</body>
</html>