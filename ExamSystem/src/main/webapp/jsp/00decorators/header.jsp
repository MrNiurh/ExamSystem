<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		//关闭切换企业浮动框
		$("#closeSwitchEnterprise").click(function() {
			$("#divSwitchEnterprise").hide();
		})
		//打开切换企业浮动框
		$("#openSwitchEnterprise").click(
				function() {
					/* if ($('#divSwitchEnterprise').css("display") == "none") {
					            $('#iframeSwitchEnterprise').attr('src',
					                    '/prePageFrame/switchEnterprise');
					        } */
					if (!$('#iframeSwitchEnterprise').attr('src')) {
						$('#iframeSwitchEnterprise').attr('src',
								'/prePageFrame/switchEnterprise');
					}
					$("#divSwitchEnterprise").toggle();
				})
	})
	// 丁 2018-03-29添加 系统设置弹窗
	function switchSystembase() {
		window.parent.layer.open({
			type : 2,
			title : '系统设置',
			shadeClose : true,
			shade : 0.6,
			scrollbar : false,
			area : [ '1500px',"650px" ],
			content :"/addFrame/systemlist"
		});
	}
</script>
<!-- 选择一个企业提交数据 -->
<form id="formChooseOne" name="formChooseOne" action="/prePage/chooseOneEnterprise" method="post">
	<input id="chooseOne" name="chooseOne" type="hidden"></input>
</form>
<div class="div-table" style="margin-left: 14px;">
	<div class="div-table-cell">
		<img src="/assets/imgs/main-logo.png">
	</div>
</div>
<div class="div-table" style="margin: 0 10px 0 64px;">
	<div class="div-table-cell">
		<div class="div-company-logo" style="background-image: url(${sessionEnterprise.entlogo});"></div>
	</div>
</div>
<div class="div-table" style="margin-right: 10px;">
	<div class="div-table-cell" style="text-align: left;">
		<div style="font-size: 16px; color: #FFFFFF;">${sessionEnterprise.entname}</div>
		<!-- 只有事务所版有切换企业操作 -->		
		<c:if test="${sessionSystemType eq currentSystemType}">
			<div style="font-size: 16px; color: #FFFFFF; margin-top: 18px;">
				<button id="openSwitchEnterprise" name="openSwitchEnterprise" class="btn btn btn-xs btn-warning"">
					切换企业 <i class="hbvat-icon hbvat-icon-angle-down" style="font-size: 12px;"></i>
				</button>
			</div>
		</c:if>
	</div>
</div>
<ul>
	<c:choose>
		<c:when test="${not empty allPermissionMenuList}">
			<c:forEach items="${allPermissionMenuList}" var="var" varStatus="vs">
				<li><a href="${var.actionurl}"><div class="divMenuOuter">
							<i class="hbvat-icon hbvat-icon-${var.icon}"></i>
							<div>${var.menuname}</div>
						</div></a></li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<li><a href="/enterprise/index"><div class="divMenuOuter">
						<i class="hbvat-icon hbvat-icon-weihu"></i>
						<div>企业中心</div>
					</div></a></li>
			<li><a href=""><div class="divMenuOuter">
						<i class="hbvat-icon hbvat-icon-zhuangtaitu"></i>
						<div>企业状态图</div>
					</div></a></li>
			<li><a href=""><div class="divMenuOuter">
						<i class="hbvat-icon hbvat-icon-qingsuantu"></i>
						<div>企业清算图</div>
					</div></a></li>
			<li><a href="/project/index"><div class="divMenuOuter">
						<i class="hbvat-icon hbvat-icon-guangli"></i>
						<div>项目管理</div>
					</div></a></li>
			<li><a href="javascript:switchSystembase();"><div class="divMenuOuter">
						<i class="hbvat-icon hbvat-icon-shezhi"></i>
						<div>系统设置</div>
					</div></a></li>
		</c:otherwise>
	</c:choose>
	<li><a href="javascript:switchSystembase();"><div class="divMenuOuter">
		<i   class="hbvat-icon hbvat-icon-shezhi"></i>
		<div>系统设置</div>
	</div></a></li>
</ul>

<ul style="float: right;">
	<li><a href=""><div class="divMenuOuter">
				<i class="hbvat-icon hbvat-icon-wode"></i>
				<div>${sessionUser.username}</div>
			</div></a></li>
	<li><a href="/logout"><div class="divMenuOuter">
				<i class="hbvat-icon hbvat-icon-tuichu"></i>
				<div>系统退出</div>
			</div></a></li>
</ul>
<div id="divSwitchEnterprise" name="divSwitchEnterprise">
	<div class="divTriangle"></div>
	<div id="closeSwitchEnterprise" name="closeSwitchEnterprise">
		<i class="hbvat-icon hbvat-icon-gb-1" style="font-size: 20px; color: white;"></i>
	</div>
	<iframe id="iframeSwitchEnterprise" name="iframeSwitchEnterprise" style="border: 2px; width: 100%; height: 100%;"> </iframe>
</div>