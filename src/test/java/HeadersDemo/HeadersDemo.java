package HeadersDemo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeadersDemo {
	
	@Test(priority=1)
	public void headerTest1()
	{
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.header("Role","Employee")
		.header("x-mock-match-request-headers","Role")
		.log().headers()
		.when()
		.get("/employeeInfo")
		.then().log().all().statusCode(200);
	}
	@Test(priority=2)
	public void headerTest2()
	{
		Header header1=new Header("Role","Employee");
		Header header2=new Header("x-mock-match-request-headers","Role");
		
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.header(header1)
		.header(header2)
		.log().headers()
		.when()
		.get("/employeeInfo")
		.then().log().all().statusCode(200);
	}
	@Test(priority=3)
	public void headerTest3()
	{
		Header header1=new Header("Role","Employee");
		Header header2=new Header("x-mock-match-request-headers","Role");
		Headers headers=new Headers(header1,header2);
		
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.headers(headers)
		.log().headers()
		.when()
		.get("/employeeInfo")
		.then().log().all().statusCode(200);
	}
	@Test(priority=4)
	public void headerTest4()
	{
		HashMap<String,String>headers=new HashMap<String,String>();
		headers.put("Role", "Employee");
		headers.put("x-mock-match-request-headers", "Role");
		
				
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.headers(headers)
		.log().headers()
		.when()
		.get("/employeeInfo")
		.then().log().all().statusCode(200);
	}
	
	@Test(priority=5)
	public void headerTest5()
	{	
					
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.header("Address","Value1,Value2")
		.header("x-mock-match-request-headers","Address")
		.log().all()
		.when()
		.get("/employeeAddress")
		.then().log().all().statusCode(200);
	}
	@Test(priority=6)
	public void headerTest6()
	{
		
		
		Header header1=new Header("Address","value1,Value2");
		Header header2=new Header("x-mock-match-request-headers","Address");
		
		Headers headers=new Headers(header1,header2);
		
				
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.headers(headers)
		.log().all()
		.when()
		.get("/employeeAddress")
		.then().log().all().statusCode(200);
	}
	
	@Test(priority=6,enabled=false)
	public void headerTest7()
	{
		
		
		HashMap<String, String[]> header1= new HashMap<String,String[]>();
		header1.put("Address", new String[]{"Value1", "Value2"});
		
		Header header2=new Header("x-mock-match-request-headers","Address");
		
		//Headers headers=new Headers(header1,header2);
		
				
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
	
		.log().all()
		.when()
		.get("/employeeAddress")
		.then().log().all().statusCode(200);
	}
	
	@Test
	public void HeaderextractTest()
	{
		HashMap<String,String>headers=new HashMap<String,String>();
		headers.put("Role", "Employee");
		headers.put("x-mock-match-request-headers", "Role");
		
				
		Headers headersAll=RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.headers(headers)
		.log().headers()
		.when()
		.get("/employeeInfo")
		.then().log().all().statusCode(200).extract().headers();
		
		for(Header header:headersAll)
		{
			System.out.println(header.getName()+",");
			System.out.println(header.getValue());
		}
		
	}
	@Test
	public void HeaderextractTest2()
	{
							
		Headers headersAll=RestAssured.given()
		.log().headers()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().log().all().statusCode(200).extract().headers();
		
		for(Header header:headersAll)
		{
			System.out.println(header.getName()+",");
			System.out.println(header.getValue());
		}
		
	}

}

