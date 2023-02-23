<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRICING PAGE</title>
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
<body>
<div class="alert alert-primary" role="alert">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="dashBoard"><b><i>AUTO-FIT SPARE PART CENTRE pvt.ltd</i></b><br>  <font size="1"><i>Solution for all automobile problems</i></font></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
</div>
<div class="alert alert-primary" role="alert">
 <center><h3>USER PRICE ESTIMATION</h3></center>
</div>

<table class="table table-striped">
 <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">PART NO</th>
      <th scope="col">PART NAME</th>
      <th scope="col">AUTOMOBILE</th>
      <th scope="col">CATEGORY</th>
      <th scope="col">PRICE</th>
      <th scope="col">BOUGHT QUANTITY</th>
      <th scope="col">AMOUNT</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${cartModel.orderModelList}" varStatus="status">
      <tr>
        <th scope="row">#</th>
        <td>${sparePartModels[status.index].partNo}</td>
        <td>${sparePartModels[status.index].name}</td>
        <td>${sparePartModels[status.index].suitedVhl}</td>
        <td>${sparePartModels[status.index].category}</td>
        <td>${sparePartModels[status.index].price}</td>
        <td>${list.quantity}</td>
        <td>${list.amount}</td>
      </tr>
      </c:forEach>
      <tr>
      <form:form method="post" modelAttribute="quote" action="/AutoFit/user/submitQuote?cartId=${cartModel.id}">
      <div class="form-group row">
          <form:label for="inputEmail3" class="col-sm-2 col-form-label" path="reqQuote"><i><b>QUOTE AMOUNT</i></b><br><i>Enter amount in full figures</i></br></form:label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputEmail3" placeholder="Enter Desired amount in Rupees" path="reqQuote"/>
          </div>
        </div>
        <div class="form-group">
            <form:label for="exampleFormControlTextarea1" path="comments">Comments</form:label>
            <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3" path="comments"/>
          </div>
           <div class="form-group row">
              <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">SUBMIT</button>
              </div>
            </div>
        </form:form>
      </tr>
  </tbody>
</table>
<h4><center><strong>TOTAL AMOUNT :${cartModel.totalAmount} RS</strong></center></h4>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>