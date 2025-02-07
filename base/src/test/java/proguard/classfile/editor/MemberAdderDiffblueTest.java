package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.testutils.cpa.NamedField;
import proguard.testutils.cpa.NamedMember;
import proguard.util.StringFunction;

class MemberAdderDiffblueTest {
  /**
   * Test {@link MemberAdder#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    ProgramClass targetClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    MemberAdder memberAdder = new MemberAdder(targetClass, nameTransformer, new AttributeSorter());
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramField(programClass, new NamedField("Field Name", "Field Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Field Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField2() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    MemberAdder memberAdder =
        new MemberAdder(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1),
            nameTransformer,
            null);
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramField(programClass, new NamedField("Field Name", "Field Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Field Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField3() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    ProgramClass targetClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    MemberAdder memberAdder =
        new MemberAdder(targetClass, nameTransformer, new ConstantPoolShrinker());
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramField(programClass, new NamedField("Field Name", "Field Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Field Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    ProgramClass targetClass =
        new ProgramClass(-17, 1, new Constant[] {new ClassConstant()}, -17, -17, -17);

    MemberAdder memberAdder = new MemberAdder(targetClass, nameTransformer, new AttributeSorter());
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramMethod(programClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Member Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod2() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    MemberAdder memberAdder =
        new MemberAdder(
            new ProgramClass(-17, 1, new Constant[] {new ClassConstant()}, -17, -17, -17),
            nameTransformer,
            null);
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramMethod(programClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Member Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod3() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    ProgramClass targetClass =
        new ProgramClass(-17, 1, new Constant[] {new ClassConstant()}, -17, -17, -17);

    MemberAdder memberAdder =
        new MemberAdder(targetClass, nameTransformer, new BootstrapMethodsAttributeShrinker());
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramMethod(programClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Member Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod4() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    ProgramClass targetClass =
        new ProgramClass(-17, 1, new Constant[] {new ClassConstant()}, -17, -17, -17);

    MemberAdder memberAdder =
        new MemberAdder(targetClass, nameTransformer, new BridgeMethodFixer());
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramMethod(programClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Member Name"));
  }

  /**
   * Test {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberAdder#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.MemberAdder.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod5() {
    // Arrange
    StringFunction nameTransformer = mock(StringFunction.class);
    when(nameTransformer.transform(Mockito.<String>any())).thenReturn("Transform");
    ProgramClass targetClass =
        new ProgramClass(-17, 1, new Constant[] {new ClassConstant()}, -17, -17, -17);

    MemberAdder memberAdder =
        new MemberAdder(targetClass, nameTransformer, new ConstantPoolShrinker());
    ProgramClass programClass = new ProgramClass();

    // Act
    memberAdder.visitProgramMethod(programClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    verify(nameTransformer).transform(eq("Member Name"));
  }
}
