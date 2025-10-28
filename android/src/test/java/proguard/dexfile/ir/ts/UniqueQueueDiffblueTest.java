package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;

public class UniqueQueueDiffblueTest {
  /**
   * Method under test: {@link UniqueQueue#addAll(Collection)}
   */
  @Test
  public void testAddAll() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    ArrayList<Object> c = new ArrayList<>();

    // Act and Assert
    assertFalse(objectList.addAll(c));
    assertTrue(objectList.isEmpty());
    assertTrue(c.isEmpty());
  }

  /**
   * Method under test: {@link UniqueQueue#addAll(Collection)}
   */
  @Test
  public void testAddAll2() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add(Constant.Null);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    Object expectedGetResult = c.get(0);
    assertSame(expectedGetResult, objectList.get(0));
  }

  /**
   * Method under test: {@link UniqueQueue#addAll(Collection)}
   */
  @Test
  public void testAddAll3() {
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
   * Method under test: {@link UniqueQueue#add(Object)}
   */
  @Test
  public void testAdd() {
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
   * Method under test: {@link UniqueQueue#add(Object)}
   */
  @Test
  public void testAdd2() {
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
   * Method under test: {@link UniqueQueue#poll()}
   */
  @Test
  public void testPoll() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();

    // Act and Assert
    assertNull(objectList.poll());
  }

  /**
   * Method under test: {@link UniqueQueue#pop()}
   */
  @Test
  public void testPop() {
    // Arrange
    UniqueQueue<Object> objectList = new UniqueQueue<>();
    objectList.add(Constant.Null);

    // Act
    objectList.pop();

    // Assert
    assertTrue(objectList.isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link UniqueQueue}
   */
  @Test
  public void testNewUniqueQueue() {
    // Arrange and Act
    UniqueQueue<Object> actualObjectList = new UniqueQueue<>();

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }
}
