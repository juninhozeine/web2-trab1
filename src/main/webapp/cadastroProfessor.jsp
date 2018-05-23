<%-- 
    Document   : cadastroProfessor
    Created on : 10/04/2018, 19:48:14
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="cdProfServlet">Cadastrar Professor</a>
            <a href="CadOrientacao">Cadastrar Orientação</a>
            <a href="lista">Listar </a>
            <a href="logout">Sair</a>
        </div>
        
        <h1>Bem Vindo a Tela de Cadastro de Professores!</h1>
        
        <form method="POST" name="cadastrarProfessores">
            <label>Nome do Professor: </label><input type="text" name="nomeProfessor">
            <button type="submite" value="Cadastrar">Cadastrar</button>
        </form>
        
        <div><h4>${msgSucesso}</h4></div>
        <div><h5>${msgCampos}</h5></div>
    </body>
</html>
