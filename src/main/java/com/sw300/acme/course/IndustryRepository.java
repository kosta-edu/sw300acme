package com.sw300.acme.course;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "industry", path = "industrys")
public interface IndustryRepository extends PagingAndSortingRepository<Industry, Long> {
}
