
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.Timer;
public class TicTacToe implements ActionListener {
	Random random = new Random();
	Timer timer = new Timer();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	boolean tie = true;
	int totalMoves = 0; 

	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(51,51,51));
		textfield.setForeground(new Color(255,255,255));
		textfield.setFont(new Font("SansSerif",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("SansSerif",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		JButton playAgainButton = new JButton("Play Again");
		playAgainButton.setFont(new Font("MV Boli", Font.PLAIN, 30));
		playAgainButton.addActionListener(e -> resetGame());

		// Create Exit button
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("MV Boli", Font.PLAIN, 30));
		exitButton.addActionListener(e -> System.exit(0));

		// Add buttons to a panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(playAgainButton);
		buttonPanel.add(exitButton);

		// Add the button panel to the frame's south (bottom) position
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		firstTurn();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(51,204,255));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						totalMoves++; 
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,255,0));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						totalMoves++;
						check();
					}
					
				}
			}
		}
		
	}
	public void firstTurn() {
		timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  if(random.nextInt(2)==0) {
						player1_turn = true;
						textfield.setText("X's turn");
				  }
				  else {
						player1_turn = false;
						textfield.setText("O's turn");
				  }  
				  for (int i = 0; i < 9; i++) {
						buttons[i].setEnabled(true);
				  }
			  }
		}, 3000);	
	}
	
	private void resetGame() {
	    for (int i = 0; i < 9; i++) {
	        buttons[i].setText("");
	        buttons[i].setBackground(null);
	        buttons[i].setEnabled(true);
	    }

	    totalMoves = 0;
	    player1_turn = random.nextBoolean();

	    if (player1_turn) {
	        textfield.setText("X turn");
	    } else {
	        textfield.setText("O turn");
	       
	    }
	}

	
	public void check() {
		//check X win condition
		if(
			(buttons[0].getText()=="X") &&
			(buttons[1].getText()=="X")&&
			(buttons[2].getText()=="X")) {
			xWins(0,1,2);
			
		}
		if(
			(buttons[3].getText()=="X") &&
			(buttons[4].getText()=="X")&&
			(buttons[5].getText()=="X")) {
			xWins(3,4,5);
			
		}
		if(
			(buttons[6].getText()=="X") &&
			(buttons[7].getText()=="X")&&
			(buttons[8].getText()=="X")) {
			xWins(6,7,8);
			
		}
		if(
			(buttons[0].getText()=="X") &&
			(buttons[3].getText()=="X")&&
			(buttons[6].getText()=="X")) {
			xWins(0,3,6);
			
		}
		if(
			(buttons[1].getText()=="X") &&
			(buttons[4].getText()=="X")&&
			(buttons[7].getText()=="X")) {
			xWins(1,4,7);
		
		}
		if(
			(buttons[2].getText()=="X") &&
			(buttons[5].getText()=="X")&&
			(buttons[8].getText()=="X")) {
			xWins(2,5,8);
			
		}
		if(
			(buttons[0].getText()=="X") &&
			(buttons[4].getText()=="X")&&
			(buttons[8].getText()=="X")) {
			xWins(0,4,8);
		;
		}
		if(
			(buttons[2].getText()=="X") &&
			(buttons[4].getText()=="X")&&
			(buttons[6].getText()=="X")) {
			xWins(2,4,6);
			
		}		
		
		//check 0 win conditions
		
		if(
			(buttons[0].getText()=="O") &&
			(buttons[1].getText()=="O")&&
			(buttons[2].getText()=="O")) {
			oWins(0,1,2);
		
		}
		if(
			(buttons[3].getText()=="O") &&
			(buttons[4].getText()=="O")&&
			(buttons[5].getText()=="O")) {
			oWins(3,4,5);
		
		}
		if(
			(buttons[6].getText()=="O") &&
			(buttons[7].getText()=="O")&&
			(buttons[8].getText()=="O")) {
			oWins(6,7,8);
			
		}
		if(
			(buttons[0].getText()=="O") &&
			(buttons[3].getText()=="O")&&
			(buttons[6].getText()=="O")) {
			oWins(0,3,6);
			
		}
		if(
			(buttons[1].getText()=="O") &&
			(buttons[4].getText()=="O")&&
			(buttons[7].getText()=="O")) {
			oWins(1,4,7);
			
		}
		if(
			(buttons[2].getText()=="O") &&
			(buttons[5].getText()=="O")&&
			(buttons[8].getText()=="O")) {
			oWins(2,5,8);
		
		}
		if(
			(buttons[0].getText()=="O") &&
			(buttons[4].getText()=="O")&&
			(buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if(
			(buttons[2].getText()=="O") &&
			(buttons[4].getText()=="O")&&
			(buttons[6].getText()=="O")) {
			oWins(2,4,6);
		}
		
		// Check for a tie
		
        if (totalMoves == 9) {
            textfield.setText("It's a Tie!");
            disableButtons();
        }
    }
		
	
	public void xWins(int a, int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		   
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
		resetting();
	}
	
	public void oWins(int a, int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		   
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
		resetting();  
	}
	
    private void disableButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }
	
	public void resetting() {
		
		firstTurn();
		timer.schedule(new TimerTask() {
			
			  @Override
			  public void run() {
				  for (int i = 0; i < 9; i++) {
					  buttons[i].setEnabled(true);
					  buttons[i].setText("");
					  buttons[i].setBackground(null);
				  }
			  }
		}, 3000);	
	}
}

