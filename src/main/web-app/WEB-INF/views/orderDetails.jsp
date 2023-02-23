<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details Page</title>
<style>
.form
{
    margin-left: 2%;
    margin-right: 2%;
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
  </nav>
</div>

<c:if test = "${empty cart}">
<div class="alert alert-secondary" role="alert">
<h3><b>Hey user:${user.userName}...Kindly mention the quantity you require for your selected "${sparePartModel.name}" item.</b></h3>
</c:if>

<c:if test = "${cart!=null}">
<div class="alert alert-secondary" role="alert">
<h3><b>Hey user:${cart.user.userName}...Kindly mention the quantity you require for your selected "${sparePartModel.name}" item.</b></h3>
</c:if>

<c:choose>
  <c:when test="${empty cart}">
   <!-- construct an "OrderDetails" link with user id -->
             <c:url var="OrderAddLink" value="/user/submit">
              <c:param name="partId" value="${sparePartModel.id}" />
              <c:param name="userId" value="${user.id}" />
              <c:param name="carBrand" value="${brand}" />
             </c:url>

  </c:when>
  <c:otherwise>
    <!-- construct an "OrderDetails" link with cart id -->
              <c:url var="OrderAddLink" value="/user/saveToCart">
               <c:param name="partId" value="${sparePartModel.id}" />
               <c:param name="cartId" value="${cart.id}" />
               <c:param name="carBrand" value="${brand}" />
              </c:url>
  </c:otherwise>
</c:choose>
<form:form method="post" modelAttribute="order" action="${OrderAddLink}">
  <div class="form-group row">
    <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="quantity"><i><b>Quantity</i></b></form:label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" id="inputEmail3" placeholder="Enter the count" path="quantity"/>
    </div>
  </div>
  <div class="form-group row">
      <div class="col-sm-10">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
        </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>