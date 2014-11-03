<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sk" lang="sk">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="Author" content="Slovenská pošta, a.s." />
<meta name="viewport" content="width=1024" />
<meta
	content='<acronym title="Internet Explorer">IE</acronym>=EmulateIE7'
	http-equiv="X-UA-Compatible" />
<link type="image/x-icon" rel="shortcut icon"
	href="<c:url value="/resources/img/favicon.ico" />" />
<link href="<c:url value="/resources/css/common.css" />"
	media="screen,print" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/ready.functions.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/fmo.js" />"
	type="text/javascript"></script>
<title>Slovenská pošta</title>
</head>
<body id="home">
	<div class="site-wrapper">
		<div class="site-header" style="position: relative">
			<img alt="Slovenská pošta" class="logo"
				src="<c:url value="/resources/img/sl-posta-logo.png" />"
				title="Slovenská pošta" />
			<div class="site-nav-top"></div>
			<div class="site-search">
				<input id="searchUsersInput" type="text" value="" class="noautocomplete" />
				<div class="site-search-results hide"></div>
			</div>
		</div>

		<div class="site-nav-main">
			<ul>
	          <li class="logout border-left border-right">
	            <a href="${pageContext.request.contextPath}/login"><span class="ico"></span>Logout</a>
	          </li>
				<li class="add_user"><a href="javascript:{}"><span
						class="ico"></span>Pridaj používateľa</a>
				</li>
			</ul>
		</div>
		<div class="site-area-top newuser inithide"></div>
		<div class="site-area-main newuser inithide">

			<div class="area-post">
				<form id="new_user" action="${pageContext.request.contextPath}/addUser" method="post">
					<div id="nominal_div">
						<!--  <div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="bvd3EDmGDVNADtADy1pQW/EI76g3NZkBilWt3uahuCs=" /></div>  -->
						<p class="form-text">
							<label>Id zamestnanca (login)</label> <input class="text"
								id="idZamLogin" inline="true" name="idZamLogin" type="text" />
							<span id="idZamLogin_err" class="inithide errmsg"></span>
						</p>

						<p class="form-text">
							<label>Meno</label> <input class="text" id="meno" inline="true"
								name="meno" type="text" /> <span id="meno_err"
								class="inithide errmsg"></span>
						</p>

						<p class="form-text">
							<label>Priezvisko</label> <input class="text" id="priezvisko"
								inline="true" name="priezvisko" type="text" /> <span
								id="priezvisko_err" class="inithide errmsg"></span>
						</p>

						<p class="form-text">
							<label>Správca</label> <input class="checkbox" id="spravca"
								inline="true" name="spravca" type="checkbox" /> <span
								id="spravca_err" class="inithide errmsg"></span>
						</p>

						<p class="form-text">
							<label>Heslo</label> <input class="text" id="heslo" inline="true"
								name="heslo" type="password" /> <span id="heslo_err"
								class="inithide errmsg"></span>
						</p>

						<p class="form-text">
							<label>Zopakovať heslo</label> <input class="text" id="repHeslo"
								inline="true" name="repHeslo" type="password" /> <span
								id="repHeslo_err" class="inithide errmsg"></span>
						</p>

						<p class="submit">
							<a class="red_button" href="javascript:{}"
								onclick="clearUserForm();">Zmazať formulár</a> <a
								class="blue_button" href="javascript:{}"
								onclick="submitUserForm();">Odoslať</a>
						</p>
					</div>
				</form>
			</div>
		</div>
		<div class="site-area-bottom newuser inithide"></div>

		<div class="site-area-top listdata"></div>
		<div class="site-area-main listdata">
			<div class="cleft">
				<div class="box-940 tabs">
					<div id="news-tab" class="news ui-tabs-panel"
						style="display: block;">

						<div class="main">
							<ul id="table-ul">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="site-area-bottom listdata"></div>
</body>
</html>