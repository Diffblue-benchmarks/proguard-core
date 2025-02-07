package proguard.resources.file.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.resources.file.ResourceFile;

class MultiResourceFileVisitorDiffblueTest {
  /**
   * Test {@link MultiResourceFileVisitor#visitAnyResourceFile(ResourceFile)}.
   *
   * <ul>
   *   <li>When {@link ResourceFile} {@link ResourceFile#accept(ResourceFileVisitor)} does nothing.
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiResourceFileVisitor#visitAnyResourceFile(ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test visitAnyResourceFile(ResourceFile); when ResourceFile accept(ResourceFileVisitor) does nothing; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.visitor.MultiResourceFileVisitor.visitAnyResourceFile(proguard.resources.file.ResourceFile)"
  })
  void testVisitAnyResourceFile_whenResourceFileAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    MultiResourceFileVisitor multiResourceFileVisitor =
        new MultiResourceFileVisitor(new ResourceJavaReferenceCleaner());
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());

    // Act
    multiResourceFileVisitor.visitAnyResourceFile(resourceFile);

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
  }
}
