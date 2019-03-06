package com.sw300.acme.farota;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SectorDevice {
    @Id
    private SectorDevicePK pk;
}
