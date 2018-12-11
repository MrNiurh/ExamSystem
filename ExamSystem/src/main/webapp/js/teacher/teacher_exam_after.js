$(function() {
	$("#endTest").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 2
		}
		updateSignal(data);
	});
	$("#testClean").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 4
		}
		updateSignal(data);
	});

	$("#testDel").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 5
		}
		updateSignal(data);
	})

	$("#exportrecords_info").click(function() {
		$("#testClean").show();
	})
})

function updateSignal(data) {
	var URL = root + "/teacher/updateSignal"
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		dataType : 'json',
		async : true,
		success : function(data) {
			location.reload();
		},
		error : function(data) {
			alert("操作失败");
		}
	});

}
