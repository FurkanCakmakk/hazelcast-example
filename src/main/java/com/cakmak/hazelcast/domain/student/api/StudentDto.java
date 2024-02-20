package com.cakmak.hazelcast.domain.student.api;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String id;
    private String firstname;
    private String lastname;
    private int age;

}
