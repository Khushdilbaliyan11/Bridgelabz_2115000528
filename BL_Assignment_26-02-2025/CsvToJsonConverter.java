import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CsvToJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String csvFilePath = "input.csv";  
        String jsonFilePath = "output.json"; 
        convertCsvToJson(csvFilePath, jsonFilePath);
    }

    private static void convertCsvToJson(String csvFilePath, String jsonFilePath) throws Exception {
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> allRows = csvReader.readAll();
            if (allRows.isEmpty()) {
                System.out.println("CSV file is empty.");
                return;
            }

            String[] headers = allRows.get(0);
            ArrayNode jsonArray = objectMapper.createArrayNode();

            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }
                jsonArray.add(jsonObject);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), jsonArray);
            System.out.println("Converted JSON Content:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
        }
    }
}
