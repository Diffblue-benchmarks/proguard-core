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

class ModuleConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Module(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#ModuleConstant()}
   *   <li>{@link ModuleConstant#toString()}
   *   <li>{@link ModuleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'Module(0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ModuleConstant.<init>()",
    "void proguard.classfile.constant.ModuleConstant.<init>(int)",
    "boolean proguard.classfile.constant.ModuleConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.ModuleConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsModule0() {
    // Arrange and Act
    ModuleConstant actualModuleConstant = new ModuleConstant();
    String actualToStringResult = actualModuleConstant.toString();
    boolean actualIsCategory2Result = actualModuleConstant.isCategory2();

    // Assert
    assertEquals("Module(0)", actualToStringResult);
    assertNull(actualModuleConstant.getProcessingInfo());
    assertEquals(0, actualModuleConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Module(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#ModuleConstant(int)}
   *   <li>{@link ModuleConstant#toString()}
   *   <li>{@link ModuleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'Module(1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ModuleConstant.<init>()",
    "void proguard.classfile.constant.ModuleConstant.<init>(int)",
    "boolean proguard.classfile.constant.ModuleConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.ModuleConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsModule1() {
    // Arrange and Act
    ModuleConstant actualModuleConstant = new ModuleConstant(1);
    String actualToStringResult = actualModuleConstant.toString();
    boolean actualIsCategory2Result = actualModuleConstant.isCategory2();

    // Assert
    assertEquals("Module(1)", actualToStringResult);
    assertNull(actualModuleConstant.getProcessingInfo());
    assertEquals(0, actualModuleConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link ModuleConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.ModuleConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = moduleConstant.getName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link ModuleConstant#getTag()}.
   *
   * <p>Method under test: {@link ModuleConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.ModuleConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.MODULE, (new ModuleConstant(1)).getTag());
  }

  /**
   * Test {@link ModuleConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitModuleConstant(Clazz, ModuleConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitModuleConstant(Clazz, ModuleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.ModuleConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitModuleConstant() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitModuleConstant(Mockito.<Clazz>any(), Mockito.<ModuleConstant>any());

    // Act
    moduleConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor).visitModuleConstant(isA(Clazz.class), isA(ModuleConstant.class));
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}, and {@link ModuleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#equals(Object)}
   *   <li>{@link ModuleConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ModuleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ModuleConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);
    ModuleConstant moduleConstant2 = new ModuleConstant(1);

    // Act and Assert
    assertEquals(moduleConstant, moduleConstant2);
    int expectedHashCodeResult = moduleConstant.hashCode();
    assertEquals(expectedHashCodeResult, moduleConstant2.hashCode());
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}, and {@link ModuleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#equals(Object)}
   *   <li>{@link ModuleConstant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ModuleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ModuleConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act and Assert
    assertEquals(moduleConstant, moduleConstant);
    int expectedHashCodeResult = moduleConstant.hashCode();
    assertEquals(expectedHashCodeResult, moduleConstant.hashCode());
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ModuleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ModuleConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(0);

    // Act and Assert
    assertNotEquals(moduleConstant, new ModuleConstant(1));
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ModuleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ModuleConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConstant(1), null);
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.ModuleConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.ModuleConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConstant(1), "Different type to ModuleConstant");
  }
}
