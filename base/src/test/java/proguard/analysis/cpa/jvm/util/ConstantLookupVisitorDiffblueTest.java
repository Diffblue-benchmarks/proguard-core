package proguard.analysis.cpa.jvm.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;

class ConstantLookupVisitorDiffblueTest {
  /**
   * Test {@link ConstantLookupVisitor#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then {@link ConstantLookupVisitor} (default constructor) {@link
   *       ConstantLookupVisitor#result} is {@code Class Name#Name:#}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantLookupVisitor#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then ConstantLookupVisitor (default constructor) result is 'Class Name#Name:#'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.util.ConstantLookupVisitor.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenConstantLookupVisitorResultIsClassNameName() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("#");

    // Act
    constantLookupVisitor.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz, atLeast(1)).getType(eq(0));
    assertEquals("Class Name#Name:#", constantLookupVisitor.result);
    assertEquals(1, constantLookupVisitor.resultSize);
  }

  /**
   * Test {@link ConstantLookupVisitor#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then {@link ConstantLookupVisitor} (default constructor) {@link
   *       ConstantLookupVisitor#result} is {@code Class Name#Name:Type}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantLookupVisitor#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then ConstantLookupVisitor (default constructor) result is 'Class Name#Name:Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.util.ConstantLookupVisitor.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenConstantLookupVisitorResultIsClassNameNameType() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantLookupVisitor.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz, atLeast(1)).getType(eq(0));
    assertEquals("Class Name#Name:Type", constantLookupVisitor.result);
    assertEquals(1, constantLookupVisitor.resultSize);
  }

  /**
   * Test {@link ConstantLookupVisitor#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then {@link ConstantLookupVisitor} (default constructor) {@link
   *       ConstantLookupVisitor#result} is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantLookupVisitor#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; then ConstantLookupVisitor (default constructor) result is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.util.ConstantLookupVisitor.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_thenConstantLookupVisitorResultIsName() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantLookupVisitor.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
    assertEquals("Name", constantLookupVisitor.result);
    assertEquals(1, constantLookupVisitor.resultSize);
  }

  /**
   * Test {@link ConstantLookupVisitor#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then {@link ConstantLookupVisitor} (default constructor) {@link
   *       ConstantLookupVisitor#result} is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantLookupVisitor#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'String'; then ConstantLookupVisitor (default constructor) result is 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.util.ConstantLookupVisitor.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenString_thenConstantLookupVisitorResultIsString() {
    // Arrange
    ConstantLookupVisitor constantLookupVisitor = new ConstantLookupVisitor();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantLookupVisitor.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", constantLookupVisitor.result);
    assertEquals(1, constantLookupVisitor.resultSize);
  }

  /**
   * Test new {@link ConstantLookupVisitor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ConstantLookupVisitor}
   */
  @Test
  @DisplayName("Test new ConstantLookupVisitor (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.analysis.cpa.jvm.util.ConstantLookupVisitor.<init>()"})
  void testNewConstantLookupVisitor() {
    // Arrange and Act
    ConstantLookupVisitor actualConstantLookupVisitor = new ConstantLookupVisitor();

    // Assert
    assertNull(actualConstantLookupVisitor.result);
    assertNull(actualConstantLookupVisitor.resultClazz);
    assertEquals(-1, actualConstantLookupVisitor.resultSize);
    assertFalse(actualConstantLookupVisitor.isStatic);
  }
}
