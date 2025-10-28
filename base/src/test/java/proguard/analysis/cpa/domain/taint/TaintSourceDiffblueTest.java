package proguard.analysis.cpa.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.Signature;

public class TaintSourceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaintSource#equals(Object)}
   *   <li>{@link TaintSource#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();
    TaintSource taintSource2 = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs2, new HashSet<>());

    // Act and Assert
    assertEquals(taintSource, taintSource2);
    int expectedHashCodeResult = taintSource.hashCode();
    assertEquals(expectedHashCodeResult, taintSource2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaintSource#equals(Object)}
   *   <li>{@link TaintSource#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs, new HashSet<>());

    // Act and Assert
    assertEquals(taintSource, taintSource);
    int expectedHashCodeResult = taintSource.hashCode();
    assertEquals(expectedHashCodeResult, taintSource.hashCode());
  }

  /**
   * Method under test: {@link TaintSource#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints this,"
            + " taints return",
        (new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link TaintSource#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints" + " return",
        (new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, true, taintsArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link TaintSource#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;," + " taints this",
        (new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, false, taintsArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link TaintSource#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints this,"
            + " taints return, taints args (2)",
        (new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
            new HashSet<>())).toString());
  }

  /**
   * Method under test: {@link TaintSource#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange
    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("[TaintSource] ");

    // Act and Assert
    assertEquals(
        "[TaintSource] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, taints this,"
            + " taints return, taints globals ([TaintSource] )",
        (new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, new HashSet<>(),
            taintsGlobals)).toString());
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(taintSource, new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, true,
        taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(taintSource, new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, false,
        taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(taintSource, new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();
    taintsArgs.add(2);
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs, new HashSet<>());
    HashSet<Integer> taintsArgs2 = new HashSet<>();

    // Act and Assert
    assertNotEquals(taintSource, new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs2, new HashSet<>()));
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<String> taintsGlobals = new HashSet<>();
    taintsGlobals.add("foo");
    TaintSource taintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        new HashSet<>(), taintsGlobals);
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(taintSource, new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs, new HashSet<>()));
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()), null);
  }

  /**
   * Method under test: {@link TaintSource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act and Assert
    assertNotEquals(new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true, taintsArgs,
        new HashSet<>()), "Different type to TaintSource");
  }

  /**
   * Method under test:
   * {@link TaintSource#TaintSource(Signature, boolean, boolean, Set, Set)}
   */
  @Test
  public void testNewTaintSource() {
    // Arrange
    HashSet<Integer> taintsArgs = new HashSet<>();

    // Act
    TaintSource actualTaintSource = new TaintSource(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, true,
        taintsArgs, new HashSet<>());

    // Assert
    assertTrue(actualTaintSource.taintsArgs.isEmpty());
    assertTrue(actualTaintSource.taintsGlobals.isEmpty());
  }
}
