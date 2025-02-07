package proguard.resources.file;

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
import proguard.resources.file.visitor.ResourceFileVisitor;
import proguard.resources.file.visitor.ResourceJavaReferenceCleaner;

class FilePoolDiffblueTest {
  /**
   * Test {@link FilePool#resourceFileAccept(String, ResourceFileVisitor)}.
   *
   * <ul>
   *   <li>Given {@link ResourceFile} {@link ResourceFile#accept(ResourceFileVisitor)} does nothing.
   *   <li>Then calls {@link ResourceFile#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link FilePool#resourceFileAccept(String, ResourceFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test resourceFileAccept(String, ResourceFileVisitor); given ResourceFile accept(ResourceFileVisitor) does nothing; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.file.FilePool.resourceFileAccept(java.lang.String, proguard.resources.file.visitor.ResourceFileVisitor)"
  })
  void testResourceFileAccept_givenResourceFileAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ResourceFile resourceFile = mock(ResourceFile.class);
    doNothing().when(resourceFile).accept(Mockito.<ResourceFileVisitor>any());
    when(resourceFile.getFileName()).thenReturn("foo.txt");
    ResourceFilePool resourceFilePool = new ResourceFilePool(resourceFile);

    // Act
    resourceFilePool.resourceFileAccept("foo.txt", new ResourceJavaReferenceCleaner());

    // Assert
    verify(resourceFile).accept(isA(ResourceFileVisitor.class));
    verify(resourceFile).getFileName();
  }
}
