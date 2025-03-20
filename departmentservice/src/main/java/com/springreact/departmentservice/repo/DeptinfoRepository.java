package com.springreact.departmentservice.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.springreact.departmentservice.entity.Deptinfo;

import reactor.core.publisher.Mono;

public interface DeptinfoRepository extends ReactiveCrudRepository<Deptinfo, Integer> {
	
	@Query("SELECT id,deptname,deptno FROM deptinfo WHERE deptno=:deptno")
	public Mono<Deptinfo> findAllByDeptno(Integer deptno);
}
