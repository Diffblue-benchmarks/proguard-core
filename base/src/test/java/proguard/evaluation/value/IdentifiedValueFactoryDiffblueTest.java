package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.ParticularReferenceValueFactory;

class IdentifiedValueFactoryDiffblueTest {
  /**
   * Test {@link IdentifiedValueFactory#IdentifiedValueFactory()}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#IdentifiedValueFactory()}
   */
  @Test
  @DisplayName("Test new IdentifiedValueFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IdentifiedValueFactory.<init>()"})
  void testNewIdentifiedValueFactory() {
    // Arrange, Act and Assert
    assertTrue(
        new IdentifiedValueFactory().referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Test {@link IdentifiedValueFactory#IdentifiedValueFactory(ValueFactory)}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#IdentifiedValueFactory(ValueFactory)}
   */
  @Test
  @DisplayName("Test new IdentifiedValueFactory(ValueFactory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IdentifiedValueFactory.<init>(ValueFactory)"})
  void testNewIdentifiedValueFactory2() {
    // Arrange, Act and Assert
    assertTrue(
        new IdentifiedValueFactory(new ParticularReferenceValueFactory()).referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link IdentifiedValueFactory#IdentifiedValueFactory(ValueFactory, ValueFactory)}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#IdentifiedValueFactory(ValueFactory,
   * ValueFactory)}
   */
  @Test
  @DisplayName("Test new IdentifiedValueFactory(ValueFactory, ValueFactory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IdentifiedValueFactory.<init>(ValueFactory, ValueFactory)"})
  void testNewIdentifiedValueFactory3() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act
    IdentifiedValueFactory actualIdentifiedValueFactory =
        new IdentifiedValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());

    // Assert
    assertTrue(
        actualIdentifiedValueFactory.referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link IdentifiedValueFactory#createIntegerValue()}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createIntegerValue()}
   */
  @Test
  @DisplayName("Test createIntegerValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IdentifiedValueFactory.createIntegerValue()"})
  void testCreateIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = new IdentifiedValueFactory().createIntegerValue();

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link IdentifiedValueFactory#createLongValue()}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createLongValue()}
   */
  @Test
  @DisplayName("Test createLongValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IdentifiedValueFactory.createLongValue()"})
  void testCreateLongValue() {
    // Arrange and Act
    LongValue actualCreateLongValueResult = new IdentifiedValueFactory().createLongValue();

    // Assert
    assertTrue(actualCreateLongValueResult instanceof IdentifiedLongValue);
    assertFalse(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Test {@link IdentifiedValueFactory#createFloatValue()}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createFloatValue()}
   */
  @Test
  @DisplayName("Test createFloatValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue IdentifiedValueFactory.createFloatValue()"})
  void testCreateFloatValue() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult = new IdentifiedValueFactory().createFloatValue();

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof IdentifiedFloatValue);
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertFalse(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Test {@link IdentifiedValueFactory#createDoubleValue()}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createDoubleValue()}
   */
  @Test
  @DisplayName("Test createDoubleValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue IdentifiedValueFactory.createDoubleValue()"})
  void testCreateDoubleValue() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult = new IdentifiedValueFactory().createDoubleValue();

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof IdentifiedDoubleValue);
    assertFalse(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean)} with
   * {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean)} with
   * {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue(null, new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();
    LibraryMethod creationMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, creationClass, creationMethod, 1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();
    LibraryMethod creationMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue(
            null, referencedClass, true, true, creationClass, creationMethod, 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();
    LibraryMethod creationMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, creationClass, creationMethod, 1, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();
    LibraryMethod creationMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue(
            null, referencedClass, true, true, creationClass, creationMethod, 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue("Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValue(String, Clazz, boolean, boolean, Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        identifiedValueFactory.createReferenceValue(null, new LibraryClass(), true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        identifiedValueFactory.createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        identifiedValueFactory.createReferenceValueForId(
            null, new LibraryClass(), true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertEquals(Value.NEVER, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        identifiedValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id", "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        identifiedValueFactory.createReferenceValueForId(
            null, new LibraryClass(), true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertEquals(Value.NEVER, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        identifiedValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    assertTrue(
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory
            instanceof IdentifiedValueFactory);
    assertTrue(
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        identifiedValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    assertNull(actualCreateArrayReferenceValueResult.getType());
    assertNull(actualCreateArrayReferenceValueResult.getReferencedClass());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNull());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNotNull());
  }

  /**
   * Test {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue IdentifiedValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength3() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory
            instanceof DetailedArrayValueFactory);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    assertTrue(
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }
}
