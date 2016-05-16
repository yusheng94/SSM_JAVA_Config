//全局加载用户信息
$(function(){
	
});

//设定Cookie值
function SetCookie(name, value) {
	var expdate = new Date();
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	var path = (argc > 3) ? argv[3] : null;
	var domain = (argc > 4) ? argv[4] : null;
	var secure = (argc > 5) ? argv[5] : false;
	if (expires != null)
		expdate.setTime(expdate.getTime() + (expires * 1000));
	document.cookie = name + "=" + escape(value)
			+ ((expires == null) ? "" : ("; expires=" + expdate.toGMTString()))
			+ ((path == null) ? "" : ("; path=" + path))
			+ ((domain == null) ? "" : ("; domain=" + domain))
			+ ((secure == true) ? "; secure" : "");
}

//获得Cookie的原始值
function GetCookie(name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;
	var cookie = document.cookie;
	while (i < clen) {
		var j = i + alen;
		if (cookie.substring(i, j) == arg)
			return GetCookieVal(j);
		i = cookie.indexOf(" ", i) + 1;
		if (i == 0)
			break;
	}
	return null;
}

//获得Cookie解码后的值
function GetCookieVal(offset) {
	var endstr = document.cookie.indexOf(";", offset);
	if (endstr == -1)
		endstr = document.cookie.length;
	return unescape(document.cookie.substring(offset, endstr));
}

//退出登录
function logout() {
	$.ajax({
		url : '/mortgage/account/logout',
		type : 'POST',
		dataType : 'json',
		// timeout: 1000,
		error : function() {
		},
		success : function(txt) {
			if (txt.flag) {
				window.location.reload();
			} else {
				
			}
		}
	});
}
// 获取URL参数
function getQueryParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//去空格
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
function trim(str) {
	return str.replace(/^\s+|\s+$/g, "");
}

//验证码
function changeVerifyCode(img){
	var rand = Math.random();
	if (typeof img == 'string') {
		var imgArr = document.getElementById(img);
		imgArr.src = "/auth?" + rand;
	} else {
		img.src = "/auth?" + rand;
	}
  } 
//邮箱注册
var hash = {
	'qq.com' : 'http://mail.qq.com',
	'gmail.com' : 'http://mail.google.com',
	'sina.com' : 'http://mail.sina.com.cn',
	'163.com' : 'http://mail.163.com',
	'126.com' : 'http://mail.126.com',
	'yeah.net' : 'http://www.yeah.net/',
	'sohu.com' : 'http://mail.sohu.com/',
	'tom.com' : 'http://mail.tom.com/',
	'sogou.com' : 'http://mail.sogou.com/',
	'139.com' : 'http://mail.10086.cn/',
	'hotmail.com' : 'http://www.hotmail.com',
	'live.com' : 'http://login.live.com/',
	'live.cn' : 'http://login.live.cn/',
	'live.com.cn' : 'http://login.live.com.cn',
	'189.com' : 'http://webmail16.189.cn/webmail/',
	'yahoo.com.cn' : 'http://mail.cn.yahoo.com/',
	'yahoo.cn' : 'http://mail.cn.yahoo.com/',
	'eyou.com' : 'http://www.eyou.com/',
	'21cn.com' : 'http://mail.21cn.com/',
	'188.com' : 'http://www.188.com/',
	'foxmail.coom' : 'http://www.foxmail.com',
	'wo.com.cn' : 'http://mail.wo.com.cn/mail/login.action',
	'263.net' : 'http://www.263.net/',
	'263.net.cn' : 'http://www.263.net/',
	'x263.net' : 'http://www.263.net/'
};

// 打开邮箱
function toEmail() {
	var email = $("#email_span").html();
	if (email) {
		var url = email.substring(email.indexOf("@") + 1);
		if (hash[url]) {
			window.open(hash[url]);
		} else {
			window.open('http://mail.' + url);
		}
	}
}
//控制文字过长显示...
function subString(str,len){
	if(str != undefined && str.length > len){
		return str.substring(0,len)+"...";
	}
	return str;
}
//控制文字过长显示...[详情]
function subStrDetail(str,len,url){
	if(str != undefined && str.length > len){
		return str.substring(0,len)+"...[<a class='dansuse' href='"+url+"'>详情</a>]";
	}
	return str;
}
function isMobile(mobile){
	var reg = /^[1]([3][0-9]{1}|[5][0-35-9]{1}|[8][01-9]{1}|47|77)[0-9]{8}$/;
	return reg.test(mobile);
}
function isPrice(price){
	var reg = /^(0\.[0-9]{0,10}[1-9]\d*|[1-9]\d*(\.\d+)?)$/;
	return reg.test(price);
}
function isEmail(email){
	var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	return reg.test(email);
}
function isNumber(number){
	var reg = /^[1-9]*[1-9][0-9]*$/;
	return reg.test(number);
}
function isAuthCode(authCode){
	var reg = /^[\w\W]{4}$/;
	return reg.test(authCode);
}
function isPassword(password){
	var reg = /^[0-9a-zA-Z_]{6,20}$/;
	return reg.test(password);
}
function showMsg(msg){
	var div = $(document.createElement('div'));
    var top = ($(window).height() - div.height())/2;   
    var left = ($(window).width() - div.width())/2;   
    var scrollTop = $(document).scrollTop();   
    var scrollLeft = $(document).scrollLeft();   
    div.html(msg);
    div.css( {color:'white', background:'#040','font-size':'13px','max-width':'200px', padding:'10px', position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } );
    $('body').append(div);
    div.fadeOut(1500,function(){div.remove();});
}
//qq登陆
function qqlogin(){
	window.open('/main/qqlogin.html?opflag=web_login','window',"height=400,width=700,top=300,left=400,toolbar=1,menubar=1,scrollbars=no,resizable=yes,location=yes,status=1");
}

//sina登陆
function sinalogin(){
	window.open('/main/sinawblogin.html?opflag=web_login','window',"height=400,width=700,top=300,left=400,toolbar=1,menubar=1,scrollbars=no,resizable=yes,location=yes,status=1");
}
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
	}

//统计
function statistics(pageCode){
	jQuery.ajax({type: "POST",dataType: "json",url: "/mortgage/statistics/statistics",data: "pageCode="+pageCode});
}
//判断元素是否禁用
function noDisabled(obj){ 
	if(obj.disabled) { 
		return false; 
	} 
	return true; 
}
