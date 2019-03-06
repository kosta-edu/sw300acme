package com.sw300.acme.farota;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "companys")
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
