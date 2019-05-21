package rESTAssured;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JIRA_Add_Comment_POST {

	public void AddCommentToExistingIssue(String token, int Number) throws Exception {
	
		RestAssured.baseURI="http://localhost:8080";
		
		given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+token).
		body("{\r\n" + 
				"    \"body\": \"Adding First Comment from Eclipse.\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").
		
		when().
		post("/rest/api/2/issue/RES-"+Number+"/comment").
		
		then().
		assertThat().statusCode(201).and().contentType(ContentType.JSON);
		System.out.println("Working as expected");

	}

}
