package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.MemberVisitor;

class RecordComponentInfoDiffblueTest {
  /**
   * Test {@link RecordComponentInfo#RecordComponentInfo()}.
   *
   * <p>Method under test: {@link RecordComponentInfo#RecordComponentInfo()}
   */
  @Test
  @DisplayName("Test new RecordComponentInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.RecordComponentInfo.<init>()",
    "void proguard.classfile.attribute.RecordComponentInfo.<init>(int, int, int, proguard.classfile.attribute.Attribute[])"
  })
  void testNewRecordComponentInfo() {
    // Arrange and Act
    RecordComponentInfo actualRecordComponentInfo = new RecordComponentInfo();

    // Assert
    assertNull(actualRecordComponentInfo.getProcessingInfo());
    assertEquals(0, actualRecordComponentInfo.getProcessingFlags());
  }

  /**
   * Test {@link RecordComponentInfo#RecordComponentInfo(int, int, int, Attribute[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link RecordComponentInfo#RecordComponentInfo(int, int, int,
   * Attribute[])}
   */
  @Test
  @DisplayName("Test new RecordComponentInfo(int, int, int, Attribute[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.RecordComponentInfo.<init>()",
    "void proguard.classfile.attribute.RecordComponentInfo.<init>(int, int, int, proguard.classfile.attribute.Attribute[])"
  })
  void testNewRecordComponentInfo_whenOne() {
    // Arrange and Act
    RecordComponentInfo actualRecordComponentInfo =
        new RecordComponentInfo(1, 1, 3, new Attribute[] {new BootstrapMethodsAttribute()});

    // Assert
    assertNull(actualRecordComponentInfo.getProcessingInfo());
    assertEquals(0, actualRecordComponentInfo.getProcessingFlags());
  }

  /**
   * Test {@link RecordComponentInfo#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link RecordComponentInfo#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.RecordComponentInfo.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = recordComponentInfo.getName(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link RecordComponentInfo#getDescriptor(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link RecordComponentInfo#getDescriptor(Clazz)}
   */
  @Test
  @DisplayName("Test getDescriptor(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.RecordComponentInfo.getDescriptor(proguard.classfile.Clazz)"
  })
  void testGetDescriptor_givenString_thenReturnString() {
    // Arrange
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualDescriptor = recordComponentInfo.getDescriptor(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualDescriptor);
  }

  /**
   * Test {@link RecordComponentInfo#referencedFieldAccept(Clazz, MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryField} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link RecordComponentInfo#referencedFieldAccept(Clazz, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedFieldAccept(Clazz, MemberVisitor); given LibraryField accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.RecordComponentInfo.referencedFieldAccept(proguard.classfile.Clazz, proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedFieldAccept_givenLibraryFieldAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryField libraryField = mock(LibraryField.class);
    doNothing().when(libraryField).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    RecordComponentInfo recordComponentInfo = new RecordComponentInfo();
    recordComponentInfo.referencedField = libraryField;
    LibraryClass clazz = new LibraryClass();

    // Act
    recordComponentInfo.referencedFieldAccept(clazz, new AttributeSorter());

    // Assert
    verify(libraryField).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }
}
