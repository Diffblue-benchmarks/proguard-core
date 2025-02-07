package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

class DetailedArrayReferenceValueDiffblueTest {
  /**
   * Test {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue,
   * ValueFactory, int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link Optional#get()} Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DetailedArrayReferenceValue#create(String, Clazz, boolean,
   * IntegerValue, ValueFactory, int)}
   */
  @Test
  @DisplayName(
      "Test create(String, Clazz, boolean, IntegerValue, ValueFactory, int); when empty string; then return get() Type is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.value.DetailedArrayReferenceValue.create(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)"
  })
  void testCreate_whenEmptyString_thenReturnGetTypeIsEmptyString() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult =
        DetailedArrayReferenceValue.create(
            "",
            referencedClass,
            true,
            ParticularValueFactory.INTEGER_VALUE_0,
            new ParticularReferenceValueFactory(),
            1);

    // Assert
    DetailedArrayReferenceValue getResult = actualCreateResult.get();
    assertTrue(getResult.getReferencedClass() instanceof LibraryClass);
    AnalyzedObject value = getResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("", getResult.getType());
    assertEquals("", modeledOrNullValue.getType());
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue,
   * ValueFactory, int)}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Optional#get()} Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DetailedArrayReferenceValue#create(String, Clazz, boolean,
   * IntegerValue, ValueFactory, int)}
   */
  @Test
  @DisplayName(
      "Test create(String, Clazz, boolean, IntegerValue, ValueFactory, int); when INTEGER_VALUE_0; then return get() Type is 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.value.DetailedArrayReferenceValue.create(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)"
  })
  void testCreate_whenInteger_value_0_thenReturnGetTypeIsType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult =
        DetailedArrayReferenceValue.create(
            "Type",
            referencedClass,
            true,
            ParticularValueFactory.INTEGER_VALUE_0,
            new ParticularReferenceValueFactory(),
            1);

    // Assert
    DetailedArrayReferenceValue getResult = actualCreateResult.get();
    assertTrue(getResult.getReferencedClass() instanceof LibraryClass);
    AnalyzedObject value = getResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("Type", getResult.getType());
    assertEquals("Type", modeledOrNullValue.getType());
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Test {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue,
   * ValueFactory, int)}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link DetailedArrayReferenceValue#create(String, Clazz, boolean,
   * IntegerValue, ValueFactory, int)}
   */
  @Test
  @DisplayName(
      "Test create(String, Clazz, boolean, IntegerValue, ValueFactory, int); when INTEGER_VALUE_BYTE; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.value.DetailedArrayReferenceValue.create(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)"
  })
  void testCreate_whenInteger_value_byte_thenReturnNotPresent() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult =
        DetailedArrayReferenceValue.create(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Assert
    assertFalse(actualCreateResult.isPresent());
  }

  /**
   * Test {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue,
   * ValueFactory, int)}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link DetailedArrayReferenceValue#create(String, Clazz, boolean,
   * IntegerValue, ValueFactory, int)}
   */
  @Test
  @DisplayName(
      "Test create(String, Clazz, boolean, IntegerValue, ValueFactory, int); when INTEGER_VALUE_M1; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.value.DetailedArrayReferenceValue.create(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)"
  })
  void testCreate_whenInteger_value_m1_thenReturnNotPresent() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult =
        DetailedArrayReferenceValue.create(
            "Type",
            referencedClass,
            true,
            ParticularValueFactory.INTEGER_VALUE_M1,
            new ParticularReferenceValueFactory(),
            1);

    // Assert
    assertFalse(actualCreateResult.isPresent());
  }

  /**
   * Test {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue,
   * ValueFactory, int)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link DetailedArrayReferenceValue#create(String, Clazz, boolean,
   * IntegerValue, ValueFactory, int)}
   */
  @Test
  @DisplayName(
      "Test create(String, Clazz, boolean, IntegerValue, ValueFactory, int); when INTEGER_VALUE; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.value.DetailedArrayReferenceValue.create(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)"
  })
  void testCreate_whenInteger_value_thenReturnNotPresent() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult =
        DetailedArrayReferenceValue.create(
            "Type",
            referencedClass,
            true,
            BasicValueFactory.INTEGER_VALUE,
            new ParticularReferenceValueFactory(),
            1);

    // Assert
    assertFalse(actualCreateResult.isPresent());
  }

  /**
   * Test {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue,
   * ValueFactory, int)}.
   *
   * <ul>
   *   <li>When {@code Invalid type [}.
   *   <li>Then return {@link Optional#get()} Type is {@code Invalid type [}.
   * </ul>
   *
   * <p>Method under test: {@link DetailedArrayReferenceValue#create(String, Clazz, boolean,
   * IntegerValue, ValueFactory, int)}
   */
  @Test
  @DisplayName(
      "Test create(String, Clazz, boolean, IntegerValue, ValueFactory, int); when 'Invalid type ['; then return get() Type is 'Invalid type ['")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.value.DetailedArrayReferenceValue.create(java.lang.String, proguard.classfile.Clazz, boolean, proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory, int)"
  })
  void testCreate_whenInvalidType_thenReturnGetTypeIsInvalidType() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IntegerValue arrayLength = ParticularValueFactory.INTEGER_VALUE_1;
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult =
        DetailedArrayReferenceValue.create(
            "Invalid type [", referencedClass, true, arrayLength, valuefactory, 1);

    // Assert
    DetailedArrayReferenceValue getResult = actualCreateResult.get();
    assertTrue(getResult.getReferencedClass() instanceof LibraryClass);
    AnalyzedObject value = getResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("Invalid type [", getResult.getType());
    assertEquals("Invalid type [", modeledOrNullValue.getType());
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    assertEquals(1, values.length);
    assertFalse(getResult.isParticular());
    assertSame(valuefactory.INTEGER_VALUE, values[0]);
    assertSame(arrayLength, getResult.arrayLength);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }
}
