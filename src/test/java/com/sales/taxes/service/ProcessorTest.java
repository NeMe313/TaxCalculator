package com.sales.taxes.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import org.junit.Test;

public class ProcessorTest {

	@Test(expected = NullPointerException.class)
	public void testProccesStreamNull() {
		Stream<String> stream = null;
		Processor.process(stream);
	}

	@Test
	public void testProccesWithInput1() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("input1.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}

	@Test
	public void testProccesWithInput2() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("input2.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}

	@Test
	public void testProccesWithInput3() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("input3.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}

	@Test
	public void testCartCreationWithOnlyEmptyLines() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("testInput1.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}
	
	@Test
	public void testCartCreationWithMixedData() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("testInput2.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}
	
	@Test
	public void testCartCreationWithImportNotOnBeginning() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("testInput3.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}	
	
	@Test(expected = Error.class)
	public void testCartCreationWithNoQuantity() {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("testInput4.txt");
		Stream<String> stream = new BufferedReader(new InputStreamReader(input)).lines();
		Processor.process(stream);
	}
}
