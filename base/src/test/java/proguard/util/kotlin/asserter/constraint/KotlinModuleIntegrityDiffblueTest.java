package proguard.util.kotlin.asserter.constraint;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.resources.file.visitor.ResourceFileVisitor;
import proguard.resources.kotlinmodule.KotlinModule;
import proguard.util.kotlin.asserter.Reporter;

class KotlinModuleIntegrityDiffblueTest {
  /**
   * Test {@link KotlinModuleIntegrity#check(Reporter, KotlinModule)} with {@code reporter}, {@code
   * kotlinModule}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinModule#accept(ResourceFileVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModuleIntegrity#check(Reporter, KotlinModule)}
   */
  @Test
  @DisplayName(
      "Test check(Reporter, KotlinModule) with 'reporter', 'kotlinModule'; then calls accept(ResourceFileVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.KotlinModuleIntegrity.check(proguard.util.kotlin.asserter.Reporter, proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testCheckWithReporterKotlinModule_thenCallsAccept() {
    // Arrange
    KotlinModuleIntegrity kotlinModuleIntegrity = new KotlinModuleIntegrity();
    Reporter reporter = mock(Reporter.class);
    KotlinModule kotlinModule = mock(KotlinModule.class);
    doNothing().when(kotlinModule).accept(Mockito.<ResourceFileVisitor>any());

    // Act
    kotlinModuleIntegrity.check(reporter, kotlinModule);

    // Assert
    verify(kotlinModule).accept(isA(ResourceFileVisitor.class));
  }
}
