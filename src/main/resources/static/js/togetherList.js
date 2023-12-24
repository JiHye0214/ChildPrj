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

// --------------------------------------------------

const types = document.querySelectorAll(".type");
const typeValInput = document.querySelector("#type-val-input");
const typeVal = document.querySelector("#type-val");

if (typeVal.textContent == null) {
    types[0].classList.add("active");
}

types.forEach((type) => {
    if (type.textContent == typeVal.textContent) {
        type.classList.add("active");
    }

    type.addEventListener("click", () => {
        if (!type.classList.contains("active")) {
            types.forEach((el) => {
                el.classList.remove("active");
            })
            type.classList.add("active");

            typeValInput.value = type.textContent;

            $("[name='typeFrm']").attr({
                "method": "POST",
                "action": "typeSelect"
            }).submit();
        }
    })
})
