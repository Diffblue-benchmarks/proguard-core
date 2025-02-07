package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;

class ImplementingClassConstantFilterDiffblueTest {
  /**
   * Test {@link ImplementingClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#extendsOrImplements(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ImplementingClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls extendsOrImplements(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ImplementingClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsExtendsOrImplements() {
    // Arrange
    LibraryClass implementingClass = mock(LibraryClass.class);
    when(implementingClass.extendsOrImplements(Mockito.<Clazz>any())).thenReturn(true);
    ImplementingClassConstantFilter implementingClassConstantFilter =
        new ImplementingClassConstantFilter(implementingClass, new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();
    classConstant.referencedClass = new LibraryClass();

    // Act
    implementingClassConstantFilter.visitClassConstant(clazz, classConstant);

    // Assert
    verify(implementingClass).extendsOrImplements(isA(Clazz.class));
  }

  /**
   * Test {@link ImplementingClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link ImplementingClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ImplementingClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsVisitClassConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitClassConstant(Mockito.<Clazz>any(), Mockito.<ClassConstant>any());
    ImplementingClassConstantFilter implementingClassConstantFilter =
        new ImplementingClassConstantFilter(new LibraryClass(), constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    implementingClassConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(constantVisitor).visitClassConstant(isA(Clazz.class), isA(ClassConstant.class));
  }
}
