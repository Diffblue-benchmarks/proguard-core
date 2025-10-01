package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState;

class DefaultReachedSetDiffblueTest {
  /**
   * Test {@link DefaultReachedSet#remove(AbstractState)} with {@code AbstractState}.
   *
   * <ul>
   *   <li>Given {@link DefaultReachedSet} (default constructor) add {@link
   *       JvmMemoryLocationAbstractState#top}.
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultReachedSet#remove(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test remove(AbstractState) with 'AbstractState'; given DefaultReachedSet (default constructor) add top; when top; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultReachedSet.remove(AbstractState)"})
  void testRemoveWithAbstractState_givenDefaultReachedSetAddTop_whenTop_thenReturnTrue() {
    // Arrange
    DefaultReachedSet defaultReachedSet = new DefaultReachedSet();
    defaultReachedSet.add(JvmMemoryLocationAbstractState.top);

    // Act
    boolean actualRemoveResult =
        defaultReachedSet.remove((AbstractState) JvmMemoryLocationAbstractState.top);

    // Assert
    assertTrue(defaultReachedSet.isEmpty());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link DefaultReachedSet#remove(AbstractState)} with {@code AbstractState}.
   *
   * <ul>
   *   <li>Given {@link DefaultReachedSet} (default constructor).
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultReachedSet#remove(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test remove(AbstractState) with 'AbstractState'; given DefaultReachedSet (default constructor); when top; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultReachedSet.remove(AbstractState)"})
  void testRemoveWithAbstractState_givenDefaultReachedSet_whenTop_thenReturnFalse() {
    // Arrange
    DefaultReachedSet defaultReachedSet = new DefaultReachedSet();

    // Act and Assert
    assertFalse(defaultReachedSet.remove((AbstractState) JvmMemoryLocationAbstractState.top));
    assertTrue(defaultReachedSet.isEmpty());
  }

  /**
   * Test {@link DefaultReachedSet#asCollection()}.
   *
   * <p>Method under test: {@link DefaultReachedSet#asCollection()}
   */
  @Test
  @DisplayName("Test asCollection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DefaultReachedSet.asCollection()"})
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
   * Test {@link DefaultReachedSet#getReached(AbstractState)}.
   *
   * <p>Method under test: {@link DefaultReachedSet#getReached(AbstractState)}
   */
  @Test
  @DisplayName("Test getReached(AbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DefaultReachedSet.getReached(AbstractState)"})
  void testGetReached() {
    // Arrange
    DefaultReachedSet defaultReachedSet = new DefaultReachedSet();

    // Act
    Collection<AbstractState> actualReached =
        defaultReachedSet.getReached(JvmMemoryLocationAbstractState.top);

    // Assert
    assertTrue(actualReached instanceof Set);
    assertTrue(actualReached.isEmpty());
    assertSame(defaultReachedSet, actualReached);
  }

  /**
   * Test new {@link DefaultReachedSet} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DefaultReachedSet}
   */
  @Test
  @DisplayName("Test new DefaultReachedSet (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultReachedSet.<init>()"})
  void testNewDefaultReachedSet() {
    // Arrange, Act and Assert
    assertTrue(new DefaultReachedSet().isEmpty());
  }
}
