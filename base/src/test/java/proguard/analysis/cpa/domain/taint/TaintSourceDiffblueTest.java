package proguard.analysis.cpa.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

class TaintSourceDiffblueTest {
  /**
   * Test {@link TaintSource#TaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <p>Method under test: {@link TaintSource#TaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  @DisplayName("Test new TaintSource(Signature, boolean, boolean, Set, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.domain.taint.TaintSource.<init>(proguard.classfile.Signature, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewTaintSource() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act
    TaintSource actualTaintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());

    // Assert
    assertTrue(actualTaintSource.taintsArgs.isEmpty());
    assertTrue(actualTaintSource.taintsGlobals.isEmpty());
  }

  /**
   * Test {@link TaintSource#equals(Object)}, and {@link TaintSource#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaintSource#equals(Object)}
   *   <li>{@link TaintSource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    TaintSource taintSource2 =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>());

    // Act and Assert
    assertEquals(taintSource, taintSource2);
    int expectedHashCodeResult = taintSource.hashCode();
    assertEquals(expectedHashCodeResult, taintSource2.hashCode());
  }

  /**
   * Test {@link TaintSource#equals(Object)}, and {@link TaintSource#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaintSource#equals(Object)}
   *   <li>{@link TaintSource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());

    // Act and Assert
    assertEquals(taintSource, taintSource);
    int expectedHashCodeResult = taintSource.hashCode();
    assertEquals(expectedHashCodeResult, taintSource.hashCode());
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        taintSource,
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            false,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        taintSource,
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            false,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        taintSource,
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        taintSource,
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");
    TaintSource taintSource =
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            new HashSet<>(),
            taintsGlobals);
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        taintSource,
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()));
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()),
        null);
  }

  /**
   * Test {@link TaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.domain.taint.TaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.domain.taint.TaintSource.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        new TaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()),
        "Different type to TaintSource");
  }

  /**
   * Test {@link TaintSource#toString()}.
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.cpa.domain.taint.TaintSource.toString()"})
  void testToString() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints this,"
            + " taints return",
        (new TaintSource(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                true,
                taintsArgs,
                new HashSet<>()))
            .toString());
  }

  /**
   * Test {@link TaintSource#toString()}.
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.cpa.domain.taint.TaintSource.toString()"})
  void testToString2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints"
            + " return",
        (new TaintSource(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                false,
                true,
                taintsArgs,
                new HashSet<>()))
            .toString());
  }

  /**
   * Test {@link TaintSource#toString()}.
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.cpa.domain.taint.TaintSource.toString()"})
  void testToString3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;,"
            + " taints this",
        (new TaintSource(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                false,
                taintsArgs,
                new HashSet<>()))
            .toString());
  }

  /**
   * Test {@link TaintSource#toString()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code [TaintSource]}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @DisplayName("Test toString(); given HashSet() add '[TaintSource]'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.cpa.domain.taint.TaintSource.toString()"})
  void testToString_givenHashSetAddTaintSource_thenReturnAString() {
    // Arrange
    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("[TaintSource] ");

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints this,"
            + " taints return, taints globals ([TaintSource] )",
        (new TaintSource(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                true,
                new HashSet<>(),
                taintsGlobals))
            .toString());
  }

  /**
   * Test {@link TaintSource#toString()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add two.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @DisplayName("Test toString(); given HashSet() add two; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.cpa.domain.taint.TaintSource.toString()"})
  void testToString_givenHashSetAddTwo_thenReturnAString() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints this,"
            + " taints return, taints args (2)",
        (new TaintSource(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                true,
                taintsArgs,
                new HashSet<>()))
            .toString());
  }
}
