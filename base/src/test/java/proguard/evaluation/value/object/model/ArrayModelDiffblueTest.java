package proguard.evaluation.value.object.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

class ArrayModelDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayModel#ArrayModel(Value[], String)}
   *   <li>{@link ArrayModel#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.object.model.ArrayModel.<init>(proguard.evaluation.value.Value[], java.lang.String)",
    "java.lang.String proguard.evaluation.value.object.model.ArrayModel.getType()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Type", (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")).getType());
  }

  /**
   * Test {@link ArrayModel#getValues()}.
   *
   * <p>Method under test: {@link ArrayModel#getValues()}
   */
  @Test
  @DisplayName("Test getValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value[] proguard.evaluation.value.object.model.ArrayModel.getValues()"
  })
  void testGetValues() {
    // Arrange and Act
    Value[] actualValues =
        (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")).getValues();

    // Assert
    Value value = actualValues[0];
    assertTrue(value instanceof UnknownDoubleValue);
    assertEquals(1, actualValues.length);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(value.isCategory2());
  }

  /**
   * Test {@link ArrayModel#init(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#init(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test init(MethodExecutionInfo, ValueCalculator); when 'null'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ArrayModel.init(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInit_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"))
                .init(null, mock(ValueCalculator.class)));
  }

  /**
   * Test {@link ArrayModel#invoke(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#invoke(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test invoke(MethodExecutionInfo, ValueCalculator); when 'null'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ArrayModel.invoke(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInvoke_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"))
                .invoke(null, mock(ValueCalculator.class)));
  }

  /**
   * Test {@link ArrayModel#invokeStatic(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#invokeStatic(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test invokeStatic(MethodExecutionInfo, ValueCalculator); when 'null'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ArrayModel.invokeStatic(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInvokeStatic_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"))
                .invokeStatic(null, mock(ValueCalculator.class)));
  }

  /**
   * Test {@link ArrayModel#equals(Object)}, and {@link ArrayModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayModel#equals(Object)}
   *   <li>{@link ArrayModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ArrayModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ArrayModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type");
    ArrayModel arrayModel2 = new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type");

    // Act and Assert
    assertEquals(arrayModel, arrayModel2);
    int expectedHashCodeResult = arrayModel.hashCode();
    assertEquals(expectedHashCodeResult, arrayModel2.hashCode());
  }

  /**
   * Test {@link ArrayModel#equals(Object)}, and {@link ArrayModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayModel#equals(Object)}
   *   <li>{@link ArrayModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ArrayModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ArrayModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type");

    // Act and Assert
    assertEquals(arrayModel, arrayModel);
    int expectedHashCodeResult = arrayModel.hashCode();
    assertEquals(expectedHashCodeResult, arrayModel.hashCode());
  }

  /**
   * Test {@link ArrayModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ArrayModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ArrayModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[] {BasicValueFactory.FLOAT_VALUE}, "Type");

    // Act and Assert
    assertNotEquals(
        arrayModel, new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"));
  }

  /**
   * Test {@link ArrayModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ArrayModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ArrayModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayModel arrayModel =
        new ArrayModel(
            new Value[] {BasicValueFactory.DOUBLE_VALUE},
            "proguard.evaluation.value.object.model.ArrayModel");

    // Act and Assert
    assertNotEquals(
        arrayModel, new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"));
  }

  /**
   * Test {@link ArrayModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ArrayModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ArrayModel.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"), null);
  }

  /**
   * Test {@link ArrayModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ArrayModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ArrayModel.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"),
        "Different type to ArrayModel");
  }

  /**
   * Test {@link ArrayModel#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayModel#ArrayModel(Value[], String)} with values is {@code null} and
   *       {@code Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayModel#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ArrayModel(Value[], String) with values is 'null' and 'Type'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.object.model.ArrayModel.toString()"
  })
  void testToString_givenArrayModelWithValuesIsNullAndType_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals(" null", (new ArrayModel(null, "Type")).toString());
  }
}
