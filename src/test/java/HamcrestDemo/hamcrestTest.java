package HamcrestDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 class hamcrestTest {
	
	@Test
	public void getUserList()
	{
		RestAssured.given()
		.when()
		.get("https://search.stg.aeccglobal.com/api/search-providers?isCommisionAvailable=true")
		.then().log().all().body("data.name",hasItem("Australian Catholic University"))
		.body("data.city", hasItems("Sydney","Gold Coast","Darwin"))
		.body("data.slug", not(hasItem("flinders")))
		//.body("data.logo", contains("https://search.stg.aeccglobal.com/app/provider/aculogojpg"))
		//.body("", empty())
		.body("data.logo", everyItem(startsWith("https")))
		.body("data.headerImage", everyItem(startsWith("https")))
		//.body(hasKey("pages"))
		.body("totalRecords",greaterThanOrEqualTo(0));
		
		
	}
	@Test(enabled=false)
	public void getUserExample()
	{
		RestAssured.given()
		.baseUri("https://api.example.com")
		.pathParam("userid",123)
		.when()
		.get("/user/{userid}")
		.then().log().all();
		
		
	}
}
