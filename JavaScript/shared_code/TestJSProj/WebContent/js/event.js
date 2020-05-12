

function showMsg() {
	alert("Added focus to uname textbox");
}

function showBlurMsg() {
	alert("Lost focus to uname textbox");
}
function copyMsg() {
	var unameVal = document.getElementById("username").value;
	document.getElementById("pwd").value = unameVal;
	console.log("copyMsg: ", unameVal);
}