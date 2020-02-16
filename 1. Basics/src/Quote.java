public class Quote {
    private String quote;
    private String attribute;

    Quote(String input) {
        String[] split = input.split(";");
        quote = split[0];
        attribute = split[1];
    }

    @Override
    public String toString() {
        return "'" + quote + "' by " + attribute;
    }

    public String getText() {
        return quote;
    }

    public String getComment() {
        return attribute;
    }
}
