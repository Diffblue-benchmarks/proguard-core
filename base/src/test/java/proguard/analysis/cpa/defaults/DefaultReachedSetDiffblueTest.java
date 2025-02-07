package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;

class DefaultReachedSetDiffblueTest {
  /**
   * Test {@link DefaultReachedSet#asCollection()}.
   *
   * <p>Method under test: {@link DefaultReachedSet#asCollection()}
   */
  @Test
  @DisplayName("Test asCollection()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.DefaultReachedSet.asCollection()"
  })
  void testAsCollection() {
    // Arrange
    DefaultReachedSet defaultReachedSet = new DefaultReachedSet();

    // Act
    Collection<AbstractState> actualAsCollectionResult = defaultReachedSet.asCollection();

    // Assert
    assertTrue(actualAsCollectionResult instanceof Set);
    assertTrue(actualAsCollectionResult.isEmpty());
    assertSame(defaultReachedSet, actualAsCollectionResult);
  }

  /**
   * Test new {@link DefaultReachedSet} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DefaultReachedSet}
   */
  @Test
  @DisplayName("Test new DefaultReachedSet (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.analysis.cpa.defaults.DefaultReachedSet.<init>()"})
  void testNewDefaultReachedSet() {
    // Arrange, Act and Assert
    assertTrue((new DefaultReachedSet()).isEmpty());
  }
}
