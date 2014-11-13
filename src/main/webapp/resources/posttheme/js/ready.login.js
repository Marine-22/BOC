$(document).ready(
    function()
    {
    	$('.inithide').hide();
    	
	    $("#login_user input#pass").keypress(function (e) {
	        if ((e.which && e.which == 13) || (e.keyCode && e.keyCode == 13)) {
	            $('#login_user a.blue_button').click();
	        }
	    });
    }
)