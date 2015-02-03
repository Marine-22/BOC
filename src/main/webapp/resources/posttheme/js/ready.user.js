var defSudnaSluzba = null;
var defSpravnaSluzba = null;
var defSudnaSluzbaText = null;
var defSpravnaSluzbaText = null;

$(document).ready(
    function()
    {
	    $.ajaxSetup({
	        cache: false
	    });
	    
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
    			// kontrola, ci uz takyto kreditny kolok nie je v zozname
    			var list = $(".nominal input.text");
    			var exists = false;
    			for(var i = 0; i < list.length-1; i++){
    				if(list[i].value == $(this).val()){
    					exists = true;
    					break;
    				}
    			}
    			if(!exists){
	    			addNewPredpisElement();
    			}
    			else{
    				$(this).val("");
    			}
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
    	$("#searchDatumPridaniaOdInput").datepicker();
    	$("#searchDatumPridaniaDoInput").datepicker();
    	$("#searchDatumSyncOdInput").datepicker();
    	$("#searchDatumSyncDoInput").datepicker();
    	
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
    	
    	$("#searchDatumDoInput, #searchDatumOdInput, #searchDatumPridaniaOdInput, #searchDatumPridaniaDoInput, #searchDatumSyncOdInput, #searchDatumSyncDoInput").change(function(){
			refreshPredpis();
    	});
    	
    	$('#sluzba').autocomplete({
    		source: window.GLOBAL_APP_NAME + '/searchSluzba',
    		focus: function(e, ui){
    			$('#sluzba_name').text(ui.item.name);
    			$('#sluzbaSuma').val(ui.item.price + "€");
    		}
    	});
    	
	    $('#uradpicker input').focusout(function(){
	    	var thiz = $(this);
	    	if(thiz.val().length > 0){
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
			    					if($("#sluzba").val().length == 0){
				    					if(data.data.spSu == 0){ //SPRAVNY
				    						$("#sluzba").val(defSpravnaSluzba);
				    					}
				    					else{ // SUDNY
				    						$("#sluzba").val(defSudnaSluzba);
				    					}
				    					$('#sluzba').focusout();
			    					}
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
	    	}
	    });
	    
	    $('#sluzba').focusout(function(){
	    	var thiz = $(this);
	    	if(thiz.val() == defSudnaSluzba){
				thiz.css("border","");
				$("#sluzba_err").text("");
				$("#sluzba_err").hide();
				$("#sluzba_name").text(defSudnaSluzbaText);
				$("#sluzba_name").show();
				$("#sluzbaSuma").val("Neurčitá");
	    	}
	    	else if(thiz.val() == defSpravnaSluzba){
				thiz.css("border","");
				$("#sluzba_err").text("");
				$("#sluzba_err").hide();
				$("#sluzba_name").text(defSpravnaSluzbaText);
				$("#sluzba_name").show();
				$("#sluzbaSuma").val("Neurčitá");
	    	}
	    	else if(thiz.val().length > 0){
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
			    					$("#sluzbaSuma").val(data.data.suma + "€");
		    					}
		    					else{
			    					thiz.val("");
			    					thiz.css("border","2px solid #F00");
			    					$("#sluzba_name").text("");
			    					$("#sluzba_name").hide();
			    					$("#sluzbaSuma").val("€");
		    					}
		    				}
		    			}
		    	)
	    	}
	    	else{ // sluzba nie je zadana, musim vynulovat sluzba name
				$("#sluzba_name").text("");
				$("#sluzba_name").hide();
				$("#sluzbaSuma").val("€");
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
	    
	    $('.del_button').mousemove( 
	 	       function(e){
	 	    	   if(e.pageX > ($(this).offset().left + $(this).width() + 42 - 30)){
	 	    		   $(this).css('cursor','pointer');
	 	    	   }
	 	    	   else{
	 	    		   $(this).css('cursor','auto');
	 	    	   }
	 	    }
	 	);
	    
		$('.del_button').click( 
				function(e){
					if(e.pageX > ($(this).offset().left + $(this).width() + 42 - 30)){
						if($(this)[0] == $('#searchStavInput')[0]){
							$('#filter-loaded').prop('checked', true); 
							$('#filter-waiting').prop('checked', true);
							$('#filter-processed').prop('checked', true);
							$('#filter-error').prop('checked', true);
							//refreshPredpis();
						}
						else{
							$(this).val("");
							$(this).keyup();
							$(this).change();
						}
					}
		});
		
		
	    $('.search_button').mousemove( 
		 	       function(e){
		 	    	   if(e.pageX > ($(this).offset().left + $(this).width() + 42 - 30)){
		 	    		   $(this).css('cursor','pointer');
		 	    	   }
		 	    	   else{
		 	    		   $(this).css('cursor','auto');
		 	    	   }
		 	    }
		 	);
		    
			$('.search_button').click( 
					function(e){
						if(e.pageX > ($(this).offset().left + $(this).width() + 42 - 30)){
							refreshPredpis();
						}
			});
	    $('#searchStavInput').focus(function(){
	    	$('#state-filter').show();
	    	prepareStates();
	    	$('#state-filter').click(function(e){
	    		e.stopPropagation();
	    	});
	    	$('#searchStavInput').click(function(e){
	    		e.stopPropagation();
	    	});
			$(document).click(function(){
	    		$('#state-filter').hide();
		    	refreshPredpis();
	    		$(this).off('click');
	    		$('#state-filter').off('click');
		    	$('#searchStavInput').click(function(e){
		    		if(e.pageX > ($(this).offset().left + $(this).width() + 42 - 30)){
		    			$('#filter-loaded').prop('checked', true); 
 	    				$('#filter-waiting').prop('checked', true);
 	    				$('#filter-processed').prop('checked', true);
 	    				$('#filter-error').prop('checked', true);
		    		}
		    	});
	    	});
	    	
	    });
	    
	    if(defSudnaSluzba == null || defSpravnaSluzba == null){
	    	$.getJSON(window.GLOBAL_APP_NAME + "/getDefaultSluzby",
	    			{JSR:""},
	    			function(data){
	    				if(checkRedirect(data) && checkErrs(data)){
	    					defSudnaSluzba = data.data.SUDNA;
	    					defSpravnaSluzba = data.data.SPRAVNA;
	    					defSudnaSluzbaText = data.data.SUDNA_TEXT; 
	    					defSpravnaSluzbaText = data.data.SPRAVNA_TEXT;
	    				}
	    			}
	    	)
	    };
	    
	    
	    refreshPredpis();
	    

    }
)

