package com.example.Hotel_App;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class HotelAppApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("ngo quang dung");
	}
	@Test
	void testSumWithInput() {
		int a = 5;
		int b = 7;
		int sum = a + b;
		System.out.println("Sum: " + sum);
	}

}
