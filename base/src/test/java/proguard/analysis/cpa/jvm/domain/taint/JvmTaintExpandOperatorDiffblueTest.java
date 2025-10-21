package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.classfile.Signature;

public class JvmTaintExpandOperatorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map)",
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map, boolean)",
    "Map JvmTaintExpandOperator.getSignaturesToSources()"
  })
  public void testGettersAndSetters_whenJvmCfa() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map)",
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map, boolean)",
    "Map JvmTaintExpandOperator.getSignaturesToSources()"
  })
  public void testGettersAndSetters_whenTrue() {
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
