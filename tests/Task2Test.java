package jom.com.softserve.s1.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task2Test {

	final private static String POINT = "";

	@DisplayName("Check that Point class is present")
	@Test
	void isTypeClassMyUtilsTest() {
		try {
			assertNotNull(Class.forName(POINT));
			assertEquals("Point", Class.forName(POINT).getSimpleName());
		} catch (ClassNotFoundException e) {
			fail("There is no Point class");
		}
	}

	@DisplayName("Check that Point class has 'x' field")
	@Test
	void hasTypeDeclaredFieldTest() {
		try {
			Class<?> clazz = Class.forName(POINT);
			Field field = clazz.getDeclaredField("x");
			assertNotNull(field);
			assertEquals("x", field.getName());
		} catch (ClassNotFoundException e) {
			fail("There is no Point class");
		} catch (NoSuchFieldException e) {
			fail("There is no 'x' field");
		}
	}

	@DisplayName("Check that type of field is int")
	@ParameterizedTest
	@MethodSource("provideFieldData")
	void isCounterFieldIntTest(String fieldName, Class type) {
		try {
			Class<?> clazz = Class.forName(POINT);
			Field field = clazz.getDeclaredField(fieldName);
			assertTrue(field.getType().equals(type));
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		} catch (NoSuchFieldException e) {
			fail("There is no such field");
		}
	}

	private static Stream<Arguments> provideFieldData() {
		return Stream.of(Arguments.of("x", int.class), Arguments.of("y", int.class));
	}

	@DisplayName("Check that a field is private")
	@ParameterizedTest
	@MethodSource("provideFieldData")
	void isFieldPrivateTest(String fieldName) {
		try {
			Class<?> clazz = Class.forName(POINT);
			Field field = clazz.getDeclaredField(fieldName);
			assertTrue(Modifier.isPrivate(field.getModifiers()));
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		} catch (NoSuchFieldException e) {
			fail("There is no such field");
		}
	}

	@DisplayName("Check that Point class contains a constructor")
	@Test
	void hasIteratorClassConstructorTest() {
		try {
			Class<?> clazz = Class.forName(POINT);
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			assertNotNull(constructors);
			boolean isConstructor = false;
			for (Constructor<?> constructor : constructors) {
				Class<?>[] params = constructor.getParameterTypes();
				if (Arrays.equals(params, new Class[] { int.class, int.class })) {
					isConstructor = true;
				}
			}
			assertTrue(isConstructor);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	@DisplayName("Check that Point class has a method")
	@ParameterizedTest
	@MethodSource("provideMethodData")
	void hasTypeDeclaredMethod(String methodName, Class<?>[] params) {
		try {
			Class<?> clazz = Class.forName(POINT);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method method: methods) {
				if (methodName.equals(method.getName())) {
					Class<?>[] p = method.getParameterTypes();
					if (Arrays.equals(p, params)) {
						isMethod = true;
						break;
					}
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	private static Stream<Arguments> provideMethodData() {
		return Stream.of(Arguments.of("distance", new Class[] { Point.class }),
				Arguments.of("distance", new Class[] {}), Arguments.of("getXYPair", new Class[] {}),
				Arguments.of("distance", new Class[] { int.class, int.class }));
	}
	
	@DisplayName("Check that 'distance' method returns double")
	@Test
	void hasMethodReturnType() {
		Method[] methods = null;
		try {
			methods = Class.forName(POINT).getDeclaredMethods();
		} catch (ClassNotFoundException e) {
			fail("There is no class Point");
		}
		boolean isMethod = false;
		for (Method method : methods) {
			if (method.getName().equals("distance")) {
				isMethod = true;
				assertEquals(method.getReturnType(), double.class);
				break;
			}
		}
		assertTrue(isMethod);
	}

	@DisplayName("Check the distance between points")
	@ParameterizedTest
	@MethodSource("providePointsData")
	void distanceTest(int x1, int y1, int x2, int y2, double result) {
		Point p = new Point(x1, y1);
		assertEquals(p.distance(x2, y2), result, 0.001);

	}
	
	@DisplayName("Check the distance between points")
	@ParameterizedTest
	@MethodSource("providePointsData")
	void distanceTest1(int x1, int y1, int x2, int y2, double result) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		assertEquals(p1.distance(p2), result, 0.001);

	}

	private static Stream<Arguments> providePointsData() {
		return Stream.of(Arguments.of(5, 7, 3, 10, 3.6056), Arguments.of(-5, 7, 3, -10, 18.7883),
				Arguments.of(-5, -7, 3, 10, 18.7883), Arguments.of(5, -7, -3, 10, 18.7883));
	}
	
	@DisplayName("Check the distance between points")
	@ParameterizedTest
	@MethodSource("providePointZeroData")
	void distanceZeroTest(int x1, int y1, double result) {
		Point p = new Point(x1, y1);
		assertEquals(p.distance(), result, 0.001);

	}

	private static Stream<Arguments> providePointZeroData() {
		return Stream.of(Arguments.of(7, 3, 7.6158), Arguments.of(-7, 3, 7.6158),
				Arguments.of(-7, 3, 7.6158), Arguments.of(-7, -3, 7.6158));
	}
}
