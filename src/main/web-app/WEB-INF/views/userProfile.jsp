<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style>

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

<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="dashBoard"><b>HOME</a>
      </li>
    </nav>
<b>PROFILE</b>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="row">FIRST NAME</th>
      <td>:${user.firstName}</td>
      </tr>
      <tr>
      <th scope="row">LAST NAME</th>
      <td>:${user.lastName}</td>
      </tr>
      <tr>
      <th scope="row">USER NAME</th>
      <td>:${user.userName}</td>
      </tr>
      <tr>
      <th scope="row">PASSWORD</th>
      <td>:${user.password}</td>
      </tr>
      <tr>
      <th scope="row">AGE</th>
      <td>:${user.age}</td>
      </tr>
      <tr>
      <th scope="row">GENDER</th>
      <td>:${user.gender}</td>
      </tr>
      </thead>
      </table>
      <b>ADDRESS</b>
      <table class="table table-dark">
        <thead>
          <tr>
          <th scope="col"></th>
            <th scope="col">ADDRESS LINE 1</th>
            <th scope="col">ADDRESS LINE 2</th>
            <th scope="col">CITY</th>
            <th scope="col">STATE</th>
            <th scope="col">COUNTRY</th>
            <th scope="col">PINCODE</th>
            <th scope="col">EDIT</th>
            <th scope="col">DELETE</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${addressModels}">
          <tr>
          <th scope="row">#</th>
            <th scope="row">${list.addressLine1}</th>
            <td>${list.addressLine2}</td>
            <td>${list.city}</td>
            <td>${list.state}</td>
            <td>${list.country}</td>
            <td>${list.pincode}</td>
            <td><a href="addressEdit?addressId=${list.id}" class="badge badge-primary">Edit</a></td>
            <td><a href="deleteAddress?addressId=${list.id}&&userId=${user.id}" class="badge badge-primary">Delete</a></td>
          </tr>
      </c:forEach>
  </thead>
</table>
<a href="newAddress?userId=${user.id}" button type="button" class="btn btn-primary btn-lg btn-block">Add new Address</button></a>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
    </html>