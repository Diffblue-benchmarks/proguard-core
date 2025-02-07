package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.DeprecatedAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.ExceptionsAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.InnerClassesInfo;
import proguard.classfile.attribute.LineNumberTableAttribute;
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
import proguard.classfile.attribute.SyntheticAttribute;
import proguard.classfile.attribute.UnknownAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ArrayElementValue;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.ConstantElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.ParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo;
import proguard.classfile.attribute.annotation.target.visitor.LocalVariableTargetElementVisitor;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.annotation.visitor.TypeAnnotationVisitor;
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
import proguard.classfile.attribute.preverification.LessZeroFrame;
import proguard.classfile.attribute.preverification.MoreZeroFrame;
import proguard.classfile.attribute.preverification.ObjectType;
import proguard.classfile.attribute.preverification.SameOneFrame;
import proguard.classfile.attribute.preverification.SameZeroFrame;
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
import proguard.classfile.attribute.visitor.LineNumberInfoVisitor;
import proguard.classfile.attribute.visitor.LocalVariableInfoVisitor;
import proguard.classfile.attribute.visitor.LocalVariableTypeInfoVisitor;
import proguard.classfile.attribute.visitor.ParameterInfoVisitor;
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.util.SimpleProcessable;

class ClassPrinterDiffblueTest {
  /**
   * Test {@link ClassPrinter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> classPrinter.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassPrinter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); given 'Name'; then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_givenName_thenCallsAttributesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).interfaceConstantsAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());
    when(programClass.getProcessingInfo()).thenReturn("Processing Info");
    when(programClass.getName()).thenReturn("Name");
    when(programClass.getSuperName()).thenReturn("Super Name");

    // Act
    classPrinter.visitProgramClass(programClass);

    // Assert
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass, atLeast(1)).getName();
    verify(programClass).getSuperName();
    verify(programClass).interfaceConstantsAccept(isA(ConstantVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
    verify(programClass).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    ProgramClass programClass = mock(ProgramClass.class);
    doThrow(
            new UnsupportedOperationException(
                "_____________________________________________________________________"))
        .when(programClass)
        .interfaceConstantsAccept(Mockito.<ConstantVisitor>any());
    when(programClass.getProcessingInfo()).thenReturn("Processing Info");
    when(programClass.getName()).thenReturn("Name");
    when(programClass.getSuperName()).thenReturn("Super Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> classPrinter.visitProgramClass(programClass));
    verify(programClass, atLeast(1)).getName();
    verify(programClass).getSuperName();
    verify(programClass).interfaceConstantsAccept(isA(ConstantVisitor.class));
    verify(programClass).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then calls {@link IntegerConstant#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @DisplayName(
      "Test visitIntegerConstant(Clazz, IntegerConstant); given forty-two; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitIntegerConstant(proguard.classfile.Clazz, proguard.classfile.constant.IntegerConstant)"
  })
  void testVisitIntegerConstant_givenFortyTwo_thenCallsGetValue() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    IntegerConstant integerConstant = mock(IntegerConstant.class);
    when(integerConstant.getValue()).thenReturn(42);
    when(integerConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitIntegerConstant(clazz, integerConstant);

    // Assert
    verify(integerConstant).getValue();
    verify(integerConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitLongConstant(Clazz, LongConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link LongConstant#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLongConstant(Clazz, LongConstant)}
   */
  @Test
  @DisplayName(
      "Test visitLongConstant(Clazz, LongConstant); given 'Processing Info'; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLongConstant(proguard.classfile.Clazz, proguard.classfile.constant.LongConstant)"
  })
  void testVisitLongConstant_givenProcessingInfo_thenCallsGetValue() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LongConstant longConstant = mock(LongConstant.class);
    when(longConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(longConstant.getValue()).thenReturn(42L);

    // Act
    classPrinter.visitLongConstant(clazz, longConstant);

    // Assert
    verify(longConstant).getValue();
    verify(longConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitFloatConstant(Clazz, FloatConstant)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then calls {@link FloatConstant#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitFloatConstant(Clazz, FloatConstant)}
   */
  @Test
  @DisplayName("Test visitFloatConstant(Clazz, FloatConstant); given ten; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitFloatConstant(proguard.classfile.Clazz, proguard.classfile.constant.FloatConstant)"
  })
  void testVisitFloatConstant_givenTen_thenCallsGetValue() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    FloatConstant floatConstant = mock(FloatConstant.class);
    when(floatConstant.getValue()).thenReturn(10.0f);
    when(floatConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitFloatConstant(clazz, floatConstant);

    // Assert
    verify(floatConstant).getValue();
    verify(floatConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitDoubleConstant(Clazz, DoubleConstant)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then calls {@link DoubleConstant#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitDoubleConstant(Clazz, DoubleConstant)}
   */
  @Test
  @DisplayName("Test visitDoubleConstant(Clazz, DoubleConstant); given ten; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitDoubleConstant(proguard.classfile.Clazz, proguard.classfile.constant.DoubleConstant)"
  })
  void testVisitDoubleConstant_givenTen_thenCallsGetValue() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    DoubleConstant doubleConstant = mock(DoubleConstant.class);
    when(doubleConstant.getValue()).thenReturn(10.0d);
    when(doubleConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitDoubleConstant(clazz, doubleConstant);

    // Assert
    verify(doubleConstant).getValue();
    verify(doubleConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then calls {@link PrimitiveArrayConstant#getLength()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitPrimitiveArrayConstant(Clazz,
   * PrimitiveArrayConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant); given 'A'; then calls getLength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitPrimitiveArrayConstant(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant)"
  })
  void testVisitPrimitiveArrayConstant_givenA_thenCallsGetLength() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    PrimitiveArrayConstant primitiveArrayConstant = mock(PrimitiveArrayConstant.class);
    when(primitiveArrayConstant.getPrimitiveType()).thenReturn('A');
    when(primitiveArrayConstant.getLength()).thenReturn(3);
    when(primitiveArrayConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitPrimitiveArrayConstant(clazz, primitiveArrayConstant);

    // Assert
    verify(primitiveArrayConstant).getLength();
    verify(primitiveArrayConstant).getPrimitiveType();
    verify(primitiveArrayConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); given 'Processing Info'; when LibraryClass; then calls getString(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_givenProcessingInfo_whenLibraryClass_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    classPrinter.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
    verify(stringConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); when LibraryClass getString(int) return 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_whenLibraryClassGetStringReturnString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link Utf8Constant#getString()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @DisplayName(
      "Test visitUtf8Constant(Clazz, Utf8Constant); given 'Processing Info'; then calls getString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitUtf8Constant(proguard.classfile.Clazz, proguard.classfile.constant.Utf8Constant)"
  })
  void testVisitUtf8Constant_givenProcessingInfo_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    Utf8Constant utf8Constant = mock(Utf8Constant.class);
    when(utf8Constant.getProcessingInfo()).thenReturn("Processing Info");
    when(utf8Constant.getString()).thenReturn("String");

    // Act
    classPrinter.visitUtf8Constant(clazz, utf8Constant);

    // Assert
    verify(utf8Constant).getString();
    verify(utf8Constant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    DynamicConstant dynamicConstant = mock(DynamicConstant.class);
    when(dynamicConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(dynamicConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    InvokeDynamicConstant invokeDynamicConstant = mock(InvokeDynamicConstant.class);
    when(invokeDynamicConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(invokeDynamicConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    MethodHandleConstant methodHandleConstant = mock(MethodHandleConstant.class);
    when(methodHandleConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitMethodHandleConstant(clazz, methodHandleConstant);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(methodHandleConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ModuleConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); given 'Processing Info'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_givenProcessingInfo_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleConstant moduleConstant = mock(ModuleConstant.class);
    when(moduleConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(moduleConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classPrinter.visitModuleConstant(clazz, moduleConstant);

    // Assert
    verify(moduleConstant).getName(isA(Clazz.class));
    verify(moduleConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link PackageConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); given 'Processing Info'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_givenProcessingInfo_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    PackageConstant packageConstant = mock(PackageConstant.class);
    when(packageConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(packageConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classPrinter.visitPackageConstant(clazz, packageConstant);

    // Assert
    verify(packageConstant).getName(isA(Clazz.class));
    verify(packageConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitPackageConstant(Clazz, PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitFieldrefConstant(Clazz, FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenClassName_thenCallsGetClassName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    classPrinter.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitFieldrefConstant(Clazz, FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    when(fieldrefConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitFieldrefConstant(clazz, fieldrefConstant);

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(fieldrefConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_givenClassName_thenCallsGetClassName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    classPrinter.visitInterfaceMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    InterfaceMethodrefConstant interfaceMethodrefConstant = mock(InterfaceMethodrefConstant.class);
    when(interfaceMethodrefConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitInterfaceMethodrefConstant(clazz, interfaceMethodrefConstant);

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(interfaceMethodrefConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodrefConstant(Clazz, MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenClassName_thenCallsGetClassName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    classPrinter.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodrefConstant(Clazz, MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    MethodrefConstant methodrefConstant = mock(MethodrefConstant.class);
    when(methodrefConstant.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitMethodrefConstant(clazz, methodrefConstant);

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(methodrefConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Processing Info'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenProcessingInfo_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classPrinter.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    verify(classConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link MethodTypeConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); given 'Processing Info'; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_givenProcessingInfo_thenCallsGetType() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    MethodTypeConstant methodTypeConstant = mock(MethodTypeConstant.class);
    when(methodTypeConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(methodTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    classPrinter.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(methodTypeConstant).getType(isA(Clazz.class));
    verify(methodTypeConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link NameAndTypeConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); given 'Processing Info'; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_givenProcessingInfo_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    NameAndTypeConstant nameAndTypeConstant = mock(NameAndTypeConstant.class);
    when(nameAndTypeConstant.getProcessingInfo()).thenReturn("Processing Info");
    when(nameAndTypeConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(nameAndTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    classPrinter.visitNameAndTypeConstant(clazz, nameAndTypeConstant);

    // Assert
    verify(nameAndTypeConstant).getName(isA(Clazz.class));
    verify(nameAndTypeConstant).getType(isA(Clazz.class));
    verify(nameAndTypeConstant).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#getString(int)} return {@code <init>}.
   *   <li>Then calls {@link ProgramClass#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); when ProgramClass getString(int) return '<init>'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_whenProgramClassGetStringReturnInit_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    when(programClass.getString(anyInt())).thenReturn("<init>");

    // Act
    classPrinter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getName();
    verify(programClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod} {@link LibraryMember#getDescriptor(Clazz)} return {@code
   *       <init>}.
   *   <li>Then calls {@link LibraryClass#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); when LibraryMethod getDescriptor(Clazz) return '<init>'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_whenLibraryMethodGetDescriptorReturnInit_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    when(libraryMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(libraryMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("<init>");
    when(libraryMethod.getName(Mockito.<Clazz>any())).thenReturn("<init>");

    // Act
    classPrinter.visitLibraryMethod(libraryClass, libraryMethod);

    // Assert
    verify(libraryClass).getName();
    verify(libraryMethod, atLeast(1)).getDescriptor(isA(Clazz.class));
    verify(libraryMethod, atLeast(1)).getName(isA(Clazz.class));
    verify(libraryMethod).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); given 'Processing Info'; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_givenProcessingInfo_thenCallsGetAttributeName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    UnknownAttribute unknownAttribute = mock(UnknownAttribute.class);
    when(unknownAttribute.getProcessingInfo()).thenReturn("Processing Info");
    when(unknownAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    classPrinter.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    verify(unknownAttribute).getAttributeName(isA(Clazz.class));
    verify(unknownAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodsAttribute#bootstrapMethodEntriesAccept(Clazz,
   *       BootstrapMethodInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls bootstrapMethodEntriesAccept(Clazz, BootstrapMethodInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsBootstrapMethodEntriesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    when(bootstrapMethodsAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(
            Mockito.<Clazz>any(), Mockito.<BootstrapMethodInfoVisitor>any());

    // Act
    classPrinter.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(isA(Clazz.class), isA(BootstrapMethodInfoVisitor.class));
    verify(bootstrapMethodsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    SourceFileAttribute sourceFileAttribute = mock(SourceFileAttribute.class);
    when(sourceFileAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(sourceFileAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    SourceDirAttribute sourceDirAttribute = mock(SourceDirAttribute.class);
    when(sourceDirAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(sourceDirAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); given 'Processing Info'; then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_givenProcessingInfo_thenCallsComponentsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttributeAttribute = mock(RecordAttribute.class);
    when(recordAttributeAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(recordAttributeAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    classPrinter.visitRecordAttribute(clazz, recordAttributeAttribute);

    // Assert
    verify(recordAttributeAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
    verify(recordAttributeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InnerClassesAttribute#innerClassEntriesAccept(Clazz,
   *       InnerClassesInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls innerClassEntriesAccept(Clazz, InnerClassesInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsInnerClassEntriesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    when(innerClassesAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(innerClassesAttribute)
        .innerClassEntriesAccept(Mockito.<Clazz>any(), Mockito.<InnerClassesInfoVisitor>any());

    // Act
    classPrinter.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(innerClassesAttribute)
        .innerClassEntriesAccept(isA(Clazz.class), isA(InnerClassesInfoVisitor.class));
    verify(innerClassesAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 0));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    EnclosingMethodAttribute enclosingMethodAttribute = mock(EnclosingMethodAttribute.class);
    when(enclosingMethodAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(enclosingMethodAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    NestHostAttribute nestHostAttribute = mock(NestHostAttribute.class);
    when(nestHostAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(nestHostAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link NestMembersAttribute#memberClassConstantsAccept(Clazz,
   *       ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls memberClassConstantsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsMemberClassConstantsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    NestMembersAttribute nestMembersAttribute = mock(NestMembersAttribute.class);
    when(nestMembersAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(nestMembersAttribute)
        .memberClassConstantsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    verify(nestMembersAttribute)
        .memberClassConstantsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(nestMembersAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link PermittedSubclassesAttribute#permittedSubclassConstantsAccept(Clazz,
   *       ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls permittedSubclassConstantsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsPermittedSubclassConstantsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    PermittedSubclassesAttribute permittedSubclassesAttribute =
        mock(PermittedSubclassesAttribute.class);
    when(permittedSubclassesAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(permittedSubclassesAttribute)
        .permittedSubclassConstantsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    verify(permittedSubclassesAttribute)
        .permittedSubclassConstantsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(permittedSubclassesAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link ModuleAttribute#exportsAccept(Clazz, ExportsInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); given 'Processing Info'; then calls exportsAccept(Clazz, ExportsInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_givenProcessingInfo_thenCallsExportsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ModuleAttribute moduleAttribute = mock(ModuleAttribute.class);
    when(moduleAttribute.getProcessingInfo()).thenReturn("Processing Info");
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
    classPrinter.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(moduleAttribute).exportsAccept(isA(Clazz.class), isA(ExportsInfoVisitor.class));
    verify(moduleAttribute).opensAccept(isA(Clazz.class), isA(OpensInfoVisitor.class));
    verify(moduleAttribute).providesAccept(isA(Clazz.class), isA(ProvidesInfoVisitor.class));
    verify(moduleAttribute).requiresAccept(isA(Clazz.class), isA(RequiresInfoVisitor.class));
    verify(moduleAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ModuleMainClassAttribute moduleMainClassAttribute = mock(ModuleMainClassAttribute.class);
    when(moduleMainClassAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(moduleMainClassAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link ModulePackagesAttribute#packagesAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); given 'Processing Info'; then calls packagesAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_givenProcessingInfo_thenCallsPackagesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    ModulePackagesAttribute modulePackagesAttribute = mock(ModulePackagesAttribute.class);
    when(modulePackagesAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(modulePackagesAttribute)
        .packagesAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    verify(modulePackagesAttribute).packagesAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(modulePackagesAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with {@code
   * clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitDeprecatedAttribute(clazz, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitSyntheticAttribute(clazz, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(signatureAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    ConstantValueAttribute constantValueAttribute = mock(ConstantValueAttribute.class);
    when(constantValueAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitConstantValueAttribute(clazz, field, constantValueAttribute);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(constantValueAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    classPrinter.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link MethodParametersAttribute#parametersAccept(Clazz, Method,
   *       ParameterInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); given 'Processing Info'; then calls parametersAccept(Clazz, Method, ParameterInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_givenProcessingInfo_thenCallsParametersAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute methodParametersAttribute = mock(MethodParametersAttribute.class);
    when(methodParametersAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(methodParametersAttribute)
        .parametersAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ParameterInfoVisitor>any());

    // Act
    classPrinter.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    verify(methodParametersAttribute)
        .parametersAccept(isA(Clazz.class), isA(Method.class), isA(ParameterInfoVisitor.class));
    verify(methodParametersAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link ExceptionsAttribute#exceptionEntriesAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); given 'Processing Info'; then calls exceptionEntriesAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_givenProcessingInfo_thenCallsExceptionEntriesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ExceptionsAttribute exceptionsAttribute = mock(ExceptionsAttribute.class);
    when(exceptionsAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(exceptionsAttribute)
        .exceptionEntriesAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    verify(exceptionsAttribute)
        .exceptionEntriesAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(exceptionsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link CodeAttribute#attributesAccept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given 'Processing Info'; then calls attributesAccept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenProcessingInfo_thenCallsAttributesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");
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
    classPrinter.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .attributesAccept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
    verify(codeAttribute)
        .exceptionsAccept(isA(Clazz.class), isA(Method.class), isA(ExceptionInfoVisitor.class));
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}
   */
  @Test
  @DisplayName("Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute(new FullFrame[] {new FullFrame()}));

    // Assert
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link StackMapAttribute#stackMapFramesAccept(Clazz, Method, CodeAttribute,
   *       StackMapFrameVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls stackMapFramesAccept(Clazz, Method, CodeAttribute, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsStackMapFramesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");
    StackMapAttribute stackMapAttribute = mock(StackMapAttribute.class);
    doNothing()
        .when(stackMapAttribute)
        .stackMapFramesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapFrameVisitor>any());

    // Act
    classPrinter.visitStackMapAttribute(clazz, method, codeAttribute, stackMapAttribute);

    // Assert
    verify(stackMapAttribute)
        .stackMapFramesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapFrameVisitor.class));
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>When {@link StackMapAttribute#StackMapAttribute()}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); when StackMapAttribute(); then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_whenStackMapAttribute_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitStackMapAttribute(clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitStackMapTableAttribute(
        clazz,
        method,
        codeAttribute,
        new StackMapTableAttribute(new StackMapFrame[] {new FullFrame()}));

    // Assert
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link StackMapTableAttribute#stackMapFramesAccept(Clazz, Method,
   *       CodeAttribute, StackMapFrameVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls stackMapFramesAccept(Clazz, Method, CodeAttribute, StackMapFrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsStackMapFramesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getProcessingInfo()).thenReturn("Processing Info");
    StackMapTableAttribute stackMapTableAttribute = mock(StackMapTableAttribute.class);
    doNothing()
        .when(stackMapTableAttribute)
        .stackMapFramesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapFrameVisitor>any());

    // Act
    classPrinter.visitStackMapTableAttribute(clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    verify(stackMapTableAttribute)
        .stackMapFramesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapFrameVisitor.class));
    verify(codeAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link LineNumberTableAttribute#lineNumbersAccept(Clazz, Method,
   *       CodeAttribute, LineNumberInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); given 'Processing Info'; then calls lineNumbersAccept(Clazz, Method, CodeAttribute, LineNumberInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_givenProcessingInfo_thenCallsLineNumbersAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = mock(LineNumberTableAttribute.class);
    when(lineNumberTableAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(lineNumberTableAttribute)
        .lineNumbersAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LineNumberInfoVisitor>any());

    // Act
    classPrinter.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    verify(lineNumberTableAttribute)
        .lineNumbersAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LineNumberInfoVisitor.class));
    verify(lineNumberTableAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTableAttribute#localVariablesAccept(Clazz, Method,
   *       CodeAttribute, LocalVariableInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls localVariablesAccept(Clazz, Method, CodeAttribute, LocalVariableInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsLocalVariablesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute =
        mock(LocalVariableTableAttribute.class);
    when(localVariableTableAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(localVariableTableAttribute)
        .localVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableInfoVisitor>any());

    // Act
    classPrinter.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    verify(localVariableTableAttribute)
        .localVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableInfoVisitor.class));
    verify(localVariableTableAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTypeTableAttribute#localVariablesAccept(Clazz, Method,
   *       CodeAttribute, LocalVariableTypeInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then calls localVariablesAccept(Clazz, Method, CodeAttribute, LocalVariableTypeInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenCallsLocalVariablesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        mock(LocalVariableTypeTableAttribute.class);
    when(localVariableTypeTableAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(localVariableTypeTableAttribute)
        .localVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeInfoVisitor>any());

    // Act
    classPrinter.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    verify(localVariableTypeTableAttribute)
        .localVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeInfoVisitor.class));
    verify(localVariableTypeTableAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(runtimeVisibleAnnotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classPrinter.visitRuntimeVisibleAnnotationsAttribute(clazz, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute)
        .annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
    verify(runtimeVisibleAnnotationsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(runtimeInvisibleAnnotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classPrinter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute)
        .annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
    verify(runtimeInvisibleAnnotationsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ParameterAnnotationsAttribute#annotationsAccept(Clazz, Method,
   *       AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassPrinter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute); then calls annotationsAccept(Clazz, Method, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        mock(RuntimeVisibleParameterAnnotationsAttribute.class);
    when(runtimeVisibleParameterAnnotationsAttribute.getProcessingInfo())
        .thenReturn("Processing Info");
    doNothing()
        .when(runtimeVisibleParameterAnnotationsAttribute)
        .annotationsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classPrinter.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleParameterAnnotationsAttribute)
        .annotationsAccept(isA(Clazz.class), isA(Method.class), isA(AnnotationVisitor.class));
    verify(runtimeVisibleParameterAnnotationsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * ClassPrinter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        mock(RuntimeInvisibleParameterAnnotationsAttribute.class);
    when(runtimeInvisibleParameterAnnotationsAttribute.getProcessingInfo())
        .thenReturn("Processing Info");
    doNothing()
        .when(runtimeInvisibleParameterAnnotationsAttribute)
        .annotationsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classPrinter.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleParameterAnnotationsAttribute)
        .annotationsAccept(isA(Clazz.class), isA(Method.class), isA(AnnotationVisitor.class));
    verify(runtimeInvisibleParameterAnnotationsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(runtimeVisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(Mockito.<Clazz>any(), Mockito.<TypeAnnotationVisitor>any());

    // Act
    classPrinter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(isA(Clazz.class), isA(TypeAnnotationVisitor.class));
    verify(runtimeVisibleTypeAnnotationsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getProcessingInfo())
        .thenReturn("Processing Info");
    doNothing()
        .when(runtimeInvisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(Mockito.<Clazz>any(), Mockito.<TypeAnnotationVisitor>any());

    // Act
    classPrinter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(isA(Clazz.class), isA(TypeAnnotationVisitor.class));
    verify(runtimeInvisibleTypeAnnotationsAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classPrinter.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotationDefaultAttribute).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitBootstrapMethodInfo(
        clazz, new BootstrapMethodInfo(1, 3, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link BootstrapMethodInfo#methodArgumentsAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo); given 'Processing Info'; then calls methodArgumentsAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo_givenProcessingInfo_thenCallsMethodArgumentsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    BootstrapMethodInfo bootstrapMethodInfo = mock(BootstrapMethodInfo.class);
    when(bootstrapMethodInfo.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(bootstrapMethodInfo)
        .methodArgumentsAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitBootstrapMethodInfo(clazz, bootstrapMethodInfo);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(bootstrapMethodInfo).methodArgumentsAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(bootstrapMethodInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodInfo(Clazz, BootstrapMethodInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitBootstrapMethodInfo(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodInfo)"
  })
  void testVisitBootstrapMethodInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitBootstrapMethodInfo(clazz, new BootstrapMethodInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link RecordComponentInfo#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); given 'Processing Info'; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_givenProcessingInfo_thenCallsGetDescriptor() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    when(recordComponentInfo.getProcessingInfo()).thenReturn("Processing Info");
    when(recordComponentInfo.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(recordComponentInfo.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classPrinter.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(recordComponentInfo).getDescriptor(isA(Clazz.class));
    verify(recordComponentInfo).getName(isA(Clazz.class));
    verify(recordComponentInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitRecordComponentInfo(Clazz, RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitRecordComponentInfo(clazz, new RecordComponentInfo());

    // Assert
    verify(clazz, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo2() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(0, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo3() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 0, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo4() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 0, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo5() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 50));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo6() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 4));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo7() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 0));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo8() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, 8));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName("Test visitInnerClassesInfo(Clazz, InnerClassesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo9() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, new InnerClassesInfo(1, 1, 1, -1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link InnerClassesInfo#innerClassConstantAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitInnerClassesInfo(Clazz, InnerClassesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesInfo(Clazz, InnerClassesInfo); given 'Processing Info'; then calls innerClassConstantAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitInnerClassesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesInfo)"
  })
  void testVisitInnerClassesInfo_givenProcessingInfo_thenCallsInnerClassConstantAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    InnerClassesInfo innerClassesInfo = mock(InnerClassesInfo.class);
    when(innerClassesInfo.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(innerClassesInfo)
        .innerClassConstantAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    doNothing()
        .when(innerClassesInfo)
        .innerNameConstantAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    doNothing()
        .when(innerClassesInfo)
        .outerClassConstantAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitInnerClassesInfo(clazz, innerClassesInfo);

    // Assert
    verify(innerClassesInfo).innerClassConstantAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(innerClassesInfo).innerNameConstantAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(innerClassesInfo).outerClassConstantAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(innerClassesInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link Instruction#toString(Clazz, int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnyInstruction(Clazz, Method, CodeAttribute,
   * int, Instruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction); given 'String'; then calls toString(Clazz, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction_givenString_thenCallsToString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    BranchInstruction instruction = mock(BranchInstruction.class);
    when(instruction.toString(Mockito.<Clazz>any(), anyInt())).thenReturn("String");

    // Act
    classPrinter.visitAnyInstruction(clazz, method, codeAttribute, 2, instruction);

    // Assert
    verify(instruction).toString(isA(Clazz.class), eq(2));
  }

  /**
   * Test {@link ClassPrinter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -59, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction2() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -70, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction3() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) -71, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ConstantInstruction#toString(Clazz, int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); given 'String'; when LibraryClass; then calls toString(Clazz, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_givenString_whenLibraryClass_thenCallsToString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ConstantInstruction constantInstruction = mock(ConstantInstruction.class);
    when(constantInstruction.toString(Mockito.<Clazz>any(), anyInt())).thenReturn("String");

    // Act
    classPrinter.visitConstantInstruction(clazz, method, codeAttribute, 2, constantInstruction);

    // Assert
    verify(constantInstruction).toString(isA(Clazz.class), eq(2));
  }

  /**
   * Test {@link ClassPrinter#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExceptionInfo exceptionInfo = mock(ExceptionInfo.class);
    when(exceptionInfo.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitExceptionInfo(clazz, method, codeAttribute, exceptionInfo);

    // Assert
    verify(exceptionInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitSameZeroFrame(Clazz, Method, CodeAttribute, int,
   * SameZeroFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameZeroFrame(Clazz, Method, CodeAttribute, int, SameZeroFrame); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSameZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameZeroFrame)"
  })
  void testVisitSameZeroFrame_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameZeroFrame sameZeroFrame = mock(SameZeroFrame.class);
    when(sameZeroFrame.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitSameZeroFrame(clazz, method, codeAttribute, 2, sameZeroFrame);

    // Assert
    verify(sameZeroFrame).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SameOneFrame#stackItemAccept(Clazz, Method, CodeAttribute, int,
   *       VerificationTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitSameOneFrame(Clazz, Method, CodeAttribute, int,
   * SameOneFrame)}
   */
  @Test
  @DisplayName(
      "Test visitSameOneFrame(Clazz, Method, CodeAttribute, int, SameOneFrame); given 'Processing Info'; then calls stackItemAccept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitSameOneFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.SameOneFrame)"
  })
  void testVisitSameOneFrame_givenProcessingInfo_thenCallsStackItemAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    SameOneFrame sameOneFrame = mock(SameOneFrame.class);
    when(sameOneFrame.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(sameOneFrame)
        .stackItemAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<VerificationTypeVisitor>any());

    // Act
    classPrinter.visitSameOneFrame(clazz, method, codeAttribute, 2, sameOneFrame);

    // Assert
    verify(sameOneFrame)
        .stackItemAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(VerificationTypeVisitor.class));
    verify(sameOneFrame).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitLessZeroFrame(Clazz, Method, CodeAttribute, int, LessZeroFrame)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLessZeroFrame(Clazz, Method, CodeAttribute, int,
   * LessZeroFrame)}
   */
  @Test
  @DisplayName(
      "Test visitLessZeroFrame(Clazz, Method, CodeAttribute, int, LessZeroFrame); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLessZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.LessZeroFrame)"
  })
  void testVisitLessZeroFrame_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LessZeroFrame lessZeroFrame = mock(LessZeroFrame.class);
    when(lessZeroFrame.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitLessZeroFrame(clazz, method, codeAttribute, 2, lessZeroFrame);

    // Assert
    verify(lessZeroFrame).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link MoreZeroFrame#additionalVariablesAccept(Clazz, Method, CodeAttribute,
   *       int, VerificationTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitMoreZeroFrame(Clazz, Method, CodeAttribute, int,
   * MoreZeroFrame)}
   */
  @Test
  @DisplayName(
      "Test visitMoreZeroFrame(Clazz, Method, CodeAttribute, int, MoreZeroFrame); given 'Processing Info'; then calls additionalVariablesAccept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitMoreZeroFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.MoreZeroFrame)"
  })
  void testVisitMoreZeroFrame_givenProcessingInfo_thenCallsAdditionalVariablesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    MoreZeroFrame moreZeroFrame = mock(MoreZeroFrame.class);
    when(moreZeroFrame.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(moreZeroFrame)
        .additionalVariablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<VerificationTypeVisitor>any());

    // Act
    classPrinter.visitMoreZeroFrame(clazz, method, codeAttribute, 2, moreZeroFrame);

    // Assert
    verify(moreZeroFrame)
        .additionalVariablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(VerificationTypeVisitor.class));
    verify(moreZeroFrame).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link FullFrame#stackAccept(Clazz, Method, CodeAttribute, int,
   *       VerificationTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitFullFrame(Clazz, Method, CodeAttribute, int,
   * FullFrame)}
   */
  @Test
  @DisplayName(
      "Test visitFullFrame(Clazz, Method, CodeAttribute, int, FullFrame); given 'Processing Info'; then calls stackAccept(Clazz, Method, CodeAttribute, int, VerificationTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitFullFrame(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.FullFrame)"
  })
  void testVisitFullFrame_givenProcessingInfo_thenCallsStackAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    FullFrame fullFrame = mock(FullFrame.class);
    when(fullFrame.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(fullFrame)
        .stackAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<VerificationTypeVisitor>any());
    doNothing()
        .when(fullFrame)
        .variablesAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<VerificationTypeVisitor>any());

    // Act
    classPrinter.visitFullFrame(clazz, method, codeAttribute, 2, fullFrame);

    // Assert
    verify(fullFrame)
        .stackAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(VerificationTypeVisitor.class));
    verify(fullFrame)
        .variablesAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(VerificationTypeVisitor.class));
    verify(fullFrame).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitObjectType(Clazz, Method, CodeAttribute, int,
   * ObjectType)}
   */
  @Test
  @DisplayName(
      "Test visitObjectType(Clazz, Method, CodeAttribute, int, ObjectType); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitObjectType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.ObjectType)"
  })
  void testVisitObjectType_givenClassName_thenCallsGetClassName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitObjectType(
        clazz, method, codeAttribute, 2, VerificationTypeFactory.createObjectType(1));

    // Assert
    verify(clazz).getClassName(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName("Test visitParameterInfo(Clazz, Method, int, ParameterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    classPrinter.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName("Test visitParameterInfo(Clazz, Method, int, ParameterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo2() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    classPrinter.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 50));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName("Test visitParameterInfo(Clazz, Method, int, ParameterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo3() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    classPrinter.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 4096));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName("Test visitParameterInfo(Clazz, Method, int, ParameterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo4() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    classPrinter.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 32768));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitParameterInfo(Clazz, Method, int, ParameterInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitParameterInfo(Clazz, Method, int,
   * ParameterInfo)}
   */
  @Test
  @DisplayName("Test visitParameterInfo(Clazz, Method, int, ParameterInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitParameterInfo(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.ParameterInfo)"
  })
  void testVisitParameterInfo5() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    classPrinter.visitParameterInfo(clazz, method, 1, new ParameterInfo(1, 0));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link LocalVariableInfo#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'Descriptor'; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenDescriptor_thenCallsGetDescriptor() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = mock(LocalVariableInfo.class);
    when(localVariableInfo.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(localVariableInfo.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classPrinter.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    verify(localVariableInfo).getDescriptor(isA(Clazz.class));
    verify(localVariableInfo).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link LocalVariableTypeInfo#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = mock(LocalVariableTypeInfo.class);
    when(localVariableTypeInfo.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(localVariableTypeInfo.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classPrinter.visitLocalVariableTypeInfo(clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    verify(localVariableTypeInfo).getName(isA(Clazz.class));
    verify(localVariableTypeInfo).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classPrinter.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo2() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(0, 1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo3() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, 50, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo4() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, Double.SIZE, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo5() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, 0, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo6() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, 4096, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo7() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, -1, 1));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName("Test visitRequiresInfo(Clazz, RequiresInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo8() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, new RequiresInfo(1, 1, 0));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link RequiresInfo#moduleAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitRequiresInfo(Clazz, RequiresInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRequiresInfo(Clazz, RequiresInfo); given 'Processing Info'; when LibraryClass; then calls moduleAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitRequiresInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.RequiresInfo)"
  })
  void testVisitRequiresInfo_givenProcessingInfo_whenLibraryClass_thenCallsModuleAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    RequiresInfo requiresInfo = mock(RequiresInfo.class);
    when(requiresInfo.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(requiresInfo)
        .moduleAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    doNothing()
        .when(requiresInfo)
        .versionAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitRequiresInfo(clazz, requiresInfo);

    // Assert
    verify(requiresInfo).moduleAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(requiresInfo).versionAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(requiresInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitExportsInfo(Clazz, ExportsInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link ExportsInfo#packageAccept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitExportsInfo(Clazz, ExportsInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExportsInfo(Clazz, ExportsInfo); given 'Processing Info'; then calls packageAccept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitExportsInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ExportsInfo)"
  })
  void testVisitExportsInfo_givenProcessingInfo_thenCallsPackageAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    ExportsInfo exportsInfo = mock(ExportsInfo.class);
    when(exportsInfo.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(exportsInfo)
        .packageAccept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitExportsInfo(clazz, exportsInfo);

    // Assert
    verify(exportsInfo).packageAccept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(exportsInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName("Test visitOpensInfo(Clazz, OpensInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitOpensInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.OpensInfo)"
  })
  void testVisitOpensInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitOpensInfo(clazz, new OpensInfo(1, 1, 3, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(anyInt(), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOpensInfo(Clazz, OpensInfo); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitOpensInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.OpensInfo)"
  })
  void testVisitOpensInfo_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    OpensInfo opensInfo = mock(OpensInfo.class);
    when(opensInfo.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitOpensInfo(clazz, opensInfo);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(opensInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitOpensInfo(Clazz, OpensInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitOpensInfo(Clazz, OpensInfo)}
   */
  @Test
  @DisplayName(
      "Test visitOpensInfo(Clazz, OpensInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitOpensInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.OpensInfo)"
  })
  void testVisitOpensInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitOpensInfo(clazz, new OpensInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName("Test visitProvidesInfo(Clazz, ProvidesInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitProvidesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ProvidesInfo)"
  })
  void testVisitProvidesInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitProvidesInfo(clazz, new ProvidesInfo(1, 1, new int[] {1, 2, 1, 2}));

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitProvidesInfo(Clazz, ProvidesInfo); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitProvidesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ProvidesInfo)"
  })
  void testVisitProvidesInfo_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    ProvidesInfo providesInfo = mock(ProvidesInfo.class);
    when(providesInfo.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitProvidesInfo(clazz, providesInfo);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(providesInfo).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitProvidesInfo(Clazz, ProvidesInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitProvidesInfo(Clazz, ProvidesInfo)}
   */
  @Test
  @DisplayName(
      "Test visitProvidesInfo(Clazz, ProvidesInfo); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitProvidesInfo(proguard.classfile.Clazz, proguard.classfile.attribute.module.ProvidesInfo)"
  })
  void testVisitProvidesInfo_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    classPrinter.visitProvidesInfo(clazz, new ProvidesInfo());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classPrinter.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsElementValuesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = mock(Annotation.class);
    when(annotation.getProcessingInfo()).thenReturn("Processing Info");
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classPrinter.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
    verify(annotation).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitAnnotation(Clazz, Method, int, Annotation)} with {@code clazz},
   * {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <p>Method under test: {@link ClassPrinter#visitAnnotation(Clazz, Method, int, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = mock(Annotation.class);
    when(annotation.getProcessingInfo()).thenReturn("Processing Info");
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("Type");
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classPrinter.visitAnnotation(clazz, method, 1, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
    verify(annotation).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitAnnotation(Clazz, Method, int, Annotation)} with {@code clazz},
   * {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnnotation(Clazz, Method, int, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    classPrinter.visitAnnotation(clazz, method, 1, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassPrinter#visitLocalVariableTargetInfo(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link LocalVariableTargetInfo#targetElementsAccept(Clazz, Method,
   *       CodeAttribute, TypeAnnotation, LocalVariableTargetElementVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitLocalVariableTargetInfo(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTargetInfo(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo); then calls targetElementsAccept(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetElementVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitLocalVariableTargetInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo)"
  })
  void testVisitLocalVariableTargetInfo_thenCallsTargetElementsAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = mock(LocalVariableTargetInfo.class);
    doNothing()
        .when(localVariableTargetInfo)
        .targetElementsAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<LocalVariableTargetElementVisitor>any());

    // Act
    classPrinter.visitLocalVariableTargetInfo(
        clazz, method, codeAttribute, typeAnnotation, localVariableTargetInfo);

    // Assert
    verify(localVariableTargetInfo)
        .targetElementsAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(TypeAnnotation.class),
            isA(LocalVariableTargetElementVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); given 'Processing Info'; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_givenProcessingInfo_thenCallsGetProcessingInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    Annotation annotation = new Annotation();
    ConstantElementValue constantElementValue = mock(ConstantElementValue.class);
    when(constantElementValue.getProcessingInfo()).thenReturn("Processing Info");

    // Act
    classPrinter.visitConstantElementValue(clazz, annotation, constantElementValue);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
    verify(constantElementValue).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    Annotation annotation = new Annotation();

    // Act
    classPrinter.visitConstantElementValue(
        clazz, annotation, new ConstantElementValue('\u0001', 1, 1));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(1), isA(ConstantVisitor.class));
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitConstantElementValue(Clazz, Annotation, ConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitConstantElementValue(Clazz, Annotation,
   * ConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitConstantElementValue(Clazz, Annotation, ConstantElementValue); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ConstantElementValue)"
  })
  void testVisitConstantElementValue_thenCallsConstantPoolEntryAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    Annotation annotation = new Annotation();

    // Act
    classPrinter.visitConstantElementValue(clazz, annotation, new ConstantElementValue('A'));

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link ClassPrinter#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}
   */
  @Test
  @DisplayName("Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classPrinter.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(0, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link EnumConstantElementValue#getConstantName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given 'Processing Info'; then calls getConstantName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenProcessingInfo_thenCallsGetConstantName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = new Annotation();
    EnumConstantElementValue enumConstantElementValue = mock(EnumConstantElementValue.class);
    when(enumConstantElementValue.getProcessingInfo()).thenReturn("Processing Info");
    when(enumConstantElementValue.getConstantName(Mockito.<Clazz>any()))
        .thenReturn("Constant Name");
    when(enumConstantElementValue.getTypeName(Mockito.<Clazz>any())).thenReturn("Type Name");

    // Act
    classPrinter.visitEnumConstantElementValue(clazz, annotation, enumConstantElementValue);

    // Assert
    verify(enumConstantElementValue).getConstantName(isA(Clazz.class));
    verify(enumConstantElementValue).getTypeName(isA(Clazz.class));
    verify(enumConstantElementValue).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classPrinter.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <p>Method under test: {@link ClassPrinter#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName("Test visitClassElementValue(Clazz, Annotation, ClassElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classPrinter.visitClassElementValue(clazz, annotation, new ClassElementValue(0, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link ClassElementValue#getClassName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'Processing Info'; then calls getClassName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenProcessingInfo_thenCallsGetClassName() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = mock(ClassElementValue.class);
    when(classElementValue.getProcessingInfo()).thenReturn("Processing Info");
    when(classElementValue.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act
    classPrinter.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    verify(classElementValue).getClassName(isA(Clazz.class));
    verify(classElementValue).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitClassElementValue(Clazz, Annotation, ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classPrinter.visitClassElementValue(clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }

  /**
   * Test {@link ClassPrinter#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); given 'Processing Info'; then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_givenProcessingInfo_thenCallsAnnotationAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    when(annotationElementValue.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classPrinter.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
    verify(annotationElementValue).getProcessingInfo();
  }

  /**
   * Test {@link ClassPrinter#visitArrayElementValue(Clazz, Annotation, ArrayElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   *   <li>Then calls {@link ArrayElementValue#elementValuesAccept(Clazz, Annotation,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPrinter#visitArrayElementValue(Clazz, Annotation,
   * ArrayElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitArrayElementValue(Clazz, Annotation, ArrayElementValue); given 'Processing Info'; then calls elementValuesAccept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPrinter.visitArrayElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ArrayElementValue)"
  })
  void testVisitArrayElementValue_givenProcessingInfo_thenCallsElementValuesAccept() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ArrayElementValue arrayElementValue = mock(ArrayElementValue.class);
    when(arrayElementValue.getProcessingInfo()).thenReturn("Processing Info");
    doNothing()
        .when(arrayElementValue)
        .elementValuesAccept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classPrinter.visitArrayElementValue(clazz, annotation, arrayElementValue);

    // Assert
    verify(arrayElementValue)
        .elementValuesAccept(
            isA(Clazz.class), isA(Annotation.class), isA(ElementValueVisitor.class));
    verify(arrayElementValue).getProcessingInfo();
  }
}
