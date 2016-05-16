var bgDiv = $(document.createElement('div'));
var showDiv = $(document.createElement('div'));
bgDiv.attr("id","bg");
showDiv.attr("id","show");
bgDiv.attr("style","display:none;position:absolute;left:0%;width:100%;height:100%;background-color:black;z-index:1001;-moz-opacity:0.7;opacity:.15;filter:alpha(opacity=15);");
showDiv.attr("style","display:none;position:absolute;width:100%;z-index:1002;overflow:auto;margin-left: auto;margin-right: auto;text-align:center;");
$('body').append(bgDiv);
$('body').append(showDiv);

function showdiv(html) {      
	showDiv.html(html);
	/**设置提示信息居中**/
	var top = document.body.scrollTop;
	var bgStyle = bgDiv.attr("style");
	bgStyle+="top:"+top+"px;";
	bgDiv.attr("style",bgStyle);
	var showStyle = showDiv.attr("style");
	showStyle+="top:"+(top+$(window).height()/2-showDiv.height()/2)+"px;";
	showDiv.attr("style",showStyle);
	/**设置提示信息居中**/
	bgDiv.fadeIn("fast");
	showDiv.fadeIn("fast");
}
function hidediv(html) {
	if(html!=""){     
		showDiv.html(html);
	}
	bgDiv.fadeOut(1000);
	showDiv.fadeOut(1000);
}