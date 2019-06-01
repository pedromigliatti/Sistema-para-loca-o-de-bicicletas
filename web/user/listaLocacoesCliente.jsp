<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="show.renting.client.title"/></title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1><f:message key="show.renting.client.label"/></h1>
        <hr>
        <c:if test="${empty requestScope.listaLocacoes}">
            <f:message key="show.renting.client.test.label"/>
        </c:if>
        <c:if test="${!empty requestScope.listaLocacoes}">
            <table>
                <tr>
                    <th><f:message key="show.renting.client.info1.label"/></th>
                    <th><f:message key="show.renting.client.info2.label"/></th>
                </tr>
                <c:forEach items="${requestScope.listaLocacoes}" var="locacao">
                    <tr>
                        <td>${locacao.dataHora}</td> 
                        <td>${locacao.cnpjlocadoraId.getCnpj()}</td>                      
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <br>
            <a href="adicionaLocacao?cpf=<c:out value='${cpf}'/>"><f:message key="show.renting.client.option1.label"/></a>
            
             <br>
           <!-- <a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/adminIndex.jsp"><f:message key="show.renting.client.option2.label"/></a>-->
            </body></body> <a class="myButtonEdit"  onclick="goBack()"><f:message key="show.renting.client.option2.label"/></a>
            
        

<script>
function goBack() {
  window.history.back();
}
</script> 
    </body>
</html>
</f:bundle>