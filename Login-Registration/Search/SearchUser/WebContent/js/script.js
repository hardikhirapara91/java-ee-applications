function validate() {
	var args = Array.prototype.slice.call(arguments), e = args[0];
	var password = document.getElementById('password').value, confirmPassword = document
			.getElementById('confirm').value, username = document
			.getElementById('username').value;

	if (password != confirmPassword) {
		alert("Passwords Don't Match");
		e.cancelBubble = true;
		e.returnValue = false;
		if (e.preventDefault) {
			e.preventDefault();
		}
		return false;
	} else {
		return true;
	}
}
function addEventHandler(node, evt, func) {
	if (node.addEventListener)
		node.addEventListener(evt, func);
	else
		node.attachEvent("on" + evt, func);
}
function initializeAll() {
	addEventHandler(document.getElementById('regForm'), 'submit', validate);
}
addEventHandler(window, 'load', initializeAll);
/* ============================================================== */
// Invoke the callback-oriented method.
$(function() {
	$('#username').keyup(
			function(e) {
				checkUsernameAvailibility(successHandler, failHandler, $(
						'#username').val(), "u");
			});
});
// ==========================================================

// Now, let's create a mock function that makes use of the
// success and fail callback handlers.
var checkUsernameAvailibility = function(successHandler, failHandler, username,
		type) {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.responseText.trim() == "true") {
				return (successHandler());
			} else {
				return (failHandler());
			}
		}
	}
	xmlhttp.open("POST", "user_availibility.jsp?username=" + username, true);
	xmlhttp.send();
};
// Define a success handler.
var successHandler = function() {
	$("#availibility").text(
			"Username is not available, please try different username.").css(
			"color", "red");
	document.getElementById("username").focus();
	$('#submit').attr("disabled", true);
};
// Define a fail handler.
var failHandler = function() {
	$("#availibility").text("");
	$('#submit').removeAttr("disabled");
	return true;
};