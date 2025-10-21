package proguard.preverify;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.exception.ProguardCoreException;

public class CodeSubroutineInlinerDiffblueTest {
  /**
   * Test {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeSubroutineInliner.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute() throws UnsupportedEncodingException {
    // Arrange
    CodeSubroutineInliner codeSubroutineInliner = new CodeSubroutineInliner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            codeSubroutineInliner.visitCodeAttribute(
                clazz, method, new CodeAttribute(1, 3, 3, -1, "AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeSubroutineInliner.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute_whenA_thenThrowProguardCoreException() {
    // Arrange
    CodeSubroutineInliner codeSubroutineInliner = new CodeSubroutineInliner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            codeSubroutineInliner.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }
}
