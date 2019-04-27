<%-- 
    Document   : index
    Created on : 22/04/2019, 10:21:40
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Bem Vindo!</h1>
        <br>
        <div align="center">
        <a  class="myButton" href="adminIndex.jsp">Cadastros</a>
        <br>
        <br>
        <a class="myButton" href="todos/buscaEstado.jsp">Locadoras por Cidade</a>
        <br>
        <br>
        <a class="myButton" href="todos/verLocadorasTodos">Lista de todas as Locadoras</a>
        </div>
    </body>
</html>
