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
<!--    <link href="<c:url value="/resources/css/main_home.css" />" media="screen,print" rel="stylesheet" type="text/css" />  -->
    <script src="<c:url value="/resources/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/ready.functions.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/fmo.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery-ui.js" />" type="text/javascript"></script>
    <!--[if (gte IE 7)]>
<!--    <link href="/stylesheets/ie_packaged.css?1408746701" media="screen,print" rel="stylesheet" type="text/css" />  -->
    <!-- [endif]-->
    <!--[if (gte IE 6)]>
<!--    <link href="/stylesheets/ie6_packaged.css?1408746701" media="screen,print" rel="stylesheet" type="text/css" /> -->
    <!-- [endif]-->
<!--    <script src="/javascripts/common_packaged.js?1408746686" type="text/javascript"></script>  -->
    <!--[if (gte IE 6)]>
<!--    <script src="/javascripts/vendor/ie-css3.js?1374117531" type="text/javascript"></script> -->
    <!-- [endif]-->
    <!--[if (gte IE 6)&(lt IE 7)]>
<!--    <script src="/javascripts/ie6_packaged.js?1408746686" type="text/javascript"></script> -->        
    <!-- [endif]-->
<!--     <link href="/stylesheets/main_home_packaged.css?1408746701" media="screen,print" rel="stylesheet" type="text/css" /> -->
<!-- <script src="/javascripts/main_home_packaged.js?1408746688" type="text/javascript"></script> -->
<title>Slovenská pošta</title>
<!--    <link href="/stylesheets/print_packaged.css?1408746701" media="print" rel="stylesheet" type="text/css" />  -->
  </head>
  <body id="home">
    <div class="site-wrapper">
      <div class="site-header" style="position: relative">
<!--         <a href="http://www.posta.sk"> -->  
          <img alt="Slovenská pošta" class="logo" src="<c:url value="/resources/img/sl-posta-logo.png" />" title="Slovenská pošta" />  
<!--        </a>            -->

        <div class="site-nav-top">
<!--     
          <span class="lang-switch">
            <a href="http://www.posta.sk/en">
              <span>EN</span>
              <span class="right">&nbsp;</span>
            </a>
          </span>
          <ul>
            <li><a href="http://www.posta.sk/informacie/informacie" class="first">Informácie</a></li>
            <li><a href="http://kariera.posta.sk">Kariéra</a></li>
            <li><a href="http://www.posta.sk/mapa-stranky">Mapa stránky</a></li>
            <li><a href="http://www.posta.sk/kontakty/kontakty" class="lastitem">Kontakty</a></li>
          </ul>
