package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FloatConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FloatConstant#FloatConstant()}
   *   <li>{@link FloatConstant#setValue(float)}
   *   <li>{@link FloatConstant#toString()}
   *   <li>{@link FloatConstant#getTag()}
   *   <li>{@link FloatConstant#getValue()}
   *   <li>{@link FloatConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FloatConstant.<init>()",
    "void proguard.classfile.constant.FloatConstant.<init>(float)",
    "int proguard.classfile.constant.FloatConstant.getTag()",
    "float proguard.classfile.constant.FloatConstant.getValue()",
    "boolean proguard.classfile.constant.FloatConstant.isCategory2()",
    "void proguard.classfile.constant.FloatConstant.setValue(float)",
    "java.lang.String proguard.classfile.constant.FloatConstant.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    FloatConstant actualFloatConstant = new FloatConstant();
    actualFloatConstant.setValue(10.0f);
    String actualToStringResult = actualFloatConstant.toString();
    int actualTag = actualFloatConstant.getTag();
    float actualValue = actualFloatConstant.getValue();
    boolean actualIsCategory2Result = actualFloatConstant.isCategory2();

    // Assert
    assertEquals("Float(10.0)", actualToStringResult);
    assertNull(actualFloatConstant.getProcessingInfo());
    assertEquals(0, actualFloatConstant.getProcessingFlags());
    assertEquals(10.0f, actualValue);
    assertEquals(4, actualTag);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FloatConstant#FloatConstant(float)}
   *   <li>{@link FloatConstant#setValue(float)}
   *   <li>{@link FloatConstant#toString()}
   *   <li>{@link FloatConstant#getTag()}
   *   <li>{@link FloatConstant#getValue()}
   *   <li>{@link FloatConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FloatConstant.<init>()",
    "void proguard.classfile.constant.FloatConstant.<init>(float)",
    "int proguard.classfile.constant.FloatConstant.getTag()",
    "float proguard.classfile.constant.FloatConstant.getValue()",
    "boolean proguard.classfile.constant.FloatConstant.isCategory2()",
    "void proguard.classfile.constant.FloatConstant.setValue(float)",
    "java.lang.String proguard.classfile.constant.FloatConstant.toString()"
  })
  void testGettersAndSetters_whenTen() {
    // Arrange and Act
    FloatConstant actualFloatConstant = new FloatConstant(10.0f);
    actualFloatConstant.setValue(10.0f);
    String actualToStringResult = actualFloatConstant.toString();
    int actualTag = actualFloatConstant.getTag();
    float actualValue = actualFloatConstant.getValue();
    boolean actualIsCategory2Result = actualFloatConstant.isCategory2();

    // Assert
    assertEquals("Float(10.0)", actualToStringResult);
    assertNull(actualFloatConstant.getProcessingInfo());
    assertEquals(0, actualFloatConstant.getProcessingFlags());
    assertEquals(10.0f, actualValue);
    assertEquals(4, actualTag);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link FloatConstant#equals(Object)}, and {@link FloatConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FloatConstant#equals(Object)}
   *   <li>{@link FloatConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.FloatConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.FloatConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FloatConstant floatConstant = new FloatConstant(10.0f);
    FloatConstant floatConstant2 = new FloatConstant(10.0f);

    // Act and Assert
    assertEquals(floatConstant, floatConstant2);
    int expectedHashCodeResult = floatConstant.hashCode();
    assertEquals(expectedHashCodeResult, floatConstant2.hashCode());
  }

  /**
   * Test {@link FloatConstant#equals(Object)}, and {@link FloatConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FloatConstant#equals(Object)}
   *   <li>{@link FloatConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.FloatConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.FloatConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FloatConstant floatConstant = new FloatConstant(10.0f);

    // Act and Assert
    assertEquals(floatConstant, floatConstant);
    int expectedHashCodeResult = floatConstant.hashCode();
    assertEquals(expectedHashCodeResult, floatConstant.hashCode());
  }

  /**
   * Test {@link FloatConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FloatConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.FloatConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.FloatConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FloatConstant floatConstant = new FloatConstant(0.5f);

    // Act and Assert
    assertNotEquals(floatConstant, new FloatConstant(10.0f));
  }

  /**
   * Test {@link FloatConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FloatConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.FloatConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.FloatConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FloatConstant(10.0f), null);
  }

  /**
   * Test {@link FloatConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FloatConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.FloatConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.FloatConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FloatConstant(10.0f), "Different type to FloatConstant");
  }
}
