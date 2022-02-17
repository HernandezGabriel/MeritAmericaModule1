package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the temperature: ");
		int temperature= sc.nextInt();
		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String scale = sc.next().toUpperCase(Locale.ROOT);
		if(scale.equals("F")){
			System.out.println(temperature+scale+" is "
					+(int)((((temperature-32)/1.8)+.5))+"C");
		}
		if(scale.equals("C")){
			System.out.println(temperature+scale+" is "
					+(int)((temperature*1.8+32))+"F");
		}

		//TempConvert.main(args);

	}

}
