<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORDER LISTS</title>
<style>
.form
{
    margin-right:25%;
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
        <c:if test ="${userId=null}">
                <a class="nav-link" href="list?cartId=${cart.id}"><b>Home</b> <span class="sr-only">(current)</span></a>
                </c:if>
                <c:if test ="${userId!=null}">
                <a class="nav-link" href="userTransactions?userId=${userId}"><b>back</b> <span class="sr-only">(current)</span></a>
                </c:if>
              </li>

      </ul>
    </div>
  </nav>

  <div class="alert alert-primary" role="alert">
    <center><h3>ORDER DETAILS</h3></center>
  </div>

<table class="table table-striped"">
  <thead class="thead-dark">
    <tr>
      <th scope="col"> </th>
      <th scope="col">PART NO</th>
      <th scope="col">PART NAME</th>
      <th scope="col">CATEGORY</th>
      <th scope="col">PRICE</th>
      <th scope="col">QUANTITY</th>
      <th scope="col">AMOUNT</th>
      <th scope="col">APPLIED TO:</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${orderModels}" varStatus="status">
    <tr>
      <th scope="row">#</th>
      <td>${sparePartModels[status.index].partNo}</td>
      <td>${sparePartModels[status.index].name}</td>
      <td>${sparePartModels[status.index].category}</td>
      <td>${sparePartModels[status.index].price}</td>
      <td>${list.quantity}</td>
      <td>${list.amount}</td>
      <td>${sparePartModels[status.index].suitedVhl}</td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    </div>
    <strong>Total amount :${cart.totalAmount} Rs</strong>
</body><br>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>