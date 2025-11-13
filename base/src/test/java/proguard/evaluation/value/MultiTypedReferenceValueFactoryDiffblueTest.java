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
import proguard.classfile.kotlin.KotlinConstants;

class MultiTypedReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link MultiTypedReferenceValueFactory#createReferenceValueNull()}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  @DisplayName("Test createReferenceValueNull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue MultiTypedReferenceValueFactory.createReferenceValueNull()"})
  void testCreateReferenceValueNull() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult =
        new MultiTypedReferenceValueFactory().createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof MultiTypedReferenceValue);
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult)
            .getPotentialTypes()
            .size());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(actualCreateReferenceValueNullResult.isParticular());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).mayBeUnknown);
    assertEquals(Value.NEVER, actualCreateReferenceValueNullResult.isNotNull());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        ((MultiTypedReferenceValue) actualCreateReferenceValueNullResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        multiTypedReferenceValueFactory.createReferenceValue(
            "Ljava/lang/Object;", new LibraryClass(), true, false);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'; then return NotNull is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean_thenReturnNotNullIsOne() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        multiTypedReferenceValueFactory.createReferenceValue(
            "Ljava/lang/Object;", referencedClass, false, false);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return NotNull is zero.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'; then return NotNull is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean_thenReturnNotNullIsZero() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        multiTypedReferenceValueFactory.createReferenceValue(
            "Ljava/lang/Object;", new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'; then return Type is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean_thenReturnTypeIsNull() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        multiTypedReferenceValueFactory.createReferenceValue(
            null, new LibraryClass(), false, false);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertNull(actualCreateReferenceValueResult.getType());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'; when 'Type'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean_whenType_thenReturnType() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        multiTypedReferenceValueFactory.createReferenceValue(
            "Type", new LibraryClass(), true, true);

    // Assert
    Clazz referencedClass = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateReferenceValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        multiTypedReferenceValueFactory.createArrayReferenceValue(
            "Ljava/lang/Object;", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getGeneralizedType();
    assertEquals("[Ljava/lang/Object;", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        multiTypedReferenceValueFactory.createArrayReferenceValue(
            "Ljava/lang/Object;", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getGeneralizedType();
    assertEquals("[Ljava/lang/Object;", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength3() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        multiTypedReferenceValueFactory.createArrayReferenceValue(
            "[Ljava/lang/Object;", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[[Ljava/lang/Object;", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getGeneralizedType();
    assertEquals("[[Ljava/lang/Object;", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        multiTypedReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(
        1,
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult)
            .getPotentialTypes()
            .size());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeUnknown);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <ul>
   *   <li>Then return {@code [Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'; then return '[Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength_thenReturnType() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        multiTypedReferenceValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getGeneralizedType();
    assertEquals("[Type", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <ul>
   *   <li>Then return {@code [Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'; then return '[Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue MultiTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength_thenReturnType2() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        multiTypedReferenceValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof MultiTypedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateArrayReferenceValueResult).getGeneralizedType();
    assertEquals("[Type", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName("Test createValue(String, Clazz, boolean, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue(
            "Ljava/lang/Object;", new LibraryClass(), true, false);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL,
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Given {@link MultiTypedReferenceValueFactory#MultiTypedReferenceValueFactory()}.
   *   <li>When {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); given MultiTypedReferenceValueFactory(); when 'Type'; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_givenMultiTypedReferenceValueFactory_whenType_thenReturnType() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue("Type", new LibraryClass(), true, true);

    // Assert
    Clazz referencedClass =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return ReferencedClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); then return ReferencedClass is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_thenReturnReferencedClassIsNull() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue(
            "Ljava/lang/Object;", new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertNull(((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName("Test createValue(String, Clazz, boolean, boolean); then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_thenReturnType() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory(
            true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue("Type", new LibraryClass(), true, true);

    // Assert
    Clazz referencedClass =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", ((MultiTypedReferenceValue) actualCreateValueResult).getType());
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return GeneralizedType NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); when 'false'; then return GeneralizedType NotNull is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_whenFalse_thenReturnGeneralizedTypeNotNullIsOne() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue("Type", new LibraryClass(), true, false);

    // Assert
    Clazz referencedClass =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertEquals(1, generalizedType.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCreateValueResult).isNotNull());
    assertFalse(generalizedType.mayBeNull);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return not GeneralizedType mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); when 'false'; then return not GeneralizedType mayBeExtension")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_whenFalse_thenReturnNotGeneralizedTypeMayBeExtension() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue("Type", new LibraryClass(), false, true);

    // Assert
    Clazz referencedClass =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(generalizedType.mayBeExtension);
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Object;}.
   *   <li>Then return not GeneralizedType mayBeExtension.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); when 'Ljava/lang/Object;'; then return not GeneralizedType mayBeExtension")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_whenLjavaLangObject_thenReturnNotGeneralizedTypeMayBeExtension() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue(
            "Ljava/lang/Object;", new LibraryClass(), false, true);

    // Assert
    Clazz referencedClass =
        ((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    TypedReferenceValue generalizedType =
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType();
    assertFalse(generalizedType.mayBeExtension());
    assertFalse(generalizedType.mayBeExtension);
    assertSame(referencedClass, generalizedType.getReferencedClass());
  }

  /**
   * Test {@link MultiTypedReferenceValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Ljava/lang/Object;}.
   *   <li>Then return ReferencedClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTypedReferenceValueFactory#createValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); when 'Ljava/lang/Object;'; then return ReferencedClass is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value MultiTypedReferenceValueFactory.createValue(String, Clazz, boolean, boolean)"
  })
  void testCreateValue_whenLjavaLangObject_thenReturnReferencedClassIsNull() {
    // Arrange
    MultiTypedReferenceValueFactory multiTypedReferenceValueFactory =
        new MultiTypedReferenceValueFactory();

    // Act
    Value actualCreateValueResult =
        multiTypedReferenceValueFactory.createValue(
            "Ljava/lang/Object;", new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof MultiTypedReferenceValue);
    assertNull(((MultiTypedReferenceValue) actualCreateValueResult).getReferencedClass());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
        ((MultiTypedReferenceValue) actualCreateValueResult).getGeneralizedType());
  }
}
