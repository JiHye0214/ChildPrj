const heartsBtns = document.querySelectorAll(".heart");
const heartForm = document.querySelectorAll(".content-zzimBtn");

heartsBtns.forEach((heart, i) => {
    heart.addEventListener("click", () => {
        heart.style.fill = "#fff";
        // $(".list-content").eq(i).fadeToggle("400");
        heartForm[i].name = i;
        heartForm[i].submit();
    });
});
