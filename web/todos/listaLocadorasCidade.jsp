<%-- 
    Document   : listaLocadorasCidade.jsp
    Created on : 01/06/2019, 11:22:30
    Author     : Theo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="city.rental.store.title"/></title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1><f:message key="city.rental.store.main.label"/></h1>
        <hr>
        <c:if test="${empty requestScope.listaLocadoras}">
            <f:message key="city.rental.store.test1.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaLocadoras}">
            <ul>
                <c:forEach items="${requestScope.listaLocadoras}" var="locadora">
                    <a class="myButtonEdit" onclick="criarTabela()"><li>${locadora.cidade}</li></a>
                </c:forEach>
            </ul>
        </c:if>
       <h2><f:message key="city.rental.store.second.main.label"/></h2>
        <hr>
        <c:if test="${empty requestScope.listaLocadoras}">
            <f:message key="all.rental.store.test1.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaLocadoras}">
            <table id="Locadoras">
                <tr>
                    <th><f:message key="all.rental.store.test2.email.label"/></th>
                    <th><f:message key="all.rental.store.test2.name.label"/></th>
                </tr>
                <c:forEach items="${requestScope.listaLocadoras}" var="locadora">
                    <tr>
                        <td>${locadora.email}</td> 
                        <td>${locadora.nome}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <script>
        function criarTabela() {
                document.getElementById("Locadoras").classList.toggle("show");
                
        }
        </script>
        
    </body>
</html>
</f:bundle>