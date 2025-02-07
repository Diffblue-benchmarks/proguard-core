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

class DynamicConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Dynamic(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#DynamicConstant()}
   *   <li>{@link DynamicConstant#toString()}
   *   <li>{@link DynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link DynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link DynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'Dynamic(0,0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.DynamicConstant.<init>()",
    "void proguard.classfile.constant.DynamicConstant.<init>(int, int, proguard.classfile.Clazz[])",
    "int proguard.classfile.constant.DynamicConstant.getBootstrapMethodAttributeIndex()",
    "int proguard.classfile.constant.DynamicConstant.getNameAndTypeIndex()",
    "boolean proguard.classfile.constant.DynamicConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.DynamicConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsDynamic00() {
    // Arrange and Act
    DynamicConstant actualDynamicConstant = new DynamicConstant();
    String actualToStringResult = actualDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualDynamicConstant.isCategory2();

    // Assert
    assertEquals("Dynamic(0,0)", actualToStringResult);
    assertNull(actualDynamicConstant.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodAttributeIndex);
    assertEquals(0, actualNameAndTypeIndex);
    assertEquals(0, actualDynamicConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Dynamic(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#DynamicConstant(int, int, Clazz[])}
   *   <li>{@link DynamicConstant#toString()}
   *   <li>{@link DynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link DynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link DynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'Dynamic(1,1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.DynamicConstant.<init>()",
    "void proguard.classfile.constant.DynamicConstant.<init>(int, int, proguard.classfile.Clazz[])",
    "int proguard.classfile.constant.DynamicConstant.getBootstrapMethodAttributeIndex()",
    "int proguard.classfile.constant.DynamicConstant.getNameAndTypeIndex()",
    "boolean proguard.classfile.constant.DynamicConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.DynamicConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsDynamic11() {
    // Arrange and Act
    DynamicConstant actualDynamicConstant =
        new DynamicConstant(1, 1, new Clazz[] {new LibraryClass()});
    String actualToStringResult = actualDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualDynamicConstant.isCategory2();

    // Assert
    assertEquals("Dynamic(1,1)", actualToStringResult);
    assertNull(actualDynamicConstant.getProcessingInfo());
    assertEquals(0, actualDynamicConstant.getProcessingFlags());
    assertEquals(1, actualBootstrapMethodAttributeIndex);
    assertEquals(1, actualNameAndTypeIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link DynamicConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getName(int)} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'Name'; when LibraryClass getName(int) return 'Name'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.DynamicConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenName_whenLibraryClassGetNameReturnName_thenReturnName() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");

    // Act
    String actualName = dynamicConstant.getName(clazz);

    // Assert
    verify(clazz).getName(eq(0));
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link DynamicConstant#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getType(int)} return {@code Type}.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'Type'; when LibraryClass getType(int) return 'Type'; then return 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.DynamicConstant.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenType_whenLibraryClassGetTypeReturnType_thenReturnType() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    String actualType = dynamicConstant.getType(clazz);

    // Assert
    verify(clazz).getType(eq(0));
    assertEquals("Type", actualType);
  }

  /**
   * Test {@link DynamicConstant#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.DynamicConstant.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    dynamicConstant.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    dynamicConstant.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link DynamicConstant#getTag()}.
   *
   * <p>Method under test: {@link DynamicConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.DynamicConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.DYNAMIC, (new DynamicConstant()).getTag());
  }

  /**
   * Test {@link DynamicConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link ConstantCounter} (default constructor).
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); when ConstantCounter (default constructor); then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.DynamicConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_whenConstantCounter_thenConstantCounterCountIsOne() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    LibraryClass clazz = new LibraryClass();
    ConstantCounter constantVisitor = new ConstantCounter();

    // Act
    dynamicConstant.accept(clazz, constantVisitor);

    // Assert
    assertEquals(1, constantVisitor.getCount());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}, and {@link DynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#equals(Object)}
   *   <li>{@link DynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DynamicConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    DynamicConstant dynamicConstant2 = new DynamicConstant();

    // Act and Assert
    assertEquals(dynamicConstant, dynamicConstant2);
    int expectedHashCodeResult = dynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, dynamicConstant2.hashCode());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}, and {@link DynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#equals(Object)}
   *   <li>{@link DynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DynamicConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act and Assert
    assertEquals(dynamicConstant, dynamicConstant);
    int expectedHashCodeResult = dynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, dynamicConstant.hashCode());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(dynamicConstant, new DynamicConstant());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant(0, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(dynamicConstant, new DynamicConstant());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicConstant(), null);
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.DynamicConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.DynamicConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicConstant(), "Different type to DynamicConstant");
  }
}
