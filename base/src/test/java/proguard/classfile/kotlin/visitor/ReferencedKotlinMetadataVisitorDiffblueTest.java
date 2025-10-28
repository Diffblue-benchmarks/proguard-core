package proguard.classfile.kotlin.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ReferencedKotlinMetadataVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link ReferencedKotlinMetadataVisitor#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ReferencedKotlinMetadataVisitor referencedKotlinMetadataVisitor = new ReferencedKotlinMetadataVisitor(
        new KotlinMetadataPrinter());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> referencedKotlinMetadataVisitor.visitAnyClass(new LibraryClass()));
  }
}
