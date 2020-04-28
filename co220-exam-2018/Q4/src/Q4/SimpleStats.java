package Q4;

import java.awt.*;
import javax.swing.*;

public class SimpleStats implements Updatable {

  JTextField currentMax = new JTextField(11);
  JTextField currentMean = new JTextField(11);

  // view
  private void display() {
    JFrame frame = new JFrame("Simple Stats");
    frame.setSize(250, 350);
    Panel panel = new Panel();
    panel.add(new JLabel("Max: value "));
    panel.add(currentMax);
    panel.add(new JLabel("Mean: value "));
    panel.add(currentMean);

    ArithmeticEngine calc = new ArithmeticEngine();
    calc.addObserver(this);

    for (int i = 1; i <= 12; i++) {
      final int n = i;
      JButton button = new JButton(String.valueOf(i));
      button.addActionListener(
          e -> {
            calc.apply(n);
          });
      panel.add(button);
    }
    frame.getContentPane().add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  //controller
  @Override
  public void updateWith(int max, double mean) {
    currentMax.setText(String.valueOf(max));
    currentMean.setText(String.valueOf(mean));
  }

  public static void main(String[] args) {
    new SimpleStats().display();
  }
}
