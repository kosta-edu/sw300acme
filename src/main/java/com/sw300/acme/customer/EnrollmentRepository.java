package com.sw300.acme.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "enrollment", path = "enrollments")
public interface EnrollmentRepository extends PagingAndSortingRepository<Enrollment, EnrollmentPK> {
    @Query(value = "select * from enrollment where customer_id=?1", nativeQuery = true)
    List<Enrollment> findEnrollmentUsingCustomer(Long customerId);
}
