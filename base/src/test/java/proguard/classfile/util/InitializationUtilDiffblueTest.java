package proguard.classfile.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassVisitor;

class InitializationUtilDiffblueTest {
  /**
   * Test {@link InitializationUtil#initialize(ClassPool, ClassPool, WarningPrinter)} with {@code
   * programClassPool}, {@code libraryClassPool}, {@code warningPrinter}.
   *
   * <p>Method under test: {@link InitializationUtil#initialize(ClassPool, ClassPool,
   * WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test initialize(ClassPool, ClassPool, WarningPrinter) with 'programClassPool', 'libraryClassPool', 'warningPrinter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InitializationUtil.initialize(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter)"
  })
  void testInitializeWithProgramClassPoolLibraryClassPoolWarningPrinter() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    InitializationUtil.initialize(
        programClassPool,
        KotlinConstants.dummyClassPool,
        new WarningPrinter(new PrintWriter(new StringWriter())));

    // Assert
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
    verify(programClassPool, atLeast(1)).getClass(eq("java/lang/Object"));
  }

  /**
   * Test {@link InitializationUtil#initialize(ClassPool, ClassPool, WarningPrinter)} with {@code
   * programClassPool}, {@code libraryClassPool}, {@code warningPrinter}.
   *
   * <p>Method under test: {@link InitializationUtil#initialize(ClassPool, ClassPool,
   * WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test initialize(ClassPool, ClassPool, WarningPrinter) with 'programClassPool', 'libraryClassPool', 'warningPrinter'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InitializationUtil.initialize(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter)"
  })
  void testInitializeWithProgramClassPoolLibraryClassPoolWarningPrinter2() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());
    ClassPool libraryClassPool = mock(ClassPool.class);
    doNothing().when(libraryClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    InitializationUtil.initialize(
        programClassPool,
        libraryClassPool,
        new WarningPrinter(new PrintWriter(new StringWriter())));

    // Assert
    verify(libraryClassPool).classesAccept(isA(ClassVisitor.class));
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link InitializationUtil#initialize(ClassPool, ClassPool)} with {@code programClassPool},
   * {@code libraryClassPool}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPool#classesAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link InitializationUtil#initialize(ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test initialize(ClassPool, ClassPool) with 'programClassPool', 'libraryClassPool'; then calls classesAccept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InitializationUtil.initialize(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testInitializeWithProgramClassPoolLibraryClassPool_thenCallsClassesAccept() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());
    ClassPool libraryClassPool = mock(ClassPool.class);
    doNothing().when(libraryClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    InitializationUtil.initialize(programClassPool, libraryClassPool);

    // Assert
    verify(libraryClassPool).classesAccept(isA(ClassVisitor.class));
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link InitializationUtil#initialize(ClassPool, ClassPool)} with {@code programClassPool},
   * {@code libraryClassPool}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPool#getClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InitializationUtil#initialize(ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test initialize(ClassPool, ClassPool) with 'programClassPool', 'libraryClassPool'; then calls getClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.InitializationUtil.initialize(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testInitializeWithProgramClassPoolLibraryClassPool_thenCallsGetClass() {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    when(programClassPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    InitializationUtil.initialize(programClassPool, KotlinConstants.dummyClassPool);

    // Assert
    verify(programClassPool, atLeast(1)).classesAccept(Mockito.<ClassVisitor>any());
    verify(programClassPool, atLeast(1)).getClass(eq("java/lang/Object"));
  }
}
