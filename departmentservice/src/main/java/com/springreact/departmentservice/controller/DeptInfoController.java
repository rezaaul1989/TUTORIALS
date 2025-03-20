package com.springreact.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.departmentservice.entity.Deptinfo;
import com.springreact.departmentservice.service.DeptifoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/deptinfo")
public class DeptInfoController {
	
	@Autowired
	private DeptifoService deptService;
	
	@GetMapping(value = "/getdeptbydeptno/{deptno}")
	public Mono<Deptinfo> getdeptbydeptno(@PathVariable("deptno") Integer deptno){
		return deptService.getDeptByDeptno(deptno).log();
	}

}
