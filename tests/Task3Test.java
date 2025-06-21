package jom.com.softserve.s1.task3;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task3Test {

	final private static String PRODUCT = "";

	@DisplayName("Check that Product class is present")
	@Test
	void isTypeClass() {
		try {
			assertNotNull(Class.forName(PRODUCT));
			assertEquals("Product", Class.forName(PRODUCT).getSimpleName());
		} catch (ClassNotFoundException e) {
			fail("There is no class Product");
		}
	}

	@DisplayName("Check that Product class has a constructor")
	@Test
	void hasProductClassConstructorTest() {
		try {
			Class<?> clazz = Class.forName(PRODUCT);
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			assertNotNull(constructors);
		} catch (ClassNotFoundException e) {
			fail("There is no class Product");
		}
	}

	@DisplayName("Check that Product class has private constructor")
	@Test
	void hasProductClassPublicConstructorTest() {
		try {
			Class<?> clazz = Class.forName(PRODUCT);
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			boolean isPrivateConstructor;
			for (Constructor<?> constructor : constructors) {
				isPrivateConstructor = false;
				if (Modifier.isPublic(constructor.getModifiers())) {
					isPrivateConstructor = true;
				}
				assertTrue(isPrivateConstructor);
			}
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException or there is no public constructor");
		}
	}

	@DisplayName("Check that field is present and private")
	@ParameterizedTest
	@MethodSource("provideDataForMethod")
	void isFieldPrivateTest(String fieldName) {
		try {
			Class<?> clazz = Class.forName(PRODUCT);
			Field[] declaredFields = clazz.getDeclaredFields();
			boolean isField = false;
			for (Field field : declaredFields) {
				if (fieldName.equals(field.getName())) {
					assertTrue(Modifier.isPrivate(field.getModifiers()));
					isField = true;
				}
			}
			assertTrue(isField);
		} catch (ClassNotFoundException e) {
			fail("There is no Product class");
		}
	}

	@DisplayName("Check type of field")
	@ParameterizedTest
	@MethodSource("provideDataForMethod")
	void hasFieldType(String fieldName, Class type) {
		try {
			Class<?> clazz = Class.forName(PRODUCT);
			Field field = clazz.getDeclaredField(fieldName);
			assertTrue(Modifier.isPrivate(field.getModifiers()));
		} catch (ClassNotFoundException e) {
			fail("There is no Product class");
		} catch (NoSuchFieldException e) {
			fail("There is no such field");
		}
	}

	private static Stream<Arguments> provideDataForMethod() {
		return Stream.of(Arguments.of("name", String.class), Arguments.of("price", double.class));
	}

	@DisplayName("Check that return type of a method")
	@ParameterizedTest
	@MethodSource("provideDataForReturnTypeMethod")
	void hasMethodReturnType(String methodName, Class type) {
		Method[] methods = null;
		try {
			methods = Class.forName(PRODUCT).getDeclaredMethods();
		} catch (ClassNotFoundException e) {
			fail("There is no Product class");
		}
		boolean isMethod = false;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				isMethod = true;
				assertEquals(method.getReturnType(), type);
				break;
			}
		}
		assertTrue(isMethod);
	}

	private static Stream<Arguments> provideDataForReturnTypeMethod() {
		return Stream.of(Arguments.of("setPrice", void.class), Arguments.of("count", int.class),
				Arguments.of("getPrice", double.class), Arguments.of("getName", String.class),
				Arguments.of("setPrice", void.class), Arguments.of("setName", void.class));
	}

	@DisplayName("Check that Product class contains a method")
	@ParameterizedTest
	@MethodSource("provideDataMethod")
	void hasTypeDeclaredMethod(String methodName, Class[] params) {
		Method[] methods = null;
		try {
			methods = Class.forName(PRODUCT).getDeclaredMethods();
		} catch (ClassNotFoundException e) {
			fail("There is no Product class");
		}
		boolean isMethod = false;
		for (Method method : methods) {
			if (method.getName().equals(methodName) && Arrays.equals(params, method.getParameterTypes())) {
				isMethod = true;
				break;
			}
		}
		assertTrue(isMethod);
	}

	private static Stream<Arguments> provideDataMethod() {
		return Stream.of(Arguments.of("setName", new Class[] { String.class }),
				Arguments.of("setPrice", new Class[] { double.class }), Arguments.of("getName", new Class[] {}),
				Arguments.of("count", new Class[] {}), Arguments.of("getPrice", new Class[] {}));
	}

	@DisplayName("Check that 'count' method is static")
	@Test
	void isCountMethodStatic() {
		try {
			Class<?> clazz = Class.forName(PRODUCT);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method method : methods) {
				if ("count".equals(method.getName()) && Modifier.isStatic(method.getModifiers())) {
					isMethod = true;
					break;
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	@DisplayName("Check that a method is public")
	@ParameterizedTest
	@MethodSource("provideDataMethod")
	void isMethodPublic(String methodName) {
		try {
			Class<?> clazz = Class.forName(PRODUCT);
			Method[] methods = clazz.getDeclaredMethods();
			boolean isMethod = false;
			for (Method method : methods) {
				if ("count".equals(method.getName()) && Modifier.isPublic(method.getModifiers())) {
					isMethod = true;
					break;
				}
			}
			assertTrue(isMethod);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	@DisplayName("Check count of ceating products")
	@Test
	void countOfCreatedProductsTest() {
		Product pr1 = new Product();
		Product pr2 = new Product("Car", 15000);
		assertTrue(Product.count() == 2);

	}
}
