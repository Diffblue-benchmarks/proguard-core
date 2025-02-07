package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.Member;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMember;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.ConstantPoolRemapper;
import proguard.testutils.cpa.NamedField;

class MemberRenamerDiffblueTest {
  /**
   * Test {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <p>Method under test: {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName("Test visitProgramMember(ProgramClass, ProgramMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember() throws UnsupportedEncodingException {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, null);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    NamedField programMember = new NamedField("Field Name", "Field Descriptor");

    // Act
    memberRenamer.visitProgramMember(programClass, programMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    assertEquals("Apply", ((Utf8Constant) constant).getString());
    assertNull(constant.getProcessingInfo());
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, constant.getTag());
    assertEquals(1, programMember.u2nameIndex);
    assertEquals(17, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    byte[] expectedBytes = "Apply".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then first element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then first element ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenFirstElementClassConstant() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn(null);
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, new AttributeSorter());
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3, new Constant[] {classConstant}, 1, 1, 1);

    NamedField programMember = new NamedField("Field Name", "Field Descriptor");

    // Act
    memberRenamer.visitProgramMember(programClass, programMember);

    // Assert that nothing has changed
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(0, programMember.u2nameIndex);
    assertEquals(1, constantArray.length);
    assertEquals(3, programClass.u2constantPoolCount);
    assertSame(classConstant, constant);
  }

  /**
   * Test {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then first element {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then first element Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenFirstElementUtf8Constant() throws UnsupportedEncodingException {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, new AttributeSorter());
    ProgramClass programClass =
        new ProgramClass(1, 0, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    memberRenamer.visitProgramMember(
        programClass, new NamedField("Field Name", "Field Descriptor"));

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof Utf8Constant);
    assertEquals("Apply", ((Utf8Constant) constant).getString());
    assertEquals(1, constant.getTag());
    assertEquals(1, constantArray.length);
    assertEquals(1, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    byte[] expectedBytes = "Apply".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then fourth element {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then fourth element Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenFourthElementUtf8Constant() throws UnsupportedEncodingException {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, new AttributeSorter());
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    NamedField programMember = new NamedField("Field Name", "Field Descriptor");

    // Act
    memberRenamer.visitProgramMember(programClass, programMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof Utf8Constant);
    assertEquals("Apply", ((Utf8Constant) constant).getString());
    assertNull(constant.getProcessingInfo());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, constant.getTag());
    assertEquals(19, constantArray.length);
    assertEquals(3, programMember.u2nameIndex);
    assertEquals(4, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    byte[] expectedBytes = "Apply".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then ProgramClass() u2constantPoolCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenProgramClassU2constantPoolCountIsZero() {
    // Arrange
    Function<Clazz, String> classNameFunction = mock(Function.class);
    MemberRenamer memberRenamer = new MemberRenamer(classNameFunction, new AttributeSorter());
    ProgramClass programClass = new ProgramClass();
    NamedField programMember = new NamedField("Field Name", "Field Descriptor");

    // Act
    memberRenamer.visitProgramMember(programClass, programMember);

    // Assert that nothing has changed
    assertEquals(0, programClass.u2constantPoolCount);
    assertEquals(0, programMember.u2nameIndex);
  }

  /**
   * Test {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>Then second element {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); then second element Utf8Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitProgramMember(proguard.classfile.ProgramClass, proguard.classfile.ProgramMember)"
  })
  void testVisitProgramMember_thenSecondElementUtf8Constant() throws UnsupportedEncodingException {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, new AttributeSorter());
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    NamedField programMember = new NamedField("Field Name", "Field Descriptor");

    // Act
    memberRenamer.visitProgramMember(programClass, programMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    assertEquals("Apply", ((Utf8Constant) constant).getString());
    assertNull(constant.getProcessingInfo());
    assertNull(constantArray[2]);
    assertNull(constantArray[3]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, constant.getTag());
    assertEquals(1, programMember.u2nameIndex);
    assertEquals(17, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    byte[] expectedBytes = "Apply".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <p>Method under test: {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName("Test visitLibraryMember(LibraryClass, LibraryMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction);
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Apply", libraryMember.name);
  }

  /**
   * Test {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <p>Method under test: {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName("Test visitLibraryMember(LibraryClass, LibraryMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember2() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, new ConstantPoolRemapper());
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Apply", libraryMember.name);
  }

  /**
   * Test {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <p>Method under test: {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName("Test visitLibraryMember(LibraryClass, LibraryMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember3() {
    // Arrange
    Function<Clazz, String> classNameFunction = mock(Function.class);
    MemberRenamer memberRenamer = new MemberRenamer(classNameFunction, new AttributeSorter());
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert that nothing has changed
    assertEquals("Name", libraryMember.name);
  }

  /**
   * Test {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <p>Method under test: {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName("Test visitLibraryMember(LibraryClass, LibraryMember)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember4() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Apply");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction, new MethodLinker());
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Apply", libraryMember.name);
  }

  /**
   * Test {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMember(LibraryClass, LibraryMember); given BiFunction apply(Object, Object) return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember_givenBiFunctionApplyReturnName() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn("Name");
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction);
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert that nothing has changed
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Name", libraryMember.name);
  }

  /**
   * Test {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberRenamer#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMember(LibraryClass, LibraryMember); given BiFunction apply(Object, Object) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MemberRenamer.visitLibraryMember(proguard.classfile.LibraryClass, proguard.classfile.LibraryMember)"
  })
  void testVisitLibraryMember_givenBiFunctionApplyReturnNull() {
    // Arrange
    BiFunction<Clazz, Member, String> memberNameFunction = mock(BiFunction.class);
    when(memberNameFunction.apply(Mockito.<Clazz>any(), Mockito.<Member>any())).thenReturn(null);
    MemberRenamer memberRenamer = new MemberRenamer(memberNameFunction);
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act
    memberRenamer.visitLibraryMember(libraryClass, libraryMember);

    // Assert that nothing has changed
    verify(memberNameFunction).apply(isA(Clazz.class), isA(Member.class));
    assertEquals("Name", libraryMember.name);
  }
}
