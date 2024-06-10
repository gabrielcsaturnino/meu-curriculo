<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>

<body>

    <h1>Inserir projeto</h1>
    <form class="f" id="t" action="/insertProject" method="POST">
        <input type="text" name="nome"><br>
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
        <h2>apresentacao:</h2><input type="text" name="apresentacao"><br>
        <h2>email:</h2><input type="text" name="email"><br>
        <h2>linkedin:</h2><input type="text" name="rede_social"><br>
        <h2>nome:</h2><input type="text" name="nome"><br>
        <button type="submit">Enviar</button>
    </form >

</body>
</html>
