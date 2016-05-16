$(function(){
	var box = $(".header1");
	box.each(function(){
		if(!$(this).hasClass("sele11")){
			$(this).remove();
		}else{
			$(this).attr("style","top:0px;");
		}
	});
	$(".space2").eq(0).remove();
});