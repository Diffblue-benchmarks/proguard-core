package proguard.classfile.attribute.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
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
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
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
import proguard.classfile.attribute.RecordAttribute;
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
import proguard.util.CollectionMatcher;

class AttributeNameFilterDiffblueTest {
  /**
   * Test {@link AttributeNameFilter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @DisplayName("Test visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @DisplayName("Test visitUnknownAttribute(Clazz, UnknownAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); then calls visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_thenCallsVisitUnknownAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitUnknownAttribute(Mockito.<Clazz>any(), Mockito.<UnknownAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    UnknownAttribute unknownAttribute = mock(UnknownAttribute.class);
    when(unknownAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    verify(unknownAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor).visitUnknownAttribute(isA(Clazz.class), isA(UnknownAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitUnknownAttribute(Clazz,
   * UnknownAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitUnknownAttribute(Clazz, UnknownAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    UnknownAttribute unknownAttribute = mock(UnknownAttribute.class);
    when(unknownAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitUnknownAttribute(clazz, unknownAttribute);

    // Assert
    verify(unknownAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName("Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitBootstrapMethodsAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); given CollectionMatcher(Set) with set is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_givenCollectionMatcherWithSetIsHashSet() {
    // Arrange
    CollectionMatcher regularExpressionMatcher = new CollectionMatcher(new HashSet<>());
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter(regularExpressionMatcher, new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    when(bootstrapMethodsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link BootstrapMethodsAttribute#bootstrapMethodEntriesAccept(Clazz,
   *       BootstrapMethodInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls bootstrapMethodEntriesAccept(Clazz, BootstrapMethodInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsBootstrapMethodEntriesAccept() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter(
            "", new AllBootstrapMethodInfoVisitor(mock(BootstrapMethodInfoVisitor.class)));
    LibraryClass clazz = mock(LibraryClass.class);
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    doNothing()
        .when(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(
            Mockito.<Clazz>any(), Mockito.<BootstrapMethodInfoVisitor>any());
    when(bootstrapMethodsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute).getAttributeName(isA(Clazz.class));
    verify(bootstrapMethodsAttribute)
        .bootstrapMethodEntriesAccept(isA(Clazz.class), isA(BootstrapMethodInfoVisitor.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    BootstrapMethodsAttribute bootstrapMethodsAttribute = mock(BootstrapMethodsAttribute.class);
    when(bootstrapMethodsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitBootstrapMethodsAttribute(clazz, bootstrapMethodsAttribute);

    // Assert
    verify(bootstrapMethodsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitBootstrapMethodsAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); then calls visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_thenCallsVisitSourceFileAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSourceFileAttribute(Mockito.<Clazz>any(), Mockito.<SourceFileAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    SourceFileAttribute sourceFileAttribute = mock(SourceFileAttribute.class);
    when(sourceFileAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    verify(sourceFileAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSourceFileAttribute(isA(Clazz.class), isA(SourceFileAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceFileAttribute(Clazz, SourceFileAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    SourceFileAttribute sourceFileAttribute = mock(SourceFileAttribute.class);
    when(sourceFileAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSourceFileAttribute(clazz, sourceFileAttribute);

    // Assert
    verify(sourceFileAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); then calls visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_thenCallsVisitSourceDirAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSourceDirAttribute(Mockito.<Clazz>any(), Mockito.<SourceDirAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    SourceDirAttribute sourceDirAttribute = mock(SourceDirAttribute.class);
    when(sourceDirAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    verify(sourceDirAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSourceDirAttribute(isA(Clazz.class), isA(SourceDirAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDirAttribute(Clazz,
   * SourceDirAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDirAttribute(Clazz, SourceDirAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    SourceDirAttribute sourceDirAttribute = mock(SourceDirAttribute.class);
    when(sourceDirAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSourceDirAttribute(clazz, sourceDirAttribute);

    // Assert
    verify(sourceDirAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSourceDebugExtensionAttribute(
        clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute2() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSourceDebugExtensionAttribute(
            Mockito.<Clazz>any(), Mockito.<SourceDebugExtensionAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute =
        mock(SourceDebugExtensionAttribute.class);
    when(sourceDebugExtensionAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSourceDebugExtensionAttribute(clazz, sourceDebugExtensionAttribute);

    // Assert
    verify(sourceDebugExtensionAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSourceDebugExtensionAttribute(
            isA(Clazz.class), isA(SourceDebugExtensionAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute); then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    SourceDebugExtensionAttribute sourceDebugExtensionAttribute =
        mock(SourceDebugExtensionAttribute.class);
    when(sourceDebugExtensionAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSourceDebugExtensionAttribute(clazz, sourceDebugExtensionAttribute);

    // Assert
    verify(sourceDebugExtensionAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSourceDebugExtensionAttribute(
        clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName("Test visitRecordAttribute(Clazz, RecordAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRecordAttribute(clazz, new RecordAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new AllAttributeVisitor(true, new DominatorCalculator(true)));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());
    when(recordAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(recordAttribute).getAttributeName(isA(Clazz.class));
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName("Test visitRecordAttribute(Clazz, RecordAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRecordAttribute(clazz, new RecordAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    when(recordAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(recordAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitInnerClassesAttribute(Clazz,
   *       InnerClassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); then calls visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_thenCallsVisitInnerClassesAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitInnerClassesAttribute(Mockito.<Clazz>any(), Mockito.<InnerClassesAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    when(innerClassesAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(innerClassesAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitInnerClassesAttribute(isA(Clazz.class), isA(InnerClassesAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    InnerClassesAttribute innerClassesAttribute = mock(InnerClassesAttribute.class);
    when(innerClassesAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitInnerClassesAttribute(clazz, innerClassesAttribute);

    // Assert
    verify(innerClassesAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitEnclosingMethodAttribute(Clazz,
   *       EnclosingMethodAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); then calls visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_thenCallsVisitEnclosingMethodAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitEnclosingMethodAttribute(
            Mockito.<Clazz>any(), Mockito.<EnclosingMethodAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    EnclosingMethodAttribute enclosingMethodAttribute = mock(EnclosingMethodAttribute.class);
    when(enclosingMethodAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(enclosingMethodAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitEnclosingMethodAttribute(isA(Clazz.class), isA(EnclosingMethodAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    EnclosingMethodAttribute enclosingMethodAttribute = mock(EnclosingMethodAttribute.class);
    when(enclosingMethodAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitEnclosingMethodAttribute(clazz, enclosingMethodAttribute);

    // Assert
    verify(enclosingMethodAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName("Test visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName("Test visitNestHostAttribute(Clazz, NestHostAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); then calls visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_thenCallsVisitNestHostAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitNestHostAttribute(Mockito.<Clazz>any(), Mockito.<NestHostAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    NestHostAttribute nestHostAttribute = mock(NestHostAttribute.class);
    when(nestHostAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    verify(nestHostAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor).visitNestHostAttribute(isA(Clazz.class), isA(NestHostAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestHostAttribute(Clazz,
   * NestHostAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestHostAttribute(Clazz, NestHostAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    NestHostAttribute nestHostAttribute = mock(NestHostAttribute.class);
    when(nestHostAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitNestHostAttribute(clazz, nestHostAttribute);

    // Assert
    verify(nestHostAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName("Test visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitNestMembersAttribute(clazz, new NestMembersAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitNestMembersAttribute(clazz, new NestMembersAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitNestMembersAttribute(Clazz,
   *       NestMembersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); then calls visitNestMembersAttribute(Clazz, NestMembersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_thenCallsVisitNestMembersAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitNestMembersAttribute(Mockito.<Clazz>any(), Mockito.<NestMembersAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    NestMembersAttribute nestMembersAttribute = mock(NestMembersAttribute.class);
    when(nestMembersAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    verify(nestMembersAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitNestMembersAttribute(isA(Clazz.class), isA(NestMembersAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitNestMembersAttribute(Clazz, NestMembersAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitNestMembersAttribute(Clazz,
   * NestMembersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitNestMembersAttribute(Clazz, NestMembersAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitNestMembersAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestMembersAttribute)"
  })
  void testVisitNestMembersAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    NestMembersAttribute nestMembersAttribute = mock(NestMembersAttribute.class);
    when(nestMembersAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitNestMembersAttribute(clazz, nestMembersAttribute);

    // Assert
    verify(nestMembersAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName("Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitPermittedSubclassesAttribute(
        clazz, new PermittedSubclassesAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitPermittedSubclassesAttribute(
        clazz, new PermittedSubclassesAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitPermittedSubclassesAttribute(Clazz,
   *       PermittedSubclassesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); then calls visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_thenCallsVisitPermittedSubclassesAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitPermittedSubclassesAttribute(
            Mockito.<Clazz>any(), Mockito.<PermittedSubclassesAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    PermittedSubclassesAttribute permittedSubclassesAttribute =
        mock(PermittedSubclassesAttribute.class);
    when(permittedSubclassesAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    verify(permittedSubclassesAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitPermittedSubclassesAttribute(
            isA(Clazz.class), isA(PermittedSubclassesAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitPermittedSubclassesAttribute(Clazz,
   * PermittedSubclassesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitPermittedSubclassesAttribute(Clazz, PermittedSubclassesAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitPermittedSubclassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.PermittedSubclassesAttribute)"
  })
  void testVisitPermittedSubclassesAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    PermittedSubclassesAttribute permittedSubclassesAttribute =
        mock(PermittedSubclassesAttribute.class);
    when(permittedSubclassesAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitPermittedSubclassesAttribute(clazz, permittedSubclassesAttribute);

    // Assert
    verify(permittedSubclassesAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName("Test visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName("Test visitModuleAttribute(Clazz, ModuleAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitModuleAttribute(clazz, new ModuleAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleAttribute(Clazz, ModuleAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); then calls visitModuleAttribute(Clazz, ModuleAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_thenCallsVisitModuleAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitModuleAttribute(Mockito.<Clazz>any(), Mockito.<ModuleAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleAttribute moduleAttribute = mock(ModuleAttribute.class);
    when(moduleAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    verify(moduleAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor).visitModuleAttribute(isA(Clazz.class), isA(ModuleAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleAttribute(Clazz, ModuleAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleAttribute(Clazz, ModuleAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleAttribute)"
  })
  void testVisitModuleAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleAttribute moduleAttribute = mock(ModuleAttribute.class);
    when(moduleAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitModuleAttribute(clazz, moduleAttribute);

    // Assert
    verify(moduleAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName("Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitModuleMainClassAttribute(clazz, new ModuleMainClassAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModuleMainClassAttribute(Clazz,
   *       ModuleMainClassAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); then calls visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_thenCallsVisitModuleMainClassAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitModuleMainClassAttribute(
            Mockito.<Clazz>any(), Mockito.<ModuleMainClassAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleMainClassAttribute moduleMainClassAttribute = mock(ModuleMainClassAttribute.class);
    when(moduleMainClassAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    verify(moduleMainClassAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitModuleMainClassAttribute(isA(Clazz.class), isA(ModuleMainClassAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModuleMainClassAttribute(Clazz,
   * ModuleMainClassAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModuleMainClassAttribute(Clazz, ModuleMainClassAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModuleMainClassAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModuleMainClassAttribute)"
  })
  void testVisitModuleMainClassAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleMainClassAttribute moduleMainClassAttribute = mock(ModuleMainClassAttribute.class);
    when(moduleMainClassAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitModuleMainClassAttribute(clazz, moduleMainClassAttribute);

    // Assert
    verify(moduleMainClassAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName("Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitModulePackagesAttribute(clazz, new ModulePackagesAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitModulePackagesAttribute(Clazz,
   *       ModulePackagesAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); then calls visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_thenCallsVisitModulePackagesAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitModulePackagesAttribute(Mockito.<Clazz>any(), Mockito.<ModulePackagesAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    ModulePackagesAttribute modulePackagesAttribute = mock(ModulePackagesAttribute.class);
    when(modulePackagesAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    verify(modulePackagesAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitModulePackagesAttribute(isA(Clazz.class), isA(ModulePackagesAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz, ModulePackagesAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitModulePackagesAttribute(Clazz,
   * ModulePackagesAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitModulePackagesAttribute(Clazz, ModulePackagesAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitModulePackagesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.module.ModulePackagesAttribute)"
  })
  void testVisitModulePackagesAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    ModulePackagesAttribute modulePackagesAttribute = mock(ModulePackagesAttribute.class);
    when(modulePackagesAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitModulePackagesAttribute(clazz, modulePackagesAttribute);

    // Assert
    verify(modulePackagesAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute3() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitDeprecatedAttribute(Mockito.<Clazz>any(), Mockito.<DeprecatedAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitDeprecatedAttribute(isA(Clazz.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with
   * {@code clazz}, {@code deprecatedAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, (Field) field, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute3() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<DeprecatedAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, (Field) field, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Field.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute)}
   * with {@code clazz}, {@code field}, {@code deprecatedAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Field,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Field, DeprecatedAttribute) with 'clazz', 'field', 'deprecatedAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzFieldDeprecatedAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, (Field) field, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(
        clazz, (Method) method, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(
        clazz, (Method) method, new DeprecatedAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute)}
   * with {@code clazz}, {@code method}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitDeprecatedAttribute(Clazz, Method,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, Method, DeprecatedAttribute) with 'clazz', 'method', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzMethodDeprecatedAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitDeprecatedAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<DeprecatedAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DeprecatedAttribute deprecatedAttribute = mock(DeprecatedAttribute.class);
    when(deprecatedAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitDeprecatedAttribute(clazz, (Method) method, deprecatedAttribute);

    // Assert
    verify(deprecatedAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitDeprecatedAttribute(
            isA(Clazz.class), isA(Method.class), isA(DeprecatedAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)} with
   * {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Field) field, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)} with
   * {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)} with
   * {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SyntheticAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Field) field, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(Field.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field, SyntheticAttribute)} with
   * {@code clazz}, {@code field}, {@code syntheticAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Field,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Field, SyntheticAttribute) with 'clazz', 'field', 'syntheticAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzFieldSyntheticAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Field) field, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Method) method, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute3() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSyntheticAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SyntheticAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Method) method, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSyntheticAttribute(
            isA(Clazz.class), isA(Method.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method, SyntheticAttribute)}
   * with {@code clazz}, {@code method}, {@code syntheticAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, Method,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, Method, SyntheticAttribute) with 'clazz', 'method', 'syntheticAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzMethodSyntheticAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, (Method) method, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute2() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSyntheticAttribute(Mockito.<Clazz>any(), Mockito.<SyntheticAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSyntheticAttribute(isA(Clazz.class), isA(SyntheticAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    SyntheticAttribute syntheticAttribute = mock(SyntheticAttribute.class);
    when(syntheticAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, syntheticAttribute);

    // Assert
    verify(syntheticAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSyntheticAttribute(Clazz,
   * SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field, SignatureAttribute)} with
   * {@code clazz}, {@code field}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSignatureAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, (Field) field, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field, SignatureAttribute)} with
   * {@code clazz}, {@code field}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSignatureAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, (Field) field, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field, SignatureAttribute)} with
   * {@code clazz}, {@code field}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSignatureAttribute3() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<SignatureAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, (Field) field, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(Field.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field, SignatureAttribute)} with
   * {@code clazz}, {@code field}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Field,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Field, SignatureAttribute) with 'clazz', 'field', 'signatureAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzFieldSignatureAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, (Field) field, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSignatureAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSignatureAttribute(
        clazz, (Method) method, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSignatureAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, (Method) method, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSignatureAttribute3() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<SignatureAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, (Method) method, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(Method.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method, SignatureAttribute)}
   * with {@code clazz}, {@code method}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz, Method,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, Method, SignatureAttribute) with 'clazz', 'method', 'signatureAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzMethodSignatureAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitSignatureAttribute(
        clazz, (Method) method, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitSignatureAttribute(
        clazz, recordComponentInfo, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitSignatureAttribute(
        clazz, recordComponentInfo, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, RecordComponentInfo,
   * SignatureAttribute)} with {@code clazz}, {@code recordComponentInfo}, {@code
   * signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * RecordComponentInfo, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, RecordComponentInfo, SignatureAttribute) with 'clazz', 'recordComponentInfo', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzRecordComponentInfoSignatureAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<SignatureAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, recordComponentInfo, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSignatureAttribute(
            isA(Clazz.class), isA(RecordComponentInfo.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitSignatureAttribute(Mockito.<Clazz>any(), Mockito.<SignatureAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitSignatureAttribute(isA(Clazz.class), isA(SignatureAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    SignatureAttribute signatureAttribute = mock(SignatureAttribute.class);
    when(signatureAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, signatureAttribute);

    // Assert
    verify(signatureAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitSignatureAttribute(Clazz,
   * SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName("Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitConstantValueAttribute(Clazz, Field,
   *       ConstantValueAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); then calls visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_thenCallsVisitConstantValueAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitConstantValueAttribute(
            Mockito.<Clazz>any(), Mockito.<Field>any(), Mockito.<ConstantValueAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    ConstantValueAttribute constantValueAttribute = mock(ConstantValueAttribute.class);
    when(constantValueAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitConstantValueAttribute(clazz, field, constantValueAttribute);

    // Assert
    verify(constantValueAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitConstantValueAttribute(
            isA(Clazz.class), isA(Field.class), isA(ConstantValueAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    ConstantValueAttribute constantValueAttribute = mock(ConstantValueAttribute.class);
    when(constantValueAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitConstantValueAttribute(clazz, field, constantValueAttribute);

    // Assert
    verify(constantValueAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName("Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitMethodParametersAttribute(
        clazz, method, new MethodParametersAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitMethodParametersAttribute(
        clazz, method, new MethodParametersAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitMethodParametersAttribute(Clazz, Method,
   *       MethodParametersAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then calls visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenCallsVisitMethodParametersAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitMethodParametersAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<MethodParametersAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute exceptionsAttribute = mock(MethodParametersAttribute.class);
    when(exceptionsAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitMethodParametersAttribute(clazz, method, exceptionsAttribute);

    // Assert
    verify(exceptionsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitMethodParametersAttribute(
            isA(Clazz.class), isA(Method.class), isA(MethodParametersAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute exceptionsAttribute = mock(MethodParametersAttribute.class);
    when(exceptionsAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitMethodParametersAttribute(clazz, method, exceptionsAttribute);

    // Assert
    verify(exceptionsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName("Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitExceptionsAttribute(clazz, method, new ExceptionsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitExceptionsAttribute(Clazz, Method,
   *       ExceptionsAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); then calls visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_thenCallsVisitExceptionsAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitExceptionsAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ExceptionsAttribute exceptionsAttribute = mock(ExceptionsAttribute.class);
    when(exceptionsAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    verify(exceptionsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitExceptionsAttribute(
            isA(Clazz.class), isA(Method.class), isA(ExceptionsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitExceptionsAttribute(Clazz, Method,
   * ExceptionsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionsAttribute(Clazz, Method, ExceptionsAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitExceptionsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.ExceptionsAttribute)"
  })
  void testVisitExceptionsAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    ExceptionsAttribute exceptionsAttribute = mock(ExceptionsAttribute.class);
    when(exceptionsAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitExceptionsAttribute(clazz, method, exceptionsAttribute);

    // Assert
    verify(exceptionsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", new AttributeCounter());
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsGetString2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName("Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitStackMapAttribute(
        clazz, method, codeAttribute, new StackMapAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   *       StackMapAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); then calls visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_thenCallsVisitStackMapAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitStackMapAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapAttribute stackMapAttribute = mock(StackMapAttribute.class);
    when(stackMapAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitStackMapAttribute(clazz, method, codeAttribute, stackMapAttribute);

    // Assert
    verify(stackMapAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitStackMapAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method, CodeAttribute,
   * StackMapAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapAttribute(Clazz, Method,
   * CodeAttribute, StackMapAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapAttribute(Clazz, Method, CodeAttribute, StackMapAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapAttribute)"
  })
  void testVisitStackMapAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapAttribute stackMapAttribute = mock(StackMapAttribute.class);
    when(stackMapAttribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitStackMapAttribute(clazz, method, codeAttribute, stackMapAttribute);

    // Assert
    verify(stackMapAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitStackMapTableAttribute(
        clazz, method, codeAttribute, new StackMapTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitStackMapTableAttribute(Clazz, Method,
   *       CodeAttribute, StackMapTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); then calls visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_thenCallsVisitStackMapTableAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitStackMapTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<StackMapTableAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapTableAttribute stackMapTableAttribute = mock(StackMapTableAttribute.class);
    when(stackMapTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitStackMapTableAttribute(
        clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    verify(stackMapTableAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitStackMapTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(StackMapTableAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method, CodeAttribute,
   * StackMapTableAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitStackMapTableAttribute(Clazz, Method,
   * CodeAttribute, StackMapTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitStackMapTableAttribute(Clazz, Method, CodeAttribute, StackMapTableAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitStackMapTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.preverification.StackMapTableAttribute)"
  })
  void testVisitStackMapTableAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    StackMapTableAttribute stackMapTableAttribute = mock(StackMapTableAttribute.class);
    when(stackMapTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitStackMapTableAttribute(
        clazz, method, codeAttribute, stackMapTableAttribute);

    // Assert
    verify(stackMapTableAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitLineNumberTableAttribute(Clazz, Method,
   *       CodeAttribute, LineNumberTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then calls visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenCallsVisitLineNumberTableAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitLineNumberTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LineNumberTableAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = mock(LineNumberTableAttribute.class);
    when(lineNumberTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    verify(lineNumberTableAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitLineNumberTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LineNumberTableAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = mock(LineNumberTableAttribute.class);
    when(lineNumberTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    verify(lineNumberTableAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitLocalVariableTableAttribute(Clazz, Method,
   *       CodeAttribute, LocalVariableTableAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then calls visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenCallsVisitLocalVariableTableAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitLocalVariableTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTableAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute =
        mock(LocalVariableTableAttribute.class);
    when(localVariableTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    verify(localVariableTableAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitLocalVariableTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTableAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute =
        mock(LocalVariableTableAttribute.class);
    when(localVariableTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    verify(localVariableTableAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTypeTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute2() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeTableAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        mock(LocalVariableTypeTableAttribute.class);
    when(localVariableTypeTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    verify(localVariableTypeTableAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeTableAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        mock(LocalVariableTypeTableAttribute.class);
    when(localVariableTypeTableAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    verify(localVariableTypeTableAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, new LocalVariableTypeTableAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Field, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Field, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Field, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Field, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * Method, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeVisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeVisibleAnnotationsAttribute runtimeVisibleAnnotationsAttribute =
        mock(RuntimeVisibleAnnotationsAttribute.class);
    when(runtimeVisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleAnnotationsAttribute(
        clazz, runtimeVisibleAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeVisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeInvisibleAnnotationsAttribute runtimeInvisibleAnnotationsAttribute =
        mock(RuntimeInvisibleAnnotationsAttribute.class);
    when(runtimeInvisibleAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, runtimeInvisibleAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeVisibleParameterAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute2() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleParameterAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        mock(RuntimeVisibleParameterAnnotationsAttribute.class);
    when(runtimeVisibleParameterAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleParameterAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeVisibleParameterAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute); then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute =
        mock(RuntimeVisibleParameterAnnotationsAttribute.class);
    when(runtimeVisibleParameterAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, runtimeVisibleParameterAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleParameterAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeVisibleParameterAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute2() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleParameterAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        mock(RuntimeInvisibleParameterAnnotationsAttribute.class);
    when(runtimeInvisibleParameterAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleParameterAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleParameterAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleParameterAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute); then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleParameterAnnotationsAttribute runtimeInvisibleParameterAnnotationsAttribute =
        mock(RuntimeInvisibleParameterAnnotationsAttribute.class);
    when(runtimeInvisibleParameterAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, runtimeInvisibleParameterAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleParameterAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz,
   * Method, RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Field) field, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(Field.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, (Method) method, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(Method.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeVisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, new RuntimeVisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzRuntimeVisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeVisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    when(runtimeVisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeVisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeVisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Field) field, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Field) field, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Field.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Method) method, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, (Method) method, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * recordComponentInfo}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RecordComponentInfo, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'recordComponentInfo', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRecordComponentInfoRuntimeInvisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(),
            Mockito.<RecordComponentInfo>any(),
            Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, recordComponentInfo, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class),
            isA(RecordComponentInfo.class),
            isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute2() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, new RuntimeInvisibleTypeAnnotationsAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute3() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AttributeNameFilter#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzRuntimeInvisibleTypeAnnotationsAttribute4() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            Mockito.<Clazz>any(), Mockito.<RuntimeInvisibleTypeAnnotationsAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    when(runtimeInvisibleTypeAnnotationsAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitRuntimeInvisibleTypeAnnotationsAttribute(
            isA(Clazz.class), isA(RuntimeInvisibleTypeAnnotationsAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitAnnotationDefaultAttribute(
        clazz, method, new AnnotationDefaultAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsGetString() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeNameFilter.visitAnnotationDefaultAttribute(
        clazz, method, new AnnotationDefaultAttribute());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link AttributeVisitor#visitAnnotationDefaultAttribute(Clazz, Method,
   *       AnnotationDefaultAttribute)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); then calls visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_thenCallsVisitAnnotationDefaultAttribute() {
    // Arrange
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitAnnotationDefaultAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationDefaultAttribute>any());
    AttributeNameFilter attributeNameFilter = new AttributeNameFilter("", attributeVisitor);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute).getAttributeName(isA(Clazz.class));
    verify(attributeVisitor)
        .visitAnnotationDefaultAttribute(
            isA(Clazz.class), isA(Method.class), isA(AnnotationDefaultAttribute.class));
  }

  /**
   * Test {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link Attribute#getAttributeName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeNameFilter#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute); when LibraryClass; then calls getAttributeName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeNameFilter.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute_whenLibraryClass_thenCallsGetAttributeName() {
    // Arrange
    AttributeNameFilter attributeNameFilter =
        new AttributeNameFilter("Regular Expression", new DominatorCalculator(true));
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getAttributeName(Mockito.<Clazz>any()))
        .thenReturn("Attribute Name");

    // Act
    attributeNameFilter.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute).getAttributeName(isA(Clazz.class));
  }
}
