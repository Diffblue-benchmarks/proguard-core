package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.AnnotationsAttribute;
import proguard.classfile.attribute.annotation.ClassElementValue;
import proguard.classfile.attribute.annotation.EnumConstantElementValue;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.AnnotationVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinAnnotatable;
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinAnnotationArgument;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ArrayValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ClassValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.EnumValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinConstructorMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinTypeAliasMetadata;
import proguard.classfile.kotlin.KotlinTypeMetadata;
import proguard.classfile.kotlin.KotlinValueParameterMetadata;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinAnnotationArgumentVisitor;
import proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor;
import proguard.classfile.kotlin.visitor.KotlinFunctionVisitor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.kotlin.visitor.KotlinPropertyVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeAliasVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;
import proguard.classfile.kotlin.visitor.KotlinValueParameterVisitor;
import proguard.classfile.visitor.ReferencedClassVisitor.KotlinReferencedClassVisitor;
import proguard.testutils.cpa.NamedMember;

class ReferencedClassVisitorDiffblueTest {
  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyAnnotation(Clazz,
   * KotlinAnnotatable, KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyAnnotation(Clazz,
   * KotlinAnnotatable, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testKotlinReferencedClassVisitorVisitAnyAnnotation_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    annotation.referencedAnnotationClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitAnyAnnotation(clazz, annotatable, annotation);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyAnnotation(Clazz,
   * KotlinAnnotatable, KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyAnnotation(Clazz,
   * KotlinAnnotatable, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyAnnotation(Clazz, KotlinAnnotatable, KotlinAnnotation); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testKotlinReferencedClassVisitorVisitAnyAnnotation_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    annotation.referencedAnnotationClass = new ProgramClass();

    // Act
    kotlinReferencedClassVisitor.visitAnyAnnotation(clazz, annotatable, annotation);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)"
  })
  void testKotlinReferencedClassVisitorVisitAnyArgument() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitAnyArgument(
        clazz, annotatable, annotation, argument, mock(Value.class));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)"
  })
  void testKotlinReferencedClassVisitorVisitAnyArgument2() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, new Clazz[] {new ProgramClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitAnyArgument(
        clazz, annotatable, annotation, argument, mock(Value.class));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)"
  })
  void testKotlinReferencedClassVisitorVisitAnyArgument3() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    LibraryClass libraryClass = new LibraryClass();

    ProgramMethod programMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new LibraryClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitAnyArgument(
        clazz, annotatable, annotation, argument, mock(Value.class));

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$Value)"
  })
  void testKotlinReferencedClassVisitorVisitAnyArgument4() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    LibraryClass libraryClass = new LibraryClass();

    ProgramMethod programMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new ProgramClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitAnyArgument(
        clazz, annotatable, annotation, argument, mock(Value.class));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyFunction(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyFunction(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyFunction(Clazz, KotlinMetadata, KotlinFunctionMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitAnyFunction() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinFunctionMetadata kotlinFunctionMetadata = mock(KotlinFunctionMetadata.class);
    doNothing()
        .when(kotlinFunctionMetadata)
        .contextReceiverTypesAccept(
            Mockito.<Clazz>any(), Mockito.<KotlinMetadata>any(), Mockito.<KotlinTypeVisitor>any());
    doNothing()
        .when(kotlinFunctionMetadata)
        .receiverTypeAccept(
            Mockito.<Clazz>any(), Mockito.<KotlinMetadata>any(), Mockito.<KotlinTypeVisitor>any());
    doNothing()
        .when(kotlinFunctionMetadata)
        .returnTypeAccept(
            Mockito.<Clazz>any(), Mockito.<KotlinMetadata>any(), Mockito.<KotlinTypeVisitor>any());
    doNothing()
        .when(kotlinFunctionMetadata)
        .typeParametersAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinTypeParameterVisitor>any());
    doNothing()
        .when(kotlinFunctionMetadata)
        .valueParametersAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinValueParameterVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitAnyFunction(clazz, kotlinMetadata, kotlinFunctionMetadata);

    // Assert
    verify(kotlinFunctionMetadata)
        .contextReceiverTypesAccept(
            isA(Clazz.class), isA(KotlinMetadata.class), isA(KotlinTypeVisitor.class));
    verify(kotlinFunctionMetadata)
        .receiverTypeAccept(
            isA(Clazz.class), isA(KotlinMetadata.class), isA(KotlinTypeVisitor.class));
    verify(kotlinFunctionMetadata)
        .returnTypeAccept(
            isA(Clazz.class), isA(KotlinMetadata.class), isA(KotlinTypeVisitor.class));
    verify(kotlinFunctionMetadata)
        .typeParametersAccept(
            isA(Clazz.class), isA(KotlinMetadata.class), isA(KotlinTypeParameterVisitor.class));
    verify(kotlinFunctionMetadata)
        .valueParametersAccept(
            isA(Clazz.class), isA(KotlinMetadata.class), isA(KotlinValueParameterVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyType(Clazz,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyType(Clazz,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyType(Clazz, KotlinTypeMetadata); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitAnyType_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();
    kotlinTypeMetadata.typeArguments = null;
    kotlinTypeMetadata.referencedClass = new LibraryClass();
    kotlinTypeMetadata.annotations = null;

    // Act
    kotlinReferencedClassVisitor.visitAnyType(clazz, kotlinTypeMetadata);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitAnyType(Clazz,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitAnyType(Clazz,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitAnyType(Clazz, KotlinTypeMetadata); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitAnyType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitAnyType_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();
    kotlinTypeMetadata.typeArguments = null;
    kotlinTypeMetadata.referencedClass = new ProgramClass();
    kotlinTypeMetadata.annotations = new ArrayList<>();

    // Act
    kotlinReferencedClassVisitor.visitAnyType(clazz, kotlinTypeMetadata);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testKotlinReferencedClassVisitorVisitArrayArgument() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(new ArrayList<>()));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testKotlinReferencedClassVisitorVisitArrayArgument2() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");

    ProgramMethod programMethod = new ProgramMethod(1, 1, 1, new Clazz[] {new ProgramClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(new ArrayList<>()));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testKotlinReferencedClassVisitorVisitArrayArgument3() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    LibraryClass libraryClass = new LibraryClass();

    ProgramMethod programMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new LibraryClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(new ArrayList<>()));

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testKotlinReferencedClassVisitorVisitArrayArgument4() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    LibraryClass libraryClass = new LibraryClass();

    ProgramMethod programMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new ProgramClass()});
    programMethod.addProcessingFlags(2, 1, 2, 1);
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = programMethod;

    // Act
    kotlinReferencedClassVisitor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(new ArrayList<>()));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <ul>
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue); then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testKotlinReferencedClassVisitorVisitArrayArgument_thenCallsAccept() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());

    ArrayList<Value> elements = new ArrayList<>();
    elements.add(value);

    // Act
    kotlinReferencedClassVisitor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(elements));

    // Assert
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}.
   *
   * <ul>
   *   <li>Then calls {@link Value#accept(Clazz, KotlinAnnotatable, KotlinAnnotation,
   *       KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitArrayArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitArrayArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ArrayValue); then calls accept(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, KotlinAnnotationArgumentVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitArrayArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ArrayValue)"
  })
  void testKotlinReferencedClassVisitorVisitArrayArgument_thenCallsAccept2() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    Value value = mock(Value.class);
    doNothing()
        .when(value)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());
    Value value2 = mock(Value.class);
    doNothing()
        .when(value2)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinAnnotatable>any(),
            Mockito.<KotlinAnnotation>any(),
            Mockito.<KotlinAnnotationArgument>any(),
            Mockito.<KotlinAnnotationArgumentVisitor>any());

    ArrayList<Value> elements = new ArrayList<>();
    elements.add(value2);
    elements.add(value);

    // Act
    kotlinReferencedClassVisitor.visitArrayArgument(
        clazz, annotatable, annotation, argument, new ArrayValue(elements));

    // Assert
    verify(value2)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
    verify(value)
        .accept(
            isA(Clazz.class),
            isA(KotlinAnnotatable.class),
            isA(KotlinAnnotation.class),
            isA(KotlinAnnotationArgument.class),
            isA(KotlinAnnotationArgumentVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = null;
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument2() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()});
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument3() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = new NamedMember("Member Name", "Descriptor");
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument4() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {new ProgramClass()});
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument5() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    LibraryClass libraryClass = new LibraryClass();
    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new LibraryClass()});
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument6() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    LibraryClass libraryClass = new LibraryClass();
    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new ProgramClass()});
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}.
   *
   * <ul>
   *   <li>Given {@link ProgramMethod#ProgramMethod()}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitClassArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitClassArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, ClassValue); given ProgramMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitClassArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue)"
  })
  void testKotlinReferencedClassVisitorVisitClassArgument_givenProgramMethod() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = new ProgramMethod();
    ClassValue value = new ClassValue("Class Name");
    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitClassArgument(
        clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link
   * KotlinReferencedClassVisitor#visitConstructorValParameter(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinClassKindMetadata,
   *       KotlinConstructorMetadata, KotlinTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitConstructorValParameter(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitConstructorValParameter(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata); then calls typeAccept(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitConstructorValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitConstructorValParameter_thenCallsTypeAccept() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        mock(KotlinValueParameterMetadata.class);
    doNothing()
        .when(kotlinValueParameterMetadata)
        .typeAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinTypeVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitConstructorValParameter(
        clazz, kotlinClassKindMetadata, kotlinConstructorMetadata, kotlinValueParameterMetadata);

    // Assert
    verify(kotlinValueParameterMetadata)
        .typeAccept(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinTypeVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = null;
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument2() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()});
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument3() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = new NamedMember("Member Name", "Descriptor");
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument4() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {new ProgramClass()});
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument5() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    LibraryClass libraryClass = new LibraryClass();
    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new LibraryClass()});
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument6() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    LibraryClass libraryClass = new LibraryClass();
    argument.referencedAnnotationMethod =
        new ProgramMethod(1, 1, 1, new Clazz[] {libraryClass, new ProgramClass()});
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor, atLeast(1)).visitLibraryClass(Mockito.<LibraryClass>any());
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}.
   *
   * <ul>
   *   <li>Given {@link ProgramMethod#ProgramMethod()}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitEnumArgument(Clazz,
   * KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitEnumArgument(Clazz, KotlinAnnotatable, KotlinAnnotation, KotlinAnnotationArgument, EnumValue); given ProgramMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitEnumArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinAnnotatable, proguard.classfile.kotlin.KotlinAnnotation, proguard.classfile.kotlin.KotlinAnnotationArgument, proguard.classfile.kotlin.KotlinAnnotationArgument$EnumValue)"
  })
  void testKotlinReferencedClassVisitorVisitEnumArgument_givenProgramMethod() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinAnnotatable annotatable = mock(KotlinAnnotatable.class);
    KotlinAnnotation annotation = new KotlinAnnotation("Class Name");
    KotlinAnnotationArgument argument = new KotlinAnnotationArgument("Name", mock(Value.class));

    argument.referencedAnnotationMethod = new ProgramMethod();
    EnumValue value = new EnumValue("Class Name", "Enum Entry Name");

    value.referencedClass = new LibraryClass();

    // Act
    kotlinReferencedClassVisitor.visitEnumArgument(clazz, annotatable, annotation, argument, value);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link
   * KotlinReferencedClassVisitor#visitFunctionValParameter(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinMetadata,
   *       KotlinFunctionMetadata, KotlinTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitFunctionValParameter(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitFunctionValParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata); then calls typeAccept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitFunctionValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitFunctionValParameter_thenCallsTypeAccept() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        mock(KotlinValueParameterMetadata.class);
    doNothing()
        .when(kotlinValueParameterMetadata)
        .typeAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitFunctionValParameter(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinValueParameterMetadata);

    // Assert
    verify(kotlinValueParameterMetadata)
        .typeAccept(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link
   * KotlinReferencedClassVisitor#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitKotlinClassMetadata() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .contextReceiverTypesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .delegatedPropertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .propertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .typeAliasesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeAliasVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitKotlinClassMetadata(clazz, kotlinClassKindMetadata);

    // Assert
    verify(kotlinClassKindMetadata)
        .contextReceiverTypesAccept(isA(Clazz.class), isA(KotlinTypeVisitor.class));
    verify(kotlinClassKindMetadata)
        .delegatedPropertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinClassKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
    verify(kotlinClassKindMetadata)
        .propertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinClassKindMetadata)
        .typeAliasesAccept(isA(Clazz.class), isA(KotlinTypeAliasVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link
   * KotlinReferencedClassVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <p>Method under test: {@link
   * KotlinReferencedClassVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitKotlinDeclarationContainerMetadata() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .delegatedPropertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .propertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .typeAliasesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeAliasVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinDeclarationContainerMetadata)
        .delegatedPropertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .propertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .typeAliasesAccept(isA(Clazz.class), isA(KotlinTypeAliasVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link
   * KotlinReferencedClassVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <p>Method under test: {@link
   * KotlinReferencedClassVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitKotlinSyntheticClassMetadata() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        mock(KotlinSyntheticClassKindMetadata.class);
    doNothing()
        .when(kotlinSyntheticClassKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitKotlinSyntheticClassMetadata(
        clazz, kotlinSyntheticClassKindMetadata);

    // Assert
    verify(kotlinSyntheticClassKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link
   * KotlinReferencedClassVisitor#visitPropertyValParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinValueParameterMetadata#typeAccept(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitPropertyValParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitPropertyValParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata); then calls typeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitPropertyValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitPropertyValParameter_thenCallsTypeAccept() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags =
        new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;
    KotlinPropertyMetadata kotlinPropertyMetadata =
        new KotlinPropertyMetadata(
            flags, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3));

    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        mock(KotlinValueParameterMetadata.class);
    doNothing()
        .when(kotlinValueParameterMetadata)
        .typeAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitPropertyValParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinValueParameterMetadata);

    // Assert
    verify(kotlinValueParameterMetadata)
        .typeAccept(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeVisitor.class));
  }

  /**
   * Test KotlinReferencedClassVisitor {@link KotlinReferencedClassVisitor#visitTypeAlias(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeAliasMetadata#annotationsAccept(Clazz,
   *       KotlinAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinReferencedClassVisitor#visitTypeAlias(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)}
   */
  @Test
  @DisplayName(
      "Test KotlinReferencedClassVisitor visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata); then calls annotationsAccept(Clazz, KotlinAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor$KotlinReferencedClassVisitor.visitTypeAlias(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata)"
  })
  void testKotlinReferencedClassVisitorVisitTypeAlias_thenCallsAnnotationsAccept() {
    // Arrange
    KotlinReferencedClassVisitor kotlinReferencedClassVisitor =
        new KotlinReferencedClassVisitor(mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeAliasMetadata kotlinTypeAliasMetadata = mock(KotlinTypeAliasMetadata.class);
    doNothing()
        .when(kotlinTypeAliasMetadata)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<KotlinAnnotationVisitor>any());
    doNothing()
        .when(kotlinTypeAliasMetadata)
        .expandedTypeAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeVisitor>any());
    doNothing()
        .when(kotlinTypeAliasMetadata)
        .typeParametersAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeParameterVisitor>any());
    doNothing()
        .when(kotlinTypeAliasMetadata)
        .underlyingTypeAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeVisitor>any());

    // Act
    kotlinReferencedClassVisitor.visitTypeAlias(
        clazz, kotlinDeclarationContainerMetadata, kotlinTypeAliasMetadata);

    // Assert
    verify(kotlinTypeAliasMetadata)
        .annotationsAccept(isA(Clazz.class), isA(KotlinAnnotationVisitor.class));
    verify(kotlinTypeAliasMetadata)
        .expandedTypeAccept(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeVisitor.class));
    verify(kotlinTypeAliasMetadata)
        .typeParametersAccept(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeParameterVisitor.class));
    verify(kotlinTypeAliasMetadata)
        .underlyingTypeAccept(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeVisitor.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(true, mock(ClassVisitor.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> referencedClassVisitor.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(true, mock(ClassVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    referencedClassVisitor.visitProgramClass(programClass);

    // Assert
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(false, mock(ClassVisitor.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).interfacesAccept(Mockito.<ClassVisitor>any());
    doNothing().when(libraryClass).methodsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).superClassAccept(Mockito.<ClassVisitor>any());

    // Act
    referencedClassVisitor.visitLibraryClass(libraryClass);

    // Assert
    verify(libraryClass).fieldsAccept(isA(MemberVisitor.class));
    verify(libraryClass).interfacesAccept(isA(ClassVisitor.class));
    verify(libraryClass).methodsAccept(isA(MemberVisitor.class));
    verify(libraryClass).superClassAccept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenCallsKotlinMetadataAccept() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(true, mock(ClassVisitor.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).interfacesAccept(Mockito.<ClassVisitor>any());
    doNothing().when(libraryClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(libraryClass).methodsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).superClassAccept(Mockito.<ClassVisitor>any());

    // Act
    referencedClassVisitor.visitLibraryClass(libraryClass);

    // Assert
    verify(libraryClass).fieldsAccept(isA(MemberVisitor.class));
    verify(libraryClass).interfacesAccept(isA(ClassVisitor.class));
    verify(libraryClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(libraryClass).methodsAccept(isA(MemberVisitor.class));
    verify(libraryClass).superClassAccept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).accept(Mockito.<ClassVisitor>any());
    LibraryClass libraryClass2 = new LibraryClass();
    libraryClass2.interfaceClasses = new Clazz[] {new LibraryClass()};
    libraryClass2.kotlinMetadata = null;
    libraryClass2.superClass = libraryClass;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> referencedClassVisitor.visitLibraryClass(libraryClass2));
    verify(libraryClass).accept(isA(ClassVisitor.class));
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName("Test visitProgramMember(ProgramClass, ProgramMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    referencedClassVisitor.visitProgramMember(
        programClass, new ProgramField(1, 1, 1, new ProgramClass()));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName("Test visitProgramMember(ProgramClass, ProgramMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember2() {
    // Arrange
    new UnsupportedOperationException("foo");
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    referencedClassVisitor.visitProgramMember(
        programClass, new ProgramMethod(1, 1, 1, new Clazz[] {new ProgramClass()}));

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    referencedClassVisitor.visitProgramMember(
        programClass, new ProgramField(1, 1, 1, new LibraryClass()));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenCallsVisitLibraryClass2() {
    // Arrange
    new UnsupportedOperationException("foo");
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    referencedClassVisitor.visitProgramMember(
        programClass, new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    StringConstant stringConstant = new StringConstant();
    stringConstant.referencedClass = new LibraryClass();
    stringConstant.referencedMember = null;

    // Act
    referencedClassVisitor.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnyRefConstant(Clazz, RefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnyRefConstant(Clazz, RefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyRefConstant(Clazz, RefConstant); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnyRefConstant(proguard.classfile.Clazz, proguard.classfile.constant.RefConstant)"
  })
  void testVisitAnyRefConstant_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    FieldrefConstant refConstant = new FieldrefConstant();
    refConstant.referencedClass = new LibraryClass();

    // Act
    referencedClassVisitor.visitAnyRefConstant(clazz, refConstant);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    invokeDynamicConstant.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    invokeDynamicConstant.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();
    classConstant.referencedClass = new LibraryClass();

    // Act
    referencedClassVisitor.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    methodTypeConstant.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    methodTypeConstant.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    enclosingMethodAttribute.referencedClass = new LibraryClass();

    // Act
    referencedClassVisitor.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    signatureAttribute.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    SignatureAttribute signatureAttribute = new SignatureAttribute(1, 1);

    signatureAttribute.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(true, mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    referencedClassVisitor.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(true, mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    referencedClassVisitor.visitAnnotationDefaultAttribute(
        clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    localVariableInfo.referencedClass = new LibraryClass();

    // Act
    referencedClassVisitor.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    localVariableTypeInfo.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    localVariableTypeInfo.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    annotation.u2elementValuesCount = 0;
    annotation.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitAnnotation(clazz, annotation);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    annotation.u2elementValuesCount = 0;
    annotation.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitAnnotation(clazz, annotation);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    enumConstantElementValue.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitEnumConstantElementValue(
        clazz, annotation, enumConstantElementValue);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    EnumConstantElementValue enumConstantElementValue = new EnumConstantElementValue(1, 1, 1);

    enumConstantElementValue.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitEnumConstantElementValue(
        clazz, annotation, enumConstantElementValue);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, classVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = new ClassElementValue(1, 1);

    classElementValue.referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    referencedClassVisitor.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = new ClassElementValue(1, 1);

    classElementValue.referencedClasses = new Clazz[] {new ProgramClass()};

    // Act
    referencedClassVisitor.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link ReferencedClassVisitor#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ReferencedClassVisitor#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ReferencedClassVisitor.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor =
        new ReferencedClassVisitor(true, mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    referencedClassVisitor.visitAnnotationElementValue(clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }
}