-->
        </div>
        <div class="site-search">
          <input id="searchPredpisInput" type="text" value="" class="noautocomplete" />
          <div class="site-search-results hide">
        </div>
      </div>     
      
      
      
      
    </div>

      <div class="site-nav-main">
        <ul>
          <li class="logout border-left border-right">
            <a href="/boc-BOC/login"><span class="ico"></span>Logout</a>
          </li>
          <li class="add_predpis border-left">
            <a href="javascript:{}" ><span class="ico"></span>Pridaj predpis</a>
          </li>
          <li id="poradove_cislo">
            <label>P.č.</label>
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
Zmena hesla
</div>
<div class="site-area-bottom chpass inithide"></div>
<!--
  <div class="services-navi" id="services-navi">
  <ul class="level0">
        <li><a href="http://www.posta.sk/sluzby/listove-zasielky">Listové zásielky</a></li>
        <li><a href="http://www.posta.sk/sluzby/baliky">Balíky</a></li>
        <li><a href="http://www.posta.sk/sluzby/expres-zasielky">Expres zásielky</a></li>
        <li><a href="http://www.posta.sk/sluzby/penazne-sluzby">Peňažné služby</a></li>
        <li><a href="http://www.posta.sk/sluzby/reklamne-sluzby">Reklamné služby</a></li>
        <li><a href="http://www.posta.sk/sluzby/spracovanie-zasielok">Spracovanie zásielok</a></li>
        <li><a href="http://www.posta.sk/sluzby/sluzby-statu">Služby štátu</a></li>
        <li><a href="http://www.posta.sk/sluzby/postshop">POSTshop</a></li>
        <li><a href="http://www.posta.sk/sluzby/ostatne-sluzby">Ostatné služby</a></li>
        <li><a href="http://www.posta.sk/sluzby/filatelia">Filatelia</a></li>
        <li><a href="http://www.posta.sk/sluzby/faq-casto-kladene-otazky">FAQ - často kladené otázky</a></li>
      </ul>
  <div></div>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Listové zásielky" src="/subory/37023/listove_zasielky_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/listova-zasielka">Listová zásielka</a></li>
        <li><a href="http://www.posta.sk/sluzby/listova-zasielka-svet">Listová zásielka svet</a></li>
        <li><a href="http://www.posta.sk/sluzby/doporucena-zasielka">Doporučená zásielka</a></li>
        <li><a href="http://www.posta.sk/sluzby/doporucena-zasielka-svet">Doporučená zásielka svet</a></li>
        <li><a href="http://www.posta.sk/sluzby/poistena-zasielka">Poistená zásielka</a></li>
        <li><a href="http://www.posta.sk/sluzby/poistena-zasielka-svet">Poistená zásielka svet</a></li>
        <li><a href="http://www.posta.sk/sluzby/uradna-zasielka">Úradná zásielka</a></li>
        <li><a href="http://www.posta.sk/sluzby/zmluvny-list">Zmluvný list</a></li>
        <li><a href="http://www.posta.sk/sluzby/zmluvna-tlac">Zmluvná tlač</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Balíky" src="/subory/37035/baliky_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/balik">Balík</a></li>
        <li><a href="http://www.posta.sk/sluzby/balik-svet">Balík svet</a></li>
        <li><a href="http://www.posta.sk/sluzby/zmluvny-balik">Zmluvný balík</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Expres zásielky" src="/subory/37034/expresne_zasielky_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/expres-kurier-60">Expres Kuriér 60</a></li>
        <li><a href="http://www.posta.sk/sluzby/expres-kurier">Expres Kuriér</a></li>
        <li><a href="http://www.posta.sk/sluzby/expres-mail-servis-ems">Expres Mail Servis</a></li>
        <li><a href="http://www.posta.sk/sluzby/obchodny-balik-epg">EPG</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Peňažné služby" src="/subory/37033/penazne_sluzby_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/postovy-poukaz-na-ucet">Poštový poukaz na účet</a></li>
        <li><a href="http://www.posta.sk/sluzby/postovy-poukaz-na-adresu">Poštový poukaz na adresu</a></li>
        <li><a href="http://www.posta.sk/sluzby/postovy-poukaz-na-vyplatu">Poštový poukaz na výplatu</a></li>
        <li><a href="http://www.posta.sk/sluzby/postovy-poukaz-ekonomicky">Poštový poukaz ekonomický</a></li>
        <li><a href="http://www.posta.sk/sluzby/western-union">Western Union</a></li>
        <li><a href="http://www.posta.sk/sluzby/sipo">SIPO</a></li>
        <li><a href="http://www.posta.sk/sluzby/dochodky-a-davky">Dôchodky a dávky</a></li>
        <li><a href="http://www.posta.sk/sluzby/sepa">SEPA</a></li>
        <li><a href="http://www.posta.sk/sluzby/sluzby-postovej-banky">Poštová banka</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Reklamné služby" src="/subory/37032/reklamne_sluzby_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/letaky">Letáky</a></li>
        <li><a href="http://www.posta.sk/sluzby/epops">ePoPS</a></li>
        <li><a href="http://www.posta.sk/sluzby/sipo-reklama">SIPO reklama</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Spracovanie zásielok" src="/subory/37031/spracovanie_zasielok_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/postservis-1">POSTservis</a></li>
        <li><a href="http://www.posta.sk/sluzby/edokument">Digitalizácia obálok a dokumentov</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Služby štátu" src="/subory/37468/sluzby-statu_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/platobny-system-e-kolok">Platobný systém E-KOLOK</a></li>
        <li><a href="http://www.posta.sk/sluzby/eso-sluzby-statu">e.so - služby štátu na pošte</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="POSTshop" src="/subory/37030/postshop_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/postshop-obchod-na-poste">POSTshop - obchod na pošte</a></li>
        <li><a href="http://www.postshop.sk/b2c/b2c/start.do">POSTshop - e-shop</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Ostatné služby" src="/subory/37028/ostatne_sluzby_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/predplatne-novin-a-casopisov">Predplatné novín a časopisov</a></li>
        <li><a href="http://www.posta.sk/sluzby/sluzby-tipos">TIPOS</a></li>
        <li><a href="http://www.posta.sk/sluzby/postove-priecinky">Poštové priečinky</a></li>
        <li><a href="http://www.posta.sk/sluzby/zberne-jazdy">Zberné jazdy</a></li>
        <li><a href="http://www.posta.sk/sluzby/consignment">Consignment</a></li>
        <li><a href="http://www.posta.sk/sluzby/colne-prerokovanie-zasielok">Colné prerokovanie zásielok</a></li>
        <li><a href="http://www.posta.sk/sluzby/kopirovacie-sluzby">Kopírovacie služby</a></li>
        <li><a href="http://www.posta.sk/sluzby/prevod-cennych-papierov-na-fnm-sr">Prevod cenných papierov na FNM SR</a></li>
        <li><a href="http://www.posta.sk/sluzby/ticketportal">Ticketportal</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="Filatelia" src="/subory/37029/filatelia_2_small.jpg" />
    </li>
    
        <li><a href="http://www.posta.sk/sluzby/postova-filatelisticka-sluzba">Poštová filatelistická služba</a></li>
        <li><a href="http://mojaznamka.sk">Moja známka</a></li>
      </ul>
    <ul class="level1 hide">
    
    <li class="icon">
      <img alt="FAQ - často kladené otázky" src="/subory/37490/faq_small.jpg" />
    </li>
    
      </ul>
  </div>

