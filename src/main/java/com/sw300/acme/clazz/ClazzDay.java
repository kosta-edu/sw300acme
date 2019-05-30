package com.sw300.acme.clazz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sw300.acme.AcmeApplication;
import com.sw300.acme.EventProducer;
import com.sw300.acme.Streams;
import com.sw300.acme.customer.Enrolled;
import com.sw300.acme.sme.Instructor;
import lombok.Data;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ClazzDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
    private Date date;
    private Date startTime;
    private Date endTime;
    private int instructorPay;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Clazz clazz;

    @ManyToOne
    private Venu venu;

    @OneToMany(mappedBy = "clazzDay", cascade = CascadeType.ALL)
    private List<Instructor> instructorList;

    public ClazzDay(){}

    public ClazzDay(int number, Date date, Date startTime, Date endTime, int instructorPay) {
        this.number = number;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructorPay = instructorPay;
    }


    @PostPersist
    private void publishClassRegisteredEvent(){

        // version 1.
        // try{이메일 발송 코드}catch(Exception e){}

        // version 2.
        // REST 호출 to 마케팅 서비스 // 장애전파

        // version 2.5
        // REST 호출이 반응 없으면 회로 차단 --- circuit breaker

        // version 3. event-driven

        EventProducer producer = AcmeApplication.getApplicationContext().getBean(EventProducer.class);
        producer.sendMessage(new ClassDayRegistered(this));

        System.out.println("Event published");

    }

}
