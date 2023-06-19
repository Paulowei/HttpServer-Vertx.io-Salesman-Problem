package com.moderneinstein.web.vertx.serialmath ;

import io.vertx.core.http.HttpServerRequest ;
import io.vertx.core.http.HttpServerResponse ;
import io.vertx.ext.web.Router  ;
import io.vertx.core.AbstractVerticle ;
import io.vertx.core.Promise ;
import io.vertx.ext.web.Route ;
import io.vertx.ext.web.RoutingContext ;
import io.vertx.core.http.HttpServer ;
import io.vertx.ext.web.handler.BodyHandler ;
import io.vertx.core.Handler ;
import io.vertx.core.Vertx  ;
import io.vertx.core.json.JsonObject ;
import io.vertx.core.Future ;
import io.vertx.core.http.HttpMethod ;
import io.vertx.core.http.HttpServerOptions ;


import java.util.ArrayList  ;
import java.util.List  ;
import java.util.Set ;
import java.util.LinkedList ;
import java.util.Vector ;

import com.moderneinstein.web.vertx.serialmath.Permutations ;

import  java.io.PrintStream ;

public class PermutationsVerticle extends AbstractVerticle{

    public static String baseRoute =  new String("/permutations/") ;
    public  HttpServer  server  ;
    public Vertx vertx ;
    public Router router ;
    public static Permutations permute  ;
    public static int port = 8080 ;
    public static PrintStream printed =  System.out ;  
    public static String space = new String(" ") ;
    public static String trace = new String("Array") ;
    public static String dash = new String("-") ;
   public HttpServerOptions createHttp(){
        HttpServerOptions options = new HttpServerOptions() ;
       // options.setSsl(true) ;
        options.setPort(port) ;
        options.setHost("serverhost") ;
        options.setUseAlpn(true) ;
        return options ;
   }
     public void configure() throws Exception{
        vertx = Vertx.vertx() ;
        server =  vertx.createHttpServer(createHttp()) ;
        router = Router.router(vertx) ;
        permute = new Permutations() ;
    }
    public void stateRoutes() throws Exception{
        Route  routeC =  router.route() ;
        routeC.path(baseRoute.concat(":range/")).method(HttpMethod.GET) ;
        routeC.handler(new Handler<RoutingContext>(){
            @Override
            public void handle(RoutingContext context){
                HttpServerRequest request =  context.request() ;
                HttpServerResponse response = context.response( );
                int data =  Integer.parseInt(context.pathParam("range") )  ;
                 JsonObject object =  PermutationsVerticleUtils.create(data ) ;
                respond(response,false) ; 
                response.write(object.toString()) ;
                printed.println(context.statusCode()) ;
                response.end() ;
             //   context.next() ;
            }
        }) ;
    }
    public void respond(HttpServerResponse response,boolean terminate){
        response.setChunked(true) ;
        response.putHeader("content-type","application/json") ;
        response.setStatusCode(200) ;
        response.exceptionHandler(PermutationsVerticle::handleException) ; 
        if(terminate){
        response.end( ) ; }
    }
    public static void handleException(Throwable thrown){
        thrown.printStackTrace(printed)  ;
        printed.println(thrown.getMessage()) ;

    }
    public void finalise() throws Exception{
       // future.onSuccess(varied ->{printed.println("Successful") ; }) ;
       server.exceptionHandler(new Handler<Throwable>(){
        @Override
        public void handle(Throwable thrown){
        handleException(thrown) ;
        }
       })  ;
       server.requestHandler(router) ;
       server.listen(port,(asynced)->{
       if(asynced.succeeded()){
            HttpServer noted= asynced.result() ;
            printed.println(noted.toString()) ;
            printed.println("Permutations set Successfully") ;
        }else{
            asynced.cause().printStackTrace() ;
        }
    }) ;
    printed.println(server.actualPort()) ;
    }
    @Override
    public void start() throws Exception{
      //  vertx= Vertx.vertx() ;
       // printed.println(55) ;
        configure() ;
        stateRoutes() ;
        finalise() ;
        // routeC.path(baseRoute).method(HttpMethod.GET) ;
            //printed.println(routeC.getRou)
    }



}
