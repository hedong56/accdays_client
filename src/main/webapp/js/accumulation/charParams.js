$(function(){
	
});

/**
 * 添加用户信息
 */
function addPersonInfo() {
	var personInfo=$(".roundCorderC:first").clone();
	
	//去掉用户已经输入的值
	personInfo.find("input").each(function(){
		$(this).val(null);
		this.checked=false;
	});
	
	$("form").append(personInfo);
}