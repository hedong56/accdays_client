/**
 * Create by hedong
 * Since 2013-7-27下午6:41:00
 */
package com.accdays.action.JSPTagAndFunction;

import org.springframework.stereotype.Controller;

/**
 * @author hedong
 * @date 2013-7-27 下午6:41:00
 * @modifyNote
 * @version 1.0
 */
@Controller("jspTagAndFunctionAction")
public class JSPTagAndFunctionAction {

	private Long id;
	public String jspTagFunction(){
		return "jspTagFunction";
	}
	
	/**
	 * 将字符中的html标签过滤掉
	 * @Description
	 * @author hedong
	 * @date 2013-8-4 下午11:22:21
	 * @modifyNote 
	 * @return
	 */
	public String filterHtml(){
		return "filterHtml";
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
