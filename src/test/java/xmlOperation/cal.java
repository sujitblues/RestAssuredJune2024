package xmlOperation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cal {
	int AddResult;
	int SubResult;
	int MulResult;
	@Test(priority=1)
	public void Add()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>20</intA>\r\n"
				+ "      <intB>10</intB>\r\n"
				+ "    </Add>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		
		Response response=RestAssured.given()
		.header("Content-Type","text/xml; charset=utf-8")
		.body(payload)
		.log().all()
		.when()
		.post("http://www.dneonline.com/calculator.asmx?op=Add")
		.then().log().all().extract().response();
		 AddResult=response.xmlPath().getInt("Envelope.Body.AddResponse.AddResult");
		System.out.println(AddResult);
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=2)
	public void Sub()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Subtract xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>"+AddResult+"</intA>\r\n"
				+ "      <intB>10</intB>\r\n"
				+ "    </Subtract>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		
		Response response=RestAssured.given()
		.header("Content-Type","text/xml; charset=utf-8")
		.body(payload)
		.log().all()
		.when()
		.post("http://www.dneonline.com/calculator.asmx?op=Subtract")
		.then().log().all().extract().response();
		SubResult=response.xmlPath().getInt("Envelope.Body.SubtractResponse.SubtractResult");
		System.out.println(SubResult);
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3)
	public void Mul()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Multiply xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>"+SubResult+"</intA>\r\n"
				+ "      <intB>5</intB>\r\n"
				+ "    </Multiply>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		
		Response response=RestAssured.given()
		.header("Content-Type","text/xml; charset=utf-8")
		.body(payload)
		.log().all()
		.when()
		.post("http://www.dneonline.com/calculator.asmx?op=Multiply")
		.then().log().all().extract().response();
		MulResult=response.xmlPath().getInt("Envelope.Body.MultiplyResponse.MultiplyResult");
		System.out.println(MulResult);
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=4)
	public void Div()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Divide xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>"+MulResult+"</intA>\r\n"
				+ "      <intB>20</intB>\r\n"
				+ "    </Divide>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		
		Response response=RestAssured.given()
		.header("Content-Type","text/xml; charset=utf-8")
		.body(payload)
		.log().all()
		.when()
		.post("http://www.dneonline.com/calculator.asmx?op=Divide")
		.then().log().all().extract().response();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
