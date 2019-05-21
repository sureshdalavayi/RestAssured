package rESTAssured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JIRA_Get_Issue_GET {

	public void GetCreatedIssue(String token) {

 
		RestAssured.baseURI="http://localhost:8080";
	    
	    given().
	    		header("Cookie","JSESSIONID="+token).
	    		
	            when().
	            get("/rest/api/2/issue/RES-1").
	            
	            then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	            System.out.println("Working as expected");

	}

}
