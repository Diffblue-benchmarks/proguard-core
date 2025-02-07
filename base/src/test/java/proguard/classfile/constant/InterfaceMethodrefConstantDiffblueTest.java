package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;

class InterfaceMethodrefConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code InterfaceMethodref(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InterfaceMethodrefConstant#InterfaceMethodrefConstant()}
   *   <li>{@link InterfaceMethodrefConstant#toString()}
   *   <li>{@link InterfaceMethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'InterfaceMethodref(0,0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InterfaceMethodrefConstant.<init>()",
    "void proguard.classfile.constant.InterfaceMethodrefConstant.<init>(int, int, proguard.classfile.Clazz, proguard.classfile.Method)",
    "boolean proguard.classfile.constant.InterfaceMethodrefConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.InterfaceMethodrefConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsInterfaceMethodref00() {
    // Arrange and Act
    InterfaceMethodrefConstant actualInterfaceMethodrefConstant = new InterfaceMethodrefConstant();
    String actualToStringResult = actualInterfaceMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualInterfaceMethodrefConstant.isCategory2();

    // Assert
    assertEquals("InterfaceMethodref(0,0)", actualToStringResult);
    assertNull(actualInterfaceMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualInterfaceMethodrefConstant.getClassIndex());
    assertEquals(0, actualInterfaceMethodrefConstant.getNameAndTypeIndex());
    assertEquals(0, actualInterfaceMethodrefConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code InterfaceMethodref(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InterfaceMethodrefConstant#InterfaceMethodrefConstant(int, int, Clazz, Method)}
   *   <li>{@link InterfaceMethodrefConstant#toString()}
   *   <li>{@link InterfaceMethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when one; then return toString is 'InterfaceMethodref(1,1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InterfaceMethodrefConstant.<init>()",
    "void proguard.classfile.constant.InterfaceMethodrefConstant.<init>(int, int, proguard.classfile.Clazz, proguard.classfile.Method)",
    "boolean proguard.classfile.constant.InterfaceMethodrefConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.InterfaceMethodrefConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsInterfaceMethodref11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InterfaceMethodrefConstant actualInterfaceMethodrefConstant =
        new InterfaceMethodrefConstant(
            1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor"));
    String actualToStringResult = actualInterfaceMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualInterfaceMethodrefConstant.isCategory2();

    // Assert
    assertEquals("InterfaceMethodref(1,1)", actualToStringResult);
    assertNull(actualInterfaceMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualInterfaceMethodrefConstant.getProcessingFlags());
    assertEquals(1, actualInterfaceMethodrefConstant.getClassIndex());
    assertEquals(1, actualInterfaceMethodrefConstant.getNameAndTypeIndex());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link InterfaceMethodrefConstant#getTag()}.
   *
   * <p>Method under test: {@link InterfaceMethodrefConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.InterfaceMethodrefConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.INTERFACE_METHODREF, (new InterfaceMethodrefConstant()).getTag());
  }

  /**
   * Test {@link InterfaceMethodrefConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitInterfaceMethodrefConstant(Clazz,
   *       InterfaceMethodrefConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link InterfaceMethodrefConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.InterfaceMethodrefConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitInterfaceMethodrefConstant() {
    // Arrange
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitInterfaceMethodrefConstant(
            Mockito.<Clazz>any(), Mockito.<InterfaceMethodrefConstant>any());

    // Act
    interfaceMethodrefConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor)
        .visitInterfaceMethodrefConstant(isA(Clazz.class), isA(InterfaceMethodrefConstant.class));
  }
}
