package com.huy.ranking;

import com.huy.ranking.model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader {
    private static double memberInteract = 0;

    public static void readExcel(String FILE_NAME) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet contributorSheet = workbook.getSheetAt(7);
            XSSFSheet interactSheet = workbook.getSheetAt(0);
            XSSFSheet postSheet = workbook.getSheetAt(3);
            DataFormatter dataFormatter = new DataFormatter();

            ContributorDataProvider.clearList();
            PostDataProvider.clearList();
            InteractDataProvider.clearList();

            //Iterate interaction sheet
            Iterator<Row> interactRow = interactSheet.rowIterator();
            while (interactRow.hasNext()) {
                Row currentInteractRow = interactRow.next();
                double post = 0;
                double comment = 0;
                double reaction = 0;

                if (currentInteractRow.getCell(5).getCellTypeEnum() == CellType.NUMERIC) {
                    post = (int) currentInteractRow.getCell(5).getNumericCellValue();
                }
                if (currentInteractRow.getCell(6).getCellTypeEnum() == CellType.NUMERIC) {
                    comment = (int) currentInteractRow.getCell(6).getNumericCellValue();
                }
                if (currentInteractRow.getCell(7).getCellTypeEnum() == CellType.NUMERIC) {
                    reaction = (int) currentInteractRow.getCell(7).getNumericCellValue();
                }
                if (interactSheet.getRow(27).getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
                    memberInteract = (int) interactSheet.getRow(27).getCell(1).getNumericCellValue();
                }

                Interact interact = new Interact(post, comment, reaction);
                InteractDataProvider.addInteractionToBeSum(interact);
            }
            InteractDataProvider.sumAllInteract();

            //Iterate post sheet
            Iterator<Row> postRow = postSheet.rowIterator();
            while (postRow.hasNext()) {
                Row currentPost = postRow.next();
                String member = null;
                String caption = null;
                double comment = 0;
                double reaction = 0;
                double view = 0;
                String link = null;

                caption = dataFormatter.formatCellValue(currentPost.getCell(0));
                if (caption.equals("")) {
                    caption = "Link";
                }
                if (currentPost.getCell(1).getCellTypeEnum() == CellType.STRING) {
                    member = currentPost.getCell(1).getStringCellValue();
                }
                if (currentPost.getCell(2).getCellTypeEnum() == CellType.NUMERIC) {
                    comment = (int) currentPost.getCell(2).getNumericCellValue();
                }
                if (currentPost.getCell(3).getCellTypeEnum() == CellType.NUMERIC) {
                    reaction = (int) currentPost.getCell(3).getNumericCellValue();
                }
                if (currentPost.getCell(4).getCellTypeEnum() == CellType.NUMERIC) {
                    view = (int) currentPost.getCell(4).getNumericCellValue();
                }
                if (currentPost.getCell(5).getCellTypeEnum() == CellType.STRING) {
                    link = currentPost.getCell(5).getStringCellValue();
                }
                Post post = new Post(member, caption, comment, reaction, view, link);
                PostDataProvider.addPostToBeSorted(post);
            }
            PostDataProvider.addPost();

            //Iterate contributor sheet
            Iterator<Row> contributorRow = contributorSheet.rowIterator();
            while (contributorRow.hasNext()) {
                Row currentContributorRow = contributorRow.next();
                String name = null;
                double post = 0;
                double comment = 0;

                if (currentContributorRow.getCell(0).getCellTypeEnum() == CellType.STRING) {
                    name = currentContributorRow.getCell(0).getStringCellValue();
                }
                if (currentContributorRow.getCell(1).getCellTypeEnum() == CellType.NUMERIC) {
                    post = (int) currentContributorRow.getCell(1).getNumericCellValue();
                }
                if (currentContributorRow.getCell(2).getCellTypeEnum() == CellType.NUMERIC) {
                    comment = (int) currentContributorRow.getCell(2).getNumericCellValue();
                }
                ContributorDataProvider.addContributorsToBeSort(name, post, comment);
            }
            ContributorDataProvider.addContributor();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getMember() {
        return memberInteract;
    }
}
