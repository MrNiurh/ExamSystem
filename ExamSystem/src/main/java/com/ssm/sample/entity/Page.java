package com.ssm.sample.entity;

import com.ssm.sample.util.PageData;

public class Page {

	private int defaultShowCount = 10;// 默认每页显示10条
	private int showCount; // 每页显示记录数
	private int totalPage; // 总页数
	private int totalResult; // 总记录数
	private int currentPage; // 当前页
	private int currentResult; // 当前记录起始索引
	private boolean entityOrField; // true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private String pageStr; // 最终页面显示的底部翻页导航，详细见：getPageStr();
	private String pageStrPart2;// 每页显示多少行的部分，详细见：getPageStrPart2();
	private PageData pd = new PageData();

	public Page() {
		try {
			this.showCount = defaultShowCount;
		} catch (Exception e) {
			// TODO: handle exception
			this.showCount = 10;
		}

	}

	public int getTotalPage() {
		if (totalResult % showCount == 0)
			totalPage = totalResult / showCount;
		else
			totalPage = totalResult / showCount + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageStr() {
		StringBuffer sb = new StringBuffer();
		if (totalResult > 0) {
			sb.append("	<ul class=\"pagination pagination-sm pull-right\" style=\"margin-top:0\">\n");
			if (currentPage == 1) {
				// sb.append(" <li><a>共<font
				// color=red>"+totalResult+"</font>条</a></li>\n");
				// sb.append(" <li><input type=\"number\" value=\"\"
				// id=\"toGoPage\"
				// style=\"width:50px;text-align:center;float:left\"
				// placeholder=\"页码\"/></li>\n");
				// sb.append(" <li style=\"cursor:pointer;\"><a
				// onclick=\"toTZ();\" class=\"btn btn-mini
				// btn-success\">跳转</a></li>\n");
				sb.append("	<li class=\"disabled\"><a><i class=\"fa fa-step-backward\"></i></a></li>\n");
				sb.append("	<li class=\"disabled\"><a><i class=\"fa fa-caret-left\" style=\"font-size: 18px;\"></i></a></li>\n");
			} else {
				// sb.append(" <li><a>共<font
				// color=red>"+totalResult+"</font>条</a></li>\n");
				// sb.append(" <li><input type=\"number\" value=\"\"
				// id=\"toGoPage\"
				// style=\"width:50px;text-align:center;float:left\"
				// placeholder=\"页码\"/></li>\n");
				// sb.append(" <li style=\"cursor:pointer;\"><a
				// onclick=\"toTZ();\" class=\"btn btn-mini
				// btn-success\">跳转</a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(1)\"><i class=\"fa fa-step-backward\"></i></a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + (currentPage - 1) + ")\"><i class=\"fa fa-caret-left\" style=\"font-size: 18px;\"></i></a></li>\n");
			}
			int showTag = 5;// 分页标签显示数量
			int startTag = 1;
			if (currentPage > showTag) {
				startTag = currentPage - 1;
			}
			int endTag = startTag + showTag - 1;
			for (int i = startTag; i <= totalPage && i <= endTag; i++) {
				if (currentPage == i)
					sb.append("<li><a class=\"active\">" + i + "</font></a></li>\n");
				else
					sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + i + ")\">" + i + "</a></li>\n");
			}
			if (currentPage == totalPage) {
				sb.append("	<li class=\"disabled\"><a><i class=\"fa fa-caret-right\" style=\"font-size: 18px;\"></i></a></li>\n");
				sb.append("	<li class=\"disabled\"><a><i class=\"fa fa-step-forward\"></i></a></li>\n");
			} else {
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + (currentPage + 1) + ")\"><i class=\"fa fa-caret-right\" style=\"font-size: 18px;\"></i></a></li>\n");
				sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + totalPage + ")\"><i class=\"fa fa-step-forward\"></i></a></li>\n");
			}
			sb.append("	<li><a style=\"border: none;color: #bbbbbb;\">共" + totalPage + "页&nbsp; &nbsp; <span style=\"color: #000000;\">跳转到</span></a></li>\n");
			sb.append(" <li><input type=\"number\" id=\"toGoPage\" min=\"1\" max=\"" + totalPage + "\" style=\"text-align:left;float:left\" placeholder=\"页码\" value=\"" + currentPage + "\"/></li>\n");
			// sb.append(" <li><a style=\"border: none;background-color:
			// #eee;margin-left: 0px;\">页</a></li>\n");
			sb.append(" <li><button onclick=\"toTZ();\">确定</button></li>\n");

