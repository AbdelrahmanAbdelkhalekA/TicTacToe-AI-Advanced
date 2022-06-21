import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;

public class TicTacToeIN implements ActionListener {
    boolean Playerturn, computer, t = true, over = true;

    int number = 0;
    int[][] arr = new int[][] {
            {9, 9, 9}, {9, 9, 9}, {9, 9, 9}
    };
    int first;
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel Btn_layout = new JPanel();
    JButton[] jButton = new JButton[9];
    JLabel textfield = new JLabel();
    Random random = new Random();
    void d() {
        //Clicklistener
        //
        //  = new Clicklistener();
        textfield.setBackground(new Color(41, 107, 158));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("SANS_SERIF", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);
        //frame.add(textfield);
        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        for (int j = 0; j < 9; j++) {
            jButton[j] = new JButton();
            jButton[j].setBackground(Color.white);
            jButton[j].addActionListener((ActionListener) this);
            jButton[j].setFocusable(false);
            Btn_layout.add(jButton[j]);
        }
        Btn_layout.setLayout(new GridLayout(3, 3, 5, 5));
        //  t_panel.add(textfield);
        // frame.add(t_panel, BorderLayout.NORTH);
        String[] options = {
                "Friend", "Computer"
        };
        int which = JOptionPane.showOptionDialog(frame, "Do you wish to play with a friend or computer?", "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        computer = which != 0;
        frame.add(Btn_layout);
        frame.setSize(800, 800);
        frame.setVisible(true);
        launchgame();
    }
    public void launchgame() {
        try {
            textfield.setText("Loading....");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int who = random.nextInt(50);
        if (who % 2 == 0) {
            textfield.setText("Player X");
            Playerturn = true;
        } else if (!computer) {
            textfield.setText("Player O");
            Playerturn = false;
        } else {
            textfield.setText("Computer");
            Playerturn = false;
            computerc();
        }
    }
    public void WinnerX(int x, int y, int z) {
        jButton[x].setBackground(Color.YELLOW);
        jButton[y].setBackground(Color.YELLOW);
        jButton[z].setBackground(Color.YELLOW);
        textfield.setText("Player X Wins!");
        for (int i = 0; i < (jButton.length); i++) {
            jButton[i].setEnabled(false);
        }
        gameover();
    }
    public void gameover() {
        String options[] = {
                "Restart",
                "Exit"
        };
        int which = JOptionPane.showOptionDialog(frame, "Do you wish to restart or exit?", "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        frame.dispose();
        if (which == 0) {
            over = false;
            new TicTacToeIN().d();
        }
    }

    public void WinnerO(int x, int y, int z) {
        jButton[x].setBackground(Color.YELLOW);
        jButton[y].setBackground(Color.YELLOW);
        jButton[z].setBackground(Color.YELLOW);
        if (!computer) {
            textfield.setText("Player O Wins!");
        } else {
            textfield.setText("Computer Wins!");
        }
        for (JButton button: jButton) {
            button.setEnabled(false);
        }
        gameover();
    }

    public void matchscore() {

        if ((jButton[0].getText() == "X") && (jButton[1].getText() == "X") && (jButton[2].getText() == "X")) {
            WinnerX(0, 1, 2);
        } else if ((jButton[0].getText() == "X") && (jButton[4].getText() == "X") && (jButton[8].getText() == "X")) {
            WinnerX(0, 4, 8);
        } else if ((jButton[0].getText() == "X") && (jButton[3].getText() == "X") && (jButton[6].getText() == "X")) {
            WinnerX(0, 3, 6);
        } else if ((jButton[1].getText() == "X") && (jButton[4].getText() == "X") && (jButton[7].getText() == "X")) {
            WinnerX(1, 4, 7);
        } else if ((jButton[2].getText() == "X") && (jButton[4].getText() == "X") && (jButton[6].getText() == "X")) {
            WinnerX(2, 4, 6);
        } else if ((jButton[2].getText() == "X") && (jButton[5].getText() == "X") && (jButton[8].getText() == "X")) {
            WinnerX(2, 5, 8);
        } else if ((jButton[3].getText() == "X") && (jButton[4].getText() == "X") && (jButton[5].getText() == "X")) {
            WinnerX(3, 4, 5);
        } else if ((jButton[6].getText() == "X") && (jButton[7].getText() == "X") && (jButton[8].getText() == "X")) {
            WinnerX(6, 7, 8);
        } else if ((jButton[0].getText() == "O") && (jButton[1].getText() == "O") && (jButton[2].getText() == "O")) {
            WinnerO(0, 1, 2);
        } else if ((jButton[0].getText() == "O") && (jButton[3].getText() == "O") && (jButton[6].getText() == "O")) {
            WinnerO(0, 3, 6);
        } else if ((jButton[0].getText() == "O") && (jButton[4].getText() == "O") && (jButton[8].getText() == "O")) {
            WinnerO(0, 4, 8);
        } else if ((jButton[1].getText() == "O") && (jButton[4].getText() == "O") && (jButton[7].getText() == "O")) {
            WinnerO(1, 4, 7);
        } else if ((jButton[2].getText() == "O") && (jButton[4].getText() == "O") && (jButton[6].getText() == "O")) {
            WinnerO(2, 4, 6);
        } else if ((jButton[2].getText() == "O") && (jButton[5].getText() == "O") && (jButton[8].getText() == "O")) {
            WinnerO(2, 5, 8);
        } else if ((jButton[3].getText() == "O") && (jButton[4].getText() == "O") && (jButton[5].getText() == "O")) {
            WinnerO(3, 4, 5);
        } else if ((jButton[6].getText() == "O") && (jButton[7].getText() == "O") && (jButton[8].getText() == "O")) {
            WinnerO(6, 7, 8);
        }

        if (number == 9) {
            textfield.setText("Draw!");
            if (over) {
                gameover();
            }
        }
    }

    public int ComputerChoice() {
        int count = 0, empty = 0;
        int xattempts = 0, yattempts = 0, xattemptsh = 0, yattemptsv = 0;
        int button = 0;
        int[] playcor = new int[] {
                9,
                9,
                9
        };

        if ((number == 1 || number == 0) && computer) {
            int x = random.nextInt(8);
            if (x != first && number == 1) {
                x = random.nextInt(8);
            }
            return x;
        }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(jButton[count].getText(), "X")) {
                        arr[i][j] = 1;
                    } else if (Objects.equals(jButton[count].getText(), "O")) {
                        arr[i][j] = 2;
                    }
                    count++;
                }
            }
            count = 1;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (arr[i][j] == 2 && (k == 0)) {
                        yattempts++;
                        if (yattempts == 2) {
                            if (arr[i][0] == 9) {
                                return (i * 3);
                            } else if (arr[i][1] == 9) {
                                return (i * 3 + 1);
                            } else if (arr[i][2] == 9) {
                                return (i * 3 + 2);
                            }
                        }
                    }

                    if (arr[i][j] == 1 && (k == 1)) {
                        xattempts++;
                        if ((xattempts == 2)) {
                            if (arr[i][0] == 9) {
                                return (i * 3);
                            } else if (arr[i][1] == 9) {
                                return (i * 3 + 1);
                            } else if (arr[i][2] == 9) {
                                return (i * 3 + 2);
                            }
                        }
                    }
                    // 0 3 6 (0,0) (1,0) (2,0) = i*3  1 4 7 (0,1) (1,1) (2,1)
                    if (arr[j][i] == 2 && (k == 0)) {
                        yattemptsv++;
                        if (yattemptsv == 2) {
                            if (arr[0][i] == 9) {
                                return (i);
                            } else if (arr[1][i] == 9) {
                                return (3 + i);
                            } else if (arr[2][i] == 9) {
                                return (6 + i);
                            }
                        }
                    }

                    if (arr[j][i] == 1 && (k==1)) {
                        xattemptsh++;
                        if (xattemptsh == 2) {
                            if (arr[0][i] == 9) {
                                return (i);
                            } else if (arr[1][i] == 9) {
                                return (3 + i);
                            } else if (arr[2][i] == 9) {
                                return (6 + i);
                            }
                        }
                    }

                    if ((arr[0][0] == 1 && arr[1][1] == 1) || (arr[0][0] == 1 && arr[2][2] == 1) || (arr[1][1] == 1 && arr[2][2] == 1) || (arr[0][0] == 2 && arr[1][1] == 2) || (arr[0][0] == 2 && arr[2][2] == 2) || (arr[1][1] == 2 && arr[2][2] == 2)) {
                        if (arr[0][0] == 9) {
                            return 0;
                        } else if (arr[1][1] == 9) {
                            return 4;
                        } else if (arr[2][2] == 9) {
                            return 8;
                        }
                    }

                    if ((arr[0][2] == 1 && arr[1][1] == 1) || (arr[1][1] == 1 && arr[2][0] == 1) || (arr[0][2] == 1 && arr[2][0] == 1) || (arr[0][2] == 2 && arr[1][1] == 2) || (arr[1][1] == 2 && arr[2][0] == 2) || (arr[0][2] == 2 && arr[2][0] == 2)) {
                        if (arr[0][2] == 9) {
                            return 2;
                        } else if (arr[1][1] == 9) {
                            return 4;
                        } else if (arr[2][0] == 9) {
                            return 6;
                        }
                    }

                    if (count % 3 != 0) {
                        count++;
                    } else {
                        count = 1;
                        xattempts = 0;
                        yattempts = 0;
                        xattemptsh = 0;
                        yattemptsv = 0;
                    }
                }
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int b = 0; b < 3; b++) {
                if (arr[k][b] == 9) {
                    return (k * 3 + b);
                }
            }
        }
        return button;
    }

    public void computerc() {
        int y = ComputerChoice();
        number++;
        textfield.setText("Player X");
        jButton[y].setText("O");
        //jButton[i].setEnabled(false);
        jButton[y].setForeground(new Color(0, 0, 255));
        jButton[y].setFont(new Font("Ink Free", Font.BOLD, 80));
        Playerturn = true;
        matchscore();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == jButton[i]) {
                if (Playerturn) {
                    if (Objects.equals(jButton[i].getText(), "")) {
                        number++;
                        first = i;
                        if (!computer) {
                            textfield.setText("Player O");
                        } else {
                            textfield.setText("Computer");
                        }
                        jButton[i].setText("X");
                        // jButton[i].setEnabled(false);
                        jButton[i].setForeground(new Color(255, 0, 0));
                        jButton[i].setFont(new Font("Ink Free", Font.BOLD, 80));
                        Playerturn = false;
                        matchscore();
                        if (computer) {
                            computerc();
                        }
                    }
                } else {
                    if (Objects.equals(jButton[i].getText(), "") && (!computer)) {
                        number++;
                        textfield.setText("Player X");
                        jButton[i].setText("O");
                        //jButton[i].setEnabled(false);
                        jButton[i].setForeground(new Color(0, 0, 255));
                        jButton[i].setFont(new Font("Ink Free", Font.BOLD, 80));
                        Playerturn = true;
                        matchscore();
                    }
                }
            }
        }
    }
}
