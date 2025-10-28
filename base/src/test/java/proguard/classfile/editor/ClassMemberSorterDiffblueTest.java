package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.ProgramField;

public class ClassMemberSorterDiffblueTest {
  /**
   * Method under test: {@link ClassMemberSorter#compare(Object, Object)}
   */
  @Test
  public void testCompare() {
    // Arrange
    ClassMemberSorter classMemberSorter = new ClassMemberSorter();
    ProgramField programField = new ProgramField();

    // Act and Assert
    assertEquals(0, classMemberSorter.compare(programField, new ProgramField()));
  }
}
