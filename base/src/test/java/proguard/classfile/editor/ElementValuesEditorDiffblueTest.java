package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;

class ElementValuesEditorDiffblueTest {
  /**
   * Test {@link ElementValuesEditor#addElementValue(ElementValue)} with {@code elementValue}.
   *
   * <p>Method under test: {@link ElementValuesEditor#addElementValue(ElementValue)}
   */
  @Test
  @DisplayName("Test addElementValue(ElementValue) with 'elementValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValuesEditor.addElementValue(proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testAddElementValueWithElementValue() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValuesEditor elementValuesEditor =
        new ElementValuesEditor(
            targetClass,
            new Annotation(1, 1, new ElementValue[] {new AnnotationElementValue()}),
            true);
    ElementValue elementValue = mock(ElementValue.class);
    when(elementValue.getMethodName(Mockito.<Clazz>any())).thenReturn("Method Name");

    // Act
    elementValuesEditor.addElementValue(elementValue);

    // Assert
    verify(targetClass).getString(eq(0));
    verify(elementValue).getMethodName(isA(Clazz.class));
  }

  /**
   * Test {@link ElementValuesEditor#addElementValue(ElementValue)} with {@code elementValue}.
   *
   * <p>Method under test: {@link ElementValuesEditor#addElementValue(ElementValue)}
   */
  @Test
  @DisplayName("Test addElementValue(ElementValue) with 'elementValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValuesEditor.addElementValue(proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testAddElementValueWithElementValue2() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    ElementValuesEditor elementValuesEditor =
        new ElementValuesEditor(
            targetClass,
            new Annotation(1, 0, new ElementValue[] {new AnnotationElementValue()}),
            true);
    ElementValue elementValue = mock(ElementValue.class);
    when(elementValue.getMethodName(Mockito.<Clazz>any())).thenReturn("Method Name");

    // Act
    elementValuesEditor.addElementValue(elementValue);

    // Assert
    verify(elementValue).getMethodName(isA(Clazz.class));
  }

  /**
   * Test {@link ElementValuesEditor#addElementValue(ElementValue)} with {@code elementValue}.
   *
   * <p>Method under test: {@link ElementValuesEditor#addElementValue(ElementValue)}
   */
  @Test
  @DisplayName("Test addElementValue(ElementValue) with 'elementValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValuesEditor.addElementValue(proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testAddElementValueWithElementValue3() {
    // Arrange
    ElementValue elementValue = mock(ElementValue.class);
    when(elementValue.getMethodName(Mockito.<Clazz>any())).thenReturn("Method Name");
    ElementValuesEditor elementValuesEditor =
        new ElementValuesEditor(
            mock(ProgramClass.class),
            new Annotation(1, 3, new ElementValue[] {elementValue}),
            true);
    ElementValue elementValue2 = mock(ElementValue.class);
    when(elementValue2.getMethodName(Mockito.<Clazz>any())).thenReturn("Method Name");

    // Act
    elementValuesEditor.addElementValue(elementValue2);

    // Assert
    verify(elementValue).getMethodName(isA(Clazz.class));
    verify(elementValue2).getMethodName(isA(Clazz.class));
  }

  /**
   * Test {@link ElementValuesEditor#addElementValue(ElementValue)} with {@code elementValue}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValuesEditor#addElementValue(ElementValue)}
   */
  @Test
  @DisplayName("Test addElementValue(ElementValue) with 'elementValue'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValuesEditor.addElementValue(proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testAddElementValueWithElementValue_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("String");
    ElementValuesEditor elementValuesEditor =
        new ElementValuesEditor(
            targetClass,
            new Annotation(1, 3, new ElementValue[] {new AnnotationElementValue()}),
            true);

    // Act
    elementValuesEditor.addElementValue(new AnnotationElementValue());

    // Assert
    verify(targetClass, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link ElementValuesEditor#deleteElementValue(String)} with {@code
   * elementValueMethodName}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValuesEditor#deleteElementValue(String)}
   */
  @Test
  @DisplayName(
      "Test deleteElementValue(String) with 'elementValueMethodName'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ElementValuesEditor.deleteElementValue(java.lang.String)"
  })
  void testDeleteElementValueWithElementValueMethodName_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("42");
    AnnotationElementValue annotationElementValue = new AnnotationElementValue();
    AnnotationElementValue annotationElementValue2 = new AnnotationElementValue();

    // Act
    (new ElementValuesEditor(
            targetClass,
            new Annotation(
                1,
                3,
                new ElementValue[] {
                  annotationElementValue, annotationElementValue2, new AnnotationElementValue()
                }),
            true))
        .deleteElementValue("42");

    // Assert
    verify(targetClass).getString(eq(0));
  }
}
