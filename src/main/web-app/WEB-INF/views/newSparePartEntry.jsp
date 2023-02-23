<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW SPARE PART ENTRY</title>
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
<div class="alert alert-secondary" role="alert">
 <h3><b>SPARE PART DT-ENTRY</b></h3>
</div>
<form method="post" modelAttribute="sparePartModel" action="save">

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label" name="partNo"><i><b>PART NO</i></b></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="PART NO" name="partNo"/>
    </div>
  </div>

  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label" name="name"><i><b>PART NAME</i></b></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="PART NAME" name="name"/>
    </div>
  </div>

  <div class="form-group row-md-6">
        <label for="inputState" name="category"><i><b>CATEGORY</i></b></label>
        <select id="inputState" class="form-control" name="category"/>
          <option selected>Choose...</option>
          <option value="Body components">BODY COMPONENTS</option>
          <option value="Doors">DOORS</option>
          <option value="Battery">BATTERY</option>
          <option value="Gauges and meters">GAUGES AND BATTERY</option>
          <option value="Ignition system">IGNITION SYSTEM</option>
          <option value="Lighting and signaling system">LIGHTING & SIGNALLING SYSTEM</option>
        <option value="Sensors">SENSORS</option>
        </select>
      </div>

    <div class="form-group row">
          <label for="inputPassword3" class="col-sm-2 col-form-label" name="avlCount"><i><b>AVAILABLE COUNT</i></b></label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputPassword3" placeholder="AVAILABLE COUNT" name="avlCount"/>
          </div>
        </div>

        <div class="form-group row">
                  <label for="inputPassword3" class="col-sm-2 col-form-label" name="price"><i><b>PRICE</i></b></label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputPassword3" placeholder="DEFINE PRICE" name="price"/>
                  </div>
                </div>

                <div class="form-group row-md-4">
                        <label for="inputState" name="suitedVhl"><i><b>AUTOMOBILE</i></b></label>
                        <select id="inputState" class="form-control" name="suitedVhl">
                          <option selected>Choose....</option>
                          <option value="LEXUS">LEXUS</option>
                          <option value="Fiat">FIAT</option>
                          <option value="Lancia">LANCIA</option>
                          <option value="Lamborgini">LAMBORGINI</option>
                          <option value="Ferrari">FERRARI</option>
                          <option value="Maruti Suzuki">MARUTHI SUZUKI</option>
                          <option value="Force Motors">FORCE MOTORS</option>
                          <option value="Hindustan Motors ">HINDUSTHAN MOTORS</option>

                        </select>
                     </div>

                     <div class="form-group row">
                         <div class="col-sm-10">
                           <button type="submit" class="btn btn-primary">Save</button>
                         </div>
                       </div>
                       </form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>