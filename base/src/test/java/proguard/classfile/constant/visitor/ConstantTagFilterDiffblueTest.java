package proguard.classfile.constant.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class ConstantTagFilterDiffblueTest {
  /**
   * Test {@link ConstantTagFilter#visitAnyConstant(Clazz, Constant)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ClassConstant} {@link ClassConstant#accept(Clazz, ConstantVisitor)} does
   *       nothing.
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantTagFilter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName(
      "Test visitAnyConstant(Clazz, Constant); given one; when ClassConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantTagFilter.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testVisitAnyConstant_givenOne_whenClassConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ConstantTagFilter constantTagFilter = new ConstantTagFilter(1, new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    ClassConstant constant = mock(ClassConstant.class);
    doNothing().when(constant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    when(constant.getTag()).thenReturn(1);

    // Act
    constantTagFilter.visitAnyConstant(clazz, constant);

    // Assert
    verify(constant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(constant).getTag();
  }
}
