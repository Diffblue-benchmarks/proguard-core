package proguard.resources.kotlinmodule.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.resources.kotlinmodule.KotlinModule;

class KotlinModulePrinterDiffblueTest {
  /**
   * Test {@link KotlinModulePrinter#visitKotlinModule(KotlinModule)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinModule#modulePackagesAccept(KotlinModulePackageVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModulePrinter#visitKotlinModule(KotlinModule)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinModule(KotlinModule); then calls modulePackagesAccept(KotlinModulePackageVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.visitor.KotlinModulePrinter.visitKotlinModule(proguard.resources.kotlinmodule.KotlinModule)"
  })
  void testVisitKotlinModule_thenCallsModulePackagesAccept() {
    // Arrange
    KotlinModulePrinter kotlinModulePrinter = new KotlinModulePrinter();
    KotlinModule kotlinModule = mock(KotlinModule.class);
    doNothing().when(kotlinModule).modulePackagesAccept(Mockito.<KotlinModulePackageVisitor>any());

    // Act
    kotlinModulePrinter.visitKotlinModule(kotlinModule);

    // Assert
    verify(kotlinModule).modulePackagesAccept(isA(KotlinModulePackageVisitor.class));
  }
}
