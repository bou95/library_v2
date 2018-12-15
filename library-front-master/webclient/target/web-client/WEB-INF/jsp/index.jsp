<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<header class="row">
    <div class="col-lg-12">
        <%@ include file="./header.jsp" %>
    </div>
</header>
<div class="container">
    <div class="row" align="center">
        <section class="col-lg-12">
            <div class="center-block">
            <h2>Bienvenue sur le site de votre librairie</h2>
                <s:form theme="simple" cssclass="well form-search" action="searchbook">
                    <s:textfield name="books.author" label="Author" placeholder="Auteur"></s:textfield>
                    <s:textfield name="books.title" label="Title" placeholder="Titre"></s:textfield>
                    <s:submit type="button" cssclass="btn btn-primary" value="Search" />
                </s:form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
