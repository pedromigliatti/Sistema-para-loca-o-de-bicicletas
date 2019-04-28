<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<head>
<title>Ops - Erro na aplicação</title>
<meta charset="UTF-8">
<style>
body{
    margin: 0;
    padding: 0;
    background: #e7ecf0;
    font-family: Arial, Helvetica, sans-serif;
}
*{
    margin: 0;
    padding: 0;
}
p{
    font-size: 14px;
    color: #373737;
    font-family: Arial, Helvetica, sans-serif;
    line-height: 18px;
}
p a{
    color: #D71920;
    font-size: 14px;
    text-decoration: none;
}
a{
    outline: none;
}
.f-left{
    float:left;
}
.f-right{
    float:right;
}
.clear{
    clear: both;
    overflow: hidden;
}
#block_error{
    width: 844px;
    height: 366px;
    border: 1px solid #cccccc;
    margin: 89px auto 0;
    -moz-border-radius: 4px;
    -webkit-border-radius: 4px;
    border-radius: 4px;
    background: #fff ;
}
#block_error div{
    padding: 102px 43px 0 244px;
}
#block_error div h2{
    color: #D71920;
    font-size: 24px;
    display: block;
    padding: 0 0 14px 0;
    border-bottom: 1px solid #cccccc;
    margin-bottom: 12px;
    font-weight: normal;
}
</style>
<title><f:message key="500.title"/></title>
<script src="consoleErros/console.js"></script>
</head>
<body marginwidth="0" marginheight="0" onload="console500()">
    <div id="block_error">
        <div>
         <h2><f:message key="500.label"/></h2>
        
        <p>
      <f:message key="500.text1.label"/><br /><br />
	  <f:message key="500.text2.label"/> 
          <f:message key="500.text3.label"/>
        </p>
        
        <br />
        <p><f:message key="500.text4.label"/> <a href="http://localhost:8080/Sistema-para-locacao-de-bicicletas/"><f:message key="500.text5.label"/></a> </p>
        </div>
    </div>
</body>

</html>
</f:bundle>