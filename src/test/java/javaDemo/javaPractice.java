package javaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class javaPractice {

	public static void main(String[] args) {
		int a[]=new int[6];
		int[] b= {};
		
		int[] x,y;
		
		int p[],q;
		for(int i=0;i<6;i++)
		{
			a[i]=i;
		}
		ArrayList<String> arlist=new ArrayList<String>();
		arlist.add("apple");
		arlist.add("banana");
		arlist.add("orange");
		
		Iterator<String> iterator = arlist.iterator();
		
		// Traverse the ArrayList using the iterator
		while (iterator.hasNext()) {
		    String element = iterator.next();
		    System.out.println(element);
		    if (element.equals("banana")) {
		        iterator.remove();
		    }
		}



/*
		System.out.println(arlist);
		System.out.println(arlist.get(2));
		arlist.set(1, "grapes");
		System.out.println(arlist);
		arlist.remove(2);
		System.out.println(arlist);
		System.out.println(arlist.size());
		
		ArrayList<String> city = new ArrayList<String>();
		// Add elements to the ArrayList
		city.add("Delhi");
		city.add("Kolkata");
		System.out.println(city);
		
		Collection<String> collection = Arrays.asList("Mumbai", "Chennai","Kerla");
		city.addAll(collection);
		System.out.println(city);
		
		boolean checkCity=city.contains("Odisa");
		System.out.println(checkCity);
		int index=city.indexOf("Chennai");
		System.out.println(index);
		
city.removeAll(collection);
System.out.println(city);

*/
HashMap<String,Object> map=new HashMap<String,Object>();

map.put("John", 25);
//Insert another key-value pair into the HashMap
map.put("Sarah", 30);
map.put("Sarah", 1);
map.put("Mohan", 26);
map.put("Raghav", 28);
//Print the HashMap
System.out.println(map); 
System.out.println(map.get("Sarah")); 
System.out.println(map.remove("Mohan")); 
System.out.println(map);
boolean keycheck=map.containsKey("Rishi");

System.out.println(keycheck);

Set<String> keys= map.keySet();
System.out.println(keys);

	}

}
