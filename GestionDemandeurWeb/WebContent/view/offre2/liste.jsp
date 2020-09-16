<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 		<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="http://localhost:8080/GestionDemandeurWeb/acceuilAdmin.jsp">GL Jobs</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="CvDemandeur?page=cvDemandeur2">Demandeurs</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Offre?page=offre2">Offres</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Categorie?page=categorie">Categorie</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Entreprise?page=entreprise">Entreprise</a></li>
                        <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Profil</span>  
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
              <a class="dropdown-item" href="#">
                  ${entreprise.nomEse} ${entreprise.lieu}
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="Entreprise?page=entreprise">
                  Entreprise
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="Categorie?page=categorie">
                  Categorie
                </a> 
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="Logout">
                  Déconnexion
                </a>
              </div>
            </li>
                    </ul>
                </div>
            </div>
        </nav>
        
 	
       <div class="row">
           <div class="col-md-12">
              <div class="card">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Ajouter une offre</h6>
                </div>
                <div class="card-body">
                	<form method="post" action="Offre">
	                  	<br/>
                	<h1>Editer Offre</h1>
	                  	<div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nom offre </label>
	                          <c:if test="${offre!= null }">
	                          <input type="hidden" name="id" class="form-control" value='${offre.id }'/>
	                          </c:if>
	                          <input type="text" name="nomOffre" class="form-control" required="required" value='<c:if test="${offre!= null }">${offre.nomOffre }</c:if>'/>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Type offre </label>
	                          <input type="text" name="type" class="form-control" required="required" value='<c:if test="${offre!= null }">${offre.type }</c:if>' />
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Entreprise </label>
	                           <select  name="entreprise"class="form-control" required="required" value='<c:if test="${offre!= null }">${offre.entreprise }</c:if>'/>
	                          	<option value=""> Faites votre choix </option>
	                          	<c:forEach items="${entreprises }" var="c">
          							<option value="${c.id }">${c.nomEse }</option>
          						</c:forEach>
	                          </select>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Categorie </label>
	                          <select  name="categorie"class="form-control" required="required" value='<c:if test="${offre!= null }">${offre.categorie }</c:if>'/>>
	                          	<option value=""> Faites votre choix </option>
	                          	<c:forEach items="${categories }" var="c">
          							<option value="${c.id }">${c.nomCat }</option>
          						</c:forEach>
	                          </select>
	                        </div>
	                      </div>
	                    </div>
	                    <c:if test="${offre != null }">
	                    	<button type="submit" class="btn btn-success pull-right">Modifier</button>
	                    </c:if>
	                    <c:if test="${offre == null }">
	                    	<button type="submit" class="btn btn-success pull-right">Envoyer</button>
	                    </c:if>
	                    
	                 </form>
                </div>
              	
              </div>
            </div>
            
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <h1>Postuler selon votre souhait!</h1>
                  <h4 class="card-title mt-0"> Liste des Offres</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>Nom</th>
                    		<th>Type</th>
                    		<th>Entreprise</th>
                    		<th>Poste</th>
                    		<th>Action</th>
                    		
                    	</tr>
                    	<c:forEach items="${offres }" var="c">
          					<tr>
          						<td>${c.id }</td>
          						<td>${c.nomOffre }</td>
          						<td>${c.type }</td>
          						<td>${c.entreprise.nomEse } </td>
          						<td>${c.categorie.nomCat } </td>
          						<td><a href="Offre?action=edit&id=${c.id }">Modifier</a></td>
          						
          					</tr>
          				</c:forEach>
                    </table>
                  </div>
                </div>
              </div>
            </div>      
<jsp:include page="../../footer.jsp"></jsp:include>