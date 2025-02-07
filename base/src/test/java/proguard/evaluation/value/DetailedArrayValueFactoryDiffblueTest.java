package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

class DetailedArrayValueFactoryDiffblueTest {
  /**
   * Test {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}
   */
  @Test
  @DisplayName("Test new DetailedArrayValueFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.value.DetailedArrayValueFactory.<init>()"})
  void testNewDetailedArrayValueFactory() {
    // Arrange, Act and Assert
    assertTrue(
        (new DetailedArrayValueFactory()).referenceValueFactory
            instanceof TypedReferenceValueFactory);
  }

  /**
   * Test {@link DetailedArrayValueFactory#DetailedArrayValueFactory(ValueFactory)}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#DetailedArrayValueFactory(ValueFactory)}
   */
  @Test
  @DisplayName("Test new DetailedArrayValueFactory(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.DetailedArrayValueFactory.<init>(proguard.evaluation.value.ValueFactory)"
  })
  void testNewDetailedArrayValueFactory2() {
    // Arrange
    ParticularReferenceValueFactory referenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    DetailedArrayValueFactory actualDetailedArrayValueFactory =
        new DetailedArrayValueFactory(referenceValueFactory);

    // Assert
    assertTrue(
        actualDetailedArrayValueFactory.referenceValueFactory
            instanceof ParticularReferenceValueFactory);
    DoubleValue createDoubleValueResult = referenceValueFactory.createDoubleValue();
    assertTrue(createDoubleValueResult instanceof UnknownDoubleValue);
    FloatValue createFloatValueResult = referenceValueFactory.createFloatValue();
    assertTrue(createFloatValueResult instanceof UnknownFloatValue);
    IntegerValue createIntegerValueResult = referenceValueFactory.createIntegerValue();
    assertTrue(createIntegerValueResult instanceof UnknownIntegerValue);
    LongValue createLongValueResult = referenceValueFactory.createLongValue();
    assertTrue(createLongValueResult instanceof UnknownLongValue);
    assertSame(actualDetailedArrayValueFactory.DOUBLE_VALUE, createDoubleValueResult);
    assertSame(actualDetailedArrayValueFactory.FLOAT_VALUE, createFloatValueResult);
    assertSame(actualDetailedArrayValueFactory.INTEGER_VALUE, createIntegerValueResult);
    assertSame(actualDetailedArrayValueFactory.LONG_VALUE, createLongValueResult);
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    IntegerValue integerValue =
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof UnknownIntegerValue);
    assertFalse(integerValue.isParticular());
    assertFalse(integerValue.isSpecific());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
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
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength3() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    IntegerValue integerValue =
        ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[Type", modeledOrNullValue.getType());
    assertEquals(0, integerValue.value());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength4() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    IntegerValue integerValue =
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertEquals(Value.NEVER, integerValue.value());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength5() {
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
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength6() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Invalid type [", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[Invalid type [", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[Invalid type [", modeledOrNullValue.getType());
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    assertEquals(1, values.length);
    assertSame(detailedArrayValueFactory.INTEGER_VALUE_0, values[0]);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength7() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    Value value2 = values[0];
    assertTrue(value2 instanceof TypedReferenceValue);
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertNull(((TypedReferenceValue) value2).getType());
    assertNull(((TypedReferenceValue) value2).getReferencedClass());
    assertEquals(1, ((TypedReferenceValue) value2).isNull());
    assertEquals(1, values.length);
    assertFalse(((TypedReferenceValue) value2).mayBeExtension());
    assertFalse(value2.isSpecific());
    assertFalse(((TypedReferenceValue) value2).mayBeExtension);
    assertTrue(value2.isParticular());
    assertTrue(((TypedReferenceValue) value2).mayBeNull);
    assertEquals(Value.NEVER, ((TypedReferenceValue) value2).isNotNull());
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    IntegerValue integerValue =
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof UnknownIntegerValue);
    assertFalse(integerValue.isParticular());
    assertFalse(integerValue.isSpecific());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), BasicValueFactory.INTEGER_VALUE, "Element Values");

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
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues3() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            detailedArrayValueFactory.createArrayReferenceValue(
                "Type",
                new LibraryClass(),
                ParticularValueFactory.INTEGER_VALUE_0,
                "Element Values"));
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues4() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        detailedArrayValueFactory.createArrayReferenceValue(
            "Type", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_M1, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    IntegerValue integerValue =
        ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    assertTrue(integerValue.isParticular());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, integerValue.value());
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues5() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            detailedArrayValueFactory.createArrayReferenceValue(
                "", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0, "Element Values"));
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues6() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            detailedArrayValueFactory.createArrayReferenceValue(
                "Invalid type [",
                new LibraryClass(),
                ParticularValueFactory.INTEGER_VALUE_1,
                "Element Values"));
  }

  /**
   * Test {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue, Object)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.DetailedArrayValueFactory.createArrayReferenceValue(java.lang.String, proguard.classfile.Clazz, proguard.evaluation.value.IntegerValue, java.lang.Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues7() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            detailedArrayValueFactory.createArrayReferenceValue(
                "", new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_1, "Element Values"));
  }
}