<div class="promo-slider royalSlider iskin">
  <ul class="royalSlidesContainer">
    
    <li class="royalSlide">
        <a href="http://www.posta.sk/sluzby/eso-sluzby-statu">
    <img alt="banner" src="http://www.posta.sk/subory/37428/banner-vypis-register-trestov.png" />
  </a>

    </li>
    
    <li class="royalSlide">
        <a href="http://eph.posta.sk/">
    <img alt="banner" src="http://www.posta.sk/subory/36998/epodaci-harok-novy.png" />
  </a>

    </li>
    
    <li class="royalSlide">
        <a href="http://www.posta.sk/sluzby/eso-sluzby-statu">
    <img alt="banner" src="http://www.posta.sk/subory/37421/vypis-listu-vlastnictva-banner.png" />
  </a>

    </li>
    
    <li class="royalSlide">
        <a href="http://www.posta.sk/stranky/nedorucovat">
    <img alt="banner" src="http://www.posta.sk/subory/37304/banner-nedorucovat-131204.png" />
  </a>

    </li>
      </ul>
</div>

-->
<div class="site-area-top newpred inithide"></div>
<div class="site-area-main newpred inithide">
    
  <div class="area-post">
      <form id="new_predpis" action="/boc-BOC/addPredpis" method="post">
        <div id="nominal_div">
<!--  <div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="bvd3EDmGDVNADtADy1pQW/EI76g3NZkBilWt3uahuCs=" /></div>  -->
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
<!--               <button type="submit" class="btn btn-blue"><span>Odoslať</span></button> -->
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
<!-- 
  <div class="cleft">
  <div class="box-460 tabs">
    <div class="top">
      <ul id="tabview-left">
        <li><a class="first" href="#news-tab">Aktuálne</a></li>
      </ul>
    </div>
    <div id="news-tab" class="news">

<div class="bottom empty">
  
</div>
<script type="text/javascript">
//<![CDATA[
initNewsTab("a");
//]]>
</script>
</div>
  </div>
</div>

<div class="cright">
  <div class="box-460 tabs">
    <div class="top">
      <ul id="tabview-right">
        <li><a class="first" href="#inquiry-tab">Anketa</a></li>
        <li><a href="#napiste-nam">Napíšte nám</a></li>
      </ul>
    </div>
    <div id="inquiry-tab" class="inquiry"><div class="main">
    
  <p>Pri objednaní tovaru z e-shopu by ste uprednostnili vyzdvihnutie balíka na vami zvolenej pošte pred doručením cez kuriéra? </p>
  
  <ul>
        
    <li>
      <a href="/do.inquiry_vote/261" rel="#inquiry-tab">áno, bez ohľadu na výšku poštovného</a>      <span class="bar" style="width:35%"></span>
      <span class="percent">35%</span>
    </li>
        
    <li>
      <a href="/do.inquiry_vote/262" rel="#inquiry-tab">áno, ale len v prípade nižšieho poštovného</a>      <span class="bar" style="width:46%"></span>
      <span class="percent">46%</span>
    </li>
        
    <li>
      <a href="/do.inquiry_vote/263" rel="#inquiry-tab">nie</a>      <span class="bar" style="width:15%"></span>
      <span class="percent">15%</span>
    </li>
        
    <li>
      <a href="/do.inquiry_vote/264" rel="#inquiry-tab">neviem</a>      <span class="bar" style="width:4%"></span>
      <span class="percent">4%</span>
    </li>
      </ul>
  </div>
