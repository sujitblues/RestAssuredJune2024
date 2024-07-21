package Auth;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Oauth2 {
	String token;
	
	@Test(priority=1)
	public void getAccessToken()
	{
		String client_id="AX_tLWfeEFeaYeg5B7zMY6lswRi9lYUr2M5udXn97zNya-FeYJog8xw1Y2QTCSSRRn704jLnxWjglJGf";
		String client_secret="EEM3Lc6lXRMVoK82oZY6xZ-14GmziyLKgHYRr3IAwQGxAAjyDjEqU7CYLVKhlQ8NBVXA3pvEF15EEXJn";
		
				
		Response response=RestAssured.given()
		.baseUri("https://api-m.sandbox.paypal.com/v1")
		.auth().preemptive().basic(client_id,client_secret)
		.queryParam("grant_type", "client_credentials")
		.log().all()
		.when()
		.post("/oauth2/token")
		.then().log().all().extract().response();
		
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200,"checking status code");
		String statusLine=response.statusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","checking status code");
		token=response.jsonPath().getString("access_token");
	}
	
	
	@Test(priority=2)
	public void genrateInvoice()
	{
		
		Response response=RestAssured.given()
		.baseUri("https://api-m.sandbox.paypal.com/v1")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer "+token)
		.queryParam("page", 1)
		.queryParam("page_size", 2)
		.queryParam("total_count_required", true)
		.log().all()
		.when()
		.get("/invoicing/invoices")
		.then().log().all().extract().response();
		
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
		String statusLine=response.statusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","checking status code");
		
	}
}
