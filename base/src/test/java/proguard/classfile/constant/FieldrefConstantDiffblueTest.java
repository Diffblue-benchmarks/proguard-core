package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantTagFilter;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.ConstantPoolShrinker;
import proguard.classfile.visitor.MemberVisitor;

class FieldrefConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Fieldref(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldrefConstant#FieldrefConstant()}
   *   <li>{@link FieldrefConstant#toString()}
   *   <li>{@link FieldrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'Fieldref(0,0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.<init>()",
    "void proguard.classfile.constant.FieldrefConstant.<init>(int, int, proguard.classfile.Clazz, proguard.classfile.Field)",
    "boolean proguard.classfile.constant.FieldrefConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.FieldrefConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsFieldref00() {
    // Arrange and Act
    FieldrefConstant actualFieldrefConstant = new FieldrefConstant();
    String actualToStringResult = actualFieldrefConstant.toString();
    boolean actualIsCategory2Result = actualFieldrefConstant.isCategory2();

    // Assert
    assertEquals("Fieldref(0,0)", actualToStringResult);
    assertNull(actualFieldrefConstant.getProcessingInfo());
    assertEquals(0, actualFieldrefConstant.getClassIndex());
    assertEquals(0, actualFieldrefConstant.getNameAndTypeIndex());
    assertEquals(0, actualFieldrefConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Fieldref(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldrefConstant#FieldrefConstant(int, int, Clazz, Field)}
   *   <li>{@link FieldrefConstant#toString()}
   *   <li>{@link FieldrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return toString is 'Fieldref(1,1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.<init>()",
    "void proguard.classfile.constant.FieldrefConstant.<init>(int, int, proguard.classfile.Clazz, proguard.classfile.Field)",
    "boolean proguard.classfile.constant.FieldrefConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.FieldrefConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsFieldref11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    FieldrefConstant actualFieldrefConstant =
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor"));
    String actualToStringResult = actualFieldrefConstant.toString();
    boolean actualIsCategory2Result = actualFieldrefConstant.isCategory2();

    // Assert
    assertEquals("Fieldref(1,1)", actualToStringResult);
    assertNull(actualFieldrefConstant.getProcessingInfo());
    assertEquals(0, actualFieldrefConstant.getProcessingFlags());
    assertEquals(1, actualFieldrefConstant.getClassIndex());
    assertEquals(1, actualFieldrefConstant.getNameAndTypeIndex());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link FieldrefConstant#referencedFieldAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryField} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link FieldrefConstant#referencedFieldAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedFieldAccept(MemberVisitor); given LibraryField accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.referencedFieldAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedFieldAccept_givenLibraryFieldAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryField libraryField = mock(LibraryField.class);
    doNothing().when(libraryField).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.referencedField = libraryField;

    // Act
    fieldrefConstant.referencedFieldAccept(new AttributeSorter());

    // Assert
    verify(libraryField).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }

  /**
   * Test {@link FieldrefConstant#referencedMemberAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryField} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link FieldrefConstant#referencedMemberAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMemberAccept(MemberVisitor); given LibraryField accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.referencedMemberAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMemberAccept_givenLibraryFieldAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryField libraryField = mock(LibraryField.class);
    doNothing().when(libraryField).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    fieldrefConstant.referencedField = libraryField;

    // Act
    fieldrefConstant.referencedMemberAccept(new AttributeSorter());

    // Assert
    verify(libraryField).accept((Clazz) isNull(), isA(MemberVisitor.class));
  }

  /**
   * Test {@link FieldrefConstant#getTag()}.
   *
   * <p>Method under test: {@link FieldrefConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.FieldrefConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.FIELDREF, (new FieldrefConstant()).getTag());
  }

  /**
   * Test {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <p>Method under test: {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    fieldrefConstant.accept(
        clazz, new ConstantTagFilter(Constant.FIELDREF, new ConstantLookupVisitor()));

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz, atLeast(1)).getType(eq(0));
  }

  /**
   * Test {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then {@link ConstantLookupVisitor} (default constructor) {@link
   *       ConstantLookupVisitor#result} is {@code Class Name#Name:Type}.
   * </ul>
   *
   * <p>Method under test: {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then ConstantLookupVisitor (default constructor) result is 'Class Name#Name:Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenConstantLookupVisitorResultIsClassNameNameType() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");
    ConstantLookupVisitor constantVisitor = new ConstantLookupVisitor();

    // Act
    fieldrefConstant.accept(clazz, constantVisitor);

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz, atLeast(1)).getType(eq(0));
    assertEquals("Class Name#Name:Type", constantVisitor.result);
    assertEquals(1, constantVisitor.resultSize);
  }

  /**
   * Test {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link ConstantPoolShrinker} (default constructor).
   *   <li>Then calls {@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); when ConstantPoolShrinker (default constructor); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_whenConstantPoolShrinker_thenCallsConstantPoolEntryAccept() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());

    // Act
    fieldrefConstant.accept(clazz, new ConstantPoolShrinker());

    // Assert
    verify(clazz, atLeast(1)).constantPoolEntryAccept(eq(0), isA(ConstantVisitor.class));
  }

  /**
   * Test {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); when LibraryClass; then ConstantCounter (default constructor) Count is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.FieldrefConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_whenLibraryClass_thenConstantCounterCountIsOne() {
    // Arrange
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    LibraryClass clazz = mock(LibraryClass.class);
    ConstantCounter constantVisitor = new ConstantCounter();

    // Act
    fieldrefConstant.accept(clazz, constantVisitor);

    // Assert
    assertEquals(1, constantVisitor.getCount());
  }
}
