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
<link href="../stylesheet.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger Information</title>
</head>
<body>
<div class = "imageattr">
	<img src="flight.gif" alt="flight" />
</div>
<div class="welcome">
	Welcome to Airline Reservation System
</div>
<f:view>
<h2>Passenger Information</h2>
<font color="Black">
<h:form>
<h3>Please enter the Flight Number and Date</h3>
<h:panelGrid columns="2" styleClass="panelGridCenter">
<h:outputLabel value="Flight Number" style="font-size: medium"></h:outputLabel>
<h:inputText value="#{PassengersInfoMB.flight_number}" styleClass="inputText"></h:inputText>
<h:outputLabel value="Date" style="font-size: medium"></h:outputLabel>
<h:inputText id="dateInput" value="#{PassengersInfoMB.date}" label="Date" styleClass="inputText">  
   <f:convertDateTime pattern="yyyy-MM-dd"/>  
</h:inputText>
<h:commandButton value="Search" action="#{PassengersInfoMB.passSearch}"></h:commandButton>
<h:commandButton value = "Go to home Page" action="startPage.jsp"></h:commandButton>
</h:panelGrid><br />
<h:message for="dateInput" style="color:red" />
<c:if test="${PassengersInfoMB.passList!=null}">
<h4>Customer Details</h4>
<div align="center">
<h:dataTable value="#{PassengersInfoMB.passList}" var="passList" border="1" styleClass="TABLE">
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Seat_number"></h:outputText>
         </f:facet>
         <h:outputText value="#{passList.seat_number}"></h:outputText>    				
         </h:column>
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Customer_name"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{passList.customer_name}"></h:outputText> 
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Customer_phone"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{passList.customer_phone}"></h:outputText>
         </h:column>
</h:dataTable>
</div>
</c:if>
<h:outputText value="#{PassengersInfoMB.message}" style="color: Red; " styleClass="panelGridCenter"></h:outputText>
</h:form>
</font>
</f:view>
</body>
</html>