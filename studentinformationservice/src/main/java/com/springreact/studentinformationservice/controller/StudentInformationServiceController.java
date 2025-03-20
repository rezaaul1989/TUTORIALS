package com.springreact.studentinformationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.studentinformationservice.responses.StudentInformationResponse;
import com.springreact.studentinformationservice.service.StudentInformationServiceImpl;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/studentinformationservice")
public class StudentInformationServiceController {
	
	@Autowired
	private StudentInformationServiceImpl service;
	
	@GetMapping("/getStudentInfoByDept/{deptno}")
	public Mono<StudentInformationResponse> getStudentInfoByDept(@PathVariable("deptno") Integer deptno){
		return service.getStudentDeptInfoByDeptName(deptno);
	}

}
