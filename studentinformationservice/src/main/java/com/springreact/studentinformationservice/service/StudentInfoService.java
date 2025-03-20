package com.springreact.studentinformationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springreact.studentinformationservice.models.Studentinfo;

import reactor.core.publisher.Mono;

@Service
public class StudentInfoService {
	
	@Autowired
	WebClient.Builder webClient;
	
	@Autowired
	Environment env;
	
	public Mono<List<Studentinfo>> getStudentsByDeptno(Integer deptno){
		return webClient.build()
			.get()
			.uri(env.getProperty("studentinfo.getListOfStudentsByDeptNo", "")+"/"+deptno)
			.header(HttpHeaders.CONTENT_TYPE, "application/json")
			.retrieve()
			.bodyToMono(new ParameterizedTypeReference <List<Studentinfo>>() {});
	}
}
