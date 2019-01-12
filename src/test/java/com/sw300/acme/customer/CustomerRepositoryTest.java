package com.sw300.acme.customer;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
    CustomerRepository customerRepo;

    @After
    public void cleanup() {
        customerRepo.deleteAll();
    }

    @Test
    public void saveAndFindAll() {
        //given
        final Customer customer = customerRepo.save(Customer.builder().
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
        List<Customer> customerList = (List<Customer>) customerRepo.findAll();
        Customer firstCustomer = customerList.get(0);
        //then
        assertNotNull(firstCustomer);
        assertThat(firstCustomer.getEmail(), is("return@rsquare.co.kr"));
        assertThat(customer.getId(), is(firstCustomer.getId()));
    }
}