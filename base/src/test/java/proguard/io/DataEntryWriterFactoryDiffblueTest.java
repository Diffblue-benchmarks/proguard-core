package proguard.io;

import static org.junit.Assert.assertNull;
import java.security.KeyStore;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFilePool;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class DataEntryWriterFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link DataEntryWriterFactory#DataEntryWriterFactory(ClassPool, ResourceFilePool, int, StringMatcher, int, boolean, boolean, KeyStore.PrivateKeyEntry[])}
   */
  @Test
  public void testNewDataEntryWriterFactory() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();

    // Act and Assert
    assertNull(
        (new DataEntryWriterFactory(KotlinConstants.dummyClassPool, resourceFilePool, 1, new EmptyStringMatcher(), 1,
            true, true, new KeyStore.PrivateKeyEntry[]{null})).createDataEntryWriter(null, 1, 1, null));
  }
}
