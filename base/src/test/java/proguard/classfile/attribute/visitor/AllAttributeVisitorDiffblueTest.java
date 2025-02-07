package proguard.classfile.attribute.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.RecordAttribute;
import proguard.classfile.attribute.RecordComponentInfo;
import proguard.classfile.visitor.MemberVisitor;

class AllAttributeVisitorDiffblueTest {
  /**
   * Test {@link AllAttributeVisitor#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllAttributeVisitor#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AllAttributeVisitor.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAttributesAccept() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor =
        new AllAttributeVisitor(true, new DominatorCalculator(true));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    allAttributeVisitor.visitProgramClass(programClass);

    // Assert
    verify(programClass, atLeast(1)).attributesAccept(Mockito.<AttributeVisitor>any());
    verify(programClass).fieldsAccept(isA(MemberVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link AllAttributeVisitor#visitRecordAttribute(Clazz, RecordAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordAttribute#componentsAccept(Clazz, RecordComponentInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllAttributeVisitor#visitRecordAttribute(Clazz, RecordAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRecordAttribute(Clazz, RecordAttribute); then calls componentsAccept(Clazz, RecordComponentInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AllAttributeVisitor.visitRecordAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.RecordAttribute)"
  })
  void testVisitRecordAttribute_thenCallsComponentsAccept() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor =
        new AllAttributeVisitor(true, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordAttribute recordAttribute = mock(RecordAttribute.class);
    doNothing()
        .when(recordAttribute)
        .componentsAccept(Mockito.<Clazz>any(), Mockito.<RecordComponentInfoVisitor>any());

    // Act
    allAttributeVisitor.visitRecordAttribute(clazz, recordAttribute);

    // Assert
    verify(recordAttribute)
        .componentsAccept(isA(Clazz.class), isA(RecordComponentInfoVisitor.class));
  }

  /**
   * Test {@link AllAttributeVisitor#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#attributesAccept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllAttributeVisitor#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls attributesAccept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AllAttributeVisitor.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAttributesAccept() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor =
        new AllAttributeVisitor(true, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .attributesAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());

    // Act
    allAttributeVisitor.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .attributesAccept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link AllAttributeVisitor#visitRecordComponentInfo(Clazz, RecordComponentInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link RecordComponentInfo#attributesAccept(Clazz, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllAttributeVisitor#visitRecordComponentInfo(Clazz,
   * RecordComponentInfo)}
   */
  @Test
  @DisplayName(
      "Test visitRecordComponentInfo(Clazz, RecordComponentInfo); then calls attributesAccept(Clazz, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AllAttributeVisitor.visitRecordComponentInfo(proguard.classfile.Clazz, proguard.classfile.attribute.RecordComponentInfo)"
  })
  void testVisitRecordComponentInfo_thenCallsAttributesAccept() {
    // Arrange
    AllAttributeVisitor allAttributeVisitor =
        new AllAttributeVisitor(true, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    RecordComponentInfo recordComponentInfo = mock(RecordComponentInfo.class);
    doNothing()
        .when(recordComponentInfo)
        .attributesAccept(Mockito.<Clazz>any(), Mockito.<AttributeVisitor>any());

    // Act
    allAttributeVisitor.visitRecordComponentInfo(clazz, recordComponentInfo);

    // Assert
    verify(recordComponentInfo).attributesAccept(isA(Clazz.class), isA(AttributeVisitor.class));
  }
}
