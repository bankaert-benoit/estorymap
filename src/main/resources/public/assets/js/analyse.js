window.onload = function progressbar()
{
    var elem = document.getElementById("progress-bar");
    elem.style.innerText = "#ffffff"
    var largueur = 0;
    var id = setInterval(progression, 700);
    
    function progression()
    {
        if(largueur < 100)
            {
                largueur = largueur + 20;
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
    document.getElementById("box").setAttribute("style", "margin: 100px 0;padding: 50px 0;");
    testTrueFalse();
}

function testTrueFalse()
{
    var url = window.location.search;
    var queue_url = url.substring (url.lastIndexOf( "/" )+1 );
    if(queue_url == "true")
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