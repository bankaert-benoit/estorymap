fetch("isAuth").then(response => response.json()).then(json => updateLogButton(json));

function updateLogButton(isAuth) {
	if(isAuth){
		document.getElementById("login-button").setAttribute("style","display:none;");
		document.getElementById("user-pic").setAttribute("style","display:initial;border-radius:50%;border-style: solid;border-color:white;");
		fetch("profilePic").then(res => {
			return res.json();
		}).then(json => {
			document.getElementById("user-pic").setAttribute("src",json.url);
		});
	} else {
		document.getElementById("user-pic").setAttribute("style","display:none;");
	}
	
}

async function uploadFile() {
	let formData = new FormData();
	let file = document.getElementById("filepicker").files[0];
	

	formData.append('file',file);

	let response = await fetch("upload", {
		method: "POST",
		body: formData
	});

	if ( response.status == 200) {
		alert("File successfully upload.");
	}
}