package com.cakmak.hazelcast.domain.student.web;

import com.cakmak.hazelcast.domain.student.api.StudentDto;
import com.cakmak.hazelcast.domain.student.api.StudentMapper;
import com.cakmak.hazelcast.domain.student.api.StudentService;
import com.cakmak.hazelcast.library.rest.BaseController;
import com.cakmak.hazelcast.library.rest.DataResponse;
import com.cakmak.hazelcast.library.rest.MetaResponse;
import com.cakmak.hazelcast.library.rest.Response;
import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
//@CacheConfig(cacheNames = "students")
@Slf4j

public class StudentController extends BaseController {

    private final StudentService service;

    @Qualifier("hazelcastInstance")
    private final HazelcastInstance hazelcastInstance;

    private Map<String, StudentResponse> retrieveMap() {
        return hazelcastInstance.getMap("map");
    }

    @GetMapping()
    public Response<DataResponse<StudentResponse>> getAllStudents() {
        return respond(StudentMapper.toResponse(service.getAll()));
    }


    @GetMapping("/{id}")
//    @Cacheable(key = "#id")
    public Response<StudentResponse> getStudentById(@PathVariable String id) {
        StudentResponse studentResponse = retrieveMap().get(id);
        if (studentResponse == null) {
            log.info("fetching the student with id " + id + " from DB");
            StudentResponse student = StudentMapper.toResponse(service.getById(id));
            retrieveMap().put(id, student);
            return respond(student);
        } else {
            return respond(studentResponse);
        }
    }

    @PostMapping
    public Response<StudentResponse> save(@RequestBody StudentRequest request) {
        StudentResponse studentResponse = StudentMapper.toResponse(service.save(StudentMapper.toDto(request)));
        retrieveMap().put(studentResponse.getId() , studentResponse);
        return respond(studentResponse);
    }

    @PutMapping("/{id}")
//    @CachePut(key = "#id")
    public Response<StudentResponse> update(@PathVariable String id, @RequestBody StudentRequest request) {
        StudentResponse updatedStudent = StudentMapper.toResponse(service.update(id, StudentMapper.toDto(request)));
        if(updatedStudent != null){
            retrieveMap().put(id , updatedStudent);
        }
        return respond(updatedStudent);
    }

    @DeleteMapping("/{id}")
//    @CacheEvict(key = "#id")
    public Response<Void> delete(@PathVariable String id) {
        StudentDto dto = service.getById(id);
        if (dto != null){
            if(retrieveMap().get(id) != null){
                retrieveMap().remove(id);
            }
        }
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}
