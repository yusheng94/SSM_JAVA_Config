/*
**	Anderson Ferminiano
**	contato@andersonferminiano.com -- feel free to contact me for bugs or new implementations.
**	jQuery ScrollPagination
**	http://www.sucaijiayuan.com
**	You may use this script for free, but keep my credits.
**	Thank you.
*/

(function( $ ){
	 
		 
 $.fn.scrollPagination = function(options) {
  	
		var opts = $.extend($.fn.scrollPagination.defaults, options);  
		var target = opts.scrollTarget;
		if (target == null){
			target = obj; 
	 	}
		opts.scrollTarget = target;
	 
		return this.each(function() {
		  $.fn.scrollPagination.init($(this), opts);
		});

  };
  
  $.fn.stopScrollPagination = function(){
	  return this.each(function() {
	 	$(this).attr('scrollPagination', 'disabled');
	  });
	  
  };
  var currPage=0
  var size=0;
  $.fn.scrollPagination.loadContent = function(obj, opts){
	 var target = opts.scrollTarget;
	 var mayLoadContent = $(target).scrollTop()+opts.heightOffset >= $(document).height() - $(target).height();
	
	 if (mayLoadContent && opts.lock){
		 if (opts.beforeLoad != null){
			opts.beforeLoad(); 
		 }
		 opts.lock = false;
		 $(obj).children().attr('rel', 'loaded');
		 if(size==0){
			 $.ajax({
				  type: 'POST',
				  url: opts.contentPage+currPage,
				  data: opts.contentData,
				  success: function(data){
					  opts.lock = true;
					  $(obj).append(data); 
					  currPage++;
						var objectsRendered = $(obj).children('[rel!=loaded]');
						if (opts.afterLoad != null){
							opts.afterLoad(objectsRendered);
						}
						var temp=data.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
						if (temp==null||temp==''){
							// $('#loading').fadeOut();
							 $("#loading").html("已经加载到最后了。。")	
							setTimeout(function(){$('#loading').fadeOut();},100);
		    				size=1;
						}
					  },
				  dataType: 'html'
			 });
		 }else{
			 $("#loading").html("已经加载到最后了。。")	
			 setTimeout(function(){$('#loading').fadeOut();},1);
		 }
	 }
	 
  };
  
  $.fn.scrollPagination.init = function(obj, opts){
	 var target = opts.scrollTarget;
	 $(obj).attr('scrollPagination', 'enabled');
	
	 $(target).scroll(function(event){
		if ($(obj).attr('scrollPagination') == 'enabled'){
	 		$.fn.scrollPagination.loadContent(obj, opts);		
		}
		else {
			event.stopPropagation();	
		}
	 });
	 
	 $.fn.scrollPagination.loadContent(obj, opts);
	 
 };
	
 $.fn.scrollPagination.defaults = {
      	 'contentPage' : null,
     	 'contentData' : {},
		 'beforeLoad': null,
		 'afterLoad': null	,
		 'scrollTarget': null,
		 'heightOffset': 0	,
		 'lock':true,
 };	
})( jQuery );