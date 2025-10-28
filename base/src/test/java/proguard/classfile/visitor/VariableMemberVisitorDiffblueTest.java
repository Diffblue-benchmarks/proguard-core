package proguard.classfile.visitor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.editor.AttributeSorter;

public class VariableMemberVisitorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariableMemberVisitor#VariableMemberVisitor()}
   *   <li>{@link VariableMemberVisitor#setMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#getMemberVisitor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    VariableMemberVisitor actualVariableMemberVisitor = new VariableMemberVisitor();
    AttributeSorter memberVisitor = new AttributeSorter();
    actualVariableMemberVisitor.setMemberVisitor(memberVisitor);
    MemberVisitor actualMemberVisitor = actualVariableMemberVisitor.getMemberVisitor();

    // Assert that nothing has changed
    assertTrue(actualMemberVisitor instanceof AttributeSorter);
    assertSame(memberVisitor, actualMemberVisitor);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VariableMemberVisitor#VariableMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#setMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#getMemberVisitor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    VariableMemberVisitor actualVariableMemberVisitor = new VariableMemberVisitor(new AttributeSorter());
    AttributeSorter memberVisitor = new AttributeSorter();
    actualVariableMemberVisitor.setMemberVisitor(memberVisitor);
    MemberVisitor actualMemberVisitor = actualVariableMemberVisitor.getMemberVisitor();

    // Assert that nothing has changed
    assertTrue(actualMemberVisitor instanceof AttributeSorter);
    assertSame(memberVisitor, actualMemberVisitor);
  }
}
