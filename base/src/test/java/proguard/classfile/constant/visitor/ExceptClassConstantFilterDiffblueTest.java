package proguard.classfile.constant.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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

class ExceptClassConstantFilterDiffblueTest {
  /**
   * Test {@link ExceptClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ExceptClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ExceptClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ExceptClassConstantFilter exceptClassConstantFilter =
        new ExceptClassConstantFilter("Except Class Name", new ConstantLookupVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    exceptClassConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ExceptClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ExceptClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ExceptClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant2() {
    // Arrange
    ExceptClassConstantFilter exceptClassConstantFilter =
        new ExceptClassConstantFilter("String", new ConstantLookupVisitor());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    exceptClassConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ExceptClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ExceptClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ExceptClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant3() {
    // Arrange
    ExceptClassConstantFilter exceptClassConstantFilter =
        new ExceptClassConstantFilter("Except Class Name", new ConstantCounter());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    exceptClassConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ExceptClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ExceptClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ConstantVisitor constantVisitor = mock(ConstantVisitor.class);
    doNothing()
        .when(constantVisitor)
        .visitClassConstant(Mockito.<Clazz>any(), Mockito.<ClassConstant>any());
    ExceptClassConstantFilter exceptClassConstantFilter =
        new ExceptClassConstantFilter("Except Class Name", constantVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    exceptClassConstantFilter.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    verify(constantVisitor).visitClassConstant(isA(Clazz.class), isA(ClassConstant.class));
  }

  /**
   * Test {@link ExceptClassConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptClassConstantFilter#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ExceptClassConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsVisitClassConstant() {
    // Arrange
    ConstantVisitor constantVisitor = mock(ConstantVisitor.class);
    doNothing()
        .when(constantVisitor)
        .visitClassConstant(Mockito.<Clazz>any(), Mockito.<ClassConstant>any());
    ExceptClassConstantFilter exceptClassConstantFilter =
        new ExceptClassConstantFilter("Except Class Name", constantVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    exceptClassConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
    verify(constantVisitor).visitClassConstant(isA(Clazz.class), isA(ClassConstant.class));
  }
}
