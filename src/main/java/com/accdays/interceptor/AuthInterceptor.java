package com.accdays.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String preUrl=(String)session.getAttribute("userPreUrl");
		String s=request.getRequestURI();
		String islogon=(String)session.getAttribute("user");
		//如果用户"未登陆",直接访问未授权地址,记录下用户的访问地址,并跳转到登陆页面
		if((!s.equals("/accdays/accumulation/pointLists"))&&StringUtils.isBlank(islogon)){
			preUrl=request.getRequestURL().toString();
			String queryString=request.getQueryString();
			preUrl+="?";
			preUrl+=queryString;
			session.setAttribute("userPreUrl", preUrl);
			return Action.LOGIN;
		}
		return invocation.invoke();//如果存在下一个拦截器，就调用下一个拦截器，如果不存在，就带哦用action
	}

}
