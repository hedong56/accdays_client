/**
 * 类级别的插件开发(相当于对jQuery进行扩展)
 * hdPlugs是命名空间
 * 自定义插件
 */
var $dialog;

(function($){
	
	/**
	 * hdPlugs为命名空间(全局对象)
	 * 添加全局方法
	 */
	$.hdPlugs={
			
		/**自定义插件函数*/
		popupWin:function(options){//options用户传入参数
			
			//弹出窗口默认配置
			var defaults={
				src:"http://www.baidu.com",
				dialogConfig:{
					title:"弹出窗口",
					minWidth:600,
					minHeight:400,
					modal: true,
					loadSuccess:function($dialogDiv){
						$dialog=$dialogDiv;
					}
				}
			};
			
			/**
			 * true 表示深度合并,将对象中的子对象也"合并";false 子对象不会合并而是后面的"覆盖"前面的,
			 * 合并参数
			 */
			var opts = $.extend(true,{},defaults, options);
			//得到弹出窗口的html(注意：调用本对象方法时“必须”用"this"关键字，否则会报错，找不到这个方法)
			var windowHtml=this.getPopupWinHtml(opts.src);
			$("#dialog-message").remove();
			$("body").append(windowHtml);
			
			//初始化弹出窗口
			this.init_popupWin(opts.dialogConfig);
			
			//返回弹出框对象
			return $("#dialog-message");
			
		},

		/**
		 * 初始化弹出窗口
		 */
		init_popupWin:function(dialogConfig){
			$( "#dialog-message" ).dialog(dialogConfig);
		},
		/**
		 * 得到弹出窗口的html
		 * @param src 弹出窗口请求地址(用户请求地址)
		 * @returns {String}
		 */
		getPopupWinHtml:function(src){
			return "<div id='dialog-message' title='Download complete' name='iframe'>"+
						//如果不用iframe,可以用$("#div").load();来替代
						"<iframe id='dialog-message-iframe' src='"+src+"' width='100%' height='100%'></iframe>"+
					"</div>";
		}
	
	};
})(jQuery);


