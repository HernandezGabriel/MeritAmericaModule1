package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FizzWriter {

	public static void main(String[] args) {

		int[] integerArray = IntStream.range(1, 301).toArray();

		List<String> fizzBuzzList = new ArrayList<String>();
		for (Integer checkForFizzBuzz : integerArray) {
			if (checkForFizzBuzz % 3 == 0 && checkForFizzBuzz % 5 == 0) {
				fizzBuzzList.add("FizzBuzz");
			} else if (checkForFizzBuzz % 3 == 0) {
				fizzBuzzList.add("Fizz");
			} else if (checkForFizzBuzz % 5 == 0) {
				fizzBuzzList.add("Buzz");
			} else {
				fizzBuzzList.add(checkForFizzBuzz.toString());
			}
		}
		System.out.println("Enter The File Destination");
		Scanner sc = new Scanner(System.in);
		String foutPath = sc.next();
		//File fout = new File(foutPath);

		try (PrintWriter foutwriter = new PrintWriter(new File(foutPath))) {

			for (String s: fizzBuzzList	) {
				foutwriter.println(s);
			}



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}



