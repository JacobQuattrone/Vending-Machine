package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class SimpleInput {
	private PrintWriter out;
	private Scanner in;
	public SimpleInput() {
		
		this.out = new PrintWriter(System.out);
		this.in = new Scanner(System.in);
	}
	
	public String promptUserForString(String prompt) {
		out.println(prompt);
		out.flush();
		String userInput = in.nextLine();
		return userInput;
		}
	
}
