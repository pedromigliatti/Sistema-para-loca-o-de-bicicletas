<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="show.renting.store.title"/></title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1><f:message key="show.renting.store.label"/></h1>
        <hr>
        <c:if test="${empty requestScope.listaLocacoes}">
            <f:message key="show.renting.store.test.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaLocacoes}">
            <table>
                <tr>
                    <th><f:message key="show.renting.store.info1.label"/></th>
                    <th><f:message key="show.renting.store.info2.label"/></th>
                </tr>
                <c:forEach items="${requestScope.listaLocacoes}" var="locacao">
                    <tr>
                        <td>${locacao.dataHora}</td> 
                        <td>${locacao.cpfclienteId.getCpf()}</td>                      
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
</f:bundle>