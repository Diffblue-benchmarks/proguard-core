package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.domain.taint.TaintSource;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.Builder;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.ConcreteCall;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassSignature;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.exception.ProguardCoreException;

class JvmInvokeTaintSinkDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#setCallMatcher(Predicate)}
   *   <li>{@link Builder#setIsValidForSource(Predicate)}
   *   <li>{@link Builder#setTakesArgs(Set)}
   *   <li>{@link Builder#setTakesGlobals(Set)}
   *   <li>{@link Builder#setTakesInstance(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.build()",
    "proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.setCallMatcher(java.util.function.Predicate)",
    "proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.setIsValidForSource(java.util.function.Predicate)",
    "proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.setTakesArgs(java.util.Set)",
    "proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.setTakesGlobals(java.util.Set)",
    "proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.setTakesInstance(boolean)"
  })
  void testBuilderBuild() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());

    // Act
    JvmInvokeTaintSink actualBuildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Assert
    assertTrue(actualBuildResult.signature instanceof MethodSignature);
    assertEquals(1, actualBuildResult.getMemoryLocations().size());
    assertTrue(actualBuildResult.takesArgs.isEmpty());
    assertTrue(actualBuildResult.takesGlobals.isEmpty());
    assertTrue(actualBuildResult.takesInstance);
  }

  /**
   * Test Builder {@link Builder#Builder(Signature)}.
   *
   * <p>Method under test: {@link Builder#Builder(Signature)}
   */
  @Test
  @DisplayName("Test Builder new Builder(Signature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink$Builder.<init>(proguard.classfile.Signature)"
  })
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    Signature signature = actualBuilder.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("Class ClassLoader.findLoadedClass(String)", signature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        signature.getFqn());
    assertEquals("findLoadedClass", ((MethodSignature) signature).getMethodName());
    assertEquals("java.lang", signature.getExternalPackageName());
    assertEquals("java.lang", signature.getPackageName());
    assertEquals("java/lang/ClassLoader", signature.getClassName());
    assertNull(signature.getReferencedClass());
    assertNull(((MethodSignature) signature).getReferencedMethod());
    assertFalse(signature.isIncomplete());
    assertFalse(actualBuilder.takesInstance);
    assertTrue(actualBuilder.takesArgs.isEmpty());
    assertTrue(actualBuilder.takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link JvmInvokeTaintSink#takesGlobals} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); given '42'; then return takesGlobals size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_given42_thenReturnTakesGlobalsSizeIsTwo() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            takesArgs,
            takesGlobals);

    // Assert
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(2, stringSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link JvmInvokeTaintSink#takesGlobals} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); given '42'; then return takesGlobals size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_given42_thenReturnTakesGlobalsSizeIsTwo2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            isValidForSource,
            true,
            takesArgs,
            takesGlobals,
            mock(Predicate.class));

    // Assert
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(2, stringSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@link JvmInvokeTaintSink#takesGlobals} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); given '42'; then return takesGlobals size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_given42_thenReturnTakesGlobalsSizeIsTwo3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(2, stringSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(stringSet.contains("42"));
    assertTrue(stringSet.contains("foo"));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return MemoryLocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); given 'foo'; then return MemoryLocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenFoo_thenReturnMemoryLocationsSizeIsOne() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            false,
            takesArgs,
            takesGlobals);

    // Assert
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(stringSet.contains("foo"));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return MemoryLocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); given 'foo'; then return MemoryLocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_givenFoo_thenReturnMemoryLocationsSizeIsOne2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            isValidForSource,
            false,
            takesArgs,
            takesGlobals,
            mock(Predicate.class));

    // Assert
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(stringSet.contains("foo"));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return MemoryLocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); given 'foo'; then return MemoryLocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenFoo_thenReturnMemoryLocationsSizeIsOne3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, false, takesArgs, takesGlobals);

    // Assert
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(stringSet.contains("foo"));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@link JvmInvokeTaintSink#takesArgs} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); given 'foo'; when HashSet() add 'foo'; then return takesArgs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenFoo_whenHashSetAddFoo_thenReturnTakesArgsEmpty() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            takesArgs,
            takesGlobals);

    // Assert
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@link JvmInvokeTaintSink#takesArgs} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); given 'foo'; when HashSet() add 'foo'; then return takesArgs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_givenFoo_whenHashSetAddFoo_thenReturnTakesArgsEmpty2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            isValidForSource,
            true,
            takesArgs,
            takesGlobals,
            mock(Predicate.class));

    // Assert
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@link JvmInvokeTaintSink#takesArgs} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); given 'foo'; when HashSet() add 'foo'; then return takesArgs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenFoo_whenHashSetAddFoo_thenReturnTakesArgsEmpty3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    Set<String> stringSet = actualJvmInvokeTaintSink.takesGlobals;
    assertEquals(1, stringSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(stringSet.contains("foo"));
    assertTrue(actualJvmInvokeTaintSink.takesArgs.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@link JvmInvokeTaintSink#takesArgs} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); given one; then return takesArgs size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenOne_thenReturnTakesArgsSizeIsTwo() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);

    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            takesArgs,
            new HashSet<>());

    // Assert
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(2, integerSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@link JvmInvokeTaintSink#takesArgs} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); given one; then return takesArgs size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_givenOne_thenReturnTakesArgsSizeIsTwo2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);

    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            isValidForSource,
            true,
            takesArgs,
            new HashSet<>(),
            mock(Predicate.class));

    // Assert
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(2, integerSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@link JvmInvokeTaintSink#takesArgs} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); given one; then return takesArgs size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenOne_thenReturnTakesArgsSizeIsTwo3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            takesArgs,
            new HashSet<>());

    // Assert
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(2, integerSet.size());
    assertEquals(3, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(integerSet.contains(1));
    assertTrue(integerSet.contains(2));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return MemoryLocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); given two; then return MemoryLocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenTwo_thenReturnMemoryLocationsSizeIsOne() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);

    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            false,
            takesArgs,
            new HashSet<>());

    // Assert
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(integerSet.contains(2));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return MemoryLocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); given two; then return MemoryLocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_givenTwo_thenReturnMemoryLocationsSizeIsOne2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);

    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            isValidForSource,
            false,
            takesArgs,
            new HashSet<>(),
            mock(Predicate.class));

    // Assert
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(integerSet.contains(2));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return MemoryLocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); given two; then return MemoryLocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenTwo_thenReturnMemoryLocationsSizeIsOne3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            false,
            takesArgs,
            new HashSet<>());

    // Assert
    assertEquals(1, actualJvmInvokeTaintSink.getMemoryLocations().size());
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertFalse(actualJvmInvokeTaintSink.takesInstance);
    assertTrue(integerSet.contains(2));
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then return {@link JvmInvokeTaintSink#takesGlobals} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); given two; when HashSet() add two; then return takesGlobals Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenTwo_whenHashSetAddTwo_thenReturnTakesGlobalsEmpty() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);

    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            callMatcher,
            true,
            takesArgs,
            new HashSet<>());

    // Assert
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then return {@link JvmInvokeTaintSink#takesGlobals} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); given two; when HashSet() add two; then return takesGlobals Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_givenTwo_whenHashSetAddTwo_thenReturnTakesGlobalsEmpty2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);

    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            isValidForSource,
            true,
            takesArgs,
            new HashSet<>(),
            mock(Predicate.class));

    // Assert
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then return {@link JvmInvokeTaintSink#takesGlobals} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); given two; when HashSet() add two; then return takesGlobals Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_givenTwo_whenHashSetAddTwo_thenReturnTakesGlobalsEmpty3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            takesArgs,
            new HashSet<>());

    // Assert
    Set<Integer> integerSet = actualJvmInvokeTaintSink.takesArgs;
    assertEquals(1, integerSet.size());
    assertEquals(2, actualJvmInvokeTaintSink.getMemoryLocations().size());
    assertTrue(integerSet.contains(2));
    assertTrue(actualJvmInvokeTaintSink.takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set); when 'true'; then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_whenTrue_thenHashSetEmpty() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        callMatcher,
        true,
        takesArgs,
        takesGlobals);

    // Assert
    assertTrue(takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set,
   * Predicate)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, Predicate,
   * boolean, Set, Set, Predicate)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, Predicate, boolean, Set, Set, Predicate); when 'true'; then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, java.util.function.Predicate, boolean, java.util.Set, java.util.Set, java.util.function.Predicate)"
  })
  void testNewJvmInvokeTaintSink_whenTrue_thenHashSetEmpty2() {
    // Arrange
    Predicate<TaintSource> isValidForSource = mock(Predicate.class);
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        isValidForSource,
        true,
        takesArgs,
        takesGlobals,
        mock(Predicate.class));

    // Assert
    assertTrue(takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set, Set)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#JvmInvokeTaintSink(Signature, boolean, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new JvmInvokeTaintSink(Signature, boolean, Set, Set); when 'true'; then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.<init>(proguard.classfile.Signature, boolean, java.util.Set, java.util.Set)"
  })
  void testNewJvmInvokeTaintSink_whenTrue_thenHashSetEmpty3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, true, takesArgs, takesGlobals);

    // Assert
    assertTrue(takesGlobals.isEmpty());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        1,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2, true, takesArgs, new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        1,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASS_GET_METHOD_SIGNATURE, true, takesArgs, new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        2,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASS_GET_METHOD_SIGNATURE, true, takesArgs, new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations4() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        1,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                false,
                takesArgs,
                new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations(); given HashSet() add 'foo'; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations_givenHashSetAddFoo_thenReturnSizeIsThree() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");
    takesGlobals.add("(");

    // Act and Assert
    assertEquals(
        3,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                new HashSet<>(),
                takesGlobals))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code (}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations(); given HashSet() add '('; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations_givenHashSetAddLeftParenthesis_thenReturnSizeIsTwo() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("(");

    // Act and Assert
    assertEquals(
        2,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                new HashSet<>(),
                takesGlobals))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add one.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations(); given HashSet() add one; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations_givenHashSetAddOne_thenReturnSizeIsThree() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        3,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                takesArgs,
                new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add two.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations(); given HashSet() add two; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations_givenHashSetAddTwo_thenReturnSizeIsTwo() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        2,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                takesArgs,
                new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#getMemoryLocations()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#getMemoryLocations()}
   */
  @Test
  @DisplayName("Test getMemoryLocations(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.getMemoryLocations()"
  })
  void testGetMemoryLocations_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        1,
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                takesArgs,
                new HashSet<>()))
            .getMemoryLocations()
            .size());
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            takesArgs,
            new HashSet<>());

    // Act and Assert
    assertFalse(jvmInvokeTaintSink.matchCfaEdge(new JvmAssumeExceptionCfaEdge(true, 1)));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        jvmInvokeTaintSink.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASS_FOR_NAME_SIGNATURE, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        jvmInvokeTaintSink.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge4() {
    // Arrange
    ClassSignature signature = new ClassSignature("Class Name");
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink =
        new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        jvmInvokeTaintSink.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge5() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        buildResult.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge6() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(new ClassSignature("Class Name")))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertFalse(
        buildResult.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge7() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod();

    // Act and Assert
    assertFalse(
        buildResult.matchCfaEdge(
            new JvmCallCfaEdge(
                new ConcreteCall(
                    caller,
                    targetClass,
                    target,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName(
      "Test matchCfaEdge(JvmCfaEdge); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    when(callMatcher.test(Mockito.<Call>any())).thenReturn(false);
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(callMatcher)
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    boolean actualMatchCfaEdgeResult =
        buildResult.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true)));

    // Assert
    verify(callMatcher).test(isA(Call.class));
    assertFalse(actualMatchCfaEdgeResult);
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName(
      "Test matchCfaEdge(JvmCfaEdge); given Predicate test(Object) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge_givenPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);
    when(callMatcher.test(Mockito.<Call>any())).thenReturn(true);
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(callMatcher)
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    boolean actualMatchCfaEdgeResult =
        buildResult.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true)));

    // Assert
    verify(callMatcher).test(isA(Call.class));
    assertTrue(actualMatchCfaEdgeResult);
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge_thenReturnTrue() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    JvmInvokeTaintSink jvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            true,
            takesArgs,
            new HashSet<>());
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertTrue(
        jvmInvokeTaintSink.matchCfaEdge(
            new JvmCallCfaEdge(
                new SymbolicCall(
                    caller,
                    ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @DisplayName("Test matchCfaEdge(JvmCfaEdge); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.matchCfaEdge(proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge)"
  })
  void testMatchCfaEdge_thenThrowProguardCoreException() {
    // Arrange
    Predicate<Call> callMatcher = mock(Predicate.class);

    ProguardCoreException.Builder builder =
        new ProguardCoreException.Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    when(callMatcher.test(Mockito.<Call>any())).thenThrow(buildResult);
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(callMatcher)
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult2 =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            buildResult2.matchCfaEdge(
                new JvmCallCfaEdge(
                    new SymbolicCall(
                        caller,
                        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                        1,
                        new BranchInstruction((byte) 'A', 1),
                        true,
                        true))));
    verify(callMatcher).test(isA(Call.class));
  }

  /**
   * Test {@link JvmInvokeTaintSink#equals(Object)}, and {@link JvmInvokeTaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmInvokeTaintSink#equals(Object)}
   *   <li>{@link JvmInvokeTaintSink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link JvmInvokeTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    Builder setIsValidForSourceResult2 =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult2 = setIsValidForSourceResult2.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult2 =
        setTakesArgsResult2.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link JvmInvokeTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link JvmInvokeTaintSink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(mock(Predicate.class))
            .setIsValidForSource(mock(Predicate.class));
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to JvmInvokeTaintSink");
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance",
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                takesArgs,
                new HashSet<>()))
            .toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString2() {
    // Arrange
    FieldSignature signature =
        new FieldSignature(
            "[JvmInvokeTaintSink] ", "[JvmInvokeTaintSink] ", "[JvmInvokeTaintSink] ");

    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] L[JvmInvokeTaintSink] ;[JvmInvokeTaintSink] , takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString3() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " args (2)",
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                false,
                takesArgs,
                new HashSet<>()))
            .toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code [JvmInvokeTaintSink]}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString(); given HashSet() add '[JvmInvokeTaintSink]'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString_givenHashSetAddJvmInvokeTaintSink_thenReturnAString() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("[JvmInvokeTaintSink] ");

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, takes globals ([JvmInvokeTaintSink] )",
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                new HashSet<>(),
                takesGlobals))
            .toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add two.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString(); given HashSet() add two; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString_givenHashSetAddTwo_thenReturnAString() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, takes args (2)",
        (new JvmInvokeTaintSink(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
                true,
                takesArgs,
                new HashSet<>()))
            .toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [JvmInvokeTaintSink] [JvmInvokeTaintSink] , takes instance}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return '[JvmInvokeTaintSink] [JvmInvokeTaintSink] , takes instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString_thenReturnJvmInvokeTaintSinkJvmInvokeTaintSinkTakesInstance() {
    // Arrange
    ClassSignature signature = new ClassSignature("[JvmInvokeTaintSink] ");
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] [JvmInvokeTaintSink] , takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [JvmInvokeTaintSink] L[JvmInvokeTaintSink] ;?null, takes instance}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return '[JvmInvokeTaintSink] L[JvmInvokeTaintSink] ;?null, takes instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString_thenReturnJvmInvokeTaintSinkLJvmInvokeTaintSinkNullTakesInstance() {
    // Arrange
    MethodSignature signature = new MethodSignature("[JvmInvokeTaintSink] ");
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] L[JvmInvokeTaintSink] ;?null, takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [JvmInvokeTaintSink] L?;?null, takes instance}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[JvmInvokeTaintSink] L?;?null, takes instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString_thenReturnJvmInvokeTaintSinkLNullTakesInstance() {
    // Arrange
    MethodSignature signature = new MethodSignature(new LibraryClass());
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] L?;?null, takes instance",
        (new JvmInvokeTaintSink(signature, true, takesArgs, new HashSet<>())).toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [JvmInvokeTaintSink] null, takes instance}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[JvmInvokeTaintSink] null, takes instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.toString()"
  })
  void testToString_thenReturnJvmInvokeTaintSinkNullTakesInstance() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] null, takes instance",
        (new JvmInvokeTaintSink(null, true, takesArgs, new HashSet<>())).toString());
  }
}
