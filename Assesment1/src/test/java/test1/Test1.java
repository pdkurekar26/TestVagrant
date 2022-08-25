package test1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {

	@Test
	public void Assesment()
	{
		RestAssured.baseURI = "URI";
		
		RequestSpecification hrequest = RestAssured.given();
		
		Response responce = hrequest.request(Method.GET,"/RCB");
		
//		String responceBody = responce.getBody().asString();
//		
//		System.out.println("Responce Body is :" + responceBody);
		
		JsonPath json = responce.jsonPath();
		
		System.out.println(json.get("name"));
		System.out.println(json.get("country"));
		System.out.println(json.get("role"));
		System.out.println(json.get("price-in-crores"));
		
		Assert.assertEquals(json.get("country"), "South Africa");
		Assert.assertEquals(json.get("country"), "Australia");
		Assert.assertEquals(json.get("country"), "Srilanka");
		Assert.assertEquals(json.get("role"), "Wicket-keeper");
		
	}
}