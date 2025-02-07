package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class MethodHandleConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code MethodHandle(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#MethodHandleConstant()}
   *   <li>{@link MethodHandleConstant#toString()}
   *   <li>{@link MethodHandleConstant#getReferenceIndex()}
   *   <li>{@link MethodHandleConstant#getReferenceKind()}
   *   <li>{@link MethodHandleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'MethodHandle(0,0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodHandleConstant.<init>()",
    "void proguard.classfile.constant.MethodHandleConstant.<init>(int, int)",
    "int proguard.classfile.constant.MethodHandleConstant.getReferenceIndex()",
    "int proguard.classfile.constant.MethodHandleConstant.getReferenceKind()",
    "boolean proguard.classfile.constant.MethodHandleConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.MethodHandleConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsMethodHandle00() {
    // Arrange and Act
    MethodHandleConstant actualMethodHandleConstant = new MethodHandleConstant();
    String actualToStringResult = actualMethodHandleConstant.toString();
    int actualReferenceIndex = actualMethodHandleConstant.getReferenceIndex();
    int actualReferenceKind = actualMethodHandleConstant.getReferenceKind();
    boolean actualIsCategory2Result = actualMethodHandleConstant.isCategory2();

    // Assert
    assertEquals("MethodHandle(0,0)", actualToStringResult);
    assertNull(actualMethodHandleConstant.getProcessingInfo());
    assertEquals(0, actualReferenceIndex);
    assertEquals(0, actualReferenceKind);
    assertEquals(0, actualMethodHandleConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code MethodHandle(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#MethodHandleConstant(int, int)}
   *   <li>{@link MethodHandleConstant#toString()}
   *   <li>{@link MethodHandleConstant#getReferenceIndex()}
   *   <li>{@link MethodHandleConstant#getReferenceKind()}
   *   <li>{@link MethodHandleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'MethodHandle(1,1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodHandleConstant.<init>()",
    "void proguard.classfile.constant.MethodHandleConstant.<init>(int, int)",
    "int proguard.classfile.constant.MethodHandleConstant.getReferenceIndex()",
    "int proguard.classfile.constant.MethodHandleConstant.getReferenceKind()",
    "boolean proguard.classfile.constant.MethodHandleConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.MethodHandleConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsMethodHandle11() {
    // Arrange and Act
    MethodHandleConstant actualMethodHandleConstant = new MethodHandleConstant(1, 1);
    String actualToStringResult = actualMethodHandleConstant.toString();
    int actualReferenceIndex = actualMethodHandleConstant.getReferenceIndex();
    int actualReferenceKind = actualMethodHandleConstant.getReferenceKind();
    boolean actualIsCategory2Result = actualMethodHandleConstant.isCategory2();

    // Assert
    assertEquals("MethodHandle(1,1)", actualToStringResult);
    assertNull(actualMethodHandleConstant.getProcessingInfo());
    assertEquals(0, actualMethodHandleConstant.getProcessingFlags());
    assertEquals(1, actualReferenceIndex);
    assertEquals(1, actualReferenceKind);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link MethodHandleConstant#getClassName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Ref Class Name}.
   *   <li>Then return {@code Ref Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#getClassName(Clazz)}
   */
  @Test
  @DisplayName("Test getClassName(Clazz); given 'Ref Class Name'; then return 'Ref Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.MethodHandleConstant.getClassName(proguard.classfile.Clazz)"
  })
  void testGetClassName_givenRefClassName_thenReturnRefClassName() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getRefClassName(anyInt())).thenReturn("Ref Class Name");

    // Act
    String actualClassName = methodHandleConstant.getClassName(clazz);

    // Assert
    verify(clazz).getRefClassName(eq(1));
    assertEquals("Ref Class Name", actualClassName);
  }

  /**
   * Test {@link MethodHandleConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Ref Name}.
   *   <li>Then return {@code Ref Name}.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#getName(Clazz)}
   */
  @Test
  @DisplayName("Test getName(Clazz); given 'Ref Name'; then return 'Ref Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.MethodHandleConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenRefName_thenReturnRefName() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getRefName(anyInt())).thenReturn("Ref Name");

    // Act
    String actualName = methodHandleConstant.getName(clazz);

    // Assert
    verify(clazz).getRefName(eq(1));
    assertEquals("Ref Name", actualName);
  }

  /**
   * Test {@link MethodHandleConstant#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Ref Type}.
   *   <li>Then return {@code Ref Type}.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#getType(Clazz)}
   */
  @Test
  @DisplayName("Test getType(Clazz); given 'Ref Type'; then return 'Ref Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.MethodHandleConstant.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenRefType_thenReturnRefType() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getRefType(anyInt())).thenReturn("Ref Type");

    // Act
    String actualType = methodHandleConstant.getType(clazz);

    // Assert
    verify(clazz).getRefType(eq(1));
    assertEquals("Ref Type", actualType);
  }

  /**
   * Test {@link MethodHandleConstant#getTag()}.
   *
   * <p>Method under test: {@link MethodHandleConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.MethodHandleConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHOD_HANDLE, (new MethodHandleConstant(1, 1)).getTag());
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}, and {@link MethodHandleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#equals(Object)}
   *   <li>{@link MethodHandleConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodHandleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodHandleConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);
    MethodHandleConstant methodHandleConstant2 = new MethodHandleConstant(1, 1);

    // Act and Assert
    assertEquals(methodHandleConstant, methodHandleConstant2);
    int expectedHashCodeResult = methodHandleConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodHandleConstant2.hashCode());
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}, and {@link MethodHandleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#equals(Object)}
   *   <li>{@link MethodHandleConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodHandleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodHandleConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);

    // Act and Assert
    assertEquals(methodHandleConstant, methodHandleConstant);
    int expectedHashCodeResult = methodHandleConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodHandleConstant.hashCode());
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodHandleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodHandleConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(0, 1);

    // Act and Assert
    assertNotEquals(methodHandleConstant, new MethodHandleConstant(1, 1));
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodHandleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodHandleConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 0);

    // Act and Assert
    assertNotEquals(methodHandleConstant, new MethodHandleConstant(1, 1));
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodHandleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodHandleConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandleConstant(1, 1), null);
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodHandleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodHandleConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandleConstant(1, 1), "Different type to MethodHandleConstant");
  }
}
