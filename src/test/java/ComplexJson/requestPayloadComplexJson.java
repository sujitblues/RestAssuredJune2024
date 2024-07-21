package ComplexJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class requestPayloadComplexJson {
	
	public void create()
	{
		List<Integer>idArrayList=new ArrayList<Integer>();
		idArrayList.add(5);
		idArrayList.add(9);
		
		HashMap<String,Object>batterHashMap2=new HashMap<String,Object>();
		batterHashMap2.put("id", idArrayList);
		batterHashMap2.put("type", "Chocolate");

		HashMap<String,Object>batterHashMap1=new HashMap<String,Object>();
		batterHashMap2.put("id", "1001");
		batterHashMap2.put("type", "Regular");
		
		List<HashMap<String,Object>>batterArrayList=new ArrayList<HashMap<String,Object>>();
		batterArrayList.add(batterHashMap1);
		batterArrayList.add(batterHashMap2);
		
		HashMap<String,List<HashMap<String,Object>>> batterHashMap=new HashMap<String,List<HashMap<String,Object>>>();
		batterHashMap.put("batter", batterArrayList);
		
		List<String>typeArrayList=new ArrayList<String>();
		typeArrayList.add("test1");
		typeArrayList.add("test2");
		
		HashMap<String,Object>toppingHashMap2=new HashMap<String,Object>();
		toppingHashMap2.put("id", "5002");
		toppingHashMap2.put("type", typeArrayList);
		
		HashMap<String,Object>toppingHashMap1=new HashMap<String,Object>();
		toppingHashMap2.put("id", "5001");
		toppingHashMap2.put("type", "None");
		
		List<HashMap<String,Object>>toppingArrayList=new ArrayList<HashMap<String,Object>>();
		toppingArrayList.add(toppingHashMap1);
		toppingArrayList.add(toppingHashMap2);
		
		HashMap<String,Object>mainHashMap=new HashMap<String,Object>();
		mainHashMap.put("id", "001");
		mainHashMap.put("type", "donut");
		mainHashMap.put("name", "Cake");
		mainHashMap.put("ppu", 0.55);
		mainHashMap.put("batters", batterHashMap);
		batterHashMap.put("topping", toppingArrayList);
		
		
	}

}
