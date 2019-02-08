package com.sw300.acme.course;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "course", path = "courses")
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    List<Course> findByTitleContaining(@Param("title") String title);


}
