package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#IntegerConstant()}
   *   <li>{@link IntegerConstant#setValue(int)}
   *   <li>{@link IntegerConstant#toString()}
   *   <li>{@link IntegerConstant#getTag()}
   *   <li>{@link IntegerConstant#getValue()}
   *   <li>{@link IntegerConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.IntegerConstant.<init>()",
    "void proguard.classfile.constant.IntegerConstant.<init>(int)",
    "int proguard.classfile.constant.IntegerConstant.getTag()",
    "int proguard.classfile.constant.IntegerConstant.getValue()",
    "boolean proguard.classfile.constant.IntegerConstant.isCategory2()",
    "void proguard.classfile.constant.IntegerConstant.setValue(int)",
    "java.lang.String proguard.classfile.constant.IntegerConstant.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    IntegerConstant actualIntegerConstant = new IntegerConstant();
    actualIntegerConstant.setValue(42);
    String actualToStringResult = actualIntegerConstant.toString();
    int actualTag = actualIntegerConstant.getTag();
    int actualValue = actualIntegerConstant.getValue();
    boolean actualIsCategory2Result = actualIntegerConstant.isCategory2();

    // Assert
    assertEquals("Integer(42)", actualToStringResult);
    assertNull(actualIntegerConstant.getProcessingInfo());
    assertEquals(0, actualIntegerConstant.getProcessingFlags());
    assertEquals(3, actualTag);
    assertEquals(42, actualValue);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#IntegerConstant(int)}
   *   <li>{@link IntegerConstant#setValue(int)}
   *   <li>{@link IntegerConstant#toString()}
   *   <li>{@link IntegerConstant#getTag()}
   *   <li>{@link IntegerConstant#getValue()}
   *   <li>{@link IntegerConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.IntegerConstant.<init>()",
    "void proguard.classfile.constant.IntegerConstant.<init>(int)",
    "int proguard.classfile.constant.IntegerConstant.getTag()",
    "int proguard.classfile.constant.IntegerConstant.getValue()",
    "boolean proguard.classfile.constant.IntegerConstant.isCategory2()",
    "void proguard.classfile.constant.IntegerConstant.setValue(int)",
    "java.lang.String proguard.classfile.constant.IntegerConstant.toString()"
  })
  void testGettersAndSetters_whenFortyTwo() {
    // Arrange and Act
    IntegerConstant actualIntegerConstant = new IntegerConstant(42);
    actualIntegerConstant.setValue(42);
    String actualToStringResult = actualIntegerConstant.toString();
    int actualTag = actualIntegerConstant.getTag();
    int actualValue = actualIntegerConstant.getValue();
    boolean actualIsCategory2Result = actualIntegerConstant.isCategory2();

    // Assert
    assertEquals("Integer(42)", actualToStringResult);
    assertNull(actualIntegerConstant.getProcessingInfo());
    assertEquals(0, actualIntegerConstant.getProcessingFlags());
    assertEquals(3, actualTag);
    assertEquals(42, actualValue);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}, and {@link IntegerConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#equals(Object)}
   *   <li>{@link IntegerConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.IntegerConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.IntegerConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(42);
    IntegerConstant integerConstant2 = new IntegerConstant(42);

    // Act and Assert
    assertEquals(integerConstant, integerConstant2);
    int expectedHashCodeResult = integerConstant.hashCode();
    assertEquals(expectedHashCodeResult, integerConstant2.hashCode());
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}, and {@link IntegerConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#equals(Object)}
   *   <li>{@link IntegerConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.IntegerConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.IntegerConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act and Assert
    assertEquals(integerConstant, integerConstant);
    int expectedHashCodeResult = integerConstant.hashCode();
    assertEquals(expectedHashCodeResult, integerConstant.hashCode());
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.IntegerConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.IntegerConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(1);

    // Act and Assert
    assertNotEquals(integerConstant, new IntegerConstant(42));
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.IntegerConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.IntegerConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IntegerConstant(42), null);
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.IntegerConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.IntegerConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IntegerConstant(42), "Different type to IntegerConstant");
  }
}
