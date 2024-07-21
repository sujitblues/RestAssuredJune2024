package day2;

import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String,Object> data=new HashMap<String,Object>();
		
		data.put("Rahul", 25);
		data.put("Anjali", 30);
		System.out.println(data);
		data.put("Sarah", 30);
		
		System.out.println(data.get("Rahul"));	
		data.remove("Rahul");	
		System.out.println(data);
		System.out.println(data.containsKey("Sarah"));
	}

}
