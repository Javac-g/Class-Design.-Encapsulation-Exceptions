package jom.com.softserve.s1.task6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task6Test {

	final private static String PLANT = "jom.com.softserve.s1.task6.Plant";

	@DisplayName("Check that Plant class has 'tryCreatePlant' method")
	@Test
	void hasTypeDeclaredMethod() {
		try {
			Class<?> clazz = Class.forName(PLANT);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method m : methods) {
				if ("tryCreatePlant".equals(m.getName())) {
					assertTrue(Arrays.equals(new Class[] { String.class, String.class, String.class },
							m.getParameterTypes()));
					isMethod = true;
					break;
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no Plant class");
		}
	}

	@DisplayName("Check that 'tryCreatePlant' method returns object of Plant type")
	@Test
	void hasMethodReturnType() {
		try {
			Class<?> clazz = Class.forName(PLANT);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method method : methods) {
				if ("tryCreatePlant".equals(method.getName())) {
					assertEquals(method.getReturnType(), Plant.class);
					isMethod = true;
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no Plant class");
		}
	}

	@DisplayName("Check that 'tryCreatePlant' method is static")
	@Test
	void isMethodStatic() {
		try {
			Class<?> clazz = Class.forName(PLANT);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method method : methods) {
				if ("tryCreatePlant".equals(method.getName())) {
					assertTrue(Modifier.isStatic(method.getModifiers()));
					isMethod = true;
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no Plant class");
		}
	}

	@DisplayName("Check that 'tryCreatePlant' method returns valid plant")
	@ParameterizedTest
	@MethodSource("providePlantData")
	void isCorrectPlantCreated(String type, String color, String name) {
		assertNotNull(Plant.tryCreatePlant(type, color, name));
	}

	private static Stream<Arguments> providePlantData() {
		return Stream.of(Arguments.of("Rare", "MyColor", "MyName"), Arguments.of("MyType", "Red", "MyName"),
				Arguments.of("MyType", "MyColor", "MyName"));
	}
}
