package com.ssm.sample.util;

import java.util.Date;

public class Const {
	public static final String SESSION_PROJECT = "sessionProject";// 当前选择的项目信息
	public static final String SESSION_ENTERPRISE = "sessionEnterprise";// 当前选择的企业信息
	public static final String SESSION_SYSTEM_TYPE = "sessionSystemType";// 当前选择的企业信息

	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ENV = "env";
	public static final String SESSION_USER_ROLES = "session_user_roles";
	public static final String SESSION_USER_DEFAULT_ROLE = "session_user_default_role";

	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_menuList = "menuList"; // 当前菜单
	public static final String SESSION_allmenuList = "allmenuList"; // 全部菜单
	public static final String SESSION_userpds = "userpds";
	public static final String SESSION_USERROL = "USERROL"; // 用户对象
	public static final String SESSION_USERNAME = "USERNAME"; // 用户名
	public static final String SESSION_USERPHOTOS = "USERPHOTOS";// 用户头像
	public static final String SESSION_ALLPERMISSONMENULIST = "allPermissionMenuList"; // 全部菜单
	@SuppressWarnings("deprecation")
	public static final Date BOUNDARYDATE = new Date("2016/5/1"); // 时间界限
	public static final int REFRESHHOUR = 24; // 基础数据刷新时间
	/** 公共变量，用于判断字符串 1 */
	public static final String COMMON_CODE_YES = "1";
	/** 公共变量，用于判断字符串 0 */
	public static final String COMMON_CODE_NO = "0";

	public static final String CONST_000 = "000";
	public static final String CONST_111 = "111";
	public static final String CONST_999 = "999";

	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login"; // 登录地址
	public static final String LOGOUT = "/logout"; // 退出地址
	/* 数据库公共常量 */
	public static final int DB_COL_ENABLE = 1;
	public static final int DB_COL_DISABLE = 0;
	// 不对匹配该值的访问路径拦截（正则）
	public static final String NO_INTERCEPTOR_PATH = ".*/((assets)|(uploadfiles)|(login)|(doLogin)|(logout)|(code)|(static)).*|(.*\\.css$)|(.*\\.js$)|(.*\\.png$)|(.*\\.ico$)|(.*\\.jpg$)|(.*\\.svg$)|(.*\\.woff2$)|(.*\\.woff$)|(.*\\.ttf$)";

	public static final String SESSION_CLIENTHEIGHT = "clientHeight"; // 浏览器窗体高度
	public static final String SESSION_CLIENTWIDTH = "clientWidth"; // 浏览器窗体宽度
	public static final String SESSION_ORGORMALLNAME = "orgormallname"; // 浏览器窗体宽度
	public static final String SESSION_ONLYFORPAD = "onlyForPad"; // 仅使用在iPad标志

	/** 返回结果：success */
	public static final String CONST_RETURN_SUCCESS = "SUCCESS";
	/** 返回结果：error */
	public static final String CONST_RETURN_ERROR = "ERROR";
	/** 返回结果：result */
	public static final String CONST_RETURN_RESULT = "RESULT";
	/** 返回结果：syserr */
	public static final String CONST_RETURN_SYSERR = "SYSERR";
	/** 返回结果：MESSAGE */
	public static final String CONST_RETURN_MESSAGE = "MESSAGE";

	/** API返回的token标识符 */
	public static final String DEFAULT_TOKEN_NAME = "X-Token";
}
