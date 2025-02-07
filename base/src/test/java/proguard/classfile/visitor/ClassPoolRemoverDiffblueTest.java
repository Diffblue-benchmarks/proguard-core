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
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ClassPoolRemoverDiffblueTest {
  /**
   * Test {@link ClassPoolRemover#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#removeClass(Clazz)} does nothing.
   *   <li>Then calls {@link ClassPool#removeClass(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPoolRemover#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given ClassPool removeClass(Clazz) does nothing; then calls removeClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPoolRemover.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenClassPoolRemoveClassDoesNothing_thenCallsRemoveClass() {
    // Arrange
    ClassPool classPool = mock(ClassPool.class);
    doNothing().when(classPool).removeClass(Mockito.<Clazz>any());
    ClassPoolRemover classPoolRemover = new ClassPoolRemover(classPool);

    // Act
    classPoolRemover.visitAnyClass(new LibraryClass());

    // Assert
    verify(classPool).removeClass(isA(Clazz.class));
  }
}
