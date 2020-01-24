// middleware "function" to check if
// a) req has token
// b) web token JWT is valid or not.
const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
  try {
    // "Bearer authorization_token"
    const token = req.headers.authorization.split(" ")[1];
    jwt.verify(token, 'secret_this_should_be_a_very_long_string_to_maintain_privacy');
    next();
  } catch (err) {
    console.log(err);
    res.status(401).json({message: 'could not get auth token'});// 401 for authentication failure
  }

}
