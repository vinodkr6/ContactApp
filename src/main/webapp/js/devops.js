$(document).ready(function() {
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();

	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function() {
		if (this.checked) {
			checkbox.each(function() {
				this.checked = true;
			});
		} else {
			checkbox.each(function() {
				this.checked = false;
			});
		}
	});
	checkbox.click(function() {
		if (!this.checked) {
			$("#selectAll").prop("checked", false);
		}
	});
});

function fnAddEmployee() {
	let employeeId = document.getElementById('employeeId').value;
	let employeeName = document.getElementById('employeeName').value;
	let employeeEmail = document.getElementById('employeeEmail').value;
	let employeeAddress = document.getElementById('employeeAddress').value;
	let employeePhone = document.getElementById('employeePhone').value;

	var jsonObject = {
		employeeId : employeeId,
		employeeName : employeeName,
		employeeEmail : employeeEmail,
		employeeAddress : employeeAddress,
		employeePhone : employeePhone
	};

	document.getElementById("addBtnClose").click();
	$("#LoadingImage").show();
	$.ajax({
		url : "addemployee",
		type : "POST",
		data : {
			students : JSON.stringify(jsonObject)
		},
		success : function(result) {
			$("#errorLabel").text("");
			$("#LoadingImage").hide();
			if (result == 'SUCCESS') {
				appendRow(employeeId, employeeName, employeeEmail,
						employeeAddress, employeePhone);
			}else{
				$('#errorLabel').text(result);
			}
		},
		error : function(data) {
			$("#LoadingImage").hide();
			$("#errorLabel").text(data);
		}
	});

}

// function appendRow(employeeId, employeeName, employeeEmail, employeeAddress,
// employeePhone) {
//
// var newRowContent = "<tr><td><span class='custom-checkbox'>"
// + "</span></td><td>"
// + employeeId
// + "</td><td>"
// + employeeName
// + "</td><td>"
// + employeeEmail
// + "</td>"
// + "<td>"
// + employeeAddress
// + "</td><td>"
// + employeePhone
// + "</td><td><a href='#editEmployeeModal' class='edit' data-toggle='modal'>"
// + "<i class='material-icons' data-toggle='tooltip'
// title='Edit'>&#xE254;</i></a><a href='#deleteEmployeeModal' "
// + "class='delete' data-toggle='modal'><i class='material-icons'
// data-toggle='tooltip' title='Delete'>&#xE872;</i></a></td></tr>";
//
// $(newRowContent).appendTo($("#tblEntAttributes"));
//
// }

function appendRow(employeeId, employeeName, employeeEmail, employeeAddress,
		employeePhone) {

	var newRowContent = "<tr id ='"+employeeId+"'><td><span class='custom-checkbox'>"
			+ "</span></td><td>"
			+ employeeId
			+ "</td><td>"
			+ employeeName
			+ "</td><td>"
			+ employeeEmail
			+ "</td>"
			+ "<td>"
			+ employeeAddress
			+ "</td><td>"
			+ employeePhone
			+ "</td><td><a href='#editEmployeeModal' class='edit' data-toggle='modal' onclick=\"fnEdit()\">"
			+ "<i class='material-icons' data-toggle='tooltip' title='Edit'>&#xE254;</i></a>"
			+ "<a href='#' id = 'del_"+employeeId+"' onclick=\"fnDelete('d"+employeeId+"')\""
			+ "class='delete' data-toggle='modal'><i class='material-icons' data-toggle='tooltip' title='Delete' >&#xE872;</i></a></td></tr>";

	$(newRowContent).appendTo($("#tblEntAttributes"));

}

function getAllData() {

	document.getElementById("addBtnClose").click();
	$("#errorLabel").text("");
	$("#LoadingImage").show();
	$.ajax({
		url : "allemployees",
		type : "GET",
		success : function(result) {
			$("#LoadingImage").hide();
			if(result.startsWith("ERROR:")){
				$("#errorLabel").text(result);
			}else{
				var json = JSON.parse(result);
				for (var i = 0; i < json.length; i++) {
					var obj = json[i];
					console.log(obj);
					appendRow(obj.employeeId, obj.employeeName, obj.employeeEmail,
							obj.employeeAddress, obj.employeePhone);
				}
			}
			
		},
		error : function(data) {
			$("#errorLabel").text(data);
		}
	});

}

function fnEdit(){
	setTimeout(() => {
		document.getElementById('editEmployeeID').value = "032388";
		document.getElementById('editEmployeeName').value = "Sunil K Bhadram";
		document.getElementById('editEmployeeMail').value = "sunil.bhadram@in.ibm.com";
		document.getElementById('editEmployeeAddress').value = "Bangalore";
		document.getElementById('editEmployeePhone').value = "9836034499";
	}, 500);
	
}

function fnDelete(employeeId){
	var jsonObject = {
			employeeId : ""+employeeId+"",
	};
	$("#LoadingImage").show();
	$("#errorLabel").text("");
	$.ajax({
		url : "deleteemployee",
		type : "POST",
		data : {
			id : JSON.stringify(jsonObject)
		},
		success : function(result) {
			$("#LoadingImage").hide();
            if(result == 'SUCCESS'){
            	var trId = employeeId.substring(1);
            	$('#'+trId+'').remove();
            }else{
            	$("#errorLabel").text(result);
            }
			
		},
		error : function(data) {
			$("#LoadingImage").hide();
			$("#errorLabel").text(data);
		}
	});
	
}
