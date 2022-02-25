package com.techelevator;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map animalGroup = new HashMap<>();
		animalGroup.put("RHINO", "Crash");
		animalGroup.put("ELEPHANT","Herd");
		animalGroup.put("GIRAFFE","Tower");
		animalGroup.put("LION","Pride");
		animalGroup.put("CROW","Murder");
		animalGroup.put("PIGEON","Kit");
		animalGroup.put("FLAMINGO","Pat");
		animalGroup.put("DEER","Herd");
		animalGroup.put("DOG","Pack");
		animalGroup.put("CROCODILE","Float");

		if (animalName==null){
			return "unknown";
		}
		if (animalGroup.containsKey(animalName.toUpperCase())){
			return (String)animalGroup.get(animalName.toUpperCase());
		}
		else return "unknown";
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map discounts = new HashMap<>();
		discounts.put("KITCHEN4001",.20);
		discounts.put("GARAGE1070",.15);
		discounts.put("LIVINGROOM",.10);
		discounts.put("KITCHEN6073",.40);
		discounts.put("BEDROOM3434",.60);
		discounts.put("BATH0073",.15);
		if (itemNumber==null){
			return 0.00;
		}
		if (discounts.containsKey(itemNumber.toUpperCase())){
			return (double)discounts.get(itemNumber.toUpperCase());
		}
		else return 0.00;

	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		if(peterPaul.get("Peter")>0 && peterPaul.get("Paul")<1000){
			int half;
			int paul;

			if (peterPaul.get("Peter")%2==1){ //UNEVEN **peter keeps the penny
				 half= (int) (((peterPaul.get("Peter")-1)/2)); //take off the penny to do the division
				 paul=peterPaul.get("Paul");

				peterPaul.put("Peter", half+1);           //peter keeps penny
				peterPaul.put("Paul", paul+half);

			}
			else{
				 half= (int) (((peterPaul.get("Peter"))/2));
				 paul=peterPaul.get("Paul");

				peterPaul.put("Peter", half);
				peterPaul.put("Paul", paul+half);
			}


		}

		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		if(peterPaul.get("Peter")>=5000&&peterPaul.get("Paul")>=10000){
			double peterPaulContributionCombined=.25*peterPaul.get("Peter")+.25*peterPaul.get("Paul");

			peterPaul.put("PeterPaulPartnership",(int)peterPaulContributionCombined);

			int peterMinusContribution=peterPaul.get("Peter")- (int) (peterPaul.get("Peter")*.25);
			int paulMinusContribution=peterPaul.get("Paul")- (int) (peterPaul.get("Paul")*.25);
			peterPaul.put("Peter",peterMinusContribution);
			peterPaul.put("Paul",paulMinusContribution);
		}

		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map begAndEnd = new HashMap<>();
		for(String s :words){
			begAndEnd.put(s.substring(0,1),s.substring(s.length()-1));

		}
		return begAndEnd;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map wrdCount=new HashMap<String,Integer>();
		int wordCounter=0;
		String word="";
		for(int i =0; i< words.length;i++){
			word=words[i];
			for (int x=0;x< words.length;x++){
				if (word.equals(words[x])){
					wordCounter++;
				}
			}
			wrdCount.put(word,wordCounter);
			wordCounter=0;
		}
		return wrdCount;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map intCount = new HashMap<Integer,Integer>();
		int integerBeingCounted=0;
		int integerCounter=0;

		for(int i:ints){
			integerBeingCounted=i;
			for(int x: ints){
				if(integerBeingCounted==x){
					integerCounter++;
				}
			}
			intCount.put(integerBeingCounted,integerCounter);
			integerCounter=0;
		}
		return intCount;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map iftwoOrMoreMAP=new HashMap<String, Boolean>();
		int counter=0;

		for(String s : words){
			for (String s2: words){
				if(s.equals(s2)){
					counter++;
				}
			}
			iftwoOrMoreMAP.put(s,(counter>1));
			counter=0;


		}
		return iftwoOrMoreMAP;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		Map combinedMap = new HashMap(mainWarehouse); // new combinedMap is equal to mainWH
		remoteWarehouse.forEach((Key,Value) ->  //for each key value pair in remote warehouse we are going to
												//COMBINEDMAP.merge
				combinedMap.merge(Key,Value, (v1, v2) -> (int)v1+(int)v2)); //meaning "merging into combined map"
																			// they key and then the values added
								//formatting of merge method is what I don't quite understand.
								//I was really surprised I got this one.
		return combinedMap;
	}



	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map last2 = new HashMap<String, Integer>();
		String last2string;
		int counter=0;
		for(String s:words){
			last2string=s.substring(s.length()-2);
			s=s.substring(0,s.length()-2);
			//seperated first part from last 2 chars

			for (int i = 0; i < s.length()-1; i++) {
				if (s.substring(i,i+2).equals(last2string)){
					counter++;
				}
			}
			last2.put(s+last2string,counter);
			counter=0;
		}
		return last2;


	}

}
