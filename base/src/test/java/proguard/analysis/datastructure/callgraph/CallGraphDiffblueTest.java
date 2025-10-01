package proguard.analysis.datastructure.callgraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.kotlin.KotlinConstants;

class CallGraphDiffblueTest {
  /**
   * Test {@link CallGraph#CallGraph()}.
   *
   * <p>Method under test: {@link CallGraph#CallGraph()}
   */
  @Test
  @DisplayName("Test new CallGraph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.<init>()", "void CallGraph.<init>(Map, Map, boolean)"})
  void testNewCallGraph() {
    // Arrange and Act
    CallGraph actualCallGraph = new CallGraph();

    // Assert
    assertTrue(actualCallGraph.incoming.isEmpty());
    assertTrue(actualCallGraph.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#CallGraph(Map, Map, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#CallGraph(Map, Map, boolean)}
   */
  @Test
  @DisplayName("Test new CallGraph(Map, Map, boolean); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.<init>()", "void CallGraph.<init>(Map, Map, boolean)"})
  void testNewCallGraph_whenHashMap() {
    // Arrange
    HashMap<MethodSignature, Set<Call>> incoming = new HashMap<>();

    // Act
    CallGraph actualCallGraph = new CallGraph(incoming, new HashMap<>(), true);

    // Assert
    assertTrue(actualCallGraph.incoming.isEmpty());
    assertTrue(actualCallGraph.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#concurrentCallGraph()}.
   *
   * <p>Method under test: {@link CallGraph#concurrentCallGraph()}
   */
  @Test
  @DisplayName("Test concurrentCallGraph()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CallGraph CallGraph.concurrentCallGraph()"})
  void testConcurrentCallGraph() {
    // Arrange and Act
    CallGraph actualConcurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Assert
    assertTrue(actualConcurrentCallGraphResult.incoming.isEmpty());
    assertTrue(actualConcurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    SymbolicCall call =
        new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            0,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall4() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            -1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall5() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member =
        new LibraryField(
            1, "Location of call {} is not a method", "Location of call {} is not a method");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target =
        new LibraryMethod(
            1, "Location of call {} is not a method", "Location of call {} is not a method");

    ConcreteCall call =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall6() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member =
        new LibraryField(
            1, "Location of call {} is not a method", "Location of call {} is not a method");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target =
        new LibraryMethod(
            1, "Location of call {} is not a method", " (always throws NullPointerException)");

    ConcreteCall call =
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall7() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);
    SymbolicCall call =
        new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>Given {@link CallGraph#CallGraph()}.
   *   <li>Then {@link CallGraph#CallGraph()} {@link CallGraph#incoming} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call); given CallGraph(); then CallGraph() incoming size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall_givenCallGraph_thenCallGraphIncomingSizeIsOne() {
    // Arrange
    CallGraph callGraph = new CallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    callGraph.addCall(call);

    // Assert
    assertEquals(1, callGraph.incoming.size());
    assertEquals(1, callGraph.outgoing.size());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>Then concurrentCallGraph {@link CallGraph#incoming} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call); then concurrentCallGraph incoming size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall_thenConcurrentCallGraphIncomingSizeIsOne() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert
    assertEquals(1, concurrentCallGraphResult.incoming.size());
    assertEquals(1, concurrentCallGraphResult.outgoing.size());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>When {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is minus one and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName(
      "Test addCall(Call); when BranchInstruction(byte, int) with opcode is minus one and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall_whenBranchInstructionWithOpcodeIsMinusOneAndBranchOffsetIsOne() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) -1, 1),
            true,
            true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>When {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is minus one and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName(
      "Test addCall(Call); when BranchInstruction(byte, int) with opcode is minus one and branchOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CallGraph.addCall(Call)"})
  void testAddCall_whenBranchInstructionWithOpcodeIsMinusOneAndBranchOffsetIsOne2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);
    SymbolicCall call =
        new SymbolicCall(caller, null, 1, new BranchInstruction((byte) -1, 1), true, true);

    // Act
    concurrentCallGraphResult.addCall(call);

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1,
            new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    ClassPool programClassPool = new ClassPool();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            programClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1,
            new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            0,
            1,
            new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods4() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1,
            stopMethods);

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods5() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    MethodSignature start = new MethodSignature("");

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool, start, 2, 1, new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("", methodSignature.getClassName());
    assertEquals("", methodSignature.getExternalPackageName());
    assertEquals("", methodSignature.getPackageName());
    assertEquals("? .?(?)", methodSignature.getPrettyFqn());
    assertEquals("L;?null", methodSignature.getFqn());
    assertNull(methodSignature.getMethodName());
    assertNull(methodSignature.getDescriptor());
    assertFalse(actualReconstructCallGraphResult.isTruncated);
    assertTrue(methodSignature.isIncomplete());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set) with 'programClassPool', 'start', 'stopMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, Set)"})
  void testReconstructCallGraphWithProgramClassPoolStartStopMethods() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}, {@code reachedMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set, Set) with 'programClassPool', 'start', 'stopMethods', 'reachedMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, Set, Set)"})
  void testReconstructCallGraphWithProgramClassPoolStartStopMethodsReachedMethods() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    HashSet<MethodSignature> stopMethods = new HashSet<>();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            stopMethods,
            new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}, {@code reachedMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set, Set) with 'programClassPool', 'start', 'stopMethods', 'reachedMethods'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Node CallGraph.reconstructCallGraph(ClassPool, MethodSignature, Set, Set)"})
  void testReconstructCallGraphWithProgramClassPoolStartStopMethodsReachedMethods2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    HashSet<MethodSignature> stopMethods = new HashSet<>();

    HashSet<MethodSignature> reachedMethods = new HashSet<>();
    reachedMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            stopMethods,
            reachedMethods);

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }
}
