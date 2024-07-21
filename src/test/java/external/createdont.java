package external;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class createdont {
	
	@Test(enabled=false)
	public void createDontTest()
	{
		File payload=new File("D:\\Rest-Assured-10AMJune2024\\src\\test\\java\\external\\payload.json");
		
		RestAssured.given()
		.baseUri("https://99a83407-1f11-412c-9f16-7f9b660cdb26.mock.pstmn.io")
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("/createDont")
		.then().log().all().statusCode(200);
		
	}
	
	@Test
public void createpet()
{
	File payload=new File("D:\\Rest-Assured-10AMJune2024\\src\\test\\java\\external\\createPetBody.json");
	
	RestAssured.given()
	.baseUri("https://petstore.swagger.io/v2")
	.header("Content-Type","application/json")
	.header("Accept","application/json")
	.body(payload)
	.log().body()
	.when()
	.post("/pet")
	.then().log().ifError().statusCode(200);
}
	@Test
	public void createUser()
	{
		File payload=new File("D:\\Rest-Assured-10AMJune2024\\src\\test\\java\\external\\createUserBody.json");
		
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2")
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("/user")
		.then().log().all().statusCode(200);
	}
}
