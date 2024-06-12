<!DOCTYPE html>
<html lang="pt-br">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="org.example.meucurriculo.models.HomePage" %>
    <%@ page import="org.example.meucurriculo.services.HomePageService" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="org.example.meucurriculo.models.Project" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Meu Portfólio - testing</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <%
        HomePageService homePageService = new HomePageService();

        HomePage homePage = homePageService.getHomePage("homePage");
        String apresentacao = homePage.getApresentacao();
        String nome = homePage.getNome();
        String email = homePage.getEmail();
        String rede_social = homePage.getRede_social();
    %>

    <style>
        body {
            padding-top: 56px;
            background-color: bisque;
        }
        .project-card {
            margin-bottom: 20px;
        }
        .filter-btn {
            margin-right: 10px;
        }
        p{
            font-family: "BitstreamVeraSansMono Nerd Font";
            color: coral;
        }
        h2{
            font-family: "BitstreamVeraSansMono Nerd Font";
            color: coral;
        }
        h1{
            font-family: "BitstreamVeraSansMono Nerd Font";
            color: coral;
        }

    </style>
</head>

<!-- Apresentação -->
<section id="presentation" class="py-5">
    <div class="container">
        <h1 class="text-center"><%out.print(nome);%></h1>
        <p class="lead text-center">
        <%out.print(apresentacao);%>

        </p>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <img src="path/to/your/photo.jpg" class="img-fluid rounded-circle" alt="Minha Foto">
            </div>
        </div>
    </div>
</section>

<!-- Projetos -->
<section id="projects" class="py-5 bg-light">
    <div class="container">
        <h2 class="text-center">Meus Projetos</h2>
        <div class="text-center mb-4">
            <button class="btn btn-primary filter-btn" onclick="filterProjects('All')">Todos</button>
            <button class="btn btn-secondary filter-btn" onclick="filterProjects('Java')">Java</button>
            <button class="btn btn-success filter-btn" onclick="filterProjects('JavaScript')">JavaScript</button>
            <button class="btn btn-info filter-btn" onclick="filterProjects('Python')">Python</button>
        </div>
        <div class="container>">
        <div class="row" id="project-cards">
            <%
                ArrayList<Project> list = homePage.getList_project();
                for (Project p : list) {
            %>
            <div class="col-md-4 project-card" data-tech="Java">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><%out.print(p.getNome());%></h5>
                        <p class="card-text">Descrição: <%out.print(p.getDescricao());%>. Tecnologia: Java</p>
                    </div>
                </div>
            </div>
            <%}%>
            <%-- Adicione mais cartões de projetos aqui --%>
         </div>
      </div>
    </div>
</section>


<section id="contacts" class="py-5">
    <div class="col-lg-8 col-md-6">
        <p><strong>Email:</strong> <%out.print(email);%>></p>
        <p><strong>Telefone:</strong> (00) 1234-5678</p>
        <p><strong>LinkedIn:</strong><%out.print(rede_social);%></p>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
<script>
    function filterProjects(tech) {
        $('.project-card').each(function() {
            if (tech === 'All' || $(this).data('tech') === tech) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    }
</script>


</body>
</html>
