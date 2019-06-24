//轮播
var index = 0;
var time = setInterval(function() {
	if (index == 2) {
		index = -1;
	}
	index++;
	var len = index * 1000 + "px";
	$('.banner ul').animate({
		right: len
	});
}, 3000);

$('.left').click(function() {
	clearInterval(time);
	if (index == 0) {
		index = 3;
	}
	index--;
	var len = index * 1000 + "px";
	$('.banner ul').animate({
		right: len
	});
});
$('.right').click(function() {
	clearInterval(time);
	if (index == 2) {
		index = -1;
	}
	index++;
	var len = index * 1000 + "px";
	$('.banner ul').animate({
		right: len
	});

});
//广告图片放大
$('#brand li img').mouseenter(function() {
	temp_width = $(this).width();
	temp_height = $(this).height();
	var wValue = 1.3 * $(this).width();
	var hValue = 1.3 * $(this).height();
	$(this).stop().animate({
		width: wValue,
		height: hValue
	}, 300);
}).mouseleave(function() {
	$(this).stop().animate({
		width: temp_width,
		height: temp_height,

	}, 300);
});
//监听页面的滚动事件
$(document).scroll(
      function() {
		var winPos = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop || 0;
		//导航条
		if (winPos >= 200 && winPos <= $('footer').offset().top) {
			$('nav').css('position', 'fixed');
			$('nav').css('top', '0px');
			$('nav').css('opacity', 0.7);
			$('.floor-menu').css('display','block');

		} else if (winPos < 200) {
			$('nav').css('position', 'relative');
			$('nav').css('opacity', 1);
			$('floor-menu').css('display','none');
		}
		//楼梯菜单
//		if (winPos >= 300&& winPos <= $('#brand').offset().top) {
//			
//			$('.floor-menu').css('display','block');
//
//		} else  {
//		
//			$('.floor-menu').css('display','none');
//		}

	}
);
$('.floor-menu li').hover(function(){
	$(this).css('background','darkmagenta');
	$(this).css('color','white');
	
},function(){
	$(this).css('background','white');
	$(this).css('color','black');
	
}


);
$('.floor-menu li').click(function(){
	
	var winPos = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop || 0;
	var index = $(this).index();

	var top = $('.floor-title').eq(index).offset().top;
	
	$(document).scrollTop(top-40);
});
$('#gocar').click(
	function(){
		window.location.href = 'car.html';
	}
);
 $(window).on('scroll', function () {/*当滚动条的垂直位置大于浏览器所能看到的页面的那部分的高度时，回到顶部按钮就显示 */

        if ($(window).scrollTop() > $(window).height())

            $('.gotop').fadeIn();

        else

            $('.gotop').fadeOut();

    });
    
$('.gotop').click(function(){
	 $('html,body').animate({

            scrollTop: 0

        }, 800);
});
