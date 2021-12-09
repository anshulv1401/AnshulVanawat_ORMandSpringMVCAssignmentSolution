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
			
			<h2>
				Available list of customers
				<a href="/crmapp/customers/new" class="btn btn-primary btn-sm float-end">Add a customer</a>
			</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td><c:out value="${customer.firstname}" /></td>
							<td><c:out value="${customer.lastname}" /></td>
							<td><c:out value="${customer.email}" /></td>
							<td>
								<a href="/crmapp/customers/edit?id=${customer.id}" class="btn btn-secondary btn-sm">Update</a>
								<a href="/crmapp/customers/delete?id=${customer.id}" class="btn btn-danger btn-sm">Delete</a>
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>