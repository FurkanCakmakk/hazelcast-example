package com.cakmak.hazelcast.domain.student.web;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentRequest {
    private String firstname;
    private String lastname;
    private Integer age;

}
