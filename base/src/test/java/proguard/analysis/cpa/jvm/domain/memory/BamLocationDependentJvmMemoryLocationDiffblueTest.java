package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

class BamLocationDependentJvmMemoryLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link JvmUnknownCfaNode#INSTANCE}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#BamLocationDependentJvmMemoryLocation(JvmMemoryLocation,
   *       JvmCfaNode, ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#setProgramLocation(JvmCfaNode)}
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getMemoryLocation()}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getSourceReachedSet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation)",
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet)",
    "proguard.analysis.cpa.jvm.witness.JvmMemoryLocation proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.getMemoryLocation()",
    "proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.getSourceReachedSet()",
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.setProgramLocation(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode)",
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.setSourceReachedSet(proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet)"
  })
  void testGettersAndSetters_whenInstance() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualBamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(programLocation);
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    actualBamLocationDependentJvmMemoryLocation.setSourceReachedSet(sourceReachedSet);
    JvmMemoryLocation actualMemoryLocation =
        actualBamLocationDependentJvmMemoryLocation.getMemoryLocation();

    // Assert
    assertTrue(actualMemoryLocation instanceof JvmLocalVariableLocation);
    assertEquals(1, ((JvmLocalVariableLocation) actualMemoryLocation).index);
    assertSame(sourceReachedSet, actualBamLocationDependentJvmMemoryLocation.getSourceReachedSet());
    assertSame(memoryLocation, actualMemoryLocation);
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(
        expectedProgramLocation, actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link JvmLocalVariableLocation#JvmLocalVariableLocation(int)} with index is one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#BamLocationDependentJvmMemoryLocation(JvmMemoryLocation)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#setProgramLocation(JvmCfaNode)}
   *   <li>{@link
   *       BamLocationDependentJvmMemoryLocation#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getMemoryLocation()}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getSourceReachedSet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when JvmLocalVariableLocation(int) with index is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation)",
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet)",
    "proguard.analysis.cpa.jvm.witness.JvmMemoryLocation proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.getMemoryLocation()",
    "proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.getSourceReachedSet()",
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.setProgramLocation(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode)",
    "void proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.setSourceReachedSet(proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet)"
  })
  void testGettersAndSetters_whenJvmLocalVariableLocationWithIndexIsOne() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualBamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(memoryLocation);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(programLocation);
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    actualBamLocationDependentJvmMemoryLocation.setSourceReachedSet(sourceReachedSet);
    JvmMemoryLocation actualMemoryLocation =
        actualBamLocationDependentJvmMemoryLocation.getMemoryLocation();

    // Assert
    assertTrue(actualMemoryLocation instanceof JvmLocalVariableLocation);
    assertEquals(1, ((JvmLocalVariableLocation) actualMemoryLocation).index);
    assertSame(sourceReachedSet, actualBamLocationDependentJvmMemoryLocation.getSourceReachedSet());
    assertSame(memoryLocation, actualMemoryLocation);
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(
        expectedProgramLocation, actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#copy()}.
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.copy()"
  })
  void testCopy() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(
        bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation.copy());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test extractFirstValue(LatticeAbstractState); then return UNKNOWN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.extractFirstValue(proguard.analysis.cpa.defaults.LatticeAbstractState)"
  })
  void testExtractFirstValue_thenReturnUnknown() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());

    // Act
    ValueAbstractState actualExtractFirstValueResult =
        bamLocationDependentJvmMemoryLocation.extractFirstValue(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractFirstValueResult.UNKNOWN, actualExtractFirstValueResult);
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}.
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}
   */
  @Test
  @DisplayName("Test getProgramLocation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.getProgramLocation()"
  })
  void testGetProgramLocation() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNull(bamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}, and {@link
   * BamLocationDependentJvmMemoryLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation2 =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation2);
    int expectedHashCodeResult = bamLocationDependentJvmMemoryLocation.hashCode();
    assertEquals(expectedHashCodeResult, bamLocationDependentJvmMemoryLocation2.hashCode());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}, and {@link
   * BamLocationDependentJvmMemoryLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation);
    int expectedHashCodeResult = bamLocationDependentJvmMemoryLocation.hashCode();
    assertEquals(expectedHashCodeResult, bamLocationDependentJvmMemoryLocation.hashCode());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0));

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>());

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    bamLocationDependentJvmMemoryLocation.setProgramLocation(JvmUnknownCfaNode.INSTANCE);

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation, null);
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(
        bamLocationDependentJvmMemoryLocation,
        "Different type to BamLocationDependentJvmMemoryLocation");
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.toString()"
  })
  void testToString_thenReturnAString() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    bamLocationDependentJvmMemoryLocation.setProgramLocation(
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()));

    // Act and Assert
    assertEquals(
        "JvmLocalVariableLocation(1)@Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang"
            + "/Class;:2",
        bamLocationDependentJvmMemoryLocation.toString());
  }

  /**
   * Test {@link BamLocationDependentJvmMemoryLocation#toString()}.
   *
   * <ul>
   *   <li>Then return {@code JvmLocalVariableLocation(1)}.
   * </ul>
   *
   * <p>Method under test: {@link BamLocationDependentJvmMemoryLocation#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'JvmLocalVariableLocation(1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation.toString()"
  })
  void testToString_thenReturnJvmLocalVariableLocation1() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        bamLocationDependentJvmMemoryLocation =
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", bamLocationDependentJvmMemoryLocation.toString());
  }
}
