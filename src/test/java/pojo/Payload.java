package pojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Payload {

    public static void main(String[] args) throws JsonProcessingException {

        EmployeePojo employeePojo = new EmployeePojo("graviel", "QA", new String[]{"java", "REST Assured"}
                , "XYZ", "sosa@gmail.com");
        ObjectMapper objectMapper = new ObjectMapper();
        String payloadAsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojo);



        //7. Cómo enviar un payload en un POST API usando POJO classes?
//        Response getResponse = given()
//                .auth().none()
//                .header("Content-Type", "Application/json")
//                .contentType(ContentType.JSON)
//                .when()
//                .body(payloadAsJson).log().all()
//                .post("https://reqres.in/api/users");
//        String re = getResponse.asString();


        //8. Cómo logear request y response de un post API?
        given()
                .auth().none()
                .header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(payloadAsJson).log().all()
                .post("https://reqres.in/api/users")
                .then().log().all();

        //9. Cómo validar el response de un POST API?
        given()
                .auth().none()
                .header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(payloadAsJson).log().all()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .body("name", equalTo("graviel"),"job", equalTo("QA"),"skil[0]",equalTo("java"));

        //9. Cómo validar el response de un POST API? with Assert
        Response response=given()
                .auth().none()
                .header("Content-Type", "Application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(payloadAsJson).log().all()
                .post("https://reqres.in/api/users");
        Assert.assertEquals(response.getBody().path("name"),"graviel");
        Assert.assertEquals(response.getBody().path("job"),"QA");

        Assert.assertEquals(response.jsonPath().get("name"),"graviel");
    }
}
