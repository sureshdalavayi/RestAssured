package rESTAssured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class JIRA_Update_Comment_PUT {

	public void UpdateEnteredComment(String token) {
		
		given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+token).
		body("{\r\n" + 
				"    \"body\": \"Updating the First Comment from Eclipse.\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").
		
		when().
		put("/rest/api/2/issue/RES-1/comment/10001").
		
		then().
		assertThat().statusCode(200).and().contentType(ContentType.JSON);
		System.out.println("Working as expected");

	}

}
