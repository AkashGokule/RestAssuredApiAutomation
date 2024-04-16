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
		  .cookie("ACE", "Ae3NU9M88ZAoovjJ8ad5mlkUg7AV7H9ZSJKwSzDEITTp375eeh7Ad20DyQg; expires=Sat, 28-Sep-2024 12:35:18 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax")
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
