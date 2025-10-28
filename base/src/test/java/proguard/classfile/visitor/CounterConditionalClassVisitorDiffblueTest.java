package proguard.classfile.visitor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CounterConditionalClassVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link CounterConditionalClassVisitor#hasIncreased(int, int)}
   */
  @Test
  public void testHasIncreased() {
    // Arrange, Act and Assert
    assertFalse(CounterConditionalClassVisitor.hasIncreased(1, 1));
    assertTrue(CounterConditionalClassVisitor.hasIncreased(0, 1));
  }

  /**
   * Method under test: {@link CounterConditionalClassVisitor#isSame(int, int)}
   */
  @Test
  public void testIsSame() {
    // Arrange, Act and Assert
    assertTrue(CounterConditionalClassVisitor.isSame(1, 1));
    assertFalse(CounterConditionalClassVisitor.isSame(0, 1));
  }
}
