package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;

class ParticularValueFactoryDiffblueTest {
  /**
   * Test {@link ParticularValueFactory#ParticularValueFactory(ValueFactory)}.
   *
   * <p>Method under test: {@link ParticularValueFactory#ParticularValueFactory(ValueFactory)}
   */
  @Test
  @DisplayName("Test new ParticularValueFactory(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.ParticularValueFactory.<init>(proguard.evaluation.value.ValueFactory)",
    "void proguard.evaluation.value.ParticularValueFactory.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.value.ValueFactory)"
  })
  void testNewParticularValueFactory() {
    // Arrange, Act and Assert
    assertTrue(
        (new ParticularValueFactory(new ParticularReferenceValueFactory())).referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link ParticularValueFactory#ParticularValueFactory(ValueFactory, ValueFactory)}.
   *
   * <p>Method under test: {@link ParticularValueFactory#ParticularValueFactory(ValueFactory,
   * ValueFactory)}
   */
  @Test
  @DisplayName("Test new ParticularValueFactory(ValueFactory, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.ParticularValueFactory.<init>(proguard.evaluation.value.ValueFactory)",
    "void proguard.evaluation.value.ParticularValueFactory.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.value.ValueFactory)"
  })
  void testNewParticularValueFactory2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();

    // Act and Assert
    assertTrue(
        (new ParticularValueFactory(
                    arrayReferenceValueFactory, new ParticularReferenceValueFactory()))
                .referenceValueFactory
            instanceof ParticularReferenceValueFactory);
  }

  /**
   * Test {@link ParticularValueFactory#ParticularValueFactory()}.
   *
   * <p>Method under test: {@link ParticularValueFactory#ParticularValueFactory()}
   */
  @Test
  @DisplayName("Test new ParticularValueFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.value.ParticularValueFactory.<init>()"})
  void testNewParticularValueFactory3() {
    // Arrange, Act and Assert
    assertTrue(
        (new ParticularValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_0() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_0, particularValueFactory.createIntegerValue(0));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_1}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_1() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_1, particularValueFactory.createIntegerValue(1));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_2}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_2")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_2() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_2, particularValueFactory.createIntegerValue(2));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_3}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_3")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_3, particularValueFactory.createIntegerValue(3));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_4}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_4")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_4() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_4, particularValueFactory.createIntegerValue(4));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_5}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_5")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_5() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_5, particularValueFactory.createIntegerValue(5));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; then return ParticularValueFactory() INTEGER_VALUE_M1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_thenReturnParticularValueFactoryInteger_value_m1() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.INTEGER_VALUE_M1,
        particularValueFactory.createIntegerValue(Value.NEVER));
  }

  /**
   * Test {@link ParticularValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int) with 'value'; when forty-two; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue_whenFortyTwo_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new ParticularValueFactory()).createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(42, actualCreateIntegerValueResult.value());
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertTrue(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link ParticularValueFactory#createLongValue(long)} with {@code long}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createLongValue(long)}
   */
  @Test
  @DisplayName(
      "Test createLongValue(long) with 'long'; then return ParticularValueFactory() LONG_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularValueFactory.createLongValue(long)"
  })
  void testCreateLongValueWithLong_thenReturnParticularValueFactoryLong_value_0() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.LONG_VALUE_0, particularValueFactory.createLongValue(0L));
  }

  /**
   * Test {@link ParticularValueFactory#createLongValue(long)} with {@code long}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createLongValue(long)}
   */
  @Test
  @DisplayName(
      "Test createLongValue(long) with 'long'; when forty-two; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularValueFactory.createLongValue(long)"
  })
  void testCreateLongValueWithLong_whenFortyTwo_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualCreateLongValueResult = (new ParticularValueFactory()).createLongValue(42L);

    // Assert
    assertTrue(actualCreateLongValueResult instanceof ParticularLongValue);
    assertEquals(42L, actualCreateLongValueResult.value());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Test {@link ParticularValueFactory#createLongValue(long)} with {@code long}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#LONG_VALUE_1}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createLongValue(long)}
   */
  @Test
  @DisplayName(
      "Test createLongValue(long) with 'long'; when one; then return ParticularValueFactory() LONG_VALUE_1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularValueFactory.createLongValue(long)"
  })
  void testCreateLongValueWithLong_whenOne_thenReturnParticularValueFactoryLong_value_1() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.LONG_VALUE_1, particularValueFactory.createLongValue(1L));
  }

  /**
   * Test {@link ParticularValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#FLOAT_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  @DisplayName(
      "Test createFloatValue(float) with 'float'; then return ParticularValueFactory() FLOAT_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.ParticularValueFactory.createFloatValue(float)"
  })
  void testCreateFloatValueWithFloat_thenReturnParticularValueFactoryFloat_value_0() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.FLOAT_VALUE_0, particularValueFactory.createFloatValue(0.0f));
  }

  /**
   * Test {@link ParticularValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#FLOAT_VALUE_1}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  @DisplayName(
      "Test createFloatValue(float) with 'float'; then return ParticularValueFactory() FLOAT_VALUE_1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.ParticularValueFactory.createFloatValue(float)"
  })
  void testCreateFloatValueWithFloat_thenReturnParticularValueFactoryFloat_value_1() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.FLOAT_VALUE_1, particularValueFactory.createFloatValue(1.0f));
  }

  /**
   * Test {@link ParticularValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#FLOAT_VALUE_2}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  @DisplayName(
      "Test createFloatValue(float) with 'float'; then return ParticularValueFactory() FLOAT_VALUE_2")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.ParticularValueFactory.createFloatValue(float)"
  })
  void testCreateFloatValueWithFloat_thenReturnParticularValueFactoryFloat_value_2() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.FLOAT_VALUE_2, particularValueFactory.createFloatValue(2.0f));
  }

  /**
   * Test {@link ParticularValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  @DisplayName(
      "Test createFloatValue(float) with 'float'; when ten; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.ParticularValueFactory.createFloatValue(float)"
  })
  void testCreateFloatValueWithFloat_whenTen_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult =
        (new ParticularValueFactory()).createFloatValue(10.0f);

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualCreateFloatValueResult.value());
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertTrue(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Test {@link ParticularValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#DOUBLE_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createDoubleValue(double)}
   */
  @Test
  @DisplayName(
      "Test createDoubleValue(double) with 'double'; then return ParticularValueFactory() DOUBLE_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.ParticularValueFactory.createDoubleValue(double)"
  })
  void testCreateDoubleValueWithDouble_thenReturnParticularValueFactoryDouble_value_0() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.DOUBLE_VALUE_0, particularValueFactory.createDoubleValue(0.0d));
  }

  /**
   * Test {@link ParticularValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       ParticularValueFactory#DOUBLE_VALUE_1}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createDoubleValue(double)}
   */
  @Test
  @DisplayName(
      "Test createDoubleValue(double) with 'double'; then return ParticularValueFactory() DOUBLE_VALUE_1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.ParticularValueFactory.createDoubleValue(double)"
  })
  void testCreateDoubleValueWithDouble_thenReturnParticularValueFactoryDouble_value_1() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.DOUBLE_VALUE_1, particularValueFactory.createDoubleValue(1.0d));
  }

  /**
   * Test {@link ParticularValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createDoubleValue(double)}
   */
  @Test
  @DisplayName(
      "Test createDoubleValue(double) with 'double'; when ten; then return ParticularDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.ParticularValueFactory.createDoubleValue(double)"
  })
  void testCreateDoubleValueWithDouble_whenTen_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult =
        (new ParticularValueFactory()).createDoubleValue(10.0d);

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualCreateDoubleValueResult.value());
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue()}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue()}
   */
  @Test
  @DisplayName("Test createReferenceValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue()"
  })
  void testCreateReferenceValue() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());

    // Act and Assert
    assertSame(
        basicRangeValueFactory.REFERENCE_VALUE, basicRangeValueFactory.createReferenceValue());
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(Clazz, boolean,
   * boolean, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(Clazz, boolean,
   * boolean, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    ParticularValueFactory particularValueFactory =
        new ParticularValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(Clazz, boolean,
   * boolean, CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(Clazz, boolean,
   * boolean, CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    ParticularValueFactory particularValueFactory =
        new ParticularValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean)} with
   * {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean)} with
   * {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1);

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject3() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new PrimitiveTypedReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        basicRangeValueFactory.REFERENCE_VALUE,
        basicRangeValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value"));
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        particularValueFactory.createReferenceValue("Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue("Type", referencedClass, true, true, "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean,
   * Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject3() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new PrimitiveTypedReferenceValueFactory());

    // Act and Assert
    assertSame(
        basicRangeValueFactory.REFERENCE_VALUE,
        basicRangeValueFactory.createReferenceValue(
            "Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValue()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#ParticularValueFactory()} {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValue()}
   */
  @Test
  @DisplayName("Test createReferenceValue(); then return ParticularValueFactory() REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValue()"
  })
  void testCreateReferenceValue_thenReturnParticularValueFactoryReference_value() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(
        particularValueFactory.REFERENCE_VALUE, particularValueFactory.createReferenceValue());
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueNull()}.
   *
   * <ul>
   *   <li>Then return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueNull()}
   */
  @Test
  @DisplayName("Test createReferenceValueNull(); then return TypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueNull()"
  })
  void testCreateReferenceValueNull_thenReturnTypedReferenceValue() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult =
        (new ParticularValueFactory()).createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof TypedReferenceValue);
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertEquals(1, actualCreateReferenceValueNullResult.isNull());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(actualCreateReferenceValueNullResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueNullResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueNullResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueNullResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueNullResult.isNotNull());
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularValueFactory.createReferenceValueForId(referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    ParticularValueFactory particularValueFactory =
        new ParticularValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularValueFactory.createReferenceValueForId(referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularValueFactory.createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        basicRangeValueFactory.createReferenceValueForId("Type", referencedClass, true, true, "Id");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        particularValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id", "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(arrayReferenceValueFactory, new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        basicRangeValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id", "Value");

    // Assert
    Clazz referencedClass2 = actualCreateReferenceValueForIdResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue3() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new PrimitiveTypedReferenceValueFactory());

    // Act and Assert
    assertSame(
        basicRangeValueFactory.REFERENCE_VALUE,
        basicRangeValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        particularValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[Type", modeledOrNullValue.getType());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength3() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[", modeledOrNullValue.getType());
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength4() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    IntegerValue integerValue =
        ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    assertTrue(values[0] instanceof TypedReferenceValue);
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals(1, integerValue.value());
    assertEquals(1, values.length);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength5() {
    // Arrange
    BasicRangeValueFactory arrayReferenceValueFactory = new BasicRangeValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        basicRangeValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength6() {
    // Arrange
    DetailedArrayValueFactory arrayReferenceValueFactory = new DetailedArrayValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        basicRangeValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[Type", modeledOrNullValue.getType());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.ParticularValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        particularValueFactory.createArrayReferenceValue(
            "Type", referencedClass, ParticularValueFactory.INTEGER_VALUE_0, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    assertTrue(
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof ParticularIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }
}
