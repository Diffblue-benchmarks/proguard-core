package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;

class UniqueQueueDiffblueTest {
  /**
   * Test new {@link UniqueQueue} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link UniqueQueue}
   */
  @Test
  @DisplayName("Test new UniqueQueue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UniqueQueue.<init>()"})
  void testNewUniqueQueue() {
    // Arrange and Act
    UniqueQueue<Object> actualObjectList = new UniqueQueue<>();

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Test {@link UniqueQueue#addAll(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@link Constant#Null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Constant#Null}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'Collection'; given Null; when ArrayList() add Null; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UniqueQueue.addAll(Collection)"})
  void testAddAllWithCollection_givenNull_whenArrayListAddNull_thenArrayListSizeIsTwo() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add(Constant.Null);
    c.add(Constant.Null);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals(2, c.size());
    assertTrue(actualAddAllResult);
    assertSame(c.get(0), objectList.get(0));
  }

  /**
   * Test {@link UniqueQueue#addAll(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@link Constant#Null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Constant#Null}.
   *   <li>Then {@link UniqueQueue} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'Collection'; given Null; when ArrayList() add Null; then UniqueQueue (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UniqueQueue.addAll(Collection)"})
  void testAddAllWithCollection_givenNull_whenArrayListAddNull_thenUniqueQueueSizeIsOne() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add(Constant.Null);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    assertEquals(objectList, c);
  }

  /**
   * Test {@link UniqueQueue#addAll(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'Collection'; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UniqueQueue.addAll(Collection)"})
  void testAddAllWithCollection_whenArrayList_thenReturnFalse() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    ArrayList<Object> c = new ArrayList<>();

    // Act and Assert
    assertFalse(objectList.addAll(c));
    assertTrue(objectList.isEmpty());
    assertEquals(objectList, c);
  }

  /**
   * Test {@link UniqueQueue#add(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>Given {@link UniqueQueue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'Object'; given UniqueQueue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UniqueQueue.add(Object)"})
  void testAddWithObject_givenUniqueQueue() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    Object object = Constant.Null;

    // Act
    boolean actualAddResult = objectList.add(object);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(object, objectList.get(0));
  }

  /**
   * Test {@link UniqueQueue#add(Object)} with {@code Object}.
   *
   * <ul>
   *   <li>Given {@link UniqueQueue} (default constructor) add {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'Object'; given UniqueQueue (default constructor) add Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UniqueQueue.add(Object)"})
  void testAddWithObject_givenUniqueQueueAddNull() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    objectList.add(Constant.Null);
    Object object = Constant.Null;

    // Act
    boolean actualAddResult = objectList.add(object);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(object, objectList.get(0));
  }

  /**
   * Test {@link UniqueQueue#poll()}.
   *
   * <p>Method under test: {@link UniqueQueue#poll()}
   */
  @Test
  @DisplayName("Test poll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UniqueQueue.poll()"})
  void testPoll() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();

    // Act and Assert
    assertNull(objectList.poll());
  }

  /**
   * Test {@link UniqueQueue#pop()}.
   *
   * <ul>
   *   <li>Given {@link UniqueQueue} (default constructor) add {@link Constant#Null}.
   *   <li>Then {@link UniqueQueue} (default constructor) Empty.
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#pop()}
   */
  @Test
  @DisplayName(
      "Test pop(); given UniqueQueue (default constructor) add Null; then UniqueQueue (default constructor) Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UniqueQueue.pop()"})
  void testPop_givenUniqueQueueAddNull_thenUniqueQueueEmpty() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    objectList.add(Constant.Null);

    // Act
    objectList.pop();

    // Assert
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link UniqueQueue#pop()}.
   *
   * <ul>
   *   <li>Given {@link UniqueQueue} (default constructor).
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link UniqueQueue#pop()}
   */
  @Test
  @DisplayName(
      "Test pop(); given UniqueQueue (default constructor); then throw NoSuchElementException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object UniqueQueue.pop()"})
  void testPop_givenUniqueQueue_thenThrowNoSuchElementException() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> objectList.pop());
  }
}
