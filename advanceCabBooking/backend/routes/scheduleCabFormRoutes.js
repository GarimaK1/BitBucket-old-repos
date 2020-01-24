const express = require('express');
const router = express.Router();
const ScheduleCabForm = require('../models/scheduleCabForm');
const checkAuth = require('../middleware/check-auth');
// use checkAuth middleware to verify token.
// this is used to restrict access to paths to authorized users only.
// Anyone can post schedule cab form. But only admin can view and delete it.

router.get('', checkAuth, (req, res) => {
  const cabForms = ScheduleCabForm
                    .find()
                    .then((cabForms) => {
                      res.status(200).json({ message: 'Schedule cab forms sent!', cabForms: cabForms });
                    })
                    .catch((err) => {
                      console.log(err);
                      res.status(404).json({message: 'Error in getting schedule forms'});
                    });

});

router.post('', (req, res) => {
  const scheduleCabForm = new ScheduleCabForm({
    name: req.body.name,
    phone: req.body.mobile,
    email: req.body.email,
    pickup_date: req.body.pickup_date,
    pickup_time: req.body.pickup_time,
    passengers: req.body.passengers,
    pickup_location:req.body.pickup_loc,
    drop_location: req.body.drop_loc
  });
  console.log(scheduleCabForm);
  scheduleCabForm.save()
  .then(() => {
    console.log('Schedule Cab Form saved successfully');
    res.status(201).json({ // 201=>A new resource was created.
      message: 'Schedule Cab Form added to DB successfully.'
    });
  })
  .catch((err) => {
    console.log('Error saving schedule cab form to DB', err);
  });
});

router.delete('/:id', checkAuth, (req, res) => {
  ScheduleCabForm.findByIdAndDelete({_id: req.params.id})
    .then((scheduleCabForm) => {
      console.log('Form deleted from DB: ' + scheduleCabForm);
      res.status(200).json({ message: 'form deleted successfully from DB', scheduleCabForm: scheduleCabForm});
  })
  .catch((err) => {
    console.log(err);
    res.status(404).json({message: 'Could not find required document'});
  })
});

module.exports = router;
