package com.sw300.acme.clazz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sw300.acme.AcmeApplication;
import com.sw300.acme.EventProducer;
import com.sw300.acme.course.Course;

import javax.persistence.*;
import java.util.List;

@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClazzStatus status;
    private double evaluationRate;

    @ManyToOne @JoinColumn(name = "courseId")
   // @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Course course;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ClazzDay> clazzDayList;

    private float price;

    public Clazz() {
    }


    @PostPersist
    public void copyPriceFromUnitPrice(){
        try {
            setPrice(getCourse().getUnitPrice());
        }catch(RuntimeException e){
            throw new CourseNotFoundException();
        }
    }

    @PostRemove
    public void publishCancelled(){

        EventProducer producer = AcmeApplication.getApplicationContext().getBean(EventProducer.class);
        producer.sendMessage(new ClassCancelled(this));

    }

    public Clazz(ClazzStatus status, double evaluationRate) {
        this.status = status;
        this.evaluationRate = evaluationRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClazzStatus getStatus() {
        return status;
    }

    public void setStatus(ClazzStatus status) {
        this.status = status;
    }

    public double getEvaluationRate() {
        return evaluationRate;
    }

    public void setEvaluationRate(double evaluationRate) {
        this.evaluationRate = evaluationRate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<ClazzDay> getClazzDayList() {
        return clazzDayList;
    }

    public void setClazzDayList(List<ClazzDay> clazzDayList) {
        this.clazzDayList = clazzDayList;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
