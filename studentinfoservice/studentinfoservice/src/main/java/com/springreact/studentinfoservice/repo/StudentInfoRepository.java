package com.springreact.studentinfoservice.repo;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.springreact.studentinfoservice.entity.Studentinfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentInfoRepository extends ReactiveCrudRepository<Studentinfo, Integer>{
	Mono<Studentinfo> findAllByRoll(Integer roll);
	Flux<Studentinfo> findAllByDeptno(Integer deptno);
	
	@Modifying
	@Query("insert into studentinfo(id,fname,lname,age,deptno,roll) values (:#{#std.id}, :#{#std.fname}, :#{#std.lname}, :#{#std.age}, :#{#std.deptno}, :#{#std.roll}) on conflict DO NOTHING")
	Mono<Studentinfo> saveStudent(Studentinfo std);
	
	@Query("SELECT id,fname,lname,age,deptno,roll FROM studentinfo WHERE deptno=:deptno")
	Flux<Studentinfo> findAllByDeptNumber(Integer deptno);
}
