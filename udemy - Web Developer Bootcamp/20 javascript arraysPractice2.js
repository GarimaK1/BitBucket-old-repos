var numbers = [1,2,3,4,5,6];

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~ 1: printReverseArray() ~~~~~~~~~~~~~~~~~");
numbers = [1, 2, 3, 4, 5, 6];

function printReverseArray(arr){
    for (var i=arr.length-1; i>=0; i--){
        console.log(arr[i]);
    }
}

printReverseArray(numbers);

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~ 2: isUniform() ~~~~~~~~~~~~~~~~~");
numbers = [1,1,1,1,2,1];

function isUniform(arr){
    var first = arr[0];
    for (var i=0; i<arr.length; i++){
        if (first !== arr[i]){
            return false;
        }
    }
    return true;
}

console.log(isUniform(numbers));

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~ 3: sumArray() ~~~~~~~~~~~~~~~~~");
numbers = [1, 1, 1, 1, 2, 1];

/* THIS WORKS WITH REGULAR FOR LOOP AS WELL AS FOREACH LOOP!!
function sumArray(arr){
    var sum = 0;
    for (var i=0; i<arr.length; i++){
        sum +=arr[i];
    }
    return sum;
}
*/
function sumArray(arr) {
    var sum = 0;
    arr.forEach(function(num){
        sum = sum + num;
    });
    return sum;
}

console.log("Sum is: "+sumArray(numbers));

// -----------------------------------------------------------------------------------------
console.log("~~~~~~~~~~~~~~~~ 4: max() ~~~~~~~~~~~~~~~~~");
numbers = [1, 2, 3, 4, 5, 6];
/* THIS WORKS WITH REGULAR FOR LOOP AS WELL AS FOREACH LOOP!!
function max(arr){
    var max = arr[0];
    for (var i=0; i<arr.length; i++){
        if (max < arr[i]){
            max = arr[i];
        }
    }
    return max;
}
*/
function max(arr){
    var max = arr[0];
    arr.forEach(function(num){
        if (max < num){
            max = num;
        }
    });
    return max;
}

console.log("Max number is: " + max(numbers));

// -----------------------------------------------------------------------------------------