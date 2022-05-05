package io.mockito;

import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@ExtendWith(MockitoExtension.class)
public class CalculatorMockitoTest {
	
	@Mock
	CalculatorService service;
	
	@InjectMocks
	CalculatorServiceImpl impl ;
		
	@BeforeEach
	void init() {
		impl = new  CalculatorServiceImpl();
		impl.setCalculatorService(service);
		System.out.println("Implementation Created..."+impl);
	}
	
	@Test
	void testAdd() {
		System.out.println("Test started..");
		Mockito.when(service.add(10.0, 20.0)).thenReturn(30.0);
		double value =impl.add(10.0, 20.0);
		Assertions.assertEquals(value,30);
	}

}


