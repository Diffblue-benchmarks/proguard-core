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
import proguard.classfile.visitor.ClassVisitor;

class MethodTypeConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code MethodType(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#MethodTypeConstant()}
   *   <li>{@link MethodTypeConstant#toString()}
   *   <li>{@link MethodTypeConstant#getDescriptorIndex()}
   *   <li>{@link MethodTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'MethodType(0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodTypeConstant.<init>()",
    "void proguard.classfile.constant.MethodTypeConstant.<init>(int, proguard.classfile.Clazz[])",
    "int proguard.classfile.constant.MethodTypeConstant.getDescriptorIndex()",
    "boolean proguard.classfile.constant.MethodTypeConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.MethodTypeConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsMethodType0() {
    // Arrange and Act
    MethodTypeConstant actualMethodTypeConstant = new MethodTypeConstant();
    String actualToStringResult = actualMethodTypeConstant.toString();
    int actualDescriptorIndex = actualMethodTypeConstant.getDescriptorIndex();
    boolean actualIsCategory2Result = actualMethodTypeConstant.isCategory2();

    // Assert
    assertEquals("MethodType(0)", actualToStringResult);
    assertNull(actualMethodTypeConstant.getProcessingInfo());
    assertEquals(0, actualDescriptorIndex);
    assertEquals(0, actualMethodTypeConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code MethodType(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#MethodTypeConstant(int, Clazz[])}
   *   <li>{@link MethodTypeConstant#toString()}
   *   <li>{@link MethodTypeConstant#getDescriptorIndex()}
   *   <li>{@link MethodTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'MethodType(1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodTypeConstant.<init>()",
    "void proguard.classfile.constant.MethodTypeConstant.<init>(int, proguard.classfile.Clazz[])",
    "int proguard.classfile.constant.MethodTypeConstant.getDescriptorIndex()",
    "boolean proguard.classfile.constant.MethodTypeConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.MethodTypeConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsMethodType1() {
    // Arrange and Act
    MethodTypeConstant actualMethodTypeConstant =
        new MethodTypeConstant(1, new Clazz[] {new LibraryClass()});
    String actualToStringResult = actualMethodTypeConstant.toString();
    int actualDescriptorIndex = actualMethodTypeConstant.getDescriptorIndex();
    boolean actualIsCategory2Result = actualMethodTypeConstant.isCategory2();

    // Assert
    assertEquals("MethodType(1)", actualToStringResult);
    assertNull(actualMethodTypeConstant.getProcessingInfo());
    assertEquals(0, actualMethodTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link MethodTypeConstant#getType(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#getType(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getType(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.MethodTypeConstant.getType(proguard.classfile.Clazz)"
  })
  void testGetType_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualType = methodTypeConstant.getType(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualType);
  }

  /**
   * Test {@link MethodTypeConstant#referencedClassesAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#referencedClassesAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedClassesAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodTypeConstant.referencedClassesAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedClassesAccept_thenCallsVisitLibraryClass() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    methodTypeConstant.referencedClasses = new Clazz[] {new LibraryClass()};
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    methodTypeConstant.referencedClassesAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link MethodTypeConstant#getTag()}.
   *
   * <p>Method under test: {@link MethodTypeConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.MethodTypeConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHOD_TYPE, (new MethodTypeConstant()).getTag());
  }

  /**
   * Test {@link MethodTypeConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodTypeConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitMethodTypeConstant() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitMethodTypeConstant(Mockito.<Clazz>any(), Mockito.<MethodTypeConstant>any());

    // Act
    methodTypeConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor)
        .visitMethodTypeConstant(isA(Clazz.class), isA(MethodTypeConstant.class));
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}, and {@link MethodTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#equals(Object)}
   *   <li>{@link MethodTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodTypeConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    MethodTypeConstant methodTypeConstant2 = new MethodTypeConstant();

    // Act and Assert
    assertEquals(methodTypeConstant, methodTypeConstant2);
    int expectedHashCodeResult = methodTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodTypeConstant2.hashCode());
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}, and {@link MethodTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#equals(Object)}
   *   <li>{@link MethodTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodTypeConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act and Assert
    assertEquals(methodTypeConstant, methodTypeConstant);
    int expectedHashCodeResult = methodTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodTypeConstant.hashCode());
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant =
        new MethodTypeConstant(1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(methodTypeConstant, new MethodTypeConstant());
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodTypeConstant(), null);
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.MethodTypeConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.MethodTypeConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodTypeConstant(), "Different type to MethodTypeConstant");
  }
}
