package tools;
import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.*;


public class CSVReaderFF {

    public String[][] CSVReaderFromFile(String filePath) throws IOException {
        int i = 0;
        String[][] zwrotka = new String[6][20];

        Reader file = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(file);
                //CSVFormat.RFC4180.withHeader("godzinka", "dzien", "wyjazd", "przyjazd", "pociag", "numer", "ifnazwa").parse(file);

        for (CSVRecord record : records) {

            for (int j = 0; j < record.size(); j++) {
                zwrotka[i][j] = record.get(j);
            }
            i++;
        }

        return zwrotka;
    }

    public String[][] CsvReaderFF(String filePath) throws FileNotFoundException {
        String [][] test = new String[5][20];
        CSVReader reader = new CSVReader(new FileReader(filePath));
        String [] nextLine;

        return test;
    }

    @DataProvider(name="testData1")
    public static Object[][] testDataCSV() throws IOException {
        String[][] testDataFromF;
        CSVReaderFF file = new CSVReaderFF();
        testDataFromF = file.CSVReaderFromFile("src/test/java/data/DDT_data.csv");
        int rows = testDataFromF.length;
        Object[][]testDataS = new Object[rows][7];
        for(int i=0;i<rows-1; i++) {
            System.arraycopy(testDataFromF[i], 0, testDataS[i], 0, 7);

        }
        return testDataS;
    }

    @DataProvider(name="testData2")
    public static Object[][] testDataCSV2() throws IOException {
        String[][] testDataFromF;
        CSVReaderFF file = new CSVReaderFF();
        testDataFromF = file.CSVReaderFromFile("src/test/java/data/DDT_data2.csv");
        int rows = testDataFromF.length;
        Object[][]testDataS = new Object[rows][20];
        for(int i=0;i<rows-1; i++) {
            System.arraycopy(testDataFromF[i], 0, testDataS[i], 0, 20);

        }

        return testDataFromF;
    }

    @DataProvider(name="testData3")
    public static Object[][] testDataCSV3() throws IOException {
        String[][] testDataFromF;
        CSVReaderFF file = new CSVReaderFF();
        testDataFromF = file.CSVReaderFromFile("src/test/java/data/DDT_data3.csv");
        int rows = testDataFromF.length;
        Object[][]testDataS = new Object[rows][4];
        for(int i=0;i<rows-1; i++) {
            System.arraycopy(testDataFromF[i], 0, testDataS[i], 0, 4);

        }
        return testDataS;
    }
}
