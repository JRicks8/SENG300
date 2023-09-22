package stacks;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GUI {
	
	public JFrame frmLibraryApp;
	public JButton btnPalindrome;
	public JButton btnIntQueue;
	public JTextField fieldPalindrome;
	public JTextField fieldIntQueue;
	public JLabel lblOutputIntQueue;
	public JLabel lblOutputPalindrome;
	
	public GUI() {
		frmLibraryApp = new JFrame();
		frmLibraryApp.getContentPane().setBackground(new Color(192, 192, 192));
		
		JPanel panel = new JPanel();
		frmLibraryApp.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		fieldPalindrome = new JTextField();
		fieldPalindrome.setBounds(10, 36, 119, 20);
		panel.add(fieldPalindrome);
		fieldPalindrome.setColumns(10);
		
		JLabel lblPalindrome = new JLabel("Test for palindromes");
		lblPalindrome.setBounds(10, 11, 133, 14);
		panel.add(lblPalindrome);
		
		lblOutputPalindrome = new JLabel("Output: ");
		lblOutputPalindrome.setBounds(10, 101, 96, 14);
		panel.add(lblOutputPalindrome);
		
		btnPalindrome = new JButton("Execute");
		btnPalindrome.setBounds(10, 67, 86, 23);
		panel.add(btnPalindrome);
		
		JLabel lblIntQueue = new JLabel("Reverse IntQueue");
		lblIntQueue.setBounds(139, 11, 285, 14);
		panel.add(lblIntQueue);
		
		fieldIntQueue = new JTextField();
		fieldIntQueue.setText("1,2,3,4,5,6,7,8,9,10");
		fieldIntQueue.setBounds(139, 36, 285, 20);
		panel.add(fieldIntQueue);
		fieldIntQueue.setColumns(10);
		
		btnIntQueue = new JButton("Execute");
		btnIntQueue.setBounds(140, 67, 86, 23);
		panel.add(btnIntQueue);
		
		lblOutputIntQueue = new JLabel("Output: ");
		lblOutputIntQueue.setBounds(139, 101, 1000000, 49);
		panel.add(lblOutputIntQueue);
		frmLibraryApp.setTitle("Stacks Class Assignment");
		frmLibraryApp.setBounds(100, 100, 450, 200);
		frmLibraryApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}