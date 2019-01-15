package com.sw300.acme.course;

import com.sw300.acme.AcmeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcmeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JobTest {
    private static String INDUSTRY_ENDPOINT = "http://localhost:8080/industrys";
    private static String PRACTICE_ENDPOINT = "http://localhost:8080/practices";
    private static String THEORYS_ENDPOINT = "http://localhost:8080/theorys";
    private static String LO_ENDPOINT = "http://localhost:8080/los";
    private static String JOB_ENDPOINT = "http://localhost:8080/jobs";

    @Autowired
    private TestRestTemplate template;

    @Test
    public void createSingleIndustry(){
        //given
        Industry industry = new Industry("IoT");
        //when
        template.postForEntity(INDUSTRY_ENDPOINT,industry,Industry.class);
        //then
        ResponseEntity<Industry> industryGetResponse
                = template.getForEntity(INDUSTRY_ENDPOINT + "/1", Industry.class);
        assertEquals(industryGetResponse.getBody().getName(),industry.getName());
    }

    @Test
    public void createSinglePractice(){
        //given
        Practice practice = new Practice("TDD", "Test Driven Development");
        //when
        template.postForEntity(PRACTICE_ENDPOINT,practice,Practice.class);
        //then
        ResponseEntity<Practice> practiceGetResponse
                = template.getForEntity(PRACTICE_ENDPOINT + "/5", Practice.class);
        assertEquals(practiceGetResponse.getBody().getName(),practice.getName());
    }

    @Test
    public void createSingleTheory(){
        //given
        Theory theory = new Theory("OOAD","Object Oriented Analysis Design");
        //when
        template.postForEntity(THEORYS_ENDPOINT,theory,Theory.class);
        //then
        ResponseEntity<Theory> theoryGetResponse
                = template.getForEntity(THEORYS_ENDPOINT + "/3", Theory.class);
        assertEquals(theoryGetResponse.getBody().getName(),theory.getName());
    }

    @Test
    public void createSingleLO(){
        //given
        LearningObject lo =
                new LearningObject("Business Model","Understanding Software Business Models");
        //when
        template.postForEntity(LO_ENDPOINT,lo,LearningObject.class);
        //then
        ResponseEntity<LearningObject> theoryGetResponse
                = template.getForEntity(LO_ENDPOINT + "/4", LearningObject.class);
        assertEquals(theoryGetResponse.getBody().getName(),lo.getName());
    }

    @Test
    public void creatSingleJob(){
        //given
        Job job = new Job("Docker 101",1,"Practical Docker Course");
        //when
        template.postForEntity(JOB_ENDPOINT,job,Job.class);
        //then
        ResponseEntity<Job> jobGetResponse
                = template.getForEntity(JOB_ENDPOINT + "/2", Job.class);
        assertEquals(jobGetResponse.getBody().getTitle(),job.getTitle());

    }
}
