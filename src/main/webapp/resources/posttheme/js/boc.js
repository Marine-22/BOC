var GLOBAL_APP_NAME = '/boc-BOC';

function addNewPredpisElement(){
	
	var elem = $('.nominal:last input');
	if(elem.val().length == 10){
		elem = $('.nominal:first');
		var cln = elem.clone(true);
		cln.find("label").css('visibility', 'hidden');
		cln.find("a.red_button_small").show();
		cln.find("input").val("");
		cln.find("#idnom_err").text("");
		cln.find("#idnom_err").hide();
		cln.insertBefore($( "div#nominal_div p.submit"));
	}
}

function submitPredpisForm(){
	clearPredpisFormErrors();
	var errs = 0;
	errs += checkRequired("#poradove");
	errs += checkRequired("#datum");
	errs += checkRequired("#urad");
	errs += checkRequired("#doklad");
	errs += checkRequired("#konanie");
	errs += checkRequired("#sluzba");
	var jsonData = new Object();	
	jsonData.idnom = [];
	var finalCount = 0;
	ids = $(".nominal input").each(function(index){
		if($(this).val().length == 10){
			jsonData.idnom.push($(this).val());
			finalCount++;
		}
	});
	
	if(finalCount == 0){
		errs++;
		$('#idnom_err').text("Treba zadať aspoň 1 nominálny kolok.");
		$('#idnom_err').show();
	}
	if(errs == 0){
		jsonData.poradove = $("#poradove").val();
		jsonData.datum = $("#datum").val();
		jsonData.urad = $("#urad").val();
		jsonData.doklad = $("#doklad").val();
		jsonData.konanie = $("#konanie").val();
		jsonData.sluzba = $("#sluzba").val();
		jsonData.JSR = "";
		$.post(GLOBAL_APP_NAME + "/addPredpis", jsonData, 
				function(data){
					if(checkRedirect(data) && checkErrs(data)){
						var tmp_poradove = $("#poradove_cislo input").val();
						var int_porad;
						try{
							int_porad = parseInt(tmp_poradove);
							int_porad++;
						}catch(e){int_porad = tmp_poradove}
						$("#poradove_cislo input").val("" + int_porad);
						clearPredpisForm();
		    			$('.newpred').hide();
		    			refreshPredpis();
					}
				},
				"json"
		);
	}
}

function clearPredpisForm(){
	$('#poradove')	.val("");
	$('#datum')		.val("");
	$('#urad')		.val("");
	$('#urad_name')	.text("");
	$('#doklad')	.val("");
	$('#konanie')	.val("");
	$('#sluzba')	.val("");
	$('#sluzba_name').text("");
	$('.nominal:first input').val("");
	$('.nominal:not(:first)').remove();
}

function clearUserForm(){
	$('#idZamLogin').val("");
	$('#meno').val("");
	$('#priezvisko').val("");
	$('#heslo').val("");
	$('#repHeslo').val("");
}

function submitUserForm(){
	clearUserFormErrors();
	var errs = 0;
	errs += checkRequired('#idZamLogin');
	errs += checkRequired('#meno');    
	errs += checkRequired('#priezvisko');
	errs += checkRequired('#heslo');   
	errs += checkRequired('#repHeslo');
	if($('#heslo').val() != $('#repHeslo').val()){
		if($('#heslo_err').text().length > 0){
			$('#heslo_err').text($('#heslo_err').text() + "; Zadané heslá sa nezhodujú");
		}
		else{
			$('#heslo_err').show();
			$('#heslo_err').text("Zadané heslá sa nezhodujú");
		}
		errs++;
	}
	if(errs == 0){
		$.post($('#new_user').attr("action"),
				{
					idZamLogin:		$('#idZamLogin').val(),
					meno:			$('#meno').val(),
					priezvisko:		$('#priezvisko').val(),
					userType:		$('#userType :selected').val(),
					heslo:			$('#heslo').val(),
					repHeslo:		$('#repHeslo').val(),
					active:			"true",
					JSR:			""
				},
				function(data){
					if(checkRedirect(data) && checkErrs(data)){
						clearUserForm();
						$('.newuser').hide();
						refreshUsers();
					}
				},
				"json"
		)
	}
}

function checkRedirect(d){
	if(d.status == "REDIRECT"){
		if(d.reason){
			alert(d.reason);
		}
		window.location.replace(d.redirect);
		return false;
	}
	return true;
}

function checkErrs(d){
	if(d.status == "NOK"){
		if(d.errors){
			var errmsg = "";
			var index;
			for(index = 0; index < d.errors.length; index++){
				errmsg += "- " + d.errors[index] + "\n";
			}
			alert(errmsg);
		}
		if(d.fieldErrors){
			var index;
			for(index = 0; index < d.fieldErrors.length; index++){
				var item = d.fieldErrors[index];
				$(item.field).text(item.error);
				$(item.field).show();
			}
		}
		return false;
	}
	return true;
}


