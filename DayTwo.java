import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DayTwo {
    public static void main(String[] args) {
        String filePath = "dayTwo.txt";
        String str;
        String idString;
        int id = 0;
        int total = 0;
        int compare;
        boolean isValid;
        final int MAX_SIZE_RED = 12;
        final int MAX_SIZE_GREEN = 13;
        final int MAX_SIZE_BLUE = 14;
        HashMap<String, Integer> cubeCombos = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((str = reader.readLine()) != null) {
                isValid = true;
                String[] words = str.split(" ");

                idString = words[1];
                idString = idString.substring(0, (idString.indexOf(":")));
                id = Integer.valueOf(idString);

                for (int i = 2; i < words.length; i++) {
                    try{
                        compare = Integer.valueOf(words[i]);
                    if (i +1 < words.length) {
                        String key = words[i+1];
                    if ((cubeCombos.get(key) == null) || (cubeCombos.get(key)) < compare){
                        cubeCombos.put(key, compare);
                    }
                    i++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + words[i]);
                }
            }
                if ((cubeCombos.get("green") != null) && (cubeCombos.get("green") > MAX_SIZE_GREEN))
                    isValid = false;
                else if ((cubeCombos.get("blue") != null) && (cubeCombos.get("blue") > MAX_SIZE_BLUE))
                    isValid = false;

                else if ((cubeCombos.get("red") != null) && (cubeCombos.get("red")> MAX_SIZE_RED))
                    isValid = false;

                if (isValid)
                    total += id;
                System.out.println(cubeCombos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    System.out.println(total);
    }
}