
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MainField extends JPanel {
    boolean krest = true;
    boolean nulik;
    boolean[] nazim = new boolean[9];
    String winnerX = "";
    String winnerY = "";
    static String win;
    static MainField g;
    static JFrame frame;
    private JButton squares[][];


    private String checkWinnerCheck() {
        if (winnerX.length() >= 3) {
            if (winnerX.contains("1") && winnerX.contains("2") && winnerX.contains("3")) return "Выйграл крестик";
            else if (winnerX.contains("1") && winnerX.contains("4") && winnerX.contains("7")) return "Выйграл крестик";
            else if (winnerX.contains("4") && winnerX.contains("5") && winnerX.contains("6")) return "Выйграл крестик";
            else if (winnerX.contains("9") && winnerX.contains("8") && winnerX.contains("7")) return "Выйграл крестик";
            else if (winnerX.contains("2") && winnerX.contains("5") && winnerX.contains("8")) return "Выйграл крестик";
            else if (winnerX.contains("3") && winnerX.contains("6") && winnerX.contains("9")) return "Выйграл крестик";
            else if (winnerX.contains("1") && winnerX.contains("5") && winnerX.contains("9")) return "Выйграл крестик";
            else if (winnerX.contains("7") && winnerX.contains("5") && winnerX.contains("3")) return "Выйграл крестик";
        }
        if (winnerY.length() >= 3) {
            if (winnerY.contains("1") && winnerY.contains("2") && winnerY.contains("3")) return "Выйграл нолик";
            else if (winnerY.contains("1") && winnerY.contains("4") && winnerY.contains("7")) return "Выйграл нолик";
            else if (winnerY.contains("4") && winnerY.contains("5") && winnerY.contains("6")) return "Выйграл нолик";
            else if (winnerY.contains("9") && winnerY.contains("8") && winnerY.contains("7")) return "Выйграл нолик";
            else if (winnerY.contains("2") && winnerY.contains("5") && winnerY.contains("8")) return "Выйграл нолик";
            else if (winnerY.contains("3") && winnerY.contains("6") && winnerY.contains("9")) return "Выйграл нолик";
            else if (winnerY.contains("1") && winnerY.contains("5") && winnerY.contains("9")) return "Выйграл нолик";
            else if (winnerY.contains("7") && winnerY.contains("5") && winnerY.contains("3")) return "Выйграл нолик";
        }
        return "a";
    }

    public static void main(String[] args) {
        g = new MainField();
        frame = new JFrame("TicTacToe");
        frame.add(g);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void cheChecker() {
        win = g.checkWinnerCheck();
        if (win.equals("Выйграл нолик") || win.equals("Выйграл крестик")) {
            frame.dispose();

            frame.add(new Kostil());
        }
    }

    public void forActions(String num) {
        int firts = 0;
        int second = 0;
        String[] pass = {"1","2","3","4","5","6","7","8","9"};
        String number = "";
        int counter = 0;
        FIRTS_LOOP:for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(pass[counter].equals(num)){
                    firts = i;
                    second = j;
                    break FIRTS_LOOP;
                }
                counter++;
            }
        }
        number = pass[counter];
        if (!nazim[counter]) {
            squares[firts][second].setFont(new Font("Arial", Font.PLAIN, 80));
            String el;
            String sss;
            el = printXorO(squares[firts][second]);
            if (el.equals("X")) {
                setPassX(number);
            } else {
                setPassY(number);
            }
            nazim[counter] = true;
            sss = checkWinnerCheck();
            System.out.println(sss);
            cheChecker();
        }
    }


    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            forActions(str);
        }
    };


    public static String getStr() {
        return win;
    }

    public MainField() {
        int cc = 0;
        this.setSize(400, 400);
        this.setLayout(new GridLayout(3, 3));
        squares = new JButton[3][3];
        buildButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cc++;
                squares[i][j].setActionCommand(""+cc);
                squares[i][j].addActionListener(actionListener);
            }
        }
    }



    private void setPassX(String winnerX) {
        this.winnerX += winnerX;
    }

    private void setPassY(String winnerY) {
        this.winnerY += winnerY;
    }

    private String printXorO(JButton sq) {
        if (krest) {
            sq.setText("X");
            nulik = true;
            krest = false;
            return "X";
        } else if (nulik) {
            sq.setText("O");
            krest = true;
            nulik = false;
            return "O";
        }
        return "false";
    }

    int[][] num = new int[3][3];

    private void buildButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setSize(400, 400);
                this.add(squares[i][j]);
            }
        }
    }

}
