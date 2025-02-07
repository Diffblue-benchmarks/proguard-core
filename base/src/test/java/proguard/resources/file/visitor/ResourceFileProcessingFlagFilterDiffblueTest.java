package proguard.resources.file.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.resources.file.ResourceFile;

class ResourceFileProcessingFlagFilterDiffblueTest {
  /**
   * Test {@link ResourceFileProcessingFlagFilter#visitAnyResourceFile(ResourceFile)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceFileProcessingFlagFilter#visitAnyResourceFile(ResourceFile)}
   */
  @Test
  @DisplayName("Test visitAnyResourceFile(ResourceFile); then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.ResourceFileProcessingFlagFilter.visitAnyResourceFile(proguard.resources.file.ResourceFile)"
  })
  void testVisitAnyResourceFile_thenCallsAccept() {
    // Arrange
    ResourceFileProcessingFlagFilter resourceFileProcessingFlagFilter =
        new ResourceFileProcessingFlagFilter(
            0, Integer.MIN_VALUE, new ResourceJavaReferenceCleaner());
    ResourceFile resourceFile = mock(ResourceFile.class);
    when(resourceFile.getProcessingFlags()).thenReturn(1);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());

    // Act
    resourceFileProcessingFlagFilter.visitAnyResourceFile(resourceFile);

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getProcessingFlags();
  }
}
