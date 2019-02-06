package com.sw300.acme.clazz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by uengine on 2019. 2. 6..
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Course that matches the courseId is not found")
public class CourseNotFoundException extends RuntimeException {}