<%-- 
    Document   : cadastroCliente
    Created on : 22/04/2019, 00:23:34
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Locacao</title>
    </head>
    <body>
        <sec:authorize access="hasRole('ADMIN')">
                <form action="novaLocacao">
            <fieldset>

                <!-- Form Name -->
                <legend>Nova Locacao</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="data">Data</label>  
                    <div class="col-md-4">
                        <input id="nascimento" name="data" type="date" placeholder="data" class="form-control input-md" required="">

                    </div>
                </div>
                        
                <!-- Text input-->
                <div class="form-group" hidden>
                    <label class="col-md-4 control-label" for="cpf">CPF Cliente</label>  
                    <div class="col-md-4">
                        <input id="email" name="cpf" type="text" placeholder="CPF Cliente" class="form-control input-md" required=""value="${cpf}">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cnpj">CNPJ Locadora</label>  
                    <div class="col-md-4">
                        <input id="email" name="cnpj" type="text" placeholder="CNPJ Locadora" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" type="submit" name="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>

            </fieldset>
        </form>
            </sec:authorize>

    </body>
</html>
