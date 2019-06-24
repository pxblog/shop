$("#addressSub").click(
	function address(){
		$.post(
			basePath+"addAddress.action",
			{
				addressee :$("#addressee").val(),
				cityAddress :$("#cityAddress").val(),
				streetAddress :$("#streetAddress").val(),
				phone :$("#phone").val()
			},
			function (data) {
				if(data!=''&&data!=null){
					$("#addressSpans").append(data)
					$('.add').css('display','none')
				}else{
					alert("error")
				}
			}
		)	
	}
);

//把更换的input值放到隐藏域中
function changeMaid(maid) {
	$("#maidHid").val(maid)
}
	
function go(){
	$('.add').css('display','block');
	
}
$('#close').click(
	function(){
		$('.add').css('display','none');
	}
);
function checkOrdersub(){
//没有选收获地址要提示
	if($('[type=radio]:checked').length==0){
		alert("请选择收货地址");
		return false;
	}
	$('[type=radio]').each(
		function(){
			if(!$(this).attr('checked')){
				$(this).removeAttr('name');
			}
		return true;
		}
	);
}

$('.addspan').click(function(){
	$(this).find('input').attr('checked','true');
});
