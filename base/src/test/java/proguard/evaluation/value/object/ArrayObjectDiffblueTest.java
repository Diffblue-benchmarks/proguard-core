package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ArrayModel;

public class ArrayObjectDiffblueTest {
  /**
   * Test {@link ArrayObject#getPreciseValue()}.
   *
   * <p>Method under test: {@link ArrayObject#getPreciseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] ArrayObject.getPreciseValue()"})
  public void testGetPreciseValue() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")))
                .getPreciseValue());
  }

  /**
   * Test {@link ArrayObject#getType()}.
   *
   * <p>Method under test: {@link ArrayObject#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ArrayObject.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        "Type",
        (new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")))
            .getType());
  }

  /**
   * Test {@link ArrayObject#equals(Object)}, and {@link ArrayObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayObject#equals(Object)}
   *   <li>{@link ArrayObject#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayObject arrayObject =
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"));
    ArrayObject arrayObject2 =
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"));

    // Act and Assert
    assertEquals(arrayObject, arrayObject2);
    int expectedHashCodeResult = arrayObject.hashCode();
    assertEquals(expectedHashCodeResult, arrayObject2.hashCode());
  }

  /**
   * Test {@link ArrayObject#equals(Object)}, and {@link ArrayObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayObject#equals(Object)}
   *   <li>{@link ArrayObject#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayObject arrayObject =
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type"));

    // Act and Assert
    assertEquals(arrayObject, arrayObject);
    int expectedHashCodeResult = arrayObject.hashCode();
    assertEquals(expectedHashCodeResult, arrayObject.hashCode());
  }

  /**
   * Test {@link ArrayObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayObject arrayObject =
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.FLOAT_VALUE}, "Type"));

    // Act and Assert
    assertNotEquals(
        arrayObject,
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")));
  }

  /**
   * Test {@link ArrayObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")),
        null);
  }

  /**
   * Test {@link ArrayObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayObject#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ArrayObject(new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type")),
        "Different type to ArrayObject");
  }
}
