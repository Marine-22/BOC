$(document).ready(
    function()
    {
    	
    	$('.inithide').hide();
    	
    	$('.site-nav-main li.add_predpis a').click(function(){
    		if($('.newpred').is(":visible")){
    			$('.newpred').hide();
    		}else{
    			$("#poradove")	.val($("li#poradove_cislo input").val());
    			$("#urad")		.val($("li#uradpicker input").val());
    			$("#datum")		.val($("li#datepicker input").val());
    			$('.newpred').show();
    		}
    	});
    	
    	$("li#poradove_cislo input").keyup(function(){
    		if($('.newpred').is(":visible")){
    			$("#poradove")	.val($("li#poradove_cislo input").val());
    		}
    	});
		
    	$("li#uradpicker input").keyup(function(){
    		if($('.newpred').is(":visible")){
    			$("#urad")		.val($("li#uradpicker input").val());
    		}
    	});
		
		$("li#datepicker input").change(function(){
			if($('.newpred').is(":visible")){
				$("#datum")		.val($("li#datepicker input").val());
    		}
    	});
    	
    	$('.site-nav-main li.change_pass a').click(function(){
    		if($('.chpass').is(":visible")){
        		$('.chpass').hide();
    		}else{
        		$('.chpass').show();
    		}    		
    	});

    	$('.site-nav-main li.add_user a').click(function(){
    		if($('.newuser').is(":visible")){
        		$('.newuser').hide();
    		}else{
        		$('.newuser').show();
    		}    		
    	});
    	
    	
    	
    	$(".nominal .red_button_small").click(function(e) {
    		var j = $(e.target);
    		var len = j.siblings("input.text").val().length;
    		if(len > 0){
    			if(len == 10){
    				j.parent().remove();
    			}
    			else{
    				j.siblings("input.text").val("");
    			}
    			//e.target.parentNode.parentNode.removeChild(e.target.parentNode);
    		}
    	});
    	
    	$(".nominal input.text").keyup(function(e) {
    		if($(this).val().length == 10){
    			addNewPredpisElement();
    			$('.nominal:last input').focus();
    		}
    	});
    	
	    $("#login_user input#pass").keypress(function (e) {
	        if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
	            $('#login_user a.blue_button').click();
	        }
	    });
	    
	    try{ // datepicker nemusi existovat, musi byt osetrene
	    	$("#datepicker input").datepicker();
	    }catch(e){}
	    
	    $("#searchUsersInput").keyup(function(e){
	    	refreshUsers();
	    });
	    
	    $("#searchPredpisInput").keyup(function(e){
	    	refreshPredpis();
	    });
	    
	    
	    
	    $(".site-nav-main ul li:not(:last-child, :first-child)").hover(function(){
	    	$(".site-nav-main ul li:not(:last-child, :first-child)").css("background", "#e68902 url(resources/img/main-navi-bcg-h.png) repeat-x");
	    },function(){
	    	$(".site-nav-main ul li:not(:last-child, :first-child)").css("background", "#fec006 url(resources/img/main-navi-bcg.png) repeat-x");
	    });
	    
	    refreshUsers();
	    refreshPredpis();
	    
    }
)