window.setTimeout(function(){

    var lis = document.querySelectorAll("li");
    console.log(lis);

    for (var i = 0; i < lis.length; i++) {
        lis[i].addEventListener("mouseover", function () {
            //console.log("over");
            //this.style.color = "green";
            this.classList.add("selected");
        });

        lis[i].addEventListener("mouseout", function () {
            //console.log("out");
            //this.style.color = "black";
            this.classList.remove("selected");
        });

        lis[i].addEventListener("click", function () {
            //console.log("click");
            this.classList.toggle("done");
        });
    }



}, 500);

