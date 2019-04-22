<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos Usuários</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Clientes</h1>
        <hr>
        <c:if test="${empty requestScope.listaClientes}">
            Não há apostas!
        </c:if>
        <c:if test="${!empty requestScope.listaClientes}">
            <table>
                <tr>
                    <th>Usuário</th>
                    <th>Nome</th>
                </tr>
                <c:forEach items="${requestScope.listaClientes}" var="cliente">
                    <tr>
                        <td>${cliente.email}</td>
                        <td>${cliente.nome}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>