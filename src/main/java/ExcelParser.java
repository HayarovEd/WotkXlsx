


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ExcelParser {

    public static void parse(String fileName, ArrayList<Content> file) {

        InputStream inputStream;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        int countRow = 0;
        while (it.hasNext()) {
            Row row = it.next();
            countRow++;
        }
        for (int i = 0; i < countRow; i++) {

            int tempId = (int) workBook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue();
            String tempName = workBook.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();
            String tempInn = workBook.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
            String tempKpp = workBook.getSheetAt(0).getRow(i).getCell(3).getStringCellValue();
            String tempRegnum = workBook.getSheetAt(0).getRow(i).getCell(4).getStringCellValue();
            String tempStatus = workBook.getSheetAt(0).getRow(i).getCell(5).getStringCellValue();
            String tempCateg = workBook.getSheetAt(0).getRow(i).getCell(6).getStringCellValue();
            String tempRegcod = workBook.getSheetAt(0).getRow(i).getCell(7).getStringCellValue();
            Date tempRegfns = workBook.getSheetAt(0).getRow(i).getCell(8).getDateCellValue();
            String tempUnregcod = workBook.getSheetAt(0).getRow(i).getCell(9).getStringCellValue();
            Date tempUnregfns = workBook.getSheetAt(0).getRow(i).getCell(10).getDateCellValue();
            int tempunZLSZVM = (int) workBook.getSheetAt(0).getRow(i).getCell(11).getNumericCellValue();
            int tempunZLRSV = (int) workBook.getSheetAt(0).getRow(i).getCell(12).getNumericCellValue();
            int tempunZLRSV0 = (int) workBook.getSheetAt(0).getRow(i).getCell(13).getNumericCellValue();
            file.add(i, new Content(tempId, tempName, tempInn, tempKpp, tempRegnum, tempStatus, tempCateg, tempRegcod,
                    tempRegfns, tempUnregcod, tempUnregfns, tempunZLSZVM, tempunZLRSV, tempunZLRSV0));
        }


    }

    public static void printToDisplay(ArrayList<Content> file) {
        for (Content temp : file) {
            System.out.println(temp.getId() + " " + temp.getName() + " " + temp.getInn() + " " + temp.getKpp() + " " + temp.getRegnum() + " " +
                    temp.getStatus() + " " + temp.getCateg() + " " + temp.getRegcod() + " " + temp.getRegfns() + " " + temp.getUnregcod() + " " +
                    temp.getUnrefns() + " " + temp.getUnZLSZVM() + " " + temp.getUnZLRSV() + " " + temp.getUnZLRSV0());
        }
    }
    public static void sravFiles(ArrayList<Content> file1, ArrayList<Content> file2 ,ArrayList<Content> fileout) {
        int count=0;
        for (Content tmp: file1) {
            for (Content currenttmp: file2) {
                if (tmp.getRegnum().equals(currenttmp.getRegnum())) {
                    fileout.add(count++,new Content(tmp.getId(), tmp.getName(),tmp.getInn(), tmp.getKpp(), tmp.getRegnum(),
                            tmp.getStatus(), tmp.getCateg(), tmp.getRegcod(), tmp.getRegfns(), tmp.getUnregcod(), tmp.getUnrefns(),
                            Math.abs(tmp.getUnZLSZVM()-currenttmp.getUnZLSZVM()),
                            Math.abs(tmp.getUnZLRSV()-currenttmp.getUnZLRSV()),
                            Math.abs(tmp.getUnZLRSV0()-currenttmp.getUnZLRSV0())));

                }
            }
        }
        fileout.removeIf(tmp -> tmp.getUnZLSZVM() == 0 && tmp.getUnZLRSV() == 0 && tmp.getUnZLRSV0() == 0);
    }
    public static void writeToFile(ArrayList<Content> outFile) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("лист1");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("№ п/п");
        row.createCell(1).setCellValue("Наименование плательщика");
        row.createCell(2).setCellValue("ИНН плательщика");
        row.createCell(3).setCellValue("КПП плательщика");
        row.createCell(4).setCellValue("Регистрационный номер плательщика СВ");
        row.createCell(5).setCellValue("Статус плательщика");
        row.createCell(6).setCellValue("Категория плательщика");
        row.createCell(7).setCellValue("Код постановки на учет");
        row.createCell(8).setCellValue("Дата постановки на учет в ИФНС");
        row.createCell(9).setCellValue("Код снятия с учета");
        row.createCell(10).setCellValue("Дата снятия с учета в ИФНС");
        row.createCell(11).setCellValue("Количество уникальных ИЛС ЗЛ, актуализированных сведениями о работе из отчетности по форме СЗВ-М");
        row.createCell(12).setCellValue("Всего РСВ");
        row.createCell(13).setCellValue("В том числе, нулевые");
        for (Content tmp : outFile) {
            createSheetHeader(sheet, ++rowNum, tmp);
        }
        try (FileOutputStream out = new FileOutputStream(new File("fileout.xlsx"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");



    }
    private static void createSheetHeader(XSSFSheet sheet, int rowNum, Content outFile) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(outFile.getId());
        row.createCell(1).setCellValue(outFile.getName());
        row.createCell(2).setCellValue(outFile.getInn());
        row.createCell(3).setCellValue(outFile.getKpp());
        row.createCell(4).setCellValue(outFile.getRegnum());
        row.createCell(5).setCellValue(outFile.getStatus());
        row.createCell(6).setCellValue(outFile.getCateg());
        row.createCell(7).setCellValue(outFile.getRegcod());
        //row.createCell(8).setCellValue(outFile.getRegfns());
        row.createCell(9).setCellValue(outFile.getUnregcod());
        //row.createCell(10).setCellValue(outFile.getUnrefns());
        row.createCell(11).setCellValue(outFile.getUnZLSZVM());
        row.createCell(12).setCellValue(outFile.getUnZLRSV());
        row.createCell(13).setCellValue(outFile.getUnZLRSV0());
    }
}
