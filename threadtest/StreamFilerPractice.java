package com.threadtest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Talent
 *
 */
public class StreamFilerPractice {
	
	/*Before java 8*/
	public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");
//        List<String> result = getFilterOutputlambda(lines, "mkyong");
//        for (String temp : result) {
//            System.out.println(temp);    //output : spring, node
//        }
//
//    }
//
//    private static List<String> getFilterOutput(List<String> lines, String filter) {
//        List<String> result = new ArrayList<>();
//        for (String line : lines) {
//            if (!"mkyong".equals(line)) { // we dont like mkyong
//                result.add(line);
//            }
//        }
//        return result;
//    }
//    private static List<String> getFilterOutputlambda(List<String> lines, String filter) {
//        List<String> result = new ArrayList<>();
//        /*for (String line : lines) {
//            if (!"mkyong".equals(line)) { // we dont like mkyong
//                result.add(line);
//            }
//        }*/
//        lines.forEach(line->{
//            if (!"mkyong".equals(line)) { // we dont like mkyong
//                result.add(line);
//            }});
//        return result;
//    }
//    
    /*With stream changes*/
    List<String> result = lines.stream().filter(line->!"mkyong".equals(line)).collect(Collectors.toList());
    result.forEach(System.out::println);
//New example
    List<Person> persons = Arrays.asList(
            new Person("mkyong", 30),
            new Person("jack", 20),
            new Person("lawrence", 40)
    );

    String name = persons.stream()
            .filter(x -> "jack".equals(x.getName()))
            .map(Person::getName)   //convert stream to String
            .findAny()
            .orElse("");

    System.out.println("name : " + name);

    List<String> collect = persons.stream()
            .map(Person::getName)
            .collect(Collectors.toList());

    collect.forEach(System.out::println);
//Map example
    List<Developer> staff = Arrays.asList(
            new Developer("mkyong", new BigDecimal(10000), 30),
            new Developer("jack",  new BigDecimal(20000), 32),
            new Developer("lawrence",  new BigDecimal(30000), 34)
    );

    //Before Java 8
    List<String> result1 = new ArrayList<>();
    for (Developer x : staff) {
        result1.add(x.getName());
    }
    System.out.println("check"+result1); //[mkyong, jack, lawrence]

    //Java 8
    List<Integer> collect1 = staff.stream().map(x -> x.getAge()).collect(Collectors.toList());
 //   IntSummaryStatistics collect2 = staff.stream().mapToInt((x) -> x).seq;
    System.out.println(collect1); //[mkyong, jack, lawrence]
    
    int[] lNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    boolean result2 = Arrays.stream(lNumber).boxed().anyMatch(x -> x == 10);

    if (result2) {
        System.out.println("Hello 10");
    } else {
        System.out.println("Where is number 10?");
    }
    String password = "password123";
    
    char[] ok = password.toCharArray();

   long k= password.chars() //IntStream
    .mapToObj(x -> (char) x).collect(Collectors.counting());//Stream<Character>
    //.forEach(System.out::println);
   
   System.out.println("count is" + ok[1]+k);
   
   String[] s1 = new String[]{"a", "b", "c"};
   String[] s2 = new String[]{"d", "e", "f"};
   String[] s3 = new String[]{"g", "h", "i"};
   
   String[] result_ok = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
   System.out.println(Arrays.toString(result_ok));
   List<String> concatlist = Arrays.asList("Hello","Tom") ;

  	String concatstring = String.join("",concatlist);
  	System.out.println(concatstring);
  	

}
}
