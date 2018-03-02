package com.threadtest;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemNew {

	/* To get the digital root */
	public void getDigitalRoot(int num) {

		int count = 0;
		int originalnum = num;
		while (num / 10 > 0) {
			count = Integer.toString(num).chars().map(x -> x - '0').sum();
			num = count;
			// String s = String.valueOf(num);
			// count = s.chars()
			// .mapToLong(i ->i -'0').sum();

		}
		System.out.println("Digital root of " + originalnum + " is :" + num);
	}

	/* To get Min Max */
	public void MinMAx(int[] sample) throws ArithmeticException {

		System.out.println("MAX: " + Arrays.stream(sample).reduce((a, b) -> a > b ? a : b).toString());

		// String check="12346883167";
		// String s = "66443875"; //"121211789012345678901234567890123456780";
		// final int chunksize=4;
		// String Finalchunks="";
		// System.out.println(s.length()+""+s.length()/chunksize);
		// List<Integer> chunks=IntStream.range(0, s.length()/chunksize)
		// .mapToObj(i -> Integer.parseInt(s.substring(i*chunksize,
		// (i+1)*chunksize))).collect(Collectors.toList());
		// IntStream.range(0, s.length()/chunksize)
		// .mapToObj(i -> s.substring(i*chunksize,
		// (i+1)*chunksize)).forEach(System.out::println);

		// String Finalchunks=IntStream.range(0, s.length()/chunksize)
		// .mapToObj(i -> s.substring(i*chunksize,
		// (i+1)*chunksize)).filter(x->(x.chars().map(y ->
		// (y-'0')^3).sum()%2)==0).map(i -> new
		// StringBuilder(i).reverse().toString()).collect(Collectors.joining(""));
		// s.substring(1, s.length() - 1) +s.charAt(0)
		// if(chunksize>0)
		// {
		// IntStream.range(0, s.length()/chunksize)
		// .mapToObj(i -> s.substring(i*chunksize,
		// (i+1)*chunksize)).forEach(System.out::println);

		// Finalchunks=IntStream.range(0, s.length()/chunksize)
		// .mapToObj(i -> s.substring(i*chunksize, (i+1)*chunksize)).map(i->
		// {if((i.chars().map(y -> (y-'0')^3).sum()%2)==0) {return new
		// StringBuilder(i).reverse().toString();}else{return new
		// StringBuilder(i).substring(1, i.length())
		// +i.charAt(0);}}).collect(Collectors.joining(""));
		// }
		// System.out.println("Final chunk : "+Finalchunks);
		// Arrays.stream(sample).filter(x->x)
		// IntStream Stream=Arrays.stream(sample);
		// String min=Stream.reduce((a,b)-> a>b?a:b).toString();
		// String max=Stream.reduce((a,b)-> a<b?a:b).toString();
		// System.out.println(min+"ok"+max);

		// int[] minMax= {min.getAsInt(),max.getAsInt()};
		// minMax.add(min.getAsInt());
		// minMax.add(max.getAsInt());
		// System.out.println(" Min is:"+min.getAsInt()+" Max is
		// :"+max.getAsInt());
		// System.out.println(minMax.toString());
	}

	public void revrot(String chunk, int chunkSize) {
		String Finalchunks = "";
		if (chunkSize > 0) {
			// IntStream.range(0, chunk.length()/chunkSize)
			// .mapToObj(i -> chunk.substring(i*chunkSize,
			// (i+1)*chunkSize)).forEach(System.out::println);

			Finalchunks = IntStream.range(0, chunk.length() / chunkSize)
					.mapToObj(i -> chunk.substring(i * chunkSize, (i + 1) * chunkSize)).map(i -> {
						if ((i.chars().map(y -> (y - '0') ^ 3).sum() % 2) == 0) {
							return new StringBuilder(i).reverse().toString();
						} else {
							return new StringBuilder(i).substring(1, i.length()) + i.charAt(0);
						}
					}).collect(Collectors.joining(""));
		}
		System.out.println("Final chunk : " + Finalchunks);

	}

	public static void main(String[] args) {

		/* To get the digital root */
		int numberToProcess = 132189;
		ProblemNew p = new ProblemNew();
		p.getDigitalRoot(numberToProcess);

		/* To get Min Max */
		int[] sample = { 1, 23, 43, 21, 3 };
		p.MinMAx(sample);

		/* Problem 3 of revrot() */
		String str = "66443875";
		p.revrot(str, 4);
	}

}
