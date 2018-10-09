<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>界面要素示例</title>
<script type="text/javascript" src="<%=path%>/js/sample/sample2.js?uuid="${uuid}></script>
<script type="text/javascript">
	$(function() {
		laydate.render({
			elem : '#testDate1',
			type : 'month',
			format : 'yyyy.MM'
		});
		laydate.render({
			elem : '#testDate2',
			format : 'yyyy.MM.dd'
		});
		laydate.render({
			elem : '#testDate3',
			type : 'datetime',
			format : 'yyyy.MM.dd HH:mm:ss'
		});
		laydate.render({
			elem : '#testDate4',
			format : 'yyyy.MM.dd',
			range : '-',
			done : function(value, date, endDate) {
				debugger;
			}
		});
	})
</script>
</head>
<body>
	<div style="padding-bottom: 130px; padding-top: 20px;">
		<div class="row">
			<div class="col-md-2">日期控件(参考链接：http://www.layui.com/laydate/)</div>
			<div class="col-md-1">
				<div class="ui-input-text">
					<input readonly id="testDate1" name="testDate1" class="form-control" placeholder="YYYY.MM" /><i class="hbvat-icon hbvat-icon-rili"></i>
				</div>
			</div>
			<div class="col-md-1">
				<div class="ui-input-text">
					<input readonly id="testDate2" name="testDate2" class="form-control" placeholder="YYYY.MM.DD" /><i class="hbvat-icon hbvat-icon-rili"></i>
				</div>
			</div>
			<div class="col-md-2">
				<div class="ui-input-text">
					<input readonly id="testDate3" name="testDate3" class="form-control" placeholder="YYYY.MM.DD hh:mm:ss" /><i class="hbvat-icon hbvat-icon-rili"></i>
				</div>
			</div>
			<div class="col-md-2">
				<div class="ui-input-text">
					<input readonly id="testDate4" name="testDate4" class="form-control" placeholder="YYYY.MM.DD-YYYY.MM.DD" /> <i class="hbvat-icon hbvat-icon-rili"></i>
				</div>
			</div>
		</div>
		<div class="form-horizontal">
			<div class="block-level-2">
				<div class="row">
					<div class="col-md-4">
						<label class="col-md-5 control-label">项目编号</label>
						<div class="col-md-7 ui-input-text">A01-00041</div>
					</div>
					<div class="col-md-4">
						<label class="col-md-5 control-label">项目名称</label>
						<div class="col-md-7 ui-input-text">升龙又一城</div>
					</div>
					<div class="col-md-4">
						<label class="col-md-5 control-label">可售面积</label>
						<div class="col-md-7 ui-input-text">133</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<label class="col-md-5 control-label">项目编号</label>
						<div class="col-md-7 ui-input-text">A01-00041</div>
					</div>
					<div class="col-md-4">
						<label class="col-md-5 control-label">项目名称</label>
						<div class="col-md-7 ui-input-text">升龙又一城</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<label class="col-md-3 control-label">项目编号</label>
						<div class="col-md-7 ui-input-text">A01-00041</div>
					</div>
					<div class="col-md-6">
						<label class="col-md-3 control-label">项目名称</label>
						<div class="col-md-7 ui-input-text">升龙又一城</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<label class="col-md-3 control-label">项目编号</label>
						<div class="col-md-7 ui-input-text">
							<input type="text" class="form-control" placeholder="项目编号">
						</div>
					</div>
					<div class="col-md-6">
						<label class="col-md-3 control-label">项目名称</label>
						<div class="col-md-7 ui-input-text">
							<select class="form-control">
								<option value="">全部</option>
								<option value="">1222</option>
								<option value="">2222</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<label class="col-md-3 control-label">建筑面积</label>
						<div class="col-md-7 ui-input-text">
							<input type="text" class="form-control" placeholder="项目编号"> <span>m²</span>
						</div>
					</div>
					<div class="col-md-6">
						<label class="col-md-3 control-label">项目名称</label>
						<div class="col-md-7 ui-input-text"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">图标选择控件</div>
			<div class="col-md-5">
				<div class="ui-input-text">
					<input id="" type="text" value="" name="" class="ui-
from-imput form-control"> <i class="hbvat-icon hbvat-icon-sousuo"></i>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">按钮组</div>
			<div class="col-md-10">
				<div class="btn-md-group">
					<button type="button" class="btn btn-df btn-default">取消</button>
					<button type="button" class="btn btn-df btn-success">登录</button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">中等button</div>
			<div class="col-md-10">
				<button type="button" class="btn btn-md btn-success">
					<span class="bold">登录</span>
				</button>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">默认button</div>
			<div class="col-md-10">
				<button type="button" class="btn btn-df btn-success">
					<i class="fa fa-pencil"></i> <span class="bold">编辑</span>
				</button>
				<button type="button" class="btn btn-df btn-success">
					<i class="fa fa-plus"></i><span class="bold">添加</span>
				</button>
				<button type="button" class="btn btn-df btn-success">
					<span class="bold">联合汇算</span>
				</button>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">大button</div>
			<div class="col-md-10">
				<button type="button" class="btn btn-lg btn-success">
					<span class="bold">清算列表</span>
				</button>
				<button type="button" class="btn btn-lg btn-success">
					<span class="bold">项目分期清算状态图</span>
				</button>
				<button type="button" class="btn btn-lg btn-success">
					<span class="bold">项目清算状态图</span>
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">小button</div>
			<div class="col-md-10">
				<button type="button" class="btn btn-sm btn-warning">
					<span class="bold">项目详情</span>
				</button>
				<button type="button" class="btn btn-sm btn-warning">
					<span class="bold">清算列表</span><i class="fa fa-angle-right"></i>
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">极小button</div>
			<div class="col-md-10">
				<button type="button" class="btn btn-xs btn-primary">
					<span class="bold">汇算进度</span>
				</button>
				<button type="button" class="btn btn-xs btn-warning">
					<span class="bold">结果查看</span>
				</button>
				<button type="button" class="btn btn-xs btn-info">
					<span class="bold">详情</span>
				</button>
			</div>
		</div>

		<div class="row">
			<label class="col-md-2 control-label">单选框</label>
			<div class="col-md-10 ui-input-text">
				<input type="radio" class="regular-radio" id="LR1" name="onename"> <label for="LR1" class="title-label-level-4"></label> <label class="ui-check-label">a</label>&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="radio" class="regular-radio" id="LR2" name="onename"> <label for="LR2" class="title-label-level-4"></label> <label class="ui-check-label">b</label>
			</div>
		</div>
		<div class="row">
			<label class="col-md-2 control-label">复选框</label>
			<div class="col-md-10 ui-input-text">
				<input type="checkbox" class="regular-checkbox" id="LR3"> <label for="LR3" class="title-label-level-4"></label> <label class="ui-check-label">a</label>&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="checkbox" class="regular-checkbox" id="LR4"> <label for="LR4" class="title-label-level-4"></label> <label class="ui-check-label">b</label>
			</div>
		</div>
		<hr align=center width="100%" style="color: #ffffff; height: 0px; margin: 0px; padding: 0px; border: 0px;">
		<div class="row">
			<div class="col-md-2">虚线</div>
			<div class="col-md-10">
				<div class="ui-hr-dotted"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">实线</div>
			<div class="col-md-10">
				<div class="ui-hr-solid"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">表格</div>
			<div class="col-md-10">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th width="10%" style="text-align: center;">序号</th>
							<th>开发期间</th>
							<th>开发期间</th>
							<th>开发期间</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">1</td>
							<td>S001-A01-00041</td>
							<td>S001-A01-00041</td>
							<td>S001-A01-00041</td>
						</tr>
						<tr>
							<td align="center">2</td>
							<td>S001-A01-00041</td>
							<td>S001-A01-00041</td>
							<td>S001-A01-00041</td>
						</tr>
						<tr>
							<td align="center">3</td>
							<td>S001-A01-00041</td>
							<td>S001-A01-00041</td>
							<td>S001-A01-00041</td>
						</tr>
					</tbody>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">弹窗</div>
			<div class="col-md-10">
				<button id="btnMsg" name="btnMsg" type="button" class="btn btn-df btn-success">
					<span class="bold">提示</span>
				</button>
				<button id="btnAlert" name="btnAlert" type="button" class="btn btn-df btn-success">
					<span class="bold">弹框</span>
				</button>
				<button id="btnLoad" name="btnLoad" type="button" class="btn btn-df btn-success">
					<span class="bold">等待</span>
				</button>
				<button id="btnConfirm" name="btnConfirm" type="button" class="btn btn-df btn-success">
					<span class="bold">确认</span>
				</button>
				<button id="btnOpen" name="btnOpen" type="button" class="btn btn-df btn-success">
					<span class="bold">弹窗</span>
				</button>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">点击提示</div>
			<div class="col-md-10">
				<button type="button" class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="left" data-content="这里是提示内容" data-original-title="" title="">左侧提示</button>
				<button type="button" class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="top" data-content="这里是提示内容" data-original-title="" title="">顶部提示</button>
				<button type="button" class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="bottom" data-content="这里是提示内容" data-original-title="" title="">底部提示</button>
				<button type="button" class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="right" data-content="这里是提示内容" data-original-title="" title="">右侧提示</button>
			</div>
		</div>
	</div>
</body>
