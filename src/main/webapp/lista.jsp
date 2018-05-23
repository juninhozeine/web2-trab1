<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="estilos/style.css" >
        <title>JSP Page</title>
    </head>
    <style>
        .invisivel{
            display: none;
        }
        .doLadinho{
            display: inline;
        }
    </style>
    <body>
         <div class="topnav">
            <a class="active" href="cdProfServlet">Cadastrar Professor</a>
            <a href="CadOrientacao">Cadastrar Orientação</a>
            <a href="lista">Listar </a>
            <a href="logout">Sair</a>
        </div>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <fieldset> <legend>Busca de professor e listagem</legend>        
            <form method="GET" action="lista" accept-charset="iso-8859-1" class="doLadinho">
                <p>Pesquise o professor</p>
                <input name="inputNome"/>
                <button type="submit">Pesquisar</button>
                
            </form>
            <form method="GET" action="lista" accept-charset="iso-8859-1" class="doLadinho">
                <input class="invisivel" name="inputNome"/>
                <button type="submit">Listar tudo</button>
            </form>
            <ul>
                <c:forEach items="${orientacoes}" var="array">
                    <li>${array.professor.getNomeProfessor()}
                        <ul>
                            <li>Descrição da orientação: ${array.getDescricaoOrientacao()}</li> 
                            <li>Orientado: ${array.getOrientadoOrientacao()}</li>
                        </ul>                    
                    </li>
                </c:forEach>
            </ul>
        </fieldset>
        <div><h4>${msgCampos}</h4></div>
    </body>
</html>