<div class="bottom hr">
  <ul>
        <li>Počet hlasov : <strong>186</strong></li>
        <li><a href="/do.inquiry_archive" rel="#inquiry-tab">Archív ankiet</a></li>
  </ul>
</div>
<script type="text/javascript">
//<![CDATA[
initInquiryTab();
//]]>
</script>
</div>
    <div id="napiste-nam" class="writeus"><div class="main">
  <p class="head">
    Prostredníctvom tohto formulára môžete získať viac informácií o našich produktoch a službách. Napíšte nám vašu požiadavku a naši zamestnanci vás budú kontaktovať v čo najkratšom termíne.</br>
    <i>Pozn.: Tento formulár neslúži na podanie reklamácie.</i>
  </p>
  
    <form action="/do.writeus" method="post" rel="#napiste-nam"><div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="bvd3EDmGDVNADtADy1pQW/EI76g3NZkBilWt3uahuCs=" /></div>
  <div class="form">
    <p class="form-select">
    <label>Typ zákazníka</label>
  
    <select class="text" id="customer" inline="true" name="customer"><option value="person">Občan</option>
<option value="businessman">Podnikateľ</option>
<option value="organization">Firma</option></select>
  
</p>
    <p class="form-text">
    <label>Meno</label>
      
  
  <input class="text" id="name" inline="true" name="name" type="text" />
  
  
</p>
    <p class="form-text">
    <label>Email</label>
      
  
  <input class="text" id="email" inline="true" name="email" type="text" />
  
  
</p>
    <p class="form-text">
    <label>Telefón</label>
      
  
  <input class="text" id="phone" inline="true" name="phone" type="text" />
  
  
</p>

    <p class="form-select">
    <label>Téma</label>
  
    <select class="select" id="theme" inline="true" name="theme"><option value="otázky k poskytovaným službám">otázky k poskytovaným službám</option>
<option value="žiadosť o cenovu ponuku">žiadosť o cenovu ponuku</option>
<option value="stretnutie s obchodníkom">stretnutie s obchodníkom</option>
<option value="ine">ine</option></select>
  
</p>
    <p class="form-textarea">
  <label>Vaša požiadavka</label>
  <textarea class="textarea" id="message" name="message"></textarea>
  
</p>

    <p class="form-captcha">
  <label>Opíšte kód</label>
  
  <img src="/do.captcha/6a28333ab60dc40e42f4eeb7a2a96144d2c7141c" alt="" />
  <input class="text short noautocomplete" id="captcha" name="captcha" type="text" value="" />
  
</p>

    <p class="submit">
      <button type="submit" class="btn btn-blue"><span>Odoslať</span></button>
    </p>
  </div>
  </form>  <p class="foot">
    Odoslaním vyplneného formulára udeľujem v súlade so zákonom č.122/2013 Z.z. o ochrane osobných údajov a o zmene a doplnení niektorých zákonov spoločnosti Slovenská pošta, a.s., IČO 36 631 124, Partizánska cesta 9, 975 99 Banská Bystrica súhlas na spracúvanie mojich osobných údajov v rozsahu uvedenom v tomto formulári na účely poskytnutia informácií o produktoch a službách Slovenskej pošty, a.s. Tento súhlas udeľujem na dobu neurčitú. Súhlas som oprávnený písomne kedykoľvek odvolať v zmysle § 28 zákona č.122/2013 Z.z.
  </p>
</div>
<div class="bottom empty"></div>
<script type="text/javascript">
//<![CDATA[
initWriteusTab();
//]]>
</script>
</div>
  </div>
</div>

-->  
</div>    
<p>${output}</p>
  </body>
</html>



<!-- 
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/blended_layout.css" />" rel="stylesheet" type="text/css">
<title>Page Title</title>
<meta name="description" content="Write some words to describe your html page">
</head>
<body>
<div class="blended_grid">
<div class="pageHeader">
<P>  The time on the server bla bla bla is ${serverTime}. </P>
</div>
<div class="pageLeftMenu">
<P>  The time on the server bla bla bla is ${serverTime}. </P>
</div>
<div class="pageContent">
<P>  The time on the server bla bla bla is ${serverTime}. 1 package org.apache.tomcat.maven.plugin.tomcat7.run; 2 /* 3 * Licensed to the ... You may obtain a copy of the License at 10 * 11 * http://www.apache.org/licenses/LICENSE-2.0 ... MojoExecutionException; 33 import org.apache.maven.plugin. ..... created 401 * @throws MojoExecutionException in case of an error creating ... </P>

</div>
<div class="pageFooter">
</div>
</div>
</body>
</html>

 -->