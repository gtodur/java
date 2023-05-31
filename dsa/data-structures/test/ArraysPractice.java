package practice.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.stream.IntStream;

public class ArraysPractice {

	public static void main(String[] args) {
		String [] names = {"Guru", "Prasad", "Todur"};
		String [] countries = new String[] {"India", "Russia", "Germany"};
		int [] scores = new int[10]; //intialises array with 10 zeros as its of type int
		scores = new int[]{87, 97, 67, 67, 89, 90, 94, 77, 88, 62};
		System.out.println(names.length);
		for(String name : names) {
			System.out.println(name);
		}
		countries[1] = "France";
		for(int i=0; i < countries.length; i++) {
			System.out.println(countries[i]);
		}
		//appending item to end of array
		countries = Arrays.copyOf(countries, 4);
		countries[3] = "Russia";
		for(int i=0; i < countries.length; i++) {
			System.out.println(countries[i]);
		}
		//Adding integer items to array
		scores = IntStream.concat(Arrays.stream(scores), IntStream.of(34, 56)).toArray();
		for(int score : scores) {
			System.out.println(score);
		}
		
		/**
		 * When array is cloned, new array is created, but elements are shared
		 */
		
		//1D array clone is a deep copy
		String[] countriesClone = countries.clone();
		for(String country : countriesClone) {
			System.out.println(country);
		}
		
		System.out.println("Clone of 1D array - is it same? - : " + (countries == countriesClone));
		System.out.println("Individual items of Clone of 1D array - is it same? - : " + (countries[0] == countriesClone[0]));
		
		Person [] persons = new Person[2];
		persons[0] = new Person("Guru", 123, "Private", "Bengaluru", "3479759475");
		persons[1] = new Person("Todur", 456, "Govt", "Hubballi", "8349549444");
		for(Person person : persons) {
			System.out.println(person.toString());
		}
		
		float [] arrayForAdd = {-10, 30.5f, 40.75f, -50, 20};
		printArraySum(arrayForAdd);
		int[] arrayWithRoundedUpElements = getArrayElementsRoundedUp(arrayForAdd);
		for(int no : arrayWithRoundedUpElements) {
			System.out.println(no);
		}
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		Date date1 = Date.from(LocalDate.of(2021, 10, 26).atStartOfDay(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM", Locale.ENGLISH);
			System.out.println(sdf.format(date1));
			sdf = new SimpleDateFormat("EEEE dd MMMM", new Locale("cy", "cy"));
			System.out.println(sdf.format(date1));
		
	}
	
	static void printArraySum(float [] array) {
		float sum = 0.0f;
		
		for(float no : array) {
			sum += no;
		}
		System.out.println("Sum of elements of array : " + sum);
	}
	
	static int [] getArrayElementsRoundedUp(float [] array) {
		int [] arrayWithRoundedUpElements = new int[array.length];
		for(int i=0; i<array.length; i++) {
			arrayWithRoundedUpElements[i] = Math.round(array[i]);
		}
		return arrayWithRoundedUpElements;
	}
	
}
