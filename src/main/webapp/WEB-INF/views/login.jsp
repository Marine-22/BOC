<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sk" lang="sk">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="Author" content="SlovenskÃ¡ poÅ¡ta, a.s." />
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
		</div>

		<div class="site-nav-main">
			<ul></ul>
		</div>

		<div class="site-area-top"></div>
		<div class="site-area-main">
			<div class="area-post">
				<form id="login_user" action="${pageContext.request.contextPath}/loginUser" method="post">
					<div id="nominal_div">
						<!--  <div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="bvd3EDmGDVNADtADy1pQW/EI76g3NZkBilWt3uahuCs=" /></div>  -->
						<p class="form-text">
							<label>Id zamestnanca (login)</label> <input class="text"
								id="login" inline="true" name="login" type="text" />
						</p>

						<p class="form-text">
							<label>Heslo</label> 
							<input class="text" id="pass" inline="true" name="pass" type="password" /> 
						</p>
						<p class="bottom-form-info errmsg">${loginError}</p>
						<p class="submit login_submit">
							<a class="blue_button" href="javascript:{}"
								onclick="document.getElementById('login_user').submit();">Prihlásiť</a>
						</p>
					</div>
				</form>
			</div>
		</div>
		<div class="site-area-bottom"></div>
	</div>
</body>
</html>