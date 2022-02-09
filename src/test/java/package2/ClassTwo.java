package package2;

import io.restassured.response.Response;
import package1.ClassOne;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static package1.ClassOne.*;

public class ClassTwo {

    public static void main(String[] args) {


        //3.Que son los static import en REST assured y por que son necesarios?
        ClassOne.method2();
        ClassOne classOne = new ClassOne();
        classOne.method1();
        method2();
        method3();
        given();
        given();


//        //4. Que son los métodos given,when y then en REST assured
        given()
                .param("page", "2")
                .auth().none()
                .when().get("https://reqres.in/api/users")
                .then().statusCode(200)
                .body("page", equalTo(2));


//        // 5 Cuantos tipos de autenticaciones soporta REST assured?
        given()
                .param("page", "2")
                .auth().basic("userName", "password")
                .auth().oauth2("accessToken")
                .when().get("https://reqres.in/api/users")
                .then().statusCode(200)
                .body("page", equalTo(2));


        //6. Como validar Response Time de la API?
        Response getResponse = given()
                .param("page", "2")
                .auth().none()
                .when().get("https://reqres.in/api/users");
        getResponse.getTime();
        getResponse.getTimeIn(TimeUnit.SECONDS);
        getResponse.time();
        getResponse.timeIn(TimeUnit.SECONDS);

        System.out.println("1- getTime() is: " + getResponse.getTime());
        System.out.println("2- getTimeIn() is: " + getResponse.getTimeIn(TimeUnit.SECONDS));
        System.out.println("3- time() is: " + getResponse.time());
        System.out.println("4- timeIn() is: " + getResponse.timeIn(TimeUnit.SECONDS));


    }
}
