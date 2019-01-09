package com.sw300.acme;

import com.sw300.acme.customer.Customer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.sw300.acme.customer.CustomerRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @After
    public void cleanup() {
        customerRepository.deleteAll();
    }

    @Test
    public void createAndLoadCustomer() {
        //given
        customerRepository.save(Customer.builder().
                firstName("세욱").
                lastName("김").
                job("dev").
                industry("IT").
                email("return@rsquare.co.kr").
                phone("01066147741").
                membership(true).
                build()
        );

        //when
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();

        //then
        Customer customer = customerList.get(0);
        assertThat(customer.getEmail(), is("return@rsquare.co.kr"));
    }
}