package com.cakmak.hazelcast.domain.student.web;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String id;
    private String firstname;
    private String lastname;
    private int age;

}
