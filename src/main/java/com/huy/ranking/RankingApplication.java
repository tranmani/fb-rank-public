package com.huy.ranking;

import com.huy.ranking.controller.FinalListToUse;
import com.huy.ranking.model.ContributorDataProvider;
import com.huy.ranking.model.InteractDataProvider;
import com.huy.ranking.model.PostDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RankingApplication {
    public static String FILE_NAME = "insight.xlsx";
//    public static String FILE_NAME2 = "insight2.xlsx";

    public static void main(String[] args) {
        ExcelReader.readExcel(FILE_NAME);
        FinalListToUse haiAnhPheCan = new FinalListToUse(ContributorDataProvider.getContributor(), PostDataProvider.getPosts(), InteractDataProvider.getInteracts(), ExcelReader.getMember());
        FinalListToUse.setHaiAnhPheCan(haiAnhPheCan);

//        ExcelReader.readExcel(FILE_NAME2);
//        FinalListToUse backyardOfHeaven = new FinalListToUse(ContributorDataProvider.getContributor(), PostDataProvider.getPosts(), InteractDataProvider.getInteracts(), ExcelReader.getMember());
//        FinalListToUse.setBackyardOfHeaven(backyardOfHeaven);

        SpringApplication.run(RankingApplication.class, args);
    }
}