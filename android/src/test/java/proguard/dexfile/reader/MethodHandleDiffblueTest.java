package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MethodHandleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Field is {@link Field#Field(String, String, String)} with {@code Owner} and
   *       {@code Name} and {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Field, Method)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return Field is Field(String, String, String) with 'Owner' and 'Name' and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Field)",
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Field, proguard.dexfile.reader.Method)",
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Method)",
    "proguard.dexfile.reader.Field proguard.dexfile.reader.MethodHandle.getField()",
    "proguard.dexfile.reader.Method proguard.dexfile.reader.MethodHandle.getMethod()",
    "int proguard.dexfile.reader.MethodHandle.getType()"
  })
  void testGettersAndSetters_thenReturnFieldIsFieldWithOwnerAndNameAndType() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

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
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Field is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Method)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Field is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Field)",
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Field, proguard.dexfile.reader.Method)",
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Method)",
    "proguard.dexfile.reader.Field proguard.dexfile.reader.MethodHandle.getField()",
    "proguard.dexfile.reader.Method proguard.dexfile.reader.MethodHandle.getMethod()",
    "int proguard.dexfile.reader.MethodHandle.getType()"
  })
  void testGettersAndSetters_thenReturnFieldIsNull() {
    // Arrange
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    // Act
    MethodHandle actualMethodHandle = new MethodHandle(1, method);
    Field actualField = actualMethodHandle.getField();
    Method actualMethod = actualMethodHandle.getMethod();

    // Assert
    assertNull(actualField);
    assertEquals(1, actualMethodHandle.getType());
    assertSame(method, actualMethod);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   *   <li>Then return Method is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#MethodHandle(int, Field)}
   *   <li>{@link MethodHandle#getField()}
   *   <li>{@link MethodHandle#getMethod()}
   *   <li>{@link MethodHandle#getType()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when Field(String, String, String) with 'Owner' and 'Name' and 'Type'; then return Method is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Field)",
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Field, proguard.dexfile.reader.Method)",
    "void proguard.dexfile.reader.MethodHandle.<init>(int, proguard.dexfile.reader.Method)",
    "proguard.dexfile.reader.Field proguard.dexfile.reader.MethodHandle.getField()",
    "proguard.dexfile.reader.Method proguard.dexfile.reader.MethodHandle.getMethod()",
    "int proguard.dexfile.reader.MethodHandle.getType()"
  })
  void testGettersAndSetters_whenFieldWithOwnerAndNameAndType_thenReturnMethodIsNull() {
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
   * Test {@link MethodHandle#equals(Object)}, and {@link MethodHandle#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#equals(Object)}
   *   <li>{@link MethodHandle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);
    MethodHandle methodHandle2 = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertEquals(methodHandle, methodHandle2);
    int expectedHashCodeResult = methodHandle.hashCode();
    assertEquals(expectedHashCodeResult, methodHandle2.hashCode());
  }

  /**
   * Test {@link MethodHandle#equals(Object)}, and {@link MethodHandle#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandle#equals(Object)}
   *   <li>{@link MethodHandle#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertEquals(methodHandle, methodHandle);
    int expectedHashCodeResult = methodHandle.hashCode();
    assertEquals(expectedHashCodeResult, methodHandle.hashCode());
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(0, new Field("Owner", "Name", "Type"));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, new Field("Owner", "Name", "Type")));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MethodHandle methodHandle = new MethodHandle(1, (Field) null);

    // Act and Assert
    assertNotEquals(
        methodHandle,
        new MethodHandle(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"))));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MethodHandle methodHandle =
        new MethodHandle(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act and Assert
    assertNotEquals(methodHandle, new MethodHandle(1, (Field) null));
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandle(1, new Field("Owner", "Name", "Type")), null);
  }

  /**
   * Test {@link MethodHandle#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandle#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.reader.MethodHandle.equals(java.lang.Object)",
    "int proguard.dexfile.reader.MethodHandle.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MethodHandle(1, new Field("Owner", "Name", "Type")), "Different type to MethodHandle");
  }
}
