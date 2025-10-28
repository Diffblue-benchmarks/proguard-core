package proguard.dexfile.reader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class MethodDiffblueTest {
  /**
   * Method under test: {@link Method#getDesc()}
   */
  @Test
  public void testGetDesc() {
    // Arrange, Act and Assert
    assertEquals("(Parameter Types)Return Type",
        (new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"))).getDesc());
  }

  /**
   * Method under test: {@link Method#getParameterTypes()}
   */
  @Test
  public void testGetParameterTypes() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"Parameter Types"},
        (new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"))).getParameterTypes());
  }

  /**
   * Method under test: {@link Method#getReturnType()}
   */
  @Test
  public void testGetReturnType() {
    // Arrange, Act and Assert
    assertEquals("Return Type",
        (new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"))).getReturnType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));
    Method method2 = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method2);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Method method = new Method(null, "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));
    Method method2 = new Method(null, "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method2);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Method method = new Method("Owner", null, new Proto(new String[]{"Parameter Types"}, "Return Type"));
    Method method2 = new Method("Owner", null, new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method2);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Method#equals(Object)}
   *   <li>{@link Method#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertEquals(method, method);
    int expectedHashCodeResult = method.hashCode();
    assertEquals(expectedHashCodeResult, method.hashCode());
  }

  /**
   * Method under test: {@link Method#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Method method = new Method("Name", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(method, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));
  }

  /**
   * Method under test: {@link Method#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Method method = new Method(null, "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(method, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));
  }

  /**
   * Method under test: {@link Method#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Method method = new Method("Owner", "Owner", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(method, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));
  }

  /**
   * Method under test: {@link Method#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Method method = new Method("Owner", null, new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act and Assert
    assertNotEquals(method, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));
  }

  /**
   * Method under test: {@link Method#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")), null);
  }

  /**
   * Method under test: {@link Method#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")),
        "Different type to Method");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Method#Method(String, String, Proto)}
   *   <li>{@link Method#toString()}
   *   <li>{@link Method#getName()}
   *   <li>{@link Method#getOwner()}
   *   <li>{@link Method#getProto()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    Method actualMethod = new Method("Owner", "Name", proto);
    String actualToStringResult = actualMethod.toString();
    String actualName = actualMethod.getName();
    String actualOwner = actualMethod.getOwner();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Owner", actualOwner);
    assertEquals("Owner->Name(Parameter Types)Return Type", actualToStringResult);
    assertSame(proto, actualMethod.getProto());
  }

  /**
   * Method under test: {@link Method#Method(String, String, String[], String)}
   */
  @Test
  public void testNewMethod() {
    // Arrange
    String[] parameterTypes = new String[]{"Parameter Types"};

    // Act
    Method actualMethod = new Method("Owner", "Name", parameterTypes, "Return Type");

    // Assert
    assertEquals("(Parameter Types)Return Type", actualMethod.getDesc());
    Proto proto = actualMethod.getProto();
    assertEquals("(Parameter Types)Return Type", proto.getDesc());
    assertEquals("Name", actualMethod.getName());
    assertEquals("Owner", actualMethod.getOwner());
    assertEquals("Return Type", actualMethod.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    String[] parameterTypes2 = actualMethod.getParameterTypes();
    assertSame(parameterTypes, parameterTypes2);
    assertSame(parameterTypes, proto.getParameterTypes());
    assertArrayEquals(new String[]{"Parameter Types"}, parameterTypes2);
  }
}
