package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;

class NameAndTypeShrinkerDiffblueTest {
  /**
   * Test {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    nameAndTypeShrinker.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass2() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getTag()).thenReturn(1);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {new ClassConstant(), classConstant}, 1, 1, 1);

    // Act
    nameAndTypeShrinker.visitProgramClass(programClass);

    // Assert that nothing has changed
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(classConstant).getTag();
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then array length is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenArrayLengthIsThree() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    // Act
    nameAndTypeShrinker.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertEquals(3, programClass.u2constantPoolCount);
    assertSame(classConstant2, constantArray[1]);
  }

  /**
   * Test {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenSecondElementIsNull() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(classConstant.getTag()).thenReturn(12);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {new ClassConstant(), classConstant}, 1, 0, 0);

    // Act
    nameAndTypeShrinker.visitProgramClass(programClass);

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(classConstant).getTag();
    verify(classConstant).getProcessingInfo();
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[1]);
    assertEquals(1, programClass.u2constantPoolCount);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link NameAndTypeShrinker#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    nameAndTypeShrinker.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link NameAndTypeShrinker#visitAnyRefConstant(Clazz, RefConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyRefConstant(Clazz, RefConstant); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitAnyRefConstant(proguard.classfile.Clazz, proguard.classfile.constant.RefConstant)"
  })
  void testVisitAnyRefConstant_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    nameAndTypeShrinker.visitAnyRefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getConstant(eq(0));
  }

  /**
   * Test {@link NameAndTypeShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstant#ClassConstant()}.
   *   <li>Then calls {@link ProgramClass#getConstant(int)}.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); given ClassConstant(); then calls getConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NameAndTypeShrinker.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_givenClassConstant_thenCallsGetConstant() {
    // Arrange
    NameAndTypeShrinker nameAndTypeShrinker = new NameAndTypeShrinker();
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getConstant(anyInt())).thenReturn(new ClassConstant());

    // Act
    nameAndTypeShrinker.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(clazz).getConstant(eq(1));
  }
}
