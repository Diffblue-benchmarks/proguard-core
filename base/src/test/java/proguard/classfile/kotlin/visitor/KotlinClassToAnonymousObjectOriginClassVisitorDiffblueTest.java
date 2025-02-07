package proguard.classfile.kotlin.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;

class KotlinClassToAnonymousObjectOriginClassVisitorDiffblueTest {
  /**
   * Test {@link KotlinClassToAnonymousObjectOriginClassVisitor#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPool#getClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinClassToAnonymousObjectOriginClassVisitor#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); then calls getClass(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinClassToAnonymousObjectOriginClassVisitor.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_thenCallsGetClass() {
    // Arrange
    ClassPool classPool = mock(ClassPool.class);
    when(classPool.getClass(Mockito.<String>any())).thenReturn(new LibraryClass());
    KotlinClassToAnonymousObjectOriginClassVisitor kotlinClassToAnonymousObjectOriginClassVisitor =
        new KotlinClassToAnonymousObjectOriginClassVisitor(
            classPool, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass(36, "This Class Name", "Super Class Name");

    // Act
    kotlinClassToAnonymousObjectOriginClassVisitor.visitKotlinClassMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(classPool).getClass(eq("This Class Name"));
  }
}
