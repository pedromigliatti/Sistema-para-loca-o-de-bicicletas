<%-- 
    Document   : cadastroCliente
    Created on : 22/04/2019, 00:23:34
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="new.renting.title"/></title>
        
        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
				
		
		<script type="text/javascript" src="jquery-3.4.1.min.user.js"></script>
	
		<script type="text/javascript" src="jquery.mask.min.user.js"></script>	
		<script type="text/javascript">
		$(document).ready(function(){
			$("#cpf").mask("000.000.000-00")
			
		})
		</script>
    </head>
    <body>
        <sec:authorize access="hasRole('ADMIN')">
                <form action="novaLocacao">
            <fieldset>

                <!-- Form Name -->
                <legend><f:message key="new.renting.legend.label"/></legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="data"><f:message key="new.renting.info1.label"/></label>  
                    <div class="col-md-4">
                        <input id="nascimento" name="data" type="data" placeholder="data" class="form-control input-md" required="">

                    </div>
                </div>
                
              <!-- Text input
                <div class="form-group">
                    <label class="col-md-4 control-label" for="data">Horário</label>  
                    <div class="col-md-4">
                        <input id="nascimento" name="horário" type="time" placeholder="horário" class="form-control input-md" required="">

                    </div>
                </div>
                        -->
                <!-- Text input-->
                <div class="form-group" hidden>
                    <label class="col-md-4 control-label" for="cpf"><f:message key="new.renting.info2.label"/></label>  
                    <div class="col-md-4">
                        <input id="email" name="cpf" type="text" placeholder="CPF Cliente" class="form-control input-md" required=""value="${cpf}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cnpj"><f:message key="new.renting.info3.label"/></label>  
                    <div class="col-md-4">
                        <input id="email" name="cnpj" type="text" placeholder="CNPJ Locadora" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" type="submit" name="submit" class="btn btn-primary"><f:message key="new.renting.option1.label"/></button>
                    </div>
                </div>

            </fieldset>
        </form>
            </sec:authorize>
                         <br>
           <!-- <a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/adminIndex.jsp"><f:message key="new.renting.option2.label"/></a>-->
             </body></body> <a class="myButtonEdit"  onclick="goBack()"><f:message key="new.renting.option2.label"/></a>
            
        

<script>
function goBack() {
  window.history.back();
}
</script> 

    </body>
</html>
</f:bundle>