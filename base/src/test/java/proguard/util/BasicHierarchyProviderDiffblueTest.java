package proguard.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class BasicHierarchyProviderDiffblueTest {
  /**
   * Method under test: {@link BasicHierarchyProvider#getClazz(String)}
   */
  @Test
  public void testGetClazz() {
    // Arrange, Act and Assert
    assertNull((new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
        .getClazz("Class Name"));
  }

  /**
   * Method under test: {@link BasicHierarchyProvider#getSubClasses(String)}
   */
  @Test
  public void testGetSubClasses() {
    // Arrange, Act and Assert
    assertTrue((new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
        .getSubClasses("Class Name")
        .isEmpty());
  }
}
