$(document).ready(
    function()
    {
    	$('.inithide').hide();
    	
    	$('.site-nav-main li.add_user a').click(function(){
    		if($('.newuser').is(":visible")){
        		$('.newuser').hide();
    		}else{
        		$('.newuser').show();
    		} 
    	});
    	
	    $("#searchUsersInput").keyup(function(e){
	    	refreshUsers();
	    });
	    
	    $(".site-nav-main ul li:not(:last-child, :first-child)").hover(function(){
	    	$(".site-nav-main ul li:not(:last-child, :first-child)").css("background", "#e68902 url(resources/img/main-navi-bcg-h.png) repeat-x");
	    },function(){
	    	$(".site-nav-main ul li:not(:last-child, :first-child)").css("background", "#fec006 url(resources/img/main-navi-bcg.png) repeat-x");
	    });
	    
    	$('.site-nav-main li.change_pass a').click(function(){
    		if($('.ispep').is(":visible")){
        		$('.ispep').hide();
    		}else{
        		$('.ispep').show();
    		}    		
    	});
    	
	    refreshUsers();
    }
)