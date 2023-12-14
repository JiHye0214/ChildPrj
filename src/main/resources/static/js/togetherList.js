const heartsBtn = document.querySelectorAll("#heart");

heartsBtn.forEach((heart) => {
    heart.addEventListener("click", () => {
        if (heart.classList.contains("zzim")) {
            heart.classList.remove("zzim");
            heart.style.fill = "#fff";
        } else {
            heart.classList.add("zzim");
            heart.style.fill = "rgb(255, 80, 80)";
        }
    });
});
