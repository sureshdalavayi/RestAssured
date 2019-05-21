package rESTAssured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class JIRA_Delete_Issue {

	public void DeleteCreatedIssue(String token) {
		
		given().
		header("Cookie","JSESSIONID="+token).
		
        when().
        delete("/rest/api/2/issue/RES-10").
        
        then().assertThat().statusCode(204).and().contentType(ContentType.JSON);
        System.out.println("Working as expected");
		
	}

}
