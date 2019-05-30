package com.sw300.acme.customer;

import com.sw300.acme.AcmeApplication;
import com.sw300.acme.EventProducer;
import com.sw300.acme.Streams;
import com.sw300.acme.clazz.Clazz;
import lombok.Data;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

@Entity
//@Data
public class Enrollment {
    @Id @GeneratedValue
    private Long id;

    private String status;
    private Date date;
    private int grade;

    @ManyToOne @JoinColumn(name="clazzId")
    Clazz clazz;

    @ManyToOne @JoinColumn(name="customerId")
    Customer customer;

    public Enrollment() {
    }

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "enrollment")
    Set<Payment> payments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @PostPersist
    private void publishEnrolledEvent(){
//        Streams streams = AcmeApplication.getApplicationContext().getBean(Streams.class);

//        MessageChannel messageChannel = streams.outboundChannel();
//
        Enrolled enrolled = new Enrolled();
        enrolled.setClassId(""+getClazz().getId());
        enrolled.setCourseTitle(""+getClazz().getCourse().getTitle());
        enrolled.setCustomerId(""+getCustomer().getId());
        enrolled.setCustomerName(""+getCustomer().getFirstName() + " " + getCustomer().getLastName());
        enrolled.setHour(getClazz().getCourse().getDuration()*8);
        enrolled.setPrice(getClazz().getPrice());
//
//        messageChannel.send(MessageBuilder
//                .withPayload(enrolled)
//                .setHeader("key", enrolled.getCustomerId())
//                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                .build());
//
//        System.out.println("Event published");


        EventProducer producer = AcmeApplication.getApplicationContext().getBean(EventProducer.class);

        producer.sendMessage(enrolled);


        //이메일 발송

        //대시보드 정보 업데이트


    }
}
