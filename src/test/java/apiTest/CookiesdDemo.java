package apiTest;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesdDemo {
	
@Test
public void testCookie() {
		
		given()
		
		.when()
		  .get("https://www.google.com/") 
		
		.then()
		  .cookie("AEC", "AQTF6HyllnOsvZTHUaL9ejb7EmJROimfF4ZTkAXC3WiMf3mZ_YKpsc563w")
		  .statusCode(200)
		  .log().all()
		;		
	}
@Test
public void testCookies() {
		
 Response res=given()
		
		.when()
		  .get("https://www.google.com/") ;
		Map<String, String> cookies_vaslue = res.getCookies();
 
 for (String k:cookies_vaslue.keySet()) {
	             String cookies = res.getCookie(k);
	             System.out.println(k+"    "+cookies);
}
		
//		.then()
//		  .statusCode(200)
//		  .log().all()
//		;		
	}
}
