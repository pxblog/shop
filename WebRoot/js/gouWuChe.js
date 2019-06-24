var jian = document.getElementsByName("jian");
	jia = document.getElementsByName("jia");
	oShopNum = document.getElementsByName("shopNum");
	oMoneySum = document.getElementsByClassName("moneySum");
	oDanJia = document.getElementsByClassName("danJia");
	oZongJi = document.getElementsByClassName("zongJi")[0];
	oCheck = document.getElementsByClassName("cheak");
	oCheckAll = document.getElementById("cheakAll");
	oQuanXuan = document.getElementsByClassName("quanXuan")[0];
	ogwTable = document.getElementById("gwTable");
	oSetShopName = document.getElementsByName("setShopName")[0];
	oSetShopImage = document.getElementsByName("setShopImage")[0];
	oSetShopMoney = document.getElementsByName("setShopMoney")[0];
	oAdd = document.getElementById("add");
	oAddWord = document.getElementsByClassName("addWord")[0];
	oClearAdd = document .getElementsByClassName("clearAdd")[0];
	ocs = document.getElementsByClassName("cheak_td");
/*加减部分，取父节点*/	
ogwTable.addEventListener('click', function (e) {
	var target = e.target;
	if(e.target.name == 'jian') {
		if(e.target.parentNode.getElementsByClassName('shopNum')[0].value > 0) {
			var carId = e.target.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.getElementsByClassName("cartId")[0].innerText
			var diorNum = e.target.parentNode.getElementsByClassName('shopNum')[0].value--;
			//ajax 购买数量加
			$.post(
					basePath+"myCartAjax.action",
					{
						keyword:'jian',
						carId:carId,
						shopNum:e.target.parentNode.getElementsByClassName('shopNum')[0].value
					},
					function (data) {
						if(data=="ok"){
							for(var i=0;i<oMoneySum.length;i++){
								if(oShopNum[i].value >= 0){
									//测试兄弟结点
									oMoneySum[i].innerHTML = oDanJia[i].innerText*oShopNum[i].value;
								}else{
									oMoneySum[i].innerHTML = 0;
								}
							}
						}else{
							alert(data)
						}
						
					}
				)
			
				
			
		}
	}
})
ogwTable.addEventListener('click', function (e) {
	var target = e.target;
		
	if(e.target.name == 'jia') {
		var carId = e.target.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.getElementsByClassName("cartId")[0].innerText
		var diorNum = e.target.parentNode.getElementsByClassName('shopNum')[0].value++;
		//ajax 购买数量加
			$.post(
					basePath+"myCartAjax.action",
					{
						keyword:'jia',
						carId:carId,
						shopNum:e.target.parentNode.getElementsByClassName('shopNum')[0].value
					},
					function (data) {
						if(data=="ok"){
							for(var i=0;i<oMoneySum.length;i++){
								if(oShopNum[i].value >= 0){
									//测试兄弟结点
									oMoneySum[i].innerHTML = oDanJia[i].innerText*oShopNum[i].value;
								}else{
									oMoneySum[i].innerHTML = 0;
								}
							}
						}else{
							alert(data)
						}
						
					}
				)
		
		
			
	}
})	
								/*下为原写法*/
	/*减部分*/
	/*for(var i=0;i<jian.length;i++){
		var e = jian[i];
		e.index = i;
		e.onclick = function (){
			var a = this.index;
			if(oShopNum[a].value > 0){
				var diorNum = oShopNum[a].value--;
				//测试兄弟结点
				oMoneySum[a].innerHTML = oDanJia[a].innerText*oShopNum[a].value;
			}
		}
	}
	*/
	
	/*加部分*/
	/*for(var i=0;i<jia.length;i++){
		var e = jia[i];
		e.index = i;
		e.onclick = function (){
			var a = this.index;
			var diorNum = oShopNum[a].value++;
			oMoneySum[a].innerHTML = oDanJia[a].innerText*oShopNum[a].value;
		}	
	}*/

/*初始化*/
for(var i=0;i<oMoneySum.length;i++){
	if(oShopNum[i].value >= 0){
		//测试兄弟结点
		oMoneySum[i].innerHTML = oDanJia[i].innerText*oShopNum[i].value;
	}else{
		oMoneySum[i].innerHTML = 0;
	}
}


