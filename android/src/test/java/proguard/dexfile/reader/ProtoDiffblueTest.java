package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProtoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Proto#Proto(String[], String)}
   *   <li>{@link Proto#getParameterTypes()}
   *   <li>{@link Proto#getReturnType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.Proto.<init>(java.lang.String[], java.lang.String)",
    "java.lang.String[] proguard.dexfile.reader.Proto.getParameterTypes()",
    "java.lang.String proguard.dexfile.reader.Proto.getReturnType()"
  })
  void testGettersAndSetters() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};

    // Act
    Proto actualProto = new Proto(parameterTypes, "Return Type");
    String[] actualParameterTypes = actualProto.getParameterTypes();

    // Assert
    assertEquals("Return Type", actualProto.getReturnType());
    assertSame(parameterTypes, actualParameterTypes);
    assertArrayEquals(new String[] {"Parameter Types"}, actualParameterTypes);
  }

  /**
   * Test {@link Proto#getDesc()}.
   *
   * <ul>
   *   <li>Given {@link Proto#Proto(String[], String)} with parameterTypes is {@code null} and
   *       {@code Return Type}.
   *   <li>Then return {@code ()Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link Proto#getDesc()}
   */
  @Test
  @DisplayName(
      "Test getDesc(); given Proto(String[], String) with parameterTypes is 'null' and 'Return Type'; then return '()Return Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.reader.Proto.getDesc()"})
  void testGetDesc_givenProtoWithParameterTypesIsNullAndReturnType_thenReturnReturnType() {
    // Arrange, Act and Assert
    assertEquals("()Return Type", (new Proto(null, "Return Type")).getDesc());
  }

  /**
   * Test {@link Proto#getDesc()}.
   *
   * <ul>
   *   <li>Then return {@code (Parameter Types)Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link Proto#getDesc()}
   */
  @Test
  @DisplayName("Test getDesc(); then return '(Parameter Types)Return Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.reader.Proto.getDesc()"})
  void testGetDesc_thenReturnParameterTypesReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "(Parameter Types)Return Type",
        (new Proto(new String[] {"Parameter Types"}, "Return Type")).getDesc());
  }

  /**
   * Test {@link Proto#equals(Object)}, and {@link Proto#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Proto#equals(Object)}
   *   <li>{@link Proto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");
    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(proto, proto2);
    int expectedHashCodeResult = proto.hashCode();
    assertEquals(expectedHashCodeResult, proto2.hashCode());
  }

  /**
   * Test {@link Proto#equals(Object)}, and {@link Proto#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Proto#equals(Object)}
   *   <li>{@link Proto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, null);
    Proto proto2 = new Proto(new String[] {"Parameter Types"}, null);

    // Act and Assert
    assertEquals(proto, proto2);
    int expectedHashCodeResult = proto.hashCode();
    assertEquals(expectedHashCodeResult, proto2.hashCode());
  }

  /**
   * Test {@link Proto#equals(Object)}, and {@link Proto#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Proto#equals(Object)}
   *   <li>{@link Proto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(proto, proto);
    int expectedHashCodeResult = proto.hashCode();
    assertEquals(expectedHashCodeResult, proto.hashCode());
  }

  /**
   * Test {@link Proto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Proto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Proto proto = new Proto(new String[] {"Return Type"}, "Return Type");

    // Act and Assert
    assertNotEquals(proto, new Proto(new String[] {"Parameter Types"}, "Return Type"));
  }

  /**
   * Test {@link Proto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Proto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, null);

    // Act and Assert
    assertNotEquals(proto, new Proto(new String[] {"Parameter Types"}, "Return Type"));
  }

  /**
   * Test {@link Proto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Proto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Proto(new String[] {"Parameter Types"}, "Return Type"), null);
  }

  /**
   * Test {@link Proto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Proto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.Proto.equals(java.lang.Object)",
    "int proguard.dexfile.reader.Proto.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Proto(new String[] {"Parameter Types"}, "Return Type"), "Different type to Proto");
  }
}
