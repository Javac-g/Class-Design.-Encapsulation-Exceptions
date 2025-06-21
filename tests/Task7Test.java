package jom.com.softserve.s1.task7;

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

class Task7Test {

	final private static String CLASS = "jom.com.softserve.s1.task7.InsufficientAmountException";

	@DisplayName("Check that InsufficientAmountException class is present")
	@Test
	void isTypeClass() {
		try {
			Class<?> clazz = Class.forName(CLASS);
			assertTrue(clazz.getSimpleName().equals("InsufficientAmountException"));
		} catch (ClassNotFoundException e) {
			fail("There is no InsufficientAmountException class");
		}
	}

	@DisplayName("Check that InsufficientAmountException class extends Exception class")
	@Test
	void extendsTypeClass() {
		try {
			final Class<?> parentClazz = Class.forName("java.lang.Exception");
			final Class<?> childClazz = Class.forName(CLASS);
			assertTrue(parentClazz.isAssignableFrom(childClazz));
		} catch (ClassNotFoundException e) {
			fail("There is no InsufficientAmountException class");
		}
	}

	@DisplayName("Check that InsufficientAmountException class has 'amount' field")
	@Test
	void hasTypeDeclaredField() {
		try {
			Class<?> clazz = Class.forName(CLASS);
			assertNotNull(clazz.getDeclaredField("amount"));
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		} catch (NoSuchFieldException e) {
			fail("There is no 'amount' field");
		}
	}

	@DisplayName("Check that 'amount' field is double")
	@Test
	void hasFieldType() {
		try {
			Class<?> clazz = Class.forName(CLASS);
			Field field = clazz.getDeclaredField("amount");
			assertNotNull(field);
			assertTrue(field.getType().equals(double.class));
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		} catch (NoSuchFieldException e) {
			fail("There is no 'amount' field");
		}
	}

	@DisplayName("Check that InsufficientAmountException class has a constructor")
	@Test
	void isConstructor() {
		try {
			Class<?> clazz = Class.forName(CLASS);
			Constructor<?>[] constructors = clazz.getConstructors();
			boolean isConstructor = false;
			for (Constructor<?> constructor : constructors) {
				Class<?>[] types = constructor.getParameterTypes();
				if (Arrays.equals(types, new Class[] { double.class })) {
					isConstructor = true;
				}
			}
			assertTrue(isConstructor);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	@DisplayName("Check that InsufficientAmountException class has a properly methods")
	@ParameterizedTest
	@MethodSource("provideMethod")
	void hasTypeDeclaredMethod(String methodName, Class[] paramTypes) {
		try {
			Class<?> clazz = Class.forName(CLASS);
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

	private static Stream<Arguments> provideMethod() {
		return Stream.of(Arguments.of("getMessage", new Class[] {}), Arguments.of("getAmount", new Class[] {}));
	}

	@DisplayName("Check that InsufficientAmountException class has a constructor")
	@Test
	void verifyMessage() {
		CheckingAccount c = new CheckingAccount(101);
		c.deposit(370.00);
		try {
			c.withdraw(90.00);
			c.withdraw(300.00);
		} catch (InsufficientAmountException e) {
			assertEquals(e.getMessage(), "Sorry, but you are short $20.0");
		}
	}
}
