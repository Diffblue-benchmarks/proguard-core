package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.domain.taint.TaintSource;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

public class JvmTaintSourceDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintSource.<init>(Signature, boolean, boolean, Set, Set)"})
  public void testNewJvmTaintSource_given42_whenHashSetAdd42_thenReturnTaintsGlobalsSizeIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintSource.<init>(Signature, boolean, boolean, Set, Set)"})
  public void testNewJvmTaintSource_givenFoo_whenHashSetAddFoo_thenHashSetSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintSource.<init>(Signature, boolean, boolean, Set, Set)"})
  public void testNewJvmTaintSource_givenOne_whenHashSetAddOne_thenReturnTaintsArgsSizeIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintSource.<init>(Signature, boolean, boolean, Set, Set)"})
  public void testNewJvmTaintSource_givenTwo_whenHashSetAddTwo_thenReturnTaintsArgsSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintSource.<init>(Signature, boolean, boolean, Set, Set)"})
  public void testNewJvmTaintSource_thenHashSetEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintSource#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmTaintSource.equals(Object)", "int JvmTaintSource.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
