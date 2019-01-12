package com.sw300.acme;

import com.sw300.acme.course.*;
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
public class CourseTest {
    private static String COURSE_ENDPOINT = "http://localhost:8080/courses";
    private static String COURSEWARES_ENDPOINT = "http://localhost:8080/coursewares";
    private static String DISCIPLINE_ENDPOINT = "http://localhost:8080/disciplines";
    private static String INDUSTRY_ENDPOINT = "http://localhost:8080/industrys";

    @Autowired
    private TestRestTemplate template;

    @Test
    public void createSingleCourse(){
        //given
        Course course = new Course("DevOps with Docer",2,"도커 강의",20,8,600000);
        //when
        template.postForEntity(COURSE_ENDPOINT,course,Course.class);
        //then
        ResponseEntity<Course> courseGetResponse
                = template.getForEntity(COURSE_ENDPOINT + "/1", Course.class);
        assertEquals(courseGetResponse.getBody().getTitle(),course.getTitle());
    }

    @Test
    public void createSingleCourseware(){
        //given
        Courseware courseware = new Courseware(CoursewareType.SW,"이클립스","실습");
        //when
        template.postForEntity(COURSEWARES_ENDPOINT,courseware,Courseware.class);
        //then
        ResponseEntity<Courseware> courseGetResponse
                = template.getForEntity(COURSEWARES_ENDPOINT + "/2", Courseware.class);
        assertEquals(courseGetResponse.getBody().getTitle(),"이클립스");
    }

    @Test
    public void createSingleDiscipline(){
        //given
        Discipline discipline = new Discipline("강의","강의");
        //when
        template.postForEntity(DISCIPLINE_ENDPOINT,discipline,Discipline.class);
        //then
        ResponseEntity<Discipline> disciplineGetResponse
                = template.getForEntity(DISCIPLINE_ENDPOINT + "/3", Discipline.class);
        assertEquals(disciplineGetResponse.getBody().getName(),"강의");
    }
}
