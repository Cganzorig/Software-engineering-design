import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PickYourQuote {

    public static void main(String[] args) throws Exception {
        String quotesFile = args[0];
        int index = Integer.parseInt(args[1]);

        // read the file Quotes.txt using a BufferedReader
        FileReader f = new FileReader(quotesFile);
        BufferedReader quoteReader = new BufferedReader(f);

        // reformat the file
        reformat(index, quoteReader);

    }

    public static void reformat(int i, BufferedReader in) throws IOException {
        String line = in.readLine();
        int count = 0;

        while(line != null) {
            if(count == i - 1) {
                String[] split = line.split(";");
                System.out.println(split[0] + split[1]);
                return;
            } else {
                line = in.readLine();
                count++;
            }
        }
    }
}
