package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticEngineTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    Updatable display = context.mock(Updatable.class);

    @Test
    public void updateDisplayWhenANewNumberIsInput(){
        ArithmeticEngine arithmeticEngine = new ArithmeticEngine();
        arithmeticEngine.addObserver(display);

        context.checking(new Expectations(){{
            exactly(1).of(display).updateWith(5);
        }});

        arithmeticEngine.input(5);
    }

    @Test
    public void supportAddingTwoValues(){
        ArithmeticEngine arithmeticEngine = new ArithmeticEngine();
        arithmeticEngine.addObserver(display);

        context.checking(new Expectations(){{
            allowing(display).updateWith(5);
            allowing(display).updateWith(3);
            exactly(1).of(display).updateWith(8);
        }});

        arithmeticEngine.input(5);
        arithmeticEngine.input(3);
        arithmeticEngine.apply(Operator.PLUS);
    }

    @Test
    public void supportSubtractingTwoValues(){
        ArithmeticEngine arithmeticEngine = new ArithmeticEngine();
        arithmeticEngine.addObserver(display);

        context.checking(new Expectations(){{
            allowing(display).updateWith(5);
            allowing(display).updateWith(3);
            exactly(1).of(display).updateWith(2);
        }});

        arithmeticEngine.input(5);
        arithmeticEngine.input(3);
        arithmeticEngine.apply(Operator.MINUS);
    }

}