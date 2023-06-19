package com.moderneinstein.web.vertx.serialmath;

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

public class PermutationsVerticleUtils {
    public static String space = new String(" ") ;
    public static String trace = new String("Array") ;
    public static String dash = new String("-") ;
    public static JsonObject create(int lapse){
        List<Integer> listed = new ArrayList<Integer>() ;
        for(int re=1;re<=lapse;re++){
            listed.add(re) ;
        }
        JsonObject json = new JsonObject() ;
        List<List<Integer>> payload = Permutations.derive(listed) ;
        for(int vc=0;vc<payload.size(); vc++){
            List<Integer> current = payload.get(vc) ;
            String keys = trace.concat(dash).concat(space) ;
            keys = keys.concat(Integer.toString(vc+1)).concat(space) ;
            String value = current.toString() ;
            json.put(keys,value) ;
        }
        return json  ;
  }
}
