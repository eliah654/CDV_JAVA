package tools;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.*;


public class CSVReader {

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

    @DataProvider(name="testData1")
    public static Object[][] testDataCSV() throws IOException {
        String[][] testDataFromF;
        CSVReader file = new CSVReader();
        testDataFromF = file.CSVReaderFromFile("src/test/java/data/DDT_data.csv");
        int rows = testDataFromF.length;
        System.out.println(rows);
        Object[][]testDataS = new Object[rows][7];
        for(int i=0;i<rows-1; i++) {
            System.arraycopy(testDataFromF[i], 0, testDataS[i], 0, 7);

        }
        return testDataS;
    }

}
