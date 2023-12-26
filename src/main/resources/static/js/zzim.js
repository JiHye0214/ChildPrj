const heartsBtns = document.querySelectorAll("#heart");

heartsBtns.forEach((heart, i) => {
    heart.addEventListener("click", () => {

        heart.style.fill = "#fff";
        // $(".list-content").eq(i).fadeToggle("200");
        $("[name='zzimFrm']").attr({
            "method": "POST",
            "action": "deleteZzim"
        }).submit();

        // if (heart.classList.contains("zzim")) {
        //     heart.classList.remove("zzim");
        //     heart.style.fill = "#fff";
        //
        //     $(".list-content").eq(i).fadeToggle("500");
        // } else {
        //     heart.classList.add("zzim");
        //     heart.style.fill = "rgb(255, 80, 80)";
        // }
    });
});
