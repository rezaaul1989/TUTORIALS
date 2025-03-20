package com.springreact.studentinformationservice.service;

import com.springreact.studentinformationservice.responses.StudentInformationResponse;

import reactor.core.publisher.Mono;

public interface StudentInformationService {
	public Mono<StudentInformationResponse>  getStudentDeptInfoByDeptName(Integer deptno);
}
