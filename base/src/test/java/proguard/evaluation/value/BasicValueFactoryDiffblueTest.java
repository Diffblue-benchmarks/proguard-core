package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ClassLoaderModel;

class BasicValueFactoryDiffblueTest {
  /**
   * Test {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); then ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.BasicValueFactory.createValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult =
        arrayReferenceValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    Clazz referencedClass2 = ((TypedReferenceValue) actualCreateValueResult).getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateValueResult instanceof TypedReferenceValue);
    assertEquals("Type", ((TypedReferenceValue) actualCreateValueResult).getType());
    assertEquals(0, ((TypedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(actualCreateValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createValue(String, Clazz, boolean, boolean); then return BasicValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.BasicValueFactory.createValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateValue_thenReturnBasicValueFactoryReference_value() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue()}
   */
  @Test
  @DisplayName("Test createIntegerValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.BasicValueFactory.createIntegerValue()"
  })
  void testCreateIntegerValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue());
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int, int) with 'min', 'max'; then return BasicValueFactory (default constructor) INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.BasicValueFactory.createIntegerValue(int, int)"
  })
  void testCreateIntegerValueWithMinMax_thenReturnBasicValueFactoryInteger_value() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue(1, 3));
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue(int, int)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue(int, int)}
   */
  @Test
  @DisplayName(
      "Test createIntegerValue(int, int) with 'min', 'max'; then return IdentifiedIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.BasicValueFactory.createIntegerValue(int, int)"
  })
  void testCreateIntegerValueWithMinMax_thenReturnIdentifiedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult =
        (new DetailedArrayValueFactory()).createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link BasicValueFactory#createIntegerValue(int)} with {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createIntegerValue(int)}
   */
  @Test
  @DisplayName("Test createIntegerValue(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.BasicValueFactory.createIntegerValue(int)"
  })
  void testCreateIntegerValueWithValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue(42));
  }

  /**
   * Test {@link BasicValueFactory#createLongValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createLongValue()}
   */
  @Test
  @DisplayName("Test createLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.BasicValueFactory.createLongValue()"
  })
  void testCreateLongValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.LONG_VALUE, basicValueFactory.createLongValue());
  }

  /**
   * Test {@link BasicValueFactory#createLongValue(long)} with {@code long}.
   *
   * <p>Method under test: {@link BasicValueFactory#createLongValue(long)}
   */
  @Test
  @DisplayName("Test createLongValue(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.BasicValueFactory.createLongValue(long)"
  })
  void testCreateLongValueWithLong() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.LONG_VALUE, basicValueFactory.createLongValue(42L));
  }

  /**
   * Test {@link BasicValueFactory#createFloatValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createFloatValue()}
   */
  @Test
  @DisplayName("Test createFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.BasicValueFactory.createFloatValue()"
  })
  void testCreateFloatValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.FLOAT_VALUE, basicValueFactory.createFloatValue());
  }

  /**
   * Test {@link BasicValueFactory#createFloatValue(float)} with {@code float}.
   *
   * <p>Method under test: {@link BasicValueFactory#createFloatValue(float)}
   */
  @Test
  @DisplayName("Test createFloatValue(float) with 'float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.BasicValueFactory.createFloatValue(float)"
  })
  void testCreateFloatValueWithFloat() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.FLOAT_VALUE, basicValueFactory.createFloatValue(10.0f));
  }

  /**
   * Test {@link BasicValueFactory#createDoubleValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createDoubleValue()}
   */
  @Test
  @DisplayName("Test createDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.BasicValueFactory.createDoubleValue()"
  })
  void testCreateDoubleValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.DOUBLE_VALUE, basicValueFactory.createDoubleValue());
  }

  /**
   * Test {@link BasicValueFactory#createDoubleValue(double)} with {@code double}.
   *
   * <p>Method under test: {@link BasicValueFactory#createDoubleValue(double)}
   */
  @Test
  @DisplayName("Test createDoubleValue(double) with 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.BasicValueFactory.createDoubleValue(double)"
  })
  void testCreateDoubleValueWithDouble() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.DOUBLE_VALUE, basicValueFactory.createDoubleValue(10.0d));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue()}
   */
  @Test
  @DisplayName("Test createReferenceValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue()"
  })
  void testCreateReferenceValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValue());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, AnalyzedObject)}
   * with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertSame(basicValueFactory.REFERENCE_VALUE, actualCreateReferenceValueResult);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, AnalyzedObject)}
   * with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    when(value.getPreciseValue()).thenReturn("Precise Value");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getPreciseValue();
    verify(value).getType();
    verify(value).isModeled();
    assertSame(basicValueFactory.REFERENCE_VALUE, actualCreateReferenceValueResult);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, AnalyzedObject)}
   * with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject3() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertTrue(actualCreateReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, AnalyzedObject)}
   * with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject4() {
    // Arrange
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory();
    LibraryClass referencedClass =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertTrue(actualCreateReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, AnalyzedObject)}
   * with {@code Clazz}, {@code boolean}, {@code boolean}, {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanAnalyzedObject5() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());
    LibraryClass referencedClass =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue(referencedClass, true, true, value);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCreateReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNull());
    assertSame(value, actualCreateReferenceValueResult.getValue());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            basicValueFactory.createReferenceValue(
                referencedClass,
                true,
                true,
                new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2),
                mock(AnalyzedObject.class)));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertSame(basicValueFactory.REFERENCE_VALUE, actualCreateReferenceValueResult);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject3() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    when(value.getPreciseValue()).thenReturn("Precise Value");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value).getPreciseValue();
    verify(value).getType();
    verify(value).isModeled();
    assertSame(basicValueFactory.REFERENCE_VALUE, actualCreateReferenceValueResult);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject4() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCreateReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof ParticularReferenceValue);
    assertEquals(1, actualCreateReferenceValueResult.isNotNull());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNull());
    assertSame(value, actualCreateReferenceValueResult.getValue());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean, CodeLocation,
   * AnalyzedObject)} with {@code Clazz}, {@code boolean}, {@code boolean}, {@code CodeLocation},
   * {@code AnalyzedObject}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(Clazz, boolean, boolean,
   * CodeLocation, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(Clazz, boolean, boolean, CodeLocation, AnalyzedObject) with 'Clazz', 'boolean', 'boolean', 'CodeLocation', 'AnalyzedObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(proguard.classfile.Clazz, boolean, boolean, proguard.analysis.datastructure.CodeLocation, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueWithClazzBooleanBooleanCodeLocationAnalyzedObject5() {
    // Arrange
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    CodeLocation creationLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    when(value.getPreciseValue()).thenReturn("Precise Value");

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        basicRangeValueFactory.createReferenceValue(
            referencedClass, true, true, creationLocation, value);

    // Assert
    verify(value).getPreciseValue();
    verify(value).getType();
    verify(value).isModeled();
    assertTrue(actualCreateReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean)} with
   * {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue(
            "Type",
            referencedClass,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code
   * Clazz}, {@code Method}, {@code int}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodInt2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(
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
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue(
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
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz,
   * Method, int, Object)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean},
   * {@code Clazz}, {@code Method}, {@code int}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Clazz', 'Method', 'int', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanClazzMethodIntObject2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(
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
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue("Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   * with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}, {@code Object}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean, Object) with 'String', 'Clazz', 'boolean', 'boolean', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBooleanObject2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult =
        arrayReferenceValueFactory.createReferenceValue(
            "Type", referencedClass, true, true, "Value");

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
   * Test {@link BasicValueFactory#createReferenceValueNull()}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueNull()}
   */
  @Test
  @DisplayName("Test createReferenceValueNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueNull()"
  })
  void testCreateReferenceValueNull() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValueNull());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        basicValueFactory.createReferenceValueForId(referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertSame(basicValueFactory.REFERENCE_VALUE, actualCreateReferenceValueForIdResult);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    when(value.getPreciseValue()).thenReturn("Precise Value");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        basicValueFactory.createReferenceValueForId(referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getPreciseValue();
    verify(value).getType();
    verify(value).isModeled();
    assertSame(basicValueFactory.REFERENCE_VALUE, actualCreateReferenceValueForIdResult);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue3() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        arrayReferenceValueFactory.createReferenceValueForId(
            referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertTrue(actualCreateReferenceValueForIdResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue4() {
    // Arrange
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory();
    LibraryClass referencedClass =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getModeledValue()).thenReturn(new ClassLoaderModel());
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        basicRangeValueFactory.createReferenceValueForId(referencedClass, true, true, "Id", value);

    // Assert
    verify(value).getModeledValue();
    verify(value).getType();
    verify(value).isModeled();
    assertTrue(actualCreateReferenceValueForIdResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean, boolean, Object,
   * AnalyzedObject)} with {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(Clazz, boolean,
   * boolean, Object, AnalyzedObject)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(Clazz, boolean, boolean, Object, AnalyzedObject) with 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(proguard.classfile.Clazz, boolean, boolean, java.lang.Object, proguard.evaluation.value.object.AnalyzedObject)"
  })
  void testCreateReferenceValueForIdWithReferencedClassMayBeExtensionMayBeNullIdValue5() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());
    LibraryClass referencedClass =
        new LibraryClass(
            12, "The object value should not be null", "The object value should not be null");

    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        basicRangeValueFactory.createReferenceValueForId(referencedClass, true, true, "Id", value);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualCreateReferenceValueForIdResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateReferenceValueForIdResult instanceof ParticularReferenceValue);
    assertEquals("Id", ((ParticularReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals(1, actualCreateReferenceValueForIdResult.isNotNull());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(((ParticularReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateReferenceValueForIdResult.isNull());
    assertSame(value, actualCreateReferenceValueForIdResult.getValue());
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code mayBeNull},
   * {@code id}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullId2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        arrayReferenceValueFactory.createReferenceValueForId(
            "Type", referencedClass, true, true, "Id");

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
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValueForId(
            "Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Test {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean,
   * Object, Object)} with {@code type}, {@code referencedClass}, {@code mayBeExtension}, {@code
   * mayBeNull}, {@code id}, {@code value}.
   *
   * <p>Method under test: {@link BasicValueFactory#createReferenceValueForId(String, Clazz,
   * boolean, boolean, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object) with 'type', 'referencedClass', 'mayBeExtension', 'mayBeNull', 'id', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createReferenceValueForId(java.lang.String, proguard.classfile.Clazz, boolean, boolean, java.lang.Object, java.lang.Object)"
  })
  void testCreateReferenceValueForIdWithTypeReferencedClassMayBeExtensionMayBeNullIdValue2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult =
        arrayReferenceValueFactory.createReferenceValueForId(
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
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)} with
   * {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory =
        new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory =
        new BasicRangeValueFactory(
            arrayReferenceValueFactory, new ParticularReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        basicRangeValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code elementValues}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), arrayLength, "Element Values"));
    assertSame(arrayLength, basicValueFactory.createIntegerValue());
  }

  /**
   * Test {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code elementValues}.
   *
   * <p>Method under test: {@link BasicValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.BasicValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        primitiveTypedReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    assertTrue(
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    IntegerValue expectedCreateIntegerValueResult =
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertSame(
        expectedCreateIntegerValueResult, primitiveTypedReferenceValueFactory.createIntegerValue());
  }

  /**
   * Test {@link BasicValueFactory#checkCreationLocation(CodeLocation)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicValueFactory#checkCreationLocation(CodeLocation)}
   */
  @Test
  @DisplayName("Test checkCreationLocation(CodeLocation); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.BasicValueFactory.checkCreationLocation(proguard.analysis.datastructure.CodeLocation)"
  })
  void testCheckCreationLocation_thenThrowIllegalStateException() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            BasicValueFactory.checkCreationLocation(
                new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)));
  }
}
