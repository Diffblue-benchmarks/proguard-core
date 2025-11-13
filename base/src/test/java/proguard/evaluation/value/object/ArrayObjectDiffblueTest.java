package proguard.evaluation.value.object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ArrayModel;

class ArrayObjectDiffblueTest {
  /**
   * Test {@link ArrayObject#getPreciseValue()}.
   *
   * <p>Method under test: {@link ArrayObject#getPreciseValue()}
   */
  @Test
  @DisplayName("Test getPreciseValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ArrayObject.getPreciseValue()"})
  void testGetPreciseValue() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "Type");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new ArrayObject(value).getPreciseValue());
  }

  /**
   * Test {@link ArrayObject#getType()}.
   *
   * <p>Method under test: {@link ArrayObject#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ArrayObject.getType()"})
  void testGetType() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "Type");

    // Act and Assert
    assertEquals("Type", new ArrayObject(value).getType());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "Type");
    ArrayObject arrayObject = new ArrayObject(value);
    Value[] values2 = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value2 = new ArrayModel(values2, "Type");
    ArrayObject arrayObject2 = new ArrayObject(value2);

    // Act and Assert
    assertEquals(arrayObject, arrayObject2);
    assertEquals(arrayObject.hashCode(), arrayObject2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "Type");
    ArrayObject arrayObject = new ArrayObject(value);

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "proguard.evaluation.value.object.model.ArrayModel");
    ArrayObject arrayObject = new ArrayObject(value);
    Value[] values2 = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value2 = new ArrayModel(values2, "Type");

    // Act and Assert
    assertNotEquals(arrayObject, new ArrayObject(value2));
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "Type");

    // Act and Assert
    assertNotEquals(new ArrayObject(value), null);
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayObject.equals(Object)", "int ArrayObject.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Value[] values = new Value[] {BasicValueFactory.DOUBLE_VALUE};
    ArrayModel value = new ArrayModel(values, "Type");

    // Act and Assert
    assertNotEquals(new ArrayObject(value), "Different type to ArrayObject");
  }
}
