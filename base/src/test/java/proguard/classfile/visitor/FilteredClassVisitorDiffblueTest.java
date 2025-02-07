package proguard.classfile.visitor;

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
import proguard.classfile.ClassPool;
import proguard.classfile.ProgramClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.util.EmptyStringMatcher;

class FilteredClassVisitorDiffblueTest {
  /**
   * Test {@link FilteredClassVisitor#FilteredClassVisitor(String, ClassVisitor)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredClassVisitor#FilteredClassVisitor(String, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new FilteredClassVisitor(String, ClassVisitor); when empty string; then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.FilteredClassVisitor.<init>(java.lang.String, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewFilteredClassVisitor_whenEmptyString_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    (new FilteredClassVisitor("", classVisitor)).visitClassPool(KotlinConstants.dummyClassPool);

    // Assert
    verify(classVisitor, atLeast(1)).visitProgramClass(Mockito.<ProgramClass>any());
  }

  /**
   * Test {@link FilteredClassVisitor#visitClassPool(ClassPool)}.
   *
   * <p>Method under test: {@link FilteredClassVisitor#visitClassPool(ClassPool)}
   */
  @Test
  @DisplayName("Test visitClassPool(ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.FilteredClassVisitor.visitClassPool(proguard.classfile.ClassPool)"
  })
  void testVisitClassPool() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    (new FilteredClassVisitor("", classVisitor)).visitClassPool(KotlinConstants.dummyClassPool);

    // Assert
    verify(classVisitor, atLeast(1)).visitProgramClass(Mockito.<ProgramClass>any());
  }

  /**
   * Test {@link FilteredClassVisitor#visitClassPool(ClassPool)}.
   *
   * <p>Method under test: {@link FilteredClassVisitor#visitClassPool(ClassPool)}
   */
  @Test
  @DisplayName("Test visitClassPool(ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.FilteredClassVisitor.visitClassPool(proguard.classfile.ClassPool)"
  })
  void testVisitClassPool2() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    (new FilteredClassVisitor(new EmptyStringMatcher(), classVisitor))
        .visitClassPool(KotlinConstants.dummyClassPool);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }
}
