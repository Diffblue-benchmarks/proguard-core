package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class StackSizeComputerDiffblueTest {
  /**
   * Method under test: {@link StackSizeComputer#isReachable(int)}
   */
  @Test
  public void testIsReachable() {
    // Arrange, Act and Assert
    assertFalse((new StackSizeComputer()).isReachable(1));
  }

  /**
   * Method under test: {@link StackSizeComputer#getStackSizeBefore(int)}
   */
  @Test
  public void testGetStackSizeBefore() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new StackSizeComputer()).getStackSizeBefore(1));
  }

  /**
   * Method under test: {@link StackSizeComputer#getStackSizeAfter(int)}
   */
  @Test
  public void testGetStackSizeAfter() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new StackSizeComputer()).getStackSizeAfter(1));
  }

  /**
   * Method under test: {@link StackSizeComputer#getMaxStackSize()}
   */
  @Test
  public void testGetMaxStackSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new StackSizeComputer()).getMaxStackSize());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link StackSizeComputer}
   */
  @Test
  public void testNewStackSizeComputer() {
    // Arrange, Act and Assert
    assertEquals(0, (new StackSizeComputer()).getMaxStackSize());
  }
}
