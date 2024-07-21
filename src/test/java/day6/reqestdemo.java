package day6;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class reqestdemo {
	//RequestSpecification request=new RequestSpecBuilder().setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
			int petId;
	@Test(priority=1)
	public void createPet()
	{
		
		
		petId=RestAssured.given()
		.baseUri("https://petstore.swagger.io")
		.header("Content-Type","application/json")
		.body("")
		.when()
		.post("/v2/pet")
		.then().statusCode(200).extract().jsonPath().getInt("id");
	}
	@Test(priority=1)
	public void UpdatePet()
	{
File payload=new File("D:\\Rest-Assured-10AMJune2024\\src\\test\\java\\day6\\data.json");
		
		RestAssured.given()
		.baseUri("https://petstore.swagger.io")
		.header("Content-Type","application/json")
		.body(payload)
		.when()
		.put("/v2/pet")
		.then().statusCode(200).extract().jsonPath().getInt("id");
	}
	@Test(priority=1)
	public void getPet()
	{
		RestAssured.given()
		.when()
		.then();
	}
	@Test(priority=1)
	public void deletePet()
	{
		RestAssured.given()
		.when()
		.then();
	}

}
