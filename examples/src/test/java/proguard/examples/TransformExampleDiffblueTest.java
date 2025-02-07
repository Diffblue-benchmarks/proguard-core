package proguard.examples;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import proguard.classfile.ProgramClass;
import proguard.classfile.visitor.MemberVisitor;
import proguard.examples.TransformExample.MyTransformer;

public class TransformExampleDiffblueTest {
  /**
   * Test MyTransformer {@link MyTransformer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#methodsAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MyTransformer#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void proguard.examples.TransformExample$MyTransformer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  public void testMyTransformerVisitProgramClass_thenCallsMethodsAccept() {
    // Arrange
    MyTransformer myTransformer = new MyTransformer();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    myTransformer.visitProgramClass(programClass);

    // Assert
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }
}
