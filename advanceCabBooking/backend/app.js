const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const contactFormRoutes = require('./routes/contactFormRoutes');
const scheduleCabFormRoutes = require('./routes/scheduleCabFormRoutes');
const userLoginRoutes = require('./routes/userRoutes');

mongoose.connect("mongodb+srv://Garima:9AfndudvQEfo4yhT@advancecabbooking-6lrnk.mongodb.net/AdvanceCabBookingDB", { useNewUrlParser: true, useUnifiedTopology: true })
        .then (() => {
          console.log('Connected to the DB :)');
        })
        .catch((err) => {
          console.log('Error connecting to db:', err);
        });
// 9AfndudvQEfo4yhT
// mongodb+srv://Garima:9AfndudvQEfo4yhT@advancecabbooking-6lrnk.mongodb.net/AdvanceCabBookingDB?retryWrites=true&w=majority
app.use(express.json());
app.use(bodyParser.urlencoded({ extended: false}));

app.use((req, res, next) => {
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Headers',
    'Origin, X-Requested-With, Content-Type, Accept, Authorization');
  res.setHeader('Access-Control-Allow-Methods',
                'GET, POST, PUT, PATCH, DELETE, OPTIONS');
  next();
})

app.use('/api/ContactForms', contactFormRoutes);
app.use('/api/scheduleCabForm', scheduleCabFormRoutes);
app.use('/api/user', userLoginRoutes);

module.exports = app;
