package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;

public class UniqueQueueDiffblueTest {
  /**
   * Test new {@link UniqueQueue} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link UniqueQueue}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UniqueQueue.<init>()"})
  public void testNewUniqueQueue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UniqueQueue.addAll(Collection)"})
  public void testAddAllWithCollection_givenNull_whenArrayListAddNull_thenArrayListSizeIsTwo() {
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
    Object expectedGetResult = c.get(0);
    assertSame(expectedGetResult, objectList.get(0));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UniqueQueue.addAll(Collection)"})
  public void testAddAllWithCollection_givenNull_whenArrayListAddNull_thenUniqueQueueSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UniqueQueue.addAll(Collection)"})
  public void testAddAllWithCollection_whenArrayList_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UniqueQueue.add(Object)"})
  public void testAddWithObject_givenUniqueQueue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UniqueQueue.add(Object)"})
  public void testAddWithObject_givenUniqueQueueAddNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object UniqueQueue.poll()"})
  public void testPoll() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object UniqueQueue.pop()"})
  public void testPop_givenUniqueQueueAddNull_thenUniqueQueueEmpty() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    objectList.add(Constant.Null);

    // Act
    objectList.pop();

    // Assert
    assertTrue(objectList.isEmpty());
  }
}
