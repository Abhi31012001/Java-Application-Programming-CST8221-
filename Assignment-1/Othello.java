package Othello;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
/**
 * The main class to run the splash screen and the controller
 * @version 1.0
 * @since 	2020-10-15
 * @author 	Abhi Patel 040978822
 * @see 	OthelloViewController
 * @see 	OthelloSplashScreen
 */
public class Othello {
	/**
	 * This method runs the program
	 * @param 	args	An array of arguments put in the function
	 * @return 	void	Nothing
	 */
	public static void main(String[] args) {
		int duration = 3000;
		if(args.length == 1){
			try{
				duration = Integer.parseInt(args[0]);
			}catch (NumberFormatException mfe){
				System.out.println("Wrong command line argument: must be an integer number");
				System.out.println("The default duration 10000 milliseconds will be used");
				//mfe.printStackTrace();	
			} 
		}
		// Create the screen
		OthelloSplashScreen splashWindow = new OthelloSplashScreen(duration);
		//Show the Splash screen 
		splashWindow.showSplashWindow();
		//Create and display the main application GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new OthelloViewController();
				frame.setTitle("Nguyen Gia Khanh Ho Othello Client");
				frame.setMinimumSize(new Dimension(1017, 619));  
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationByPlatform(true);  
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
			}
		});		
	}//end main
}
