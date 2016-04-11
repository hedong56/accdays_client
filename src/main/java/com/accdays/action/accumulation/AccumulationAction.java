package com.accdays.action.accumulation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.accdays.model.User;
import com.accdays.service.accumulation.IAccumulationService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("accumulationAction")
public class AccumulationAction extends ActionSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private IAccumulationService accumulationService;
	
	
	/**
	 * 进入知识点页面(相当于登陆成功后，正常跳转的页面)
	 * @Description
	 * @author hedong
	 * @date 2013-7-1 下午8:57:22
	 * @modifyNote 
	 * @return
	 */
	private String redirectUrl;
	public String pointLists(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("user", "login");
		/** 设置session的有效期，单位秒s;在有效期内访问后，将重新开始计算有效时间 */
		session.setMaxInactiveInterval(30*60);
		
		//如果用户登陆成功，且存在上次未登录的请求URL，则跳转到上次的URL
		String preUrl=(String)session.getAttribute("userPreUrl");
		if(StringUtils.isNotBlank(preUrl)){
			redirectUrl=preUrl;
			session.removeAttribute("userPreUrl");
			return "redirectUrl";
		}
		return "pointLists";
	}
	
	/**
	 * 进入字符串参数拼接页面
	 * @Description
	 * @author hedong
	 * @date 2013-7-1 下午8:57:49
	 * @modifyNote 
	 * @return
	 */
	public String charParams(){
		return "charParams";
	}
	
	/**
	 * 进入动态加载页面
	 * @Description
	 * @author hedong
	 * @date 2013-7-2 下午9:17:11
	 * @modifyNote 
	 * @return
	 */
	public String dynamicLading(){
		return "dynamicLading";
	}
	
	/**
	 * URL参数验证
	 * @Description
	 * @author hedong
	 * @date 2013-7-18 下午8:39:35
	 * @modifyNote 
	 * @return
	 */
	public String urlParaValidation(){
		return "urlParaValidation";
	}
	
	/**
	 * 根据用户ID查询用户信息
	 * @Description
	 * @author hedong
	 * @date 2013-7-18 下午8:49:45
	 * @modifyNote 
	 * @return
	 */
	private Long id;
	private User userInfo;
	
	
	/**
	 * flash视频播放
	 * @Description
	 * @author hedong
	 * @date 2013-7-28 下午3:02:48
	 * @modifyNote 
	 * @return
	 */
	public String vedioPlayer(){
		return "vedioPlayer";
	}
	
	
	
	private String name;
	private List<User> users;
	public String rmiAccess(){
		try {
			users=accumulationService.findUserByName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rmiAccess";
	}
	
	public String popupwindow(){
		return "popupwindow";
	}
	
	public String popupwindowCheckUser(){
		return "popupwindowCheckUser";
	}

	/**
	 * @Description
	 * @author hedong
	 * @date 2013-8-11 下午5:15:08
	 * @modifyNote 
	 * @return
	 */
	public String iframeAndFrame(){
		return "iframeAndFrame";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the redirectUrl
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * @param redirectUrl the redirectUrl to set
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
