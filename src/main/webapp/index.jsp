<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DevOps Demo For Capita</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/devops.js"></script>

</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Team Data</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add</span></a>

					</div>
				</div>
			</div>
			<div id="errorDiv" style="display: block;color: red;" align="center">
				<label style="font-size: 1em;" id="errorLabel"></label>
			</div>

			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> </span></th>
						<th>Emp ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="tblEntAttributes">
				</tbody>
			</table>
		</div>
		<div id="LoadingImage" style="display: none" align="center">
			<img src="images/loader.gif" />
		</div>

		<!-- Edit Modal HTML -->
		<div id="addEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form>
						<div class="modal-header">
							<h4 class="modal-title">Add Employee</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true" id="addBtnClose">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Emp Id</label> <input type="text" class="form-control"
									required id="employeeId">
							</div>
							<div class="form-group">
								<label>Name</label> <input type="text" class="form-control"
									required id="employeeName">
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" class="form-control"
									required id="employeeEmail">
							</div>
							<div class="form-group">
								<label>Address</label>
								<textarea class="form-control" required id="employeeAddress"></textarea>
							</div>
							<div class="form-group">
								<label>Phone</label> <input type="text" class="form-control"
									required id="employeePhone">
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="button"
								class="btn btn-success" value="Add" onclick="fnAddEmployee()"
								id="btnAdd">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Edit Modal HTML -->
		<div id="editEmployeeModal" class="modal fade" >
			<div class="modal-dialog">
				<div class="modal-content">
					<form>
						<div class="modal-header">
							<h4 class="modal-title">Edit Employee</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Employee ID</label> <input id="editEmployeeID" type="text" class="form-control" disabled="disabled"
									required>
							</div>
							<div class="form-group">
								<label>Name</label> <input id = "editEmployeeName" type="text" class="form-control"
									required>
							</div>
							<div class="form-group">
								<label>Email</label> <input id = "editEmployeeMail" type="email" class="form-control"
									required>
							</div>
							<div class="form-group">
								<label>Address</label>
								<textarea id = "editEmployeeAddress" class="form-control" required></textarea>
							</div>
							<div class="form-group">
								<label>Phone</label> <input id = "editEmployeePhone" type="text" class="form-control"
									required>
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-info" value="Save">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Delete Modal HTML -->
		<div id="deleteEmployeeModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form>
						<div class="modal-header">
							<h4 class="modal-title">Delete Employee</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<p>Are you sure you want to delete these Records?</p>
							<p class="text-warning">
								<small>This action cannot be undone.</small>
							</p>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-danger" value="Delete">
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">
	getAllData();
</script>
</html>
