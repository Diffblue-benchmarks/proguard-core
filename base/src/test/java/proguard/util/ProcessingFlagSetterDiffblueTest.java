package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;

public class ProcessingFlagSetterDiffblueTest {
  /**
   * Test {@link ProcessingFlagSetter#visitAnyProcessable(Processable)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then {@link LibraryClass#LibraryClass()} ProcessingFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link ProcessingFlagSetter#visitAnyProcessable(Processable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProcessingFlagSetter.visitAnyProcessable(Processable)"})
  public void testVisitAnyProcessable_whenLibraryClass_thenLibraryClassProcessingFlagsIsOne() {
    // Arrange
    ProcessingFlagSetter processingFlagSetter = new ProcessingFlagSetter(1);
    LibraryClass processable = new LibraryClass();

    // Act
    processingFlagSetter.visitAnyProcessable(processable);

    // Assert
    assertEquals(1, processable.getProcessingFlags());
  }
}
