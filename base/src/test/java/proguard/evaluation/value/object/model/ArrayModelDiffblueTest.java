package proguard.evaluation.value.object.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

public class ArrayModelDiffblueTest {
  /**
   * Method under test: {@link ArrayModel#getValues()}
   */
  @Test
  public void testGetValues() {
    // Arrange and Act
    Value[] actualValues = (new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")).getValues();

    // Assert
    Value value = actualValues[0];
    assertTrue(value instanceof UnknownDoubleValue);
    assertEquals(1, actualValues.length);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertTrue(value.isCategory2());
  }

  /**
   * Method under test:
   * {@link ArrayModel#init(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")).init(null, null));
  }

  /**
   * Method under test:
   * {@link ArrayModel#invoke(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  public void testInvoke() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")).invoke(null, null));
  }

  /**
   * Method under test:
   * {@link ArrayModel#invokeStatic(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  public void testInvokeStatic() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")).invokeStatic(null, null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayModel#equals(Object)}
   *   <li>{@link ArrayModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type");
    ArrayModel arrayModel2 = new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type");

    // Act and Assert
    assertEquals(arrayModel, arrayModel2);
    int expectedHashCodeResult = arrayModel.hashCode();
    assertEquals(expectedHashCodeResult, arrayModel2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayModel#equals(Object)}
   *   <li>{@link ArrayModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type");

    // Act and Assert
    assertEquals(arrayModel, arrayModel);
    int expectedHashCodeResult = arrayModel.hashCode();
    assertEquals(expectedHashCodeResult, arrayModel.hashCode());
  }

  /**
   * Method under test: {@link ArrayModel#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals(" null", (new ArrayModel(null, "Type")).toString());
  }

  /**
   * Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[]{BasicValueFactory.FLOAT_VALUE}, "Type");

    // Act and Assert
    assertNotEquals(arrayModel, new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"));
  }

  /**
   * Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayModel arrayModel = new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE},
        "proguard.evaluation.value.object.model.ArrayModel");

    // Act and Assert
    assertNotEquals(arrayModel, new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"));
  }

  /**
   * Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"), null);
  }

  /**
   * Method under test: {@link ArrayModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"),
        "Different type to ArrayModel");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayModel#ArrayModel(Value[], String)}
   *   <li>{@link ArrayModel#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Type", (new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")).getType());
  }
}
