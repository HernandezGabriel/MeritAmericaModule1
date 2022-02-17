package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the length: ");
		int length= sc.nextInt();
		System.out.print("Is the temperature in (m)eter, or (f)eet? ");
		String unit = sc.next();
		if(unit.equalsIgnoreCase("M")){

			System.out.println(length+unit+" is "
					+(int)(length*3.2808399)+"f");
		}
		if(unit.equalsIgnoreCase("F")){
			System.out.println(length+unit+" is "
					+(int)((length*.3048))+"m");
		}

		//TempConvert.main(args);

	}

}
