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
<title>Flight Fare</title>
</head>
<body>
<div class = "imageattr">
	<img src="flight.gif" alt="flight" />
</div>
<div class="welcome">
	Welcome to Airline Reservation System
</div>
<f:view>
<h2>Flight Fare</h2>
<font color="Black">
<h:form>
<h3>Please enter the Flight Number</h3>
<h:panelGrid columns="1" styleClass="panelGridCenter">
<h:outputLabel value="Flight Number" styleClass = "outputLabel"></h:outputLabel>
<h:inputText value="#{FareDetailsMB.flight_number}" styleClass="inputText"></h:inputText><br />
<h:commandButton value="Search" action="#{FareDetailsMB.fareSearch}"></h:commandButton>
<h:commandButton value = "Go to home Page" action="startPage.jsp"></h:commandButton>
</h:panelGrid><br />
<c:if test="${FareDetailsMB.fareList!=null}">
<h4>Flight Fare Information</h4>
<div align="center">
<h:dataTable value="#{FareDetailsMB.fareList}" var="fareList" border="1" styleClass="TABLE">
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Fare Code"></h:outputText>
         </f:facet>
         <h:outputText value="#{fareList.fareCode}"></h:outputText>    				
         </h:column>
		 <h:column>    				
         <f:facet name="header">
         <h:outputText value="Amount"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{fareList.amount}"></h:outputText> 
         </h:column>
         <h:column>
         <f:facet name="header">
         <h:outputText value="Restrictions"></h:outputText>
         </f:facet>    				
         <h:outputText value="#{fareList.restrictions}"></h:outputText>
         </h:column>
</h:dataTable>
</div>
</c:if>
<h:outputText value="#{FareDetailsMB.message}" style="color: Red; " styleClass="panelGridCenter"></h:outputText>
</h:form>
</font>
</f:view>
</body>
</html>