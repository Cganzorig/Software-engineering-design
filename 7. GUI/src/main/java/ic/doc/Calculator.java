package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;
import java.util.stream.IntStream;

public class Calculator implements Updatable {
    private final JTextField output = new JTextField();

    // view

    private void display() {

        JFrame jFrame = new JFrame("Calculator");
        ArithmeticEngine calc = new ArithmeticEngine();

        calc.addObserver(this);

        jFrame.setSize(400, 400);

        JPanel panel = new JPanel();

        addNumberButtons(calc, panel);
        addOperatorButtons(calc, panel);
        panel.add(output);


        jFrame.getContentPane().add(panel);

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void updateWith(int i) {
        output.setText(String.valueOf(i));
    }

    // controller

    private void addOperatorButtons(ArithmeticEngine calc, JPanel panel) {
        EnumSet.allOf(Operator.class).forEach(op-> {
            JButton button = new JButton(op.label());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calc.apply(op);
                }
            });
            panel.add(button);
        });
    }

    private void addNumberButtons(ArithmeticEngine calc, JPanel panel) {
        IntStream.range(1, 5).forEach(n-> {
            JButton button = new JButton(String.valueOf(n));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calc.input(n);
                }
            });
            panel.add(button);
        });
    }

    public static void main(String[] args) {
        new Calculator().display();

    }
}


