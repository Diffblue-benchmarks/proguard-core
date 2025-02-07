package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryClass;

class ProcessingFlagSetterDiffblueTest {
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
  @DisplayName(
      "Test visitAnyProcessable(Processable); when LibraryClass(); then LibraryClass() ProcessingFlags is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.ProcessingFlagSetter.visitAnyProcessable(proguard.util.Processable)"
  })
  void testVisitAnyProcessable_whenLibraryClass_thenLibraryClassProcessingFlagsIsOne() {
    // Arrange
    ProcessingFlagSetter processingFlagSetter = new ProcessingFlagSetter(1);
    LibraryClass processable = new LibraryClass();

    // Act
    processingFlagSetter.visitAnyProcessable(processable);

    // Assert
    assertEquals(1, processable.getProcessingFlags());
  }
}
