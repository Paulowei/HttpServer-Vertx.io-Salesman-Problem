#Serial Math
- The source for the implementation of a HttpServer  ;
- The back end framework used is Vertx.io ; 
- The main verticle is  named (MainVerticle.Java) 
- The Supplementary verticles (PermutationsVerticle, and SalesmanVerticle )
- Are Deployed using the 
- Verticle.deployVerticle(Verticle verticle,Handler<AsyncResult<String>>)
- Method of the Abstract Verticle Class ;

- To compile with maven , run the following commands on the terminal : 
 mvn compile   
 mvn exec:java 
 - The main Verticle should deploy the other two 
 ,and print their associated values (String deploymentID ); 
 - An asyncronous handler is used to deploy the verticles, as stated above 
 (-Verticle.deployVerticle(Verticle verticle,Handler<AsyncResult<String>>))
- To test The software ; 
Compile TestVerticle.java, and run the following commands on the terminal ; 
// java TestClient "GET" "http://localhost:8080/permutations/4/" "7C6C9C4R5C8C1C8R6C4C3C7R9C2C7C8"
//java TestClient "GET" "http://localhost:8040/salesman/optimal/4/R/C/" "7C6C9C4R5C8C1C8R6C4C3C7R9C2C7C8"
//java TestClient "GET" "http://localhost:8040/salesman/absolute/4/R/C/" "7C6C9C4R5C8C1C8R6C4C3C7R9C2C7C8"
