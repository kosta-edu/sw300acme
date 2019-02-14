package com.sw300.acme.clazz;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface ClazzDayRepository extends PagingAndSortingRepository<ClazzDay, Long> {
}
