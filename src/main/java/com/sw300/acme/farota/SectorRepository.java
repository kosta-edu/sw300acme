package com.sw300.acme.farota;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sector", path = "sectors")
public interface SectorRepository extends PagingAndSortingRepository<Sector, Long> {
}
