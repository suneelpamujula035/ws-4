package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.example.cal.Calculation;

@SpringBootTest
class Junit1ApplicationTests {
	
	
	@BeforeTestClass
	public void setup1() {
		System.out.println("Im executing before class");
	}
	@BeforeTestMethod
	public void setup2() {
		System.out.println("Im executing before every test method");
	}
	@Test
	public void testCase1() {
		System.out.println("Im executing testCase1");
	}
	@Test
	public void testCase2() {
		System.out.println("Im executing testCase2");
	}
	@Test
	public void testCase3() {
		System.out.println("Im executing testCase3");
	}
	@Test
	public void testCase4() {
		System.out.println("Im executing testCase4");
	}
	@Test
	public void addTestCase() {
		assertEquals(15, Calculation.addNumbers(10, 5));
		System.out.println("calculation successfull");
	}
	@AfterTestMethod
	public void setup3() {
		System.out.println("Im executing after every test method");
	}
	@AfterTestClass
	public void setup4() {
		System.out.println("Im executing after class");
	}
}
