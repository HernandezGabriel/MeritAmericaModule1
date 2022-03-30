package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        System.out.println("What is the search word");
        Scanner sc = new Scanner(System.in);
        String searchWord = sc.nextLine();

        System.out.println("What is the replacement word");
        String replacementWord=sc.nextLine();

        System.out.println("What is the replacement file");
        String finPath =sc.nextLine();

        System.out.printf("What is the destination file?");
        String foutPath=sc.nextLine();

        File fin= new File(finPath);
        File fout = new File(foutPath);

        try(Scanner scFin = new Scanner(new FileReader(fin));
            PrintWriter writer = new PrintWriter(fout);) {
            //BufferedReader reader = new BufferedReader(new FileReader(fin));
            //PrintWriter writer = new PrintWriter(fout);





            while(scFin.hasNextLine()){

                String test= scFin.nextLine();
                test= test.replace(searchWord,replacementWord);
                writer.println(test);

            }
            writer.close();



        } catch (FileNotFoundException ex) {

            System.out.println("FILE NOT FOUND");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }

}

                // String strArray[] = line.split(" ");

//                for (int i = 0; i < strArray.length; i++) {
//                    if(strArray[i].equals(searchWord)){
//                        strArray[i] = replacementWord;
//                    }
//                }
//
//                for (int i = 0; i < strArray.length; i++) {
//                    writer.print(strArray[i]+" ");
//                }
//

