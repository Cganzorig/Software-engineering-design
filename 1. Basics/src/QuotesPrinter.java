import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuotesPrinter {

  static final String quotesFile = "C:/Users/Ganzorig/Desktop/Software Engineering/575_exercise1_gc18/Quotes.txt";

  public static void main(String[] args) throws Exception {

    // read the file Quotes.txt using a BufferedReader
    FileReader fileReader = new FileReader(quotesFile);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    // reformat the file
    reformat(bufferedReader);
  }

  public static void reformat(BufferedReader input) throws IOException {

    String line = input.readLine();

    while(line != null) {
      String[] split = line.split(";");
      System.out.println(split[0]);
      System.out.println(split[1]);

      line = input.readLine();
    }
  }
}
