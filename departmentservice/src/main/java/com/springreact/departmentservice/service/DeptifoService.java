package com.springreact.departmentservice.service;

import com.springreact.departmentservice.entity.Deptinfo;

import reactor.core.publisher.Mono;

public interface DeptifoService {
	
	public Mono<Deptinfo> getDeptByDeptno(Integer deptno);
}
