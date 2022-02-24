package com.techelevator;

import java.util.ArrayList;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String input=sc.nextLine();
		Scanner sc2 = new Scanner(input);
		ArrayList<Integer> numberArray = new ArrayList<>();
		while(sc2.hasNextInt()){

			numberArray.add(sc2.nextInt());

		}

		int numberDecimal;
		String numberBinary;

		for(int i=0;i<numberArray.size();i++){
			numberDecimal=numberArray.get(i);
			numberBinary="";

			while (numberDecimal!=0){
				if(numberDecimal%2==1){
					numberBinary='1'+numberBinary;
				}
				if(numberDecimal%2==0){
					numberBinary='0'+numberBinary;
				}
				numberDecimal=numberDecimal/2;

			}
			System.out.println(numberArray.get(i)+" in binary is "+numberBinary);

		}

	}

}
