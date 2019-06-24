var oMain = document.getElementById("main");
    oMax = document.getElementById("max");
    //根据class获取元素时加上下标
    oSelect = document.getElementsByClassName("select")[0];
    oDemo = document.getElementsByClassName("demo")[0];
    oLarge = document.getElementsByClassName("large")[0];
    
/*
 	鼠标事件
		进入		mouseover
 				mouseenter 
 	
 		离开		mouseout
 				mouseleave
 				
 		移动		mousemove
 
 */

oMain.onmouseover = function(){
	oMax.style.display='block';
	oSelect.style.display='block';
}
oMain.onmouseout = function(){
	oMax.style.display='none';
	oSelect.style.display='none';
}
oMain.onmousemove = function(e){	//小方块跟随鼠标移动
	
	oMax.style.left=(oMain.offsetLeft+303)+"px";
	
	var x = e.clientX-oMain.offsetLeft-oSelect.offsetWidth/2;
	var y = e.clientY-oMain.offsetTop-oSelect.offsetHeight/2;
	
	var maxX = oMain.offsetWidth-oSelect.offsetWidth;
	var maxY = oMain.offsetHeight-oSelect.offsetHeight;
	if(x<=0){
		x=0;
	}else if(x>=maxX){
		x=maxX;
	}
	if(y<=0){
		y=0;
	}else if(y>=maxY){
		y=maxY;
	}
	oSelect.style.left = x+'px';
	oSelect.style.top = y+'px';
	
	oLarge.style.left = x/maxX*(oMax.offsetWidth-oLarge.offsetWidth)+'px'; 
	oLarge.style.top = y/maxY*(oMax.offsetHeight-oLarge.offsetHeight)+'px'; 
} 
