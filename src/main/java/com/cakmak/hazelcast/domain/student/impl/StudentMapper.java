package com.cakmak.hazelcast.domain.student.impl;

import com.cakmak.hazelcast.domain.student.api.StudentDto;

public class StudentMapper {
    public static StudentDto toDto(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .age(student.getAge())
                .build();
    }

    public static Student toEntity(Student student , StudentDto dto){
        student.setFirstname(dto.getFirstname());
        student.setLastname(dto.getLastname());
        student.setAge(dto.getAge());
        return student;
    }


}
