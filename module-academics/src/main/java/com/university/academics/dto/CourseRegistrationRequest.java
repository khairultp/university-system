package com.university.academics.dto;

import java.util.List;

public record CourseRegistrationRequest(Long studentId, List<String> courseIds) {}
