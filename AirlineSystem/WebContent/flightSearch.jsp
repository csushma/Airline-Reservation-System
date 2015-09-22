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
<title>Flight Search</title>
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
<h2>Flight Search</h2>
<font color="Black">
<h:form>
<h3>Please enter the Departure and Arrival Airport Code</h3>
<h:panelGrid columns="1" styleClass="panelGridCenter">
<h:outputLabel value="Departure Airport Code" styleClass="outputLabel"></h:outputLabel>
<h:inputText value="#{FlightSearchMB.dep_airport_code}" styleClass="inputText"></h:inputText><br />
<h:outputLabel value="Arrival Airport Code" styleClass="outputLabel"></h:outputLabel>
<h:inputText value="#{FlightSearchMB.arr_airport_code}" styleClass="inputText"></h:inputText><br />
<h:outputLabel value="Number of stops" styleClass="outputLabel"></h:outputLabel>
<h:selectOneMenu value="#{FlightSearchMB.noStops}" styleClass="inputText">
   	<f:selectItem itemValue="0" itemLabel="Non Stop" />
   	<f:selectItem itemValue="1" itemLabel="Single Stop" />
   	<f:selectItem itemValue="2" itemLabel="Two Stops"/>
</h:selectOneMenu><br />
<h:commandButton value="Search" action="#{FlightSearchMB.flightSearch}"></h:commandButton>
<h:commandButton value = "Go to home Page" action="startPage.jsp"></h:commandButton>
</h:panelGrid><br />
<c:if test="${FlightSearchMB.flightList!=null}">
<h4>Direct Flight Details </h4>
<div style="height: 200px; overflow: auto" align="center">
<h:dataTable value="#{FlightSearchMB.flightList}" var="flightList" border="1" styleClass="TABLE" >
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Flight Number"></h:outputText>
         </f:facet>
         <h:outputText value="#{flightList.flight_number}"></h:outputText>    				
         </h:column>
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Airline"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.airline}"></h:outputText> 
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Weekdays"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.weekdays}"></h:outputText>
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Departure airport code"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.dep_airport_code}"></h:outputText>
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Scheduled Departure Time"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.sch_dep_time}"></h:outputText>
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Arrival Airport Code"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.arr_airport_code}"></h:outputText>
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Scheduled Arrival Time"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{flightList.sch_arr_time}"></h:outputText>
         </h:column>
</h:dataTable>
</div>
</c:if>
<c:if test="${FlightSearchMB.flightList1!=null}">
<h4>Flights with One Stop</h4>
<div style="height: 200px; overflow: auto">
<h:dataTable value="#{FlightSearchMB.flightList1}" var='flightList1' border="1" styleClass="TABLE">
			<h:column>
			<f:facet name="header">
			<h:outputText value="Flight Number"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList1.flightNumber}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Airline"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList1.airline}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Departure Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.dep_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Scheduled Departure Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.dep_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Level 1 Arrival Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.level1_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Level 1 Scheduled Arrival Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.arr1_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Connecting Flight Number"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList1.flight_Number1}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="CF Scheduled Departure Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.dep1_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Arrival Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.arr_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="CF Scheduled Arrival Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.arr_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="WeekDays"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList1.weekDays}"></h:outputText>
			</h:column>
</h:dataTable>
</div>
</c:if>
<c:if test="${FlightSearchMB.flightList2!=null}">
<h4>Flights with Two Stops</h4>
<div style="height: 200px; overflow: auto">
<h:dataTable value="#{FlightSearchMB.flightList2}" var='flightList2' border="1" styleClass="TABLE">
			<h:column>
			<f:facet name="header">
			<h:outputText value="Flight Number"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList2.flightNumber}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Airline"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList2.airline}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Departure Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.dep_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Scheduled Departure Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.dep_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Level 1 Arrival Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.level1_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Level 1 Scheduled Arrival Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.arr1_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Connecting Flight Number1"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList2.flightNumber1}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Scheduled FLight1 Departure Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.dep1_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Level 2 Arrival Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.level2_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Level 2 Scheduled Arrival Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.arr2_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Connecting Flight Number2"></h:outputText>
			</f:facet>	
			<h:outputText value="#{flightList2.flightNumber2}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Scheduled Flight 2 Departure Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.dep2_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Arrival Airport"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.arr_Airport}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="Scheduled Arrival Time"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.arr_Time}"></h:outputText>
			</h:column>
			<h:column>
			<f:facet name="header">
			<h:outputText value="WeekDays"></h:outputText>
			</f:facet>
			<h:outputText value="#{flightList2.weekDays}"></h:outputText>
			</h:column>
</h:dataTable>
</div>
</c:if>
<h:outputText value="#{FlightSearchMB.message}" style="color: Red; " styleClass="panelGridCenter"></h:outputText>
</h:form>
</font>
</f:view>
</body>
</html>