<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Todas Locadoras</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Locadoras</h1>
        <hr>
        <c:if test="${empty requestScope.listaLocadoras}">
            Não há locadoras!
        </c:if>
        <c:if test="${!empty requestScope.listaLocadoras}">
            <table border="1px">
                <tr>
                    <th>Email</th>
                    <th>Nome</th>
                    <th>CNPJ</th>
                    <th>Cidade</th>
                </tr>
                <c:forEach items="${requestScope.listaLocadoras}" var="locadora">
                    <tr>
                        <td>${locadora.email}</td> 
                        <td>${locadora.nome}</td>
                        <td>${locadora.cnpj}</td>
                        <td>${locadora.cidade}</td>
                        <sec:authorize access="hasRole('ADMIN')">
                        <td><a class="myButtonDelete" href="deletaLocadora?id=<c:out value='${locadora.id}' />">Deletar</a></td>
                        <td><a class="myButtonEdit" href="editaLocadora?id=<c:out value='${locadora.id}' />">Modificar</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <br>
            <br>
            <a class="myButtonEdit" href="novaLocadora.jsp">Criar Nova Locadora</a>
            <br>
            <br>
            <a class="myButtonEdit" href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/adminIndex.jsp">Voltar</a>
    </body>
</html>