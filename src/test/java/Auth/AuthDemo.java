package Auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthDemo {
	
	@Test
	public void BasicTest()
	{
		RestAssured.given()
		.auth().basic("postman", "password")
		.baseUri("https://postman-echo.com")
		.when()
		.get("/basic-auth")
		.then().statusCode(200);
	}
	@Test
	public void digesTest()
	{
		RestAssured.given()
		.auth().digest("postman", "password")
		.baseUri("https://postman-echo.com")
		.when()
		.get("/digest-auth")
		.then().statusCode(200);
	}
	
	@Test
	public void apiKeyTest()
	{
		RestAssured.given()
		.baseUri("https://api.openweathermap.org/data/2.5")
		.queryParam("appid", "566be371a97a11b1763b0cdaaca945d8")
		.when()
		.get("/weather?q=delhi")
		.then().statusCode(200);
	}

}
