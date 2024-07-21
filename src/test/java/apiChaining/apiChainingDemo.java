package apiChaining;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiChainingDemo {
	Faker faker;
	int id;
	@Test(priority=1)
	public void createUser()
	{
		faker=new Faker();
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload.put("name",faker.name().fullName());
		payload.put("job", "QA");
		
		Response response=RestAssured.given()
		.baseUri("https://reqres.in")
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("/api/users")
		.then().log().all().extract().response();
		int statuscode=response.statusCode();
		//String statusline=response.statusLine();
		Assert.assertEquals(statuscode, 201);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");
		id=response.jsonPath().getInt("id");
		System.out.println(id);
	}
	@Test(priority=2,enabled=true)
	public void updateUser()
	{
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload.put("name",faker.name().fullName());
		payload.put("job", "QA");
		
		Response response=RestAssured.given()
		.baseUri("https://reqres.in")
		.header("Content-Type","application/json")
				.body(payload)
				.pathParam("userid", id)
				.log().all()
		.when()
		.put("/api/users/{userid}")
		.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	@Test(priority=3,enabled=true)
	public void getSingleUser()
	{
		Response response=RestAssured.given()
		.baseUri("https://reqres.in")
		.header("Content-Type","application/json")
		.pathParam("userid", id)
		.when()
		.get("/api/users/{userid}")
		.then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
	}
	@Test(priority=4,enabled=false)
	public void deleteUser()
	{
		Response response=RestAssured.given()
				.baseUri("https://reqres.in")
				.header("Content-Type","application/json")
				.pathParam("userid", id)
				.when()
				.delete("/api/users/{userid}")
				.then().extract().response();
				Assert.assertEquals(response.statusCode(), 204);
				
	}

}
