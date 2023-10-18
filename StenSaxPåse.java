package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StenSaxPåse extends JFrame {

  // Olika klasser som går ihop med de olika knapparna
  private JButton rockButton;
  private JButton paperButton;
  private JButton scissorsButton;
  private JLabel resultLabel;

  // Utgör titeln av programmet
  public StenSaxPåse() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Rock, Paper, Scissors");
    // Placering av popup skärmen som dyker upp
    setLocationRelativeTo(null);
    // Storlek på popup skärmen
    setSize(800, 400);

    // Text i de olika knapparna
    rockButton = new JButton("Rock");
    paperButton = new JButton("Paper");
    scissorsButton = new JButton("Scissors");
    resultLabel = new JLabel("");

    // Knappar
    setLayout(new FlowLayout());
    add(rockButton);
    add(paperButton);
    add(scissorsButton);
    add(resultLabel);

    // Actionlistener används för att ta emot vad användaren klickar på för knapp så
    // utgörs en händelse, i detta fall val av sten, sax, påse för användaren.
    rockButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        playGame("rock");
      }
    });

    paperButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        playGame("paper");
      }
    });

    scissorsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        playGame("scissors");
      }
    });
  }

  // Slumpar datorns val av sten, sax, påse vid varje spel
  private void playGame(String userChoice) {
    String[] choices = { "rock", "paper", "scissors" };
    Random random = new Random();
    int computerIndex = random.nextInt(choices.length);
    String computerChoice = choices[computerIndex];

    String result;
    // Programmet skriver ut att användaren vann, förlora eller jämt utifrån
    // användarens inmatning med jämförelse av vad datorn hade valt av sten, sax
    // påse
    if (userChoice.equals(computerChoice)) {
      result = "It's a tie!";
    } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
        (userChoice.equals("paper") && computerChoice.equals("rock")) ||
        (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
      result = "You win!";
    } else {
      result = "You lost!";
    }

    // Skrivet ut inmatning från användaren jämförs med datorns val
    resultLabel.setText("You chose " + userChoice + ", Computer chose " + computerChoice + ". " + result);

  }

  // Startar programmet i main med popup på spelet
  // Setvisible måste vara på true annars poppar programmet inte upp om den är på
  // false
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new StenSaxPåse().setVisible(true);
      }
    });
  }
}