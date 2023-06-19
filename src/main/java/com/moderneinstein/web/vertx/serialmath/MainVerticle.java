package com.moderneinstein.web.vertx.serialmath;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer ; 
import io.vertx.core.Vertx ; 
import io.vertx.core.Handler ; 
import io.vertx.core.AsyncResult ; 
import java.util.logging.Logger  ; 
import java.io.PrintStream ; 
import io.vertx.core.Future ; 
import io.vertx.core.http.HttpServerOptions ; 
import io.vertx.core.VertxOptions ; 
import io.vertx.core.http.HttpClientOptions ; 
import io.vertx.core.http.HttpClient ; 
import io.vertx.core.buffer.Buffer ; 
import io.vertx.core.http.HttpClientResponse ; 
import io.vertx.core.http.HttpClientRequest ;
import io.vertx.core.http.HttpMethod ; 
import io.vertx.core.json.JsonObject ; 
import io.vertx.core.Verticle ; 

public class MainVerticle extends AbstractVerticle {

  //public static Vertx vertx ; 
  public  Verticle[] permute = {new PermutationsVerticle(),new SalesmanVerticle() } ; 
  public Logger logger ;
  public static PrintStream stream = System.out ; 
    public  void  configure(){
     // vertx = Vertx.vertx() ; 
     // permute = new PermutationsVerticle() ; 
     for(int  vc=0;vc<permute.length;vc++){
      Verticle  portion = permute[vc] ; 
      Handler<AsyncResult<String>> handles= new Handler<AsyncResult<String>>(){
        @Override 
        public void handle(AsyncResult<String> result){
          if(result.succeeded()){
             String taken = result.result() ; 
              stream.println(taken) ;
            stream.println("Executed and Present ! ")  ;
            stream.println(portion.getClass().toString())  ;
        //  while(true){System.out.println(taken) ; }
      }
        }
      };
    //  vertx.deployVerticle(permute,(worker)->{stream.println(worker.result()) ; }) ; 
     vertx.deployVerticle((portion),handles) ; 
    }
    /*  Future<String> noted = vertx.deployVerticle(permute) ;
      noted.onComplete(handles) ; 
      noted.onSuccess(new Handler<String>(){
        @Override 
        public void handle(String value)
        {stream.println(value) ; }
      }) ;   */
     // noted.onFailure((permute::handleException )) ; 
    }
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    //vertx = Vertx.vertx( ) ; 
    
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete() ;
        stream.println("HTTP server started on port 8888");
        HttpServer temp = http.result()  ; 
      //  stream.println(temp) ; 
      } else {
        startPromise.fail(http.cause());
      }
    })  ;
    
  }
  public void testClient(){
    stream.println("Starting request") ;
    HttpClient client = Vertx.vertx().createHttpClient()   ; 
   Future<HttpClientRequest> request = client.request(HttpMethod.GET,8888,"localhost","/permutations/") ; 
   if(request.failed()) {
    System.out.println("Failed") ; 
    Throwable thrown = request.cause() ; 
    String  relative = thrown.getMessage() ; 
    stream.println(relative) ; 
   }
  // stream.println(request.result().hashCode()) ; 
    request.onSuccess( new Handler<HttpClientRequest>(){
         @Override
         public void handle(HttpClientRequest request){
          System.out.println(11) ; 
           Future<HttpClientResponse> response = request.response() ; 
           stream.println(response.result()) ; 
           response.onSuccess(
             result->{
              System.out.println("EE") ; 
               Future<Buffer> nexts = result.body() ; 
               nexts.onComplete(
                 (asynced)->{if(asynced.succeeded()){Buffer buffer= asynced.result() ; 
                   JsonObject json = buffer.toJsonObject( )  ;
                 stream.println(json.toString()); }}
               ) ;
             } );
           } ;
       } ) ;
       stream.println(44) ; 
  }
  public static void main(String[] args) throws Exception {
    MainVerticle Verticle = new MainVerticle() ; 
    //Verticle.configure() ;
    HttpServerOptions options = new HttpServerOptions().setLogActivity(true)
    .setSsl(true).setHost("localhost").setPort(8080 ) ; 
    Verticle.configure() ; 
    stream.println(55) ;
    Verticle.testClient() ;  
    //vertx = Vertx.vertx(new VertxOptions(options.toJson())) ; 
    //Verticle.configure() ; 
   // while(true){ 
   // Verticle.start() ; 
    // }
      }    
     }
