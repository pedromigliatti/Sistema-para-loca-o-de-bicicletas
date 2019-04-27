<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
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
            <table>
                <tr>
                    <th>Email</th>
                    <th>Nome</th>
                    <th>Cidade</th>
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