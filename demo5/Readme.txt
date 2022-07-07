Zuul 
- API Gateway - Act as filter based on which URL which microservice will be invoked
-It is JVM based router and server side load balancer

#All requestes to: http://localhost:8079/product-producer/ 
will be diverted to this resource 
http://localhost:10000/info

This is due to zuul gateway