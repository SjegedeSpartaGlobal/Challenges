package com.sparta.sj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
//        System.out.println(getNumber(10));
//        Thread thread = runThread();
//        thread.start();
//        Thread t2 = runLamdaThread();
//        t2.start();
//        lamdas();
//        collections();
        townsToUpperCase(Towns, startWithW);
    }

    private static List<String> Towns = Arrays.asList("Brighton", "Bristol", "Worthing", "Watford", "Southhampton");
    private static Predicate<String> startWithB = (word) -> word.startsWith("B");
    private static Predicate<String> startWithW = (word) -> word.startsWith("W");

    public int doubleNumber(int num){
        return num*2;
    }

    public interface NumberDoubler {
        int doubleNumber(int i);
    }

    public static int getNumber(int j){
        NumberDoubler doubler =  (i) -> i * 2;
        return doubler.doubleNumber(j);
    }

    public static Thread runThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in thread");
            }
        });
        return thread;
    }

    public static Thread runLamdaThread(){
        Thread thread = new Thread(() -> System.out.println("Running in Lamda Thread"));
        return thread;
    }

    public static int lamdas(){
        Consumer<String> cons = (message) -> System.out.println("Running in Consumer Lamda "+message);
        Runnable t1 = () -> System.out.println("Running in Runnable Lamda Thread ");
        Nums result = (int x, int y) -> x + y;
        Predicate<String> isTrue = (word) -> word.length() > 5;
        return result.addNums(3,5);
    }

    public interface Nums{
        int addNums(int x, int y);
    }

    public static void collections(){
        List<String> towns = Arrays.asList("Brighton", "Bristol", "Worthing", "Watford", "Southhampton");
        Iterator it = towns.iterator();
//        Iterator<String> it2 = new Iterator<String>(towns );


        for(String town : towns){
            System.out.println(town);
        }

        for(int i=0; i<towns.size(); i++){
            System.out.println(towns.get(i));
        }

        while(it.hasNext()){
            System.out.println(it.next());
        }

        Predicate<String> start = (word) -> word.startsWith("B");

        towns.stream()
                .map(String::toUpperCase)//:: static
                .filter (start)
                .forEach(town -> System.out.println(town));

        List<String> myTownList = new ArrayList<>();
        towns.stream()
                .filter(start)
                .map(town -> myTownList.add(town))
                .forEach(town -> System.out.println(town));


    }

    public static void townsToUpperCase(List<String> towns, Predicate<String> filter){
        towns.stream()
                .map(String::toUpperCase)//:: static
                .filter (filter)
                .forEach(town -> System.out.println(town));
    }
}
