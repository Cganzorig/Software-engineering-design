import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class PickManyQuotes {

  public static void main(String[] args) throws Exception {

    // Use file name and quote numbers in args
      FileReader f = new FileReader(args[0]);
      BufferedReader quoteReader = new BufferedReader(f);

      int[] num_parameters = new int [args.length - 1];

      for(int i = 1; i < args.length; i++) {
          num_parameters[i - 1] = Integer.parseInt(args[i]) - 1;
      }
    // to first create a list of quotes using loadQuotes
      List<Quote> quotes = loadQuotes(quoteReader);
    // and then print to System.out the chosen quotes.
      reformat(quotes, num_parameters);
 }

  public static void reformat(List<Quote> quotes, int[] choices) {
    // Print to System.out quotes according to choices.
      for(int i = 0; i < choices.length ; i++) {
          System.out.println(quotes.get(choices[i]).toString());
      }
  }

  public static List<Quote> loadQuotes(BufferedReader in) throws IOException {
      List<Quote> quotes = new ArrayList<Quote>();

    // Read lines from the input
      String line = in.readLine();
      while(line != null) {
          // Create a Quote object for each line and store in list.
          Quote buffer = new Quote(line);
          quotes.add(buffer);

          line = in.readLine();
      }

    return quotes;
  }

}

