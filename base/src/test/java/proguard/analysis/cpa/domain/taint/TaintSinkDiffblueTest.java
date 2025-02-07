package proguard.analysis.cpa.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink;
import proguard.classfile.ClassConstants;

class TaintSinkDiffblueTest {
  /**
   * Test {@link TaintSink#equals(Object)}, and {@link TaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    JvmReturnTaintSink jvmReturnTaintSink2 =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink2);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink2.hashCode());
  }

  /**
   * Test {@link TaintSink#equals(Object)}, and {@link TaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act and Assert
    assertEquals(jvmReturnTaintSink, jvmReturnTaintSink);
    int expectedHashCodeResult = jvmReturnTaintSink.hashCode();
    assertEquals(expectedHashCodeResult, jvmReturnTaintSink.hashCode());
  }

  /**
   * Test {@link TaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE);

    // Act and Assert
    assertNotEquals(
        jvmReturnTaintSink,
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link TaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmReturnTaintSink jvmReturnTaintSink =
        new JvmReturnTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, mock(Predicate.class));

    // Act and Assert
    assertNotEquals(
        jvmReturnTaintSink,
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link TaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSink.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Test {@link TaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSink.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE),
        "Different type to TaintSink");
  }
}
