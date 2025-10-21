package proguard.classfile.visitor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.editor.AttributeSorter;

public class VariableMemberVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableMemberVisitor#VariableMemberVisitor()}
   *   <li>{@link VariableMemberVisitor#setMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#getMemberVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableMemberVisitor.<init>()",
    "void VariableMemberVisitor.<init>(MemberVisitor)",
    "MemberVisitor VariableMemberVisitor.getMemberVisitor()",
    "void VariableMemberVisitor.setMemberVisitor(MemberVisitor)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    VariableMemberVisitor actualVariableMemberVisitor = new VariableMemberVisitor();
    AttributeSorter memberVisitor = new AttributeSorter();
    actualVariableMemberVisitor.setMemberVisitor(memberVisitor);
    MemberVisitor actualMemberVisitor = actualVariableMemberVisitor.getMemberVisitor();

    // Assert
    assertTrue(actualMemberVisitor instanceof AttributeSorter);
    assertSame(memberVisitor, actualMemberVisitor);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link AttributeSorter} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableMemberVisitor#VariableMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#setMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#getMemberVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableMemberVisitor.<init>()",
    "void VariableMemberVisitor.<init>(MemberVisitor)",
    "MemberVisitor VariableMemberVisitor.getMemberVisitor()",
    "void VariableMemberVisitor.setMemberVisitor(MemberVisitor)"
  })
  public void testGettersAndSetters_whenAttributeSorter() {
    // Arrange and Act
    VariableMemberVisitor actualVariableMemberVisitor =
        new VariableMemberVisitor(new AttributeSorter());
    AttributeSorter memberVisitor = new AttributeSorter();
    actualVariableMemberVisitor.setMemberVisitor(memberVisitor);
    MemberVisitor actualMemberVisitor = actualVariableMemberVisitor.getMemberVisitor();

    // Assert
    assertTrue(actualMemberVisitor instanceof AttributeSorter);
    assertSame(memberVisitor, actualMemberVisitor);
  }
}
