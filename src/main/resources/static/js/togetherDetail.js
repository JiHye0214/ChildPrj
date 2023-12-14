const heartBtn = document.querySelector("#heart");

heartBtn.addEventListener("click", () => {
    if (heartBtn.classList.contains("zzim")) {
        heartBtn.classList.remove("zzim");
        heartBtn.style.fill = "#fff";
    } else {
        heartBtn.classList.add("zzim");
        heartBtn.style.fill = "rgb(255, 80, 80)";
    }
});
