var GLOBAL_APP_NAME = '/${build.finalName}';

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
//	errs += checkRequired("#konanie");
	errs += checkRequired("#sluzba");
	var jsonData = new Object();	
	jsonData.idnom = [];
	var finalCount = 0;
	$(".nominal input").each(function(index){
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
//		jsonData.konanie = $("#konanie").val();
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
//	$('#konanie')	.val("");
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
		window.location.replace(GLOBAL_APP_NAME + d.redirect);
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
//	$("#konanie_err"	).text("");
	$("#sluzba_err"		).text("");
	$("#idnom_err"		).text("");
	$("#poradove_err"	).hide();
	$("#datum_err"		).hide();
	$("#urad_err"		).hide();
	$("#doklad_err"		).hide();
//	$("#konanie_err"	).hide();
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
					var isAdmin = (data.data[i].idZamLogin == "admin");
					htmlBlock += 
							"<li class=\"dynamic-li\"> \
									<span class=\"data\">("+data.data[i].idZamLogin+")</span> \
									<div class=\"name-surname\"> \
											<span class=\"data data-admin table-surname\" data-selector=\".new-surname\" data-zamid=\""+data.data[i].idZamLogin+"\">"+data.data[i].priezvisko+"</span> \
											<input class=\"dynamic-data-update new-surname\" data-selector=\".table-surname\" type=\"text\" style=\"width: 80px; display:none\" value=\""+data.data[i].priezvisko+"\" /> \
											<span class=\"data data-admin table-name\" data-selector=\".new-name\" data-zamid=\""+data.data[i].idZamLogin+"\">"+data.data[i].meno+"</span> \
											<input class=\"dynamic-data-update new-name\" data-selector=\".table-name\" type=\"text\" style=\"width: 80px; display:none\" value=\""+data.data[i].meno+"\" /> \
									</div> \
									<span class=\"data data-admin "+(isAdmin? "" : "table-active")+" "+(data.data[i].active ? "ACTIVE" : "UNACTIVE")+"\" data-active-bool-value=\""+data.data[i].active+"\" data-zamid=\""+data.data[i].idZamLogin+"\">"+(data.data[i].active ? "Aktívny" : "Neaktívny") +"</span> \
									<span class=\"data data-admin\">Heslo:</span> \
									<span class=\"data data-admin table-password\" data-zamid=\""+data.data[i].idZamLogin+"\">****</span> \
									<input class=\"update-table-password new-pass\" data-zamid=\""+data.data[i].idZamLogin+"\" type=\"password\" style=\"width: 80px; float:left; display:none\" /> \
									<span class=\"update-table-password data data-admin\" style=\"width: 101px; padding:0px 10px; display:none\">Zopakovať heslo:</span> \
									<input class=\"update-table-password repeat-pass\" type=\"password\" style=\"width: 80px; float:left; display:none\" /> \
									<a class=\"update-table-password red_button\" href=\"javascript:{}\" onclick=\"updatePassword(true)\" style=\"padding:4px 8px 3px; margin-left: 8px; line-height: 1; display:none\">X</a> \
									<a class=\"update-table-password blue_button\" href=\"javascript:{}\" onclick=\"updatePassword()\" style=\"padding:4px 8px 3px; margin-left: 8px; line-height: 1; display:none\">Uložiť</a>\
									<br/>"+(ismsie() ? "<br/>" : "")+" \
								<span class=\"sub-data "+(isAdmin ? "" : "table-user-type")+"\" data-enum-val=\"" + data.data[i].userType + "\" data-zamid=\""+data.data[i].idZamLogin+"\">" + getUserType(data.data[i].userType) + "</span> \
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

	var states = [$('#filter-loaded').prop('checked'), 
	              $('#filter-waiting').prop('checked'),
	              $('#filter-processed').prop('checked'),
	              $('#filter-error').prop('checked')];
	
	$.getJSON(GLOBAL_APP_NAME + "/searchPredpis",
		{
			urad:$('#searchUradId').text(),
			datumPredajaOd:$("#searchDatumOdInput").val(),
			datumPredajaDo:$("#searchDatumDoInput").val(),
			datumPridaniaOd:$("#searchDatumPridaniaOdInput").val(),
			datumPridaniaDo:$("#searchDatumPridaniaDoInput").val(),
			datumSyncOd:$("#searchDatumSyncOdInput").val(),
			datumSyncDo:$("#searchDatumSyncDoInput").val(),
			states:states,
			sq:$("#searchPredpisInput").val(),
			page:$("div#paginDiv").pagination('getCurrentPage'),
			JSR:""
		},
		function(data){
			if(checkRedirect(data) && checkErrs(data)){
				$("li.dynamic-li").remove();
				var htmlBlock = "";
				var idNoms = "";
				var listPredpis = data.data.l;
				for(var i = 0; i < listPredpis.length; i++){
					for(var j = 0; j < listPredpis[i].idnom.length; j++){
						if(j == 0){
							idNoms = listPredpis[i].idnom[j];
						}
						else{
							idNoms += "; " + listPredpis[i].idnom[j];
						}
					}
					//data.data[i].datum
					//datumPridania
					//datumSync
					
					var errBlock = "";
					if(listPredpis[i].errorMsg){
						errBlock = "<br/> \
							<span class=\"data-label long-label error_predpis\">Chyba:</span> \
							<span class=\"data long error_predpis\">" + listPredpis[i].errorMsg + "</span>";
					}
//					<span class=\"data-label\">Č. konania:</span> \  Vyhodene zo stringu dole
//					<span class=\"data\">"+data.data[i].konanie+"</span> \

					
					htmlBlock += "<li class=\"dynamic-li\"> \
									<span class=\"data-label\">P.č.:</span> \
									<span class=\"data\" style=\"width: 35px;\">"+listPredpis[i].poradove+"</span> \
									<span class=\"data-label\">Č. dokladu/konania:</span> \
									<span class=\"data\" style=\"width: 220px;\">"+listPredpis[i].doklad+"</span> \
									<span class=\"data-label\">Pridal:</span> \
									<span class=\"data\" style=\"width:150px\">"+listPredpis[i].fullName+"</span> \
									<span class=\"data-label\">Stav:</span> \
									<span class=\"data "+listPredpis[i].stav+"\" style=\"width:"+(listPredpis[i].stav == "PROCESSED" ? "60" : "100")+"px\">"+getStav(listPredpis[i].stav)+"</span> \
									"+(listPredpis[i].stav == "PROCESSED" ? ("<span class=\"data-label\">"+(listPredpis[i].idPredpisu == null ? "" : ("(" + listPredpis[i].idPredpisu + ")"))+"</span>") : "") + " \
									"+((listPredpis[i].stav == "ERROR" && isSuperUser(data)) ? "<a href=\"javascript:{}\" class=\"blue_button\" style=\"padding: 4px 10px 3px; margin-left: 10px; line-height: 1;\" onclick=\"resendPredpis('"+listPredpis[i].id+"')\">Znovu</a>" : "")+" \
									<br/> \
									<span class=\"data-label\">Dátum spotreby:</span> \
									<span class=\"data\">" + getD(listPredpis[i].datumPredaja) + "</span> \
									<span class=\"data-label\">Dátum a čas pridania:</span> \
									<span class=\"data\">" + getDC(listPredpis[i].datumPridania) + "</span> \
									<span class=\"data-label\">Dátum a čas synchronizácie:</span> \
									<span class=\"data\">" + getDC(listPredpis[i].datumSync) + "</span> \
									<br/> \
									<span class=\"data-label long-label\">Služba:</span> \
									<span class=\"data long\">"+listPredpis[i].sluzbaName+"</span> \
									<br/> \
									<span class=\"data-label long-label\">Úrad:</span> \
									<span class=\"data long\">"+listPredpis[i].uradName+"</span> \
									" + errBlock + " \
									<br/> \
									<span class=\"data-label\">ID nominálov:</span> \
									<span class=\"sub-data\">"+idNoms+"</span> \
								</li>";
					
				}
				$("ul#table-ul").append(htmlBlock);
				  $("div#paginDiv").pagination({
					    items:data.data.totalCount,
					    itemsOnPage:10,
					    cssStyle: 'compact-theme',
					    currentPage:data.data.page,
					    onPageClick: function(){
					    	refreshPredpis();
					    }
					  });
				  
				// data.data.page - netreba
				
			}
		},
		'json'
	);
	// Potrebujem znovu nastavit X a Y suradnice checkboxov so stavmi. 
	// Mohlo sa to zmenit kvoli scrollbaru. 
	// prepareStates();
}

function getS(s){
	return s ? s : "[n/a]";
}

function getD(d){
	if(!d){
		return "[n/a]";
	}
	else{
		var datum = new Date(d);
		return (datum.getDate() < 10 ? "0" + datum.getDate() : datum.getDate()) + "." + (datum.getMonth() < 9 ? ("0" + (datum.getMonth() + 1)) : (datum.getMonth() + 1)) + "." + datum.getFullYear();
	}
}

function getDC(d){
	if(!d){
		return "[n/a]";
	}
	else{
		var datum = new Date(d);
		
		return (datum.getDate() < 10 ? "0" + datum.getDate() : datum.getDate()) + "." + (datum.getMonth() < 9 ? ("0" + (datum.getMonth() + 1)) : (datum.getMonth() + 1)) + "." + datum.getFullYear() + " " + (datum.getHours() < 10 ? ("0" + datum.getHours()) : datum.getHours()) + ":" + (datum.getMinutes() < 10 ? ("0" + datum.getMinutes()) : datum.getMinutes());
	}
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

function resendPredpis(id){
	$.post(GLOBAL_APP_NAME + '/resendPredpis',
			{
				id:		id,
				JSR:	""
			},
			function(data){
				if(checkRedirect(data) && checkErrs(data)){
					// nothing to do with that god damn data, just check
				}
			},
			"json"
	)
	refreshPredpis();
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

function prepareStates(){
	var stateFil = $('#searchStavInput').parent();
	//var posx = parseInt(stateFil.offset().left) - parseInt(stateFil.css('padding-left')) + 2;
	var posx = parseInt(stateFil.offset().left) - parseInt(stateFil.css('padding-left'));
	var posy = parseInt(stateFil.offset().top);
	$('#state-filter').offset({top:posy, left:posx});
	//$('#state-filter').hide();
}

function syncEnums(){
	$.getJSON(GLOBAL_APP_NAME + "/syncEnums",
			{},
			function(data){
				if(checkRedirect(data) && checkErrs(data)){
					
				}
			}
	);
	
}

function testConn(){
	$.getJSON(GLOBAL_APP_NAME + "/testConn",
			{},
			function(data){
				if(checkRedirect(data) && checkErrs(data)){
					
				}
			}
	);
}

function pepRefresh(){
	$.getJSON(GLOBAL_APP_NAME + "/pepRefresh",
			{},
			function(data){
				if(checkRedirect(data) && checkErrs(data)){
					
					$('#pepsluzby').text(data.data.SLUZBY.version + " ("+getDC(data.data.SLUZBY.datum)+")");
					$('#pepurady').text(data.data.URADY.version + " ("+getDC(data.data.URADY.datum)+")");
					$('#pepconn').text(data.data.CONN_TEST.version + " ("+getDC(data.data.CONN_TEST.datum)+")");
				}
			}
	);
}

/*
 getDC - na datum z longu
  
pepsluzby
pepurady
pepconn

{"status":"OK",
 "redirect":null,
 "reason":null,
 "errors":null,
 "fieldErrors":null,
 "userType":null,
 "data":
    {"SLUZBY":
        {"id":"54aff2e5c4b7426ef3fd8cdb",
        "name":"SLUZBY",
        "version":"23605473",
        "datum":1420817936019,
        "dateDatum":1420817936019},
     "URADY":
        {"id":"54aff2e5c4b7426ef3fd8cdc",
        "name":"URADY",
        "version":"23674449",
        "datum":1420817936019,
        "dateDatum":1420817936019},
     "CONN_TEST":
        {"id":"54aff2e1c4b7426ef3fd8cda",
        "name":"CONN_TEST",
        "version":"CHYBA",
        "datum":1420818046922,
        "dateDatum":1420818046922}
    }
}
 */

function isSuperUser(retVal){
	return retVal.userType == "SUPER_USER";
}

function isAdmin(retVal){
	return retVal.userType == "ADMIN";
}

function ismsie() {

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");

    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer, return version number
        return true;
    return false;
}