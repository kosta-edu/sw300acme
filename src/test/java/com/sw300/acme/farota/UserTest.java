package com.sw300.acme.farota;

import com.sw300.acme.AcmeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcmeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTest {
    private static String USER_ENDPOINT = "http://localhost:8080/users";

    @Autowired
    private TestRestTemplate template;

    @Test
    public void createAUser(){
        //given
        User user = new User("scott");
        //when
        template.postForEntity(USER_ENDPOINT,user,User.class);
        //then
        final ResponseEntity<User> userResponse =
                template.getForEntity(USER_ENDPOINT + "/1", User.class);
        assertNotNull(userResponse.getBody());
        assertEquals(userResponse.getBody().getName(),user.getName());
    }

    @Test
    public void listUser(){
        
    }
}
