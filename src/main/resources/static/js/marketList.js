const searchInput = document.querySelector("#search-input");
const searchInputVal = document.querySelector("#search-input-val");
const btn = document.querySelector("#initial-btn");

searchInputVal.value = searchInput.value;
searchInput.oninput = (e) => {
    searchInputVal.value = e.target.value;
}

btn.onclick = () => {
    if (searchInputVal.value) {
        searchInputVal.value = "";

        $("[name='orderFrm']").attr({
            "method": "POST",
            "action": "orderWay"
        }).submit();
    }
}

$("[name='orderWay']").change(() => {
    $("[name='orderFrm']").attr({
        "method": "POST",
        "action": "orderWay"
    }).submit();
});
