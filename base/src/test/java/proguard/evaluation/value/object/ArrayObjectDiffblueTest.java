package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ArrayModel;

public class ArrayObjectDiffblueTest {
  /**
   * Method under test: {@link ArrayObject#getPreciseValue()}
   */
  @Test
  public void testGetPreciseValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"))).getPreciseValue());
  }

  /**
   * Method under test: {@link ArrayObject#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Type",
        (new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"))).getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayObject#equals(Object)}
   *   <li>{@link ArrayObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayObject arrayObject = new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"));
    ArrayObject arrayObject2 = new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"));

    // Act and Assert
    assertEquals(arrayObject, arrayObject2);
    int expectedHashCodeResult = arrayObject.hashCode();
    assertEquals(expectedHashCodeResult, arrayObject2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayObject#equals(Object)}
   *   <li>{@link ArrayObject#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayObject arrayObject = new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type"));

    // Act and Assert
    assertEquals(arrayObject, arrayObject);
    int expectedHashCodeResult = arrayObject.hashCode();
    assertEquals(expectedHashCodeResult, arrayObject.hashCode());
  }

  /**
   * Method under test: {@link ArrayObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayObject arrayObject = new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.FLOAT_VALUE}, "Type"));

    // Act and Assert
    assertNotEquals(arrayObject, new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")));
  }

  /**
   * Method under test: {@link ArrayObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")), null);
  }

  /**
   * Method under test: {@link ArrayObject#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayObject(new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type")),
        "Different type to ArrayObject");
  }
}
