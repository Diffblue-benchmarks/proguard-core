package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.ExceptionsAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;
import proguard.classfile.attribute.MethodParametersAttribute;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.NestMembersAttribute;
import proguard.classfile.attribute.ParameterInfo;
import proguard.classfile.attribute.PermittedSubclassesAttribute;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.AnnotationsAttribute;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.ConstantElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.module.ExportsInfo;
import proguard.classfile.attribute.module.ModuleAttribute;
import proguard.classfile.attribute.module.ModuleMainClassAttribute;
import proguard.classfile.attribute.module.ModulePackagesAttribute;
import proguard.classfile.attribute.module.OpensInfo;
import proguard.classfile.attribute.module.ProvidesInfo;
import proguard.classfile.attribute.module.RequiresInfo;
import proguard.classfile.attribute.module.visitor.ExportsInfoVisitor;
import proguard.classfile.attribute.module.visitor.OpensInfoVisitor;
import proguard.classfile.attribute.module.visitor.ProvidesInfoVisitor;
import proguard.classfile.attribute.module.visitor.RequiresInfoVisitor;
import proguard.classfile.attribute.preverification.FullFrame;
import proguard.classfile.attribute.preverification.ObjectType;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.StackMapAttribute;
import proguard.classfile.attribute.preverification.StackMapFrame;
import proguard.classfile.attribute.preverification.StackMapTableAttribute;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.attribute.preverification.visitor.StackMapFrameVisitor;
import proguard.classfile.attribute.preverification.visitor.VerificationTypeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.attribute.visitor.BootstrapMethodInfoVisitor;
import proguard.classfile.attribute.visitor.ExceptionInfoVisitor;
import proguard.classfile.attribute.visitor.InnerClassesInfoVisitor;
import proguard.classfile.attribute.visitor.LocalVariableInfoVisitor;
import proguard.classfile.attribute.visitor.LocalVariableTypeInfoVisitor;
import proguard.classfile.attribute.visitor.ParameterInfoVisitor;
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.testutils.cpa.NamedField;