function clearPredpisFormErrors(){
	$("#poradove_err"	).text("");
	$("#datum_err"		).text("");
	$("#urad_err"		).text("");
	$("#doklad_err"		).text("");
	$("#konanie_err"	).text("");
	$("#sluzba_err"		).text("");
	$("#idnom_err"		).text("");
	$("#poradove_err"	).hide();
	$("#datum_err"		).hide();
	$("#urad_err"		).hide();
	$("#doklad_err"		).hide();
	$("#konanie_err"	).hide();
	$("#sluzba_err"		).hide();
	$("#idnom_err"		).hide();
}

function clearUserFormErrors(){
	$('#idZamLogin_err').text("");
	$('#meno_err')		.text("");
	$('#priezvisko_err').text("");
	$('#heslo_err')		.text("");
	$('#repHeslo_err')	.text("");
	$('#idZamLogin_err').hide();
	$('#meno_err')		.hide();
	$('#priezvisko_err').hide();
	$('#heslo_err')		.hide();
	$('#repHeslo_err')	.hide();
}

function checkRequired(fieldId){
	if($(fieldId).val() == ""){
		errs = 1;
		$(fieldId + '_err').text("Toto pole je povinné");
		$(fieldId + '_err').show();
		return 1;
	}
	return 0;
}

function refreshUsers(){
	$.getJSON(GLOBAL_APP_NAME + "/searchUsers",
		{sq:$("#searchUsersInput").val(),JSR:""},
		function(data){
			if(checkRedirect(data) && checkErrs(data)){
				$("li.dynamic-li").remove();
				var htmlBlock = "";
				for(var i = 0; i < data.data.length; i++){
					htmlBlock += 
							"<li class=\"dynamic-li\"> \
								<span class=\"data\">("+data.data[i].idZamLogin+")</span> \
								<div class=\"name-surname\"> \
										<span class=\"data table-surname\" data-selector=\".new-surname\" data-zamid=\""+data.data[i].idZamLogin+"\">"+data.data[i].priezvisko+"</span> \
										<input class=\"dynamic-data-update new-surname\" data-selector=\".table-surname\" type=\"text\" style=\"width: 80px; display:none\" value=\""+data.data[i].priezvisko+"\" /> \
										<span class=\"data table-name\" data-selector=\".new-name\" data-zamid=\""+data.data[i].idZamLogin+"\">"+data.data[i].meno+"</span> \
										<input class=\"dynamic-data-update new-name\" data-selector=\".table-name\" type=\"text\" style=\"width: 80px; display:none\" value=\""+data.data[i].meno+"\" /> \
								</div> \
								<span class=\"data table-active "+(data.data[i].active ? "ACTIVE" : "UNACTIVE")+"\" data-active-bool-value=\""+data.data[i].active+"\" data-zamid=\""+data.data[i].idZamLogin+"\">"+(data.data[i].active ? "Aktívny" : "Neaktívny") +"</span> \
								<span class=\"data\">Heslo:</span> \
								<span class=\"data table-password\" data-zamid=\""+data.data[i].idZamLogin+"\">****</span> \
								<input class=\"update-table-password new-pass\" data-zamid=\""+data.data[i].idZamLogin+"\" type=\"password\" style=\"width: 80px; float:left; display:none\" /> \
								<span class=\"update-table-password data\" style=\"width: 100px; padding:0px 10px; display:none\">Zopakovať heslo:</span> \
								<input class=\"update-table-password repeat-pass\" type=\"password\" style=\"width: 80px; float:left; display:none\" /> \
								<a class=\"update-table-password red_button\" href=\"javascript:{}\" onclick=\"updatePassword(true)\" style=\"padding:4px 10px 3px; margin-left: 10px; line-height: 1; display:none\">X</a> \
								<a class=\"update-table-password blue_button\" href=\"javascript:{}\" onclick=\"updatePassword()\" style=\"padding:4px 10px 3px; margin-left: 10px; line-height: 1; display:none\">Uložiť</a> \
								<br/> \
								<span class=\"sub-data table-user-type\" data-enum-val=\"" + data.data[i].userType + "\" data-zamid=\""+data.data[i].idZamLogin+"\">" + getUserType(data.data[i].userType) + "</span> \
								<select class = \"dynamic-data-update new-user-type\" style=\"display:none;\"> \
									<option value=\"USER\">Používateľ</option> \
									<option value=\"SUPER_USER\">Super Používateľ</option> \
									<option value=\"ADMIN\">Správca</option> \
								</select> \
							</li>";
				}
				$("ul#table-ul").append(htmlBlock);
				setUserUpdates();
			}
		},
		'json'
	);
}

