$(function(){
	//浏览器高度
	var height=$(window).height();
	$("body").css({height:1100});
});
/**
 * 鼠标滚动事件
 */
window.onscroll=function(){
	//获取滚动条到顶部的垂直高度
	var scrollTop=$(document).scrollTop();
	var formNum=$("form").length;
	var formHgt=$("form").height();
//	$("#back").css({top:scrollTop+226});
	//100指第一次要超过100才添加
	if(scrollTop>(100+(formNum-1)*formHgt)){
		$("body").append($("form:first").clone());
		var height=$("body").height();
		//增加body的高度使之能继续向下滚动；formHgt为被添加的高度
		$("body").css({height:height+formHgt});
		$(".weight:last").val(formNum+1);
	}
	
	//当向下滚动的高度大于当前个数+1时，表明才能够放下一个新元素，这是才添加一个新元素;而不是滚动的高度>元素高度就放；这样会放太多
//	if(scrollTop>=((formNum+1)*formHgt)){
//		$("body").append($("form:first").clone());
//		var height=$("body").height();
//		//增加body的高度使之能继续向下滚动；formHgt为被添加的高度
//		$("body").css({height:height+formHgt});
//		$(".weight:last").val(formNum+1);
//	}
	
};

/**
 * 回到顶部
 */
function backTop(){
	$(document).scrollTop(0);
}