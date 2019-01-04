package com.sw300.acme.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "payment", path = "payments")
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
}
