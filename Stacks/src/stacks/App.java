package stacks;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends GUI {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmLibraryApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		super();
		initialize();
	}
	
	private void initialize() {
		
		btnIntQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntQueue out = Test.parseInput(fieldIntQueue.getText());
				out = Test.reverseQueue(out);
				lblOutputIntQueue.setText("Output: " + out.toString());
			}
		});
		
		btnPalindrome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean out = Palindrome.isPalindrome(fieldPalindrome.getText());
				lblOutputPalindrome.setText("Output: " + out.toString());
			}
		});
	}
}
