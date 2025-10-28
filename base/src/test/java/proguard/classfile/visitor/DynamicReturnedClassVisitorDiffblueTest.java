package proguard.classfile.visitor;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.AccessFixer;

public class DynamicReturnedClassVisitorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DynamicReturnedClassVisitor#DynamicReturnedClassVisitor(ClassVisitor)}
   *   <li>{@link DynamicReturnedClassVisitor#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicReturnedClassVisitor actualDynamicReturnedClassVisitor = new DynamicReturnedClassVisitor(new AccessFixer());
    LibraryClass clazz = new LibraryClass();
    actualDynamicReturnedClassVisitor.visitAnyConstant(clazz, new ClassConstant());

    // Assert that nothing has changed
    assertTrue(actualDynamicReturnedClassVisitor.classVisitor instanceof AccessFixer);
  }
}
