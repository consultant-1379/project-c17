package com.project.csvconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ConverterApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(ConverterApplication.class, args);

		CsvConverter converter = context.getBean(CsvConverter.class);
		converter.setName("info_1.csv");
		converter.init();
		//converter.printAllCommits();
		Thread converterThread = new Thread(converter);

		converterThread.start();
	}

}