for(var i=0;i<oShopNum.length;i++){
	oShopNum[i].addEventListener('blur',function(e) {
		
		var carId = e.target.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.getElementsByClassName("cartId")[0].innerText
		
		$.post(
			basePath+"myCartAjax.action",
			{
				keyword:'changeNum',
				carId:carId,
				shopNum:e.target.value
			},
			function (data) {
				if(data=="ok"){
					for(var i=0;i<oMoneySum.length;i++){
						if(oShopNum[i].value >= 0){
							//测试兄弟结点
							oMoneySum[i].innerHTML = oDanJia[i].innerText*oShopNum[i].value;
						}else{
							oMoneySum[i].innerHTML = 0;
						}
					}
				}else{
					alert(data)
				}
			}
		)
	} )
	
}



/*定时更新数据部分*/
var timer = setInterval(function(){
	
	var	temp = 0;
	for(var i=0;i<oMoneySum.length;i++){ 
		if(oCheck[i].checked){ //判断是否选中
			ocs[i].style.backgroundImage = "url("+basePath+"images/true_ok.png)";
			ocs[i].style.backgroundSize = "13px";
			ocs[i].style.backgroundRepeat = "no-repeat";
			ocs[i].style.backgroundPosition = "left";
			temp += parseInt(oMoneySum[i].innerHTML) ;
		}else{
			ocs[i].style.backgroundImage = "url("+basePath+"images/true_no.png)";
			ocs[i].style.backgroundSize = "13px";
			ocs[i].style.backgroundRepeat = "no-repeat";
			ocs[i].style.backgroundPosition = "left";
		}
	}
	oZongJi.innerHTML = temp; 
},200);

/*全选部分*/
var flag = true;
var k = document.getElementsByClassName("cheakAll_td")[0];
var qx = setInterval(function(){
	for(var i=0;i<oCheck.length;i++){
		flag = true;
		if(!oCheck[i].checked){
			flag = false;
			break;
		}
	}
	if(flag){
		k.style.backgroundImage = "url("+basePath+"images/true_ok.png)";
		k.style.backgroundSize = "13px";
		k.style.backgroundRepeat = "no-repeat";
		k.style.backgroundPosition = "left";
		oCheckAll.checked = true;
		oQuanXuan.innerText = "取消全选";
	}else{
		k.style.backgroundImage = "url("+basePath+"images/true_no.png)";
		k.style.backgroundSize = "13px";
		k.style.backgroundRepeat = "no-repeat";
		k.style.backgroundPosition = "left";
		oCheckAll.checked = false;
		oQuanXuan.innerText = "全部选中";
	}
},200)

oCheckAll.onclick = function (){
	if(oCheckAll.checked){
		for(var i=0;i<oCheck.length;i++){
			k.style.backgroundImage = "url("+basePath+"images/true_ok.png)";	
			k.style.backgroundSize = "13px";
			k.style.backgroundRepeat = "no-repeat";
			k.style.backgroundPosition = "left";
			oCheck[i].checked = true;
			oQuanXuan.innerText = "取消全选";
		}
	}else{
		for(var i=0;i<oCheck.length;i++){
			k.style.backgroundImage = "url("+basePath+"images/true_no.png)";
			k.style.backgroundSize = "13px";
			k.style.backgroundRepeat = "no-repeat";
			k.style.backgroundPosition = "left";
			oCheck[i].checked = false;
			oQuanXuan.innerText = "全选选中";
		}
	}
}

/*删除部分*/
function del(){
	var array=[];
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			array.push(oCheck[i].nextSibling.innerText)
			ogwTable.deleteRow(i+2); //因为加了标题行，故加2
			i--;
		}
	}
	//ajax 删除
	$.post(
			basePath+"myCartAjax.action",
			{
				keyword:'delete',
				carIds:array.toString()
			}
		)
}
//结算部分
function settlement(){
	var array=[];
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			array.push(oCheck[i].nextSibling.innerText)
		}
	}
	oCarIds = document.getElementById("carIds");
	oCarIds.value = array.toString();
	document.forms["userForm"].submit();
}

