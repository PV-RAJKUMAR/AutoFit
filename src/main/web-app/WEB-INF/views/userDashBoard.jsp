<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User DashBoard</title>
<style>
.wrap{
    left      : 80%;
    top       : 50%;
    position  : absolute;
    transform : translate(-50%, -50%);
    color     : blue;
}
.form
{
    margin-left: 1%;
    margin-right: 1%;
    text-align: justify;
}
body {
  background-color:lightblue;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body >
<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="dashBoard"><b><i>AUTO-FIT SPARE PART CENTRE pvt.ltd</i></b><br>  <font size="1"><i>Solution for all automobile problems</i></font></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
</div>

<div class="form">
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active dropdown">
              <a class="nav-link dropdown-toggle my-2 my-lg-0" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <b>GENERAL</b>
              </a>
              <div class="dropdown-menu " aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="listAll?userId=${user.id}">SPARE PART LIST</a>
              </div>
              </li>
      <li class="nav-item active dropdown">
        <a class="nav-link dropdown-toggle my-2 my-lg-0" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <b>USER SPECIFIC</b>
        </a>
        <div class="dropdown-menu " aria-labelledby="navbarDropdown">
        <a class="dropdown-item" href="userTransactions?userId=${user.id}">Transactions(CART DETAILS)</a>
        </div>
        </li>
    </ul>
    <div class="btn-group" role="group">
        <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <c:if test="${user!= null}">
                  Welcome user: ${user.userName}
                  </c:if>
        </button>
        <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
          <a class="dropdown-item" href="/AutoFit/user/profile?userId=${user.id}"><font color="blue">PROFILE</font></a>
          <a class="dropdown-item" href="/AutoFit/user/edit?userId=${user.id}"><font color="blue">EDIT</font></a>
          <a class="dropdown-item" href="/AutoFit/j_spring_security_logout"><font color="blue">LOG-OUT</font></a>
        </div>
      </div>
  </div>
</nav>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>