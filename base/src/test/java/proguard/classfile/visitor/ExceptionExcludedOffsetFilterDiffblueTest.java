package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.visitor.ExceptionInfoVisitor;

class ExceptionExcludedOffsetFilterDiffblueTest {
  /**
   * Test {@link ExceptionExcludedOffsetFilter#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ExceptionExcludedOffsetFilter#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ExceptionExcludedOffsetFilter.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo() {
    // Arrange
    ExceptionInfoVisitor exceptionInfoVisitor = mock(ExceptionInfoVisitor.class);
    doNothing()
        .when(exceptionInfoVisitor)
        .visitExceptionInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<ExceptionInfo>any());
    ExceptionExcludedOffsetFilter exceptionExcludedOffsetFilter =
        new ExceptionExcludedOffsetFilter(0, exceptionInfoVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    exceptionExcludedOffsetFilter.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    verify(exceptionInfoVisitor)
        .visitExceptionInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(ExceptionInfo.class));
  }

  /**
   * Test {@link ExceptionExcludedOffsetFilter#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link ExceptionInfoVisitor#visitExceptionInfo(Clazz, Method, CodeAttribute,
   *       ExceptionInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionExcludedOffsetFilter#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then calls visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ExceptionExcludedOffsetFilter.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenCallsVisitExceptionInfo() {
    // Arrange
    ExceptionInfoVisitor exceptionInfoVisitor = mock(ExceptionInfoVisitor.class);
    doNothing()
        .when(exceptionInfoVisitor)
        .visitExceptionInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<ExceptionInfo>any());
    ExceptionExcludedOffsetFilter exceptionExcludedOffsetFilter =
        new ExceptionExcludedOffsetFilter(3, exceptionInfoVisitor);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    exceptionExcludedOffsetFilter.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    verify(exceptionInfoVisitor)
        .visitExceptionInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(ExceptionInfo.class));
  }
}
