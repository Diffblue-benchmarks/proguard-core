package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;

public class ExceptionCounterDiffblueTest {
  /**
   * Test {@link ExceptionCounter#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}.
   *
   * <p>Method under test: {@link ExceptionCounter#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExceptionCounter.visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)"
  })
  public void testVisitExceptionInfo() {
    // Arrange
    ExceptionCounter exceptionCounter = new ExceptionCounter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    exceptionCounter.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    assertEquals(1, exceptionCounter.getCount());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExceptionCounter}
   *   <li>{@link ExceptionCounter#getCount()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExceptionCounter.<init>()", "int ExceptionCounter.getCount()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new ExceptionCounter()).getCount());
  }
}
