fetch("isAuth").then(response => {
    return response.json();
}).then(json => updateLogButton(json));

function updateLogButton(isAuth) {
	if(isAuth){
		document.getElementById("login-button").setAttribute("style","display:none;");
		document.getElementById("user-pic").setAttribute("style","display:initial;");
		fetch("profilePic").then(res => {
			return res.json();
		}).then(json => {
			document.getElementById("user-pic").setAttribute("src",json.url);
		});
	} else {
		document.getElementById("user-pic").setAttribute("style","display:none;");
	}
	
}