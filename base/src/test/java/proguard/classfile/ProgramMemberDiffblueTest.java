package proguard.classfile;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProgramMemberDiffblueTest {
  /**
   * Test {@link ProgramMember#getAccessFlags()}.
   *
   * <p>Method under test: {@link ProgramMember#getAccessFlags()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ProgramMember.getAccessFlags()"})
  public void testGetAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new ProgramField()).getAccessFlags());
  }
}
