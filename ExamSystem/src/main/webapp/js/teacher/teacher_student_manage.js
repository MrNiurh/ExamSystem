$(function() {

	$("#addStudent").click(function() {
		addStudent();
	});
	
	$("#selectStudent").click(function() {
		selectAllStudent();
	});

})

function addStudent() {
	var data = $("#insert").serialize();
	var URL = abroot + "teacher/insertStudent";
	$.ajax({
		url : URL,
		type : "post",
		async : false,
		data : data,
		dataType : 'json',
		success : function(data) {
			alert("操作成功");
		},
		error : function(data) {
			alert("操作失败");
		}
	});
}
function selectAllStudent() {
	var data = $("#select").serialize();
	var URL = abroot + "teacher/selectAllStudent";
	$.ajax({
		url : URL,
		type : "post",
		async : false,
		data : data,
		dataType : 'json',
		success : function(data) {
			$("#tbody").empty();
			for (var i = 0; i < data.length; i++) {
				var str = '';
				str += "<tr class='tablectrl'>";
				str += "<td>" + data[i].stuid + "</td>";
				str += "<td>" + data[i].stuname + "</td>";
				str += "<td>" + data[i].stuclass + "</td>";
				str += "<td>" + data[i].ip + "</td></tr>";
				$("#tbody").append(str);
			}
		},
		error : function(data) {
			alert("查询失败");
		}
	});
}