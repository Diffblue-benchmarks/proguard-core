package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.cpa.interfaces.AbstractState;

public class DefaultReachedSetDiffblueTest {
  /**
   * Method under test: {@link DefaultReachedSet#asCollection()}
   */
  @Test
  public void testAsCollection() {
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
   * Method under test: default or parameterless constructor of
   * {@link DefaultReachedSet}
   */
  @Test
  public void testNewDefaultReachedSet() {
    // Arrange, Act and Assert
    assertTrue((new DefaultReachedSet()).isEmpty());
  }
}
