package com.moderneinstein.web.vertx.serialmath  ;  

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

public  class SalesmanUtils{

    public static PrintStream  trail = SalesmanVerticle.trail ; 
    public static String sign4 = new String("Array") ;
    public static String sign3 = new String("-")  ;
    public static String space = new String(" ") ;
    public static String colon = new String(":") ;
    public static List<List<Integer>> derive(Buffer buffed,String delimF,String delimS){
        List<List<Integer>> inted = new ArrayList<List<Integer>>() ;
        String mails = buffed.toString().trim() ;
        String[] arrays  = mails.split(delimF) ;
        for(int re=0;re<arrays.length ;re++){
            String[] pieces = arrays[re].trim().split(delimS) ;
            List<Integer> crest = new Vector<Integer>() ;
             for(int df=0;df<pieces.length;df++){
                crest.add(Integer.parseInt(pieces[df])) ;
                System.out.println(Integer.parseInt(pieces[df])) ;
             }
              inted.add(crest) ;
        }
        trail.println(inted.toString()) ;
        return inted ;
    }
    public static JsonObject restate(List<List<Integer>> weights){
        List<Integer> serial =new LinkedList<Integer>() ;
        List<List<Integer>> linear = new Vector<List<Integer>>() ;
        System.out.println(weights.toString()) ;
        int trough = Iterations.iterate(weights,linear,serial) ;
        System.out.println("Size:") ;
        trail.println(linear.size()) ;
        JsonObject object = collect(linear,serial) ;
        object.put("value",trough)  ;
        PermutationsVerticle.printed.println(linear) ;
        return object ;
    }
    public static JsonObject compute(List<List<Integer>> current){
      int space = current.size() ;
      List<List<Integer>> contain = new Vector<List<Integer>>() ;
      List<Integer>  listed = new ArrayList<Integer>() ;
      Iterations.orient(current,contain,listed ) ;
      JsonObject message = collect(contain,listed) ;
      return message ;
    }
    public static JsonObject collect(List<List<Integer>> values,List<Integer> scores){
        int lowest = 0 ;
        int height= scores.size() ;
        JsonObject holder  = new JsonObject () ;
        for(int fe=0;fe<height;fe++){
            List<Integer> current = values.get(fe) ;
            int digit = scores.get(fe) ;
            String keys = sign4.concat(space).concat(sign3)  ;
            keys  = keys.concat(space).concat(Integer.toString(fe+1)) ;
            String other = current.toString().
            concat(colon).concat(String.valueOf(digit)) ;
              holder.put(keys,other) ;
        }
      //  holder.put("value",little) ;
        System.out.println(holder.toString()) ;
        return holder ;
    }
}
/* 
trail.print(delimF) ;
trail.println(delimS ) ;
trail.println(buffed.length());
trail.println(Arrays.toString(arrays)) ;
*/