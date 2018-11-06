$(function() {
	binduserchange();

	// 学生登录
	$("#s_submit").click(function() {
		var URL = root + "main/s_login";// 处理 ajax 请求的地址
		var HREF ="student/";// 成功的地址
		userLogin(URL,HREF);
	});
	// 教师登录
	$("#t_submit").click(function() {
		var URL = root + "main/t_login";
		var HREF ="teacher/";
		userLogin(URL,HREF);
	});
	// 管理员登录
	$("#a_submit").click(function() {
		var URL = root + "main/a_login";
		var HREF ="admin/";
		userLogin(URL,HREF);
	});

})

<!--  -->
function userLogin(URL,HREF) {
	var data = $(".login").serialize();
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		dataType : 'json',
		success : function(data) {
			if (data.check == "true") {
				window.location.href =abroot + HREF;
			} else {
				alert("用户名或口令输入错误");
			}
		},
		error : function(data) {
			alert("用户名或口令输入错误");
		}
	});
}

function binduserchange() {
	$(".userlogin").click(
			function() {

				$(this).parent().addClass("active").siblings().removeClass(
						("active"));
				$(this).css("color", "#0096DA").parent().siblings().children()
						.css("color", "black");
				var userid = $(this).attr("user")
				if (userid == "1") {
					$(".stucontent").removeClass("hide").siblings().addClass("hide");
					$(".userstu").parent().removeClass("hide")
				} else {
					$(".userinfo").addClass("hide")
					if (userid == "2") {
						$(".teacontent").removeClass("hide").siblings()
								.addClass("hide")
					} else {
						$(".admincontent").removeClass("hide").siblings()
								.addClass("hide")
					}
				}

			})
}