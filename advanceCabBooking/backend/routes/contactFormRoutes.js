const express = require('express');
const router = express.Router();
const ContactForm = require('../models/contactForm');
const checkAuth = require('../middleware/check-auth');
// use checkAuth middleware to verify token.
// this is used to restrict access to paths to authorized users only.
// Anyone can post contact-us form. But only admin can view and delete it.
router.get('', checkAuth, (req, res) => {
  ContactForm.find()
    .then((docs) => {
      console.log(docs);
      res.status(200).json({
        message: 'contactForms fetched successfully!',
        contactForms: docs
      })

    })
    .catch((err) => {
      console.log(err);
      res.status(404).json({ message: 'error fetching contact forms from DB' });
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
      console.log('Error saving form to DB', err);
    });
});

router.delete('/:id', checkAuth, (req, res) => {
  // console.log(req.params.id);
  ContactForm.findOneAndDelete({ _id: req.params.id })
    .then(result => {
      if (result) {
        console.log('Form deleted: ' + result);
        res.status(200).json({ message: `ContactUs Form with id ${req.params.id} was deleted successfully.` });
      } else {
        res.status(404).send('Error deleting form with given ID..');
      }
    })
    .catch(err => {
      console.log(err);
      res.status(404).send('Error deleting genre with given ID');
    })
});

module.exports = router;
