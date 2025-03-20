package com.springreact.studentinformationservice.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springreact.studentinformationservice.models.Deptinfo;
import com.springreact.studentinformationservice.models.Studentinfo;
import com.springreact.studentinformationservice.responses.StudentInformationResponse;

import reactor.core.publisher.Mono;

@Component
public class StudentInformationServiceHelper {
	
	public Mono<StudentInformationResponse> combineResponses(List<Studentinfo> stdInfoList, Deptinfo dept){
		StudentInformationResponse stdInfoResp = new StudentInformationResponse();
		stdInfoResp.setDeptname(dept.getDeptname());
		stdInfoResp.setDeptno(dept.getDeptno());
		stdInfoResp.setStudentinfo(stdInfoList);		
		return Mono.just(stdInfoResp);		
	}

}
