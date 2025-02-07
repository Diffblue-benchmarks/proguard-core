package proguard.classfile.visitor;

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

class AllClassVisitorDiffblueTest {
  /**
   * Test {@link AllClassVisitor#visitClassPool(ClassPool)}.
   *
   * <ul>
   *   <li>When {@link KotlinConstants#dummyClassPool}.
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link AllClassVisitor#visitClassPool(ClassPool)}
   */
  @Test
  @DisplayName(
      "Test visitClassPool(ClassPool); when dummyClassPool; then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.AllClassVisitor.visitClassPool(proguard.classfile.ClassPool)"
  })
  void testVisitClassPool_whenDummyClassPool_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());

    // Act
    (new AllClassVisitor(classVisitor)).visitClassPool(KotlinConstants.dummyClassPool);

    // Assert
    verify(classVisitor, atLeast(1)).visitProgramClass(Mockito.<ProgramClass>any());
  }
}
