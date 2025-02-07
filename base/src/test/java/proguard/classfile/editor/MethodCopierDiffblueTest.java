package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberInfo;
import proguard.classfile.attribute.LineNumberTableAttribute;
import proguard.classfile.visitor.MemberVisitor;

class MethodCopierDiffblueTest {
  /**
   * Test {@link MethodCopier#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#findMethod(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCopier#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then calls findMethod(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MethodCopier.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsFindMethod() {
    // Arrange
    ProgramMethod sourceMethod = mock(ProgramMethod.class);
    when(sourceMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(sourceMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    MethodCopier methodCopier = new MethodCopier(mock(ProgramClass.class), sourceMethod);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1, "Name", "Descriptor"));

    // Act
    methodCopier.visitProgramClass(programClass);

    // Assert
    verify(programClass).findMethod(eq("Name"), eq("Descriptor"));
    verify(sourceMethod).getDescriptor(isA(Clazz.class));
    verify(sourceMethod).getName(isA(Clazz.class));
  }

  /**
   * Test {@link MethodCopier#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link MethodCopier#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MethodCopier.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() {
    // Arrange
    ProgramClass sourceClass = new ProgramClass();
    MethodCopier methodCopier = new MethodCopier(sourceClass, new ProgramMethod());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getAttribute(Mockito.<Clazz>any(), Mockito.<String>any()))
        .thenReturn(
            new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)}));

    // Act
    methodCopier.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute).getAttribute(isA(Clazz.class), eq("LineNumberTable"));
  }

  /**
   * Test {@link MethodCopier#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCopier#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); given LineNumberTableAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MethodCopier.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_givenLineNumberTableAttribute() {
    // Arrange
    ProgramClass sourceClass = new ProgramClass();
    MethodCopier methodCopier = new MethodCopier(sourceClass, new ProgramMethod());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getAttribute(Mockito.<Clazz>any(), Mockito.<String>any()))
        .thenReturn(new LineNumberTableAttribute());

    // Act
    methodCopier.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute).getAttribute(isA(Clazz.class), eq("LineNumberTable"));
  }

  /**
   * Test {@link MethodCopier#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#addSubClass(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCopier#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls addSubClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MethodCopier.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAddSubClass() {
    // Arrange
    ProgramClass sourceClass = mock(ProgramClass.class);
    doNothing().when(sourceClass).addSubClass(Mockito.<Clazz>any());
    sourceClass.addSubClass(new LibraryClass());
    ProgramMethod sourceMethod = mock(ProgramMethod.class);
    doNothing()
        .when(sourceMethod)
        .accept(Mockito.<ProgramClass>any(), Mockito.<MemberVisitor>any());
    doNothing().when(sourceMethod).addProcessingFlags((int[]) Mockito.any());
    sourceMethod.addProcessingFlags(2, 1, 2, 1);
    MethodCopier methodCopier = new MethodCopier(sourceClass, sourceMethod);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    when(codeAttribute.getAttribute(Mockito.<Clazz>any(), Mockito.<String>any()))
        .thenReturn(
            new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)}));

    // Act
    methodCopier.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(sourceClass).addSubClass(isA(Clazz.class));
    verify(sourceMethod).accept(isA(ProgramClass.class), isA(MemberVisitor.class));
    verify(codeAttribute).getAttribute(isA(Clazz.class), eq("LineNumberTable"));
    verify(sourceMethod).addProcessingFlags((int[]) Mockito.any());
  }
}
