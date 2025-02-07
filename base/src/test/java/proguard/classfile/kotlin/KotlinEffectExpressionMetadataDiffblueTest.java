package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;

class KotlinEffectExpressionMetadataDiffblueTest {
  /**
   * Test {@link KotlinEffectExpressionMetadata#typeOfIsAccept(Clazz, KotlinTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitTypeOfIsExpression(Clazz,
   *       KotlinEffectExpressionMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinEffectExpressionMetadata#typeOfIsAccept(Clazz,
   * KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeOfIsAccept(Clazz, KotlinTypeVisitor); then calls visitTypeOfIsExpression(Clazz, KotlinEffectExpressionMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinEffectExpressionMetadata.typeOfIsAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testTypeOfIsAccept_thenCallsVisitTypeOfIsExpression() {
    // Arrange
    KotlinEffectExpressionMetadata kotlinEffectExpressionMetadata =
        new KotlinEffectExpressionMetadata();
    kotlinEffectExpressionMetadata.typeOfIs = KotlinTypeMetadata.starProjection();
    LibraryClass clazz = new LibraryClass();
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitTypeOfIsExpression(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectExpressionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinEffectExpressionMetadata.typeOfIsAccept(clazz, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitTypeOfIsExpression(
            isA(Clazz.class),
            isA(KotlinEffectExpressionMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinEffectExpressionMetadata}
   *   <li>{@link KotlinEffectExpressionMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinEffectExpressionMetadata.<init>()",
    "java.lang.String proguard.classfile.kotlin.KotlinEffectExpressionMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinEffectExpressionMetadata actualKotlinEffectExpressionMetadata =
        new KotlinEffectExpressionMetadata();

    // Assert
    assertEquals("Kotlin contract effect", actualKotlinEffectExpressionMetadata.toString());
    assertNull(actualKotlinEffectExpressionMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinEffectExpressionMetadata.getProcessingFlags());
  }
}
