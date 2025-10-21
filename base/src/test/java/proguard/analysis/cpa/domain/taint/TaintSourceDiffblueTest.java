package proguard.analysis.cpa.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

public class TaintSourceDiffblueTest {
  /**
   * Test {@link TaintSource#TaintSource(Signature, boolean, boolean, Set, Set)}.
   *
   * <p>Method under test: {@link TaintSource#TaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaintSource.<init>(Signature, boolean, boolean, Set, Set)"})
  public void testNewTaintSource() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSource.equals(Object)", "int TaintSource.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TaintSource.toString()"})
  public void testToString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TaintSource.toString()"})
  public void testToString2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TaintSource.toString()"})
  public void testToString3() {
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
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TaintSource.toString()"})
  public void testToString_givenHashSetAddTaintSource() {
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
   * </ul>
   *
   * <p>Method under test: {@link TaintSource#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TaintSource.toString()"})
  public void testToString_givenHashSetAddTwo() {
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
