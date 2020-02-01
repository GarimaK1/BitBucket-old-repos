const express = require('express');
const router = express.Router();
const ContactForm = require('../models/contactForm');
const checkAuth = require('../middleware/check-auth');
const checkAdmin = require('../middleware/check-admin');
// use checkAuth middleware to verify token.
// this is used to restrict access to paths to authorized users only.
// Anyone can post contact-us form. But only admin can view and delete it.
// So use check-admin middleware too.

router.get('', checkAuth, checkAdmin, (req, res) => {
  ContactForm.find()
    .then((docs) => {
      // console.log(docs);
      res.status(200).json({
        message: 'contactForms fetched successfully!',
        contactForms: docs
      })

    })
    .catch((err) => {
      console.log('Error getting contact forms from DB:' + err);
      res.status(404).json({ message: 'Getting contact forms failed!' });
    });;
});

router.post('', (req, res) => {
  const contactForm = new ContactForm({
    name: req.body.name,
    email: req.body.email,
    phone: req.body.phone,
    subject: req.body.subject,
    message: req.body.message
  });
  console.log(contactForm);
  contactForm.save()
    .then(() => {
      console.log('Contact Form saved successfully');
      res.status(201).json({ // 201=>A new resource was created.
        message: 'ContactForm added to DB successfully.'
      });
    })
    .catch((err) => {
      console.log('Error saving form to DB:', err);
      res.status(404).json({ message: 'Saving contact form failed!' });
    });
});

router.delete('/:id', checkAuth, checkAdmin, (req, res) => {
  // console.log(req.params.id);
  ContactForm.findOneAndDelete({ _id: req.params.id })
    .then(result => {
      if (result) {
        console.log('Form deleted: ' + result);
        return res.status(200).json({ message: 'ContactUs Form deleted successfully.' });
      }
      console.log('Contact form does not exist.');
      res.status(404).send('Deleting contact form failed!');
    })
    .catch(err => {
      console.log(err);
      res.status(404).send('Getting correct contact form failed!');
    })
});

module.exports = router;
