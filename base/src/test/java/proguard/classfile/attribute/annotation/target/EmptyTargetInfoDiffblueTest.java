package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.guardsquare.proguard.assembler.AnnotationsParser;
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
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor;

class EmptyTargetInfoDiffblueTest {
  /**
   * Test {@link EmptyTargetInfo#EmptyTargetInfo()}.
   *
   * <ul>
   *   <li>Then return TargetType is {@link TargetInfo#TARGET_TYPE_PARAMETER_GENERIC_CLASS}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyTargetInfo#EmptyTargetInfo()}
   */
  @Test
  @DisplayName(
      "Test new EmptyTargetInfo(); then return TargetType is TARGET_TYPE_PARAMETER_GENERIC_CLASS")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.<init>(byte)"
  })
  void testNewEmptyTargetInfo_thenReturnTargetTypeIsTarget_type_parameter_generic_class() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new EmptyTargetInfo()).getTargetType());
  }

  /**
   * Test {@link EmptyTargetInfo#EmptyTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyTargetInfo#EmptyTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new EmptyTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.<init>(byte)"
  })
  void testNewEmptyTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new EmptyTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link EmptyTargetInfo#accept(Clazz, Field, TypeAnnotation, TargetInfoVisitor)} with
   * {@code clazz}, {@code field}, {@code typeAnnotation}, {@code targetInfoVisitor}.
   *
   * <p>Method under test: {@link EmptyTargetInfo#accept(Clazz, Field, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, TypeAnnotation, TargetInfoVisitor) with 'clazz', 'field', 'typeAnnotation', 'targetInfoVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor)"
  })
  void testAcceptWithClazzFieldTypeAnnotationTargetInfoVisitor() {
    // Arrange
    EmptyTargetInfo emptyTargetInfo = new EmptyTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    AnnotationsParser targetInfoVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(targetInfoVisitor)
        .visitEmptyTargetInfo(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<EmptyTargetInfo>any());

    // Act
    emptyTargetInfo.accept(clazz, field, typeAnnotation, targetInfoVisitor);

    // Assert
    verify(targetInfoVisitor)
        .visitEmptyTargetInfo(
            isA(Clazz.class),
            isA(Field.class),
            isA(TypeAnnotation.class),
            isA(EmptyTargetInfo.class));
  }

  /**
   * Test {@link EmptyTargetInfo#accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor)} with
   * {@code clazz}, {@code method}, {@code typeAnnotation}, {@code targetInfoVisitor}.
   *
   * <p>Method under test: {@link EmptyTargetInfo#accept(Clazz, Method, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor) with 'clazz', 'method', 'typeAnnotation', 'targetInfoVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor)"
  })
  void testAcceptWithClazzMethodTypeAnnotationTargetInfoVisitor() {
    // Arrange
    EmptyTargetInfo emptyTargetInfo = new EmptyTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    AnnotationsParser targetInfoVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(targetInfoVisitor)
        .visitEmptyTargetInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<EmptyTargetInfo>any());

    // Act
    emptyTargetInfo.accept(clazz, method, typeAnnotation, targetInfoVisitor);

    // Assert
    verify(targetInfoVisitor)
        .visitEmptyTargetInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(TypeAnnotation.class),
            isA(EmptyTargetInfo.class));
  }

  /**
   * Test {@link EmptyTargetInfo#accept(Clazz, TypeAnnotation, TargetInfoVisitor)} with {@code
   * clazz}, {@code typeAnnotation}, {@code targetInfoVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link TargetInfoVisitor#visitEmptyTargetInfo(Clazz, Field, TypeAnnotation,
   *       EmptyTargetInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyTargetInfo#accept(Clazz, TypeAnnotation, TargetInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, TypeAnnotation, TargetInfoVisitor) with 'clazz', 'typeAnnotation', 'targetInfoVisitor'; then calls visitEmptyTargetInfo(Clazz, Field, TypeAnnotation, EmptyTargetInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.EmptyTargetInfo.accept(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor)"
  })
  void testAcceptWithClazzTypeAnnotationTargetInfoVisitor_thenCallsVisitEmptyTargetInfo() {
    // Arrange
    EmptyTargetInfo emptyTargetInfo = new EmptyTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    TargetInfoVisitor targetInfoVisitor = mock(TargetInfoVisitor.class);
    doNothing()
        .when(targetInfoVisitor)
        .visitEmptyTargetInfo(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<EmptyTargetInfo>any());

    // Act
    emptyTargetInfo.accept(clazz, typeAnnotation, targetInfoVisitor);

    // Assert
    verify(targetInfoVisitor)
        .visitEmptyTargetInfo(
            isA(Clazz.class),
            (Field) isNull(),
            isA(TypeAnnotation.class),
            isA(EmptyTargetInfo.class));
  }
}