class ConstantPoolShrinkerDiffblueTest {
  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {doubleConstant, classConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    FloatConstant floatConstant = new FloatConstant(10.0f);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, floatConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass4() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    IntegerConstant integerConstant = new IntegerConstant(42);
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, integerConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass5() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {classConstant, new DoubleConstant(10.0d)}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass6() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass programClass =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant(), null}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertNull(constantArray[2]);
    assertEquals(3, constantArray.length);
    assertEquals(3, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {doubleConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {doubleConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link InterfaceMethodrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then second element InterfaceMethodrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenSecondElementInterfaceMethodrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    InterfaceMethodrefConstant interfaceMethodrefConstant = new InterfaceMethodrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1,
            3,
            new Constant[] {doubleConstant, interfaceMethodrefConstant, new ClassConstant()},
            1,
            1,
            1);

    // Act
    constantPoolShrinker.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof InterfaceMethodrefConstant);
    assertNull(constantArray[2]);
    assertEquals(2, programClass.u2constantPoolCount);
    assertEquals(3, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>When {@link NamedField#NamedField(String, String)} with {@code Field Name} and {@code
   *       Field Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); when NamedField(String, String) with 'Field Name' and 'Field Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_whenNamedFieldWithFieldNameAndFieldDescriptor() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitProgramMember(
        programClass, new NamedField("Field Name", "Field Descriptor"));

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>When {@link ProgramField#ProgramField()}.
   *   <li>Then calls {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); when ProgramField(); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_whenProgramField_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitProgramMember(programClass, new ProgramField());

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>When {@link ProgramMethod#ProgramMethod()}.
   *   <li>Then calls {@link ProgramClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); when ProgramMethod(); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_whenProgramMethod_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitProgramMember(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); when ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_whenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[] {classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_thenCallsAttributesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(clazz).attributesAccept(isA(AttributeVisitor.class));
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>When {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); when ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_whenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[] {classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[] {classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsAttributesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(clazz).attributesAccept(isA(AttributeVisitor.class));
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnyRefConstant(Clazz, RefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyRefConstant(Clazz, RefConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnyRefConstant(proguard.classfile.Clazz, proguard.classfile.constant.RefConstant)"
  })
  void testVisitAnyRefConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitAnyRefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>When {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); when ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_whenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[] {classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>When {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); when ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_whenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    ClassConstant classConstant = mock(ClassConstant.class);
    doNothing().when(classConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    ProgramClass clazz = new ProgramClass(1, 3, new Constant[] {classConstant}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    verify(classConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName("Test visitModuleConstant(Clazz, ModuleConstant); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAttribute(Clazz, Attribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testVisitAnyAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodsAttribute#bootstrapMethodEntriesAccept(Clazz,
   *       BootstrapMethodInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls bootstrapMethodEntriesAccept(Clazz, BootstrapMethodInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsBootstrapMethodEntriesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    doNothing()
        .when(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(
            Mockito.<Clazz>any(), Mockito.<BootstrapMethodInfoVisitor>any());

    // Act
    constantPoolShrinker.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(isA(Clazz.class), isA(BootstrapMethodInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitBootstrapMethodsAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    constantPoolShrinker.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitRecordAttribute(clazz, new RecordAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InnerClassesAttribute#innerClassEntriesAccept(Clazz,
   *       InnerClassesInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls innerClassEntriesAccept(Clazz, InnerClassesInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsInnerClassEntriesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    doNothing()
        .when(innerClassesAttribute)
        .innerClassEntriesAccept(Mockito.<Clazz>any(), Mockito.<InnerClassesInfoVisitor>any());

    // Act
    constantPoolShrinker.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(innerClassesAttribute)
        .innerClassEntriesAccept(isA(Clazz.class), isA(InnerClassesInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName("Test visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitNestMembersAttribute(
        clazz, new NestMembersAttribute(1, 3, new int[] {2, 1, 2, 1}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitNestMembersAttribute(clazz, new NestMembersAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link NestMembersAttribute#memberClassConstantsAccept(Clazz,
   *       ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls memberClassConstantsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsMemberClassConstantsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    NestMembersAttribute nestMembersAttribute = mock(NestMembersAttribute.class);
    doNothing()
        .when(nestMembersAttribute)
        .memberClassConstantsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(nestMembersAttribute)
        .memberClassConstantsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName("Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitPermittedSubclassesAttribute(
        clazz, new PermittedSubclassesAttribute(1, 3, new int[] {2, 1, 2, 1}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitPermittedSubclassesAttribute(
        clazz, new PermittedSubclassesAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link PermittedSubclassesAttribute#permittedSubclassConstantsAccept(Clazz,
   *       ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls permittedSubclassConstantsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsPermittedSubclassConstantsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    PermittedSubclassesAttribute permittedSubclassesAttribute =
        mock(PermittedSubclassesAttribute.class);
    doNothing()
        .when(permittedSubclassesAttribute)
        .permittedSubclassConstantsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(permittedSubclassesAttribute)
        .permittedSubclassConstantsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName("Test visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitModuleAttribute(
        clazz,
        new ModuleAttribute(
            1,
            1,
            2,
            1,
            1,
            new RequiresInfo[] {new RequiresInfo(1, 2, 1)},
            1,
            new ExportsInfo[] {new ExportsInfo()},
            1,
            new OpensInfo[] {new OpensInfo()},
            3,
            new int[] {2, 1, 2, 1},
            1,
            new ProvidesInfo[] {new ProvidesInfo()}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ModuleAttribute#exportsAccept(Clazz, ExportsInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then calls exportsAccept(Clazz, ExportsInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsExportsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ModuleAttribute moduleAttribute = mock(ModuleAttribute.class);
    doNothing()
        .when(moduleAttribute)
        .exportsAccept(Mockito.<Clazz>any(), Mockito.<ExportsInfoVisitor>any());
    doNothing()
        .when(moduleAttribute)
        .opensAccept(Mockito.<Clazz>any(), Mockito.<OpensInfoVisitor>any());
    doNothing()
        .when(moduleAttribute)
        .providesAccept(Mockito.<Clazz>any(), Mockito.<ProvidesInfoVisitor>any());
    doNothing()
        .when(moduleAttribute)
        .requiresAccept(Mockito.<Clazz>any(), Mockito.<RequiresInfoVisitor>any());

    // Act
    constantPoolShrinker.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(moduleAttribute).exportsAccept(isA(Clazz.class), isA(ExportsInfoVisitor.class));
    verify(moduleAttribute).opensAccept(isA(Clazz.class), isA(OpensInfoVisitor.class));
    verify(moduleAttribute).providesAccept(isA(Clazz.class), isA(ProvidesInfoVisitor.class));
    verify(moduleAttribute).requiresAccept(isA(Clazz.class), isA(RequiresInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>When {@link ModuleAttribute#ModuleAttribute()}.
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); when ModuleAttribute(); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_whenModuleAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName("Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitModulePackagesAttribute(
        clazz, new ModulePackagesAttribute(1, 3, new int[] {2, 1, 2, 1}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ModulePackagesAttribute#packagesAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then calls packagesAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenCallsPackagesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ModulePackagesAttribute modulePackagesAttribute = mock(ModulePackagesAttribute.class);
    doNothing()
        .when(modulePackagesAttribute)
        .packagesAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(modulePackagesAttribute).packagesAccept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute3() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitConstantValueAttribute(
        clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitMethodParametersAttribute(
        clazz, method, new MethodParametersAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodParametersAttribute#parametersAccept(Clazz, Method,
   *       ParameterInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls parametersAccept(Clazz, Method, ParameterInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsParametersAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute methodParametersAttribute = mock(MethodParametersAttribute.class);
    doNothing()
        .when(methodParametersAttribute)
        .parametersAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ParameterInfoVisitor>any());

    // Act
    constantPoolShrinker.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(methodParametersAttribute)
        .parametersAccept(isA(Clazz.class), isA(Method.class), isA(ParameterInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName("Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitExceptionsAttribute(
        clazz, method, new ExceptionsAttribute(1, 3, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ExceptionsAttribute#exceptionEntriesAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then calls exceptionEntriesAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenCallsExceptionEntriesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ExceptionsAttribute exceptionsAttribute = mock(ExceptionsAttribute.class);
    doNothing()
        .when(exceptionsAttribute)
        .exceptionEntriesAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(exceptionsAttribute)
        .exceptionEntriesAccept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#attributesAccept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls attributesAccept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAttributesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .attributesAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());
    doNothing()
        .when(codeAttribute)
        .exceptionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionInfoVisitor>any());
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    constantPoolShrinker.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(codeAttribute)
        .attributesAccept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
    verify(codeAttribute)
        .exceptionsAccept(isA(Clazz.class), isA(Method.class), isA(ExceptionInfoVisitor.class));
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when 'A'; then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenA_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName("Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute(new FullFrame[] {new FullFrame()}));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link StackMapAttribute#stackMapFramesAccept(Clazz, Method, CodeAttribute,
   *       StackMapFrameVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls stackMapFramesAccept(Clazz, Method, CodeAttribute, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsStackMapFramesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapAttribute stackMapAttribute = mock(StackMapAttribute.class);
    doNothing()
        .when(stackMapAttribute)
        .stackMapFramesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapFrameVisitor>any());

    // Act
    constantPoolShrinker.visitStackMapAttribute(clazz, method, codeAttribute, stackMapAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(stackMapAttribute)
        .stackMapFramesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapFrameVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitStackMapTableAttribute(
        clazz,
        method,
        codeAttribute,
        new StackMapTableAttribute(new StackMapFrame[] {new FullFrame()}));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link StackMapTableAttribute#stackMapFramesAccept(Clazz, Method,
   *       CodeAttribute, StackMapFrameVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls stackMapFramesAccept(Clazz, Method, CodeAttribute, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsStackMapFramesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapTableAttribute stackMapTableAttribute = mock(StackMapTableAttribute.class);
    doNothing()
        .when(stackMapTableAttribute)
        .stackMapFramesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapFrameVisitor>any());

    // Act
    constantPoolShrinker.visitStackMapTableAttribute(
        clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(stackMapTableAttribute)
        .stackMapFramesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapFrameVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTableAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTableAttribute#localVariablesAccept(Clazz, Method,
   *       CodeAttribute, LocalVariableInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls localVariablesAccept(Clazz, Method, CodeAttribute, LocalVariableInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsLocalVariablesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute =
        mock(LocalVariableTableAttribute.class);
    doNothing()
        .when(localVariableTableAttribute)
        .localVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableInfoVisitor>any());

    // Act
    constantPoolShrinker.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(localVariableTableAttribute)
        .localVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTypeTableAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTypeTableAttribute#localVariablesAccept(Clazz, Method,
   *       CodeAttribute, LocalVariableTypeInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then calls localVariablesAccept(Clazz, Method, CodeAttribute, LocalVariableTypeInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenCallsLocalVariablesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        mock(LocalVariableTypeTableAttribute.class);
    doNothing()
        .when(localVariableTypeTableAttribute)
        .localVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeInfoVisitor>any());

    // Act
    constantPoolShrinker.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(localVariableTypeTableAttribute)
        .localVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeInfoVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    constantPoolShrinker.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitAnyAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ParameterAnnotationsAttribute#annotationsAccept(Clazz, Method,
   *       AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnyParameterAnnotationsAttribute(Clazz,
   * Method, ParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute); then calls annotationsAccept(Clazz, Method, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnyParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute)"
  })
  void testVisitAnyParameterAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute parameterAnnotationsAttribute =
        mock(RuntimeInvisibleParameterAnnotationsAttribute.class);
    doNothing()
        .when(parameterAnnotationsAttribute)
        .annotationsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationVisitor>any());

    // Act
    constantPoolShrinker.visitAnyParameterAnnotationsAttribute(
        clazz, method, parameterAnnotationsAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(parameterAnnotationsAttribute)
        .annotationsAccept(isA(Clazz.class), isA(Method.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnyParameterAnnotationsAttribute(Clazz, Method,
   * ParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnyParameterAnnotationsAttribute(Clazz,
   * Method, ParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyParameterAnnotationsAttribute(Clazz, Method, ParameterAnnotationsAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnyParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute)"
  })
  void testVisitAnyParameterAnnotationsAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitAnyParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    constantPoolShrinker.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitBootstrapMethodInfo(
        clazz, new BootstrapMethodInfo(1, 3, new int[] {2, 1, 2, 1}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodInfo#methodArgumentsAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitBootstrapMethodInfo(Clazz,
   * BootstrapMethodInfo)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo); then calls methodArgumentsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo_thenCallsMethodArgumentsAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    BootstrapMethodInfo bootstrapMethodInfo = mock(BootstrapMethodInfo.class);
    doNothing()
        .when(bootstrapMethodInfo)
        .methodArgumentsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(bootstrapMethodInfo).methodArgumentsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsAttributesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());

    // Act
    constantPoolShrinker.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(recordComponentInfo).attributesAccept(isA(Clazz.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitRecordComponentInfo(clazz, new RecordComponentInfo());

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesInfo(Clazz, InnerClassesInfo); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesInfo(Clazz, InnerClassesInfo); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitInnerClassesInfo(Clazz,
   * InnerClassesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesInfo(Clazz, InnerClassesInfo); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}.
   *
   * <ul>
   *   <li>Then calls {@link SameOneFrame#stackItemAccept(Clazz, Method, CodeAttribute, int,
   *       VerificationTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitSameOneFrame(Clazz, Method,
   * CodeAttribute, int, SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); then calls stackItemAccept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_thenCallsStackItemAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = mock(SameOneFrame.class);
    doNothing()
        .when(sameOneFrame)
        .stackItemAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<VerificationTypeVisitor>any());

    // Act
    constantPoolShrinker.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    verify(sameOneFrame)
        .stackItemAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(VerificationTypeVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitObjectType(Clazz, Method, CodeAttribute, int,
   * ObjectType)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitObjectType(Clazz, Method, CodeAttribute,
   * int, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitObjectType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.ObjectType)"
  })
  void testVisitObjectType_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitObjectType(
        clazz, method, codeAttribute, 2, VerificationTypeFactory.createObjectType(1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName(
      "Test visitParameterInfo(Clazz, Method, int, ParameterInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolShrinker.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolShrinker.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitExportsInfo(Clazz, ExportsInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @DisplayName("Test visitExportsInfo(Clazz, ExportsInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitExportsInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ExportsInfo)"
  })
  void testVisitExportsInfo() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitExportsInfo(clazz, new ExportsInfo(1, 2, 3, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitExportsInfo(Clazz, ExportsInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExportsInfo(Clazz, ExportsInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitExportsInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ExportsInfo)"
  })
  void testVisitExportsInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitExportsInfo(clazz, new ExportsInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName("Test visitOpensInfo(Clazz, OpensInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitOpensInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.OpensInfo)"
  })
  void testVisitOpensInfo() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitOpensInfo(clazz, new OpensInfo(1, 2, 3, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOpensInfo(Clazz, OpensInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitOpensInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.OpensInfo)"
  })
  void testVisitOpensInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitOpensInfo(clazz, new OpensInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName("Test visitProvidesInfo(Clazz, ProvidesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProvidesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ProvidesInfo)"
  })
  void testVisitProvidesInfo() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitProvidesInfo(clazz, new ProvidesInfo(1, 1, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitProvidesInfo(Clazz, ProvidesInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitProvidesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ProvidesInfo)"
  })
  void testVisitProvidesInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitProvidesInfo(clazz, new ProvidesInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    constantPoolShrinker.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    constantPoolShrinker.visitAnnotation(clazz, annotation);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName("Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitConstantElementValue(
        clazz, annotation, new ConstantElementValue('\u0002', 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitConstantElementValue(
        clazz, annotation, new ConstantElementValue('A'));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then second element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_thenSecondElementClassConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new ClassConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof ClassConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then second element DynamicConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_thenSecondElementDynamicConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new DynamicConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Then second element {@link FieldrefConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then second element FieldrefConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_thenSecondElementFieldrefConstant() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    ProgramClass clazz =
        new ProgramClass(1, 3, new Constant[] {doubleConstant, new FieldrefConstant()}, 1, 1, 1);

    Annotation annotation = new Annotation();

    // Act
    constantPoolShrinker.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    Constant[] constantArray = clazz.constantPool;
    assertTrue(constantArray[1] instanceof FieldrefConstant);
    assertEquals(2, constantArray.length);
  }

  /**
   * Test {@link ConstantPoolShrinker#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    constantPoolShrinker.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayElementValue#elementValuesAccept(Clazz, Annotation,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); then calls elementValuesAccept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitArrayElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ArrayElementValue)"
  })
  void testVisitArrayElementValue_thenCallsElementValuesAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = mock(ArrayElementValue.class);
    doNothing()
        .when(arrayElementValue)
        .elementValuesAccept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());

    // Act
    constantPoolShrinker.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    verify(arrayElementValue)
        .elementValuesAccept(
            isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ConstantPoolShrinker#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolShrinker#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolShrinker.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ConstantPoolShrinker constantPoolShrinker = new ConstantPoolShrinker();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    constantPoolShrinker.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }
}
