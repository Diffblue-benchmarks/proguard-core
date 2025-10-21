package proguard.classfile.visitor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CounterConditionalClassVisitorDiffblueTest {
  /**
   * Test {@link CounterConditionalClassVisitor#hasIncreased(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#hasIncreased(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CounterConditionalClassVisitor.hasIncreased(int, int)"})
  public void testHasIncreased_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CounterConditionalClassVisitor.hasIncreased(1, 1));
  }

  /**
   * Test {@link CounterConditionalClassVisitor#hasIncreased(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#hasIncreased(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CounterConditionalClassVisitor.hasIncreased(int, int)"})
  public void testHasIncreased_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CounterConditionalClassVisitor.hasIncreased(0, 1));
  }

  /**
   * Test {@link CounterConditionalClassVisitor#isSame(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#isSame(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CounterConditionalClassVisitor.isSame(int, int)"})
  public void testIsSame_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CounterConditionalClassVisitor.isSame(1, 1));
  }

  /**
   * Test {@link CounterConditionalClassVisitor#isSame(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#isSame(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CounterConditionalClassVisitor.isSame(int, int)"})
  public void testIsSame_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CounterConditionalClassVisitor.isSame(0, 1));
  }
}
