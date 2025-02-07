package proguard.classfile.editor;

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
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.visitor.ConstantVisitor;

class InterfaceAdderDiffblueTest {
  /**
   * Test {@link InterfaceAdder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link InterfaceAdder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); when LibraryClass; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InterfaceAdder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_whenLibraryClass_thenCallsAccept() {
    // Arrange
    InterfaceAdder interfaceAdder =
        new InterfaceAdder(new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    interfaceAdder.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }
}
