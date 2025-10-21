package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramField;

public class ClassMemberSorterDiffblueTest {
  /**
   * Test {@link ClassMemberSorter#compare(Object, Object)}.
   *
   * <p>Method under test: {@link ClassMemberSorter#compare(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ClassMemberSorter.compare(Object, Object)"})
  public void testCompare() {
    // Arrange
    ClassMemberSorter classMemberSorter = new ClassMemberSorter();
    ProgramField programField = new ProgramField();

    // Act and Assert
    assertEquals(0, classMemberSorter.compare(programField, new ProgramField()));
  }
}
