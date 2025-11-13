package proguard.analysis.cpa.interfaces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;

class CfaNodeDiffblueTest {
  /**
   * Test {@link CfaNode#isReturnExitNode()}.
   *
   * <p>Method under test: {@link CfaNode#isReturnExitNode()}
   */
  @Test
  @DisplayName("Test isReturnExitNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CfaNode.isReturnExitNode()"})
  void testIsReturnExitNode() {
    // Arrange, Act and Assert
    assertFalse(
        new JvmCatchCfaNode(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass())
            .isReturnExitNode());
  }

  /**
   * Test {@link CfaNode#isReturnExitNode()}.
   *
   * <ul>
   *   <li>Given {@link JvmUnknownCfaNode#INSTANCE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CfaNode#isReturnExitNode()}
   */
  @Test
  @DisplayName("Test isReturnExitNode(); given INSTANCE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CfaNode.isReturnExitNode()"})
  void testIsReturnExitNode_givenInstance_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isReturnExitNode());
  }

  /**
   * Test {@link CfaNode#isReturnExitNode()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CfaNode#isReturnExitNode()}
   */
  @Test
  @DisplayName("Test isReturnExitNode(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CfaNode.isReturnExitNode()"})
  void testIsReturnExitNode_thenReturnTrue() {
    // Arrange
    JvmCatchCfaNode jvmCatchCfaNode =
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            CfaNode.RETURN_EXIT_NODE_OFFSET,
            1,
            new LibraryClass());

    // Act and Assert
    assertTrue(jvmCatchCfaNode.isReturnExitNode());
  }

  /**
   * Test {@link CfaNode#isExceptionExitNode()}.
   *
   * <ul>
   *   <li>Given {@link JvmUnknownCfaNode#INSTANCE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CfaNode#isExceptionExitNode()}
   */
  @Test
  @DisplayName("Test isExceptionExitNode(); given INSTANCE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CfaNode.isExceptionExitNode()"})
  void testIsExceptionExitNode_givenInstance_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExceptionExitNode());
  }

  /**
   * Test {@link CfaNode#isExceptionExitNode()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CfaNode#isExceptionExitNode()}
   */
  @Test
  @DisplayName("Test isExceptionExitNode(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CfaNode.isExceptionExitNode()"})
  void testIsExceptionExitNode_thenReturnTrue() {
    // Arrange
    JvmCatchCfaNode jvmCatchCfaNode =
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            CfaNode.EXCEPTION_EXIT_NODE_OFFSET,
            1,
            new LibraryClass());

    // Act and Assert
    assertTrue(jvmCatchCfaNode.isExceptionExitNode());
  }

  /**
   * Test {@link CfaNode#isUnknownNode()}.
   *
   * <p>Method under test: {@link CfaNode#isUnknownNode()}
   */
  @Test
  @DisplayName("Test isUnknownNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CfaNode.isUnknownNode()"})
  void testIsUnknownNode() {
    // Arrange, Act and Assert
    assertTrue(JvmUnknownCfaNode.INSTANCE.isUnknownNode());
  }
}
