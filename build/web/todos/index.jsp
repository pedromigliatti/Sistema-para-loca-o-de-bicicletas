<%-- 
    Document   : index
    Created on : 22/04/2019, 10:21:40
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html>
    <style>
        .myButton {
	background-color:#005eff;
	-moz-border-radius:28px;
	-webkit-border-radius:28px;
	border-radius:28px;
	border:1px solid #005eff;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:14px;
	padding:10px 20px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}

.myButton:hover {
	background-color:#ff0000;
}
.myButton:active {
	position:relative;
	top:1px;
}
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title"/></title>
    </head>
    <body>
        <h1 align="center"><f:message key="welcome.label"/></h1>
        <br>
        <div align="center">
        <a  class="myButton" href="adminIndex.jsp"><f:message key="welcome.label"/></a>
        <br>
      
        <br>
        <a class="myButton" href="todos/verLocadorasTodos"><f:message key="rental.store.label"/></a>
        <br>
        
        <br> 
        <a class="myButton" href="todos/verLocadorasCidade"><f:message key="rental.store.by.city.label"/></a>
        </div>
    </body>
</html>
</f:bundle>