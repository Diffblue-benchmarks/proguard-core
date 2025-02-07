package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractWaitlistDiffblueTest {
  /**
   * Test {@link AbstractWaitlist#isEmpty()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.defaults.AbstractWaitlist.isEmpty()"})
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new BreadthFirstWaitlist()).isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#size()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.analysis.cpa.defaults.AbstractWaitlist.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new BreadthFirstWaitlist()).size());
  }

  /**
   * Test {@link AbstractWaitlist#iterator()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Iterator proguard.analysis.cpa.defaults.AbstractWaitlist.iterator()"
  })
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new BreadthFirstWaitlist()).iterator().hasNext());
  }

  /**
   * Test {@link AbstractWaitlist#spliterator()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#spliterator()}
   */
  @Test
  @DisplayName("Test spliterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Spliterator proguard.analysis.cpa.defaults.AbstractWaitlist.spliterator()"
  })
  void testSpliterator() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BreadthFirstWaitlist()).spliterator().getExactSizeIfKnown());
  }
}
