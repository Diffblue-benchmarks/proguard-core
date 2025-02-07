package proguard.classfile.visitor;

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
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;

class ImplementedClassConstantFilterDiffblueTest {
  /**
   * Test {@link ImplementedClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link ImplementedClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ImplementedClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsVisitClassConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitClassConstant(Mockito.<Clazz>any(), Mockito.<ClassConstant>any());
    ImplementedClassConstantFilter implementedClassConstantFilter =
        new ImplementedClassConstantFilter(new LibraryClass(), constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    implementedClassConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(constantVisitor).visitClassConstant(isA(Clazz.class), isA(ClassConstant.class));
  }
}
