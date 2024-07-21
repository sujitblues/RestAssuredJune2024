package javaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class arrayListDemo {

	public static void main(String[] args) {
		ArrayList<String> diet=new ArrayList<String>();
		diet.add("apple");
		diet.add("banana");
		diet.add("orange");
		
		Collection<String> vegetables = Arrays.asList("Onion", "potato","pee");
		
		Collection<String> drink = Arrays.asList("Water", "Limca","Coco");	
		
		diet.addAll(vegetables);
		diet.addAll(drink);
		
		System.out.println(diet);

	}

}
