package com.cakmak.hazelcast.domain.student.impl;

import com.cakmak.hazelcast.domain.student.api.StudentDto;
import com.cakmak.hazelcast.domain.student.api.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    int sayi1;

    @Scheduled(fixedDelay = 1000)
    public void calculate() {
        sayi1 = sayi1 + 1;
        System.out.println(sayi1);
    }



    @Scheduled(fixedRate = 1010)
    public void printMessage() {
        System.out.println("Scheduled task is running...");
    }

    @Override
    public StudentDto getById(String id) {
        return StudentMapper.toDto(repository.findById(id).get());
    }

    @Override
    @Transactional
    public StudentDto save(StudentDto dto) {
        return StudentMapper.toDto(repository.save(StudentMapper.toEntity(new Student() , dto)));
    }

    @Override
    @Transactional
    public StudentDto update(String id, StudentDto dto) {
        return repository.findById(id).map(student -> StudentMapper.toDto(repository.save(setStudent(student , dto)))).get();
    }

    @Override
    @Transactional
    public void delete(String id) {
        var student = repository.findById(id).get();
        repository.delete(student);
    }

    @Override
    public List<StudentDto> getAll() {
         return repository.findAll().stream().map(student -> StudentMapper.toDto(student)).collect(Collectors.toList());
    }

    private Student setStudent(Student student , StudentDto dto){
        student.setFirstname(dto.getFirstname());
        student.setLastname(dto.getLastname());
        student.setAge(dto.getAge());
        return student;
    }


}
