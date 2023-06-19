package com.moderneinstein.web.vertx.serialmath;

import java.util.List ;
import java.util.Vector ;
import java.util.ArrayList ;
import java.util.LinkedList ;

import io.vertx.core.AbstractVerticle ;
import io.vertx.core.Vertx ;
import io.vertx.core.http.HttpServer ;
import io.vertx.ext.web.Router ;
import io.vertx.ext.web.Route ;
import io.vertx.ext.web.RoutingContext ;
import io.vertx.core.http.HttpServerOptions ;
import io.vertx.core.http.HttpMethod ;
import io.vertx.core.http.HttpServerResponse ;
import io.vertx.core.http.HttpServerRequest ;
import io.vertx.core.AsyncResult ;
import io.vertx.core.Handler ;
import io.vertx.core.buffer.Buffer ;
import io.vertx.core.json.JsonObject ;

import java.io.PrintStream ;
import java.lang.reflect.Array ;
import java.util.Arrays ;

public class SalesmanVerticle extends AbstractVerticle{

    public HttpServer server ;
    public Router router ;
    public Route routes ;
    public static String baseMode = new String("/salesman") ;
    public static int port = 8040 ;
    public static String host = "localhost" ;
    public Configure orientation  ;
    public static String sign4 = new String("Array") ;
    public static String sign3 = new String("-")  ;
    public static String space = new String(" ") ;
    public static String colon = new String(":") ;
    public static PrintStream trail = System.out ;

    public void configure(){
        HttpServerOptions options = new
        HttpServerOptions().setPort(port).setHost(host) ;
        server = vertx.createHttpServer(options) ;
        router = Router.router(vertx );
         orientation = new Configure() ;
    }
   
    public void placeRoutes(){
        Route routeS = router.route() ;
        routeS.path((baseMode).concat("/optimal").concat("/:range/:delim1/:delim2/"))  ;
        routeS.method(HttpMethod.GET)   ;
        routeS.handler(new Handler<RoutingContext>(){
            @Override
            public void handle(RoutingContext context){
                trail.println("Request Handled")  ;
                HttpServerRequest request = context.request() ;
                HttpServerResponse response = context.response() ;
                String delimE = context.pathParam("delim2")  ;
                String delimD = context.pathParam("delim1") ;
                request.body(
                    new Handler<AsyncResult<Buffer>>(){
                        @Override
                        public void handle(AsyncResult<Buffer> result){
                        Buffer buffer = result.result() ;  
                        int reach = Integer.parseInt(context.pathParam("range")) ;
                        List<List<Integer>> inted = SalesmanUtils.derive(buffer,delimD,delimE) ;
                        JsonObject tier5 = SalesmanUtils.restate(inted) ;
                        respond(response,false ) ;
                        response.write(tier5.toString()) ;
                        response.end( );
                    } }
                )   ;
            }
        }  ) ;
    }
    //                      JsonObject tier3 = PermutationsVerticle.create(reach) ;
    public void placePaths(){
        Route routeR = router.route() ;
        routeR.path((baseMode).concat("/absolute").concat("/:range/:delim1/:delim2/"))  ;
        routeR.method(HttpMethod.GET)   ;
        routeR.handler(new Handler<RoutingContext>(){
            @Override
            public void handle(RoutingContext context){
                trail.println("Request Handled")  ;
                HttpServerRequest request = context.request() ;
                HttpServerResponse response = context.response() ;
                String delimE = context.pathParam("delim2")  ;
                String delimD = context.pathParam("delim1") ;
                request.body(
                    new Handler<AsyncResult<Buffer>>(){
                        @Override
                        public void handle(AsyncResult<Buffer> result){
                        Buffer buffer = result.result() ;
                        int reach = Integer.parseInt(context.pathParam("range")) ;
                        List<List<Integer>> inted =  SalesmanUtils.derive(buffer,delimD,delimE) ;
                        JsonObject tier5 = SalesmanUtils.compute(inted) ;
                        respond(response,false) ;
                        response.write(tier5.toString()) ;
                        response.end()  ;  
                    } }
                )   ;
            }
        }  ) ;
    }
    public void respond(HttpServerResponse response,boolean terminate){
        response.setChunked(true) ;
        response.setStatusCode(200) ;
        response.putHeader("content-type","application/json") ;
        response.exceptionHandler(PermutationsVerticle::handleException) ; 
        if(terminate){
        response.end( ) ; }
    }
    public  void ensure(){
        server.exceptionHandler(
            (except)->{String saved = except.getMessage() ;
                MainVerticle.stream.print(saved) ;
                MainVerticle.stream.println(" ") ;
                PermutationsVerticle.handleException(except) ;
             }
        ) ;
        server.requestHandler(router) ;
        server.listen(port,
        (result)->{
            HttpServer varied = result.result( ) ;
            trail.println(varied.toString( )) ;
         })  ;
    }
    @Override
    public void start(){
        configure() ;
        placeRoutes() ;
        placePaths() ;
        ensure() ;
     }

}
                  //   response.write("Possible Permutations: ") ;
                     //   response.write(tier3.toString()) ;
                      //  response.write("Optimal permutations: " ) ;
                     // JsonObject tier3 = PermutationsVerticle.create(reach) ;

                       //   response.write("Possible Permutations: ") ;
                     //   response.write(tier3.toString()) ;
                      //  response.write("Optimal permutations: " ) ;
                        //routeR.path((baseMode).concat(":range/:delim1:/delim2")) ;