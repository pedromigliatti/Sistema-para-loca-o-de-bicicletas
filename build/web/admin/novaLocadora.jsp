<%-- 
    Document   : novaLocadora
    Created on : 22/04/2019, 04:59:53
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar uma nova locadora</title>
    </head>
    <body>
        <sec:authorize access="hasRole('ADMIN')">
          <form action="novaLocadora">
            <fieldset>

                <!-- Form Name -->
                <legend>Nova Locadora</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="nome">Nome</label>  
                    <div class="col-md-4">
                        <input id="nome" name="nome" type="text" placeholder="Nome" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email</label>  
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="senha">Senha</label>
                    <div class="col-md-4">
                        <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cnpj">CNPJ</label>  
                    <div class="col-md-4">
                        <input id="cnpj" name="cnpj" type="text" placeholder="CNPJ" class="form-control input-md" required="">

                    </div>
                </div>


                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cidade">Cidade</label>  
                    <div class="col-md-4">
                        <input id="cidade" name="cidade" type="text" placeholder="Cidade" class="form-control input-md">

                    </div>
                </div>
                <br>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button id="submit" type="submit" name="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>

            </fieldset>
        </form>
            </sec:authorize>

    </body>
</html>

