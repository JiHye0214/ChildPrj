const listContent = document.querySelectorAll(".list-content");
const heartsBtn = document.querySelectorAll("#heart");

heartsBtn.forEach((heart, i) => {
    heart.addEventListener("click", () => {
        console.log(i);

        if (heart.classList.contains("zzim")) {
            heart.classList.remove("zzim");
            heart.style.fill = "#fff";

            $(".list-content").eq(i).fadeToggle("500");
        } else {
            heart.classList.add("zzim");
            heart.style.fill = "rgb(255, 80, 80)";
        }
    });
});
