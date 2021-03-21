package Othello;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloViewController extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField display; // the JTextField
	Color black = new Color(0, 0, 0);
	Color white = new Color(255, 255, 255);

	private static final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

	public OthelloViewController() {
		JLabel mainFrame = new JLabel();
		//the panel to include the chess board and the buttons
		JPanel westSidePanel = new JPanel();
		//the panel to include the textfield and the submit button
		JPanel eastSidePanel = new JPanel();
		//Pink zone
		JPanel pinkZone = new JPanel();
		//Board
		JLabel[][] chessBoard = new JLabel[8][8];
		//submit button
		JButton submit = new JButton();
		//Check box that has text
		JCheckBox show_moves = new JCheckBox("Show Valid Moves");  

		//Set up the whole layout
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GRAY));  
		
		/* Start pink zone*/
		pinkZone = new JPanel();
		pinkZone.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.GRAY));
		pinkZone.setLayout(new BorderLayout(0,0)); 

		show_moves = new JCheckBox("Show Valid Moves");
		JPanel checkBox = new JPanel();
		checkBox.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.GRAY));
		checkBox.setLayout(new BorderLayout(0,0));
		checkBox.setBackground(Color.WHITE);
		checkBox.add(show_moves);
		pinkZone.add(checkBox, BorderLayout.NORTH);

		JLabel playerStep = new JLabel();
		playerStep.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.GRAY));
		playerStep.setLayout(new BorderLayout()); 
		playerStep.setBackground(Color.PINK);
		playerStep.setText("<html>Player 1 initialized with 2 pieces.<br>Player 2 initialized with 2 pieces.</html>");
		playerStep.setOpaque(true);
		pinkZone.add(playerStep, BorderLayout.CENTER);

		JLabel player1 = new JLabel("Player 1 Pieces:");
		JLabel Image1 = new JLabel(new ImageIcon(getClass().getResource("white_s.png")));
		Image1.setText("2");
		JLabel wrapper1 = new JLabel();
		wrapper1.setLayout(new BorderLayout()); 
		wrapper1.add(player1, BorderLayout.WEST);
		wrapper1.add(Image1, BorderLayout.EAST);
		JLabel player2 = new JLabel("Player 2 Pieces:");
		JLabel Image2 = new JLabel(new ImageIcon(getClass().getResource("black_s.png")));
		Image2.setText("2");
		JLabel wrapper2 = new JLabel();
		wrapper2.setLayout(new BorderLayout());
		wrapper2.add(player2, BorderLayout.WEST);
		wrapper2.add(Image2, BorderLayout.EAST);
 		JPanel playerInfo = new JPanel();
		playerInfo.setLayout(new GridLayout(2, 0));
		playerInfo.setPreferredSize(new Dimension(450,100));
		playerInfo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		playerInfo.add(wrapper1);
		playerInfo.add(wrapper2);
		pinkZone.add(playerInfo, BorderLayout.SOUTH);

		//setup west layout
		westSidePanel.setLayout(new BorderLayout());

		//setup board
		westSidePanel.setLayout(new BorderLayout());
		westSidePanel.setPreferredSize(new Dimension(540,540));
		
		//set up board field
		JPanel boardField = new JPanel();
		boardField.setLayout(new GridLayout(8,8)); 
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {				
				if(i%2 == 0) {
					if(j%2 == 0) {
						if(i == 4 && j == 4) {
							chessBoard[i][j] = new JLabel(new ImageIcon(getClass().getResource("white_s.png")));
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(black);
						} else {
							chessBoard[i][j] = new JLabel();
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(black);
						}
					}
					else {
						if(i == 4 && j == 3) {
							chessBoard[i][j] = new JLabel(new ImageIcon(getClass().getResource("black_s.png")));
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(white);
						} else {
							chessBoard[i][j] = new JLabel();
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(white);	
						}
					}
				}else {
					if(j%2 != 0) {
						if(i == 3 && j == 3) {
							chessBoard[i][j] = new JLabel(new ImageIcon(getClass().getResource("white_s.png")));
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(black);
						} else {
							chessBoard[i][j] = new JLabel();
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(black);
						}
					}
					else { 
						if(i == 3 && j == 4) {
							chessBoard[i][j] = new JLabel(new ImageIcon(getClass().getResource("black_s.png")));
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(white);
						} else {
							chessBoard[i][j] = new JLabel();
							chessBoard[i][j].setOpaque(true);
							chessBoard[i][j].setPreferredSize(new Dimension(60, 60));
							chessBoard[i][j].setBackground(white);
						}
					}
				}
				boardField.add(chessBoard[i][j]);              
			}
		}
		
		//set up numField
		JPanel numberField = new JPanel();
		numberField.setLayout(new GridLayout(8,1));
		for(int i=1; i<=8; i++) {
			JButton button = createButton(String.valueOf(i),String.valueOf(i),Color.BLACK,Color.LIGHT_GRAY,new Controller());
			button.setPreferredSize(new Dimension(60, 60));
			button.setBorder(BorderFactory.createMatteBorder(1, 2, 0, 4, Color.GRAY));
			button.setOpaque(true);
			
			
			numberField.add(button);
		}
		
		//set up letterField
		JPanel letterField = new JPanel();
		letterField.setLayout(new GridLayout(1,9));
		for(int i=0;i<8;i++) {
			JButton button = createButton(letters[i],letters[i],Color.BLACK,Color.LIGHT_GRAY,new Controller());
			button.setPreferredSize(new Dimension(60, 60));
			button.setBorder(BorderFactory.createMatteBorder(2, 0, 4, 1, Color.GRAY));
			button.setOpaque(true);
			
			letterField.add(button);
		}
		
		//set up move
		JButton move = createButton("move","move",Color.BLACK,Color.WHITE,new Controller());
		move.setFont(new Font(move.getFont().getName(), move.getFont().getStyle(), 9));
		move.setOpaque(true);
		move.setPreferredSize(new Dimension(60, 60));
		move.setBorder(BorderFactory.createMatteBorder(1, 0, 4, 4, Color.GRAY));
		letterField.add(move);
		
		westSidePanel.add(boardField, BorderLayout.CENTER);
		westSidePanel.add(numberField, BorderLayout.EAST);
		westSidePanel.add(letterField, BorderLayout.SOUTH);

		//setup the textField
		display = new JTextField();
		display.setPreferredSize(new Dimension(20,20));
		display.setBackground(Color.WHITE);
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.LEFT);

		//setup the submit button
		submit.setPreferredSize(new Dimension(60, 20));
		submit.setBackground(Color.BLACK);
		submit.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		submit.setText("Submit"); 
		submit.setFont(new Font(submit.getFont().getName(), Font.PLAIN, 15));
		submit.setForeground(Color.RED);

		//setup south panel
		eastSidePanel.setLayout(new BorderLayout());
		eastSidePanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 2, Color.GRAY));

		//add button and text field
		eastSidePanel.add(display, BorderLayout.CENTER);
		eastSidePanel.add(submit, BorderLayout.EAST);

		//add into main panel
		mainFrame.add(pinkZone, BorderLayout.EAST);
		mainFrame.add(westSidePanel, BorderLayout.WEST);
		mainFrame.add(eastSidePanel, BorderLayout.SOUTH);
		
		add(mainFrame);
	}

	private JButton createButton(String text, String ac, Color fgc, Color bgc, ActionListener handler) {
		
		JButton button = new JButton(text); 

		button.setForeground(fgc);
		button.setBackground(bgc);

		if (ac != null) {
			button.setActionCommand(ac);
		}

		button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
		
		button.addActionListener(handler);

		return button;
	}
	
	class Controller implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String act = ae.getActionCommand();
			System.out.println(act);
		}
	}
}
