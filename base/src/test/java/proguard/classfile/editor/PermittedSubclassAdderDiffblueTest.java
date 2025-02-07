package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.PermittedSubclassesAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class PermittedSubclassAdderDiffblueTest {
  /**
   * Test {@link PermittedSubclassAdder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link PermittedSubclassAdder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.PermittedSubclassAdder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ProgramClass targetClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    PermittedSubclassAdder permittedSubclassAdder =
        new PermittedSubclassAdder(
            targetClass,
            new PermittedSubclassesAttribute(
                1,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                new int[] {1, 0, 1, 0}));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    permittedSubclassAdder.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link PermittedSubclassAdder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link PermittedSubclassAdder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant); then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.PermittedSubclassAdder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsGetName() {
    // Arrange
    ProgramClass targetClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    PermittedSubclassAdder permittedSubclassAdder =
        new PermittedSubclassAdder(
            targetClass, new PermittedSubclassesAttribute(1, 3, new int[] {1, 0, 1, 0}));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    permittedSubclassAdder.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }
}
