package Othello;


import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class OthelloSplashScreen extends JWindow {

	private static final long serialVersionUID = 6248477390124803341L;

	private final int duration;

	public OthelloSplashScreen(int duration) {
		this.duration = duration;
	}

	public void showSplashWindow() {

		JPanel content = new JPanel(new BorderLayout());

		content.setBackground(Color.GRAY);


		int width = 640 + 10;
		int height = 962 + 10;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;

		JLabel label = new JLabel(new ImageIcon(getClass().getResource("whoisbenjamin-sEgCV_Ekxyo-unsplash.jpg"))); 
		JLabel demo = new JLabel("Abhi Patel Student ID: 040978822", JLabel.CENTER);
		demo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
		content.add(label, BorderLayout.CENTER);
		content.add(demo, BorderLayout.SOUTH);

		Color customColor = new Color(44, 197, 211);
		setBounds(x,y,width,height);
		content.setBorder(BorderFactory.createLineBorder(customColor, 10));


		setContentPane(content);


		setVisible(true);


		try {
			Thread.sleep(duration); 
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		dispose(); 

	}
}
