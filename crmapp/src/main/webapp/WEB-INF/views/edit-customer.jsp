<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<h1>Customer Relationship Management</h1>
			<hr />
			
			<h2><c:out value="${newCustomer ? 'Add a new Customer' : 'Update Customer'}" /></h2>
			
			<form action="/crmapp/customers/save" method="post">
			  <div class="mb-3">
			    <input type="hidden" class="form-control" name="id" value="${customer.id}">
			  </div>
			  <div class="mb-3">
			    <label for="name" class="form-label">First Name</label>
			    <input type="text" class="form-control" id="firstname" name="firstname" value="${customer.firstname}">
			  </div>
			  <div class="mb-3">
			    <label for="department" class="form-label">Last Name</label>
			    <input type="text" class="form-control" id="lastname" name="lastname" value="${customer.lastname}">
			  </div>
			  <div class="mb-3">
			    <label for="country" class="form-label">Email</label>
			    <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			  <a href="/crmapp/customers/list" class="btn btn-danger">Cancel</a>
			</form>
		</div>
		
	</body>
</html>