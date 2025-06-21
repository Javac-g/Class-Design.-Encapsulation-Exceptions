package jom.com.softserve.s1.task5;

class Task5Test {

	final private static String PLANT = "jom.com.softserve.s1.task5.Plant";
	final private static String COLOR_ENUM = "jom.com.softserve.s1.task5.Color";
	final private static String TYPE_ENUM = "jom.com.softserve.s1.task5.Type";
	final private static String COLOR_EXCEPTION = "jom.com.softserve.s1.task5.ColorException";
	final private static String TYPE_EXCEPTION = "jom.com.softserve.s1.task5.TypeException";

	@DisplayName("Check that a class is present")
	@ParameterizedTest
	@MethodSource("provideClass")
	void isTypeClass() {
		try {
			assertNotNull(Class.forName(PLANT));
			assertEquals("Plant", Class.forName(PLANT).getSimpleName());
		} catch (ClassNotFoundException e) {
			fail("There is no Plant class");
		}
	}

	private static Stream<Arguments> provideClass() {
		return Stream.of(Arguments.of(PLANT), Arguments.of(TYPE_EXCEPTION), Arguments.of(COLOR_EXCEPTION));
	}

	@DisplayName("Check that a class extends Exception class")
	@ParameterizedTest
	@MethodSource("provideExceptionClass")
	void extendsTypeClass(String className) {
		try {
			Class<?> parentClazz = Class.forName("java.lang.Exception");
			Class<?> childClazz = Class.forName(className);
			assertTrue(parentClazz.isAssignableFrom(childClazz));
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	private static Stream<Arguments> provideExceptionClass() {
		return Stream.of(Arguments.of(TYPE_EXCEPTION), Arguments.of(COLOR_EXCEPTION));
	}

	@DisplayName("Check that enum is present")
	@ParameterizedTest
	@MethodSource("provideEnum")
	public void isTypeEnum(String enumName) {
		try {
			Class<?> clazz = Class.forName(enumName);
			assertTrue(clazz.isEnum());
		} catch (ClassNotFoundException e) {
			fail("There is no " + enumName + " enum");
		}
	}

	private static Stream<Arguments> provideEnum() {
		return Stream.of(Arguments.of(COLOR_ENUM), Arguments.of(TYPE_ENUM));
	}

	@DisplayName("Check that a field is present")
	@ParameterizedTest
	@MethodSource("provideField")
	public void hasTypeDeclaredField(String name, String fieldName) {
		try {
			Class<?> clazz = Class.forName(name);
			Field[] fields = clazz.getDeclaredFields();
			boolean isField = false;
			for (Field field : fields) {
				if (fieldName.equals(field.getName())) {
					isField = true;
				}
			}
			assertTrue(isField);
		} catch (ClassNotFoundException e) {
			fail("There is no " + name + " enum");
		}
	}

	private static Stream<Arguments> provideField() {
		return Stream.of(Arguments.of(COLOR_ENUM, "WHITE"), Arguments.of(COLOR_ENUM, "RED"),
				Arguments.of(COLOR_ENUM, "BLUE"), Arguments.of(TYPE_ENUM, "RARE"), Arguments.of(TYPE_ENUM, "ORDINARY"),
				Arguments.of(PLANT, "name"), Arguments.of(PLANT, "color"), Arguments.of(PLANT, "type"));
	}

	@DisplayName("Check that a class has a constructor")
	@ParameterizedTest
	@MethodSource("provideConstructor")
	public void hasTypeDeclaredConstructor(String className, Class<?>[] params) {

		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				Class<?>[] types = constructor.getParameterTypes();
				assertTrue(Arrays.equals(types, params));
			}
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}
	}

	private static Stream<Arguments> provideConstructor() {
		return Stream.of(Arguments.of(COLOR_EXCEPTION, new Class[] { String.class }),
				Arguments.of(TYPE_EXCEPTION, new Class[] { String.class }),
				Arguments.of(PLANT, new Class[] { String.class, String.class, String.class }));
	}

	@DisplayName("Check that a class has a properly type of fields")
	@ParameterizedTest
	@MethodSource("provideFieldType")
	void checkFieldType(String classType, String fieldName, Class<?> fieldType) {
		try {
			Class<?> clazz = Class.forName(classType);

			Field[] declaredFields = clazz.getDeclaredFields();
			boolean isField = false;
			for (Field field : declaredFields) {
				if (fieldName.equals(field.getName())) {
					assertEquals(field.getType(), fieldType);
					isField = true;
				}
			}
			assertTrue(isField);
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		}

	}

	private static Stream<Arguments> provideFieldType() {
		return Stream.of(Arguments.of(PLANT, "name", String.class), Arguments.of(PLANT, "color", COLOR_ENUM),
				Arguments.of(PLANT, "type", TYPE_ENUM));
	}

	@DisplayName("Check that 'toString' method is overriden in class Plant")
	@Test
	void overridesTypeMethod() {
		try {
			Class<?> parentClass = Class.forName("java.lang.Object");
			Class<?> childClass = Class.forName(PLANT);
			Method childMethod = childClass.getDeclaredMethod("toString");
			Method parentMethod = parentClass.getDeclaredMethod("toString");
			assertTrue(equalParamTypes(parentMethod.getParameterTypes(), childMethod.getParameterTypes()));
		} catch (ClassNotFoundException e) {
			fail("There is no such class");
		} catch (NoSuchMethodException e) {
			fail("There is no such method");
		}
	}

	private static boolean equalParamTypes(final Class<?>[] params1, final Class<?>[] params2) {
		if (params1.length == params2.length) {
			for (int i = 0; i < params1.length; ++i) {
				if (params1[i] != params2[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@DisplayName("Check creating a plant with valid fields")
	@Test
	void createsObjectConstructor() {
		try {
			for (final Color color : Color.values()) {
				final Type[] values2 = Type.values();
				for (int length2 = values2.length, j = 0; j < length2; ++j) {
					assertNotNull(new Plant(values2[j].toString(), color.toString(), "MyPlant"));
				}
			}
		} catch (TypeException | ColorException ex) {
			fail("Plant object is not created");
		}
	}

	@DisplayName("Check that exception is thrown when creating a plant with invalid color or type")
	@ParameterizedTest
	@MethodSource("provideEceptionData")
	void generatesConstructorColorException(Class exceptionClass, String name, String color, String type,
			String message) {

		assertThrows(exceptionClass, () -> {
			new Plant(type, color, name);
		}, message);

	}

	private static Stream<Arguments> provideEceptionData() {
		return Stream.of(
				Arguments.of(TYPE_EXCEPTION, "someType", "blue", "NewType", "Plant with such type is not created"),
				Arguments.of(COLOR_EXCEPTION, "someType", "NewColor", "rare", "Plant with such color is not created"));
	}

	@DisplayName("Check creating of a plant with valid fields")
	@Test
	void toStringTest() {

		final String s = "MyPlant";
		final String s2 = "White";
		final String s3 = "Ordinary";
		try {
			assertEquals(new Plant(s3, s2, s).toString(), String.format("{type: %s, color: %s, name: %s}",
					Type.ORDINARY.toString(), Color.WHITE.toString(), s));
		} catch (Exception ex) {
			fail("Plant with valid field is not created");
		}
	}
}
