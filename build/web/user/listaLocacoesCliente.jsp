<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todas Locações</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Locações</h1>
        <hr>
        <c:if test="${empty requestScope.listaLocacoes}">
            Não há locacçes!
        </c:if>
        <c:if test="${!empty requestScope.listaLocacoes}">
            <table>
                <tr>
                    <th>Data</th>
                    <th>CNPJ da Locadora</th>
                </tr>
                <c:forEach items="${requestScope.listaLocacoes}" var="locacao">
                    <tr>
                        <td>${locacao.data}</td> 
                        <td>${locacao.cnpj_locadora}</td>
<!--                        
                        <td><a href="deletaLocadora?id=<c:out value='${locadora.id}' />">Deletar</a></td>
                        <td><a href="editaLocadora?id=<c:out value='${locadora.id}' />">Modificar</a></td>-->
                        
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <br>
            <a href="adicionaLocacao?cpf=<c:out value='${cpf}'/>">Criar Nova Locacao</a>
    </body>
</html>