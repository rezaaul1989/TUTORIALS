package com.springreact.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.departmentservice.entity.Deptinfo;
import com.springreact.departmentservice.repo.DeptinfoRepository;

import reactor.core.publisher.Mono;

@Service
public class DeptifoServiceImpl implements DeptifoService {
	
	@Autowired
	private DeptinfoRepository deptRepo;

	@Override
	public Mono<Deptinfo> getDeptByDeptno(Integer deptno) {
		return deptRepo.findAllByDeptno(deptno);
	}

}
