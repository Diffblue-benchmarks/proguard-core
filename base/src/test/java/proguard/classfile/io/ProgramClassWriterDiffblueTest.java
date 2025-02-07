package proguard.classfile.io;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.visitor.MemberVisitor;
import proguard.io.ZipOutput.LargeDataOutputStream;

class ProgramClassWriterDiffblueTest {
  /**
   * Test {@link ProgramClassWriter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassWriter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.ProgramClassWriter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    ProgramClassWriter programClassWriter =
        new ProgramClassWriter(new LargeDataOutputStream(new ByteArrayOutputStream(1)));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    programClassWriter.visitProgramClass(programClass);

    // Assert
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ProgramClassWriter#visitAnyConstant(Clazz, Constant)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ClassConstant} {@link ClassConstant#getTag()} return one.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassWriter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyConstant(Clazz, Constant); given one; when ClassConstant getTag() return one; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.ProgramClassWriter.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testVisitAnyConstant_givenOne_whenClassConstantGetTagReturnOne_thenCallsAccept() {
    // Arrange
    ProgramClassWriter programClassWriter =
        new ProgramClassWriter(new LargeDataOutputStream(new ByteArrayOutputStream(1)));
    LibraryClass clazz = new LibraryClass();
    ClassConstant constant = mock(ClassConstant.class);
    when(constant.getTag()).thenReturn(1);
    doNothing().when(constant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    programClassWriter.visitAnyConstant(clazz, constant);

    // Assert
    verify(constant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(constant).getTag();
  }

  /**
   * Test {@link ProgramClassWriter#visitAnyAttribute(Clazz, Attribute)}.
   *
   * <ul>
   *   <li>When {@link Attribute} {@link Attribute#accept(Clazz, Method, CodeAttribute,
   *       AttributeVisitor)} does nothing.
   *   <li>Then calls {@link Attribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramClassWriter#visitAnyAttribute(Clazz, Attribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyAttribute(Clazz, Attribute); when Attribute accept(Clazz, Method, CodeAttribute, AttributeVisitor) does nothing; then calls accept(Clazz, Method, CodeAttribute, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.ProgramClassWriter.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testVisitAnyAttribute_whenAttributeAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ProgramClassWriter programClassWriter =
        new ProgramClassWriter(new LargeDataOutputStream(new ByteArrayOutputStream(1)));
    LibraryClass clazz = new LibraryClass();
    Attribute attribute = mock(Attribute.class);
    doNothing()
        .when(attribute)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<AttributeVisitor>any());

    // Act
    programClassWriter.visitAnyAttribute(clazz, attribute);

    // Assert
    verify(attribute).accept(isA(Clazz.class), isNull(), isNull(), isA(AttributeVisitor.class));
  }
}
