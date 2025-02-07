package com.guardsquare.proguard.tools;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.visitor.ClassVisitor;

public class StringPrinterDiffblueTest {
  /**
   * Test {@link StringPrinter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringPrinter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void com.guardsquare.proguard.tools.StringPrinter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  public void testVisitProgramClass_whenProgramClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    StringPrinter stringPrinter = new StringPrinter();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    stringPrinter.visitProgramClass(programClass);

    // Assert
    verify(programClass).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link StringPrinter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramField#attributesAccept(ProgramClass, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringPrinter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void com.guardsquare.proguard.tools.StringPrinter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  public void testVisitProgramField_thenCallsAttributesAccept() {
    // Arrange
    StringPrinter stringPrinter = new StringPrinter();
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = mock(ProgramField.class);
    doNothing()
        .when(programField)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());

    // Act
    stringPrinter.visitProgramField(programClass, programField);

    // Assert
    verify(programField).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link StringPrinter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramMethod#attributesAccept(ProgramClass, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringPrinter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void com.guardsquare.proguard.tools.StringPrinter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  public void testVisitProgramMethod_thenCallsAttributesAccept() {
    // Arrange
    StringPrinter stringPrinter = new StringPrinter();
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = mock(ProgramMethod.class);
    doNothing()
        .when(programMethod)
        .attributesAccept(Mockito.<ProgramClass>any(), Mockito.<AttributeVisitor>any());

    // Act
    stringPrinter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).attributesAccept(isA(ProgramClass.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link StringPrinter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link StringPrinter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void com.guardsquare.proguard.tools.StringPrinter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  public void testVisitStringConstant_givenString_whenLibraryClass_thenCallsGetString() {
    // Arrange
    StringPrinter stringPrinter = new StringPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    stringPrinter.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
  }

  /**
   * Test {@link StringPrinter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link StringPrinter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void com.guardsquare.proguard.tools.StringPrinter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  public void testVisitStringConstant_whenLibraryClassGetStringReturnString_thenCallsGetString() {
    // Arrange
    StringPrinter stringPrinter = new StringPrinter();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    stringPrinter.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }
}
