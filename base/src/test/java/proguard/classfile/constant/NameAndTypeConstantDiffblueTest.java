package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;

class NameAndTypeConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#NameAndTypeConstant()}
   *   <li>{@link NameAndTypeConstant#setDescriptorIndex(int)}
   *   <li>{@link NameAndTypeConstant#setNameIndex(int)}
   *   <li>{@link NameAndTypeConstant#toString()}
   *   <li>{@link NameAndTypeConstant#getDescriptorIndex()}
   *   <li>{@link NameAndTypeConstant#getNameIndex()}
   *   <li>{@link NameAndTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.NameAndTypeConstant.<init>()",
    "void proguard.classfile.constant.NameAndTypeConstant.<init>(int, int)",
    "int proguard.classfile.constant.NameAndTypeConstant.getDescriptorIndex()",
    "int proguard.classfile.constant.NameAndTypeConstant.getNameIndex()",
    "boolean proguard.classfile.constant.NameAndTypeConstant.isCategory2()",
    "void proguard.classfile.constant.NameAndTypeConstant.setDescriptorIndex(int)",
    "void proguard.classfile.constant.NameAndTypeConstant.setNameIndex(int)",
    "java.lang.String proguard.classfile.constant.NameAndTypeConstant.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NameAndTypeConstant actualNameAndTypeConstant = new NameAndTypeConstant();
    actualNameAndTypeConstant.setDescriptorIndex(1);
    actualNameAndTypeConstant.setNameIndex(1);
    String actualToStringResult = actualNameAndTypeConstant.toString();
    int actualDescriptorIndex = actualNameAndTypeConstant.getDescriptorIndex();
    int actualNameIndex = actualNameAndTypeConstant.getNameIndex();
    boolean actualIsCategory2Result = actualNameAndTypeConstant.isCategory2();

    // Assert
    assertEquals("NameAndType(1,1)", actualToStringResult);
    assertNull(actualNameAndTypeConstant.getProcessingInfo());
    assertEquals(0, actualNameAndTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertEquals(1, actualNameIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#NameAndTypeConstant(int, int)}
   *   <li>{@link NameAndTypeConstant#setDescriptorIndex(int)}
   *   <li>{@link NameAndTypeConstant#setNameIndex(int)}
   *   <li>{@link NameAndTypeConstant#toString()}
   *   <li>{@link NameAndTypeConstant#getDescriptorIndex()}
   *   <li>{@link NameAndTypeConstant#getNameIndex()}
   *   <li>{@link NameAndTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.NameAndTypeConstant.<init>()",
    "void proguard.classfile.constant.NameAndTypeConstant.<init>(int, int)",
    "int proguard.classfile.constant.NameAndTypeConstant.getDescriptorIndex()",
    "int proguard.classfile.constant.NameAndTypeConstant.getNameIndex()",
    "boolean proguard.classfile.constant.NameAndTypeConstant.isCategory2()",
    "void proguard.classfile.constant.NameAndTypeConstant.setDescriptorIndex(int)",
    "void proguard.classfile.constant.NameAndTypeConstant.setNameIndex(int)",
    "java.lang.String proguard.classfile.constant.NameAndTypeConstant.toString()"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    NameAndTypeConstant actualNameAndTypeConstant = new NameAndTypeConstant(1, 1);
    actualNameAndTypeConstant.setDescriptorIndex(1);
    actualNameAndTypeConstant.setNameIndex(1);
    String actualToStringResult = actualNameAndTypeConstant.toString();
    int actualDescriptorIndex = actualNameAndTypeConstant.getDescriptorIndex();
    int actualNameIndex = actualNameAndTypeConstant.getNameIndex();
    boolean actualIsCategory2Result = actualNameAndTypeConstant.isCategory2();

    // Assert
    assertEquals("NameAndType(1,1)", actualToStringResult);
    assertNull(actualNameAndTypeConstant.getProcessingInfo());
    assertEquals(0, actualNameAndTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertEquals(1, actualNameIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link NameAndTypeConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.NameAndTypeConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = nameAndTypeConstant.getName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link NameAndTypeConstant#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.NameAndTypeConstant.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualType = nameAndTypeConstant.getType(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualType);
  }

  /**
   * Test {@link NameAndTypeConstant#getTag()}.
   *
   * <p>Method under test: {@link NameAndTypeConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.NameAndTypeConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.NAME_AND_TYPE, (new NameAndTypeConstant(1, 1)).getTag());
  }

  /**
   * Test {@link NameAndTypeConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitNameAndTypeConstant(Clazz, NameAndTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.NameAndTypeConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitNameAndTypeConstant() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitNameAndTypeConstant(Mockito.<Clazz>any(), Mockito.<NameAndTypeConstant>any());

    // Act
    nameAndTypeConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor)
        .visitNameAndTypeConstant(isA(Clazz.class), isA(NameAndTypeConstant.class));
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}, and {@link NameAndTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#equals(Object)}
   *   <li>{@link NameAndTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.NameAndTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.NameAndTypeConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);
    NameAndTypeConstant nameAndTypeConstant2 = new NameAndTypeConstant(1, 1);

    // Act and Assert
    assertEquals(nameAndTypeConstant, nameAndTypeConstant2);
    int expectedHashCodeResult = nameAndTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, nameAndTypeConstant2.hashCode());
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}, and {@link NameAndTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#equals(Object)}
   *   <li>{@link NameAndTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.NameAndTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.NameAndTypeConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);

    // Act and Assert
    assertEquals(nameAndTypeConstant, nameAndTypeConstant);
    int expectedHashCodeResult = nameAndTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, nameAndTypeConstant.hashCode());
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.NameAndTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.NameAndTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(0, 1);

    // Act and Assert
    assertNotEquals(nameAndTypeConstant, new NameAndTypeConstant(1, 1));
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.NameAndTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.NameAndTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 0);

    // Act and Assert
    assertNotEquals(nameAndTypeConstant, new NameAndTypeConstant(1, 1));
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.NameAndTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.NameAndTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NameAndTypeConstant(1, 1), null);
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.NameAndTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.NameAndTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NameAndTypeConstant(1, 1), "Different type to NameAndTypeConstant");
  }
}
