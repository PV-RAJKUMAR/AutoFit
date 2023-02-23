<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPARE PART TABLE SEPERATED BY CAR BRAND</title>
<style>
.form
{
    margin-left: 1%;
    margin-right: 1%;
    text-align: justify;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color:#E8E9EA;">

<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="dashBoard"><b><i>AUTO-FIT SPARE PART CENTRE pvt.ltd</i></b><br>  <font size="1"><i>Solution for all automobile problems</i></font></a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    </div>
  </nav>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <c:if test = "${user!=null}">
        <a class="nav-link" href="listAll?userId=${user.id}"><b><span class="badge badge-primary">>>GO TO GEN LIST</span></a>
        </c:if>
        <c:if test = "${cart!=null}">
        <a class="nav-link" href="list?cartId=${cart.id}"><b><span class="badge badge-primary">>>GO TO GEN LIST</span></a>
       </c:if>
      </li>
    </nav>

<div class="alert alert-secondary" role="alert">
  <h3><font color="grey"><b>${brand} SPARE PART LIST:</b></font></h3>
<table class="table table-striped"">
  <thead class="thead-dark">
    <tr>
      <th scope="col"> </th>
      <th scope="col">PART NO</th>
      <th scope="col">PART NAME</th>
      <th scope="col">CATEGORY</th>
      <th scope="col">PRICE</th>
      <th scope="col">AVAILABILITY</th>
      <th scope="col">ADD TO CART</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${sparePartModels}">
    <tr>
      <th scope="row">#</th>
      <td>${list.partNo}</td>
      <td>${list.name}</td>
      <td>${list.category}</td>
      <td>${list.price}</td>
      <td>${list.avlCount}</td>
      <c:if test ="${user!=null}">
      <td><a href="addToOrder?partId=${list.id}&&userId=${user.id}&&carBrand=${brand}" button type="submit" class="btn btn-primary">ADD</button></a></td>
      </c:if>
      <c:if test ="${cart!=null}">
      <td><a href="addToCart?partId=${list.id}&&cartId=${cart.id}&&carBrand=${brand}" button type="submit" class="btn btn-primary">ADD</button></a></td>
      </c:if>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>