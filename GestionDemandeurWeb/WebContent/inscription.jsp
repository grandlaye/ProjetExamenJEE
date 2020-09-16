<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>GL Jobs</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="public/login/page/assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="public/login/page/css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">GL Jobs</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index.jsp">Connexion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
       
        <div class="row">
           <div class="col-md-12">
              <div class="card">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary"></h6>
                  <h1></h1>
                  <h1></h1>
                  
                  <br/>
                </div>
                <div class="card-body">
                
                <form method="post" action="Demandeur">
                	<br/>
                	<h1></h1>
                	<h1>Formulaire d'inscription</h1>
	                  	<div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nom </label>
	                          <input type="text" name="nom" class="form-control" required="required" />
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Prenom </label>
	                          <input type="text" name="prenom" class="form-control" required="required" />
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Email </label>
	                          <input type="text" name="email" class="form-control" required="required" />
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Adresse </label>
	                          <input type="password" name="password" class="form-control" required="required" />
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Telephone </label>
	                          <input type="text" name="tel" class="form-control" required="required" />
	                        </div>
	                      </div>
	                    </div>
	                    	<button type="submit" class="btn btn-success pull-right">Inscrire</button>
	                 </form>
                </div>
              	
              </div>
            </div> 
            
            
 <!--            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0"> Tableau des CV</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>Nom</th>
                    		<th>Prenom</th>
                    		<th>Email</th>
                    		
                    		<th>Action</th>
                    	</tr>
                    	<c:forEach items="${utilisateurs }" var="u">
          					<tr>
          						<td>${u.id }</td>
          						<td>${u.nom }</td>
          						<td>${u.prenom }</td>
          						<td>${u.email }</td>
          						<td><a href="Utilisateur?action=edit&id=${u.id }">Modifier</a></td>
          					</tr>
          				</c:forEach>
                    </table>
                  </div>
                </div>
              </div>
            </div> -->
          </div>
        
<jsp:include page="footer.jsp"></jsp:include>