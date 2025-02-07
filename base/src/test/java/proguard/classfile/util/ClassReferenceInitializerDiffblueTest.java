package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
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
import proguard.classfile.attribute.visitor.RecordComponentInfoVisitor;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.RefConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;

class ClassReferenceInitializerDiffblueTest {
  /**
   * Test {@link ClassReferenceInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    classReferenceInitializer.visitProgramClass(programClass);

    // Assert
    verify(programClass, atLeast(1)).attributesAccept(Mockito.<AttributeVisitor>any());
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"D1"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertNull(clazzList.get(0));
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass2() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertTrue(clazzList.get(0) instanceof ProgramClass);
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass3() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            new ClassPool(),
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class));
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertTrue(clazzList.get(0) instanceof ProgramClass);
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass4() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"kotlin/Function"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertTrue(clazzList.get(0) instanceof ProgramClass);
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass5() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {""}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    assertSame(
        kotlinMetadata.referencedPartClasses,
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass6() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class));
    LibraryClass libraryClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinMultiFileFacadeKindMetadata(
                new int[] {1, 0, 1, 0}, new String[] {}, 1, "Xs", "Pn"));

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    KotlinMetadata kotlinMetadata = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof KotlinMultiFileFacadeKindMetadata);
    assertTrue(
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata).referencedPartClasses.isEmpty());
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    KotlinMultiFileFacadeKindMetadata kotlinMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 0, 1, 0}, new String[] {"D1"}, 1, "Xs", "Pn");

    LibraryClass libraryClass =
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Act
    classReferenceInitializer.visitLibraryClass(libraryClass);

    // Assert
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("D1"));
    KotlinMetadata kotlinMetadata2 = libraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinMultiFileFacadeKindMetadata);
    List<Clazz> clazzList =
        ((KotlinMultiFileFacadeKindMetadata) kotlinMetadata2).referencedPartClasses;
    assertEquals(1, clazzList.size());
    assertNull(clazzList.get(0));
    assertSame(kotlinMetadata.referencedPartClasses, clazzList);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classReferenceInitializer.visitLibraryClass(
                new LibraryClass(
                    1,
                    "This Class Name",
                    "Super Class Name",
                    new KotlinMultiFileFacadeKindMetadata(
                        new int[] {1, 0, 1, 0}, new String[] {"kotlin/Function"}, 1, "Xs", "Pn"))));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@link
   *       LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link ClassPool#getClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given ClassPool getClass(String) return LibraryClass(); then calls getClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenClassPoolGetClassReturnLibraryClass_thenCallsGetClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool,
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programField.getDescriptor(Mockito.<Clazz>any()))
        .thenReturn("proguard.classfile.ProgramClass");

    // Act
    classReferenceInitializer.visitProgramField(programClass, programField);

    // Assert
    verify(programClassPool).getClass(eq("null$classfile"));
    verify(programField, atLeast(1))
        .attributesAccept(isA(ProgramClass.class), Mockito.<AttributeVisitor>any());
    verify(programField).getDescriptor(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField); given 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenDescriptor() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programField.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    classReferenceInitializer.visitProgramField(programClass, programField);

    // Assert
    verify(programField, atLeast(1))
        .attributesAccept(isA(ProgramClass.class), Mockito.<AttributeVisitor>any());
    verify(programField).getDescriptor(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@code Clazz[]}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given 'proguard.classfile.Clazz[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenProguardClassfileClazz() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("proguard.classfile.Clazz[]");

    // Act
    classReferenceInitializer.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programField.getDescriptor(Mockito.<Clazz>any()))
        .thenReturn("proguard.classfile.ProgramClass");

    // Act
    classReferenceInitializer.visitProgramField(programClass, programField);

    // Assert
    verify(programField, atLeast(1))
        .attributesAccept(isA(ProgramClass.class), Mockito.<AttributeVisitor>any());
    verify(programField).getDescriptor(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("null$classfile"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ProgramMember#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given 'Descriptor'; when ProgramClass; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenDescriptor_whenProgramClass_thenCallsGetDescriptor() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    classReferenceInitializer.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod, atLeast(1))
        .attributesAccept(isA(ProgramClass.class), Mockito.<AttributeVisitor>any());
  }

  /**
   * Test {@link ClassReferenceInitializer#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    classReferenceInitializer.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("java/lang/String"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitStringConstant(Clazz,
   * StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("java/lang/String"))
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitStringConstant(clazz, new StringConstant()));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("java/lang/String"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then calls {@link LibraryClass#getType(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitDynamicConstant(Clazz,
   * DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); given 'foo'; then calls getType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.DynamicConstant)"
  })
  void testVisitDynamicConstant_givenFoo_thenCallsGetType() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("foo");

    // Act
    classReferenceInitializer.visitDynamicConstant(clazz, new DynamicConstant());

    // Assert
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then calls {@link LibraryClass#getType(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); given 'foo'; then calls getType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_givenFoo_thenCallsGetType() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getType(anyInt())).thenReturn("foo");

    // Act
    classReferenceInitializer.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    classReferenceInitializer.visitMethodHandleConstant(clazz, new MethodHandleConstant(1, 1));

    // Assert
    verify(invalidReferenceVisitor)
        .visitMissingClass(isA(Clazz.class), eq("java/lang/invoke/MethodHandle"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitMethodHandleConstant(Clazz, MethodHandleConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitMethodHandleConstant(Clazz,
   * MethodHandleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodHandleConstant(Clazz, MethodHandleConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitMethodHandleConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodHandleConstant)"
  })
  void testVisitMethodHandleConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("java/lang/invoke/MethodHandle"))
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classReferenceInitializer.visitMethodHandleConstant(
                clazz, new MethodHandleConstant(1, 1)));
    verify(invalidReferenceVisitor)
        .visitMissingClass(isA(Clazz.class), eq("java/lang/invoke/MethodHandle"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName("Test visitFieldrefConstant(Clazz, FieldrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName("Test visitFieldrefConstant(Clazz, FieldrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "This Class Name", "Super Class Name"));
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName("Test visitFieldrefConstant(Clazz, FieldrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant3() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant()));
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@link
   *       ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); given ClassPool getClass(String) return ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenClassPoolGetClassReturnProgramClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName("Test visitFieldrefConstant(Clazz, FieldrefConstant); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenEmptyString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(mock(Clazz.class));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    when(fieldrefConstant.getName(Mockito.<Clazz>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    when(fieldrefConstant.getClassName(Mockito.<Clazz>any())).thenReturn("");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitFieldrefConstant(clazz, fieldrefConstant));
    verify(programClassPool).getClass(eq(""));
    verify(fieldrefConstant).getClassName(isA(Clazz.class));
    verify(fieldrefConstant).getName(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   *       ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then calls hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenCallsHierarchyAccept() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(libraryClass)
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(false), isA(ClassVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("Class Name"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidMemberReferenceVisitor#visitMissingLibraryField(Clazz,
   *       LibraryClass, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then calls visitMissingLibraryField(Clazz, LibraryClass, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenCallsVisitMissingLibraryField() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "This Class Name", "Super Class Name"));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingLibraryField(
            Mockito.<Clazz>any(),
            Mockito.<LibraryClass>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    verify(invalidReferenceVisitor)
        .visitMissingLibraryField(
            isA(Clazz.class), isA(LibraryClass.class), eq("Name"), eq("Type"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidMemberReferenceVisitor#visitMissingProgramField(Clazz,
   *       ProgramClass, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then calls visitMissingProgramField(Clazz, ProgramClass, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenCallsVisitMissingProgramField() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingProgramField(
            Mockito.<Clazz>any(),
            Mockito.<ProgramClass>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    verify(invalidReferenceVisitor)
        .visitMissingProgramField(
            isA(Clazz.class), isA(ProgramClass.class), eq("Name"), eq("Type"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>When {@link FieldrefConstant} {@link RefConstant#getClassName(Clazz)} return {@code Class
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); when FieldrefConstant getClassName(Clazz) return 'Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_whenFieldrefConstantGetClassNameReturnClassName() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(mock(Clazz.class));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    when(fieldrefConstant.getName(Mockito.<Clazz>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    when(fieldrefConstant.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitFieldrefConstant(clazz, fieldrefConstant));
    verify(programClassPool).getClass(eq("Class Name"));
    verify(fieldrefConstant).getClassName(isA(Clazz.class));
    verify(fieldrefConstant).getName(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "This Class Name", "Super Class Name"));
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant3() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classReferenceInitializer.visitAnyMethodrefConstant(
                clazz, new InterfaceMethodrefConstant()));
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant4() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(mock(Clazz.class));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    AnyMethodrefConstant anyMethodrefConstant = mock(AnyMethodrefConstant.class);
    when(anyMethodrefConstant.getName(Mockito.<Clazz>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    when(anyMethodrefConstant.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitAnyMethodrefConstant(clazz, anyMethodrefConstant));
    verify(programClassPool).getClass(eq("Class Name"));
    verify(anyMethodrefConstant).getClassName(isA(Clazz.class));
    verify(anyMethodrefConstant).getName(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#getClass(String)} return {@link
   *       ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); given ClassPool getClass(String) return ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_givenClassPoolGetClassReturnProgramClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName("Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_givenEmptyString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(mock(Clazz.class));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    AnyMethodrefConstant anyMethodrefConstant = mock(AnyMethodrefConstant.class);
    when(anyMethodrefConstant.getName(Mockito.<Clazz>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    when(anyMethodrefConstant.getClassName(Mockito.<Clazz>any())).thenReturn("");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitAnyMethodrefConstant(clazz, anyMethodrefConstant));
    verify(programClassPool).getClass(eq(""));
    verify(anyMethodrefConstant).getClassName(isA(Clazz.class));
    verify(anyMethodrefConstant).getName(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   *       ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); then calls hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_thenCallsHierarchyAccept() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(libraryClass)
        .hierarchyAccept(eq(true), eq(true), eq(true), eq(false), isA(ClassVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("Class Name"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidMemberReferenceVisitor#visitMissingLibraryMethod(Clazz,
   *       LibraryClass, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); then calls visitMissingLibraryMethod(Clazz, LibraryClass, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_thenCallsVisitMissingLibraryMethod() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "This Class Name", "Super Class Name"));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingLibraryMethod(
            Mockito.<Clazz>any(),
            Mockito.<LibraryClass>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    verify(invalidReferenceVisitor)
        .visitMissingLibraryMethod(
            isA(Clazz.class), isA(LibraryClass.class), eq("Name"), eq("Type"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidMemberReferenceVisitor#visitMissingProgramMethod(Clazz,
   *       ProgramClass, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyMethodrefConstant(Clazz,
   * AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyMethodrefConstant(Clazz, AnyMethodrefConstant); then calls visitMissingProgramMethod(Clazz, ProgramClass, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testVisitAnyMethodrefConstant_thenCallsVisitMissingProgramMethod() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingProgramMethod(
            Mockito.<Clazz>any(),
            Mockito.<ProgramClass>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitAnyMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).getClassName(eq(0));
    verify(clazz, atLeast(1)).getName();
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    verify(invalidReferenceVisitor)
        .visitMissingProgramMethod(
            isA(Clazz.class), isA(ProgramClass.class), eq("Name"), eq("Type"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert that nothing has changed
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ClassConstant classConstant = new ClassConstant();

    // Act
    classReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(clazz).getString(eq(0));
    assertTrue(classConstant.javaLangClassClass instanceof LibraryClass);
    assertTrue(classConstant.referencedClass instanceof LibraryClass);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant3() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitClassConstant(clazz, new ClassConstant());

    // Assert that nothing has changed
    verify(clazz).getString(eq(0));
    verify(invalidReferenceVisitor, atLeast(1))
        .visitMissingClass(isA(Clazz.class), Mockito.<String>any());
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant4() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(null);
    ClassPool libraryClassPool = mock(ClassPool.class);
    when(libraryClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, libraryClassPool, true, mock(InvalidReferenceVisitor.class));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(libraryClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName("Test visitClassConstant(Clazz, ClassConstant); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenEmptyString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("");
    ClassConstant classConstant = new ClassConstant();

    // Act
    classReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(clazz).getString(eq(0));
    verify(invalidReferenceVisitor, atLeast(1))
        .visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    assertTrue(classConstant.javaLangClassClass instanceof LibraryClass);
    assertTrue(classConstant.referencedClass instanceof LibraryClass);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(classConstant).getName(isA(Clazz.class));
    verify(invalidReferenceVisitor, atLeast(1))
        .visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsVisitMissingClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(null);
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    classReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(classConstant).getName(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("java/lang/Class"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then {@link ClassConstant#ClassConstant()} {@link ClassConstant#javaLangClassClass}
   *       {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then ClassConstant() javaLangClassClass LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenClassConstantJavaLangClassClassLibraryClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    ClassConstant classConstant = new ClassConstant();

    // Act
    classReferenceInitializer.visitClassConstant(clazz, classConstant);

    // Assert
    verify(programClassPool, atLeast(1)).getClass(Mockito.<String>any());
    verify(clazz).getString(eq(0));
    verify(invalidReferenceVisitor, atLeast(1))
        .visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    assertTrue(classConstant.javaLangClassClass instanceof LibraryClass);
    assertTrue(classConstant.referencedClass instanceof LibraryClass);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassConstant(Clazz,
   * ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("java/lang/Class"))
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitClassConstant(clazz, new ClassConstant()));
    verify(programClassPool).getClass(eq("String"));
    verify(clazz).getString(eq(0));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenThrowUnsupportedOperationException() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("java/lang/invoke/MethodType"))
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceInitializer.visitMethodTypeConstant(clazz, new MethodTypeConstant()));
    verify(invalidReferenceVisitor)
        .visitMissingClass(isA(Clazz.class), eq("java/lang/invoke/MethodType"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitRecordAttribute(Clazz,
   * RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttributeAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttributeAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    classReferenceInitializer.visitRecordAttribute(clazz, recordAttributeAttribute);

    // Assert
    verify(recordAttributeAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert that nothing has changed
    verify(clazz).getClassName(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(1));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
    Clazz clazz2 = enclosingMethodAttribute.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertNull(clazz2.getSuperClass());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, ((LibraryClass) clazz2).fields.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceNames.length);
    assertEquals(0, ((LibraryClass) clazz2).methods.length);
    assertEquals(1, clazz2.getAccessFlags());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute3() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new ProgramClass());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(1));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
    Clazz clazz2 = enclosingMethodAttribute.referencedClass;
    assertTrue(clazz2 instanceof ProgramClass);
    assertNull(((ProgramClass) clazz2).u2interfaces);
    assertNull(((ProgramClass) clazz2).fields);
    assertNull(((ProgramClass) clazz2).methods);
    assertNull(((ProgramClass) clazz2).attributes);
    assertNull(((ProgramClass) clazz2).constantPool);
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getSuperClass());
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, ((ProgramClass) clazz2).subClasses.length);
    assertEquals(0, ((ProgramClass) clazz2).u2attributesCount);
    assertEquals(0, ((ProgramClass) clazz2).u2constantPoolCount);
    assertEquals(0, ((ProgramClass) clazz2).u2fieldsCount);
    assertEquals(0, ((ProgramClass) clazz2).u2methodsCount);
    assertEquals(0, ((ProgramClass) clazz2).u2superClass);
    assertEquals(0, ((ProgramClass) clazz2).u2thisClass);
    assertEquals(0, ((ProgramClass) clazz2).u4version);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute4() {
    // Arrange
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1, "Name", "Descriptor"));
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(programClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(libraryClass).findMethod(eq("Name"), eq("Type"));
    verify(clazz).getClassName(eq(1));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
    Method method = enclosingMethodAttribute.referencedMethod;
    assertTrue(method instanceof LibraryMethod);
    assertEquals("Descriptor", ((LibraryMethod) method).descriptor);
    assertEquals("Name", ((LibraryMethod) method).name);
    assertNull(((LibraryMethod) method).referencedClasses);
    assertNull(method.getProcessingInfo());
    assertEquals(0, method.getProcessingFlags());
    assertEquals(1, method.getAccessFlags());
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute5() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 0);

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(1));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    Clazz clazz2 = enclosingMethodAttribute.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertNull(clazz2.getSuperClass());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, ((LibraryClass) clazz2).fields.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceNames.length);
    assertEquals(0, ((LibraryClass) clazz2).methods.length);
    assertEquals(1, clazz2.getAccessFlags());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_givenEmptyString() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingEnclosingMethod(
            Mockito.<Clazz>any(),
            Mockito.<Clazz>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("");
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq(""));
    verify(clazz).getClassName(eq(1));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    verify(invalidReferenceVisitor)
        .visitMissingEnclosingMethod(isA(Clazz.class), isA(Clazz.class), eq("Name"), eq("Type"));
    Clazz clazz2 = enclosingMethodAttribute.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertNull(clazz2.getSuperClass());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, ((LibraryClass) clazz2).fields.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceNames.length);
    assertEquals(0, ((LibraryClass) clazz2).methods.length);
    assertEquals(1, clazz2.getAccessFlags());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert that nothing has changed
    verify(clazz).getClassName(eq(1));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("Class Name"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidMemberReferenceVisitor#visitMissingEnclosingMethod(Clazz, Clazz,
   *       String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls visitMissingEnclosingMethod(Clazz, Clazz, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsVisitMissingEnclosingMethod() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    LibraryClass libraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(libraryClass);
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingEnclosingMethod(
            Mockito.<Clazz>any(),
            Mockito.<Clazz>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    EnclosingMethodAttribute enclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(1));
    verify(clazz).getName(eq(1));
    verify(clazz).getType(eq(1));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    verify(invalidReferenceVisitor)
        .visitMissingEnclosingMethod(isA(Clazz.class), isA(Clazz.class), eq("Name"), eq("Type"));
    Clazz clazz2 = enclosingMethodAttribute.referencedClass;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", clazz2.getName());
    assertNull(clazz2.getSuperClass());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, ((LibraryClass) clazz2).fields.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceNames.length);
    assertEquals(0, ((LibraryClass) clazz2).methods.length);
    assertEquals(1, clazz2.getAccessFlags());
    assertSame(libraryClass.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classReferenceInitializer.visitEnclosingMethodAttribute(
                clazz, new EnclosingMethodAttribute(1, 1, 1)));
    verify(programClassPool).getClass(eq("Class Name"));
    verify(clazz).getClassName(eq(1));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link EnclosingMethodAttribute#getClassName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); when LibraryClass; then calls getClassName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_whenLibraryClass_thenCallsGetClassName() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any()))
        .thenReturn(new LibraryClass(1, "This Class Name", "Super Class Name"));
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    EnclosingMethodAttribute enclosingMethodAttribute = mock(EnclosingMethodAttribute.class);
    when(enclosingMethodAttribute.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(programClassPool).getClass(eq("Class Name"));
    verify(enclosingMethodAttribute).getClassName(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, Member,
   * SignatureAttribute)} with {@code clazz}, {@code member}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, Member,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Member, SignatureAttribute) with 'clazz', 'member', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMemberSignatureAttribute() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classReferenceInitializer.visitSignatureAttribute(clazz, (Member) member, signatureAttribute);

    // Assert
    verify(signatureAttribute).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, Member,
   * SignatureAttribute)} with {@code clazz}, {@code member}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, Member,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Member, SignatureAttribute) with 'clazz', 'member', 'signatureAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMemberSignatureAttribute_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    classReferenceInitializer.visitSignatureAttribute(
        clazz, (Member) member, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    classReferenceInitializer.visitSignatureAttribute(
        clazz, recordComponentInfo, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute2() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classReferenceInitializer.visitSignatureAttribute(
        clazz, recordComponentInfo, signatureAttribute);

    // Assert
    verify(signatureAttribute).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link SignatureAttribute#getSignature(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getSignature(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetSignature() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classReferenceInitializer.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(signatureAttribute).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationsAttribute#annotationsAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnyAnnotationsAttribute(Clazz,
   * AnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAnnotationsAttribute(Clazz, AnnotationsAttribute); then calls annotationsAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnyAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.AnnotationsAttribute)"
  })
  void testVisitAnyAnnotationsAttribute_thenCallsAnnotationsAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute annotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    doNothing()
        .when(annotationsAttribute)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classReferenceInitializer.visitAnyAnnotationsAttribute(clazz, annotationsAttribute);

    // Assert
    verify(annotationsAttribute).annotationsAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   *       ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls defaultValueAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsDefaultValueAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    classReferenceInitializer.visitAnnotationDefaultAttribute(
        clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); given 'Descriptor'; then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_givenDescriptor_thenCallsAttributesAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing()
        .when(clazz)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    when(recordComponentInfo.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(recordComponentInfo.getName(Mockito.<Clazz>any())).thenReturn("Name");
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());

    // Act
    classReferenceInitializer.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(clazz).hierarchyAccept(eq(true), eq(true), eq(true), eq(false), isA(ClassVisitor.class));
    verify(recordComponentInfo, atLeast(1))
        .attributesAccept(isA(Clazz.class), Mockito.<AttributeVisitor>any());
    verify(recordComponentInfo).getDescriptor(isA(Clazz.class));
    verify(recordComponentInfo).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    doNothing()
        .when(clazz)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());

    // Act
    classReferenceInitializer.visitRecordComponentInfo(clazz, new RecordComponentInfo());

    // Assert
    verify(clazz, atLeast(1)).getString(eq(0));
    verify(clazz).hierarchyAccept(eq(true), eq(true), eq(true), eq(false), isA(ClassVisitor.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenDescriptor() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = mock(LocalVariableInfo.class);
    when(localVariableInfo.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");

    // Act
    classReferenceInitializer.visitLocalVariableInfo(
        clazz, method, codeAttribute, localVariableInfo);

    // Assert
    verify(localVariableInfo).getDescriptor(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code Clazz[]}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'proguard.classfile.Clazz[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenProguardClassfileClazz() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("proguard.classfile.Clazz[]");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classReferenceInitializer.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classReferenceInitializer.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPool#getClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); then calls getClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_thenCallsGetClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = mock(LocalVariableInfo.class);
    when(localVariableInfo.getDescriptor(Mockito.<Clazz>any()))
        .thenReturn("proguard.classfile.attribute.LocalVariableInfo");

    // Act
    classReferenceInitializer.visitLocalVariableInfo(
        clazz, method, codeAttribute, localVariableInfo);

    // Assert
    verify(programClassPool).getClass(eq("null$classfile"));
    verify(localVariableInfo).getDescriptor(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doNothing()
        .when(invalidReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = mock(LocalVariableInfo.class);
    when(localVariableInfo.getDescriptor(Mockito.<Clazz>any()))
        .thenReturn("proguard.classfile.attribute.LocalVariableInfo");

    // Act
    classReferenceInitializer.visitLocalVariableInfo(
        clazz, method, codeAttribute, localVariableInfo);

    // Assert
    verify(localVariableInfo).getDescriptor(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitMissingClass(isA(Clazz.class), eq("null$classfile"));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(invalidReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            programClassPool, KotlinConstants.dummyClassPool, true, invalidReferenceVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = mock(LocalVariableInfo.class);
    when(localVariableInfo.getDescriptor(Mockito.<Clazz>any()))
        .thenReturn("proguard.classfile.attribute.LocalVariableInfo");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classReferenceInitializer.visitLocalVariableInfo(
                clazz, method, codeAttribute, localVariableInfo));
    verify(programClassPool).getClass(eq("null$classfile"));
    verify(localVariableInfo).getDescriptor(isA(Clazz.class));
    verify(invalidReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@code Signature}.
   *   <li>Then calls {@link LocalVariableTypeInfo#getSignature(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableTypeInfo(Clazz,
   * Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given 'Signature'; then calls getSignature(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenSignature_thenCallsGetSignature() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = mock(LocalVariableTypeInfo.class);
    when(localVariableTypeInfo.getSignature(Mockito.<Clazz>any())).thenReturn("Signature");

    // Act
    classReferenceInitializer.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    verify(localVariableTypeInfo).getSignature(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitLocalVariableTypeInfo(Clazz,
   * Method, CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    classReferenceInitializer.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then calls {@link Annotation#elementValuesAccept(Clazz, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given 'foo'; then calls elementValuesAccept(Clazz, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenFoo_thenCallsElementValuesAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = mock(Annotation.class);
    doNothing()
        .when(annotation)
        .elementValuesAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());
    when(annotation.getType(Mockito.<Clazz>any())).thenReturn("foo");

    // Act
    classReferenceInitializer.visitAnnotation(clazz, annotation);

    // Assert
    verify(annotation).elementValuesAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotation).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classReferenceInitializer.visitEnumConstantElementValue(
        clazz, annotation, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitEnumConstantElementValue(Clazz, Annotation,
   * EnumConstantElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitEnumConstantElementValue(Clazz,
   * Annotation, EnumConstantElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitEnumConstantElementValue(Clazz, Annotation, EnumConstantElementValue); given 'String'; when 'null'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitEnumConstantElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.EnumConstantElementValue)"
  })
  void testVisitEnumConstantElementValue_givenString_whenNull_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitEnumConstantElementValue(
        clazz, null, new EnumConstantElementValue(1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassElementValue#getClassName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassElementValue(Clazz,
   * Annotation, ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'Class Name'; when LibraryClass; then calls getClassName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenClassName_whenLibraryClass_thenCallsGetClassName() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    Annotation annotation = new Annotation();
    ClassElementValue classElementValue = mock(ClassElementValue.class);
    when(classElementValue.getClassName(Mockito.<Clazz>any())).thenReturn("Class Name");

    // Act
    classReferenceInitializer.visitClassElementValue(clazz, annotation, classElementValue);

    // Assert
    verify(classElementValue).getClassName(isA(Clazz.class));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassElementValue(Clazz,
   * Annotation, ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenString_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    Annotation annotation = new Annotation();

    // Act
    classReferenceInitializer.visitClassElementValue(
        clazz, annotation, new ClassElementValue(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitClassElementValue(Clazz, Annotation,
   * ClassElementValue)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitClassElementValue(Clazz,
   * Annotation, ClassElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitClassElementValue(Clazz, Annotation, ClassElementValue); given 'String'; when 'null'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitClassElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ClassElementValue)"
  })
  void testVisitClassElementValue_givenString_whenNull_thenCallsGetString() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    classReferenceInitializer.visitClassElementValue(clazz, null, new ClassElementValue(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ClassReferenceInitializer#visitAnnotationElementValue(Clazz, Annotation,
   * AnnotationElementValue)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#annotationAccept(Clazz, AnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceInitializer#visitAnnotationElementValue(Clazz,
   * Annotation, AnnotationElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue); then calls annotationAccept(Clazz, AnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassReferenceInitializer.visitAnnotationElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.AnnotationElementValue)"
  })
  void testVisitAnnotationElementValue_thenCallsAnnotationAccept() {
    // Arrange
    ClassReferenceInitializer classReferenceInitializer =
        new ClassReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AnnotationElementValue annotationElementValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(annotationElementValue)
        .annotationAccept(Mockito.<Clazz>any(), Mockito.<AnnotationVisitor>any());

    // Act
    classReferenceInitializer.visitAnnotationElementValue(
        clazz, annotation, annotationElementValue);

    // Assert
    verify(annotationElementValue).annotationAccept(isA(Clazz.class), isA(AnnotationVisitor.class));
  }
}
