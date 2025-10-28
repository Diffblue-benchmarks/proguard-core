package proguard.classfile.visitor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.editor.AccessFixer;

public class VariableClassVisitorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariableClassVisitor#VariableClassVisitor()}
   *   <li>{@link VariableClassVisitor#setClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#getClassVisitor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    VariableClassVisitor actualVariableClassVisitor = new VariableClassVisitor();
    AccessFixer classVisitor = new AccessFixer();
    actualVariableClassVisitor.setClassVisitor(classVisitor);
    ClassVisitor actualClassVisitor = actualVariableClassVisitor.getClassVisitor();

    // Assert that nothing has changed
    assertTrue(actualClassVisitor instanceof AccessFixer);
    assertSame(classVisitor, actualClassVisitor);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariableClassVisitor#VariableClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#setClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#getClassVisitor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    VariableClassVisitor actualVariableClassVisitor = new VariableClassVisitor(new AccessFixer());
    AccessFixer classVisitor = new AccessFixer();
    actualVariableClassVisitor.setClassVisitor(classVisitor);
    ClassVisitor actualClassVisitor = actualVariableClassVisitor.getClassVisitor();

    // Assert that nothing has changed
    assertTrue(actualClassVisitor instanceof AccessFixer);
    assertSame(classVisitor, actualClassVisitor);
  }
}
