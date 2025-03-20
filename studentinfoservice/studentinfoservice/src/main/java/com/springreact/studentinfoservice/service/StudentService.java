package com.springreact.studentinfoservice.service;

import java.util.List;

import com.springreact.studentinfoservice.entity.Studentinfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
	
	public Flux<Studentinfo> getAllStudents();
	
	public Mono<Studentinfo> getStudentById(Integer id);
	
	public Mono<Studentinfo> getStudentByRoll(Integer roll);
	
	public Flux<Studentinfo> getStudentsByDeptNo(Integer deptno);
	
	public Mono<List<Studentinfo>> getListOfStudentsByDeptNo(Integer deptno);
	
	public Mono<Studentinfo> save(Studentinfo std);
	
	public Mono<Void> delete(Integer roll);
	
	public Mono<Studentinfo> edit(Studentinfo std); 
	
	public Flux<Studentinfo> getStudentsByDeptNumber(Integer deptno);

}
