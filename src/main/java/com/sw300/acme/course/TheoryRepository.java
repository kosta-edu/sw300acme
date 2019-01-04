package com.sw300.acme.course;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "theory", path = "theorys")
public interface TheoryRepository extends PagingAndSortingRepository<Theory, Long> {
}
