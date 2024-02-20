package com.cakmak.hazelcast.domain.student.api;

import com.cakmak.hazelcast.domain.student.web.StudentRequest;
import com.cakmak.hazelcast.domain.student.web.StudentResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class StudentMapper {

    public static StudentDto toDto(StudentRequest request){
        return StudentDto.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .age(request.getAge())
                .build();
    }


    public static StudentResponse toResponse(StudentDto dto){
        return StudentResponse.builder()
                .id(dto.getId())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .age(dto.getAge())
                .build();
    }

    public static List<StudentResponse> toResponse(List<StudentDto> dtos){
        return dtos.stream().map(StudentMapper::toResponse).toList();
    }


}
