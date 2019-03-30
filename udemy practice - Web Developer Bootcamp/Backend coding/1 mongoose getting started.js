// getting-started.js from mongoose official website: "https://mongoosejs.com/docs/index.html"

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/test', { useNewUrlParser: true });

var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function () {
    console.log("we're connected to MongoDB!");

    var kittySchema = new mongoose.Schema({
        name: String
    });
    kittySchema.methods.speak = function () {
        var greeting = this.name ? ("Kitten name is " + this.name) : "I don't have a name";
        console.log(greeting);
    }
    var kitten = mongoose.model('Kitten',kittySchema);
    var kit1 = new kitten({ name: "Kit1" });
    console.log("New kitty on the block with name: " + kit1.name);
    kit1.speak();
    var fluffy = new kitten({name: "Fluffy"});
    fluffy.speak();
    var Softy = new kitten({ name: "Softy" });
    Softy.speak();
    //save fluffy to MongoDB
    fluffy.save(function(err, fluffy){
        if(err) return console.log(err);
        console.log("kitten with name 'fluffy' of 'kittenSchema' saved to 'kittens' collection. ");
    });
    Softy.save(function (err, Softy) {
        if (err) return console.log(err);
        console.log("kitten with name 'Softy' of 'kittenSchema' saved to 'kittens' collection. ");
    });
    // Find all kittens in MongoDB
    // kitten.find(function(err, kittens){
    //     if (err) return console.log(err);
    //     console.log("Displaying all kittens - ");
    //     console.log(kittens);
    // });
    // Some problem - find() function is run before the save() function. Reason: node is asynchronous. 
    // Doesn't wait for callback to complete before moving to execute next line of code.
    // refer: https://stackoverflow.com/questions/32578045/mongoose-save-function-doesnt-execute
    console.log("Trial - putting find code inside last save.");
    var Silky = new kitten({ name: "Silky" });
    Silky.speak();
    Silky.save(function (err, Silky) {
        if (err) return console.log(err);
        console.log("kitten with name 'Silky' of 'kittenSchema' saved to 'kittens' collection. ");
        kitten.find(function (err, kittens) {
            if (err) return console.log(err);
            console.log("Displaying all kittens - ");
            console.log(kittens);
        });
    });
});



