package com.luv2code.spring_boot_library;

import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SpringBootLibraryApplication {

	public static void main(String[] args) {

	SpringApplication.run(SpringBootLibraryApplication.class, args);

	}

}
