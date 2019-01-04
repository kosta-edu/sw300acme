package com.sw300.acme.sme;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "instructor", path = "instructors")
public interface InstructorRepository extends PagingAndSortingRepository<Instructor, Long> {
}
