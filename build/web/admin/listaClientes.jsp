<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <style>
            .myButtonDelete {
	background-color:#ff0000;
	-moz-border-radius:28px;
	-webkit-border-radius:28px;
	border-radius:28px;
	border:1px solid #ff0000;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:14px;
	padding:10px 20px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
.myButtonEdit {
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="show.client.title"/></title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1><f:message key="show.client.label"/></h1>
        <hr>
        <c:if test="${empty requestScope.listaClientes}">
            <f:message key="show.client.test.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaClientes}">
            <table border="1px">
                <tr>
                    <th><f:message key="show.client.info1.label"/></th>
                    <th><f:message key="show.client.info2.label"/></th>
                    <th><f:message key="show.client.info3.label"/></th>
                    <th><f:message key="show.client.info4.label"/></th>
                    <th><f:message key="show.client.info5.label"/></th>
                </tr>
                <c:forEach items="${requestScope.listaClientes}" var="cliente">
                    <tr>
                        <td>${cliente.email}</td> 
                        <td>${cliente.nome}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.nascimento}</td>
                        
                        <td><a class="myButtonDelete" href="deletaCliente?id=<c:out value='${cliente.id}' />"><f:message key="show.client.option1.label"/></a></td>
                        <td><a class="myButtonEdit" href="editaCliente?id=<c:out value='${cliente.id}' />"><f:message key="show.client.option2.label"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <br>
            <a class="myButtonEdit" href="adicionaCliente"><f:message key="show.client.option3.label"/></a>
            <br>
            <br>
            <a class="myButtonEdit" href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/adminIndex.jsp"><f:message key="show.client.option4.label"/></a>
    </body>
</html>
</f:bundle>