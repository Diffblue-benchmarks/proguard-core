package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.ListAbstractState;
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmValueAbstractState#JvmValueAbstractState(ValueFactory, ExecutingInvocationUnit,
   *       JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)}
   *   <li>{@link JvmValueAbstractState#toString()}
   *   <li>{@link JvmValueAbstractState#getValueFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmValueAbstractState.<init>(ValueFactory, ExecutingInvocationUnit, JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)",
    "ValueFactory JvmValueAbstractState.getValueFactory()",
    "String JvmValueAbstractState.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();

    // Act
    JvmValueAbstractState actualJvmValueAbstractState =
        new JvmValueAbstractState(valueFactory, null, programLocation, frame, heap, staticFields);
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

  /**
   * Test {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)} with {@code
   * int}, {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#getVariableOrDefault(int,
   * ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueAbstractState.getVariableOrDefault(int, ValueAbstractState)"
  })
  public void testGetVariableOrDefaultWithIntValueAbstractState() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());
    ValueAbstractState defaultState = ValueAbstractState.UNKNOWN;
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue value =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    defaultState.setValue(value);

    // Act and Assert
    assertSame(value, jvmValueAbstractState.getVariableOrDefault(1, defaultState).getValue());
  }

  /**
   * Test {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)} with {@code
   * int}, {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#getVariableOrDefault(int,
   * ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueAbstractState.getVariableOrDefault(int, ValueAbstractState)"
  })
  public void testGetVariableOrDefaultWithIntValueAbstractState2() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());

    // Act
    ValueAbstractState actualVariableOrDefault =
        jvmValueAbstractState.getVariableOrDefault(1, ValueAbstractState.UNKNOWN);

    // Assert
    ListAbstractState<ValueAbstractState> localVariables =
        jvmValueAbstractState.getFrame().getLocalVariables();
    assertEquals(2, localVariables.size());
    ValueAbstractState valueAbstractState = actualVariableOrDefault.UNKNOWN;
    assertSame(valueAbstractState, localVariables.get(0));
    assertSame(valueAbstractState, localVariables.get(1));
  }

  /**
   * Test {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)} with {@code
   * int}, {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#getVariableOrDefault(int,
   * ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueAbstractState.getVariableOrDefault(int, ValueAbstractState)"
  })
  public void testGetVariableOrDefaultWithIntValueAbstractState3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());
    ValueAbstractState defaultState = ValueAbstractState.UNKNOWN;
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue value =
        new IdentifiedReferenceValue(
            "Ljava/lang/String;",
            referencedClass,
            true,
            true,
            new ParticularReferenceValueFactory(),
            "Id");

    defaultState.setValue(value);

    // Act and Assert
    assertSame(value, jvmValueAbstractState.getVariableOrDefault(1, defaultState).getValue());
  }

  /**
   * Test {@link JvmValueAbstractState#getVariableOrDefault(int, ValueAbstractState)} with {@code
   * int}, {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>When {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#getVariableOrDefault(int,
   * ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueAbstractState.getVariableOrDefault(int, ValueAbstractState)"
  })
  public void testGetVariableOrDefaultWithIntValueAbstractState_whenUnknown_thenReturnUnknown() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualVariableOrDefault =
        (new JvmValueAbstractState(
                valueFactory,
                null,
                JvmUnknownCfaNode.INSTANCE,
                frame,
                heap,
                new HashMapAbstractState<>()))
            .getVariableOrDefault(1, ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualVariableOrDefault.UNKNOWN, actualVariableOrDefault);
  }

  /**
   * Test {@link JvmValueAbstractState#setVariable(int, ValueAbstractState, ValueAbstractState)}
   * with {@code int}, {@code ValueAbstractState}, {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#setVariable(int, ValueAbstractState,
   * ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueAbstractState.setVariable(int, ValueAbstractState, ValueAbstractState)"
  })
  public void testSetVariableWithIntValueAbstractStateValueAbstractState() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());
    ValueAbstractState state = ValueAbstractState.UNKNOWN;
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue value =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    state.setValue(value);

    // Act and Assert
    assertSame(
        value, jvmValueAbstractState.setVariable(1, state, ValueAbstractState.UNKNOWN).getValue());
  }

  /**
   * Test {@link JvmValueAbstractState#setVariable(int, ValueAbstractState, ValueAbstractState)}
   * with {@code int}, {@code ValueAbstractState}, {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#setVariable(int, ValueAbstractState,
   * ValueAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ValueAbstractState JvmValueAbstractState.setVariable(int, ValueAbstractState, ValueAbstractState)"
  })
  public void testSetVariableWithIntValueAbstractStateValueAbstractState2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());
    ValueAbstractState state = ValueAbstractState.UNKNOWN;
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue value =
        new IdentifiedReferenceValue(
            "Ljava/lang/String;",
            referencedClass,
            true,
            true,
            new ParticularReferenceValueFactory(),
            "Id");

    state.setValue(value);

    // Act and Assert
    assertSame(
        value, jvmValueAbstractState.setVariable(1, state, ValueAbstractState.UNKNOWN).getValue());
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmCfaNode programLocation =
        new JvmCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory, null, programLocation, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    JvmCfaNode programLocation2 =
        jvmValueAbstractState
            .join(
                new JvmAbstractState<>(
                    JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>()))
            .getProgramLocation();
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        programLocation2.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges = programLocation2.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        programLocation2.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        programLocation2.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Optional<JvmCfaEdge> enteringInvokeEdge = programLocation2.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(programLocation2.isUnknownNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(programLocation2.getEnteringEdges().isEmpty());
    assertTrue(programLocation2.getLeavingEdges().isEmpty());
    assertTrue(programLocation2.isReturnExitNode());
    assertTrue(programLocation2.isExitNode());
    assertSame(enteringInvokeEdge, programLocation2.getLeavingInvokeEdge());
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState2() {
    // Arrange
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
            staticFields);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        jvmValueAbstractState,
        jvmValueAbstractState.join(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE, frame2, heap, new HashMapAbstractState<>())));
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return StaticFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState_givenFoo_thenReturnStaticFieldsSizeIsOne() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());

    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();

    // Act and Assert
    MapAbstractState<String, ValueAbstractState> staticFields2 =
        jvmValueAbstractState
            .join(
                new JvmAbstractState<>(
                    JvmUnknownCfaNode.INSTANCE,
                    frame2,
                    new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
                    staticFields))
            .getStaticFields();
    assertEquals(1, staticFields2.size());
    ValueAbstractState getResult = staticFields2.get("foo");
    assertTrue(getResult.getValue() instanceof IdentifiedReferenceValue);
    assertNull(getResult.getPrecision());
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMapAbstractState#HashMapAbstractState()} {@code foo} is {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState_givenFoo_whenHashMapAbstractStateFooIsUnknown() {
    // Arrange
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
            staticFields);

    HashMapAbstractState<String, ValueAbstractState> staticFields2 = new HashMapAbstractState<>();
    staticFields2.put("foo", ValueAbstractState.UNKNOWN);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();

    // Act and Assert
    assertSame(
        jvmValueAbstractState,
        jvmValueAbstractState.join(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE,
                frame2,
                new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
                staticFields2)));
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <ul>
   *   <li>Given {@link HashMapAbstractState#HashMapAbstractState()} {@code 42} is {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState_givenHashMapAbstractState42IsUnknown() {
    // Arrange
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();
    staticFields.put("42", ValueAbstractState.UNKNOWN);
    staticFields.put("foo", ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN),
            staticFields);
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        jvmValueAbstractState,
        jvmValueAbstractState.join(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE, frame2, heap, new HashMapAbstractState<>())));
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return Frame is {@link JvmFrameAbstractState#JvmFrameAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState_givenOne_thenReturnFrameIsJvmFrameAbstractState() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());

    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    frame2.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertEquals(
        frame2,
        jvmValueAbstractState
            .join(
                new JvmAbstractState<>(
                    JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>()))
            .getFrame());
  }

  /**
   * Test {@link JvmValueAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <ul>
   *   <li>Then return Frame LocalVariables size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState_thenReturnFrameLocalVariablesSizeIsTwo() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    JvmFrameAbstractState<ValueAbstractState> frame3 =
        jvmValueAbstractState
            .join(
                new JvmAbstractState<>(
                    JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>()))
            .getFrame();
    ListAbstractState<ValueAbstractState> localVariables = frame3.getLocalVariables();
    assertEquals(2, localVariables.size());
    assertTrue(frame3.getOperandStack().isEmpty());
    ValueAbstractState expectedGetResult = localVariables.get(0);
    assertSame(expectedGetResult, localVariables.get(1));
  }

  /**
   * Test {@link JvmValueAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmValueAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmValueAbstractState JvmValueAbstractState.copy()"})
  public void testCopy() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmValueAbstractState, jvmValueAbstractState.copy());
  }

  /**
   * Test {@link JvmValueAbstractState#equals(Object)}, and {@link JvmAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmValueAbstractState.equals(Object)"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmValueAbstractState, jvmValueAbstractState);
    int expectedHashCodeResult = jvmValueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmValueAbstractState.hashCode());
  }

  /**
   * Test {@link JvmValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmValueAbstractState.equals(Object)"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmValueAbstractState jvmValueAbstractState =
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>());
    ParticularReferenceValueFactory valueFactory2 = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap2 =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        jvmValueAbstractState,
        new JvmValueAbstractState(
            valueFactory2,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame2,
            heap2,
            new HashMapAbstractState<>()));
  }

  /**
   * Test {@link JvmValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmValueAbstractState.equals(Object)"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>()),
        null);
  }

  /**
   * Test {@link JvmValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmValueAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmValueAbstractState.equals(Object)"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        new JvmValueAbstractState(
            valueFactory,
            null,
            JvmUnknownCfaNode.INSTANCE,
            frame,
            heap,
            new HashMapAbstractState<>()),
        "Different type to JvmValueAbstractState");
  }
}
