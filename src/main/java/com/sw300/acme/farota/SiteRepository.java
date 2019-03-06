package com.sw300.acme.farota;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "site", path = "sites")
public interface SiteRepository extends PagingAndSortingRepository<Site, Long> {
}
