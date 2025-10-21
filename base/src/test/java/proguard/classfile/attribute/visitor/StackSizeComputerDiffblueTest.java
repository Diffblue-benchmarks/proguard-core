package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StackSizeComputerDiffblueTest {
  /**
   * Test new {@link StackSizeComputer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StackSizeComputer}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StackSizeComputer.<init>()"})
  public void testNewStackSizeComputer() {
    // Arrange, Act and Assert
    assertEquals(0, (new StackSizeComputer()).getMaxStackSize());
  }

  /**
   * Test {@link StackSizeComputer#isReachable(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#isReachable(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean StackSizeComputer.isReachable(int)"})
  public void testIsReachable_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new StackSizeComputer()).isReachable(1));
  }

  /**
   * Test {@link StackSizeComputer#getStackSizeBefore(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#getStackSizeBefore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StackSizeComputer.getStackSizeBefore(int)"})
  public void testGetStackSizeBefore_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new StackSizeComputer()).getStackSizeBefore(1));
  }

  /**
   * Test {@link StackSizeComputer#getStackSizeAfter(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StackSizeComputer#getStackSizeAfter(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StackSizeComputer.getStackSizeAfter(int)"})
  public void testGetStackSizeAfter_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new StackSizeComputer()).getStackSizeAfter(1));
  }

  /**
   * Test {@link StackSizeComputer#getMaxStackSize()}.
   *
   * <p>Method under test: {@link StackSizeComputer#getMaxStackSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int StackSizeComputer.getMaxStackSize()"})
  public void testGetMaxStackSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new StackSizeComputer()).getMaxStackSize());
  }
}
