package com.springreact.studentinformationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.studentinformationservice.helper.StudentInformationServiceHelper;
import com.springreact.studentinformationservice.models.Deptinfo;
import com.springreact.studentinformationservice.models.Studentinfo;
import com.springreact.studentinformationservice.responses.StudentInformationResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentInformationServiceImpl implements StudentInformationService {
	
	@Autowired
	private StudentInfoService studentServ;
	
	@Autowired
	private DeptInfoService deptService;
	
	@Autowired
	private StudentInformationServiceHelper helper;	

	@Override
	public Mono<StudentInformationResponse> getStudentDeptInfoByDeptName(Integer deptno) {
		
		//Calling http://localhost:8081/studentinfo/findListOfStudentsByDeptNo to get the student info by dept #
		Mono<List<Studentinfo>> studentsList = studentServ.getStudentsByDeptno(deptno);
		
		//Calling http://localhost:8082/deptinfo/getdeptbydeptno to get the department info by dept #
		Mono<Deptinfo> deptMono = deptService.findAllDeptByDeptNo(deptno);
		
		return Mono.zip(studentsList, deptMono).flatMap(tuple->{
			List<Studentinfo> stdList = tuple.getT1();
			Deptinfo dept = tuple.getT2();
			//Combining the two API responses into final response.
			return helper.combineResponses(stdList, dept);
		});
	}

}
