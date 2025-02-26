import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;
}

public class IPLCensorAnalyzer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String jsonInputPath = "ipl_matches.json";
        String jsonOutputPath = "ipl_matches_censored.json";
        String csvInputPath = "ipl_matches.csv";
        String csvOutputPath = "ipl_matches_censored.csv";

        List<IPLMatch> matches = readJson(jsonInputPath);
        applyCensorship(matches);
        writeJson(matches, jsonOutputPath);

        List<String[]> csvData = readCsv(csvInputPath);
        List<String[]> censoredCsvData = applyCensorshipToCsv(csvData);
        writeCsv(censoredCsvData, csvOutputPath);

        System.out.println("Censorship applied successfully.");
    }

    private static List<IPLMatch> readJson(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<IPLMatch>>() {});
    }

    private static void writeJson(List<IPLMatch> matches, String filePath) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }

    private static List<String[]> readCsv(String filePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll();
        }
    }

    private static void writeCsv(List<String[]> data, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(data);
        }
    }

    private static void applyCensorship(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.team1 = censorTeamName(match.team1);
            match.team2 = censorTeamName(match.team2);
            match.winner = censorTeamName(match.winner);
            match.player_of_match = "REDACTED";

            Map<String, Integer> censoredScore = new HashMap<>();
            for (Map.Entry<String, Integer> entry : match.score.entrySet()) {
                censoredScore.put(censorTeamName(entry.getKey()), entry.getValue());
            }
            match.score = censoredScore;
        }
    }

    private static List<String[]> applyCensorshipToCsv(List<String[]> csvData) {
        List<String[]> result = new ArrayList<>();
        result.add(csvData.get(0));

        for (int i = 1; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            row[1] = censorTeamName(row[1]);
            row[2] = censorTeamName(row[2]);
            row[5] = censorTeamName(row[5]);
            row[6] = "REDACTED";
            result.add(row);
        }
        return result;
    }

    private static String censorTeamName(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            parts[parts.length - 1] = "***";
            return String.join(" ", parts);
        }
        return "***";
    }
}
