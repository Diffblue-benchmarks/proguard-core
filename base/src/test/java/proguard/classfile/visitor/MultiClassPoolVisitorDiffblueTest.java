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
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;

class MultiClassPoolVisitorDiffblueTest {
  /**
   * Test {@link MultiClassPoolVisitor#visitClassPool(ClassPool)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPoolVisitor#visitClassPool(ClassPool)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiClassPoolVisitor#visitClassPool(ClassPool)}
   */
  @Test
  @DisplayName("Test visitClassPool(ClassPool); then calls visitClassPool(ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MultiClassPoolVisitor.visitClassPool(proguard.classfile.ClassPool)"
  })
  void testVisitClassPool_thenCallsVisitClassPool() {
    // Arrange
    ClassPoolVisitor classPoolVisitor = mock(ClassPoolVisitor.class);
    doNothing().when(classPoolVisitor).visitClassPool(Mockito.<ClassPool>any());

    // Act
    (new MultiClassPoolVisitor(classPoolVisitor)).visitClassPool(KotlinConstants.dummyClassPool);

    // Assert
    verify(classPoolVisitor).visitClassPool(isA(ClassPool.class));
  }
}
