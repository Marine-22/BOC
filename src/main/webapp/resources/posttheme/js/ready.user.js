var defSudnaSluzba = null;
var defSpravnaSluzba = null;
var defSudnaSluzbaText = null;
var defSpravnaSluzbaText = null;
var sluzbaId = null;

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
    				countAndSetAmount();
    			}
    			else{
    				var last = $(".nominal .red_button_small:last");
    				if(last[0] == j[0]){
    					j.siblings("input.text").val("");
    				}
    				else{
    					j.parent().remove();
    				}
    			}
    		}
    		else{ // len == 0, mozno musim vymazat element
    			var last = $(".nominal .red_button_small:last");
    			if(last[0] != j[0]){
    				j.parent().remove();
    			}
    		}
    	});
    	
    	$(".nominal input.text").keyup(function(e) {
    		if($(this).val().length == 10){
    			// kontrola, ci uz takyto kreditny kolok nie je v zozname
    			var list = $(".nominal input.text");
    			var exists = false;
    			for(var i = 0; i < list.length; i++){
    				if($(this)[0] != list[i] && list[i].value == $(this).val()){
    					exists = true;
    					break;
    				}
    			}
    			if(!exists){
	    			addNewPredpisElement();
	    			countAndSetAmount();
    			}
    			else{
    				$(this).val("");
    			}
    			$('.nominal:last input').focus();
    		}
    	});
    	
    	$(".nominal input.text").on('paste', function(e) {
    		var thiz = $(this);
    		setTimeout(function(){
    			if(thiz.val().length == 10){
        			// kontrola, ci uz takyto kreditny kolok nie je v zozname
        			var list = $(".nominal input.text");
        			var exists = false;
        			for(var i = 0; i < list.length; i++){
        				if(thiz[0] != list[i] && list[i].value == thiz.val()){
        					exists = true;
        					break;
        				}
        			}
        			if(!exists){
    	    			addNewPredpisElement();
    	    			countAndSetAmount();
        			}
        			else{
        				thiz.val("");
        			}
        			$('.nominal:last input').focus();
        		}
    		}, 100);
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
    			$('#sluzbaSuma').val(ui.item.suma == null ? "Neurčitá" : (ui.item.suma + "€"));
    			$("select#cenaZlava").empty();
    			$("select#cenaZlava").append("<option value=\"1\">Štandardná</option>");
    			$("input.nasobnostClass").attr("readonly", "");
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
				    						$("#feeType").val("spravny");
				    					}
				    					else{ // SUDNY
				    						$("#sluzba").val(defSudnaSluzba);
				    						$("#feeType").val("sudny");
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
	    
	    
	    
	    $('#sluzba').focusin(function(){
	    	sluzbaId = $(this).val();
	    });
	    
	    $('#sluzba').focusout(function(){
	    	if(sluzbaId === $(this).val()) return;
	    	var thiz = $(this);
			$(".nasobnostClass").attr("readonly", "");
			$(".cenaClass").attr("readonly", "");
			$("select#cenaZlava").empty();
			$("select#cenaZlava").append("<option value=\"1\">Štandardná</option>");
			
	    	if(thiz.val() == defSudnaSluzba){
				thiz.css("border","");
				$("#sluzba_err").text("");
				$("#sluzba_err").hide();
				$("#sluzba_name").text(defSudnaSluzbaText);
				$("#sluzba_name").show();
				countAndSetAmount();
				//$("#sluzbaSuma").val("0€");
	    	}
	    	else if(thiz.val() == defSpravnaSluzba){
				thiz.css("border","");
				$("#sluzba_err").text("");
				$("#sluzba_err").hide();
				$("#sluzba_name").text(defSpravnaSluzbaText);
				$("#sluzba_name").show();
				countAndSetAmount();
				//$("#sluzbaSuma").val("0€");
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
			    					$("#sluzbaSuma").val(data.data.suma == null ? "Neurčitá" : (data.data.suma + "€"));
			    	    			
			    					// CHR 55
			    					// discountEnable - ak je true, moze zadat lubovolnu cenu
			    					// multipleMax - max kolko moze zadat
			    					// multipleMin - ak je zadany, moze zvolit nasobok
			    					// electronicAmount - ak je zadany, potom moze dat elektricku cenu

		    	    				$("select#cenaZlava").attr("data-amount", (data.data.suma == null ? "Neurčitá" : (data.data.suma)));
			    	    			if(data.data.electronicAmount){
			    	    				$("select#cenaZlava").removeAttr("readonly");
			    	    				$("select#cenaZlava").append("<option value=\"2\">Elektronická</option>");
			    	    				$("select#cenaZlava").attr("data-electronic-amount", data.data.electronicAmount);
			    	    			}
			    	    			if(data.data.discountEnable){
			    	    				$("select#cenaZlava").removeAttr("readonly");
			    	    				$("select#cenaZlava").append("<option value=\"3\">So zľavou</option>");
			    	    			}
			    	    			
			    	    			// ak su aj nasobnost aj zadavanie ceny, potom zobrazim cenu s width=38
			    	    			$("input#nasobnostSluzby").val(1);
		    	    				if(data.data.multipleMin){
		    	    					$("input#nasobnostSluzby").removeAttr("readonly");
				    	    			$("input#nasobnostSluzby").attr("data-multiple-min", data.data.multipleMin);
			    	    				$("input#nasobnostSluzby").attr("data-multiple-max", data.data.multipleMax);
		    	    				}
		    	    				else{
				    	    			$("input#nasobnostSluzby").attr("data-multiple-min", 1);
			    	    				$("input#nasobnostSluzby").attr("data-multiple-max", 1);
		    	    				}
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
				$("input#nasobnostSluzby").val(1);
	    	}
	    });
	    
    	$("select#cenaZlava").change(function(){
    		if($("select#cenaZlava option:selected").val() == 1){
    			$("#sluzbaNasob_name").hide();
				$("input#sluzbaSuma").attr("readonly", "");
    			$("input#sluzbaSuma").val($("select#cenaZlava").attr("data-amount") + "€");
    		}
    		else if($("select#cenaZlava option:selected").val() == 2){
    			$("#sluzbaNasob_name").hide();
				$("input#sluzbaSuma").attr("readonly", "");
    			$("input#sluzbaSuma").val($("select#cenaZlava").attr("data-electronic-amount") + "€");
    		}
    		else if($("select#cenaZlava option:selected").val() == 3){
    			$("input#sluzbaSuma").removeAttr("readonly");
    			$("input#sluzbaSuma").val($("select#cenaZlava").attr("data-amount") + "€");
    			$("#sluzbaNasob_name").show();
    		}
    	});
    	
    	$("input#sluzbaSuma").focusout(function(){
    		var amount = $("input#sluzbaSuma").val();
    		if(amount.indexOf("€", this.length - 1) !== -1){
    			amount=amount.substring(0, amount.indexOf("€"));
    		}
    		amount = parseFloat(amount.replace(",", "."));
    		if(isNaN(amount)){
    			$("input#sluzbaSuma").val("Neurčitá");
    		}
    		else{
    			$("input#sluzbaSuma").val(amount + "€");
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
	    
		  $("div#paginDiv").pagination({
			    items:10,
			    itemsOnPage:10,
			    cssStyle: 'compact-theme',
			    onPageClick: function(){
			    	refreshPredpis();
			    }
			  });
		  
	    refreshPredpis();
	    
	    if(ismsie()){
	    	$('input').placeholder();
	    }
    }
)

