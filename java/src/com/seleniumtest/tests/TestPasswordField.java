package com.seleniumtest.tests;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class TestPasswordField {

	public static void main(String[] args) {
		JPasswordField pf = new JPasswordField();
		int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (okCxl == JOptionPane.OK_OPTION) {
		  String password = new String(pf.getPassword());
		  System.err.println("You entered: " + password);
		}

	}

}
