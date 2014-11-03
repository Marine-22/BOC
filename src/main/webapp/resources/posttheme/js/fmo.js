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
		$.post("/boc-BOC/addPredpis", jsonData, function(data){
			if(data == "OK"){
				var tmp_poradove = $("#poradove_cislo input").val();
				var int_porad;
				try{
					int_porad = parseInt(tmp_poradove);
					int_porad++;
				}catch(e){int_porad = tmp_poradove}
				$("#poradove_cislo").val("" + int_porad);
				clearPredpisForm();
    			$('.newpred').hide();
			}
		});
	}
}

function clearPredpisForm(){
	$('#poradove')	.val("");
	$('#datum')		.val("");
	$('#urad')		.val("");
	$('#doklad')	.val("");
	$('#konanie')	.val("");
	$('#sluzba')	.val("");
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
		document.getElementById('new_user').submit();
	}
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
	$.getJSON("/boc-BOC/searchUsers",
		{sq:$("#searchUsersInput").val()},
		function(data){
			// zmazem data
			$("li.dynamic-li").remove();
			var htmlBlock = "";
			for(var i = 0; i < data.length; i++){
				htmlBlock += 
						"<li class=\"dynamic-li\"> \
							<span class=\"data\">("+data[i].idZamLogin+")</span> \
							<div class=\"name-surname\"> \
									<span id=\"table-surname\" class=\"data\">"+data[i].priezvisko+"</span> \
									<span id=\"table-name\" class=\"data\">"+data[i].meno+"</span> \
							</div> \
							<span class=\"data\">Heslo:</span> \
							<span id=\"table-password\" class=\"data\">****</span> \
							<br/> \
							<span id=\"table-spravca\" class=\"sub-data\">"+(data[i].spravca ? "Správca" : "Používateľ")+"</span> \
						</li>";
			}
			$("ul#table-ul").append(htmlBlock);
	});
}

function refreshPredpis(){
	$.getJSON("/boc-BOC/searchPredpis",
		{sq:$("#searchPredpisInput").val()},
		function(data){
			$("li.dynamic-li").remove();
			var htmlBlock = "";
			var idNoms = "";
			for(var i = 0; i < data.length; i++){
				for(var j = 0; j < data[i].idnom.length; j++){
					if(j == 0){
						idNoms = data[i].idnom[j];
					}
					else{
						idNoms += "; " + data[i].idnom[j];
					}
				}
				var datum = new Date(data[i].datum);

				var date_day = datum.getDate();
				var date_month = datum.getMonth();
				var date_year = datum.getFullYear();
				
				htmlBlock += "<li class=\"dynamic-li\"> \
								<span class=\"data-label\">P.č.:</span> \
								<span class=\"data\">"+data[i].poradove+"</span> \
								<span class=\"data-label\">Č. dokladu:</span> \
								<span class=\"data\">"+data[i].doklad+"</span> \
								<span class=\"data-label\">Č. konania:</span> \
								<span class=\"data\">"+data[i].konanie+"</span> \
								<span class=\"data-label\">Dátum:</span> \
								<span class=\"data\">"+date_day + "." + date_month + "." + date_year +"</span> \
								<span class=\"data-label\">Služba:</span> \
								<span class=\"data min-width-80\">"+data[i].sluzba+"</span> \
								<span class=\"data-label\">Úrad:</span> \
								<span class=\"data min-width-80\">"+data[i].urad+"</span> \
								<br/> \
								<span class=\"data-label\">ID nominálov:</span> \
								<span class=\"sub-data\">"+idNoms+"</span> \
							</li>";
				
			}
			$("ul#table-ul").append(htmlBlock);
		}
	);
}


/*
function myFunction()
{
var itm=document.getElementById("myList2").lastChild;
var cln=itm.cloneNode(true);
document.getElementById("myList1").appendChild(cln);
}
*/