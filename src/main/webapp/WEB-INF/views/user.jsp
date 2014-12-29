<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sk" lang="sk">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="Author" content="Slovenská pošta, a.s." />
    <meta name="viewport" content="width=1024" />
    <meta content='<acronym title="Internet Explorer">IE</acronym>=EmulateIE7' http-equiv="X-UA-Compatible" />
    <link type="image/x-icon" rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" />
    <link href="<c:url value="/resources/css/common.css" />" media="screen,print" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/jquery-ui.css" />" media="screen,print" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/ready.user.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/boc.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery-ui.js" />" type="text/javascript"></script>

<title>Slovenská pošta</title>
  </head>
  <body id="home">
    <div class="site-wrapper">
      <div class="site-header" style="position: relative">
          <img alt="Slovenská pošta" class="logo" src="<c:url value="/resources/img/sl-posta-logo.png" />" title="Slovenská pošta" />  
       
       <div class="site-search">
          <input id="searchDatumOdInput" type="text" value="" class="del_button small" placeholder="-- Predaj od --" />
       </div>
              
       <div class="site-search">
          <input id="searchDatumDoInput" type="text" value="" class="del_button small" placeholder="-- Predaj do --"/>
       </div>
       
       <div class="site-search">
          <input id="searchDatumPridaniaOdInput" type="text" value="" class="del_button small" placeholder="-- Pridané od --" />
       </div>
              
       <div class="site-search">
          <input id="searchDatumPridaniaDoInput" type="text" value="" class="del_button small" placeholder="-- Pridané do --"/>
       </div>
       
       <div class="site-search">
          <input id="searchDatumSyncOdInput" type="text" value="" class="del_button small" placeholder="-- Synch od --" />
       </div>
              
       <div class="site-search">
          <input id="searchDatumSyncDoInput" type="text" value="" class="del_button small" placeholder="-- Synch do --"/>
       </div>
       
       <div class="site-search">
          <input id="searchUradInput" type="text" value="" class="del_button" placeholder="-- Úrad --"/>
          <span id="searchUradId" class="hide"></span>
       </div>    
       
       <div class="site-search">
          <input id="searchStavInput" type="text" value="" class="del_button" placeholder="-- Stav --" maxlength="0" />
       </div> 
       
      
       <div class="site-search">
          <input id="searchPredpisInput" class="search_button" type="text" value=""  />
       </div>
      
      
    </div>

      <div class="site-nav-main">
        <ul>
          <li class="logout border-left border-right">
            <a href="${pageContext.request.contextPath}/login"><span class="ico"></span>Logout</a>
          </li>
          <li class="add_predpis border-left">
            <a href="javascript:{}" ><span class="ico"></span>Pridaj predpis</a>
          </li>
          <li id="poradove_cislo">
            <label>P.č.</label>
            <input type="text" />
          </li>
          <li id="uradpicker">
            <label>Úrad</label>
            <input type="text" />
          </li>
          <li id="datepicker" class="border-right">
          	<label>Dátum</label>
          	<input type="text" />
          </li>
          <li class="change_pass border-left">
            <a href="javascript:{}"><span class="ico"></span>Zmena hesla</a>
          </li>
            </ul>
      </div>

<div class="site-area-top chpass inithide"></div>
<div class="site-area-main chpass inithide">
				<div class="area-post">
				<form id="change-password" action="${pageContext.request.contextPath}/updatePass" method="post">
					<div id="chpass_div">
						<!--  <div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="bvd3EDmGDVNADtADy1pQW/EI76g3NZkBilWt3uahuCs=" /></div>  -->
						<p class="form-text">
							<label>Aktuálne heslo:</label> <input class="text"
								id="oldpass" inline="true" name="oldpass" type="password" />
						</p>
						<p class="form-text">
							<label>Nové heslo:</label> 
							<input class="text" id="newpass" inline="true" name="newpass" type="password" /> 
						</p>
						<p class="form-text">
							<label>Zopakovať nové heslo:</label> 
							<input class="text" id="reppass" inline="true" name="reppass" type="password" /> 
						</p>
						<p class="bottom-form-info errmsg">${loginError}</p>
						<p class="submit chpass_submit">
							<a class="red_button" href="javascript:{}"	onclick="clearChPassForm();">Zmazať formulár</a>
							<a class="blue_button" href="javascript:{}"	onclick="submitChPassForm();">Uložiť</a>
						</p>
					</div>
				</form>
			</div>
