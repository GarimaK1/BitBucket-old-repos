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

-------------------------------------------------------------------------------------------------------------
Problem with Payment and Edit ScheduleCabForm:
-- Changing the number of passengers, pickup or drop location means route update.
-- Route update means distance, tolls, etc. So re-computation of fare.
-- At present application doesn't support that.
Solution:
a) Let customer pay $10 to confirm booking. Balance payable after travel.
   But then the distance that we calculated earlier is not used in our app.
   So implementing option (b).
b) Set condition in edit schedule cab form: user cannot update these fields.

-------------------------------------------------------------------------------------------------------------
-- Created two new modules to condense related work together:
   AuthModule, AngularMaterialModule
-- Using AuthModule (Login & Signup components) for Lazy Loading

-------------------------------------------------------------------------------------------------------------
Boolean vs boolean in Typescript e.g. while explicitly assigning return types
-- Upper case Boolean is an object type whereas lower case boolean is a primitive type.
-- It is always recommended to use boolean, the primitive type in your programs.
-- This is because, while JavaScript coerces an object to its primitive type,
-- the TypeScript type system does not. TypeScript treats it like an object type.

-------------------------------------------------------------------------------------------------------------
Token stored in angular authService needs to be stored somewhere other than angular to persist.
Otherwise when we reload any page i.e. reload angular application, memory is wiped clean
and we lose that token.
So stored it in local storage(provided by browser).

-------------------------------------------------------------------------------------------------------------
-- Inside AuthInterceptor
intercept method is called for all "http requests" leaving angular. So kind of middleware on front-end.
injecting token into outgoing requests.
The Basic Authentication Interceptor intercepts http requests from the application to add
basic authentication credentials to the Authorization header if the user is logged in.

--Inside ErrorInterceptor
Most major errors thrown in this application are http errors, sent as response by backend.
Interceptor "handle" method can be used to handle incoming response errors.

-------------------------------------------------------------------------------------------------------------
References:

https://www.udemy.com/course/angular-2-and-nodejs-the-practical-guide/learn/lecture/14852496?start=210#overview
-------------------------------------------------------------------------------------------------------------
