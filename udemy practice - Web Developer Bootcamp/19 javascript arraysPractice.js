console.log("~~~~~~~~~~~~~~~~Example 1~~~~~~~~~~~~~~~~~");

var colors = ["red","yellow","orange","green"];

for (var i = 0; i<colors.length; i++){
    console.log(colors[i]);
}

console.log("No of items in colors array = " + colors.length);
console.log("colors[3] = " + colors[3]);
console.log("colors[4] = " + colors[4]);

colors[10] = "pink";
console.log("colors[10] = " + colors[10]);

alert("After adding pink at 10th index, No of items in colors array = " + colors.length);

for (var i = 0; i < colors.length; i++) {
    console.log(colors[i]);
}

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~Example 2 forEach ~~~~~~~~~~~~~~~~~");
var numbers = [1,2,3,4,5,6,7,8,9,10];
var items = ["pen","ink","bottle","phone","earphones"];

numbers.forEach(function(color){
    if (color % 3 === 0){
        console.log(color);
    }
});

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~Example 3: Deleting using \"splice\" ~~~~~~~~~~~~~~~~~");

var numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(numbers);
numbers.splice(0);
console.log("After deleting, array is: " + numbers);

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~Example 4: printReverseArray() ~~~~~~~~~~~~~~~~~");

printReverseArray([1, 2, 3, 4]);

function printReverseArray(i,j,k,l){
    
}
