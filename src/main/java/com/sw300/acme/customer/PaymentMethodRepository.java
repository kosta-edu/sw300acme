package com.sw300.acme.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "paymentmethod", path = "paymentmethods")
public interface PaymentMethodRepository extends PagingAndSortingRepository<PaymentMethod, Long> {
}
