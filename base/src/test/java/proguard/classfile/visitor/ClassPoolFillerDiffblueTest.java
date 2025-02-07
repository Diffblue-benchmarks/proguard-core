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

class ClassPoolFillerDiffblueTest {
  /**
   * Test {@link ClassPoolFiller#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link ClassPool} {@link ClassPool#addClass(Clazz)} does nothing.
   *   <li>Then calls {@link ClassPool#addClass(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPoolFiller#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given ClassPool addClass(Clazz) does nothing; then calls addClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPoolFiller.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenClassPoolAddClassDoesNothing_thenCallsAddClass() {
    // Arrange
    ClassPool classPool = mock(ClassPool.class);
    doNothing().when(classPool).addClass(Mockito.<Clazz>any());
    ClassPoolFiller classPoolFiller = new ClassPoolFiller(classPool);

    // Act
    classPoolFiller.visitAnyClass(new LibraryClass());

    // Assert
    verify(classPool).addClass(isA(Clazz.class));
  }
}
