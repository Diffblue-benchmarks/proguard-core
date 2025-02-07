package proguard.classfile.attribute.visitor;

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

class RequiredAttributeFilterDiffblueTest {
  /**
   * Test {@link RequiredAttributeFilter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); then calls visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_thenCallsVisitUnknownAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(optionalAttributeVisitor)
        .visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then calls visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenCallsVisitSourceFileAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSourceFileAttribute(Mockito.<Clazz>any(), Mockito.<SourceFileAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSourceFileAttribute(isA(Clazz.class), isA(SourceFileAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then calls visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenCallsVisitSourceDirAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSourceDirAttribute(Mockito.<Clazz>any(), Mockito.<SourceDirAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSourceDirAttribute(isA(Clazz.class), isA(SourceDirAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSourceDebugExtensionAttribute(
            Mockito.<Clazz>any(), Mockito.<SourceDebugExtensionAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitSourceDebugExtensionAttribute(
        clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitSourceDebugExtensionAttribute(
            isA(Clazz.class), isA(SourceDebugExtensionAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitInnerClassesAttribute(Clazz,
   *       InnerClassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsVisitInnerClassesAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitInnerClassesAttribute(Mockito.<Clazz>any(), Mockito.<InnerClassesAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitInnerClassesAttribute(isA(Clazz.class), isA(InnerClassesAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitEnclosingMethodAttribute(Clazz,
   *       EnclosingMethodAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsVisitEnclosingMethodAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitEnclosingMethodAttribute(
            Mockito.<Clazz>any(), Mockito.<EnclosingMethodAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitEnclosingMethodAttribute(
        clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitEnclosingMethodAttribute(isA(Clazz.class), isA(EnclosingMethodAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then calls visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenCallsVisitNestHostAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitNestHostAttribute(Mockito.<Clazz>any(), Mockito.<NestHostAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(requiredAttributeVisitor)
        .visitNestHostAttribute(isA(Clazz.class), isA(NestHostAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestMembersAttribute(Clazz,
   *       NestMembersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsVisitNestMembersAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitNestMembersAttribute(Mockito.<Clazz>any(), Mockito.<NestMembersAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitNestMembersAttribute(clazz, new NestMembersAttribute());

    // Assert
    verify(requiredAttributeVisitor)
        .visitNestMembersAttribute(isA(Clazz.class), isA(NestMembersAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitPermittedSubclassesAttribute(Clazz,
   *       PermittedSubclassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsVisitPermittedSubclassesAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitPermittedSubclassesAttribute(
            Mockito.<Clazz>any(), Mockito.<PermittedSubclassesAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitPermittedSubclassesAttribute(
        clazz, new PermittedSubclassesAttribute());

    // Assert
    verify(requiredAttributeVisitor)
        .visitPermittedSubclassesAttribute(
            isA(Clazz.class), isA(PermittedSubclassesAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleAttribute(Clazz, ModuleAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitModuleAttribute(Clazz,
   * ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then calls visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsVisitModuleAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitModuleAttribute(Mockito.<Clazz>any(), Mockito.<ModuleAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(requiredAttributeVisitor)
        .visitModuleAttribute(isA(Clazz.class), isA(ModuleAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleMainClassAttribute(Clazz,
   *       ModuleMainClassAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then calls visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenCallsVisitModuleMainClassAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitModuleMainClassAttribute(
            Mockito.<Clazz>any(), Mockito.<ModuleMainClassAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitModuleMainClassAttribute(
        clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    verify(requiredAttributeVisitor)
        .visitModuleMainClassAttribute(isA(Clazz.class), isA(ModuleMainClassAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModulePackagesAttribute(Clazz,
   *       ModulePackagesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then calls visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenCallsVisitModulePackagesAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitModulePackagesAttribute(Mockito.<Clazz>any(), Mockito.<ModulePackagesAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute());

    // Assert
    verify(requiredAttributeVisitor)
        .visitModulePackagesAttribute(isA(Clazz.class), isA(ModulePackagesAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitDeprecatedAttribute(Mockito.<Clazz>any(), Mockito.<DeprecatedAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitDeprecatedAttribute(isA(Clazz.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)} with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<DeprecatedAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitDeprecatedAttribute(
        clazz, (Field) field, new DeprecatedAttribute(1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Field.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)} with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<DeprecatedAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitDeprecatedAttribute(
        clazz, (Method) method, new DeprecatedAttribute(1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Method.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)}
   * with {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SyntheticAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitSyntheticAttribute(
        clazz, (Field) field, new SyntheticAttribute(1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(Field.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SyntheticAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitSyntheticAttribute(
        clazz, (Method) method, new SyntheticAttribute(1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSyntheticAttribute(
            isA(Clazz.class), isA(Method.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with
   * {@code clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSyntheticAttribute(Mockito.<Clazz>any(), Mockito.<SyntheticAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz, Field, SignatureAttribute)}
   * with {@code clazz}, {@code field}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSignatureAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SignatureAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitSignatureAttribute(
        clazz, (Field) field, new SignatureAttribute(1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(Field.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSignatureAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SignatureAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitSignatureAttribute(
        clazz, (Method) method, new SignatureAttribute(1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(Method.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<SignatureAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    requiredAttributeFilter.visitSignatureAttribute(
        clazz, recordComponentInfo, new SignatureAttribute(1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(RecordComponentInfo.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz, SignatureAttribute)} with
   * {@code clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitSignatureAttribute(Mockito.<Clazz>any(), Mockito.<SignatureAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(optionalAttributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitConstantValueAttribute(Clazz, Field,
   *       ConstantValueAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then calls visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenCallsVisitConstantValueAttribute() {
    // Arrange
    AllAttributeVisitor requiredAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(requiredAttributeVisitor)
        .visitConstantValueAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<ConstantValueAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(requiredAttributeVisitor, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitConstantValueAttribute(
        clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(requiredAttributeVisitor)
        .visitConstantValueAttribute(
            isA(Clazz.class), isA(Field.class), isA(ConstantValueAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitMethodParametersAttribute(Clazz, Method,
   *       MethodParametersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitMethodParametersAttribute(Clazz,
   * Method, MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsVisitMethodParametersAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitMethodParametersAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<MethodParametersAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitMethodParametersAttribute(
        clazz, method, new MethodParametersAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitMethodParametersAttribute(
            isA(Clazz.class), isA(Method.class), isA(MethodParametersAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitExceptionsAttribute(Clazz, Method,
   *       ExceptionsAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then calls visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenCallsVisitExceptionsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitExceptionsAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitExceptionsAttribute(
            isA(Clazz.class), isA(Method.class), isA(ExceptionsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   *       StackMapAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsVisitStackMapAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitStackMapAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitStackMapAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitStackMapTableAttribute(Clazz, Method,
   *       CodeAttribute, StackMapTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsVisitStackMapTableAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitStackMapTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapTableAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitStackMapTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapTableAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitLineNumberTableAttribute(Clazz, Method,
   *       CodeAttribute, LineNumberTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitLineNumberTableAttribute(Clazz,
   * Method, CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then calls visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenCallsVisitLineNumberTableAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitLineNumberTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LineNumberTableAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitLineNumberTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LineNumberTableAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitLocalVariableTableAttribute(Clazz, Method,
   *       CodeAttribute, LocalVariableTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsVisitLocalVariableTableAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitLocalVariableTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTableAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTableAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitLocalVariableTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTableAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeTableAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTypeTableAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeTableAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    requiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleParameterAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeVisibleParameterAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeVisibleParameterAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleParameterAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleParameterAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    requiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Field.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * method}, {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * RequiredAttributeFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    requiredAttributeFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link RequiredAttributeFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitAnnotationDefaultAttribute(Clazz, Method,
   *       AnnotationDefaultAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredAttributeFilter#visitAnnotationDefaultAttribute(Clazz,
   * Method, AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.RequiredAttributeFilter.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsVisitAnnotationDefaultAttribute() {
    // Arrange
    AllAttributeVisitor optionalAttributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(optionalAttributeVisitor)
        .visitAnnotationDefaultAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationDefaultAttribute>any());
    RequiredAttributeFilter requiredAttributeFilter =
        new RequiredAttributeFilter(new DominatorCalculator(true), optionalAttributeVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    requiredAttributeFilter.visitAnnotationDefaultAttribute(
        clazz, method, new AnnotationDefaultAttribute());

    // Assert
    verify(optionalAttributeVisitor)
        .visitAnnotationDefaultAttribute(
            isA(Clazz.class), isA(Method.class), isA(AnnotationDefaultAttribute.class));
  }
}
