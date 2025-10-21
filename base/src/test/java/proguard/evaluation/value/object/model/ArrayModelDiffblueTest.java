package proguard.evaluation.value.object.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

public class ArrayModelDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayModel.<init>(Value[], String)", "String ArrayModel.getType()"})
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value[] ArrayModel.getValues()"})
  public void testGetValues() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult ArrayModel.init(MethodExecutionInfo, ValueCalculator)"
  })
  public void testInit_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"))
                .init(null, null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult ArrayModel.invoke(MethodExecutionInfo, ValueCalculator)"
  })
  public void testInvoke_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"))
                .invoke(null, null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult ArrayModel.invokeStatic(MethodExecutionInfo, ValueCalculator)"
  })
  public void testInvokeStatic_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"))
                .invokeStatic(null, null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayModel.equals(Object)", "int ArrayModel.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayModel.equals(Object)", "int ArrayModel.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayModel.equals(Object)", "int ArrayModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayModel.equals(Object)", "int ArrayModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayModel.equals(Object)", "int ArrayModel.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayModel.equals(Object)", "int ArrayModel.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArrayModel.toString()"})
  public void testToString_givenArrayModelWithValuesIsNullAndType_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals(" null", (new ArrayModel(null, "Type")).toString());
  }
}