</div>
<div class="site-area-bottom chpass inithide"></div>

<div class="site-area-top newpred inithide"></div>
<div class="site-area-main newpred inithide">
    
  <div class="area-post">
      <form id="new_predpis" action="${pageContext.request.contextPath}/addPredpis" method="post">
        <div id="nominal_div">
            <p class="form-text">
              <label>Poradové číslo</label>
                <input class="text" id="poradove" inline="true" name="poradove_cislo" type="text" readonly/>
                <span id="poradove_err" class="inithide errmsg"></span>
            </p>
            
            <p class="form-text">
              <label>Dátum</label>
                <input class="text" id="datum" inline="true" name="datum" type="text" readonly />
                <span id="datum_err" class="inithide errmsg"></span>
            </p>
            
            <p class="form-text">
              <label>Úrad</label>
                <input class="text" id="urad" inline="true" name="urad" type="text" readonly />
                <span id="urad_err" class="inithide errmsg"></span>
                <span id="urad_name" class="sub-data"></span>
            </p>
            
            <p class="form-text">
              <label>Číslo dokladu</label>
                <input class="text" id="doklad" inline="true" name="doklad" type="text" />
                <span id="doklad_err" class="inithide errmsg"></span>
            </p>
        
            <p class="form-text">
              <label>Číslo konania</label>
              <input class="text" id="konanie" inline="true" name="konanie" type="text" />
                <span id="konanie_err" class="inithide errmsg"></span>
            </p>
        
            <p class="form-text">
              <label>ID služby</label>
              <input class="text" id="sluzba" inline="true" name="sluzba" type="text" />
                <span id="sluzba_err" class="inithide errmsg"></span>
                <span id="sluzba_name" class="sub-data"></span>
            </p>
            
            <p class="form-text nominal">
              <label>ID nominálnych kolkov</label>
              <input class="text" id="idnom" inline="true" name="idnom" type="text" maxlength="10" />
              <span id="idnom_err" class="inithide errmsg"></span>
              <a class="red_button_small" href="javascript:{}" >-</a>
            </p>
        
            <p class="submit">
              <a class="red_button" href="javascript:{}" onclick="clearPredpisForm();">Zmazať formulár</a>
              <a class="blue_button" href="javascript:{}" onclick="submitPredpisForm();">Odoslať</a>
            </p>
        </div>
      </form>
  </div>
</div>
<div class="site-area-bottom newpred inithide"></div>

<div class="site-area-top listdata"></div>
<div class="site-area-main listdata">
			<div class="cleft">
				<div class="box-940 tabs">
					<div id="news-tab" class="news ui-tabs-panel" style="display: block;">
							
						<div class="main">
							<ul id="table-ul">

							</ul>
						</div>
					</div>
				</div>
			</div>
</div>
<div class="site-area-bottom listdata"></div>
</div>    
<ul id="state-filter" tabindex="0" class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content" style="display:none">
	<li tabindex="-1" id="state-filter-li1" class="ui-menu-item">NAHRANÉ<input id="filter-loaded" type="checkbox" checked/></li>
	<li tabindex="-1" id="state-filter-li2" class="ui-menu-item">SPRACOVÁVA SA<input id="filter-waiting" type="checkbox" checked /></li>
	<li tabindex="-1" id="state-filter-li3" class="ui-menu-item">PEP OK<input id="filter-processed" type="checkbox" checked /></li>
	<li tabindex="-1" id="state-filter-li4" class="ui-menu-item">PEP CHYBA<input id="filter-error" type="checkbox" checked /></li>
</ul>
  </body>
</html>
