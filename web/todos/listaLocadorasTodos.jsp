<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="all.rental.store.title"/></title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1><f:message key="all.rental.store.main.label"/></h1>
        <hr>
        <c:if test="${empty requestScope.listaLocadoras}">
            <f:message key="all.rental.store.test1.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaLocadoras}">
            <table>
                <tr>
                    <th><f:message key="all.rental.store.test2.label"/></th>
                    <th><f:message key="all.rental.store.test13.label"/></th>
                    <th><f:message key="all.rental.store.test4.label"/></th>
                </tr>
                <c:forEach items="${requestScope.listaLocadoras}" var="locadora">
                    <tr>
                        <td>${locadora.email}</td> 
                        <td>${locadora.nome}</td>
                        <td>${locadora.cidade}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/">Voltar</a>
    </body>
</html>
</f:bundle>