const $protectTell = document.querySelectorAll(".protect-tell");

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