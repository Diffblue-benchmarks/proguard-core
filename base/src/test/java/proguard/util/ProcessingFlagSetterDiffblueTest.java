package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.LibraryClass;

public class ProcessingFlagSetterDiffblueTest {
  /**
   * Method under test:
   * {@link ProcessingFlagSetter#visitAnyProcessable(Processable)}
   */
  @Test
  public void testVisitAnyProcessable() {
    // Arrange
    ProcessingFlagSetter processingFlagSetter = new ProcessingFlagSetter(1);
    LibraryClass processable = new LibraryClass();

    // Act
    processingFlagSetter.visitAnyProcessable(processable);

    // Assert
    assertEquals(1, processable.getProcessingFlags());
  }
}
