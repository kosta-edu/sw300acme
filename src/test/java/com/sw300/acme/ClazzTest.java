package com.sw300.acme;

import com.sw300.acme.clazz.ClassDay;
import com.sw300.acme.clazz.Venu;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcmeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClazzTest {
    private static String CLAZZ_ENDPOINT = "http://localhost:8080/clazzs/";
    private static String CLASSDAY_ENDPOINT = "http://localhost:8080/classdays/";
    private static String VENU_ENDPOINT = "http://localhost:8080/venus/";

    @Autowired
    private TestRestTemplate template;

    @Test
    public void createVenu(){
        //given
        Venu venu = new Venu("판교8","유스페이스2B동 8층",20,"https://goo.gl/maps/NzPSg74zBPy");
        //when
        template.postForEntity(VENU_ENDPOINT,venu,Venu.class);
    }

    @Test
    public void createClassDay(){
        //given
        DateTime dt = new DateTime(2019, 2, 1, 0, 0);
        DateTime start = new DateTime(2019,2,1,9,0);
        DateTime end = new DateTime(2019,2,1,18,0);
        ClassDay classDay =
                new ClassDay(1,dt.toDate(),start.toDate(),end.toDate(),30);
        //when
        template.postForEntity(CLASSDAY_ENDPOINT,classDay,ClassDay.class);
    }

    @Test
    public void createClazz(){
        //given


    }
}
