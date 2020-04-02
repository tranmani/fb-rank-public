package com.huy.ranking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RankingApplication {

    public static void main(String[] args) {
        ExcelReader.readExcel();
        SpringApplication.run(RankingApplication.class, args);
    }
}