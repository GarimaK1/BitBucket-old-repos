const express = require('express');
const router = express.Router();
const User = require('../models/user');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');

router.post('/signup', (req, res) => {
  bcrypt.hash(req.body.password, 10)
    .then((hash) => {
      const user = new User({
        email: req.body.email,
        password: hash
        //Don't keep "password: req.body.password" --> stupid to save unencrypted passwords.
      });
      user.save()
        .then(document => {
          console.log('user saved successfully to DB:' + document);
          res.status(201).json({
            message: 'user saved successfully to DB'
          });
        })
        .catch((err) => {
          console.log('Error saving user during signup: ' + err);
          res.status(500).json({ message: 'Error saving user during signup', error: err });
        })
    })
    .catch((err) => {
      console.log('Error hashing signup password.' + err);
      res.status(500).json({ message: 'Error hashing signup password.', error: err });
    });
});

router.post('/login', (req, res) => {
  // validate credentials: email and password
  let fetchedUser;
  User.findOne({ email: req.body.email })
    .then(user => {
      if (!user) {
        return res.status(401).json({
          message: 'Authenticaion failed. User not found in DB.'
        });
      }
      // console.log('We found a user with that email id. this gets printed.');
      fetchedUser = user;
      return bcrypt.compare(req.body.password, user.password); // returns a promise with result of compare
    })
    .then(result => {
      // console.log(result);
      if (!result) {
        return res.status(401).json({
          message: 'Authenticaion failed..'
        });
      }
      // user is validated. Create authentication token
      const token = jwt.sign({ email: req.body.email, userId: fetchedUser._id },
        'secret_this_should_be_a_very_long_string_to_maintain_privacy',
        { expiresIn: '1h' });

      // console.log('token is : ' + token);
      res.status(200).json({
        token: token
      });
    })
    .catch(err => {
      console.log(err);
      return res.status(401).json({
        message: 'Authenticaion failed...',
        error: err
      });
    });
});

module.exports = router;
