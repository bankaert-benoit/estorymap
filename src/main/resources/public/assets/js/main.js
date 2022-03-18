let isAuth;
fetch("isAuth").then(response => response.json()).then(json => {
	isAuth = json;
	updateLogButton(json)
});

function connect(){
	window.url = "/oauth2/authorization/google";
}

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

function uploadFile() {
    
    let file = document.getElementById("import-file").files[0];
    let formData = new FormData();
    
    if(document.getElementById("formCheck-1").checked)
        {
            formData.append('bpmn',bpmn);
        } else {
            if(document.getElementById("formCheck-2").checked)
                {
                    formData.append('mfc',mfc);
                } else {
                    if(document.getElementById("formCheck-3").checked)
                        {
                            formData.append('mcd',mfc);
                        } else {
                            alert("Veuillez sélectionner le type du diagramme");
                        }
                }
        }
    formData.append('file', file);
    
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
}

function createProject() {
	if (isAuth) {
		let formData = new FormData();
		let name = document.getElementById("project-name").value;
		formData.append("name",name);
		fetch("/createProject", {
			method: "POST",
			body: formData
		});
	}
}