public class SecondHighest2D {

import java.util.*;

    public class HighestAverageScore {
        public static void main(String[] args) {
            String[][] input = {
                    {"Alice", "90"},
                    {"Bob", "85"},
                    {"Alice", "95"},
                    {"Charlie", "78"},
                    {"Bob", "80"},
                    {"Charlie", "82"}
            };

            // Map to store total scores and count for each student
            Map<String, int[]> studentScores = new HashMap<>();

            for (String[] record : input) {
                String name = record[0];
                int score = Integer.parseInt(record[1]);

                // If the student is not yet in the map, add them
                studentScores.putIfAbsent(name, new int[2]);  // [total, count]
                studentScores.get(name)[0] += score;          // total
                studentScores.get(name)[1] += 1;              // count
            }

            String topStudent = "";
            int highestAvg = 0;

            // Find the highest average
            for (Map.Entry<String, int[]> entry : studentScores.entrySet()) {
                int total = entry.getValue()[0];
                int count = entry.getValue()[1];
                int avg = total / count; // Automatically rounds down

                if (avg > highestAvg) {
                    highestAvg = avg;
                    topStudent = entry.getKey();
                }
            }

            System.out.println("Top student average: " + highestAvg);
        }
    }

}
