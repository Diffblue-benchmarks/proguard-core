package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.BootstrapMethodsAttributeShrinker;
import proguard.classfile.editor.BridgeMethodFixer;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.util.MethodLinker;

class ConstructorMethodFilterDiffblueTest {
  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(new AttributeSorter(), null);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod2() {
    // Arrange
    AttributeSorter constructorVisitor = new AttributeSorter();
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(constructorVisitor, new BootstrapMethodsAttributeShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod3() {
    // Arrange
    AttributeSorter constructorVisitor = new AttributeSorter();
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(constructorVisitor, new BridgeMethodFixer());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod4() {
    // Arrange
    AttributeSorter constructorVisitor = new AttributeSorter();
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(constructorVisitor, new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(
        programClass, new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(programClass).getString(eq(1));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod5() {
    // Arrange
    AttributeSorter constructorVisitor = new AttributeSorter();
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(constructorVisitor, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod6() {
    // Arrange
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(
            null,
            new MethodImplementationTraveler(true, true, true, true, new BridgeMethodFixer()));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(
        programClass,
        new ProgramMethod(
            1, 1, 1, 3, new Attribute[] {mock(Attribute.class)}, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(programClass, atLeast(1)).getString(eq(1));
    verify(programClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod7() {
    // Arrange
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(
            null, new MethodImplementationTraveler(true, true, true, true, new MethodLinker()));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    constructorMethodFilter.visitProgramMethod(
        programClass,
        new ProgramMethod(
            1, 1, 1, 3, new Attribute[] {mock(Attribute.class)}, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(programClass, atLeast(1)).getString(eq(1));
    verify(programClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
  }

  /**
   * Test {@link ConstructorMethodFilter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#instructionsAccept(Clazz, Method, InstructionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstructorMethodFilter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls instructionsAccept(Clazz, Method, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstructorMethodFilter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsInstructionsAccept() {
    // Arrange
    AttributeSorter constructorVisitor = new AttributeSorter();
    ConstructorMethodFilter constructorMethodFilter =
        new ConstructorMethodFilter(constructorVisitor, new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    constructorMethodFilter.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }
}
