package com.sw300.acme.sme;

import com.sw300.acme.customer.Enrollment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "instructor", path = "instructors")
public interface InstructorRepository extends PagingAndSortingRepository<Instructor, Long> {
    @Query(value = "SELECT ID FROM Instructor WHERE EXISTS (SELECT FROM ClassDay WHERE tI.ID = C.InstructorID AND C.Date >= ?1)", nativeQuery = true)
    List<Instructor> findInstructorsByDate(String date);

    @Query(value = "SELECT S.Fname, S.Lname FROM SME S JOIN Instructor I ON (S.ID = I.SMEID) WHERE I.PayRate = (SELECT MAX(PayRate) FROM Instructor)", nativeQuery = true)
    Instructor findInstructorByMaxPayRate();
}
