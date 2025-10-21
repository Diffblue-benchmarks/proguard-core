package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.interfaces.AbstractState;

public class DefaultReachedSetDiffblueTest {
  /**
   * Test {@link DefaultReachedSet#asCollection()}.
   *
   * <p>Method under test: {@link DefaultReachedSet#asCollection()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection DefaultReachedSet.asCollection()"})
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
   * Test new {@link DefaultReachedSet} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DefaultReachedSet}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultReachedSet.<init>()"})
  public void testNewDefaultReachedSet() {
    // Arrange, Act and Assert
    assertTrue((new DefaultReachedSet()).isEmpty());
  }
}
