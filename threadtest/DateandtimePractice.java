package com.threadtest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateandtimePractice {
	
	public static void main(String[] args) {

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date1 =LocalDateTime.of(2009, 12, 31, 04, 52);//of(2009, 12, 31);
        LocalDateTime date2 =LocalDateTime.of(2009, 12, 31, 04, 53);
       // LocalDate date2 = LocalDate.of(2010, 01, 31);

        System.out.println("Without format"+ date1);
        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        System.out.println("Is...");
        if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        }

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.isEqual(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        System.out.println("CompareTo...");
        if (date1.compareTo(date2) > 0) {

            System.out.println("Date1 is after Date2");

        } else if (date1.compareTo(date2) < 0) {

            System.out.println("Date1 is before Date2");

        } else if (date1.compareTo(date2) == 0) {

            System.out.println("Date1 is equal to Date2");

        } else {

            System.out.println("How to get here?");

        }
    
// Duration sample example
	 System.out.println("--- Examples --- ");

      Duration oneHours = Duration.ofHours(1);
      System.out.println(oneHours.getSeconds() + " seconds");

      Duration oneHours2 = Duration.of(1, ChronoUnit.DAYS);
      System.out.println(oneHours2.getSeconds() + " seconds");

		// Test Duration.between
      System.out.println("\n--- Duration.between --- "); 

      LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);
      LocalDateTime newDate = LocalDateTime.of(2016, Month.DECEMBER, 9, 10, 21, 56);

      System.out.println(oldDate);
      System.out.println(newDate);

      //count seconds between dates
      Duration duration = Duration.between(oldDate, newDate);

      System.out.println(duration.getSeconds() + " seconds");
      
      //Zoneddatetime example
      DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");

      LocalDateTime ldt = LocalDateTime.of(2016, Month.AUGUST, 22, 14, 30);
      System.out.println("LocalDateTime : " + format.format(ldt));

      //UTC+8
      ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Kuala_Lumpur"));
      System.out.println("Depart : " + format.format(klDateTime));

      //UTC+9 and flight duration = 7 hours
      ZonedDateTime japanDateTime = klDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(7);
      System.out.println("Arrive : " + format.format(japanDateTime));

      System.out.println("\n---Detail---");
      System.out.println("Depart : " + klDateTime);
      System.out.println("Arrive : " + japanDateTime);
      //New example
      LocalDate localDate=LocalDate.now();
      /*localDate = localDate.with(
    			temporal -> temporal.with(ChronoField.YEAR,2018).with(ChronoField.MONTH_OF_YEAR, 1).with(ChronoField.DAY_OF_MONTH, 25)
    		);*/
      System.out.println("Next Christmas : " + localDate);
      localDate = localDate.with(x-> x.with(ChronoField.MONTH_OF_YEAR,12).with(ChronoField.DAY_OF_MONTH,21));
      System.out.println("date changed"+ localDate);
      
      //Example of optional
      Optional<String> gender = Optional.of("Male");
      gender.ifPresent(g -> { if (g.equals("Male")) System.out.println("me");});
      String check =gender.get();
      System.out.println("Gender"+gender.map(String::toUpperCase)+check);
      
      String word="Helloworld";
      String streamToString = Stream.of(word).map(String::toUpperCase).collect(Collectors.joining());
      System.out.println(streamToString);
      
      String[] myArray = { "this", "is", "a", "sentence" };
      String result = Arrays.stream(myArray)
                      .reduce((a,b) -> a + "," +b).orElse("ok");
      
      System.out.println(result);
      
     
}

//	@Override
//	public Temporal adjustInto(Temporal temporal) {
//		// TODO Auto-generated method stub
//		//return temporal.with(ChronoField.MONTH_OF_YEAR,12).with(ChronoField.DAY_OF_MONTH,25);
//		return null;
//	}

}