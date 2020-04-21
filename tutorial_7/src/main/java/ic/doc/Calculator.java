package ic.doc;

import java.util.EnumSet;
import java.util.stream.IntStream;
import javax.swing.*;

public class Calculator implements Updatable {
  JTextField output = new JTextField(10);

  // view
  private void display() {

    JFrame frame = new JFrame("Calculator");
    ArithmeticEngine calc = new ArithmeticEngine();
    calc.addObserver(this);

    frame.setSize(450, 300);
    frame.setVisible(true);

    JPanel panel = new JPanel();

    addNumberButtons(calc, panel);
    addOperatorButtons(calc, panel);

    panel.add(output);
    frame.getContentPane().add(panel);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void updateWith(int value) {
    output.setText(String.valueOf(value));
  }
  // controller

  private void addOperatorButtons(ArithmeticEngine calc, JPanel panel) {
    EnumSet.allOf(Operator.class)
        .forEach(
            op -> {
              JButton button = new JButton(op.label());
              button.addActionListener(e -> calc.apply(op));
              panel.add(button);
            });
  }

  private void addNumberButtons(ArithmeticEngine calc, JPanel panel) {
    IntStream.range(1, 5)
        .forEach(
            n -> {
              JButton button = new JButton(String.valueOf(n));
              button.addActionListener(e -> calc.input(n));
              panel.add(button);
            });
  }

  public static void main(String[] args) {
    new Calculator().display();
  }
}
