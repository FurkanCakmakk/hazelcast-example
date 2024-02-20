package com.cakmak.hazelcast.domain.student.api;

import java.util.List;

public interface StudentService {

    StudentDto getById(String id);

    StudentDto save(StudentDto dto);

    StudentDto update(String id, StudentDto dto);

    void delete(String id);

    List<StudentDto> getAll();
}
