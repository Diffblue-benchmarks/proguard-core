package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;

public class JvmTaintAbstractStateDiffblueTest {
  /**
   * Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState = new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 = new JvmForgetfulHeapAbstractState<>(null);

    // Act and Assert
    assertSame(jvmTaintAbstractState, jvmTaintAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>())));
  }

  /**
   * Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin2() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, null, null);
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState = new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 = new JvmForgetfulHeapAbstractState<>(null);

    // Act and Assert
    assertSame(jvmTaintAbstractState, jvmTaintAbstractState
        .join(new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>())));
  }

  /**
   * Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  public void testJoin3() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState = new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    frame2.setVariable(1, null, null);
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 = new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState = new JvmAbstractState<>(
        JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(abstractState, jvmTaintAbstractState.join(abstractState));
  }

  /**
   * Method under test: {@link JvmTaintAbstractState#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState = new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmTaintAbstractState, jvmTaintAbstractState.copy());
  }
}
