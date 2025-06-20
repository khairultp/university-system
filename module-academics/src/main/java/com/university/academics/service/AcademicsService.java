package com.university.academics.service;

import java.util.List;

public interface AcademicsService {

    void registerForCourses(Long studentId, List<String> courseIds);
}
