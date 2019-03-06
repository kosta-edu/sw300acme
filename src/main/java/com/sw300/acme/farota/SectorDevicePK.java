package com.sw300.acme.farota;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SectorDevicePK implements Serializable {
    private Long sectorId;
    private Long deviceId;

    public SectorDevicePK(Long sectorId, Long deviceId) {
        this.sectorId = sectorId;
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SectorDevicePK)) return false;

        SectorDevicePK that = (SectorDevicePK) o;

        return new EqualsBuilder()
                .append(sectorId, that.sectorId)
                .append(deviceId, that.deviceId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sectorId)
                .append(deviceId)
                .toHashCode();
    }
}
