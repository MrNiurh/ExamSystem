$(function() {
	$("#infoBtn").click(function() {
		selectInfoStudent();
	})
	$("#ipBtn").click(function() {
		selectStudentByIp();
	})

	$("#tbody").on("click", ".unlockBtn", function() {
		var stuid = $(this).parent().siblings(":first").text();
		var data = {
			"stuid" : stuid,
			"ip" : null
		};
		var obj = $(this);
		var URL = abroot + "student/updateStudentIp";
		$.ajax({
			url : URL,
			type : "post",
			async : false,
			data : data,
			success : function(data) {
				obj.parent().parent().remove();
			},
			error : function(data) {
			}
		});
	})

})
function selectInfoStudent() {
	var data = $("#selectInfoStudent").serialize();
	var URL = abroot + "teacher/selectInfoStudent";
	$
			.ajax({
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
						str += "<td>" + data[i].ip + "</td>";
						str += "<td><button class='btn btn-success unlockBtn' value='"
								+ data[i].stuid
								+ "'><i class='iconfont icon-qingchu'></i>解除锁定</button></tr>";
						$("#tbody").append(str);
					}
				},
				error : function(data) {
					alert("error");
				}
			});
}

function selectStudentByIp() {
	var data = $("#selectStudentByIp").serialize();
	var URL = abroot + "teacher/selectStudentByIp";
	$
			.ajax({
				url : URL,
				type : "post",
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
						str += "<td>" + data[i].ip + "</td>";
						str += "<td><button class='btn btn-success unlockBtn' value='"
								+ data[i].stuid
								+ "'><i class='iconfont icon-qingchu'></i>解除锁定</button></td></tr>"
						$("#tbody").append(str);
					}
				},
				error : function(data) {
				}
			});
}
