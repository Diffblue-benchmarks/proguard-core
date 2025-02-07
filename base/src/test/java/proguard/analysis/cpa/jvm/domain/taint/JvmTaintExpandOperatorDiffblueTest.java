package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.Signature;

class JvmTaintExpandOperatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link JvmCfa} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintExpandOperator#JvmTaintExpandOperator(JvmCfa, Map)}
   *   <li>{@link JvmTaintExpandOperator#getSignaturesToSources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when JvmCfa (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintExpandOperator.<init>(proguard.analysis.cpa.jvm.cfa.JvmCfa, java.util.Map)",
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintExpandOperator.<init>(proguard.analysis.cpa.jvm.cfa.JvmCfa, java.util.Map, boolean)",
    "java.util.Map proguard.analysis.cpa.jvm.domain.taint.JvmTaintExpandOperator.getSignaturesToSources()"
  })
  void testGettersAndSetters_whenJvmCfa() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();

    // Act
    Map<Signature, Set<JvmTaintSource>> actualSignaturesToSources =
        (new JvmTaintExpandOperator(cfa, signaturesToSources)).getSignaturesToSources();

    // Assert
    assertTrue(actualSignaturesToSources.isEmpty());
    assertSame(signaturesToSources, actualSignaturesToSources);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintExpandOperator#JvmTaintExpandOperator(JvmCfa, Map, boolean)}
   *   <li>{@link JvmTaintExpandOperator#getSignaturesToSources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintExpandOperator.<init>(proguard.analysis.cpa.jvm.cfa.JvmCfa, java.util.Map)",
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintExpandOperator.<init>(proguard.analysis.cpa.jvm.cfa.JvmCfa, java.util.Map, boolean)",
    "java.util.Map proguard.analysis.cpa.jvm.domain.taint.JvmTaintExpandOperator.getSignaturesToSources()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();

    // Act
    Map<Signature, Set<JvmTaintSource>> actualSignaturesToSources =
        (new JvmTaintExpandOperator(cfa, signaturesToSources, true)).getSignaturesToSources();

    // Assert
    assertTrue(actualSignaturesToSources.isEmpty());
    assertSame(signaturesToSources, actualSignaturesToSources);
  }
}
