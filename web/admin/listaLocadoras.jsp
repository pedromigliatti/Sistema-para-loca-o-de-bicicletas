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
        <title><f:message key="show.rental.store.title"/></title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1><f:message key="show.rental.store.label"/></h1>
        <hr>
        <c:if test="${empty requestScope.listaLocadoras}">
            <f:message key="show.rental.store.test.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaLocadoras}">
            <table border="1px">
                <tr>
                    <th><f:message key="show.rental.store.info1.label"/></th>
                    <th><f:message key="show.rental.store.info2.label"/></th>
                    <th><f:message key="show.rental.store.info3.label"/></th>
                    <th><f:message key="show.rental.store.info4.label"/></th>
                </tr>
                <c:forEach items="${requestScope.listaLocadoras}" var="locadora">
                    <tr>
                        <td>${locadora.email}</td> 
                        <td>${locadora.nome}</td>
                        <td>${locadora.cnpj}</td>
                        <td>${locadora.cidade}</td>
                        <sec:authorize access="hasRole('ADMIN')">
                        <td><a class="myButtonDelete" href="deletaLocadora?id=<c:out value='${locadora.id}' />"><f:message key="show.rental.store.option1.label"/></a></td>
                        <td><a class="myButtonEdit" href="editaLocadora?id=<c:out value='${locadora.id}' />"><f:message key="show.rental.store.option2.label"/></a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <br>
            <br>
            <a class="myButtonEdit" href="novaLocadora.jsp"><f:message key="show.rental.store.option3.label"/></a>
            <br>
            <br>
           <!-- <a class="myButtonEdit" href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/adminIndex.jsp"><f:message key="show.rental.store.option4.label"/></a>-->
            
            <a class="myButtonEdit"  onclick="goBack()"><f:message key="show.rental.store.option4.label"/></a>
            
        

<script>
function goBack() {
  window.history.back();
}
</script> 
    </body>
</html>
</f:bundle>