function refreshPredpis(){

	$.getJSON(GLOBAL_APP_NAME + "/searchPredpis",
		{
			urad:$('#searchUradId').text(),
			datumOd:$("#searchDatumOdInput").val(),
			datumDo:$("#searchDatumDoInput").val(),
			sq:$("#searchPredpisInput").val(),
			JSR:""
		},
		function(data){
			if(checkRedirect(data) && checkErrs(data)){
				$("li.dynamic-li").remove();
				var htmlBlock = "";
				var idNoms = "";
				for(var i = 0; i < data.data.length; i++){
					for(var j = 0; j < data.data[i].idnom.length; j++){
						if(j == 0){
							idNoms = data.data[i].idnom[j];
						}
						else{
							idNoms += "; " + data.data[i].idnom[j];
						}
					}
					var datum = new Date(data.data[i].datum);
	
					var date_day = datum.getDate();
					var date_month = datum.getMonth();
					var date_year = datum.getFullYear();
					
					var errBlock = "";
					if(data.data[i].errorMsg){
						errBlock = "<br/> \
							<span class=\"data-label long-label error_predpis\">Chyba:</span> \
							<span class=\"data long error_predpis\">" + data.data[i].errorMsg + "</span>";
					}
					
					htmlBlock += "<li class=\"dynamic-li\"> \
									<span class=\"data-label\">P.č.:</span> \
									<span class=\"data\">"+data.data[i].poradove+"</span> \
									<span class=\"data-label\">Č. dokladu:</span> \
									<span class=\"data\">"+data.data[i].doklad+"</span> \
									<span class=\"data-label\">Č. konania:</span> \
									<span class=\"data\">"+data.data[i].konanie+"</span> \
									<span class=\"data-label\">Dátum:</span> \
									<span class=\"data\">"+date_day + "." + date_month + "." + date_year +"</span> \
									<span class=\"data-label\">Pridal:</span> \
									<span class=\"data\" style=\"width:150px\">"+data.data[i].fullName+"</span> \
									<span class=\"data-label\">Stav:</span> \
									<span class=\"data "+data.data[i].stav+"\" style=\"width:100px\">"+getStav(data.data[i].stav)+"</span> \
									<br/> \
									<span class=\"data-label long-label\">Služba:</span> \
									<span class=\"data long\">"+data.data[i].sluzbaName+"</span> \
									<br/> \
									<span class=\"data-label long-label\">Úrad:</span> \
									<span class=\"data long\">"+data.data[i].uradName+"</span> \
									" + errBlock + " \
									<br/> \
									<span class=\"data-label\">ID nominálov:</span> \
									<span class=\"sub-data\">"+idNoms+"</span> \
								</li>";
					
				}
				$("ul#table-ul").append(htmlBlock);
			}
		},
		'json'
	);

}

function getStav(stav){
	if("LOADED" == stav){
		return "NAHRANÉ";
	}
	else if("WAITING" == stav){
		return "SPRACOVÁVA SA";	
	}
	else if("PROCESSED" == stav){
		return "PEP OK";
	}
	else if("ERROR" == stav){
		return "PEP CHYBA";
	}
}

function setUserUpdates(){
	$('.table-surname').dblclick(function(e){
		initUdateField($(this), "priezvisko");
	});
	$('.table-name').dblclick(function(e){
		initUdateField($(this), "meno");
	});
	$('.table-user-type').dblclick(function(e){
		initUpdateSpravca($(this));
	});
	$('.table-password').dblclick(function(e){
		initUpdateHeslo($(this));
	});
	$('.table-active').dblclick(function(e){
		initUpdateActive($(this));
	});
}


function initUpdateActive(jqelem){
	var zamId = jqelem.attr("data-zamid");
	var boolData = jqelem.attr("data-active-bool-value");
	boolData = (boolData == "true" ? "false" : "true");
	$.post(GLOBAL_APP_NAME + "/updateUser", 
			{zamId:zamId, field:"active", value:boolData, JSR:""},
			function(data){
				if(checkRedirect(data) && checkErrs(data)){
					jqelem.removeClass(boolData == "true" ? "UNACTIVE" : "ACTIVE");
					jqelem.attr("data-active-bool-value", boolData);
					jqelem.addClass(boolData == "true" ? "ACTIVE" : "UNACTIVE");
				}
			},
			"json");
	jqelem.text("" + (boolData == "true" ? "Aktívny" : "Neaktívny"));
}

function initUpdateHeslo(jqelem){
	jqelem.hide();
	jqelem.siblings('.update-table-password').show();
	jqelem.siblings('.repeat-pass').keypress(function(e){
		if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
			updatePassword();
		}
	});
}

