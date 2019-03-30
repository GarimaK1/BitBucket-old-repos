/* 
Chrome browser behaves a little strangely when using alert, prompt, or confirm functions.
It doesn't display the HTML on the page until after the popup has been closed. 
This is problematic since our HTML contains instructions for the user to be able to use the app we're building.

So use window.setTimeout(function(){function definition}, 500);

This gives the HTML a half second to load before running the JS, which circumvents 
the issue of the prompt function blocking the HTML from loading right away.
*/

/*
Note, if you want to be able to access the todos variable from the chrome developer console
 then you'll need to put it in the global scope, see example below:

var todos = ["Buy New Turtle"];
window.setTimeout(function() {
  // put all the rest of your JS code from the lecture here
}, 500);

If you include the todos array inside of the window.setTimeout() function then it's scope will be 
local to the anonymous function (callback) and you won't be able to access it from the chrome console.
*/
var todos = [];
window.setTimeout(function() {
    // put all of your JS code from the lecture here
    todos = ["Buy new turtle"];
    var input = prompt("What would you like to do? ");

    while(input !== "quit"){
        //handle input
        if (input === "list") {
            listToDos();
        } else if (input === "new") {
            addToDos();
        } else if (input === "del"){
            deleteToDos();
        }
        //ask user again 
        input = prompt("What would you like to do? ");
    }
    console.log("Okay, you quit the app.");

    function listToDos(){
        todos.forEach(function (todo, index) {
            console.log("********");
            console.log(index + ": " + todo);
        });
    }
    function addToDos(){
        //ask for new todo
        var newToDo = prompt("Enter new todo");
        //add to todos array
        todos.push(newToDo);
        console.log("Added todo");
    }
    function deleteToDos(){
        //ask for index of ToDo to delete
        var ind = prompt("Index of ToDo you want to delete?");
        //delete that todo
        todos.splice(ind, 1);
        console.log("Deleted todo");
    }
}, 500);