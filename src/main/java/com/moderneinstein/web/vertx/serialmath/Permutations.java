package com.moderneinstein.web.vertx.serialmath ;


import java.util.List ;
import java.util.Vector ; 
import java.util.Arrays ; 
import java.lang.reflect.Array ;
import java.util.ArrayList ;
import java.util.LinkedList ; 
import java.util.Set ; 
import java.util.Queue ;
import java.util.Stack ; 
import java.util.BitSet ; 

public class Permutations {
    public static int limit = 20  ; 
    public static List<Integer> listed ;
    public static List<List<Integer>> central ; 
    public static void orient(List<Integer> current,BitSet state){
        if(current.size()>=listed.size( )){
            central.add(new ArrayList<Integer>(current)) ;
            return ; 
        }
        int draft =   listed.size() ; 
        int tests =  state.cardinality()  ;
        for(int gc=0;gc<draft;gc++){
            if(state.get(gc)==false){
                state.set(gc) ; 
                 current.add(listed.get(gc)) ; 
                orient(current,state) ; 
                current.remove(current.size()-1)  ; 
                state.clear(gc); 
            }
        }
    }
    public static void group(List<Integer> worker){
        Queue<List<Integer>> contain = new LinkedList<List<Integer>>() ; 
        Queue<BitSet> cents =  new LinkedList<BitSet>( ) ;
        BitSet marks = new BitSet(worker.size( ))  ; 
        List<Integer> starts = new Vector<Integer>() ; 
        contain.offer(starts) ; 
        cents.offer(marks) ; 
        while(cents.size( )>0){
            marks = cents.poll() ; 
          starts =  contain.poll() ; 
          if(starts.size()>=worker.size( )){
            central.add(new  Vector<Integer>(starts)) ; 
            continue  ;
          }
        int  drift =  worker.size() ; 
        for(int fs=0;fs<drift;fs++){
             if(marks.get(fs)==false){
                marks.set(fs) ;
                starts.add(worker.get(fs)) ;
                contain.offer(new Vector<Integer>(starts) ) ;
                cents.offer((BitSet)marks.clone()) ;
                starts.remove(starts.size()-1) ; 
                marks.clear(fs) ; 

             }
        }
        }
    }
    public static void iterate(List<Integer> current){
        int spans = current.size( ) ; 
        if( spans>=listed.size( )){
            central.add(new Vector<Integer>(current)) ; 
            return ; 
        }
         Integer nexts = listed.get(spans) ;
        for(int aq=0 ;aq<spans;aq++){
            current.add(aq,nexts) ; 
            iterate(current) ; 
            current.remove(aq) ; 
        }
    }
    public static void reknown(List<Integer> begin){
        List<Integer> initial = new ArrayList<Integer>() ;
        Queue<List<Integer>> nodes = new  LinkedList<List<Integer>>() ; 
         nodes.offer(initial) ; 
         while(nodes.size( )>0){
            initial = nodes.poll( ) ; 
            int length =initial.size() ; 
            if(length>=begin.size()){
                central.add(new ArrayList<Integer>(initial)) ; 
                continue ; 
            }
            Integer token = begin.get(length) ;
            for(int vc=0;vc<length;vc++){
                initial.add(vc,token) ; 
                nodes.add(new ArrayList<Integer>(initial)) ;  
                initial.remove(vc) ; 
            }
         }
        }
    public static List<List<Integer>> derive(List<Integer> config){
         int depth = config.size() ; 
        BitSet signs = new BitSet(depth) ; 
        listed  =   config  ; 
      //  listed = new  LinkedList<List<Integer>>() ;
        List<Integer>  begin = new Vector<Integer>() ;
        central = new ArrayList<List<Integer>>(  ) ;
        //iterate(begin) ;
        //reknown(config) ; 
        group(config) ; 
        //orient(begin,signs)  ;
        // System.out.println(central.size()) ; 
        return central ;  
    }
    public static void main(String[] args){
        
    }
}