function updatePassword(cancel){
	cancel = (typeof cancel !== 'undefined' ? cancel : false);
	var newpass = $('input.new-pass:visible').val();
	var reppass = $('input.repeat-pass:visible').val();
	$('input.new-pass:visible').siblings('span.errmsg').remove();
	if(cancel){
		$('input.new-pass:visible').siblings("span.table-password").show();
		$(".update-table-password:visible").hide();
		$("input.update-table-password").val("");
	}
	else if(newpass != reppass){
		$('input.repeat-pass:visible').after('<span class="errmsg">Nezhoda!</span>');
	}
	else{
		var zamId = $('input.new-pass:visible').attr("data-zamid");
		$.post(GLOBAL_APP_NAME + "/updateUser", 
				{zamId:zamId, field:"heslo", value:newpass, JSR:""},
				function(data){
					if(checkRedirect(data) && checkErrs(data)){
						// nothing to do
					}
				},
				'json');
		$('input.new-pass:visible').siblings("span.table-password").show();
		$(".update-table-password:visible").hide();
		$("input.update-table-password").val("");
	}
}

function initUpdateSpravca(jqelem){
	var jqelemNew = jqelem.siblings('.new-user-type');
	jqelemNew.val(jqelem.attr('data-enum-val'));
	jqelem.hide();
	jqelemNew.show();
	
	jqelemNew.click(function(e){
		e.stopPropagation();
		return false;
	});
	
	$(document).click(function(){
		updateSpravca(jqelem, jqelemNew)
		$(this).off('click');
	});
}

function updateSpravca(jqelem, jqelemNew){
	var dataOrig = jqelem.attr("data-enum-val");
	var dataNew = jqelemNew.children('option').filter(':selected').val();
	var zamId = jqelem.attr("data-zamid");
	if(dataOrig != dataNew){
		$.post(GLOBAL_APP_NAME + "/updateUser", 
				{zamId:zamId, field:'userType', value:dataNew, JSR:""},
				function(data){
					if(checkRedirect(data) && checkErrs(data)){
						// nothing
					}
				},
				'json');
	}
	jqelem.text(getUserType(dataNew));
	jqelem.show();
	jqelemNew.hide();
	return true;
}

function initUdateField(jqelem, dbFieldName){
	var selector = jqelem.attr("data-selector");
	var jqelemNew = jqelem.siblings(selector);
	jqelem.hide();
	jqelemNew.show();

	jqelemNew.click(function(e){
		e.stopPropagation();
		return false;
	});
	
	jqelemNew.keypress(function(e){
		if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
			var ok = updateUser(jqelem, jqelemNew, dbFieldName);
			if(ok){
				$(document).off('click');
			}
		}
	});
	$(document).click(function(){
		var ok = updateUser(jqelem, jqelemNew, dbFieldName);
		if(ok){
			$(this).off('click');
		}
	});
}

function updateUser(jqelem, jqelemNew, field){
	var dataOrig = jqelem.text();
	var dataNew = jqelemNew.val();
	var zamId = jqelem.attr("data-zamid");
	if(dataNew.length == 0){
		jqelemNew.css("border-color", "#C00");
		return false;
	}
	else{
		if(dataOrig != dataNew){
			$.post(GLOBAL_APP_NAME + "/updateUser", 
					{zamId:zamId, field:field, value:dataNew, JSR:""},
					function(data){
						if(checkRedirect(data) && checkErrs(data)){
							// nothing
						}
					},
					'json'
			);
		}
		jqelem.text(dataNew);
		jqelem.show();
		jqelemNew.hide();
	}
	return true;
}

function clearChPassForm(){
	$("#oldpass").val("");
	$("#newpass").val("");
	$("#reppass").val("");
}

function submitChPassForm(){
	$('.bottom-form-info').text("");
	var oldPass = $("#oldpass").val();
	var newpass = $("#newpass").val();
	var reppass = $("#reppass").val();
	if(newpass != reppass){
		$('.bottom-form-info').text("Heslo a kontrola hesla sa nezhodujú!");
	}
	else{
		$.post(GLOBAL_APP_NAME + "/updatePass", 
				{oldPass:oldPass, newPass:newpass, JSR:""}, 
				function(data){
					if(checkRedirect(data) && checkErrs(data)){
						clearChPassForm();
						$(".chpass.inithide").hide();
					}
				},
				'json'
		);
	}
}

function getUserType(uType){
	if("ADMIN" == uType){
		return "Správca";
	}
	else if("USER" == uType){
		return "Používateľ";
	}
	else if("SUPER_USER" == uType){
		return "Super používateľ";
	}
	else{
		return "unknown";
	}
}