package com.sw300.acme;

import com.sw300.acme.clazz.ClassDay;
import com.sw300.acme.clazz.Clazz;
import com.sw300.acme.clazz.ClazzStatus;
import com.sw300.acme.clazz.Venu;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcmeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ClazzTest {
    private static String VENU_ENDPOINT = "http://localhost:8080/venus";
    private static String CLAZZ_ENDPOINT = "http://localhost:8080/clazzs";
    private static String CLASSDAY_ENDPOINT = "http://localhost:8080/classdays";

    @Autowired
    private TestRestTemplate template;

    @Test
    public void createSingleVenu(){
        //given
        Venu venu = new Venu("판교8","유스페이스2B동 8층",20,"https://goo.gl/maps/NzPSg74zBPy");
        //when
        template.postForEntity(VENU_ENDPOINT,venu,Venu.class);
        //then
        ResponseEntity<Venu> venuGetResponse
                = template.getForEntity(VENU_ENDPOINT + "/1", Venu.class);
        assertEquals(venuGetResponse.getBody().getName(), "판교8");
    }

    @Test
    public void createSingleClazz(){
        //given
        Clazz clazz = new Clazz(ClazzStatus.CREATED,70);
        //when
        template.postForEntity(CLAZZ_ENDPOINT,clazz,Clazz.class);
        //then
        ResponseEntity<Clazz> clazzGetResponse
                = template.getForEntity(CLAZZ_ENDPOINT + "/2", Clazz.class);
        assertNotNull(clazzGetResponse.getBody());
        assertEquals(clazzGetResponse.getBody().getStatus(), ClazzStatus.CREATED);
    }

    @Test
    public void createSingleClassDay(){
        //given
        Date date = date(2019,2,1,0,0);
        Date start = date(2019,2,1,9,0);
        Date end = date(2019,2,1,18,0);
        ClassDay classDay = new ClassDay(1,date,start,end,30);
        //when
        template.postForEntity(CLASSDAY_ENDPOINT,classDay,ClassDay.class);
        //then
        ResponseEntity<ClassDay> classDayGetResponse
                = template.getForEntity(CLASSDAY_ENDPOINT + "/3", ClassDay.class);
        assertNotNull(classDayGetResponse.getBody());
        assertEquals(classDayGetResponse.getBody().getNumber(), 1);
    }

    @Test
    public void crateEntityAndRelation(){
        //given
        Date date = date(2019,2,1,0,0);
        Date start = date(2019,2,1,9,0);
        Date end = date(2019,2,1,18,0);
        ClassDay classDay = new ClassDay(1,date,start,end,30);
        template.postForEntity(CLASSDAY_ENDPOINT,classDay,ClassDay.class);

        Venu venu = new Venu("판교8","유스페이스2B동 8층",20,"https://goo.gl/maps/NzPSg74zBPy");
        template.postForEntity(VENU_ENDPOINT,venu,Venu.class);

        Clazz clazz = new Clazz(ClazzStatus.CREATED,0);
        template.postForEntity(CLAZZ_ENDPOINT,clazz,Clazz.class);

        //when
        ResponseEntity<Venu> venuGetResponse
                = template.getForEntity(VENU_ENDPOINT + "/1", Venu.class);
        assertNotNull(venuGetResponse.getBody());

        HttpHeaders requestHeaders = requestHeaders();
        HttpEntity<String> venuHttpEntity
                = new HttpEntity<>(VENU_ENDPOINT + "/1", requestHeaders);
        template.exchange(CLASSDAY_ENDPOINT + "/3/venu",
                HttpMethod.PUT, venuHttpEntity, String.class);

        ResponseEntity<Clazz> clazzGetResponse
                = template.getForEntity(CLAZZ_ENDPOINT + "/2", Clazz.class);
        assertNotNull(clazzGetResponse.getBody());

        HttpEntity<String> clazzHttpEntity
                = new HttpEntity<>(CLAZZ_ENDPOINT + "/2", requestHeaders);
        template.exchange(CLASSDAY_ENDPOINT + "/3/clazz",
                HttpMethod.PUT, clazzHttpEntity, String.class);

        //then
        ResponseEntity<Venu> classDayVenuGetResponse
                = template.getForEntity(CLASSDAY_ENDPOINT + "/3/venu", Venu.class);
        assertEquals(classDayVenuGetResponse.getBody().getName(), "판교8");
        ResponseEntity<Clazz> classDayClazzGetResponse
                = template.getForEntity(CLASSDAY_ENDPOINT + "/3/clazz", Clazz.class);
        assertEquals(classDayClazzGetResponse.getBody().getStatus(), ClazzStatus.CREATED);
    }

    private Date date(int year,
                      int monthOfYear,
                      int dayOfMonth,
                      int hourOfDay,
                      int minuteOfHour ){
        return new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour).toDate();
    }

    private HttpHeaders requestHeaders(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/uri-list");
        return requestHeaders;
    }
}
