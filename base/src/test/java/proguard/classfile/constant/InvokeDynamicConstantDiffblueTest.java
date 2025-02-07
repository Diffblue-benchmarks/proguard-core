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
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.ClassVisitor;

class InvokeDynamicConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code InvokeDynamic(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#InvokeDynamicConstant()}
   *   <li>{@link InvokeDynamicConstant#toString()}
   *   <li>{@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link InvokeDynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link InvokeDynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'InvokeDynamic(0,0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InvokeDynamicConstant.<init>()",
    "void proguard.classfile.constant.InvokeDynamicConstant.<init>(int, int, proguard.classfile.Clazz[])",
    "int proguard.classfile.constant.InvokeDynamicConstant.getBootstrapMethodAttributeIndex()",
    "int proguard.classfile.constant.InvokeDynamicConstant.getNameAndTypeIndex()",
    "boolean proguard.classfile.constant.InvokeDynamicConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.InvokeDynamicConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsInvokeDynamic00() {
    // Arrange and Act
    InvokeDynamicConstant actualInvokeDynamicConstant = new InvokeDynamicConstant();
    String actualToStringResult = actualInvokeDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualInvokeDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualInvokeDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualInvokeDynamicConstant.isCategory2();

    // Assert
    assertEquals("InvokeDynamic(0,0)", actualToStringResult);
    assertNull(actualInvokeDynamicConstant.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodAttributeIndex);
    assertEquals(0, actualNameAndTypeIndex);
    assertEquals(0, actualInvokeDynamicConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code InvokeDynamic(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#InvokeDynamicConstant(int, int, Clazz[])}
   *   <li>{@link InvokeDynamicConstant#toString()}
   *   <li>{@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link InvokeDynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link InvokeDynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'InvokeDynamic(1,1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InvokeDynamicConstant.<init>()",
    "void proguard.classfile.constant.InvokeDynamicConstant.<init>(int, int, proguard.classfile.Clazz[])",
    "int proguard.classfile.constant.InvokeDynamicConstant.getBootstrapMethodAttributeIndex()",
    "int proguard.classfile.constant.InvokeDynamicConstant.getNameAndTypeIndex()",
    "boolean proguard.classfile.constant.InvokeDynamicConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.InvokeDynamicConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsInvokeDynamic11() {
    // Arrange and Act
    InvokeDynamicConstant actualInvokeDynamicConstant =
        new InvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});
    String actualToStringResult = actualInvokeDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualInvokeDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualInvokeDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualInvokeDynamicConstant.isCategory2();

    // Assert
    assertEquals("InvokeDynamic(1,1)", actualToStringResult);
    assertNull(actualInvokeDynamicConstant.getProcessingInfo());
    assertEquals(0, actualInvokeDynamicConstant.getProcessingFlags());
    assertEquals(1, actualBootstrapMethodAttributeIndex);
    assertEquals(1, actualNameAndTypeIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link InvokeDynamicConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getName(int)} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'Name'; when LibraryClass getName(int) return 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.InvokeDynamicConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenName_whenLibraryClassGetNameReturnName_thenReturnName() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");

    // Act
    String actualName = invokeDynamicConstant.getName(clazz);

    // Assert
    verify(clazz).getName(eq(0));
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link InvokeDynamicConstant#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getType(int)} return {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'Type'; when LibraryClass getType(int) return 'Type'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.InvokeDynamicConstant.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenType_whenLibraryClassGetTypeReturnType_thenReturnType() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    String actualType = invokeDynamicConstant.getType(clazz);

    // Assert
    verify(clazz).getType(eq(0));
    assertEquals("Type", actualType);
  }

  /**
   * Test {@link InvokeDynamicConstant#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InvokeDynamicConstant.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    invokeDynamicConstant.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    invokeDynamicConstant.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link InvokeDynamicConstant#getTag()}.
   *
   * <p>Method under test: {@link InvokeDynamicConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.InvokeDynamicConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.INVOKE_DYNAMIC, (new InvokeDynamicConstant()).getTag());
  }

  /**
   * Test {@link InvokeDynamicConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link ConstantCounter} (default constructor).
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); when ConstantCounter (default constructor); then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InvokeDynamicConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_whenConstantCounter_thenConstantCounterCountIsOne() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    LibraryClass clazz = new LibraryClass();
    ConstantCounter constantVisitor = new ConstantCounter();

    // Act
    invokeDynamicConstant.accept(clazz, constantVisitor);

    // Assert
    assertEquals(1, constantVisitor.getCount());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}, and {@link
   * InvokeDynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#equals(Object)}
   *   <li>{@link InvokeDynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.InvokeDynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.InvokeDynamicConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    InvokeDynamicConstant invokeDynamicConstant2 = new InvokeDynamicConstant();

    // Act and Assert
    assertEquals(invokeDynamicConstant, invokeDynamicConstant2);
    int expectedHashCodeResult = invokeDynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, invokeDynamicConstant2.hashCode());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}, and {@link
   * InvokeDynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#equals(Object)}
   *   <li>{@link InvokeDynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.InvokeDynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.InvokeDynamicConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act and Assert
    assertEquals(invokeDynamicConstant, invokeDynamicConstant);
    int expectedHashCodeResult = invokeDynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, invokeDynamicConstant.hashCode());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.InvokeDynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.InvokeDynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant =
        new InvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(invokeDynamicConstant, new InvokeDynamicConstant());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.InvokeDynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.InvokeDynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant =
        new InvokeDynamicConstant(0, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(invokeDynamicConstant, new InvokeDynamicConstant());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.InvokeDynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.InvokeDynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InvokeDynamicConstant(), null);
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.InvokeDynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.InvokeDynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InvokeDynamicConstant(), "Different type to InvokeDynamicConstant");
  }
}
