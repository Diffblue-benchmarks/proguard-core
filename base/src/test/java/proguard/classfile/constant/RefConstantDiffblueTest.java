package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import proguard.classfile.LibraryField;
import proguard.classfile.visitor.ClassVisitor;

class RefConstantDiffblueTest {
  /**
   * Test {@link RefConstant#getClassIndex()}.
   *
   * <p>Method under test: {@link RefConstant#getClassIndex()}
   */
  @Test
  @DisplayName("Test getClassIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.RefConstant.getClassIndex()"})
  void testGetClassIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldrefConstant()).getClassIndex());
  }

  /**
   * Test {@link RefConstant#getNameAndTypeIndex()}.
   *
   * <p>Method under test: {@link RefConstant#getNameAndTypeIndex()}
   */
  @Test
  @DisplayName("Test getNameAndTypeIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.RefConstant.getNameAndTypeIndex()"})
  void testGetNameAndTypeIndex() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldrefConstant()).getNameAndTypeIndex());
  }

  /**
   * Test {@link RefConstant#setNameAndTypeIndex(int)}.
   *
   * <p>Method under test: {@link RefConstant#setNameAndTypeIndex(int)}
   */
  @Test
  @DisplayName("Test setNameAndTypeIndex(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.constant.RefConstant.setNameAndTypeIndex(int)"})
  void testSetNameAndTypeIndex() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act
    fieldrefConstant.setNameAndTypeIndex(1);

    // Assert
    assertEquals(1, fieldrefConstant.getNameAndTypeIndex());
  }

  /**
   * Test {@link RefConstant#getClassName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#getClassName(Clazz)}
   */
  @Test
  @DisplayName("Test getClassName(Clazz); given 'Class Name'; then return 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.RefConstant.getClassName(proguard.classfile.Clazz)"
  })
  void testGetClassName_givenClassName_thenReturnClassName() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    String actualClassName = fieldrefConstant.getClassName(clazz);

    // Assert
    verify(clazz).getClassName(eq(0));
    assertEquals("Class Name", actualClassName);
  }

  /**
   * Test {@link RefConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getName(int)} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'Name'; when LibraryClass getName(int) return 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.RefConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenName_whenLibraryClassGetNameReturnName_thenReturnName() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");

    // Act
    String actualName = fieldrefConstant.getName(clazz);

    // Assert
    verify(clazz).getName(eq(0));
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link RefConstant#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getType(int)} return {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'Type'; when LibraryClass getType(int) return 'Type'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.RefConstant.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenType_whenLibraryClassGetTypeReturnType_thenReturnType() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    String actualType = fieldrefConstant.getType(clazz);

    // Assert
    verify(clazz).getType(eq(0));
    assertEquals("Type", actualType);
  }

  /**
   * Test {@link RefConstant#referencedClassAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#referencedClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.RefConstant.referencedClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.referencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    fieldrefConstant.referencedClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link RefConstant#equals(Object)}, and {@link RefConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RefConstant#equals(Object)}
   *   <li>{@link RefConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.RefConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.RefConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    FieldrefConstant fieldrefConstant2 = new FieldrefConstant();

    // Act and Assert
    assertEquals(fieldrefConstant, fieldrefConstant2);
    int expectedHashCodeResult = fieldrefConstant.hashCode();
    assertEquals(expectedHashCodeResult, fieldrefConstant2.hashCode());
  }

  /**
   * Test {@link RefConstant#equals(Object)}, and {@link RefConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RefConstant#equals(Object)}
   *   <li>{@link RefConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.RefConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.RefConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();

    // Act and Assert
    assertEquals(fieldrefConstant, fieldrefConstant);
    int expectedHashCodeResult = fieldrefConstant.hashCode();
    assertEquals(expectedHashCodeResult, fieldrefConstant.hashCode());
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.RefConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.RefConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    FieldrefConstant fieldrefConstant =
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Act and Assert
    assertNotEquals(fieldrefConstant, new FieldrefConstant());
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.RefConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.RefConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.setNameAndTypeIndex(1);

    // Act and Assert
    assertNotEquals(fieldrefConstant, new FieldrefConstant());
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.RefConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.RefConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldrefConstant(), null);
  }

  /**
   * Test {@link RefConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RefConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.RefConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.RefConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldrefConstant(), "Different type to RefConstant");
  }

  /**
   * Test {@link RefConstant#toString()}.
   *
   * <p>Method under test: {@link RefConstant#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.classfile.constant.RefConstant.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Fieldref(0,0)", (new FieldrefConstant()).toString());
  }
}
