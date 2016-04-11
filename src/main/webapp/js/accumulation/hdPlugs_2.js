/**
 * 类级别的插件开发(相当于对jQuery进行扩展)
 * hdPlugs是命名空间
 * 自定义插件
 */
(function($){
	
	/**自定义插件函数*/
	$.fn.popupWin=function(options){
		
		return $(this).each(function(){
			//弹出窗口默认配置
			var defaults={
				title:"窗口",
				src:"http://www.baidu.com",
				buttons:{
					确定: function() {
						alert('ok');
						$( this ).dialog( 'close' );
					},
					取消: function() {
						alert('cancel');
						$( this ).dialog( 'close' );
					}
			    }
			};
			//合并参数
			var opts = $.extend(defaults, options);
			//得到弹出窗口的html
			var windowHtml=getPopupWinHtml(opts.src);
			
			$("body").append(windowHtml);
			
			//初始化弹出窗口
			init_popupWin(opts);
		});
	};
	
	/**
	 * 初始化弹出窗口
	 */
	function init_popupWin(opts){
		$( "#dialog-message" ).dialog({
			title:opts.title,
			minWidth:600,
			minHeight:400,
			modal: true,
			buttons: opts.buttons,
			close:function(){
				alert("close");
			}
		});
	}
})(jQuery);




/**
 * 得到弹出窗口的html
 * @param src 弹出窗口请求地址(用户请求地址)
 * @returns {String}
 */
function getPopupWinHtml(src){
	return "<div id='dialog-message' title='Download complete'>"+
				//如果不用iframe,可以用$("#div").load();来替代
				"<iframe src='"+src+"' width='100%' height='100%'></iframe>"+
			"</div>";
}