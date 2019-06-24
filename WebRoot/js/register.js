var flag1 = false,
    flag2 = false,
    flag3 = false,
    flag4 = false;

if(message!=''&&message!=null){
	alert(message)
}

function register() {
	
	//用户名
	if($("#username").val()!=''&&$("#username").val()!=null){
		if($("#username").val().length<6||$("#username").val().length>16){
			$("#error_alert").html("<font color='red'>用户名长度不合适</font>");
			flag1 = false;
		}else{
			//ajax函数
			$.post(
				basePath+"registerAjax.action",
				{
					username:$("#username").val()
				},
				function (data) {
					if(data!=''&&data!=null){
						if(data=="<font color='red'>账号已存在<font>"){
							$("#error_alert").html(data)
							flag1 = false;
						}else{
							$("#error_alert").html(data)
							flag1 = true;
						}
					}
				}
			)
		}
	}else{
		$("#error_alert").html("<font color='red'>用户名不能为空</font>")
		flag1 = false;
	}
	//邮箱
	if($("#email").val()!=''&&$("#email").val()!=null){
		var reg =  /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if(!reg.test($("#email").val())){
			$("#email_alert").html("<font color='red'>请输入正确的邮箱格式</font>")
			flag2 = false;
		}else{
			$("#email_alert").html("<font color='green'>邮箱可以使用</font>")
			flag2 = true;
		}
	
	}else{
		$("#email_alert").html("<font color='red'>邮箱不能为空</font>")
		flag2 = false;
	}
	//密码
	if($("#pwd").val()!=''&&$("#pwd").val()!=null){
		if($("#pwd").val().length<6||$("#pwd").val().length>16){
			$("#pwd_alert").html("<font color='red'>密码长度不合适</font>")
			flag3 = false;
		}else{
			$("#pwd_alert").html("<font color='green'>密码可用</font>")
			flag3 = true;
		}
	}else{
		$("#pwd_alert").html("<font color='red'>密码不能为空</font>")
		flag3 = false;
	}
	
	//重复密码
	if($("#rePwd").val()!=''&&$("#rePwd").val()!=null){
		if($("#rePwd").val()!=$("#pwd").val()){
			$("#rePwd_alert").html("<font color='red'>两次密码输入不同</font>")
			flag4 = false;
		}else{
			$("#rePwd_alert").html("<font color='green'>密码一致</font>")
			flag4 = true;
		}
	}else{
		$("#rePwd_alert").html("<font color='red'>重复密码不能为空</font>")
		flag4 = false;
	}
	//决定注册按钮是否可用
	
}

$("#mySub").click(function(){
	if(flag1&&flag2&&flag3&&flag4&&$('#checkItem').attr('checked')){
		document.forms["userForm"].submit();
	}
});



	