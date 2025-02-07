package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;

class AttributesEditorDiffblueTest {
  /**
   * Test {@link AttributesEditor#findAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  @DisplayName("Test findAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.Attribute proguard.classfile.editor.AttributesEditor.findAttribute(java.lang.String)"
  })
  void testFindAttributeWithAttributeName() {
    // Arrange, Act and Assert
    assertNull((new AttributesEditor(new ProgramClass(), true)).findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#findAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  @DisplayName("Test findAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.Attribute proguard.classfile.editor.AttributesEditor.findAttribute(java.lang.String)"
  })
  void testFindAttributeWithAttributeName2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertNull(
        (new AttributesEditor(targetClass, new ProgramField(), true))
            .findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#findAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#findAttribute(String)}
   */
  @Test
  @DisplayName("Test findAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.Attribute proguard.classfile.editor.AttributesEditor.findAttribute(java.lang.String)"
  })
  void testFindAttributeWithAttributeName3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ProgramField targetMember = new ProgramField();

    // Act and Assert
    assertNull(
        (new AttributesEditor(targetClass, targetMember, new CodeAttribute(1), true))
            .findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#addAttribute(Attribute)} with {@code attribute}.
   *
   * <p>Method under test: {@link AttributesEditor#addAttribute(Attribute)}
   */
  @Test
  @DisplayName("Test addAttribute(Attribute) with 'attribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.addAttribute(proguard.classfile.attribute.Attribute)"
  })
  void testAddAttributeWithAttribute() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ProgramField targetMember = new ProgramField();
    AttributesEditor attributesEditor =
        new AttributesEditor(targetClass, targetMember, new CodeAttribute(1), true);
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributesEditor.addAttribute(attribute);

    // Assert
    verify(attribute).getAttributeName(isA(Clazz.class));
    assertSame(attribute, attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#addAttribute(Attribute)} with {@code attribute}.
   *
   * <p>Method under test: {@link AttributesEditor#addAttribute(Attribute)}
   */
  @Test
  @DisplayName("Test addAttribute(Attribute) with 'attribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.addAttribute(proguard.classfile.attribute.Attribute)"
  })
  void testAddAttributeWithAttribute2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    AttributesEditor attributesEditor =
        new AttributesEditor(targetClass, new ProgramField(1, 1, 1, new LibraryClass()), true);
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributesEditor.addAttribute(attribute);

    // Assert
    verify(attribute).getAttributeName(isA(Clazz.class));
    assertSame(attribute, attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#addAttribute(Attribute)} with {@code attribute}.
   *
   * <p>Method under test: {@link AttributesEditor#addAttribute(Attribute)}
   */
  @Test
  @DisplayName("Test addAttribute(Attribute) with 'attribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.addAttribute(proguard.classfile.attribute.Attribute)"
  })
  void testAddAttributeWithAttribute3() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    AttributesEditor attributesEditor =
        new AttributesEditor(
            targetClass,
            new ProgramField(
                1, 1, 1, 0, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributesEditor.addAttribute(attribute);

    // Assert
    verify(attribute).getAttributeName(isA(Clazz.class));
    assertSame(attribute, attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#addAttribute(Attribute)} with {@code attribute}.
   *
   * <ul>
   *   <li>Given {@link Attribute} {@link Attribute#getAttributeName(Clazz)} return {@code Attribute
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link AttributesEditor#addAttribute(Attribute)}
   */
  @Test
  @DisplayName(
      "Test addAttribute(Attribute) with 'attribute'; given Attribute getAttributeName(Clazz) return 'Attribute Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.addAttribute(proguard.classfile.attribute.Attribute)"
  })
  void testAddAttributeWithAttribute_givenAttributeGetAttributeNameReturnAttributeName() {
    // Arrange
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");
    AttributesEditor attributesEditor =
        new AttributesEditor(
            mock(ProgramClass.class),
            new ProgramField(1, 1, 1, 3, new Attribute[] {attribute}, new LibraryClass()),
            true);
    Attribute attribute2 = mock(Attribute.class);
    when(attribute2.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributesEditor.addAttribute(attribute2);

    // Assert
    verify(attribute).getAttributeName(isA(Clazz.class));
    verify(attribute2).getAttributeName(isA(Clazz.class));
    assertSame(attribute2, attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#addAttribute(Attribute)} with {@code attribute}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributesEditor#addAttribute(Attribute)}
   */
  @Test
  @DisplayName("Test addAttribute(Attribute) with 'attribute'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.addAttribute(proguard.classfile.attribute.Attribute)"
  })
  void testAddAttributeWithAttribute_thenCallsGetString() {
    // Arrange
    ProgramClass targetClass = mock(ProgramClass.class);
    when(targetClass.getString(anyInt())).thenReturn("Attribute Name");
    AttributesEditor attributesEditor =
        new AttributesEditor(
            targetClass,
            new ProgramField(
                1, 1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()}, new LibraryClass()),
            true);
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");

    // Act
    attributesEditor.addAttribute(attribute);

    // Assert
    verify(targetClass).getString(eq(0));
    verify(attribute).getAttributeName(isA(Clazz.class));
    assertSame(attribute, attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#deleteAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#deleteAttribute(String)}
   */
  @Test
  @DisplayName("Test deleteAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.deleteAttribute(java.lang.String)"
  })
  void testDeleteAttributeWithAttributeName() {
    // Arrange
    AttributesEditor attributesEditor = new AttributesEditor(new ProgramClass(), true);

    // Act
    attributesEditor.deleteAttribute("Attribute Name");

    // Assert that nothing has changed
    assertNull(attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#deleteAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#deleteAttribute(String)}
   */
  @Test
  @DisplayName("Test deleteAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.deleteAttribute(java.lang.String)"
  })
  void testDeleteAttributeWithAttributeName2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    AttributesEditor attributesEditor = new AttributesEditor(targetClass, new ProgramField(), true);

    // Act
    attributesEditor.deleteAttribute("Attribute Name");

    // Assert that nothing has changed
    assertNull(attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#deleteAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#deleteAttribute(String)}
   */
  @Test
  @DisplayName("Test deleteAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.deleteAttribute(java.lang.String)"
  })
  void testDeleteAttributeWithAttributeName3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ProgramField targetMember = new ProgramField();
    AttributesEditor attributesEditor =
        new AttributesEditor(targetClass, targetMember, new CodeAttribute(1), true);

    // Act
    attributesEditor.deleteAttribute("Attribute Name");

    // Assert that nothing has changed
    assertNull(attributesEditor.findAttribute("Attribute Name"));
  }

  /**
   * Test {@link AttributesEditor#deleteAttribute(String)} with {@code attributeName}.
   *
   * <p>Method under test: {@link AttributesEditor#deleteAttribute(String)}
   */
  @Test
  @DisplayName("Test deleteAttribute(String) with 'attributeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.AttributesEditor.deleteAttribute(java.lang.String)"
  })
  void testDeleteAttributeWithAttributeName4() {
    // Arrange
    Attribute attribute = mock(Attribute.class);
    when(attribute.getAttributeName(Mockito.<Clazz>any())).thenReturn("Attribute Name");
    AttributesEditor attributesEditor =
        new AttributesEditor(
            mock(ProgramClass.class),
            new ProgramField(-1, 1, 1, 1, new Attribute[] {attribute}, new LibraryClass()),
            true);

    // Act
    attributesEditor.deleteAttribute("Attribute Name");

    // Assert
    verify(attribute).getAttributeName(isA(Clazz.class));
    assertNull(attributesEditor.findAttribute("Attribute Name"));
  }
}
