package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramField;

class ClassMemberSorterDiffblueTest {
  /**
   * Test {@link ClassMemberSorter#compare(Object, Object)}.
   *
   * <p>Method under test: {@link ClassMemberSorter#compare(Object, Object)}
   */
  @Test
  @DisplayName("Test compare(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.ClassMemberSorter.compare(java.lang.Object, java.lang.Object)"
  })
  void testCompare() {
    // Arrange
    ClassMemberSorter classMemberSorter = new ClassMemberSorter();
    ProgramField programField = new ProgramField();

    // Act and Assert
    assertEquals(0, classMemberSorter.compare(programField, new ProgramField()));
  }
}
