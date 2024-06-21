package RestTask;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;


/*
NOT WORKING
Stuck with redirect issue
*/

public class RestTask {
    @Test
    public void RestTask(){
        File jsonData = new File("D:\\IdeaProjects\\testautomation\\data.json");
        File jsonAddData = new File("D:\\IdeaProjects\\testautomation\\addData.json");
        Cookies cookies = RestAssured.given()
                .baseUri("https://opensource-demo.orangehrmlive.com")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .when()
                .redirects().follow(false)
                .post("/index.php/auth/validate").then().statusCode(302).extract().response().getDetailedCookies();

        System.out.println((String.valueOf(cookies)));
        Response response = RestAssured.given()
                .baseUri("https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(jsonAddData)
                .when().post().then().statusCode(200).extract().response();

        System.out.println(response);

        }
}
