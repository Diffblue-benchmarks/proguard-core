package proguard.classfile.visitor;

import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.AccessFixer;

public class DynamicReturnedClassVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicReturnedClassVisitor#DynamicReturnedClassVisitor(ClassVisitor)}
   *   <li>{@link DynamicReturnedClassVisitor#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DynamicReturnedClassVisitor.<init>(ClassVisitor)",
    "void DynamicReturnedClassVisitor.visitAnyConstant(Clazz, Constant)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicReturnedClassVisitor actualDynamicReturnedClassVisitor =
        new DynamicReturnedClassVisitor(new AccessFixer());
    LibraryClass clazz = new LibraryClass();
    actualDynamicReturnedClassVisitor.visitAnyConstant(clazz, new ClassConstant());

    // Assert
    assertTrue(actualDynamicReturnedClassVisitor.classVisitor instanceof AccessFixer);
  }
}
