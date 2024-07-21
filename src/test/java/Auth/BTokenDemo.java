package Auth;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BTokenDemo {
	String btoken="49c7896a4bb3346afd9fa40db5440d61442a5be15d7a887bbf8bd0598c6692da";
	Faker faker;
	int id;
	@Test(priority=1)
	public void createUser()
	{
		faker=new Faker();
		HashMap<String,Object> payload=new HashMap<String,Object>();
		payload.put("name", faker.name().fullName());
		payload.put("gender", "male");
		payload.put("email", faker.internet().emailAddress());
		payload.put("status", "active");
		
		Response response=RestAssured.given()
		.baseUri("https://gorest.co.in/public/v2")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer "+btoken)
		.body(payload)
		.log().all()
		.when()
		.post("/users")
		.then().log().all().extract().response();
		int statuscode=response.statusCode();
		id=response.jsonPath().getInt("id");
		System.out.println(id);
		Assert.assertEquals(statuscode, 201,"checking status code");
		
	}
	@Test(priority=2)
	public void updateUser()
	{
		faker=new Faker();
		HashMap<String,Object> payload=new HashMap<String,Object>();
		payload.put("name", faker.name().fullName());
		payload.put("gender", "male");
		payload.put("email", faker.internet().emailAddress());
		payload.put("status", "active");
		
		Response response=RestAssured.given()
		.baseUri("https://gorest.co.in/public/v2")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer "+btoken)
		.body(payload)
		.pathParam("userid", id)
		.log().all()
		.when()
		.put("/users/{userid}")
		.then().log().all().extract().response();
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200,"checking status code");
	}
	@Test(priority=3)
	public void getUser()
	{
		Response response=RestAssured.given()
				.baseUri("https://gorest.co.in/public/v2")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer "+btoken)
				.pathParam("userid", id)
				.log().all()
				.when()
				.get("/users/{userid}")
				.then().log().all().extract().response();
				int statuscode=response.statusCode();
				Assert.assertEquals(statuscode, 200,"checking status code");
	}
	
	@Test(priority=4)
	public void DeleteUser()
	{
		Response response=RestAssured.given()
				.baseUri("https://gorest.co.in/public/v2")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer "+btoken)
				.pathParam("userid", id)
				.log().all()
				.when()
				.delete("/users/{userid}")
				.then().log().all().extract().response();
				int statuscode=response.statusCode();
				Assert.assertEquals(statuscode, 204,"checking status code");
	}

}
