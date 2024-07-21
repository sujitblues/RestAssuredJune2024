package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class responseDemo {
	
	@Test
	public void getUserList()
	{
		Response response=given()
		.baseUri("https://reqres.in/")
		.log().all()
		.when()
		.get("api/users?page=2")
		.then().log().all().extract().response();
		int pageNo=response.jsonPath().getInt("page");
		System.out.println("pageNo :"+pageNo);
		String email=response.jsonPath().getString("data[0].email");
		System.out.println("email :" + email);
		
		}

	@Test
	public void createUser()
	{
		UserPojo payload=new UserPojo();
		payload.setName("Rahul");
		payload.setJob("QA");
		
		Response response=given()
		.baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("api/users")
		.then().log().all().extract().response();
		int scode=response.statusCode();
		System.out.println("Status code :"+scode );
		String sline=response.statusLine();
		System.out.println("Status code :"+sline );
	}
}
