const searchInput = document.querySelector("#search-input");
const searchInputVal = document.querySelector("#search-input-val");
const initialBtn = document.querySelector("#initial-btn");

searchInputVal.value = searchInput.value;
searchInput.oninput = (e) => {
    searchInputVal.value = e.target.value;
}

initialBtn.onclick = () => {
    if (searchInputVal.value) {
        searchInputVal.value = "";

        $("[name='orderFrm']").attr({
            "method": "POST",
            "action": "orderWay"
        }).submit();
    }
}

$("[name='postOrderWay']").change(() => {
    $("[name='orderFrm']").attr({
        "method": "POST",
        "action": "orderWay"
    }).submit();
});
