package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.ConstantValueAttribute;
import proguard.classfile.attribute.DeprecatedAttribute;
import proguard.classfile.attribute.EnclosingMethodAttribute;
import proguard.classfile.attribute.InnerClassesAttribute;
import proguard.classfile.attribute.NestHostAttribute;
import proguard.classfile.attribute.SignatureAttribute;
import proguard.classfile.attribute.SourceDebugExtensionAttribute;
import proguard.classfile.attribute.SourceDirAttribute;
import proguard.classfile.attribute.SourceFileAttribute;
import proguard.classfile.attribute.SyntheticAttribute;
import proguard.classfile.attribute.UnknownAttribute;
import proguard.classfile.attribute.annotation.AnnotationDefaultAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;

class AttributeAdderDiffblueTest {
  /**
   * Test {@link AttributeAdder#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @DisplayName("Test visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @DisplayName("Test visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitUnknownAttribute(Clazz, UnknownAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitUnknownAttribute(Clazz, UnknownAttribute)}
   */
  @Test
  @DisplayName("Test visitUnknownAttribute(Clazz, UnknownAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitUnknownAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.UnknownAttribute)"
  })
  void testVisitUnknownAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitUnknownAttribute(clazz, new UnknownAttribute(1, 3));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceFileAttribute(Clazz, SourceFileAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceFileAttribute(Clazz,
   * SourceFileAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceFileAttribute(Clazz, SourceFileAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceFileAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceFileAttribute)"
  })
  void testVisitSourceFileAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceFileAttribute(clazz, new SourceFileAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceDirAttribute(Clazz, SourceDirAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceDirAttribute(Clazz, SourceDirAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDirAttribute(Clazz, SourceDirAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceDirAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDirAttribute)"
  })
  void testVisitSourceDirAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceDirAttribute(clazz, new SourceDirAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceDebugExtensionAttribute(clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceDebugExtensionAttribute(clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSourceDebugExtensionAttribute(Clazz,
   * SourceDebugExtensionAttribute)}
   */
  @Test
  @DisplayName("Test visitSourceDebugExtensionAttribute(Clazz, SourceDebugExtensionAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSourceDebugExtensionAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SourceDebugExtensionAttribute)"
  })
  void testVisitSourceDebugExtensionAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSourceDebugExtensionAttribute(clazz, new SourceDebugExtensionAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitInnerClassesAttribute(Clazz, InnerClassesAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitInnerClassesAttribute(Clazz,
   * InnerClassesAttribute)}
   */
  @Test
  @DisplayName("Test visitInnerClassesAttribute(Clazz, InnerClassesAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitInnerClassesAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.InnerClassesAttribute)"
  })
  void testVisitInnerClassesAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitInnerClassesAttribute(clazz, new InnerClassesAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitEnclosingMethodAttribute(Clazz,
   * EnclosingMethodAttribute)}
   */
  @Test
  @DisplayName("Test visitEnclosingMethodAttribute(Clazz, EnclosingMethodAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitEnclosingMethodAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.EnclosingMethodAttribute)"
  })
  void testVisitEnclosingMethodAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitEnclosingMethodAttribute(clazz, new EnclosingMethodAttribute(1, 1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName("Test visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName("Test visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitNestHostAttribute(Clazz, NestHostAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitNestHostAttribute(Clazz, NestHostAttribute)}
   */
  @Test
  @DisplayName("Test visitNestHostAttribute(Clazz, NestHostAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitNestHostAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.NestHostAttribute)"
  })
  void testVisitNestHostAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitNestHostAttribute(clazz, new NestHostAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with {@code
   * clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with {@code
   * clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitDeprecatedAttribute(Clazz, DeprecatedAttribute)} with {@code
   * clazz}, {@code deprecatedAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitDeprecatedAttribute(Clazz,
   * DeprecatedAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitDeprecatedAttribute(Clazz, DeprecatedAttribute) with 'clazz', 'deprecatedAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitDeprecatedAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.DeprecatedAttribute)"
  })
  void testVisitDeprecatedAttributeWithClazzDeprecatedAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitDeprecatedAttribute(clazz, new DeprecatedAttribute(1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSyntheticAttribute(Clazz, SyntheticAttribute)} with {@code
   * clazz}, {@code syntheticAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSyntheticAttribute(Clazz, SyntheticAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticAttribute(Clazz, SyntheticAttribute) with 'clazz', 'syntheticAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSyntheticAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SyntheticAttribute)"
  })
  void testVisitSyntheticAttributeWithClazzSyntheticAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSyntheticAttribute(clazz, new SyntheticAttribute(1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitSignatureAttribute(Clazz, SignatureAttribute)} with {@code
   * clazz}, {@code signatureAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitSignatureAttribute(Clazz, SignatureAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitSignatureAttribute(Clazz, SignatureAttribute) with 'clazz', 'signatureAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitSignatureAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.SignatureAttribute)"
  })
  void testVisitSignatureAttributeWithClazzSignatureAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitSignatureAttribute(clazz, new SignatureAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName("Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName("Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitConstantValueAttribute(Clazz, Field,
   * ConstantValueAttribute)}
   */
  @Test
  @DisplayName("Test visitConstantValueAttribute(Clazz, Field, ConstantValueAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitConstantValueAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.ConstantValueAttribute)"
  })
  void testVisitConstantValueAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitConstantValueAttribute(clazz, field, new ConstantValueAttribute(1, 1));

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitRuntimeVisibleAnnotationsAttribute(
        clazz, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitRuntimeVisibleAnnotationsAttribute(
        clazz, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitRuntimeVisibleAnnotationsAttribute(Clazz,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleAnnotationsAttributeWithClazzRuntimeVisibleAnnotationsAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitRuntimeVisibleAnnotationsAttribute(
        clazz, new RuntimeVisibleAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link AttributeAdder#visitRuntimeInvisibleAnnotationsAttribute(Clazz,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzRuntimeInvisibleAnnotationsAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();

    // Act
    attributeAdder.visitRuntimeInvisibleAnnotationsAttribute(
        clazz, new RuntimeInvisibleAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeAdder#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeVisibleParameterAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeAdder#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeVisibleParameterAnnotationsAttribute());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeAdder#visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeVisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeVisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeVisibleParameterAnnotationsAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitRuntimeVisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeVisibleParameterAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeAdder#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeAdder#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}.
   *
   * <p>Method under test: {@link
   * AttributeAdder#visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleParameterAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleParameterAnnotationsAttribute(Clazz, Method, RuntimeInvisibleParameterAnnotationsAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitRuntimeInvisibleParameterAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleParameterAnnotationsAttribute)"
  })
  void testVisitRuntimeInvisibleParameterAnnotationsAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    attributeAdder.visitRuntimeInvisibleParameterAnnotationsAttribute(
        clazz, method, new RuntimeInvisibleParameterAnnotationsAttribute());

    // Assert
    verify(targetClass).getString(eq(0));
  }

  /**
   * Test {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getProcessingFlags()).thenReturn(1);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    attributeAdder.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(targetClass).getString(eq(0));
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotationDefaultAttribute).getProcessingFlags();
  }

  /**
   * Test {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getProcessingFlags()).thenReturn(1);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    attributeAdder.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotationDefaultAttribute).getProcessingFlags();
  }

  /**
   * Test {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    AttributeAdder attributeAdder =
        new AttributeAdder(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), false);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getProcessingFlags()).thenReturn(1);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    attributeAdder.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotationDefaultAttribute).getProcessingFlags();
  }

  /**
   * Test {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}.
   *
   * <p>Method under test: {@link AttributeAdder#visitAnnotationDefaultAttribute(Clazz, Method,
   * AnnotationDefaultAttribute)}
   */
  @Test
  @DisplayName("Test visitAnnotationDefaultAttribute(Clazz, Method, AnnotationDefaultAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributeAdder.visitAnnotationDefaultAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.AnnotationDefaultAttribute)"
  })
  void testVisitAnnotationDefaultAttribute4() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    AttributeAdder attributeAdder =
        new AttributeAdder(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationDefaultAttribute annotationDefaultAttribute = mock(AnnotationDefaultAttribute.class);
    when(annotationDefaultAttribute.getProcessingFlags()).thenReturn(1);
    doNothing()
        .when(annotationDefaultAttribute)
        .defaultValueAccept(Mockito.<Clazz>any(), Mockito.<ElementValueVisitor>any());

    // Act
    attributeAdder.visitAnnotationDefaultAttribute(clazz, method, annotationDefaultAttribute);

    // Assert
    verify(targetClass).getString(eq(0));
    verify(annotationDefaultAttribute)
        .defaultValueAccept(isA(Clazz.class), isA(ElementValueVisitor.class));
    verify(annotationDefaultAttribute).getProcessingFlags();
  }
}
