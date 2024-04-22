package apiTest;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponceData {
	
	
	@Test(priority = 1)
	public void verifyJsonfield() {
		Boolean status=false;
		
		Response res=given()
		   .contentType(ContentType.JSON)
		 .when()
		   .get("https://reqres.in/api/users?page=2");
		
		JSONObject jo=new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++){
			
			String lastname = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println(lastname);
			
			if (lastname.equals("Lawson")) {
				status=true;
				break;//if comment break then console all last name 
				
			}
		}
		Assert.assertEquals(status, true);

	}

}
