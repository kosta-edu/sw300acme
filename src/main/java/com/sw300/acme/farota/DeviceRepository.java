package com.sw300.acme.farota;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "device", path = "devices")
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {
}
