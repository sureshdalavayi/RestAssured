package rESTAssured;

import org.testng.annotations.Test;

public class TestCases {

//	STATUS 400Returned if an error occurs.
//	STATUS 401Returned if the calling user is not authenticated.
//	STATUS 204Returned if the issue was removed successfully.
//	STATUS 403Returned if the calling user does not have permission to delete the issue.
//	STATUS 404Returned if the issue does not exist.
	
	
	@Test (priority=0, enabled=true)
	public void GetToken() {
		
		JIRA_Authorize_POST oAt=new JIRA_Authorize_POST();
		oAt.GetAuthorizeToken();
	}

	@Test (priority=1, enabled=true)
	public void CreateIssue() throws Exception {
		JIRA_Create_Issue_POST oCi=new JIRA_Create_Issue_POST();
		oCi.CreateJIRAissue(ReusableMethods.GetToken());
	}
	
	@Test (priority=2, enabled=true)
	public void GetIssue() throws Exception {
		
		JIRA_Get_Issue_GET oGi=new JIRA_Get_Issue_GET();
		oGi.GetCreatedIssue(ReusableMethods.GetToken());
	}

	@Test (priority=3, enabled=true)
	public void AddComment() throws Exception {
		
		JIRA_Add_Comment_POST oAc=new JIRA_Add_Comment_POST();
		oAc.AddCommentToExistingIssue(ReusableMethods.GetToken(),6);
	}
	
	@Test (priority=4, enabled=true)
	public void UpdateComment() throws Exception {
		
		JIRA_Update_Comment_PUT oUc=new JIRA_Update_Comment_PUT();
		oUc.UpdateEnteredComment(ReusableMethods.GetToken());
	}
	
	@Test (priority=5, enabled=true)
	public void DeleteIssue() {
		
		JIRA_Delete_Issue oDi=new JIRA_Delete_Issue();
		oDi.DeleteCreatedIssue(ReusableMethods.GetToken());
	}

}
