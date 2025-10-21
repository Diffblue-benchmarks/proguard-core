package proguard.io;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.KeyStore.PrivateKeyEntry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFilePool;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class DataEntryWriterFactoryDiffblueTest {
  /**
   * Test {@link DataEntryWriterFactory#DataEntryWriterFactory(ClassPool, ResourceFilePool, int,
   * StringMatcher, int, boolean, boolean, PrivateKeyEntry[])}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#DataEntryWriterFactory(ClassPool,
   * ResourceFilePool, int, StringMatcher, int, boolean, boolean, PrivateKeyEntry[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DataEntryWriterFactory.<init>(ClassPool, ResourceFilePool, int, StringMatcher, int, boolean, boolean, PrivateKeyEntry[])"
  })
  public void testNewDataEntryWriterFactory() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();

    // Act and Assert
    assertNull(
        (new DataEntryWriterFactory(
                KotlinConstants.dummyClassPool,
                resourceFilePool,
                1,
                new EmptyStringMatcher(),
                1,
                true,
                true,
                new PrivateKeyEntry[] {null}))
            .createDataEntryWriter(null, 1, 1, null));
  }
}
