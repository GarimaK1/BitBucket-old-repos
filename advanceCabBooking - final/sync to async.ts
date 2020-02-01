/* Note:
This file is just part of my efforts to convert some code from callback to promises and async await approach.
This file is not part of the Project. Just keeping it as a reference for the future.
https://stackoverflow.com/questions/47158979/node-wait-for-async-function-before-continue/47159391
https://www.freecodecamp.org/news/javascript-from-callbacks-to-async-await-1cc090ddad99/
https://stackoverflow.com/questions/14220321/how-do-i-return-the-response-from-an-asynchronous-call
*/

// -----------------------------------------------------------------------------------------------------------------------------------
// Original function
// -----------------------------------------------------------------------------------------------------------------------------------
getDistance() {
    // https://developers.google.com/maps/documentation/javascript/distancematrix#DrivingOptions
    this.distService = new google.maps.DistanceMatrixService();
    this.distService.getDistanceMatrix( x, (response, status) => {
        if (status) {
            x = 9;
            return x;
            console.log('Success');
        } else {
            console.log('Failure');
        }
    }
    );
  }
// -----------------------------------------------------------------------------------------------------------------------------------
// async-await way
// -----------------------------------------------------------------------------------------------------------------------------------
  function getDistance() {
      // need not write async getDistance() because it already returns a Promise
    // https://developers.google.com/maps/documentation/javascript/distancematrix#DrivingOptions
    this.distService = new google.maps.DistanceMatrixService();

    return new Promise((resolve, reject) => {
        this.distService.getDistanceMatrix( x, (response, status) => {
        if (status) {
            x = 9;
            resolve(x);
            console.log('Success');
        } else {
            reject(new Error('Failed to get value of x'));
            console.log('Failure');
        }
    }
    );
    })
  }

  async function app() {
      try {
        let distance = await getDistance();
      } catch (err) {
          console.log('Error in async call, error : ' + err);
      }

  }

  app();

  async function operation() {
    return new Promise(function(resolve, reject) {
        var a = 0;
        var b = 1;
        a = a + b;
        a = 5;

        // may be a heavy db call or http request?
        resolve(a) // successfully fill promise
    })
}

async function app() {
    var a = await operation() // a is 5
}

app()
// -----------------------------------------------------------------------------------------------------------------------------------
// promise way
// -----------------------------------------------------------------------------------------------------------------------------------
function getDistance() {
    // https://developers.google.com/maps/documentation/javascript/distancematrix#DrivingOptions
    this.distService = new google.maps.DistanceMatrixService();

    const myPromise = new Promise((resolve, reject) => {
        this.distService.getDistanceMatrix( x, (response, status) => {
        if (status) {
            x = 9;
            resolve(x);
            console.log('Success');
        } else {
            reject(new Error('Failed to get value of x'));
            console.log('Failure');
        }
    }
    );
    })

    myPromise.then(() => {
        console.log('got success, x= ' + x);
    })
    .catch(() => {
        console.log('got failure. Could not get value of x');
    })
  }

  const myPromise = new Promise(function(resolve, reject) {

  // code here

  if (codeIsFine) {
    resolve('fine')
  } else {
    reject(new Error('Failed to get value of x'));
  }

})

myPromise
  .then(function whenOk(response) {
    console.log(response)
    return response
  })
  .catch(function notOk(err) {
    console.error(err)
  })
  // -----------------------------------------------------------------------------------------------------------------------------------
