import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseToJsonReportGenerator {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String jsonFilePath = "database_report.json"; 
        generateJsonReportFromDatabase(jsonFilePath);
    }

    private static void generateJsonReportFromDatabase(String jsonFilePath) throws Exception {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ipl_db"; 
        String username = "root"; 
        String password = "password"; 
        String query = "SELECT match_id, team1, team2, score_team1, score_team2, winner, player_of_match FROM ipl_matches";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            ArrayNode jsonArray = objectMapper.createArrayNode();

            while (resultSet.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("match_id", resultSet.getInt("match_id"));
                jsonObject.put("team1", resultSet.getString("team1"));
                jsonObject.put("team2", resultSet.getString("team2"));
                jsonObject.put("score_team1", resultSet.getInt("score_team1"));
                jsonObject.put("score_team2", resultSet.getInt("score_team2"));
                jsonObject.put("winner", resultSet.getString("winner"));
                jsonObject.put("player_of_match", resultSet.getString("player_of_match"));
                jsonArray.add(jsonObject);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), jsonArray);
            System.out.println("Generated JSON Report:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
        }
    }
}
