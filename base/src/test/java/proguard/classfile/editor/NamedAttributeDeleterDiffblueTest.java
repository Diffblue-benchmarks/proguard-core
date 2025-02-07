package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.CodeAttribute;

class NamedAttributeDeleterDiffblueTest {
  /**
   * Test {@link NamedAttributeDeleter#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedAttributeDeleter#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); when ProgramClass; then first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NamedAttributeDeleter.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_whenProgramClass_thenFirstElementIsNull() {
    // Arrange
    NamedAttributeDeleter namedAttributeDeleter = new NamedAttributeDeleter("Attribute Name");
    ProgramClass programClass = mock(ProgramClass.class);
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");
    ProgramField programMember =
        new ProgramField(-1, 1, 1, 1, new Attribute[] {attribute}, new LibraryClass());

    // Act
    namedAttributeDeleter.visitProgramMember(programClass, programMember);

    // Assert
    verify(attribute).getAttributeName(isA(Clazz.class));
    Attribute[] attributeArray = programMember.attributes;
    assertNull(attributeArray[0]);
    assertEquals(0, programMember.u2attributesCount);
    assertEquals(1, attributeArray.length);
  }

  /**
   * Test {@link NamedAttributeDeleter#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>When {@link ProgramField#ProgramField()}.
   *   <li>Then {@link ProgramField#ProgramField()} {@link ProgramMember#u2attributesCount} is zero.
   * </ul>
   *
   * <p>Method under test: {@link NamedAttributeDeleter#visitProgramMember(ProgramClass,
   * ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); when ProgramField(); then ProgramField() u2attributesCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NamedAttributeDeleter.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_whenProgramField_thenProgramFieldU2attributesCountIsZero() {
    // Arrange
    NamedAttributeDeleter namedAttributeDeleter = new NamedAttributeDeleter("Attribute Name");
    ProgramClass programClass = new ProgramClass();
    ProgramField programMember = new ProgramField();

    // Act
    namedAttributeDeleter.visitProgramMember(programClass, programMember);

    // Assert that nothing has changed
    assertEquals(0, programMember.u2attributesCount);
  }

  /**
   * Test {@link NamedAttributeDeleter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link NamedAttributeDeleter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.NamedAttributeDeleter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() {
    // Arrange
    NamedAttributeDeleter namedAttributeDeleter = new NamedAttributeDeleter("Attribute Name");
    ProgramClass clazz = mock(ProgramClass.class);
    doNothing().when(clazz).addExtraFeatureName(Mockito.<String>any());
    clazz.addExtraFeatureName("Feature Name");
    ProgramMethod method = new ProgramMethod();

    // Act
    namedAttributeDeleter.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    verify(clazz).addExtraFeatureName(eq("Feature Name"));
  }
}
