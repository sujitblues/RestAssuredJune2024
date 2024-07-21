package jsonDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class complexJsonDemo {
	
	@Test
	public void createDonut()
	{
		List<Integer>idArrayList=new ArrayList<Integer>();
		idArrayList.add(5);
		idArrayList.add(9);
		
		HashMap<String,Object>betterHashMap2=new HashMap<String,Object>();
		betterHashMap2.put("id",idArrayList);
		betterHashMap2.put("type", "Chocolate");
		
		HashMap<String,Object>betterHashMap1=new HashMap<String,Object>();
		betterHashMap2.put("id","1001");
		betterHashMap2.put("type", "Regular");
		
		List<HashMap<String,Object>> betterArrayList=new ArrayList<HashMap<String,Object>>();
		betterArrayList.add(betterHashMap1);
		betterArrayList.add(betterHashMap2);
		
		List<String>typeArrayList=new ArrayList<String>();
		typeArrayList.add("test1");
		typeArrayList.add("test2");
		
		HashMap<String,Object>HashMapTopping1=new HashMap<String,Object>();
		HashMapTopping1.put("id", "5001");
		HashMapTopping1.put("type", "None");
		
		HashMap<String,Object>HashMapTopping2=new HashMap<String,Object>();
		HashMapTopping2.put("id", "5002");
		HashMapTopping2.put("type",typeArrayList );
		
		List<HashMap<String,Object>> toppingArrayList=new ArrayList<HashMap<String,Object>>();
		toppingArrayList.add(HashMapTopping1);
		toppingArrayList.add(HashMapTopping2);
		
		HashMap<String,Object>mainHashMap=new HashMap<String,Object>();
		mainHashMap.put("id", "0001");
		mainHashMap.put("type", "donut");
		mainHashMap.put("name", "Cake");
		mainHashMap.put("ppu", 0.55);
		mainHashMap.put("batters", betterArrayList);
		mainHashMap.put("topping", toppingArrayList);
		
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.header("Content-Type","application/json")
		.body(mainHashMap)
		.log().all()
		.when()
		.post("/createDont")
		.then().log().all().statusCode(200);
		
	}
	

}
