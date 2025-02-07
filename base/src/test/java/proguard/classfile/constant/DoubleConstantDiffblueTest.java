package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DoubleConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#DoubleConstant()}
   *   <li>{@link DoubleConstant#setValue(double)}
   *   <li>{@link DoubleConstant#toString()}
   *   <li>{@link DoubleConstant#getValue()}
   *   <li>{@link DoubleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.DoubleConstant.<init>()",
    "void proguard.classfile.constant.DoubleConstant.<init>(double)",
    "double proguard.classfile.constant.DoubleConstant.getValue()",
    "boolean proguard.classfile.constant.DoubleConstant.isCategory2()",
    "void proguard.classfile.constant.DoubleConstant.setValue(double)",
    "java.lang.String proguard.classfile.constant.DoubleConstant.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DoubleConstant actualDoubleConstant = new DoubleConstant();
    actualDoubleConstant.setValue(10.0d);
    String actualToStringResult = actualDoubleConstant.toString();
    double actualValue = actualDoubleConstant.getValue();
    boolean actualIsCategory2Result = actualDoubleConstant.isCategory2();

    // Assert
    assertEquals("Double(10.0)", actualToStringResult);
    assertNull(actualDoubleConstant.getProcessingInfo());
    assertEquals(0, actualDoubleConstant.getProcessingFlags());
    assertEquals(10.0d, actualValue);
    assertTrue(actualIsCategory2Result);
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
   *   <li>{@link DoubleConstant#DoubleConstant(double)}
   *   <li>{@link DoubleConstant#setValue(double)}
   *   <li>{@link DoubleConstant#toString()}
   *   <li>{@link DoubleConstant#getValue()}
   *   <li>{@link DoubleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.DoubleConstant.<init>()",
    "void proguard.classfile.constant.DoubleConstant.<init>(double)",
    "double proguard.classfile.constant.DoubleConstant.getValue()",
    "boolean proguard.classfile.constant.DoubleConstant.isCategory2()",
    "void proguard.classfile.constant.DoubleConstant.setValue(double)",
    "java.lang.String proguard.classfile.constant.DoubleConstant.toString()"
  })
  void testGettersAndSetters_whenTen() {
    // Arrange and Act
    DoubleConstant actualDoubleConstant = new DoubleConstant(10.0d);
    actualDoubleConstant.setValue(10.0d);
    String actualToStringResult = actualDoubleConstant.toString();
    double actualValue = actualDoubleConstant.getValue();
    boolean actualIsCategory2Result = actualDoubleConstant.isCategory2();

    // Assert
    assertEquals("Double(10.0)", actualToStringResult);
    assertNull(actualDoubleConstant.getProcessingInfo());
    assertEquals(0, actualDoubleConstant.getProcessingFlags());
    assertEquals(10.0d, actualValue);
    assertTrue(actualIsCategory2Result);
  }

  /**
   * Test {@link DoubleConstant#getTag()}.
   *
   * <p>Method under test: {@link DoubleConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.DoubleConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(6, (new DoubleConstant(10.0d)).getTag());
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}, and {@link DoubleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#equals(Object)}
   *   <li>{@link DoubleConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DoubleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DoubleConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DoubleConstant doubleConstant2 = new DoubleConstant(10.0d);

    // Act and Assert
    assertEquals(doubleConstant, doubleConstant2);
    int expectedHashCodeResult = doubleConstant.hashCode();
    assertEquals(expectedHashCodeResult, doubleConstant2.hashCode());
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}, and {@link DoubleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#equals(Object)}
   *   <li>{@link DoubleConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DoubleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DoubleConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);

    // Act and Assert
    assertEquals(doubleConstant, doubleConstant);
    int expectedHashCodeResult = doubleConstant.hashCode();
    assertEquals(expectedHashCodeResult, doubleConstant.hashCode());
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DoubleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DoubleConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(0.5d);

    // Act and Assert
    assertNotEquals(doubleConstant, new DoubleConstant(10.0d));
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DoubleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DoubleConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleConstant(10.0d), null);
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DoubleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DoubleConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleConstant(10.0d), "Different type to DoubleConstant");
  }
}
