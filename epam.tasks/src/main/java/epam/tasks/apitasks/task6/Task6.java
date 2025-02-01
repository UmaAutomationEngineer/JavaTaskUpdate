package epam.tasks.apitasks.task6;

import static org.hamcrest.Matchers.lessThan;

import java.util.Base64;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Task6 {
	
	@Test
    public void task1() {
        String userName = "umamaheswari_rajamanickam@epam.com";
        String token = "ATATT3xFfGF0ougeRf5DH5kH5oHS0n6SKvDbWfNlTpz_5kM57zJpHyLrOYIprC2pNOm9qNHH1K_t3a9PiyUCdK0sZeVyS9UsginLkpeq3lIBOf8bTQgRR0D-_PxR-pS_M9hV761Em-GNqxvGbPEpnSoT25-5nhSE4yrSmNWyhHuIMR8Fzm-97LQ=1618EDDC";
        String encodeCredentials = new String(Base64.encodeBase64((userName + ":" + token).getBytes()));

        String AUTHORIZATION_HEADER = "Authorization";
     // Creating an issue
        RestAssured.baseURI = "https://umamaheswari.atlassian.net";
        RestAssured.basePath = "/rest/api/3/issue";
        Response response = RestAssured.given()
                .header(AUTHORIZATION_HEADER, "Basic " + encodeCredentials)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(JiraPayload.bodyToCreateIssue)
                .when()
                .post();
        System.out.println(response.print());
        response.then().assertThat().statusCode(201);
        System.out.println(response.getBody().asString());

        String idOfNewlyCreatedIssue = response.jsonPath().get("id");
        System.out.println("New bug got created with id : " + idOfNewlyCreatedIssue);
        
     // Updating an issue
        Response updateResponse = RestAssured.given()
                .header(AUTHORIZATION_HEADER, "Basic " + encodeCredentials)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(JiraPayload.bodyToUpdateIssue)
                .when()
                .put(idOfNewlyCreatedIssue,"https://umamaheswari.atlassian.net/rest/api/3/issue/{idOfNewlyCreatedIssue}");
        updateResponse.then().assertThat().statusCode(lessThan(300));
        System.out.printf("Bug with id '%s' got updated successfully.\n", idOfNewlyCreatedIssue);
        
     // Searching an issue
        Response searchResponse = RestAssured.given()
                .header(AUTHORIZATION_HEADER, "Basic " + encodeCredentials)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("https://umamaheswari.atlassian.net/rest/api/3/search");
        List<String> idsList = searchResponse.jsonPath().getList("issues.id");
        System.out.println("All bugs found in search > " + idsList);
        Assert.assertTrue( idsList.contains(idOfNewlyCreatedIssue),"Newly created Bug id is not searchable");
        System.out.printf("Newly created Bug with id '%s' found in the search response.\n", idOfNewlyCreatedIssue);

        // Add an attachment to the issue
        Response attachmentResponse = (Response) RestAssured.given()
                .header(AUTHORIZATION_HEADER, "Basic " + encodeCredentials)
                .header("Content-Type", "multipart/form-data")
                .header("X-Atlassian-Token", "no-check")
                .accept(ContentType.JSON)
                .multiPart("file", new File(System.getProperty("user.dir") + "/apitesting/task6/Attachment.txt"))
                
             // Delete an issue
                Response deleteResponse = RestAssured.given()
                        .header(AUTHORIZATION_HEADER, "Basic " + encodeCredentials)
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .delete("https://umamaheswari.atlassian.net/rest/api/3/issue/{idOfNewlyCreatedIssue}", idOfNewlyCreatedIssue);
                deleteResponse.then().assertThat().statusCode(lessThan(300));
                System.out.printf("Bug with id '%s' got deleted.", idOfNewlyCreatedIssue);

            }
}









