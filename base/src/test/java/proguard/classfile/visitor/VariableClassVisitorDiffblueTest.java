package proguard.classfile.visitor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.editor.AccessFixer;

public class VariableClassVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableClassVisitor#VariableClassVisitor()}
   *   <li>{@link VariableClassVisitor#setClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#getClassVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableClassVisitor.<init>()",
    "void VariableClassVisitor.<init>(ClassVisitor)",
    "ClassVisitor VariableClassVisitor.getClassVisitor()",
    "void VariableClassVisitor.setClassVisitor(ClassVisitor)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    VariableClassVisitor actualVariableClassVisitor = new VariableClassVisitor();
    AccessFixer classVisitor = new AccessFixer();
    actualVariableClassVisitor.setClassVisitor(classVisitor);
    ClassVisitor actualClassVisitor = actualVariableClassVisitor.getClassVisitor();

    // Assert
    assertTrue(actualClassVisitor instanceof AccessFixer);
    assertSame(classVisitor, actualClassVisitor);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link AccessFixer} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableClassVisitor#VariableClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#setClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#getClassVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableClassVisitor.<init>()",
    "void VariableClassVisitor.<init>(ClassVisitor)",
    "ClassVisitor VariableClassVisitor.getClassVisitor()",
    "void VariableClassVisitor.setClassVisitor(ClassVisitor)"
  })
  public void testGettersAndSetters_whenAccessFixer() {
    // Arrange and Act
    VariableClassVisitor actualVariableClassVisitor = new VariableClassVisitor(new AccessFixer());
    AccessFixer classVisitor = new AccessFixer();
    actualVariableClassVisitor.setClassVisitor(classVisitor);
    ClassVisitor actualClassVisitor = actualVariableClassVisitor.getClassVisitor();

    // Assert
    assertTrue(actualClassVisitor instanceof AccessFixer);
    assertSame(classVisitor, actualClassVisitor);
  }
}
