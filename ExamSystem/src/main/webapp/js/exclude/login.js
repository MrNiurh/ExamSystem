$(function () {
	binduserchange();
})

function binduserchange() {
	$(".userlogin").click(function () {

		$(this).parent().addClass("active").siblings().removeClass(("active"));
		$(this).css("color","#0096DA").parent().siblings().children().css("color","black");
		var userid=$(this).attr("user")

		

		if(userid=="1"){
			$(".userstu").removeClass("hide").siblings().addClass("hide");
			$(".userstu").parent().removeClass("hide")
		}
		else{
			$(".userinfo").addClass("hide")
			if(userid=="2"){
				$(".teacontent").removeClass("hide").siblings().addClass("hide")
			}
			else
			{
				$(".admincontent").removeClass("hide").siblings().addClass("hide")
			}
		}


    })
}