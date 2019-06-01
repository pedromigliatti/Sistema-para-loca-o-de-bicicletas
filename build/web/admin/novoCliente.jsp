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
        <title><f:message key="new.client.title"/></title>
   
    <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
				
		
		<script type="text/javascript" src="jquery-3.4.1.min.admin.js"></script>
	
		<script type="text/javascript" src="jquery.mask.min.admin.js"></script>	
		<script type="text/javascript">
		$(document).ready(function(){
			$("#cpf").mask("000.000.000-00")
			$("#telefone").mask("(00) 0000-0000")
			$("#dataNascimento").mask("00/00/0000")
		})
		</script>
                <script language = "Javascript">

function emailcheck(str) {

var at="@"
var dot="."
var lat=str.indexOf(at)
var lstr=str.length
var ldot=str.indexOf(dot)
if (str.indexOf(at)==-1){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}

if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}

if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}

if (str.indexOf(at,(lat+1))!=-1){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}

if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}

if (str.indexOf(dot,(lat+2))==-1){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}

if (str.indexOf(" ")!=-1){
alert("Formato inválido de email, Por favor utilize o formato email@email.com")
return false
}
//("valid E-mail ID")
else
return true 
}

function ValidateEmail(){
var emailID=document.frm.email

if ((emailID.value==null)||(emailID.value=="")){
alert("Por favor insira o seu email")
emailID.focus()
return false
}
if (emailcheck(emailID.value)==false){
emailID.value=""
emailID.focus()
return false
}
return true
}
</script>
                
    </head>
    <body>
        <sec:authorize access="hasRole('ADMIN')">
                <form name="frm" action="novoCliente">
            <fieldset>

                <!-- Form Name -->
                <c:if test="${cliente.nome == null}"> <legend><f:message key="new.client.legend.label"/></legend> </c:if>
                
                <c:if test="${cliente != null}">
                    <div class="form-group">
                    <label class="col-md-4 control-label" for="id"><f:message key="new.client.info1.label"/></label>  
                    <div class="col-md-4">
                        <input id="id" name="id" type="hidden" placeholder="ID" class="form-control input-md" required="" value="${cliente.id}">

                    </div>
                </div>
                </c:if>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nome"><f:message key="new.client.info2.label"/></label>  
                    <div class="col-md-4">
                        <input id="nome" name="nome" type="text" placeholder="Nome" class="form-control input-md" required="" value="${cliente.nome}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email"><f:message key="new.client.info3.label"/></label>  
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required=""value="${cliente.email}"   >

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="senha"><f:message key="new.client.info4.label"/></label>
                    <div class="col-md-4">
                        <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md" required="" onclick="return ValidateEmail()"  >
                        <!--onclick="return ValidateEmail()"-->

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cpf"><f:message key="new.client.info5.label"/></label>  
                    <div class="col-md-4">
                        <input type="text" name="cpf"  id="cpf"  placeholder="CPF" class="form-control input-md" required="" value="${cliente.cpf}">

                    </div>
                </div>

                <!-- Multiple Radios -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="sexo"><f:message key="new.client.info6.label"/></label>
                    <div class="col-md-4">
                        <div class="radio">
                            <label for="sexo-0">
                                <input type="radio" name="sexo" id="sexo-0" value="M" checked="checked">
                                <f:message key="new.client.info6.option1.label"/>
                            </label>
                        </div>
                        <div class="radio">
                            <label for="sexo-1">
                                <input type="radio" name="sexo" id="sexo-1" value="F">
                                <f:message key="new.client.info6.option2.label"/>
                            </label>
                        </div>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="telefone"><f:message key="new.client.info7.label"/></label>  
                    <div class="col-md-4">
                        <input id="telefone" name="telefone" type="text" placeholder="Telefone" class="form-control input-md" value="${cliente.telefone}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nascimento"><f:message key="new.client.info8.label"/></label>  
                    <div class="col-md-4">
                        <input id="nascimento" name="nascimento" type="date" placeholder="Nascimento" class="form-control input-md" required="" value="${cliente.nascimento}">

                    </div>
                </div>
                <br>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" type="submit" name="submit" class="btn btn-primary" ><f:message key="new.client.option1.label"/></button>
                    </div>
                </div>

            </fieldset>
        </form>
            </sec:authorize>
<br>
           <!-- <a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/admin/verCliente"</a>-->
     <a class="myButtonEdit"  onclick="goBack()"><f:message key="new.renting.option2.label"/></a>
            
        

<script>
function goBack() {
  window.history.back();
}
</script> 
</body>
</html>
</f:bundle>