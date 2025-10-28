package proguard.resources.file.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import org.junit.Test;
import proguard.io.ClassPathDataEntry;
import proguard.io.DataEntry;

public class ResourceJavaReferenceCollectorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ResourceJavaReferenceCollector}
   *   <li>{@link ResourceJavaReferenceCollector#getReferences()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new ResourceJavaReferenceCollector()).getReferences());
  }

  /**
   * Method under test: {@link ResourceJavaReferenceCollector#read(DataEntry)}
   */
  @Test
  public void testRead() throws IOException {
    // Arrange
    ResourceJavaReferenceCollector resourceJavaReferenceCollector = new ResourceJavaReferenceCollector();
    Class<Object> clazz = Object.class;

    // Act
    resourceJavaReferenceCollector.read(new ClassPathDataEntry(clazz));

    // Assert
    assertEquals(145, resourceJavaReferenceCollector.getReferences().size());
  }
}
