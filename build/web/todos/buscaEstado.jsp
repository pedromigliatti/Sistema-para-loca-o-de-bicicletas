<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Selecione o estado e cidade da locadora</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        
        <script src="js/ajax.js"></script>
         
    </head>
    <body>
        <br/>
        <jsp:useBean id='bean' class='br.ufscar.dc.dsw.bean.DynamicSelectBean'/>
       
        <form name='form'>
            <table>
                <tr>
                    <td>Estado</td>
                    <td>
                        <select id = 'estado' name='estado' onchange='estadoSelecionado(this.value)'>
                            <option value='--'>--</option>
                            <c:forEach items='${bean.estados}' var='estado'>
                                <option value='${estado.sigla}'>${estado.sigla}</option>
                            </c:forEach>
                        </select>   
                    </td>
                </tr>
                <tr id='cidades'>    
                    <td>
                        Cidade
                    </td>
                    <td>
                        <select id='cidade' name='cidade' onchange='apresentaDS()'>
                        </select>
                    </td>   
                </tr>
            </table>
        </form>
        <br/>
       <a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/">Voltar</a>
    </body>
</html>