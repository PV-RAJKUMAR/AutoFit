<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Requests</title>
<style>
.form
{
    margin-left: 2%
    margin-right: 2%;
    text-align: justify;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><b><i>AUTO-FIT SPARE PART CENTRE pvt.ltd</i></b><br>  <font size="1"><i>Solution for all automobile problems</i></font></a></a></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
</div>

<div class="form">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
                  <a class="nav-link" href="dashBoard"><b>Home</b> <span class="sr-only">(current)</span></a>
                </li>
        </ul>
      </div>
    </nav>
  </div>

  <div class="alert alert-secondary" role="alert">
    <h3><font color="grey"><b>Order Approval Requests</b></font></h3>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col"> </th>
          <th scope="col">Customer Name</th>
          <th scope="col">Current Status</th>
          <th scope="col">Oder Details</th>
          <th scope="col">Total Amount</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="list" items="${cartModels}">
        <tr>
          <th scope="row">#</th>
          <td>${list.user.firstName} ${list.user.lastName}</td>
          <td>${list.status}</td>
          <td><a href="orders/${list.id}">Order Details</a></td>
          <td>${list.totalAmount}</td>
          <td><a href="/AutoFit/admin/approveOrder/${list.id}" button type="button" class="btn btn-primary">APPROVE-ORDER</button></a><span class="tab"></span><a href="/AutoFit/admin/rejectOrder/${list.id}" button type="button" class="btn btn-danger">REJECT-ORDER</button></a></td>
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