package com.ssm.sample.util;

/**
 * 权限处理
 * @author:administrator
*/
public class Jurisdiction {

	/**
	 * 访问权限及初始化按钮权限(控制按钮的显示)
	 * @param menuUrl  菜单路径
	 * @return
	 */
	public static boolean hasJurisdiction(String menuUrl){
		//判断是否拥有当前点击菜单的权限（内部过滤,防止通过url进入跳过菜单权限）
		/**
		 * 根据点击的菜单的xxx.do去菜单中的URL去匹配，当匹配到了此菜单，判断是否有此菜单的权限，没有的话跳转到404页面
		 * 根据按钮权限，授权按钮(当前点的菜单和角色中各按钮的权限匹对)
		 */
		//shiro管理的session
		/*Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		Boolean b = true;
		List<Menu> menuList = (List)session.getAttribute(Const.SESSION_allmenuList); //获取菜单列表
		
		for(int i=0;i<menuList.size();i++){
			for(int j=0;j<menuList.get(i).getSubMenu().size();j++){
				if(menuList.get(i).getSubMenu().get(j).getActionUrl().split(".do")[0].equals(menuUrl.split(".do")[0])){
					if(!menuList.get(i).getSubMenu().get(j).isHasMenu()){				//判断有无此菜单权限
						return false;
					}else{																//按钮判断
						Map<String, String> map = (Map<String, String>)session.getAttribute(Const.SESSION_QX);//按钮权限
						map.remove("add");
						map.remove("del");
						map.remove("edit");
						map.remove("cha");
						String MENU_ID =  String.valueOf(menuList.get(i).getSubMenu().get(j).getMenuId());
						String USERNAME = session.getAttribute(Const.SESSION_USERNAME).toString();	//获取当前登录者loginname
						Boolean isAdmin = "admin".equals(USERNAME);
						map.put("add", (RightsHelper.testRights(map.get("adds"), MENU_ID)) || isAdmin?"1":"0");
						map.put("del", RightsHelper.testRights(map.get("dels"), MENU_ID) || isAdmin?"1":"0");
						map.put("edit", RightsHelper.testRights(map.get("edits"), MENU_ID) || isAdmin?"1":"0");
						map.put("cha", RightsHelper.testRights(map.get("chas"), MENU_ID) || isAdmin?"1":"0");
						session.removeAttribute(Const.SESSION_QX);
						session.setAttribute(Const.SESSION_QX, map);	//重新分配按钮权限
					//}
				}
			}
		}*/
		/*System.out.println("in hasJurisdiction method menuUrl:"+menuUrl);
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		List<Menu> menuList = (List<Menu>)session.getAttribute(Const.SESSION_allPermissonMenuList);
		for(Menu parentMenu:menuList){
			String parentActionUrl = parentMenu.getActionUrl();
			if(parentActionUrl != null && parentActionUrl.equals(menuUrl)){
				return true;
			}
			List<Menu> subSenuList = parentMenu.getSubMenu();
            if(subSenuList != null && subSenuList.size()>0){
				for(Menu subMenu:subSenuList){
					String subActionUrl = subMenu.getActionUrl();
					if(subActionUrl != null && subActionUrl.equals(menuUrl)){
						return true;
					}
				}
			}
		}
		return false;*/
		return true;
	}
	
	/**
	 * 按钮权限(方法中校验)
	 * @param menuUrl  菜单路径
	 * @param type  类型(add、del、edit、cha)
	 * @return
	 */
	public static boolean buttonJurisdiction(String menuUrl, String type){
		//判断是否拥有当前点击菜单的权限（内部过滤,防止通过url进入跳过菜单权限）
		/**
		 * 根据点击的菜单的xxx.do去菜单中的URL去匹配，当匹配到了此菜单，判断是否有此菜单的权限，没有的话跳转到404页面
		 * 根据按钮权限，授权按钮(当前点的菜单和角色中各按钮的权限匹对)
		 */
		//shiro管理的session
		/*Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		Boolean b = true;
		List<Menu> menuList = (List)session.getAttribute(Const.SESSION_allmenuList); //获取菜单列表
		
		for(int i=0;i<menuList.size();i++){
			for(int j=0;j<menuList.get(i).getSubMenu().size();j++){
				if(menuList.get(i).getSubMenu().get(j).getActionUrl().split(".do")[0].equals(menuUrl.split(".do")[0])){
					if(!menuList.get(i).getSubMenu().get(j).isHasMenu()){				//判断有无此菜单权限
						return false;
					}else{																//按钮判断
						Map<String, String> map = (Map<String, String>)session.getAttribute(Const.SESSION_QX);//按钮权限
						String MENU_ID =  String.valueOf(menuList.get(i).getSubMenu().get(j).getMenuId());
						String USERNAME = session.getAttribute(Const.SESSION_USERNAME).toString();	//获取当前登录者loginname
						Boolean isAdmin = "admin".equals(USERNAME);
						if("add".equals(type)){
							return ((RightsHelper.testRights(map.get("adds"), MENU_ID)) || isAdmin);
						}else if("del".equals(type)){
							return ((RightsHelper.testRights(map.get("dels"), MENU_ID)) || isAdmin);
						}else if("edit".equals(type)){
							return ((RightsHelper.testRights(map.get("edits"), MENU_ID)) || isAdmin);
						}else if("cha".equals(type)){
							return ((RightsHelper.testRights(map.get("chas"), MENU_ID)) || isAdmin);
						}
					//}
				}
			}
		}*/
		/*Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		List<Menu> menuList = (List<Menu>)session.getAttribute(Const.SESSION_allPermissonMenuList);
		List<Func> funcList = (List<Func>)session.getAttribute(Const.SESSION_allPermissonFuncList);
		Boolean innerBreakFlag = false;
		Menu currentMenu = null;
		for(Menu parentMenu:menuList){
			String parentActionUrl = parentMenu.getActionUrl();
			if(parentActionUrl != null && parentActionUrl.equals(menuUrl)){
				currentMenu = parentMenu;
				break;
			}
			List<Menu> subSenuList = parentMenu.getSubMenu();
            if(subSenuList != null && subSenuList.size()>0){
				for(Menu subMenu:subSenuList){
					String subActionUrl = subMenu.getActionUrl();
					if(subActionUrl != null && subActionUrl.equals(menuUrl)){
						currentMenu = subMenu;
						innerBreakFlag = true;
					}
				}
				if(innerBreakFlag){
					break;
				}
			}
		}
		if(currentMenu != null){
			Long menuId = currentMenu.getMenuId();
			for(Func func:funcList){
				if(menuId == func.getMenuId() && func.getFuncName().equals(type)){
					return true;
				}
			}
		}
		return false;*/
		return true;
	}
	
	/**
	 * 按钮权限(方法中校验)
	 * @param funcCode  功能代码
	 * @return boolean
	 */
	/*public static boolean buttonJurisdiction(String funcCode){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		List<Func> funcList = (List<Func>)session.getAttribute(Const.SESSION_allPermissonFuncList);
		for(Func func:funcList){
			if(func.getFuncCode().equals(funcCode)){
				return true;
			}
		}
		return false;
	}*/
}
