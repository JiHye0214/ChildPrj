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

// tell setting
const $protectTell = document.querySelectorAll(".content-number");

for(e of $protectTell){
    const tellSplitHyphen = e.innerText.split("-");
    const tellSplitToken = e.innerText.split("");

    // 앞에 점
    if(tellSplitToken[0] == "."){
        tellSplitToken.shift();
        let joinTell = tellSplitToken.join("");
        e.innerText = joinTell;
    }

    // 하이픈
    if(tellSplitHyphen.length == 1){
        if(tellSplitToken.length == 9){ // 일단 9자만
            tellSplitToken.splice(2,0,"-");
            tellSplitToken.splice(6,0,"-");
            let joinTell = tellSplitToken.join("");
            e.innerText = joinTell;
        }
    }
}
