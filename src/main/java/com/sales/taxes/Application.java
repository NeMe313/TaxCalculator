package com.sales.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import com.sales.taxes.service.Chooser;
import com.sales.taxes.service.Processor;

/**
 * The class is used for running the Application through the main method
 */
public class Application {

	public static void main(String[] args) throws IOException {
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		//Asking for user choice between the three input options
		InputStream input = classLoader.getResourceAsStream((args.length != 0)?args[0]:Chooser.getUserChoice());
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		
		//Processing the choice (the input file which is selected)
        Processor.process(stream);
	}
}
