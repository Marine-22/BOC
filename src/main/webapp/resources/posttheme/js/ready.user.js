$(document).ready(
    function()
    {
    	$('.inithide').hide();
    	
    	$('.site-nav-main li.add_predpis a').click(function(){
    		if($('.newpred').is(":visible")){
    			$('.newpred').hide();
    		}else{
    			$("#poradove")	.val($("li#poradove_cislo input").val());
    			$("#datum")		.val($("li#datepicker input").val());
    			$('.newpred').show();
    			if($('#urad').val().length == 0){
    				$('#uradpicker input').focusout();
    			}
    			//$("#urad")		.val($("li#uradpicker input").val());
    		}
    	});
    	
    	
    	$("li#poradove_cislo input").keyup(function(){
    		if($('.newpred').is(":visible")){
    			$("#poradove")	.val($("li#poradove_cislo input").val());
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
    	
    	$("#change-password input#reppass").keypress(function (e) {
	        if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
	            $('#change-password a.blue_button').click();
	        }
	    });
    	
    	$("#datepicker input"  ).datepicker();
    	$("#searchDatumDoInput").datepicker();
    	$("#searchDatumOdInput").datepicker();
    	
    	$('#uradpicker input').autocomplete({
    		source: window.GLOBAL_APP_NAME + '/searchUrad'
    	});
    	
    	$('#searchUradInput').autocomplete({
    		source: window.GLOBAL_APP_NAME + '/searchUrad',
    		select: function(e, ui){
    			$('#searchUradId').text(ui.item.id);
    			refreshPredpis();
    		}
    	});
    	
    	$('#searchUradInput').keyup(function(){
    		if($(this).val().length == 0){
    			$('#searchUradId').text("");
    			refreshPredpis();
    		} 
    	});
    	
    	$("#searchDatumDoInput").change(function(){
			refreshPredpis();
    	});
    	
    	$("#searchDatumOdInput").change(function(){
			refreshPredpis();
    	});
    	
    	$('#sluzba').autocomplete({
    		source: window.GLOBAL_APP_NAME + '/searchSluzba',
    		focus: function(e, ui){
    			$('#sluzba_name').text(ui.item.name);
    		}
    	});
    	
	    $('#uradpicker input').focusout(function(){
	    	var thiz = $(this);
	    	$.getJSON(window.GLOBAL_APP_NAME + "/getUrad",
	    			{term:$(this).val(),JSR:""},
	    			function(data){
	    				if(checkRedirect(data)){
	    					if(checkErrs(data)){
		    					thiz.css("border","");
		    					$("#urad_err").hide();
		    					$("#urad_err").text("");
		    					$("#urad").val(data.data.busId);
		    					$("#urad_name").show();
		    					$("#urad_name").text(data.data.name);
	    					}
	    					else{
		    					$("#urad_name").val("");
		    					$("#urad_name").hide();
		    					$("#urad").val("");
		    					thiz.val("");
		    					thiz.css("border","2px solid #F00");
	    					}
	    				}
	    			},
	    			'json'
	    	)
	    });
	    
	    $('#sluzba').focusout(function(){
	    	var thiz = $(this);
	    	if(thiz.val().length > 0){
		    	$.getJSON(window.GLOBAL_APP_NAME + "/getSluzba",
		    			{id:$(this).val(),JSR:""},
		    			function(data){
		    				if(checkRedirect(data)){
		    					if(checkErrs(data)){
			    					thiz.css("border","");
			    					$("#sluzba_err").text("");
			    					$("#sluzba_err").hide();
			    					$("#sluzba_name").text(data.data.name);
			    					$("#sluzba_name").show();
		    					}
		    					else{
			    					thiz.val("");
			    					thiz.css("border","2px solid #F00");
			    					$("#sluzba_name").text("");
			    					$("#sluzba_name").hide();
		    					}
		    				}
		    			}
		    	)
	    	}
	    });
	    
	    $("#searchPredpisInput").keyup(function(e){
	    	refreshPredpis();
	    });
	    
	    $(".site-nav-main ul li:not(:last-child, :first-child)").hover(function(){
	    	$(".site-nav-main ul li:not(:last-child, :first-child)").css("background", "#e68902 url(resources/img/main-navi-bcg-h.png) repeat-x");
	    },function(){
	    	$(".site-nav-main ul li:not(:last-child, :first-child)").css("background", "#fec006 url(resources/img/main-navi-bcg.png) repeat-x");
	    });
	    
	    refreshPredpis();
    }
)