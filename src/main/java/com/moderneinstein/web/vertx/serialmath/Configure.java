package com.moderneinstein.web.vertx.serialmath ;


import java.util.List ;
import java.util.Set ;
import java.util.Random ;
import java.util.Stack ;
import java.util.Queue ;
import java.io.* ;
import java.io.IOException ;
import java.io.FileNotFoundException  ;
import java.util.Vector ;
import java.util.ArrayList ;
import java.io.PrintStream ;
//import  com.moderneinstein.Permutations ;

public class Configure {
    public static InputStream inner;
    public static InputStreamReader reader ;
    public static BufferedReader buffer ;
    public static String  joint = new String(" ") ;
    public static String  names = new String("Salesman.txt") ;
    public static String colon = new String(":")  ;
    public static String  linear = new String("\n") ;
    public static String  string2 = new String("\nVarious Permutation Configurations :")  ;
    public static String string4 = new String("\nOptimal Permutation Configurations : ")  ;
     public static File readFile  ;
    public static File outFile  ;
    public static OutputStream streamOut ;
    public static PrintStream outer ;
    public static List<List<Integer>> towns ;
    public static int spread ;
    public static Permutations permute ;

    //Assuming that the output and input streams have been configured ;
    public static void readInput() throws Exception {
        String   theta = buffer.readLine().trim() ;
       // outer.println(theta)  ;
        if(theta==null){return ; }
        spread =  Integer.parseInt(theta)  ;
        List<Integer> values = new Vector<Integer>( ) ;
         for(int fs=0;fs<spread;fs++){
            String  lines = buffer.readLine().trim() ;
            if(lines==null){return ; }
            String[] splits  =  lines.split(joint) ;
            values = new Vector<Integer>() ;
            for(int vc=0;vc<splits.length;vc++){
                String  temp = splits[vc].trim()  ;
                if(temp==null||temp.length()==0){continue ;}
                Integer thresh = Integer.parseInt(splits[vc].trim()) ;
                values.add(thresh) ;
            }
            towns.add(values) ;
         }
    }
    public static int  optimise(List<List<Integer>> oriented){
        int below = compute(oriented);
        List<List<Integer>> filter = new ArrayList<List<Integer>>( ) ;
        for(int sc=0;sc<oriented.size();sc++){
            List<Integer> listed= oriented.get(sc) ;
            int crest = listed.size( ) ;
            int check = 0 ;
            for(int bd=0;bd<crest;bd++){
                Integer reach = listed.get(bd)   ;
                Integer nexts = listed.get((bd+1)%crest);
                check+=towns.get(bd).get(nexts) ;
                        }
            if(check==below){
                 filter.add( listed ) ;
                below = check ;
            }
            if(check<below){
                filter.clear() ;
                filter.add(listed) ;
                below = check ; }
            below = Math.min(below,check) ;     }
            outer.println(Configure.string2)  ;
            resolve(oriented) ;
            outer.println(Configure.string4)  ;
            resolve(filter) ;
            outer.println(below) ;
            return below ;
    }
    public static void resolve(List<List<Integer>> filter){
        int length =  filter.size() ;
        for(int cs=0;cs<length;cs++){
        List<Integer> current = filter.get(cs) ;
        outer.print(Configure.linear) ;
        outer.print(current.toString()) ;
        }
        outer.print(Configure.joint) ;
       outer.println(Configure.colon) ;
    }
    public static int compute(List<List<Integer>> command){
         int alter = 0 ;
         if(command.size()==0){return 0 ; }
         List<Integer> initial = command.get(0) ;
         int change =  initial.size( ) ;
        for(int vs=0;vs<change;vs++){
            int north = initial.get(vs)  ;
            int south = initial.get((vs+1)%change) ;
            alter+=towns.get(north).get(south) ;
        }
        return alter ;
    }
    //Configure both output,and input streams ;
    public static void parse(String[] args) throws IOException{
          int stretch = args.length ;
          readFile = new File(names) ;
          switch(stretch){
             case 0 :
                if(!readFile.exists()){
                readFile.createNewFile() ; }
                outFile = readFile  ;
                streamOut = new FileOutputStream(outFile,true) ;
                break ;
          case 1 :
                readFile= new File(args[0]) ;
                outFile = readFile ;
                streamOut = new FileOutputStream(outFile,true) ;
                break ;
          case 2 :
             readFile = new File(args[0]) ;
            outFile =  new File(args[1]) ;
            streamOut = new FileOutputStream(outFile,true ) ;
            break ;
        }
          inner = new FileInputStream(readFile) ;
          reader = new  InputStreamReader(inner) ;
          buffer= new  BufferedReader(reader) ;
        outer = new PrintStream(streamOut,true) ;
    }
    public static void main(String[] args) throws Exception{
        int width = args.length ;
        //readFile.createNewFile() ;
        towns = new  ArrayList<List<Integer>>() ;
        parse(args) ;
        readInput() ;
        List<Integer> thresh = new ArrayList<Integer>( ) ;
        for(int vs=0;vs<towns.size();vs++){
            thresh.add(vs) ;
        }
        List<List<Integer>> checks = Permutations.derive(thresh) ;
        for(int gc=0;gc<checks.size();gc++){
            List<Integer> temps = checks.get(gc) ;
        //    outer.println(temps.toString()) ;
        }
        int taken = optimise(checks) ;
      //  outer.println(taken) ;
    }
}
