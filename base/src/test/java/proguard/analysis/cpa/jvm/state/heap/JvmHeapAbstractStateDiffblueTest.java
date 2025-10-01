package proguard.analysis.cpa.jvm.state.heap;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class JvmHeapAbstractStateDiffblueTest {
  /**
   * Test {@link JvmHeapAbstractState#newObject(Clazz, JvmCfaNode)} with {@code Clazz}, {@code
   * JvmCfaNode}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmHeapAbstractState#newObject(Clazz, JvmCfaNode)}
   */
  @Test
  @DisplayName(
      "Test newObject(Clazz, JvmCfaNode) with 'Clazz', 'JvmCfaNode'; when LibraryClass(); then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState JvmHeapAbstractState.newObject(Clazz, JvmCfaNode)"
  })
  void testNewObjectWithClazzJvmCfaNode_whenLibraryClass_thenReturnUnknown() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmForgetfulHeapAbstractState.newObject(new LibraryClass(), JvmUnknownCfaNode.INSTANCE));
  }
}
