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

class MethodrefConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Methodref(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodrefConstant#MethodrefConstant()}
   *   <li>{@link MethodrefConstant#toString()}
   *   <li>{@link MethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'Methodref(0,0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodrefConstant.<init>()",
    "void proguard.classfile.constant.MethodrefConstant.<init>(int, int, proguard.classfile.Clazz, proguard.classfile.Method)",
    "boolean proguard.classfile.constant.MethodrefConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.MethodrefConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsMethodref00() {
    // Arrange and Act
    MethodrefConstant actualMethodrefConstant = new MethodrefConstant();
    String actualToStringResult = actualMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualMethodrefConstant.isCategory2();

    // Assert
    assertEquals("Methodref(0,0)", actualToStringResult);
    assertNull(actualMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualMethodrefConstant.getClassIndex());
    assertEquals(0, actualMethodrefConstant.getNameAndTypeIndex());
    assertEquals(0, actualMethodrefConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Methodref(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodrefConstant#MethodrefConstant(int, int, Clazz, Method)}
   *   <li>{@link MethodrefConstant#toString()}
   *   <li>{@link MethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'Methodref(1,1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodrefConstant.<init>()",
    "void proguard.classfile.constant.MethodrefConstant.<init>(int, int, proguard.classfile.Clazz, proguard.classfile.Method)",
    "boolean proguard.classfile.constant.MethodrefConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.MethodrefConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsMethodref11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    MethodrefConstant actualMethodrefConstant =
        new MethodrefConstant(1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor"));
    String actualToStringResult = actualMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualMethodrefConstant.isCategory2();

    // Assert
    assertEquals("Methodref(1,1)", actualToStringResult);
    assertNull(actualMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualMethodrefConstant.getProcessingFlags());
    assertEquals(1, actualMethodrefConstant.getClassIndex());
    assertEquals(1, actualMethodrefConstant.getNameAndTypeIndex());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link MethodrefConstant#getTag()}.
   *
   * <p>Method under test: {@link MethodrefConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.MethodrefConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHODREF, (new MethodrefConstant()).getTag());
  }

  /**
   * Test {@link MethodrefConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodrefConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitMethodrefConstant(Clazz, MethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.MethodrefConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitMethodrefConstant() {
    // Arrange
    MethodrefConstant methodrefConstant = new MethodrefConstant();
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitMethodrefConstant(Mockito.<Clazz>any(), Mockito.<MethodrefConstant>any());

    // Act
    methodrefConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor).visitMethodrefConstant(isA(Clazz.class), isA(MethodrefConstant.class));
  }
}
