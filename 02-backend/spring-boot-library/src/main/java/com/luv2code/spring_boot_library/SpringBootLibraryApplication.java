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

		/**
		 * exmam thing
		 *
		String date = LocalDate.parse("2014-05-04")
				.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(date);

		Short s1 = 200;
		Integer s2 = 400;
		Long s3 = (long) s1 + s2;
		String s4 = (String) (s3 * s2);
		System.out.println("Sum is " + s4);

		abstract class Planet {
			protected void revolve() {
			}

			abstract void rotate();
		}

		class Earth extends Planet {
			void revolve() {
			}

			protected void rotate() {
			}
		}
		 **/
	}

}
