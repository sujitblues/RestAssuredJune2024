package day6;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class reqres {
	
	RequestSpecification request=new RequestSpecBuilder().setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
	ResponseSpecification res=new ResponseSpecBuilder().expectHeader("Content-Type", "application/json").build();
			
	int UserId;
@Test(priority=1)
public void createUser()
{

HashMap<String,Object>payload=new HashMap<String,Object>();
payload.put("name", "Rahul");
payload.put("job", "QA");

UserId=RestAssured.given().spec(request)
						.body(payload)
			.when()
			.post("/v2/pet")
			.then().spec(res).extract().jsonPath().getInt("id");
}
@Test(priority=2)
public void UpdateUser()
{
	HashMap<String,Object>payload=new HashMap<String,Object>();
	payload.put("name", "Rahul");
	payload.put("job", "QA");

		RestAssured.given()
				.spec(request)
				.pathParam("id", UserId)
				.body(payload)
				.when()
				.put("/v2/pet/{id}")
				.then().spec(res).extract().jsonPath().getInt("id");

}
@Test(priority=3)
public void getUser()
{
	

		RestAssured.given()
				.spec(request)
				.pathParam("id",UserId)
				.when()
				.get("/v2/pet/{id}")
				.then().spec(res).extract().jsonPath().getInt("id");
	
}
@Test(priority=4)
public void deleteUser()
{
	RestAssured.given()
	.spec(request)
	.pathParam("id",UserId)
	.when()
	.delete("/v2/pet/{id}")
	.then().statusCode(204).extract().jsonPath().getInt("id");
}


}
