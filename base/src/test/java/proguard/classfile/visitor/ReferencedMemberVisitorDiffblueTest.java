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
import proguard.classfile.editor.AttributeSorter;

public class ReferencedMemberVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferencedMemberVisitor#ReferencedMemberVisitor(MemberVisitor)}
   *   <li>{@link ReferencedMemberVisitor#visitAnyConstant(Clazz, Constant)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ReferencedMemberVisitor.<init>(MemberVisitor)",
    "void ReferencedMemberVisitor.visitAnyConstant(Clazz, Constant)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ReferencedMemberVisitor actualReferencedMemberVisitor =
        new ReferencedMemberVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    actualReferencedMemberVisitor.visitAnyConstant(clazz, new ClassConstant());

    // Assert
    assertTrue(actualReferencedMemberVisitor.memberVisitor instanceof AttributeSorter);
  }
}
