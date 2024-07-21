package Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class studentAuth {
	String token;
	@Test(priority=1)
	public void studentAuth()
	{
		//https://partner.auth.stg.studyreach.com/oauth2/token
		String client_id="6nlr6urkv59tj7an35fmhfalik";
		String secret_id="1jqcepanappk218a81de01j6ucu1tvhmij1ckkhhd9pbeepftj36";
		
		Response response=RestAssured.given()
		.baseUri("https://partner.auth.stg.studyreach.com")
		.auth().preemptive().basic(client_id,secret_id)
		.queryParam("grant_type", "client_credentials")
		.queryParam("scope", "https://stg.studyreach.com/studyreach.admin")
		.log().all()
		.when()
		.post("/oauth2/token")
		.then().log().all().extract().response();
		int statusCode=response.statusCode();
		 token=response.jsonPath().getString("access_token");
		Assert.assertEquals(statusCode, 200,"Checking status code");
	}
	
	@Test(priority=2)
	public void getStudentList()
	{
		Response response=RestAssured.given()
				.baseUri("https://apistudent.stg.studyreach.com")
				.log().all()
				.header("Authorization","studyreach-studentmicroservice-oauthtoken "+token)
				.header("partner","STGSTRP0000456PFZA")
				.when()
				.get("/v1/view-all-applications/")
				.then().log().all().extract().response();
		
				int statusCode=response.statusCode();
				 
				Assert.assertEquals(statusCode, 200,"Checking status code");
	}

}
