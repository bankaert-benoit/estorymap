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
	let mcd = document.getElementById("mcd-filepicker").files[0];
	//let bpmn = document.getElementById("bpmn-filepicker").files[0];
	let mfc = document.getElementById("mfc-filepicker").files[0];

	//if ( mcd == null | undefined || bpmn == null | undefined || mfc == null | undefined ) {
	//	alert("Please add all 3 file before uploading...");
	//} else {
		formData.append('mcd',mcd);
	//	formData.append('bpmn',bpmn);
		formData.append('mfc',mfc);

		let response = await fetch("upload", {
			method: "POST",
			body: formData
		});
		if (response.status == 204){
			alert("Error : empty file");
		}
		if ( response.status == 200) {
			alert("File successfully upload.");
	}
	//}
	
}
