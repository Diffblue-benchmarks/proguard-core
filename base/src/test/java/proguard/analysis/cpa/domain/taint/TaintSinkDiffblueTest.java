package proguard.analysis.cpa.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.domain.taint.JvmReturnTaintSink;
import proguard.classfile.ClassConstants;

public class TaintSinkDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSink.equals(Object)", "int TaintSink.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSink.equals(Object)", "int TaintSink.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSink.equals(Object)", "int TaintSink.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaintSink#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSink.equals(Object)", "int TaintSink.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TaintSink.equals(Object)", "int TaintSink.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JvmReturnTaintSink(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE),
        "Different type to TaintSink");
  }
}
