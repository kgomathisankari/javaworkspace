package io.sample;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Gomathi Sankari
 * This Program is test 7 iteration mechanisms.
 *
 */
public class ForLoopDemo {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("Aravind");
		names.add("Aditya");
		names.add("Ulag");
		names.add("Raja");
		
		//List<String> names = Arrays.asList("Aravind","Aditya","Ulag","Raja");

		System.out.println("1:----Normal For Loop prinitng mechanisim.. Printing Names");
		for (int i=0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		//Enhanced For Loop
		System.out.println("\n2:----Enhanched For Loop.");
		for (String s : names) {
			System.out.println(s);
		}
		
		// Iterator looping
		System.out.println("\n3:-----Iterator Loop Mechanisim");
		Iterator<String> iterateNames = names.iterator();
		while (iterateNames.hasNext())
			System.out.println(iterateNames.next());
		
		//ListIterator Looping
		System.out.println("\n4:------ListIterator Loop Mechanisim");
		ListIterator<String> listIterateNames = names.listIterator();
		while (listIterateNames.hasNext())
			System.out.println(listIterateNames.next());
		
		//While loop Example
		System.out.println("\n5:------While Loop Mechanisim");
		int i=0;
		while(i<names.size()) {
			System.out.println(names.get(i));
			i++;
		}
		
		// ForEach Method mechanism
		System.out.println("\n6:------For Each Mechanisim");
		names.forEach(s -> System.out.println(s));
		
		System.out.println("\n7:------Stream For Each Mechanisim");
		names.stream().forEach(s -> System.out.println(s));
	
	}

}
