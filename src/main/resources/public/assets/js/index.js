document.getElementById("project-name").onchange = function () {
	document.getElementById("create-project").setAttribute("href",`/createProject?name=${document.getElementById("project-name").value}`);
}

function connect(){
    window.url = "/oauth2/authorization/google";
}