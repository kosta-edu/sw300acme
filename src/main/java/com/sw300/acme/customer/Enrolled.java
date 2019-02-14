package com.sw300.acme.customer;

import lombok.Data;

/**
 * Created by uengine on 2019. 2. 12..
 */
@Data
public class Enrolled {

    String classId;
    String courseTitle;
    String customerId;
    String customerName;
    private int hour;
    private float price;

}
