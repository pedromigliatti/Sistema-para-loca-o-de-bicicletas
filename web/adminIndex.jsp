    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <style>
        .myButton {
	background-color:#005eff;
	-moz-border-radius:28px;
	-webkit-border-radius:28px;
	border-radius:28px;
	border:1px solid #005eff;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:14px;
	padding:10px 20px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
.myButton:hover {
	background-color:#ff0000;
}
.myButton:active {
	position:relative;
	top:1px;
}
.myButtonDelete {
	background-color:#ff0000;
	-moz-border-radius:28px;
	-webkit-border-radius:28px;
	border-radius:28px;
	border:1px solid #ff0000;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:14px;
	padding:10px 20px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
    </style>
    <body>
        <h2 align="center">Bemvindo
            <%=request.getUserPrincipal().getName().toString()%>
        </h2>

        <div align="center">
        <sec:authorize access="hasRole('ADMIN')">

            <a class="myButton" href="admin/verCliente">Ver Cliente</a>
            <br>
            <br>
            <a class="myButton" href="admin/verLocadora">Ver Locadoras</a>
        </sec:authorize>

        <sec:authorize access="hasRole('USER')">

            <a class="myButton" href="user/verLocacoesCliente?nome=<%=request.getUserPrincipal().getName()%>">Locações</a>
        </sec:authorize>
            <br>
            <br>
            <a class="myButtonDelete" href="logout">Logout</a>
        </div>
    </body>
</html>