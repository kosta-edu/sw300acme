package com.sw300.acme.customer;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EnrollmentPK implements Serializable {
    private Long customerId;
    private Long clazzId;

    public EnrollmentPK(Long customerId, Long clazzId) {
        this.customerId = customerId;
        this.clazzId = clazzId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof EnrollmentPK)) return false;

        EnrollmentPK that = (EnrollmentPK) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(customerId, that.customerId)
                .append(clazzId, that.clazzId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(customerId)
                .append(clazzId)
                .toHashCode();
    }
}
