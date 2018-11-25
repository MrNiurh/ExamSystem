<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>考后操作</title>
<script type="text/javascript"
	src="<%=path%>/js/teacher/teacher_exam_after.js"></script>
</head>
<div class="layui-main">
	<div class="bighat">
		<div class="tecicon">
			<img style="width: 80px; height: 80px;"
				src="<%=path%>/assets/imgs/teacher.jpg" />
		</div>
		<h2>上机考试管理</h2>
	</div>
	<div>
		<table class="layui-table">
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="9%">
				<col width="10%">
				<col width="9%">
				<col width="6%">
				<col width="6%">
				<col width="6%">
				<col width="6%">
				<col width="18%">
			</colgroup>
			<tr class="tablectrl">
				<td>考试名称</td>
				<td>考试时间</td>
				<td>创建人</td>
				<td>上传试卷</td>
				<td>自动开始</td>
				<td>进行中</td>
				<td>已结束</td>
				<td>已归档</td>
				<td>已清理</td>
				<td></td>
			</tr>
			<c:forEach items="${afterTests}" var="test">
				<tr>
					<td>${test.get('testname')}</td>
					<td>${test.get('starttime')}</td>
					<td>${test.get('teacherName')}</td>
					<!-- 上传试卷 -->
					<td><c:if test="${test.get('submit') != null }">
						试卷已上传
					</c:if></td>
					<!-- 自动开始 -->
					<c:if test="${test.get('auto_begin') == 0 }">
						<td>X</td>
					</c:if>
					<c:if test="${test.get('auto_begin') == 1 }">
						<td>√</td>
					</c:if>
					<!-- 进行中 -->
					<c:if test="${test.get('test_signal') == 0 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') == 1 }">
						<td>√</td>
					</c:if>
					<c:if test="${test.get('test_signal') > 1 }">
						<td>X</td>
					</c:if>
					<!-- 已结束 -->
					<c:if test="${test.get('test_signal') < 2 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') >= 2 }">
						<td>√</td>
					</c:if>
					<!-- 已归档 -->
					<c:if test="${test.get('test_signal') < 3 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') >= 3 }">
						<td>√</td>
					</c:if>
					<!-- 已清理 -->
					<c:if test="${test.get('test_signal') < 4 }">
						<td></td>
					</c:if>
					<c:if test="${test.get('test_signal') >= 4 }">
						<td>√</td>
					</c:if>
					<!-- 编辑 -->
					<td><c:if test="${test.get('test_signal')==1}">
							<button class="btn btn-primary" name="${test.get('testid')}"
								id="endTest">
								<i style="color: black" class="iconfont icon-tuichu"></i>结束考试
							</button>
						</c:if> <c:if
							test="${test.get('test_signal')==2 || test.get('test_signal')==3}">
							<a class="test_after_op btn btn-default" id="downloadInfo"
								onclick="fresh()" href="downZip?testid=${test.get('testid')}"
								title="打包下载"><img src="<%=path%>/assets/imgs/download.png"
								class="test_afterlogos" alt=""></a>
							<a class="test_after_op  btn btn-default" id="exportrecords_info"
								href="excelExport?testid=${test.get('testid')}" title="导出提交记录"><img
								src="<%=path%>/assets/imgs/export_record.png"
								class="test_afterlogos" alt=""></a>
						</c:if> <c:if test="${test.get('test_signal')==3}">
							<c:if test="${ifadmin != 0 || clear !=0}">
								<button class="test_after_op  btn btn-default " id="testClean"
									name="${test.get('testid')}">
									<img src="<%=path%>/assets/imgs/clean_tests.png"
										class="test_afterlogos" alt="">清理
								</button>
							</c:if>
						</c:if> <c:if test="${test.get('test_signal')==4}">
							<c:if test="${ifadmin != 0 || clear !=0}">
								<button class="test_del   btn btn-danger" id="testDel"
									name="${test.get('testid')}">
									<img src="<%=path%>/assets/imgs/clean_tests.png"
										class="test_afterlogos" alt="">删除
								</button>
							</c:if>
						</c:if> <input type="hidden" name="testid" value="${test.get('testid')}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
