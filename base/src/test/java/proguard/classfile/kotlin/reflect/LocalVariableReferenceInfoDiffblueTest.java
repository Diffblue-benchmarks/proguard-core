package proguard.classfile.kotlin.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;

public class LocalVariableReferenceInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LocalVariableReferenceInfo#LocalVariableReferenceInfo(Clazz, KotlinDeclarationContainerMetadata, String, String)}
   *   <li>{@link LocalVariableReferenceInfo#getName()}
   *   <li>{@link LocalVariableReferenceInfo#getOwner()}
   *   <li>{@link LocalVariableReferenceInfo#getSignature()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    KotlinClassKindMetadata ownerMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    LocalVariableReferenceInfo actualLocalVariableReferenceInfo = new LocalVariableReferenceInfo(ownerClass,
        ownerMetadata, "Name", "Signature");
    String actualName = actualLocalVariableReferenceInfo.getName();
    KotlinDeclarationContainerMetadata actualOwner = actualLocalVariableReferenceInfo.getOwner();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Signature", actualLocalVariableReferenceInfo.getSignature());
    assertSame(ownerMetadata, actualOwner);
  }
}
