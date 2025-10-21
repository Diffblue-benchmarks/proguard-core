package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.domain.taint.JvmInvokeTaintSink.Builder;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassSignature;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;

public class JvmInvokeTaintSinkDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmInvokeTaintSink Builder.build()",
    "Builder Builder.setCallMatcher(Predicate)",
    "Builder Builder.setIsValidForSource(Predicate)",
    "Builder Builder.setTakesArgs(Set)",
    "Builder Builder.setTakesGlobals(Set)",
    "Builder Builder.setTakesInstance(boolean)"
  })
  public void testBuilderBuild() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());

    // Act
    JvmInvokeTaintSink actualBuildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Assert
    assertTrue(actualBuildResult.signature instanceof MethodSignature);
    assertNull(actualBuildResult.isValidForSource);
    assertNull(actualBuildResult.callMatcher);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Builder.<init>(Signature)"})
  public void testBuilderNewBuilder() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_given42_thenReturnTakesGlobalsSizeIsTwo() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_given42_thenReturnTakesGlobalsSizeIsTwo2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("42");
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            true,
            takesArgs,
            takesGlobals,
            null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_given42_thenReturnTakesGlobalsSizeIsTwo3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenFoo_thenReturnMemoryLocationsSizeIsOne() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_givenFoo_thenReturnMemoryLocationsSizeIsOne2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            false,
            takesArgs,
            takesGlobals,
            null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenFoo_thenReturnMemoryLocationsSizeIsOne3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenFoo_whenHashSetAddFoo_thenReturnTakesArgsEmpty() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_givenFoo_whenHashSetAddFoo_thenReturnTakesArgsEmpty2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            true,
            takesArgs,
            takesGlobals,
            null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenFoo_whenHashSetAddFoo_thenReturnTakesArgsEmpty3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenOne_thenReturnTakesArgsSizeIsTwo() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_givenOne_thenReturnTakesArgsSizeIsTwo2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(1);
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            true,
            takesArgs,
            new HashSet<>(),
            null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenOne_thenReturnTakesArgsSizeIsTwo3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenTwo_thenReturnMemoryLocationsSizeIsOne() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_givenTwo_thenReturnMemoryLocationsSizeIsOne2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            false,
            takesArgs,
            new HashSet<>(),
            null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenTwo_thenReturnMemoryLocationsSizeIsOne3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenTwo_whenHashSetAddTwo_thenReturnTakesGlobalsEmpty() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_givenTwo_whenHashSetAddTwo_thenReturnTakesGlobalsEmpty2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);

    // Act
    JvmInvokeTaintSink actualJvmInvokeTaintSink =
        new JvmInvokeTaintSink(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            true,
            takesArgs,
            new HashSet<>(),
            null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_givenTwo_whenHashSetAddTwo_thenReturnTakesGlobalsEmpty3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_whenTrue_thenHashSetEmpty() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmInvokeTaintSink.<init>(Signature, Predicate, boolean, Set, Set, Predicate)"
  })
  public void testNewJvmInvokeTaintSink_whenTrue_thenHashSetEmpty2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    HashSet<String> takesGlobals = new HashSet<>();

    // Act
    new JvmInvokeTaintSink(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        null,
        true,
        takesArgs,
        takesGlobals,
        null);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmInvokeTaintSink.<init>(Signature, boolean, Set, Set)"})
  public void testNewJvmInvokeTaintSink_whenTrue_thenHashSetEmpty3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations_givenHashSetAddFoo_thenReturnSizeIsThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations_givenHashSetAddLeftParenthesis_thenReturnSizeIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations_givenHashSetAddOne_thenReturnSizeIsThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations_givenHashSetAddTwo_thenReturnSizeIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set JvmInvokeTaintSink.getMemoryLocations()"})
  public void testGetMemoryLocations_thenReturnSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge4() {
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
    assertFalse(
        jvmInvokeTaintSink.matchCfaEdge(
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge5() {
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
                    ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2,
                    1,
                    new BranchInstruction((byte) 'A', 1),
                    true,
                    true))));
  }

  /**
   * Test {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}.
   *
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge_givenClassSignatureWithClassName() {
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
   * <ul>
   *   <li>Given {@link ClassSignature#ClassSignature(String)} with {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#matchCfaEdge(JvmCfaEdge)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge_givenClassSignatureWithClassName2() {
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
                    caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true))));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmInvokeTaintSink.matchCfaEdge(JvmCfaEdge)"})
  public void testMatchCfaEdge_thenReturnTrue() {
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
   * Test {@link JvmInvokeTaintSink#equals(Object)}, and {@link JvmInvokeTaintSink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    Builder setIsValidForSourceResult2 =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult2 = setIsValidForSourceResult2.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult2 =
        setTakesArgsResult2.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    Builder setIsValidForSourceResult2 =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
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
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    Builder setTakesArgsResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null)
            .setTakesArgs(takesArgs);
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult2 = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult2 =
        setTakesArgsResult2.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<String> takesGlobals = new HashSet<>();
    takesGlobals.add("foo");
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    JvmInvokeTaintSink buildResult =
        setIsValidForSourceResult
            .setTakesArgs(new HashSet<>())
            .setTakesGlobals(takesGlobals)
            .setTakesInstance(true)
            .build();
    Builder setIsValidForSourceResult2 =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult = setIsValidForSourceResult2.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult2 =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();
    takesArgs.add(2);
    Builder setTakesArgsResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null)
            .setTakesArgs(takesArgs);
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(false).build();
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult2 = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmInvokeTaintSink.equals(Object)",
    "int JvmInvokeTaintSink.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString2() {
    // Arrange
    Builder setIsValidForSourceResult =
        (new Builder(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE))
            .setCallMatcher(null)
            .setIsValidForSource(null);
    Builder setTakesArgsResult = setIsValidForSourceResult.setTakesArgs(new HashSet<>());
    JvmInvokeTaintSink buildResult =
        setTakesArgsResult.setTakesGlobals(new HashSet<>()).setTakesInstance(true).build();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;, takes"
            + " instance, filtered by source null, filtered by call null",
        buildResult.toString());
  }

  /**
   * Test {@link JvmInvokeTaintSink#toString()}.
   *
   * <p>Method under test: {@link JvmInvokeTaintSink#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString_givenHashSetAddJvmInvokeTaintSink_thenReturnAString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString_givenHashSetAddTwo_thenReturnAString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString_thenReturnJvmInvokeTaintSinkJvmInvokeTaintSinkTakesInstance() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString_thenReturnJvmInvokeTaintSinkLJvmInvokeTaintSinkNullTakesInstance() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString_thenReturnJvmInvokeTaintSinkLNullTakesInstance() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JvmInvokeTaintSink.toString()"})
  public void testToString_thenReturnJvmInvokeTaintSinkNullTakesInstance() {
    // Arrange
    HashSet<Integer> takesArgs = new HashSet<>();

    // Act and Assert
    assertEquals(
        "[JvmInvokeTaintSink] null, takes instance",
        (new JvmInvokeTaintSink(null, true, takesArgs, new HashSet<>())).toString());
  }
}
