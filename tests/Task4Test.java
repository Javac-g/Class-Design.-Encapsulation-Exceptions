package jom.com.softserve.s1.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task4Test {

	final private static String OPERATION = "com.pines.s1.task4.Operation";

	@DisplayName("Check that Product class is present")
	@Test
	void isTypeClass() {
		try {
			assertNotNull(Class.forName(OPERATION));
			assertEquals("Operation", Class.forName(OPERATION).getSimpleName());
		} catch (ClassNotFoundException e) {
			fail("There is no Operation class");
		}
	}

	@DisplayName("Check that a class has a properly methods")
	@ParameterizedTest
	@MethodSource("provideTypeDeclaredMethod")
	void hasTypeDeclaredMethod(String methodName, Class[] paramTypes) {
		try {
			Class<?> clazz = Class.forName(OPERATION);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			Class<?>[] types = paramTypes;
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					Class<?>[] parameterTypes = method.getParameterTypes();
					if (Arrays.equals(types, parameterTypes)) {
						isMethod = true;
					}
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}

	}

	private static Stream<Arguments> provideTypeDeclaredMethod() {
		return Stream.of(Arguments.of("squareRectangle", new Class[] { int.class, int.class }),
				Arguments.of("trySquareRectangle", new Class[] { int.class, int.class }));
	}

	@DisplayName("Check that method returns value of appropriate type")
	@ParameterizedTest
	@MethodSource("provideReturnTypeDeclaredMethod")
	void hasMethodReturnType(String methodName, Class type) {
		try {
			Class<?> clazz = Class.forName(OPERATION);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					assertEquals(method.getReturnType(), type);
					isMethod = true;
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	private static Stream<Arguments> provideReturnTypeDeclaredMethod() {
		return Stream.of(Arguments.of("squareRectangle", int.class), Arguments.of("trySquareRectangle", int.class));
	}

	@DisplayName("Check that 'squareRectangle' method throws an exception")
	@ParameterizedTest
	@MethodSource("providesquareRectangleMethod")
	void squareRectangleTest(int a, int b) {
		assertThrows(IllegalArgumentException.class, () -> {
			Operation.squareRectangle(a, b);
		}, "both arguments should be more than zero");
	}

	private static Stream<Arguments> providesquareRectangleMethod() {
		return Stream.of(Arguments.of(-3, 5), Arguments.of(-3, -5), Arguments.of(3, -5));
	}

	@DisplayName("Check the result of 'squareRectangle' method")
	@Test
	void squareRectanglePositiveTest() {
		assertTrue(Operation.squareRectangle(3, 5) == 15);
	}

	@DisplayName("Check the result of 'trySquareRectangle' method")
	@ParameterizedTest
	@MethodSource("providesquareRectangleMethod")
	void trySquareRectangleTest(int a, int b) {
		assertTrue(Operation.trySquareRectangle(a, b) == -1);
	}

	@DisplayName("Check the result of 'trySquareRectangle' method")
	@Test
	void trySsquareRectanglePositiveTest() {
		assertTrue(Operation.trySquareRectangle(3, 5) == 15);
	}
}
