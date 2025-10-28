package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.MapAbstractState;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmHeapAbstractState;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ExecutingInvocationUnit;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.IdentifiedReferenceValue;
import proguard.evaluation.value.ValueFactory;

public class JvmValueAbstractStateDiffblueTest {
  /**
   * Method under test:
   * {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)}
   */
  @Test
  public void testGetVariableOrDefault() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act
    ValueAbstractState actualVariableOrDefault = jvmValueAbstractState.getVariableOrDefault(1,
        ValueAbstractState.UNKNOWN);

    // Assert
    JvmFrameAbstractState<ValueAbstractState> frame2 = jvmValueAbstractState.getFrame();
    assertTrue(frame2.getLocalVariables().isEmpty());
    assertSame(frame, frame2);
    assertSame(actualVariableOrDefault.UNKNOWN, actualVariableOrDefault);
  }

  /**
   * Method under test:
   * {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)}
   */
  @Test
  public void testGetVariableOrDefault2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    ValueAbstractState defaultState = ValueAbstractState.UNKNOWN;
    LibraryClass referencedClass = new LibraryClass();
    defaultState.setValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Act
    ValueAbstractState actualVariableOrDefault = jvmValueAbstractState.getVariableOrDefault(1, defaultState);

    // Assert
    JvmFrameAbstractState<ValueAbstractState> frame2 = jvmValueAbstractState.getFrame();
    assertTrue(frame2.getLocalVariables().isEmpty());
    assertSame(frame, frame2);
    assertSame(actualVariableOrDefault.UNKNOWN, actualVariableOrDefault);
  }

  /**
   * Method under test:
   * {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)}
   */
  @Test
  public void testGetVariableOrDefault3() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act
    ValueAbstractState actualVariableOrDefault = jvmValueAbstractState.getVariableOrDefault(1,
        ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(frame, jvmValueAbstractState.getFrame());
    assertSame(actualVariableOrDefault.UNKNOWN, actualVariableOrDefault);
  }

  /**
   * Method under test:
   * {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)}
   */
  @Test
  public void testGetVariableOrDefault4() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    ValueAbstractState defaultState = ValueAbstractState.UNKNOWN;
    LibraryClass referencedClass = new LibraryClass();
    defaultState.setValue(new IdentifiedReferenceValue("Ljava/lang/String;", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id"));

    // Act
    ValueAbstractState actualVariableOrDefault = jvmValueAbstractState.getVariableOrDefault(1, defaultState);

    // Assert
    JvmFrameAbstractState<ValueAbstractState> frame2 = jvmValueAbstractState.getFrame();
    assertTrue(frame2.getLocalVariables().isEmpty());
    assertSame(frame, frame2);
    assertSame(actualVariableOrDefault.UNKNOWN, actualVariableOrDefault);
  }

  /**
   * Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(jvmValueAbstractState, jvmValueAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>())));
  }

  /**
   * Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmCfaNode programLocation = new JvmCfaNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2,
        new LibraryClass());

    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null, programLocation, frame,
        heap, staticFields);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act
    JvmValueAbstractState actualJoinResult = jvmValueAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>()));

    // Assert
    JvmCfaNode programLocation2 = actualJoinResult.getProgramLocation();
    Collection<JvmCfaEdge> enteringIntraproceduralEdges = programLocation2.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges = programLocation2.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges = programLocation2.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges = programLocation2.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    JvmHeapAbstractState<ValueAbstractState> heap3 = actualJoinResult.getHeap();
    assertTrue(heap3 instanceof JvmForgetfulHeapAbstractState);
    ValueFactory valueFactory2 = actualJoinResult.getValueFactory();
    assertTrue(valueFactory2 instanceof ParticularReferenceValueFactory);
    assertNull(actualJoinResult.getPrecision());
    assertNull(heap3.getPrecision());
    assertNull(programLocation2.getClazz());
    assertNull(programLocation2.getSignature());
    assertEquals(-1, programLocation2.getOffset());
    Optional<JvmCfaEdge> enteringInvokeEdge = programLocation2.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(programLocation2.isExceptionExitNode());
    assertFalse(programLocation2.isUnknownNode());
    assertFalse(programLocation2.isEntryNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(programLocation2.getEnteringEdges().isEmpty());
    assertTrue(programLocation2.getLeavingEdges().isEmpty());
    MapAbstractState<String, ValueAbstractState> staticFields2 = actualJoinResult.getStaticFields();
    assertTrue(staticFields2.isEmpty());
    assertTrue(programLocation2.isReturnExitNode());
    assertTrue(programLocation2.isExitNode());
    assertSame(staticFields, staticFields2);
    assertSame(frame, actualJoinResult.getFrame());
    assertSame(heap, heap3);
    assertSame(valueFactory, valueFactory2);
    assertSame(enteringInvokeEdge, programLocation2.getLeavingInvokeEdge());
  }

  /**
   * Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin3() {
    // Arrange
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
        staticFields);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(jvmValueAbstractState, jvmValueAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap, new HashMapAbstractState<>())));
  }

  /**
   * Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin4() {
    // Arrange
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("42", ValueAbstractState.UNKNOWN);
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
        staticFields);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(jvmValueAbstractState, jvmValueAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap, new HashMapAbstractState<>())));
  }

  /**
   * Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin5() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(jvmValueAbstractState, jvmValueAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>())));
  }

  /**
   * Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin6() {
    // Arrange
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
        staticFields);

    HashMapAbstractState<String, ValueAbstractState> staticFields2 = new HashMapAbstractState<>();
    staticFields2.put("foo", ValueAbstractState.UNKNOWN);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();

    // Act and Assert
    assertSame(jvmValueAbstractState, jvmValueAbstractState.join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE,
        frame2, new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN), staticFields2)));
  }

  /**
   * Method under test: {@link JvmValueAbstractState#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmValueAbstractState, jvmValueAbstractState.copy());
  }

  /**
   * Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmValueAbstractState, jvmValueAbstractState);
    int expectedHashCodeResult = jvmValueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmValueAbstractState.hashCode());
  }

  /**
   * Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState = new JvmValueAbstractState(valueFactory, null,
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    ParticularReferenceValueFactory valueFactory2 = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(jvmValueAbstractState, new JvmValueAbstractState(valueFactory2, null, JvmUnknownCfaNode.INSTANCE,
        frame2, heap2, new HashMapAbstractState<>()));
  }

  /**
   * Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(new JvmValueAbstractState(valueFactory, null, JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>()), null);
  }

  /**
   * Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(new JvmValueAbstractState(valueFactory, null, JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>()), "Different type to JvmValueAbstractState");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JvmValueAbstractState#JvmValueAbstractState(ValueFactory, ExecutingInvocationUnit, JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)}
   *   <li>{@link JvmValueAbstractState#toString()}
   *   <li>{@link JvmValueAbstractState#getValueFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();

    // Act
    JvmValueAbstractState actualJvmValueAbstractState = new JvmValueAbstractState(valueFactory, null, programLocation,
        frame, heap, staticFields);
    String actualToStringResult = actualJvmValueAbstractState.toString();
    ValueFactory actualValueFactory = actualJvmValueAbstractState.getValueFactory();

    // Assert
    JvmHeapAbstractState<ValueAbstractState> heap2 = actualJvmValueAbstractState.getHeap();
    assertTrue(heap2 instanceof JvmForgetfulHeapAbstractState);
    assertTrue(actualValueFactory instanceof ParticularReferenceValueFactory);
    assertEquals("JvmValueAbstractState(JvmUnknownCfaNode{})", actualToStringResult);
    assertSame(staticFields, actualJvmValueAbstractState.getStaticFields());
    assertSame(frame, actualJvmValueAbstractState.getFrame());
    assertSame(heap, heap2);
    assertSame(valueFactory, actualValueFactory);
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(expectedProgramLocation, actualJvmValueAbstractState.getProgramLocation());
  }
}
