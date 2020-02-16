package ic.doc.co575;

public class NonWholeNumber extends InvalidNaturalNumber{
    @Override
    public String toString() {
        System.out.println("An error occurred due to division");
        return super.toString();
    }
}
