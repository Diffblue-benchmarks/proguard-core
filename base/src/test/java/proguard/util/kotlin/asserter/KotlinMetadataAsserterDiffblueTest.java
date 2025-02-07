package proguard.util.kotlin.asserter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.util.WarningLogger;
import proguard.classfile.visitor.ClassVisitor;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;
import proguard.resources.file.ResourceFile;
import proguard.resources.file.ResourceFilePool;
import proguard.resources.file.visitor.ResourceFileVisitor;

class KotlinMetadataAsserterDiffblueTest {
  /**
   * Test {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool, ClassPool,
   * ResourceFilePool)}.
   *
   * <ul>
   *   <li>Then calls {@link ResourceFilePool#resourceFilesAccept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool,
   * ClassPool, ResourceFilePool)}
   */
  @Test
  @DisplayName(
      "Test execute(WarningLogger, ClassPool, ClassPool, ResourceFilePool); then calls resourceFilesAccept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.KotlinMetadataAsserter.execute(proguard.classfile.util.WarningLogger, proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.resources.file.ResourceFilePool)"
  })
  void testExecute_thenCallsResourceFilesAccept() {
    // Arrange
    KotlinMetadataAsserter kotlinMetadataAsserter = new KotlinMetadataAsserter();
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());
    ClassPool libraryClassPool = mock(ClassPool.class);
    doNothing().when(libraryClassPool).classesAccept(Mockito.<ClassVisitor>any());
    ResourceFilePool resourceFilePool = mock(ResourceFilePool.class);
    doNothing().when(resourceFilePool).resourceFilesAccept(Mockito.<ResourceFileVisitor>any());

    // Act
    kotlinMetadataAsserter.execute(
        warningLogger, programClassPool, libraryClassPool, resourceFilePool);

    // Assert
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
    verify(libraryClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
    verify(resourceFilePool).resourceFilesAccept(isA(ResourceFileVisitor.class));
  }

  /**
   * Test {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool, ClassPool,
   * ResourceFilePool)}.
   *
   * <ul>
   *   <li>When {@link KotlinConstants#dummyClassPool}.
   *   <li>Then calls {@link ClassPool#classesAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool,
   * ClassPool, ResourceFilePool)}
   */
  @Test
  @DisplayName(
      "Test execute(WarningLogger, ClassPool, ClassPool, ResourceFilePool); when dummyClassPool; then calls classesAccept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.KotlinMetadataAsserter.execute(proguard.classfile.util.WarningLogger, proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.resources.file.ResourceFilePool)"
  })
  void testExecute_whenDummyClassPool_thenCallsClassesAccept() {
    // Arrange
    KotlinMetadataAsserter kotlinMetadataAsserter = new KotlinMetadataAsserter();
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    kotlinMetadataAsserter.execute(
        warningLogger, programClassPool, KotlinConstants.dummyClassPool, new ResourceFilePool());

    // Assert
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool, ClassPool,
   * ResourceFilePool)}.
   *
   * <ul>
   *   <li>When {@link ResourceFilePool#ResourceFilePool()}.
   *   <li>Then calls {@link ClassPool#classesAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool,
   * ClassPool, ResourceFilePool)}
   */
  @Test
  @DisplayName(
      "Test execute(WarningLogger, ClassPool, ClassPool, ResourceFilePool); when ResourceFilePool(); then calls classesAccept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.KotlinMetadataAsserter.execute(proguard.classfile.util.WarningLogger, proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.resources.file.ResourceFilePool)"
  })
  void testExecute_whenResourceFilePool_thenCallsClassesAccept() {
    // Arrange
    KotlinMetadataAsserter kotlinMetadataAsserter = new KotlinMetadataAsserter();
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());
    ClassPool libraryClassPool = mock(ClassPool.class);
    doNothing().when(libraryClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    kotlinMetadataAsserter.execute(
        warningLogger, programClassPool, libraryClassPool, new ResourceFilePool());

    // Assert
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
    verify(libraryClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool, ClassPool,
   * ResourceFilePool)}.
   *
   * <ul>
   *   <li>When {@link ResourceFile#ResourceFile(String, long)} with fileName is {@code foo.txt} and
   *       fileSize is three.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataAsserter#execute(WarningLogger, ClassPool,
   * ClassPool, ResourceFilePool)}
   */
  @Test
  @DisplayName(
      "Test execute(WarningLogger, ClassPool, ClassPool, ResourceFilePool); when ResourceFile(String, long) with fileName is 'foo.txt' and fileSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.KotlinMetadataAsserter.execute(proguard.classfile.util.WarningLogger, proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.resources.file.ResourceFilePool)"
  })
  void testExecute_whenResourceFileWithFileNameIsFooTxtAndFileSizeIsThree() {
    // Arrange
    KotlinMetadataAsserter kotlinMetadataAsserter = new KotlinMetadataAsserter();
    WarningLogger warningLogger = new WarningLogger(ReflectiveModel.log);
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());
    ClassPool libraryClassPool = mock(ClassPool.class);
    doNothing().when(libraryClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    kotlinMetadataAsserter.execute(
        warningLogger,
        programClassPool,
        libraryClassPool,
        new ResourceFilePool(new ResourceFile("foo.txt", 3L)));

    // Assert
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
    verify(libraryClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
  }
}
