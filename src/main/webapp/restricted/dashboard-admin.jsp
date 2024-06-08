<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>

<body>

    <h1>Inserir projeto</h1>
    <form class="f" id="t" action="/insertProject" method="POST">
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

    <form class="f" id="tt" action="/formApresentation" method="POST">
        <input type="text" name="apresentacao">
        <button type="submit">Enviar</button>
    </form >

</body>
</html>
