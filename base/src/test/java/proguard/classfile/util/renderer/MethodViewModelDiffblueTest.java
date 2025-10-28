package proguard.classfile.util.renderer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;

public class MethodViewModelDiffblueTest {
  /**
   * Method under test: {@link MethodViewModel#render(Clazz, Method)}
   */
  @Test
  public void testRender() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    MethodViewModel actualRenderResult = MethodViewModel.render(clazz, method);

    // Assert
    assertNull(actualRenderResult.processingInfo);
    assertTrue(actualRenderResult.processingFlags.isEmpty());
    MemberViewModel.Pair<Clazz, Member> pair = actualRenderResult.model;
    assertSame(clazz, pair.key);
    assertSame(method, pair.value);
  }
}
