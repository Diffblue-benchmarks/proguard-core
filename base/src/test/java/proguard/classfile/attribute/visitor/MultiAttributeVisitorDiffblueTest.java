package proguard.classfile.attribute.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.DeprecatedAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.ExceptionsAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.LineNumberTableAttribute;
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;
import proguard.classfile.attribute.MethodParametersAttribute;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.NestMembersAttribute;
import proguard.classfile.attribute.PermittedSubclassesAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDebugExtensionAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.SyntheticAttribute;
import proguard.classfile.attribute.UnknownAttribute;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.module.ModuleAttribute;
import proguard.classfile.attribute.module.ModuleMainClassAttribute;
import proguard.classfile.attribute.module.ModulePackagesAttribute;
import proguard.classfile.attribute.preverification.StackMapAttribute;
import proguard.classfile.attribute.preverification.StackMapTableAttribute;
import proguard.classfile.editor.ConstantPoolRemapper;

class MultiAttributeVisitorDiffblueTest {
  /**
   * Test {@link MultiAttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); then calls visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_thenCallsVisitUnknownAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(allAttributeVisitor)
        .visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then calls visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenCallsVisitSourceFileAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSourceFileAttribute(Mockito.<Clazz>any(), Mockito.<SourceFileAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitSourceFileAttribute(isA(Clazz.class), isA(SourceFileAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then calls visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenCallsVisitSourceDirAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSourceDirAttribute(Mockito.<Clazz>any(), Mockito.<SourceDirAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitSourceDirAttribute(isA(Clazz.class), isA(SourceDirAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSourceDebugExtensionAttribute(
            Mockito.<Clazz>any(), Mockito.<SourceDebugExtensionAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitSourceDebugExtensionAttribute(
        clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitSourceDebugExtensionAttribute(
            isA(Clazz.class), isA(SourceDebugExtensionAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitInnerClassesAttribute(Clazz,
   *       InnerClassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsVisitInnerClassesAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitInnerClassesAttribute(Mockito.<Clazz>any(), Mockito.<InnerClassesAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitInnerClassesAttribute(isA(Clazz.class), isA(InnerClassesAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitEnclosingMethodAttribute(Clazz,
   *       EnclosingMethodAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsVisitEnclosingMethodAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitEnclosingMethodAttribute(
            Mockito.<Clazz>any(), Mockito.<EnclosingMethodAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitEnclosingMethodAttribute(isA(Clazz.class), isA(EnclosingMethodAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then calls visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenCallsVisitNestHostAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitNestHostAttribute(Mockito.<Clazz>any(), Mockito.<NestHostAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitNestHostAttribute(isA(Clazz.class), isA(NestHostAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestMembersAttribute(Clazz,
   *       NestMembersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsVisitNestMembersAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitNestMembersAttribute(Mockito.<Clazz>any(), Mockito.<NestMembersAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitNestMembersAttribute(clazz, new NestMembersAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitNestMembersAttribute(isA(Clazz.class), isA(NestMembersAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitPermittedSubclassesAttribute(Clazz,
   *       PermittedSubclassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsVisitPermittedSubclassesAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitPermittedSubclassesAttribute(
            Mockito.<Clazz>any(), Mockito.<PermittedSubclassesAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitPermittedSubclassesAttribute(
        clazz, new PermittedSubclassesAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitPermittedSubclassesAttribute(
            isA(Clazz.class), isA(PermittedSubclassesAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleAttribute(Clazz, ModuleAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitModuleAttribute(Clazz,
   * ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then calls visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsVisitModuleAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitModuleAttribute(Mockito.<Clazz>any(), Mockito.<ModuleAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(allAttributeVisitor).visitModuleAttribute(isA(Clazz.class), isA(ModuleAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleMainClassAttribute(Clazz,
   *       ModuleMainClassAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then calls visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenCallsVisitModuleMainClassAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitModuleMainClassAttribute(
            Mockito.<Clazz>any(), Mockito.<ModuleMainClassAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitModuleMainClassAttribute(isA(Clazz.class), isA(ModuleMainClassAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModulePackagesAttribute(Clazz,
   *       ModulePackagesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then calls visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenCallsVisitModulePackagesAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitModulePackagesAttribute(Mockito.<Clazz>any(), Mockito.<ModulePackagesAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitModulePackagesAttribute(isA(Clazz.class), isA(ModulePackagesAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitDeprecatedAttribute(Mockito.<Clazz>any(), Mockito.<DeprecatedAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(allAttributeVisitor)
        .visitDeprecatedAttribute(isA(Clazz.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert that nothing has changed
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert that nothing has changed
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<DeprecatedAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Field.class), isA(DeprecatedAttribute.class));
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor2.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert that nothing has changed
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert
    assertEquals(2, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert that nothing has changed
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert that nothing has changed
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<DeprecatedAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Method.class), isA(DeprecatedAttribute.class));
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor2.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert that nothing has changed
    assertEquals(1, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = new DeprecatedAttribute(1);

    // Act
    multiAttributeVisitor.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert
    assertEquals(2, deprecatedAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SyntheticAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(Field.class), isA(SyntheticAttribute.class));
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor2.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert
    assertEquals(2, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SyntheticAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitSyntheticAttribute(
            isA(Clazz.class), isA(Method.class), isA(SyntheticAttribute.class));
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor2.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = new SyntheticAttribute(1);

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert
    assertEquals(2, syntheticAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with
   * {@code clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSyntheticAttribute(Mockito.<Clazz>any(), Mockito.<SyntheticAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(allAttributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field, SignatureAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSyntheticAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field, SignatureAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSyntheticAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field, SignatureAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SignatureAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(Field.class), isA(SignatureAttribute.class));
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field, SignatureAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSyntheticAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor2.visitSignatureAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field, SignatureAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSyntheticAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert
    assertEquals(2, syntheticAttribute.u2attributeNameIndex);
    assertEquals(2, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSyntheticAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSyntheticAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SignatureAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(Method.class), isA(SignatureAttribute.class));
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSyntheticAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor2.visitSignatureAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSyntheticAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert
    assertEquals(2, syntheticAttribute.u2attributeNameIndex);
    assertEquals(2, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSyntheticAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSyntheticAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<SignatureAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, syntheticAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(RecordComponentInfo.class), isA(SignatureAttribute.class));
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSyntheticAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor2.visitSignatureAttribute(clazz, recordComponentInfo, syntheticAttribute);

    // Assert that nothing has changed
    assertEquals(1, syntheticAttribute.u2attributeNameIndex);
    assertEquals(1, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSyntheticAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute syntheticAttribute = new SignatureAttribute(1, 1);

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, recordComponentInfo, syntheticAttribute);

    // Assert
    assertEquals(2, syntheticAttribute.u2attributeNameIndex);
    assertEquals(2, syntheticAttribute.u2signatureIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSyntheticAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitSignatureAttribute(Mockito.<Clazz>any(), Mockito.<SignatureAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitConstantValueAttribute(Clazz, Field,
   *       ConstantValueAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then calls visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenCallsVisitConstantValueAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitConstantValueAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<ConstantValueAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitConstantValueAttribute(
        clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(allAttributeVisitor)
        .visitConstantValueAttribute(
            isA(Clazz.class), isA(Field.class), isA(ConstantValueAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitMethodParametersAttribute(Clazz, Method,
   *       MethodParametersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitMethodParametersAttribute(Clazz,
   * Method, MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsVisitMethodParametersAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitMethodParametersAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<MethodParametersAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitMethodParametersAttribute(
        clazz, method, new MethodParametersAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitMethodParametersAttribute(
            isA(Clazz.class), isA(Method.class), isA(MethodParametersAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitExceptionsAttribute(Clazz, Method,
   *       ExceptionsAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then calls visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenCallsVisitExceptionsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitExceptionsAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitExceptionsAttribute(
            isA(Clazz.class), isA(Method.class), isA(ExceptionsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   *       StackMapAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsVisitStackMapAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitStackMapAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitStackMapAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitStackMapTableAttribute(Clazz, Method,
   *       CodeAttribute, StackMapTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsVisitStackMapTableAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitStackMapTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapTableAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitStackMapTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapTableAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitLineNumberTableAttribute(Clazz, Method,
   *       CodeAttribute, LineNumberTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then calls visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenCallsVisitLineNumberTableAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitLineNumberTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LineNumberTableAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitLineNumberTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LineNumberTableAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitLocalVariableTableAttribute(Clazz, Method,
   *       CodeAttribute, LocalVariableTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsVisitLocalVariableTableAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitLocalVariableTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTableAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTableAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitLocalVariableTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTableAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeTableAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTypeTableAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeTableAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeVisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeVisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeVisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeVisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        new RuntimeVisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        new RuntimeInvisibleAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute2() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleParameterAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeVisibleParameterAnnotationsAttribute.class));
    assertEquals(0, runtimeVisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute3() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeVisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Given {@link MultiAttributeVisitor#MultiAttributeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute); given MultiAttributeVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute_givenMultiAttributeVisitor() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        new RuntimeVisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeVisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute2() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute3() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleParameterAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleParameterAnnotationsAttribute.class));
    assertEquals(0, runtimeInvisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute4() {
    // Arrange
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor();
    MultiAttributeVisitor multiAttributeVisitor2 =
        new MultiAttributeVisitor(multiAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor2.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert that nothing has changed
    assertEquals(0, runtimeInvisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 2, 1, 2});
    MultiAttributeVisitor multiAttributeVisitor =
        new MultiAttributeVisitor(new MultiAttributeVisitor(), constantPoolRemapper);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        new RuntimeInvisibleParameterAnnotationsAttribute();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert
    assertEquals(1, runtimeInvisibleParameterAnnotationsAttribute.u2attributeNameIndex);
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Field.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * MultiAttributeVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiAttributeVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link MultiAttributeVisitor#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitAnnotationDefaultAttribute(Clazz, Method,
   *       AnnotationDefaultAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiAttributeVisitor#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.MultiAttributeVisitor.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsVisitAnnotationDefaultAttribute() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(allAttributeVisitor)
        .visitAnnotationDefaultAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationDefaultAttribute>any());
    MultiAttributeVisitor multiAttributeVisitor = new MultiAttributeVisitor(allAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    multiAttributeVisitor.visitAnnotationDefaultAttribute(
        clazz, method, new AnnotationDefaultAttribute());

    // Assert
    verify(allAttributeVisitor)
        .visitAnnotationDefaultAttribute(
            isA(Clazz.class), isA(Method.class), isA(AnnotationDefaultAttribute.class));
  }
}
