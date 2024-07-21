package day4;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class RequestDemo {
	Faker faker;
	
	@Test
	public void createPet()
	{
		MainPojo payload=new MainPojo();
		faker=new Faker();
		payload.setId(faker.hashCode());
		
		categoryPojo category=new categoryPojo();
		category.setId(faker.hashCode());
		category.setName("petAnimal");
		payload.setCategory(category);
		payload.setName("doggie");
		String photoUrls[]= {"http://photourldumy"};
		payload.setPhotoUrls(photoUrls);
		
		TagsPojo tags=new TagsPojo();
		tags.setId(12);
		tags.setName("Animal");
		tags.setId(13);
		tags.setName("petAnimal");
		List<TagsPojo> tag=new ArrayList<TagsPojo>();
		tag.add(tags);
		
		payload.setTags(tag);
		payload.setStatus("available");
		
		RestAssured.given()
		.baseUri("https://petstore.swagger.io")
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("/v2/pet")
		.then().log().all().statusCode(200);
		
	}

}
