<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Quote List</title>
<style>

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/dashBoard"><b><i>AUTO-FIT SPARE PART CENTRE pvt.ltd</i></b><br>  <font size="1"><i>Solution for all automobile problems</i></font></a></a>
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
                <a class="nav-link" href="dashBoard"><b>Home</b> <span class="sr-only">(current)</span></a>
              </li>

      </ul>
    </div>
  </nav>
<div class="alert alert-info" role="alert">
  <center><h3>USER CART LIST</h3></center>
</div>
  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col"></th>
        <th scope="col">ORDER DETAILS</th>
        <th scope="col">QUOTE DETAILS</th>
        <th scope="col">BILLED AMOUNT</th>
        <th scope="col">(QUOTE APPROVED)BILLABLE AMOUNT</th>
        <th scope="col">STATUS</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${userCartList}">
      <tr>
        <th scope="row">#CART</th>
        <td><a href="orderList3?cartId=${list.id}" span class="badge badge-pill badge-info">Click here to view Order details</span></td>
        <td><a href="quoteList?cartId=${list.id}" span class="badge badge-pill badge-info">Click here to view Quote details</span></td>
        <td>${list.totalAmount}</td>
        <c:if test ="${list.approvedAmount == 0}">
        <td>${list.totalAmount}</td>
        </c:if>
        <c:if test ="${list.approvedAmount > 0}">
        <td>${list.approvedAmount}</td>
        </c:if>
        <c:if test ="${list.status == 'pending'}">
        <td>DISPATCHED</td>
        </c:if>
        <c:if test ="${list.status == 'approved'}">
        <td>OUT FOR DELIVERY</td>
        </c:if>
        <c:if test ="${list.status == null}">
                <td>REVERTED</td>
                </c:if>
      </tr>
</c:forEach>
      </tbody>
      </table>

  </body>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
          </body>
          </html>