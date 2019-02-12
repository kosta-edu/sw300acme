package com.sw300.acme.clazz;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "clazz", path = "clazzes")
public interface ClazzRepository extends PagingAndSortingRepository<Clazz, Long> {
}
