<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airline Reservation System</title>
<link href="../stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class = "imageattr">
	<img src="flight.gif" alt="flight" />
</div>
<f:view>
<h:form>
<div class="welcome">
	Welcome to Airline Reservation System
</div>
<br />
<h:panelGrid columns="1"  border="0"  styleClass="panelGridCenter">
<h:commandButton action ="flightSearch.jsp" value="Flight Information" disabled="false" styleClass="commandCenter"></h:commandButton>
<h:commandButton action ="seatAvailability.jsp" value="Seat Availability" disabled="false" styleClass="commandCenter"> </h:commandButton>
<h:commandButton action ="fareSearch.jsp" value="Flight Fare" disabled="false" styleClass="commandCenter"></h:commandButton>
<h:commandButton action ="passenger_Info.jsp" value="Passenger Information" disabled="false" styleClass="commandCenter"></h:commandButton>
<h:commandButton action ="passenger_flight.jsp" value="Passenger Flight" disabled="false" styleClass="commandCenter"></h:commandButton>
</h:panelGrid>
</h:form>
</f:view>
</body>
</html>