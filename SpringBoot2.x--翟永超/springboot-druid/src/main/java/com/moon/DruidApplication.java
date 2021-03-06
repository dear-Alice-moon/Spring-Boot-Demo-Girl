package com.moon;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class DruidApplication {

	public static void main(String[] args) {

		System.out.println("----------------- 程序实际运行测试见 DruidApplication 类 -----------------");

		SpringApplication.run(DruidApplication.class, args);
	}

}
