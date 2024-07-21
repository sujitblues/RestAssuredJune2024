package day1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class reqresAPI {
	
	@Test(enabled=false)
	public void getListOfUser()
	{
		String url=given()
		.baseUri("https://reqres.in/")
		.log().all()
		.when()
		.get("api/users?page=2")
		.then()
		.statusCode(200).extract().jsonPath().getString("support.url");
		System.out.println(url);
		
	}
	@Test(enabled=false)
	public void createUser()
	{
		HashMap<String,Object>payload=new HashMap<String,Object>();
		Faker faker=new Faker();
		payload.put("name", faker.name());
		payload.put("job", faker.job());
		
		
		given()
		.baseUri("https://reqres.in/")
		.body(payload)
		.header("Content-Type","application/json")
		.header("Accept","application/json")
		.log().all()
		.when()
		.post("api/users")
		.then().log().all().statusCode(201);
		
	}
	
	@Test
	public void createUserPet()
	{
		Faker faker =new Faker();
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload.put("id", faker.hashCode());
		payload.put("username",faker.name().username());
		payload.put("firstName", faker.name().firstName());
		payload.put("lastName", faker.name().lastName());
		payload.put("email", faker.internet().emailAddress());
		payload.put("password",faker.internet().password() );
		payload.put("phone", faker.phoneNumber().cellPhone());
		payload.put("userStatus", 0);
		
		given()
		.baseUri("https://petstore.swagger.io/v2")
		.body(payload)
		.header("Content-Type","application/json")
		.header("Accept","application/json")
		.log().all()
		.when()
		.post("/user")
		.then().log().all().statusCode(200);
		
	}
}
