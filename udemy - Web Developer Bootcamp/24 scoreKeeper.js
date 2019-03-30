window.setTimeout(function(){
    var p1Button = document.getElementById("p1");
    var p2Button = document.querySelector("#p2");
    var p1Display = document.querySelector("#p1Display");
    var p2Display = document.querySelector("#p2Display");
    var resetButton = document.getElementById("reset");
    var numInput = document.querySelector("input[type='number']");
    var winningScoreDisplay = document.querySelector("p span");

    console.log(p1Display);
    console.log(p2Display);
    console.log(numInput);
    console.log(winningScoreDisplay);

    var p1Score = 0;
    var p2Score = 0;
    var gameOver = false;
    var winningScore = 5;

    p1Button.addEventListener("click", function(){
        console.log("Button 1 was clicked");
        if(!gameOver){
            p1Score++;
            //console.log(p1Score, winningScore);
            if( p1Score === winningScore){
                console.log("GAME OVER");
                p1Display.classList.add("winner");
                gameOver = true;
            }
            p1Display.textContent = p1Score; 
        }
    });

    p2Button.addEventListener("click", function () {
        console.log("Button 2 was clicked");
        if (!gameOver) {
            p2Score++;
            if (p2Score === winningScore) {
                console.log("GAME OVER");
                p2Display.classList.add("winner");
                gameOver = true;
            }
        }
        p2Display.textContent = p2Score; 
    });

    resetButton.addEventListener("click", function () {
        console.log("Button 'Reset' was clicked");
        reset();
    });

    function reset(){
        p1Score = 0;
        p2Score = 0;
        p1Display.textContent = 0;
        p2Display.textContent = 0;
        p1Display.classList.remove("winner");
        p2Display.classList.remove("winner");
        console.log("p1 Score: " + p1Score);
        console.log("p2 Score: " + p2Score);
        gameOver = false;
    }

    numInput.addEventListener("change",function(){
        winningScoreDisplay.textContent = this.value;
        winningScore = Number(this.value);
        reset();
    });

}, 500);
