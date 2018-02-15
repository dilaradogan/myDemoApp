package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
    extends TestCase
{
    
	
	public void testEmptyArrays() {
		ArrayList<Integer> array1 = new ArrayList<>();
		ArrayList<Integer> array2 = new ArrayList<>();
		ArrayList<Integer> array3 = new ArrayList<>();
		assertEquals(0,new App().search(array1, array2, array3, 5));
		
	}

	public void testNull(){
		assertEquals(0,new App().search(null, null, null, 5));
	}
	
	public void testNotFound() {
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		assertEquals(0,new App().search(array1, array2, array3, 5));
		
	}
	
	public void testAllFound() {
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 1, 3, 4));
		ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(0, 2, 1, 4));
		assertEquals(3,new App().search(array1, array2, array3, 1));
		
	}
	
	public void testTwoFound() {
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 7, 3, 4));
		ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(0, 2, 1, 4));
		assertEquals(2,new App().search(array1, array2, array3, 1));
		
	}
	
	public void testOneFound() {
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 7, 3, 4));
		ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(0, 2, 1, 4));
		assertEquals(1,new App().search(array1, array2, array3, 7));
		
	}
}
