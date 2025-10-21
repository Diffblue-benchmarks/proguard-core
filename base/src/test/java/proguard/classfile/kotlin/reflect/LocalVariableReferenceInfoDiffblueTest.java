package proguard.classfile.kotlin.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;

public class LocalVariableReferenceInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocalVariableReferenceInfo#LocalVariableReferenceInfo(Clazz,
   *       KotlinDeclarationContainerMetadata, String, String)}
   *   <li>{@link LocalVariableReferenceInfo#getName()}
   *   <li>{@link LocalVariableReferenceInfo#getOwner()}
   *   <li>{@link LocalVariableReferenceInfo#getSignature()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableReferenceInfo.<init>(Clazz, KotlinDeclarationContainerMetadata, String, String)",
    "String LocalVariableReferenceInfo.getName()",
    "KotlinDeclarationContainerMetadata LocalVariableReferenceInfo.getOwner()",
    "String LocalVariableReferenceInfo.getSignature()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    KotlinClassKindMetadata ownerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    LocalVariableReferenceInfo actualLocalVariableReferenceInfo =
        new LocalVariableReferenceInfo(ownerClass, ownerMetadata, "Name", "Signature");
    String actualName = actualLocalVariableReferenceInfo.getName();
    KotlinDeclarationContainerMetadata actualOwner = actualLocalVariableReferenceInfo.getOwner();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Signature", actualLocalVariableReferenceInfo.getSignature());
    assertSame(ownerMetadata, actualOwner);
  }
}
