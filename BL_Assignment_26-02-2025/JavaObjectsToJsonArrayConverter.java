import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Player {
    private String name;
    private String team;
    private int runs;

    public Player(String name, String team, int runs) {
        this.name = name;
        this.team = team;
        this.runs = runs;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getRuns() {
        return runs;
    }
}

public class JavaObjectsToJsonArrayConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Virat Kohli", "Royal Challengers Bangalore", 75));
        players.add(new Player("MS Dhoni", "Chennai Super Kings", 50));
        players.add(new Player("Rohit Sharma", "Mumbai Indians", 65));

        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(players);
        System.out.println(jsonArray);
    }
}