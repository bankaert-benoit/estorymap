let isAuth;
fetch("isAuth").then(response => response.json()).then(json => {
	isAuth = json;
	updateLogButton(json)
});



function updateLogButton(isAuth) {
	if(isAuth){
		document.getElementById("login-button").setAttribute("style","display:none;");
		document.getElementById("user-pic").setAttribute("style","display:initial;");
		fetch("profilePic").then(res => {
			return res.json();
		}).then(json => {
			document.getElementById("user-pic").setAttribute("src",json.url);
			document.getElementById("user-pic").setAttribute("style","border-radius: 50%;width: 50px;height: 50px;margin: auto;");
		});
	} else {
		document.getElementById("user-pic").setAttribute("style","display:none;");
	}
	
}
