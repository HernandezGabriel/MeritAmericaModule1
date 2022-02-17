package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		int number= sc.nextInt();

		int lastArrayIndex;
		int lastNumberInArray;

		ArrayList<Integer> fibArray=new ArrayList();
		fibArray.add(0);
		fibArray.add(1);

		lastArrayIndex=fibArray.size()-1;
		lastNumberInArray=fibArray.get(lastArrayIndex);

		if(number<1){
			System.out.println(fibArray.toString());
		}

		fibArray.add(fibArray.get(0)+fibArray.get(1));
		lastArrayIndex=fibArray.size()-1;
		lastNumberInArray=fibArray.get(lastArrayIndex);

		if(number==1){
			System.out.println(fibArray.toString());
		}

		while (number>lastNumberInArray){
			fibArray.add(fibArray.get(lastArrayIndex)+fibArray.get(lastArrayIndex-1));
			lastArrayIndex=fibArray.size()-1;
			lastNumberInArray=fibArray.get(lastArrayIndex);

		}

		if(number!=lastNumberInArray){
			fibArray.remove(lastArrayIndex);
			lastArrayIndex=fibArray.size()-1;
			lastNumberInArray=fibArray.get(lastArrayIndex);
		}


		System.out.println(fibArray.toString());




	}

}
