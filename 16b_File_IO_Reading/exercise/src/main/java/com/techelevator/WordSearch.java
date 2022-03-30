package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WordSearch {

	public static void main(String[] args) {

		int lineNumber = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String pathOfFile = input.nextLine();
		File dataFile = new File(pathOfFile);

		System.out.println("What is the search word you are looking for?");
		String searchWord = input.nextLine();
		System.out.println("Should the search be case sensitive? Y/N");
		String sensitivity = input.nextLine();

		int flag = 0;
		if (sensitivity.equalsIgnoreCase("No") || sensitivity.equalsIgnoreCase("n")) {
			flag = 1;
		}

		BufferedReader reader;
		try {
			//Scanner dataInput=new Scanner(dataFile);
			reader = new BufferedReader(new FileReader(dataFile));
			String line = reader.readLine();
			while (line != null) {
				lineNumber++;

				if (flag == 1) {
					String temp = line.toLowerCase();
					if (temp.contains(searchWord)) {
						System.out.println(lineNumber + " " + line);
					}
				} else {
					if (line.contains(searchWord)) {
						System.out.println(lineNumber + " " + line);
					}
				}
				line = reader.readLine();


			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}




