package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.domain.taint.TaintSource;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

class JvmTaintSourceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintSource#JvmTaintSource(Signature, Optional, boolean, boolean, Set, Set)}
   *   <li>{@link JvmTaintSource#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, java.util.Optional, boolean, boolean, java.util.Set, java.util.Set)",
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<Predicate<Call>> callMatcher = Optional.<Predicate<Call>>of(mock(Predicate.class));
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    actualJvmTaintSource.toString();

    // Assert
    assertTrue(actualJvmTaintSource.callMatcher.isPresent());
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@link TaintSource#taintsGlobals} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set); given '42'; when HashSet() add '42'; then return taintsGlobals size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_given42_whenHashSetAdd42_thenReturnTaintsGlobalsSizeIsTwo() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> taintsArgs = new HashSet<>();

    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("42");
    taintsGlobals.add("foo");

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            true,
            taintsArgs,
            taintsGlobals);

    // Assert
    Set<String> stringSet = actualJvmTaintSource.taintsGlobals;
    assertEquals(2, stringSet.size());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@link TaintSource#taintsGlobals} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, boolean, boolean, Set, Set); given '42'; when HashSet() add '42'; then return taintsGlobals size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_given42_whenHashSetAdd42_thenReturnTaintsGlobalsSizeIsTwo2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("42");
    taintsGlobals.add("foo");

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            taintsGlobals);

    // Assert
    Set<String> stringSet = actualJvmTaintSource.taintsGlobals;
    assertEquals(2, stringSet.size());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set); given 'foo'; when HashSet() add 'foo'; then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_givenFoo_whenHashSetAddFoo_thenHashSetSizeIsOne() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> taintsArgs = new HashSet<>();

    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            true,
            taintsArgs,
            taintsGlobals);

    // Assert
    assertEquals(1, taintsGlobals.size());
    Set<String> stringSet = actualJvmTaintSource.taintsGlobals;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, boolean, boolean, Set, Set); given 'foo'; when HashSet() add 'foo'; then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_givenFoo_whenHashSetAddFoo_thenHashSetSizeIsOne2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            taintsGlobals);

    // Assert
    assertEquals(1, taintsGlobals.size());
    Set<String> stringSet = actualJvmTaintSource.taintsGlobals;
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmTaintSource.taintsArgs.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return {@link TaintSource#taintsArgs} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set); given one; when HashSet() add one; then return taintsArgs size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_givenOne_whenHashSetAddOne_thenReturnTaintsArgsSizeIsTwo() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);

    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(1);
    taintsArgs.add(2);

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            true,
            taintsArgs,
            new HashSet<>());

    // Assert
    Set<Integer> integerSet = actualJvmTaintSource.taintsArgs;
    assertEquals(2, integerSet.size());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return {@link TaintSource#taintsArgs} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, boolean, boolean, Set, Set); given one; when HashSet() add one; then return taintsArgs size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_givenOne_whenHashSetAddOne_thenReturnTaintsArgsSizeIsTwo2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(1);
    taintsArgs.add(2);

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());

    // Assert
    Set<Integer> integerSet = actualJvmTaintSource.taintsArgs;
    assertEquals(2, integerSet.size());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then return {@link TaintSource#taintsArgs} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set); given two; when HashSet() add two; then return taintsArgs size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_givenTwo_whenHashSetAddTwo_thenReturnTaintsArgsSizeIsOne() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);

    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            true,
            taintsArgs,
            taintsGlobals);

    // Assert
    Set<Integer> integerSet = actualJvmTaintSource.taintsArgs;
    assertEquals(1, integerSet.size());
    assertTrue(taintsGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then return {@link TaintSource#taintsArgs} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, boolean, boolean, Set, Set); given two; when HashSet() add two; then return taintsArgs size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_givenTwo_whenHashSetAddTwo_thenReturnTaintsArgsSizeIsOne2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    JvmTaintSource actualJvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            taintsGlobals);

    // Assert
    Set<Integer> integerSet = actualJvmTaintSource.taintsArgs;
    assertEquals(1, integerSet.size());
    assertTrue(taintsGlobals.isEmpty());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmTaintSource.taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, Predicate, boolean,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, Predicate, boolean, boolean, Set, Set); then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_thenHashSetEmpty() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> taintsArgs = new HashSet<>();
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    new JvmTaintSource(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        callMatcher,
        true,
        true,
        taintsArgs,
        taintsGlobals);

    // Assert
    assertTrue(taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#JvmTaintSource(Signature, boolean, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintSource(Signature, boolean, boolean, Set, Set); then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.<init>(proguard.classfile.Signature, boolean, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmTaintSource_thenHashSetEmpty2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    HashSet<String> taintsGlobals = new HashSet<>();

    // Act
    new JvmTaintSource(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        true,
        true,
        taintsArgs,
        taintsGlobals);

    // Assert
    assertTrue(taintsGlobals.isEmpty());
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}, and {@link JvmTaintSource#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintSource#equals(Object)}
   *   <li>{@link JvmTaintSource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    JvmTaintSource jvmTaintSource2 =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>());

    // Act and Assert
    assertEquals(jvmTaintSource, jvmTaintSource2);
    int expectedHashCodeResult = jvmTaintSource.hashCode();
    assertEquals(expectedHashCodeResult, jvmTaintSource2.hashCode());
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}, and {@link JvmTaintSource#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintSource#equals(Object)}
   *   <li>{@link JvmTaintSource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());

    // Act and Assert
    assertEquals(jvmTaintSource, jvmTaintSource);
    int expectedHashCodeResult = jvmTaintSource.hashCode();
    assertEquals(expectedHashCodeResult, jvmTaintSource.hashCode());
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        jvmTaintSource,
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            false,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        jvmTaintSource,
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            false,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        jvmTaintSource,
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        jvmTaintSource,
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            new HashSet<>(),
            taintsGlobals);
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        jvmTaintSource,
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()));
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Optional<Predicate<Call>> callMatcher = Optional.<Predicate<Call>>of(mock(Predicate.class));
    HashSet<Integer> taintsArgs = new HashSet<>();
    JvmTaintSource jvmTaintSource =
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            true,
            taintsArgs,
            new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        jvmTaintSource,
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs2,
            new HashSet<>()));
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()),
        null);
  }

  /**
   * Test {@link JvmTaintSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(
        new JvmTaintSource(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            true,
            taintsArgs,
            new HashSet<>()),
        "Different type to JvmTaintSource");
  }
}
