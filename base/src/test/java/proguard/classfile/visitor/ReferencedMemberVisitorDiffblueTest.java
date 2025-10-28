package proguard.classfile.visitor;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.AttributeSorter;

public class ReferencedMemberVisitorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReferencedMemberVisitor#ReferencedMemberVisitor(MemberVisitor)}
   *   <li>{@link ReferencedMemberVisitor#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReferencedMemberVisitor actualReferencedMemberVisitor = new ReferencedMemberVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    actualReferencedMemberVisitor.visitAnyConstant(clazz, new ClassConstant());

    // Assert that nothing has changed
    assertTrue(actualReferencedMemberVisitor.memberVisitor instanceof AttributeSorter);
  }
}
