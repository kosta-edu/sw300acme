package com.sw300.acme.course;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "discipline", path = "disciplines")
public interface DisciplineRepository extends PagingAndSortingRepository<Discipline, Long> {
}
