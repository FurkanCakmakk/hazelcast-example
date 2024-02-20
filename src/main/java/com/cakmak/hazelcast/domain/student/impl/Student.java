package com.cakmak.hazelcast.domain.student.impl;

import com.cakmak.hazelcast.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = Student.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Student extends AbstractEntity {
    public static final String TABLE = "student";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String AGE = "age";

    @Column(name = FIRSTNAME)
    private String firstname;

    @Column(name = LASTNAME)
    private String lastname;

    @Column(name = AGE)
    private Integer age;

}
