<%-- 
    Document   : cadastroOrientacao
    Created on : 12/04/2018, 19:48:14
    Author     : mayara
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
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <div class="topnav">
            <a class="active" href="cdProfServlet">Cadastrar Professor</a>
            <a href="CadOrientacao">Cadastrar Orientação</a>
            <a href="lista">Listar </a>
            <a href="logout">Sair</a>
        </div>
        <h1>Cadastrar de Orientação:</h1>
        
        <form method="POST" name="CadastrarOrientacao">
            <label>Descrição da Orientação: </label><input type="text" name="descricaoOrientacao">
            <label>Orientando da Orientação: </label><input  type="text" name="orientadoOrientacao">
            <select name="option">
                    <option value="">Selecione o Professor</option>
                    <c:forEach var="objetoDaVez" items="${objetoRecebido}">
                        <option value="${objetoDaVez.idProfessor}">
                            ${objetoDaVez.nomeProfessor}
                        </option>
                    </c:forEach>
             </select>
            <button type="submit" value="Cadastrar">Cadastrar</button>
        </form>
        
        <div><h5>$(msgCampos)</h5></div>
        <div><h4>${msgSucesso}</h4></div>
    </body>
</html>
