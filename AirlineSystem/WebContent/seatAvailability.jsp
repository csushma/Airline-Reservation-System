<%@taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql_rt"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../stylesheet.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available seats</title>
</head>
<body>
<div class = "imageattr">
	<img src="flight.gif" alt="flight" />
</div>
<div class="welcome">
	Welcome to Airline Reservation System
</div>
<f:view>
<h2>Number of Available Seats</h2>
<font color="Black">
<h:form>
<h3>Please enter the Flight Number and Date</h3>
<h:panelGrid columns="2" styleClass="panelGridCenter">
<h:outputLabel value="Flight Number"></h:outputLabel>
<h:inputText value="#{AvailableSeatsMB.flight_number}" styleClass="inputText"></h:inputText>
<h:outputLabel value="Date"></h:outputLabel>
<h:inputText id="dateInput" value="#{AvailableSeatsMB.date}" styleClass="inputText" label="Date">  
   <f:convertDateTime pattern="yyyy-MM-dd"/>  
</h:inputText>
<h:commandButton value="Search" action="#{AvailableSeatsMB.seatSearch}"></h:commandButton>
<h:commandButton value = "Go to home Page" action="startPage.jsp"></h:commandButton>
</h:panelGrid><br />
<h:message for="dateInput" style="color:red" />
<c:if test="${AvailableSeatsMB.available_seats!=0}">
<h4>Available Seats Information</h4>
<div align="center">
<h:dataTable value="#{AvailableSeatsMB.available_seats}" border="1" styleClass="TABLE">
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Number of available seats"></h:outputText>
         </f:facet>
         <h:outputText value="#{AvailableSeatsMB.available_seats}"></h:outputText>    				
         </h:column>
</h:dataTable>
</div>
</c:if>
<h:outputText value="#{AvailableSeatsMB.message}" style="color: Red; " styleClass="panelGridCenter"></h:outputText>
</h:form>
</font>
</f:view>
</body>
</html>