package proguard.classfile.visitor;

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
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.util.SimpleProcessable;

class ConstantProcessingFlagFilterDiffblueTest {
  /**
   * Test {@link ConstantProcessingFlagFilter#visitAnyConstant(Clazz, Constant)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link SimpleProcessable#getProcessingFlags()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantProcessingFlagFilter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName("Test visitAnyConstant(Clazz, Constant); given one; then calls getProcessingFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstantProcessingFlagFilter.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testVisitAnyConstant_givenOne_thenCallsGetProcessingFlags() {
    // Arrange
    ConstantProcessingFlagFilter constantProcessingFlagFilter =
        new ConstantProcessingFlagFilter(1, 1, new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    ClassConstant constant = mock(ClassConstant.class);
    when(constant.getProcessingFlags()).thenReturn(1);

    // Act
    constantProcessingFlagFilter.visitAnyConstant(clazz, constant);

    // Assert
    verify(constant).getProcessingFlags();
  }

  /**
   * Test {@link ConstantProcessingFlagFilter#visitAnyConstant(Clazz, Constant)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantProcessingFlagFilter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName("Test visitAnyConstant(Clazz, Constant); then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ConstantProcessingFlagFilter.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testVisitAnyConstant_thenCallsAccept() {
    // Arrange
    ConstantProcessingFlagFilter constantProcessingFlagFilter =
        new ConstantProcessingFlagFilter(1, 0, new ConstantLookupVisitor());
    LibraryClass clazz = new LibraryClass();
    ClassConstant constant = mock(ClassConstant.class);
    doNothing().when(constant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());
    when(constant.getProcessingFlags()).thenReturn(1);

    // Act
    constantProcessingFlagFilter.visitAnyConstant(clazz, constant);

    // Assert
    verify(constant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(constant).getProcessingFlags();
  }
}
