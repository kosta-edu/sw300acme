package com.sw300.acme.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "enrollment", path = "enrollments")
public interface EnrollmentRepository extends PagingAndSortingRepository<Enrollment, Long> {
}
