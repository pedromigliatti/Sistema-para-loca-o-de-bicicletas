<%-- 
    Document   : cadastroCliente
    Created on : 22/04/2019, 00:23:34
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="edit.client.title"/></title>
    </head>
    <body>
        <sec:authorize access="hasRole('ADMIN')">
                <form action="atualizaCliente">
            <fieldset>

                <!-- Form Name -->
                <legend><f:message key="edit.client.legend.label"/></legend>
                
                <c:if test="${cliente != null}">
                    <div class="form-group">
                    <label class="col-md-4 control-label" for="id"><f:message key="edit.client.info1.label"/></label>  
                    <div class="col-md-4">
                        <input id="id" name="id" type="hidden" placeholder="ID" class="form-control input-md" required="" value="${cliente.id}">

                    </div>
                </div>
                </c:if>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nome"><f:message key="edit.client.info2.label"/></label>  
                    <div class="col-md-4">
                        <input id="nome" name="nome" type="text" placeholder="Nome" class="form-control input-md" required="" value="${cliente.nome}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email"><f:message key="edit.client.info3.label"/></label>  
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required=""value="${cliente.email}">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="senha"><f:message key="edit.client.info4.label"/></label>
                    <div class="col-md-4">
                        <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md" required="" value="${cliente.senha}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cpf"><f:message key="edit.client.info5.label"/></label>  
                    <div class="col-md-4">
                        <input id="cpf" name="cpf" type="text" placeholder="CPF" class="form-control input-md" required="" value="${cliente.cpf}">

                    </div>
                </div>

                <!-- Multiple Radios -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="sexo"><f:message key="edit.client.info6.label"/></label>
                    <div class="col-md-4">
                        <div class="radio">
                            <label for="sexo-0">
                                <input type="radio" name="sexo" id="sexo-0" value="M" checked="checked">
                                <f:message key="edit.client.info6.option1.label"/>
                            </label>
                        </div>
                        <div class="radio">
                            <label for="sexo-1">
                                <input type="radio" name="sexo" id="sexo-1" value="F">
                                <f:message key="edit.client.info6.option2.label"/>
                            </label>
                        </div>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="telefone"><f:message key="edit.client.info7.label"/></label>  
                    <div class="col-md-4">
                        <input id="telefone" name="telefone" type="text" placeholder="Telefone" class="form-control input-md" value="${cliente.telefone}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nascimento"><f:message key="edit.client.info8.label"/></label>  
                    <div class="col-md-4">
                        <input id="nascimento" name="nascimento" type="date" placeholder="Nascimento" class="form-control input-md" required="" value="${cliente.nascimento}">

                    </div>
                </div>
                <br>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" type="submit" name="submit" class="btn btn-primary"><f:message key="edit.client.option1.label"/></button>
                    </div>
                </div>

            </fieldset>
        </form>
            </sec:authorize>
<br>
            <!--<a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/admin/verCliente"><f:message key="edit.client.option2.label"/></a>-->
            
             <a class="myButtonEdit"  onclick="goBack()"><f:message key="edit.client.option2.label"/></a>
            
        

<script>
function goBack() {
  window.history.back();
}
</script> 
    </body>
</html>
</f:bundle>