package com.springreact.studentinformationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springreact.studentinformationservice.models.Deptinfo;

import reactor.core.publisher.Mono;

@Service
public class DeptInfoService {
	
	@Autowired
	WebClient.Builder webClient;
	
	@Autowired
	Environment env;
	
	public Mono<Deptinfo> findAllDeptByDeptNo(Integer deptno){
		return webClient.build()
				.get()
				.uri(env.getProperty("deptinfo.getdeptbydeptno", "")+"/"+deptno)
				.header(HttpHeaders.CONTENT_TYPE, "application/json")
				.retrieve()
				.bodyToMono(Deptinfo.class);
	}

}
