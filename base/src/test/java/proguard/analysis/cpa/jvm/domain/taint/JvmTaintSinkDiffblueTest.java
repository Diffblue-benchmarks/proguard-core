package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

class JvmTaintSinkDiffblueTest {
  /**
   * Test {@link JvmTaintSink#convertSinksToMemoryLocations(Collection)}.
   *
   * <p>Method under test: {@link JvmTaintSink#convertSinksToMemoryLocations(Collection)}
   */
  @Test
  @DisplayName("Test convertSinksToMemoryLocations(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.convertSinksToMemoryLocations(java.util.Collection)"
  })
  void testConvertSinksToMemoryLocations() {
    // Arrange
    ArrayList<JvmTaintSink> taintSinks = new ArrayList<>();
    taintSinks.add(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    taintSinks.add(new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));

    // Act
    Map<Signature, Map<JvmTaintSink, Set<JvmMemoryLocation>>>
        actualConvertSinksToMemoryLocationsResult =
            JvmTaintSink.convertSinksToMemoryLocations(taintSinks);

    // Assert
    assertEquals(1, actualConvertSinksToMemoryLocationsResult.size());
  }

  /**
   * Test {@link JvmTaintSink#convertSinksToMemoryLocations(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSink#convertSinksToMemoryLocations(Collection)}
   */
  @Test
  @DisplayName(
      "Test convertSinksToMemoryLocations(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Map proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.convertSinksToMemoryLocations(java.util.Collection)"
  })
  void testConvertSinksToMemoryLocations_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Signature, Map<JvmTaintSink, Set<JvmMemoryLocation>>>
        actualConvertSinksToMemoryLocationsResult =
            JvmTaintSink.convertSinksToMemoryLocations(new ArrayList<>());

    // Assert
    assertTrue(actualConvertSinksToMemoryLocationsResult.isEmpty());
  }

  /**
   * Test {@link JvmTaintSink#equals(Object)}, and {@link JvmTaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.hashCode()"
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
   * Test {@link JvmTaintSink#equals(Object)}, and {@link JvmTaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.hashCode()"
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
   * Test {@link JvmTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.hashCode()"
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
   * Test {@link JvmTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE), null);
  }

  /**
   * Test {@link JvmTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE),
        "Different type to JvmTaintSink");
  }
}
