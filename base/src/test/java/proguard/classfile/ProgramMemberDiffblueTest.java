package proguard.classfile;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProgramMemberDiffblueTest {
  /**
   * Method under test: {@link ProgramMember#getAccessFlags()}
   */
  @Test
  public void testGetAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new ProgramField()).getAccessFlags());
  }
}
