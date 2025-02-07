package proguard.classfile.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class DynamicMemberReferenceInitializerDiffblueTest {
  /**
   * Test {@link DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool,
   * ClassPool, WarningPrinter, StringMatcher, StringMatcher)}.
   *
   * <p>Method under test: {@link
   * DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool, ClassPool,
   * WarningPrinter, StringMatcher, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test new DynamicMemberReferenceInitializer(ClassPool, ClassPool, WarningPrinter, StringMatcher, StringMatcher)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.util.StringMatcher, proguard.util.StringMatcher)"
  })
  void testNewDynamicMemberReferenceInitializer() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "java/lang/Class", "java/lang/Class"));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();

    // Act
    new DynamicMemberReferenceInitializer(
        programClassPool,
        KotlinConstants.dummyClassPool,
        notePrinter,
        noteFieldExceptionMatcher,
        new EmptyStringMatcher());

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool,
   * ClassPool, WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)}.
   *
   * <p>Method under test: {@link
   * DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool, ClassPool,
   * WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test new DynamicMemberReferenceInitializer(ClassPool, ClassPool, WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.util.StringMatcher, proguard.util.StringMatcher, proguard.classfile.visitor.MemberVisitor)"
  })
  void testNewDynamicMemberReferenceInitializer2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "java/lang/Class", "java/lang/Class"));
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    EmptyStringMatcher noteMethodExceptionMatcher = new EmptyStringMatcher();

    // Act
    new DynamicMemberReferenceInitializer(
        programClassPool,
        KotlinConstants.dummyClassPool,
        notePrinter,
        noteFieldExceptionMatcher,
        noteMethodExceptionMatcher,
        new AttributeSorter());

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool,
   * ClassPool, WarningPrinter, StringMatcher, StringMatcher)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool, ClassPool,
   * WarningPrinter, StringMatcher, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test new DynamicMemberReferenceInitializer(ClassPool, ClassPool, WarningPrinter, StringMatcher, StringMatcher); given ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.util.StringMatcher, proguard.util.StringMatcher)"
  })
  void testNewDynamicMemberReferenceInitializer_givenProgramClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();

    // Act
    new DynamicMemberReferenceInitializer(
        programClassPool,
        KotlinConstants.dummyClassPool,
        notePrinter,
        noteFieldExceptionMatcher,
        new EmptyStringMatcher());

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool,
   * ClassPool, WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool, ClassPool,
   * WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test new DynamicMemberReferenceInitializer(ClassPool, ClassPool, WarningPrinter, StringMatcher, StringMatcher, MemberVisitor); given ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.util.StringMatcher, proguard.util.StringMatcher, proguard.classfile.visitor.MemberVisitor)"
  })
  void testNewDynamicMemberReferenceInitializer_givenProgramClass2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    EmptyStringMatcher noteMethodExceptionMatcher = new EmptyStringMatcher();

    // Act
    new DynamicMemberReferenceInitializer(
        programClassPool,
        KotlinConstants.dummyClassPool,
        notePrinter,
        noteFieldExceptionMatcher,
        noteMethodExceptionMatcher,
        new AttributeSorter());

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool,
   * ClassPool, WarningPrinter, StringMatcher, StringMatcher)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   *       ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool, ClassPool,
   * WarningPrinter, StringMatcher, StringMatcher)}
   */
  @Test
  @DisplayName(
      "Test new DynamicMemberReferenceInitializer(ClassPool, ClassPool, WarningPrinter, StringMatcher, StringMatcher); then calls hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.util.StringMatcher, proguard.util.StringMatcher)"
  })
  void testNewDynamicMemberReferenceInitializer_thenCallsHierarchyAccept() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();

    // Act
    new DynamicMemberReferenceInitializer(
        programClassPool,
        KotlinConstants.dummyClassPool,
        notePrinter,
        noteFieldExceptionMatcher,
        new EmptyStringMatcher());

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(libraryClass, atLeast(1))
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(false), Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool,
   * ClassPool, WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   *       ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicMemberReferenceInitializer#DynamicMemberReferenceInitializer(ClassPool, ClassPool,
   * WarningPrinter, StringMatcher, StringMatcher, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test new DynamicMemberReferenceInitializer(ClassPool, ClassPool, WarningPrinter, StringMatcher, StringMatcher, MemberVisitor); then calls hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.util.StringMatcher, proguard.util.StringMatcher, proguard.classfile.visitor.MemberVisitor)"
  })
  void testNewDynamicMemberReferenceInitializer_thenCallsHierarchyAccept2() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    EmptyStringMatcher noteMethodExceptionMatcher = new EmptyStringMatcher();

    // Act
    new DynamicMemberReferenceInitializer(
        programClassPool,
        KotlinConstants.dummyClassPool,
        notePrinter,
        noteFieldExceptionMatcher,
        noteMethodExceptionMatcher,
        new AttributeSorter());

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(libraryClass, atLeast(1))
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(false), Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicMemberReferenceInitializer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    DynamicMemberReferenceInitializer dynamicMemberReferenceInitializer =
        new DynamicMemberReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            notePrinter,
            noteFieldExceptionMatcher,
            new EmptyStringMatcher());
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    dynamicMemberReferenceInitializer.visitProgramClass(programClass);

    // Assert
    verify(programClass).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#visitAnyInstruction(Clazz, Method, CodeAttribute,
   * int, Instruction)}.
   *
   * <ul>
   *   <li>When {@link BranchInstruction} {@link BranchInstruction#accept(Clazz, Method,
   *       CodeAttribute, int, InstructionVisitor)} does nothing.
   *   <li>Then calls {@link ClassPool#getClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicMemberReferenceInitializer#visitAnyInstruction(Clazz,
   * Method, CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction); when BranchInstruction accept(Clazz, Method, CodeAttribute, int, InstructionVisitor) does nothing; then calls getClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction_whenBranchInstructionAcceptDoesNothing_thenCallsGetClass() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    DynamicMemberReferenceInitializer dynamicMemberReferenceInitializer =
        new DynamicMemberReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            notePrinter,
            noteFieldExceptionMatcher,
            new EmptyStringMatcher());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    BranchInstruction instruction = mock(BranchInstruction.class);
    doNothing()
        .when(instruction)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<InstructionVisitor>any());

    // Act
    dynamicMemberReferenceInitializer.visitAnyInstruction(
        clazz, method, codeAttribute, 2, instruction);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(libraryClass, atLeast(1))
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(false), Mockito.<ClassVisitor>any());
    verify(instruction, atLeast(1))
        .accept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            Mockito.<InstructionVisitor>any());
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link DynamicMemberReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenEmptyString() {
    // Arrange
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    DynamicMemberReferenceInitializer dynamicMemberReferenceInitializer =
        new DynamicMemberReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            notePrinter,
            noteFieldExceptionMatcher,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("");

    // Act
    dynamicMemberReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicMemberReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    DynamicMemberReferenceInitializer dynamicMemberReferenceInitializer =
        new DynamicMemberReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            notePrinter,
            noteFieldExceptionMatcher,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    dynamicMemberReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicMemberReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'String'; when LibraryClass getString(int) return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenString_whenLibraryClassGetStringReturnString() {
    // Arrange
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    DynamicMemberReferenceInitializer dynamicMemberReferenceInitializer =
        new DynamicMemberReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            notePrinter,
            noteFieldExceptionMatcher,
            new EmptyStringMatcher());
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    dynamicMemberReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link DynamicMemberReferenceInitializer#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#getString(int)} return {@code <init>}.
   *   <li>Then calls {@link ProgramClass#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicMemberReferenceInitializer#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); when ProgramClass getString(int) return '<init>'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.DynamicMemberReferenceInitializer.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_whenProgramClassGetStringReturnInit_thenCallsGetName() {
    // Arrange
    WarningPrinter notePrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    EmptyStringMatcher noteFieldExceptionMatcher = new EmptyStringMatcher();
    DynamicMemberReferenceInitializer dynamicMemberReferenceInitializer =
        new DynamicMemberReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            notePrinter,
            noteFieldExceptionMatcher,
            new EmptyStringMatcher());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("<init>");
    when(programClass.getName()).thenReturn("Name");

    // Act
    dynamicMemberReferenceInitializer.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getName();
    verify(programClass, atLeast(1)).getString(eq(0));
  }
}
