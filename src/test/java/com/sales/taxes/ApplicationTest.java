package com.sales.taxes;

import java.io.IOException;

import org.junit.Test;

public class ApplicationTest {
	@Test
	public void testApplicationWithCorrectFile() {
		// Setup initial args - in this case the first input example
		final String[] args = new String[] {"input1.txt"};

		try {
			Application.main(args);
		} catch (IOException e) {
			System.out.println("Application running failed. More details: " + e.getMessage());
		}
	}

}
