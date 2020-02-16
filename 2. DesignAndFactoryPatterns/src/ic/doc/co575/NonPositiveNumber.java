package ic.doc.co575;

public class NonPositiveNumber extends InvalidNaturalNumber {
    @Override
    public String toString() {
        System.out.println("An error occurred due to subtraction");
        return super.toString();
    }
}
