During login:
-- check if credentials match with ones in DB. using- "login", "authService", "userRoutes"
-- if credentials are valid, create authorization token at backend "userRoutes.js" and
    get it at frontend "auth.service.ts"

All requests leaving frontend:
-- After login, due to "auth-interceptor.ts" all requests leaving frontend carry that token now.
-- Token is inside "Authorization" header

Requests reaching backend:
-- For some routes that need to be protected using authentiation token, "check-auth.js" middleware is added.
-- It is added before req is processed.
-- It is a middleware that verifies the token.
-- If token is correct, the req is allowed to complete.
-- If token is incorrect, 401 authentication failed error is thrown.
