package proguard.classfile.editor;

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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class BridgeMethodFixerDiffblueTest {
  /**
   * Test {@link BridgeMethodFixer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#instructionsAccept(Clazz, Method, InstructionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link BridgeMethodFixer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls instructionsAccept(Clazz, Method, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BridgeMethodFixer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsInstructionsAccept() {
    // Arrange
    BridgeMethodFixer bridgeMethodFixer = new BridgeMethodFixer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    bridgeMethodFixer.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link BridgeMethodFixer#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>When {@link ProgramMethod#ProgramMethod()}.
   *   <li>Then calls {@link Clazz#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link BridgeMethodFixer#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); when ProgramMethod(); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BridgeMethodFixer.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_whenProgramMethod_thenCallsConstantPoolEntryAccept() {
    // Arrange
    BridgeMethodFixer bridgeMethodFixer = new BridgeMethodFixer();
    Clazz clazz = mock(Clazz.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ProgramMethod method = new ProgramMethod();
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    bridgeMethodFixer.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -74, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link BridgeMethodFixer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link LibraryClass#getName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link BridgeMethodFixer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); given 'Name'; then calls getName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BridgeMethodFixer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_givenName_thenCallsGetName() {
    // Arrange
    BridgeMethodFixer bridgeMethodFixer = new BridgeMethodFixer();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");

    // Act
    bridgeMethodFixer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).getName(eq(0));
  }
}
