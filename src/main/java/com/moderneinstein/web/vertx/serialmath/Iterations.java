package com.moderneinstein.web.vertx.serialmath;

import java.util.List ;
import java.util.LinkedList ;
import java.util.TreeSet ;
import java.util.Set ;
import java.util.ArrayList ; 

public class Iterations {

   // public List<List<>>
   public static Permutations oriented ;
    public static int iterate(List<List<Integer>> listed,List<List<Integer>> linear,List<Integer> serial){
        int  delta = listed.size() ;
        List<Integer> reach = new LinkedList<Integer>() ;
        for(int fd=1;fd<=delta;fd++){reach.add(fd) ; }
        List<List<Integer>> taken = Permutations.derive(reach) ;
        SalesmanVerticle.trail.println("Permutations:") ;
        System.out.println(taken.toString()) ;
        int lowest = ensure(listed,taken,0) ;
        SalesmanVerticle.trail.println(lowest) ;
        for(int rs=0;rs<taken.size();rs++){
            int alter = 0 ;
            List<Integer> inted = taken.get(rs) ;
            for(int vs=0;vs<inted.size();vs++){
                int upper = inted.get((vs+1)%inted.size())-1 ;
                int lower = inted.get(vs)-1 ;
                alter+=listed.get(lower).get(upper) ;
            }
            System.out.println(alter) ;
            if(alter==lowest){
                linear.add(inted) ;
                serial.add(alter) ;
            }
            if(alter<lowest){
                serial.clear() ;
                linear.clear() ;
                lowest = alter  ;
                linear.add(inted)  ;
                serial.add(alter) ;
            }
        }
        return lowest ;
    }
    public static int ensure(List<List<Integer>> verse,List<List<Integer>> prompt,int index){
        if(prompt.size()==0){return 0 ;}
        List<Integer>  portion = prompt.get(0) ;
        int  saved = 0 ;
        int known = portion.size() ;
        for(int vd=0;vd<portion.size();vd++){
            int south = portion.get((vd+1)%known)-1 ;
            int north = portion.get(vd)-1 ;
            saved+=verse.get(south).get(north) ;
        }
        return saved ;
    }
    public static void orient(List<List<Integer>> source,List<List<Integer>> contain,List<Integer> listed){
         List<Integer> start = new ArrayList<Integer>( )  ;
         int spans = source.size() ;
         for(int re=1;re<=spans;re++){
             start.add(re) ;   }
        List<List<Integer>> states =  Permutations.derive(start) ;
        for(int vs=1;vs<=states.size();vs++){
          int change = 0 ;
          List<Integer> portion = states.get(vs-1) ;
          for(int fd=0;fd<portion.size(); fd++){
            int farther = portion.get((fd+1)%portion.size())-1  ;
            int nearer = portion.get(fd)-1 ;
            change+=source.get(nearer).get(farther) ;
          }
          contain.add(portion) ;
          listed.add(change) ; 
        }
     }
}
