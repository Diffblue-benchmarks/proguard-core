package proguard.dexfile.reader;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ProtoDiffblueTest {
  /**
   * Method under test: {@link Proto#getDesc()}
   */
  @Test
  public void testGetDesc() {
    // Arrange, Act and Assert
    assertEquals("(Parameter Types)Return Type", (new Proto(new String[]{"Parameter Types"}, "Return Type")).getDesc());
    assertEquals("()Return Type", (new Proto(null, "Return Type")).getDesc());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Proto#equals(Object)}
   *   <li>{@link Proto#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");
    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(proto, proto2);
    int expectedHashCodeResult = proto.hashCode();
    assertEquals(expectedHashCodeResult, proto2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Proto#equals(Object)}
   *   <li>{@link Proto#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, null);
    Proto proto2 = new Proto(new String[]{"Parameter Types"}, null);

    // Act and Assert
    assertEquals(proto, proto2);
    int expectedHashCodeResult = proto.hashCode();
    assertEquals(expectedHashCodeResult, proto2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Proto#equals(Object)}
   *   <li>{@link Proto#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(proto, proto);
    int expectedHashCodeResult = proto.hashCode();
    assertEquals(expectedHashCodeResult, proto.hashCode());
  }

  /**
   * Method under test: {@link Proto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Proto proto = new Proto(new String[]{"Return Type"}, "Return Type");

    // Act and Assert
    assertNotEquals(proto, new Proto(new String[]{"Parameter Types"}, "Return Type"));
  }

  /**
   * Method under test: {@link Proto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, null);

    // Act and Assert
    assertNotEquals(proto, new Proto(new String[]{"Parameter Types"}, "Return Type"));
  }

  /**
   * Method under test: {@link Proto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Proto(new String[]{"Parameter Types"}, "Return Type"), null);
  }

  /**
   * Method under test: {@link Proto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Proto(new String[]{"Parameter Types"}, "Return Type"), "Different type to Proto");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Proto#Proto(String[], String)}
   *   <li>{@link Proto#getParameterTypes()}
   *   <li>{@link Proto#getReturnType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    String[] parameterTypes = new String[]{"Parameter Types"};

    // Act
    Proto actualProto = new Proto(parameterTypes, "Return Type");
    String[] actualParameterTypes = actualProto.getParameterTypes();

    // Assert
    assertEquals("Return Type", actualProto.getReturnType());
    assertSame(parameterTypes, actualParameterTypes);
    assertArrayEquals(new String[]{"Parameter Types"}, actualParameterTypes);
  }
}
