package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class MethodHandleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandle#equals(Object)}
   *   <li>{@link MethodHandle#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);
    MethodHandle methodHandle2 = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertEquals(methodHandle, methodHandle2);
    int expectedHashCodeResult = methodHandle.hashCode();
    assertEquals(expectedHashCodeResult, methodHandle2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandle#equals(Object)}
   *   <li>{@link MethodHandle#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertEquals(methodHandle, methodHandle);
    int expectedHashCodeResult = methodHandle.hashCode();
    assertEquals(expectedHashCodeResult, methodHandle.hashCode());
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(0, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertNotEquals(methodHandle,
        new MethodHandle(1, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"))));
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, (Field) null));
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandle(1, new Field("Owner", "Name", "Type")), null);
  }

  /**
   * Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandle(1, new Field("Owner", "Name", "Type")), "Different type to MethodHandle");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Field)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, field);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertNull(actualMethod);
    assertEquals(1, actualMethodHandle.getType());
    assertSame(field, actualField);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Field, Method)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, field, method);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertEquals(1, actualMethodHandle.getType());
    assertSame(field, actualField);
    assertSame(method, actualMethod);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Method)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, method);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertNull(actualField);
    assertEquals(1, actualMethodHandle.getType());
    assertSame(method, actualMethod);
  }
}
