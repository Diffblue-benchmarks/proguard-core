package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState;

class AbstractWaitlistDiffblueTest {
  /**
   * Test {@link AbstractWaitlist#add(AbstractState)}.
   *
   * <ul>
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then {@link BreadthFirstWaitlist} (default constructor) {@link AbstractWaitlist#waitlist}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#add(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test add(AbstractState); when top; then BreadthFirstWaitlist (default constructor) waitlist size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractWaitlist.add(AbstractState)"})
  void testAdd_whenTop_thenBreadthFirstWaitlistWaitlistSizeIsOne() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();

    // Act
    breadthFirstWaitlist.add(JvmMemoryLocationAbstractState.top);

    // Assert
    assertEquals(1, breadthFirstWaitlist.waitlist.size());
    assertFalse(breadthFirstWaitlist.isEmpty());
    Iterator<AbstractState> iteratorResult = breadthFirstWaitlist.iterator();
    AbstractState actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(JvmMemoryLocationAbstractState.top, actualNextResult);
    assertEquals(1, breadthFirstWaitlist.size());
    assertEquals(1L, breadthFirstWaitlist.spliterator().getExactSizeIfKnown());
  }

  /**
   * Test {@link AbstractWaitlist#addAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link BreadthFirstWaitlist} (default constructor) iterator next {@link
   *       JvmMemoryLocationAbstractState}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); then BreadthFirstWaitlist (default constructor) iterator next JvmMemoryLocationAbstractState")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractWaitlist.addAll(Collection)"})
  void testAddAll_thenBreadthFirstWaitlistIteratorNextJvmMemoryLocationAbstractState() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();

    ArrayList<AbstractState> abstractStates = new ArrayList<>();
    abstractStates.add(JvmMemoryLocationAbstractState.top);

    // Act
    breadthFirstWaitlist.addAll(abstractStates);

    // Assert
    Iterator<AbstractState> iteratorResult = breadthFirstWaitlist.iterator();
    AbstractState nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JvmMemoryLocationAbstractState);
    assertNull(((JvmMemoryLocationAbstractState) nextResult).getSourceLocations());
    assertNull(nextResult.getPrecision());
    assertNull(((JvmMemoryLocationAbstractState) nextResult).getLocationDependentMemoryLocation());
    assertEquals(1, breadthFirstWaitlist.waitlist.size());
    assertEquals(1, breadthFirstWaitlist.size());
    assertEquals(1L, breadthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
    assertFalse(breadthFirstWaitlist.isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#addAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link BreadthFirstWaitlist} (default constructor) iterator next {@link
   *       JvmMemoryLocationAbstractState}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); then BreadthFirstWaitlist (default constructor) iterator next JvmMemoryLocationAbstractState")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractWaitlist.addAll(Collection)"})
  void testAddAll_thenBreadthFirstWaitlistIteratorNextJvmMemoryLocationAbstractState2() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();

    ArrayList<AbstractState> abstractStates = new ArrayList<>();
    abstractStates.add(JvmMemoryLocationAbstractState.top);
    abstractStates.add(JvmMemoryLocationAbstractState.top);

    // Act
    breadthFirstWaitlist.addAll(abstractStates);

    // Assert
    Iterator<AbstractState> iteratorResult = breadthFirstWaitlist.iterator();
    AbstractState nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JvmMemoryLocationAbstractState);
    assertNull(((JvmMemoryLocationAbstractState) nextResult).getSourceLocations());
    assertNull(nextResult.getPrecision());
    assertNull(((JvmMemoryLocationAbstractState) nextResult).getLocationDependentMemoryLocation());
    assertEquals(1, breadthFirstWaitlist.waitlist.size());
    assertEquals(1, breadthFirstWaitlist.size());
    assertEquals(1L, breadthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
    assertFalse(breadthFirstWaitlist.isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#addAll(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link BreadthFirstWaitlist} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection); when ArrayList(); then BreadthFirstWaitlist (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractWaitlist.addAll(Collection)"})
  void testAddAll_whenArrayList_thenBreadthFirstWaitlistSizeIsZero() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();

    // Act
    breadthFirstWaitlist.addAll(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(0, breadthFirstWaitlist.size());
    assertEquals(0L, breadthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(breadthFirstWaitlist.iterator().hasNext());
    assertTrue(breadthFirstWaitlist.waitlist.isEmpty());
    assertTrue(breadthFirstWaitlist.isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#contains(AbstractState)}.
   *
   * <ul>
   *   <li>Given {@link BreadthFirstWaitlist} (default constructor) add {@link
   *       JvmMemoryLocationAbstractState#top}.
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#contains(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test contains(AbstractState); given BreadthFirstWaitlist (default constructor) add top; when top; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractWaitlist.contains(AbstractState)"})
  void testContains_givenBreadthFirstWaitlistAddTop_whenTop_thenReturnTrue() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();
    breadthFirstWaitlist.add(JvmMemoryLocationAbstractState.top);

    // Act and Assert
    assertTrue(breadthFirstWaitlist.contains(JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test {@link AbstractWaitlist#contains(AbstractState)}.
   *
   * <ul>
   *   <li>Given {@link BreadthFirstWaitlist} (default constructor).
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#contains(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test contains(AbstractState); given BreadthFirstWaitlist (default constructor); when top; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractWaitlist.contains(AbstractState)"})
  void testContains_givenBreadthFirstWaitlist_whenTop_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BreadthFirstWaitlist().contains(JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test {@link AbstractWaitlist#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link BreadthFirstWaitlist} (default constructor) add {@link
   *       JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given BreadthFirstWaitlist (default constructor) add top; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractWaitlist.isEmpty()"})
  void testIsEmpty_givenBreadthFirstWaitlistAddTop_thenReturnFalse() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();
    breadthFirstWaitlist.add(JvmMemoryLocationAbstractState.top);

    // Act and Assert
    assertFalse(breadthFirstWaitlist.isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link BreadthFirstWaitlist} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#isEmpty()}
   */
  @Test
  @DisplayName(
      "Test isEmpty(); given BreadthFirstWaitlist (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractWaitlist.isEmpty()"})
  void testIsEmpty_givenBreadthFirstWaitlist_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BreadthFirstWaitlist().isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#remove(AbstractState)}.
   *
   * <ul>
   *   <li>Given {@link BreadthFirstWaitlist} (default constructor) add {@link
   *       JvmMemoryLocationAbstractState#top}.
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#remove(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test remove(AbstractState); given BreadthFirstWaitlist (default constructor) add top; when top; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractWaitlist.remove(AbstractState)"})
  void testRemove_givenBreadthFirstWaitlistAddTop_whenTop_thenReturnTrue() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();
    breadthFirstWaitlist.add(JvmMemoryLocationAbstractState.top);

    // Act
    boolean actualRemoveResult = breadthFirstWaitlist.remove(JvmMemoryLocationAbstractState.top);

    // Assert
    assertEquals(0, breadthFirstWaitlist.size());
    assertEquals(0L, breadthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(breadthFirstWaitlist.iterator().hasNext());
    assertTrue(breadthFirstWaitlist.waitlist.isEmpty());
    assertTrue(breadthFirstWaitlist.isEmpty());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AbstractWaitlist#remove(AbstractState)}.
   *
   * <ul>
   *   <li>Given {@link BreadthFirstWaitlist} (default constructor).
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWaitlist#remove(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test remove(AbstractState); given BreadthFirstWaitlist (default constructor); when top; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractWaitlist.remove(AbstractState)"})
  void testRemove_givenBreadthFirstWaitlist_whenTop_thenReturnFalse() {
    // Arrange
    BreadthFirstWaitlist breadthFirstWaitlist = new BreadthFirstWaitlist();

    // Act
    boolean actualRemoveResult = breadthFirstWaitlist.remove(JvmMemoryLocationAbstractState.top);

    // Assert
    assertEquals(0, breadthFirstWaitlist.size());
    assertEquals(0L, breadthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(breadthFirstWaitlist.iterator().hasNext());
    assertFalse(actualRemoveResult);
    assertTrue(breadthFirstWaitlist.waitlist.isEmpty());
    assertTrue(breadthFirstWaitlist.isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#size()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractWaitlist.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new BreadthFirstWaitlist().size());
  }

  /**
   * Test {@link AbstractWaitlist#iterator()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator AbstractWaitlist.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new BreadthFirstWaitlist().iterator().hasNext());
  }

  /**
   * Test {@link AbstractWaitlist#spliterator()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#spliterator()}
   */
  @Test
  @DisplayName("Test spliterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Spliterator AbstractWaitlist.spliterator()"})
  void testSpliterator() {
    // Arrange, Act and Assert
    assertEquals(0L, new BreadthFirstWaitlist().spliterator().getExactSizeIfKnown());
  }
}
