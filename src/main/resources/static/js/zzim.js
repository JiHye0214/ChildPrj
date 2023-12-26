const heartsBtns = document.querySelectorAll("#heart");
const heartForm = document.querySelectorAll(".content-zzimBtn");

heartsBtns.forEach((heart, i) => {
    heart.addEventListener("click", () => {

        heartForm[i].name = i;

        heart.style.fill = "#fff";
        // $(".list-content").eq(i).fadeToggle("200");
        heartForm[i].submit();

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
