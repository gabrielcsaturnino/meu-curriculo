<%@ page import="org.example.meucurriculo.services.HomePageService" %>
<%@ page import="org.example.meucurriculo.repositoryimpl.HomePageRepositoryImpl" %>
<%@ page import="org.example.meucurriculo.models.HomePage" %><%--
  Created by IntelliJ IDEA.
  User: gabriel
  Date: 05/06/2024
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Inserir projeto</h1>
    <form action="/insertProject" method="post">
        <input type="text" name="nome">
        <input type="text" name="descricao">
        <button type="submit">Enviar</button>
        <%
        Object error = request.getSession().getAttribute("error");
        if(error!=null){
            out.print(error);
        }
        request.getSession().setAttribute("error", null);
        %>
    </form>

    <form action="/formApresentation" method="post">
        <input type="text" name="apresentacao">
        <button type="submit">Enviar</button>
    </form>

</body>
</html>
