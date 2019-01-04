package com.sw300.acme.clazz;

import com.sw300.acme.course.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "venu", path = "venus")
public interface VenuRepository extends PagingAndSortingRepository<Venu, Long> {
}
