const queryString = window.location.search;
const urlParam = new URLSearchParams(queryString);
let projetName;
let projetId;
fetch(`getProject?id=${urlParam.get("id")}`).then(response => response.json()).then(json => {
    projetName = json.name;
    projetId = json.id;
    document.getElementById("project-name").value = projetName;
});

async function uploadFile() {
    
    let file = document.getElementById("import-file").files[0];
    let formData = new FormData();
    
    if(document.getElementById("formCheck-1").checked)
        {
            formData.append('type','bpmn');
        } else {
            if(document.getElementById("formCheck-2").checked)
                {
                    formData.append('type','mfc');
                } else {
                    if(document.getElementById("formCheck-3").checked)
                        {
                            formData.append('type','mcd');
                        } else {
                            alert("Veuillez sélectionner le type du diagramme");
                        }
                }
        }
    formData.append('file', file);
    formData.append('id-projet',projetId);
    
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
    document.getElementById("compare-btn").setAttribute("href",`/compare?id=${projetId}`);
    document.getElementById("file-list").value = `${document.getElementById("file-list").value}\n${file.name}`;
}



window.onload = function progressbar()
{
    var elem = document.getElementById("progress-bar");
    elem.style.innerText = "#ffffff"
    var largueur = 0;
    var id = setInterval(progression, 600);
    
    function progression()
    {
        if(largueur < 100)
            {
                largueur = largueur + 25;
                elem.style.width = largueur + "%";
                elem.innerText = largueur + "%";
            } else {
                clearInterval(id);
                hideandshow();
            }
    }
}

function hideandshow()
{
    document.getElementById("analyse").setAttribute("style", "display:none;");
    document.getElementById("tips-box").setAttribute("style", "margin: 100px 0;padding: 50px 0;");
    testTrueFalse();
}

function testTrueFalse()
{
    var url = window.location.search;
    var queue_url = new URLSearchParams(url);
    console.log(queue_url.get("success"));
    if(queue_url.get("success") == "true")
        {
            success();
        } else {
            failure();
        }
}

function succes()
{
    document.getElementById("success").setAttribute("style", "display:initial;");
}

function failure()
{
    document.getElementById("failure").setAttribute("style", "display:initial;");
}