			sb.append("</ul>\n");
			sb.append("<script type=\"text/javascript\">\n");

			// 换页函数
			sb.append("function nextPage(page){\n");
			sb.append(" //top.jzts();\n");
			sb.append("debugger;");
			sb.append("	if(true && document.forms[0]){\n");
			// sb.append(" var url =
			// document.forms[0].getAttribute(\"action\");\n");
			sb.append("     var url = $(\"form[dt='pageform']\").attr(\"action\");\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
			sb.append("		else{url += \"?" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
			sb.append("		url = url + page + \"&" + (entityOrField ? "showCount" : "page.showCount") + "=" + showCount + "\";\n");
			// sb.append(" document.forms[0].action = url;\n");
			sb.append("     $(\"form[dt='pageform']\").attr(\"action\",url);\n");
			// sb.append(" document.forms[0].submit();\n");
			sb.append("     $(\"form[dt='pageform']\").submit();\n");
			sb.append("	}else{\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
			sb.append("		url = url + page + \"&" + (entityOrField ? "showCount" : "page.showCount") + "=" + showCount + "\";\n");
			sb.append("		document.location = url;\n");
			sb.append("	}\n");
			sb.append("}\n");

			// 调整每页显示条数
			sb.append("function changeCount(value){\n");
			sb.append(" //top.jzts();\n");
			sb.append("	if(true && document.forms[0]){\n");
			// sb.append(" var url =
			// document.forms[0].getAttribute(\"action\");\n");
			sb.append("     var url = $(\"form[dt='pageform']\").attr(\"action\");\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
			sb.append("		else{url += \"?" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
			sb.append("		url = url + \"1&" + (entityOrField ? "showCount" : "page.showCount") + "=\"+value;\n");
			// sb.append(" document.forms[0].action = url;\n");
			sb.append("     $(\"form[dt='pageform']\").attr(\"action\",url);\n");
			// sb.append(" document.forms[0].submit();\n");
			sb.append("     $(\"form[dt='pageform']\").submit();\n");
			sb.append("	}else{\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"1&" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?" + (entityOrField ? "currentPage" : "page.currentPage") + "=\";}\n");
			sb.append("		url = url + \"&" + (entityOrField ? "showCount" : "page.showCount") + "=\"+value;\n");
			sb.append("		document.location = url;\n");
			sb.append("	}\n");
			sb.append("}\n");

			// 跳转函数
			sb.append("function toTZ(){\n");
			sb.append("var toPaggeVlue = document.getElementById(\"toGoPage\").value;\n");
			sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage\").value=1;return;}\n");
			sb.append("if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage\").value=1;return;}\n");
			sb.append("nextPage(toPaggeVlue);\n");
			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}

	public String getPageStrPart2() {
		String unselectedTemp = "<option value='%d'>%d</option>\n";
		String selectedTemp = "<option value='%d' selected='selected'>%d</option>\n";
		Integer[] pgcnt = { 10, 50, 100 };

		StringBuffer sb = new StringBuffer();
		sb.append("<label>每页显示：</label>");
		sb.append("<select style=\"width:55px;\" onchange=\"changeCount(this.value)\">\n");

		for (int i = 0; i < pgcnt.length; i++) {
			if (pgcnt[i] == showCount) {
				sb.append(String.format(selectedTemp, pgcnt[i], pgcnt[i]));
			} else {
				sb.append(String.format(unselectedTemp, pgcnt[i], pgcnt[i]));
			}
		}
		sb.append("</select>\n");

		pageStrPart2 = sb.toString();
		return pageStrPart2;
	}

	/**
	 * @param pageStrPart2
	 *            the pageStrPart2 to set
	 */
	public void setPageStrPart2(String pageStrPart2) {
		this.pageStrPart2 = pageStrPart2;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {

		this.showCount = showCount;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getShowCount();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public boolean isEntityOrField() {
		return entityOrField;
	}

	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	public PageData getPd() {
		return pd;
	}

	public void setPd(PageData pd) {
		this.pd = pd;
	}

}
