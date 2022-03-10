fetch("/isAuth").then(response => {
    return response.json;
}).then(json => {
    console.log(`${json.length}`)
})