package proguard.classfile.util.inject.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.testutils.cpa.NamedMember;

public class FirstBlockDiffblueTest {
  /**
   * Method under test:
   * {@link FirstBlock#getSingleInjectionLocation(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testGetSingleInjectionLocation() {
    // Arrange
    FirstBlock firstBlock = new FirstBlock();
    ProgramClass targetClass = new ProgramClass();

    // Act
    InjectStrategy.InjectLocation actualSingleInjectionLocation = firstBlock.getSingleInjectionLocation(targetClass,
        new NamedMember("Member Name", "Descriptor"));

    // Assert
    assertEquals(0, actualSingleInjectionLocation.getOffset());
    assertTrue(actualSingleInjectionLocation.shouldInjectBefore());
  }

  /**
   * Method under test:
   * {@link FirstBlock#getAllSuitableInjectionLocation(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testGetAllSuitableInjectionLocation() {
    // Arrange
    FirstBlock firstBlock = new FirstBlock();
    ProgramClass targetClass = new ProgramClass();

    // Act
    InjectStrategy.InjectLocation[] actualAllSuitableInjectionLocation = firstBlock
        .getAllSuitableInjectionLocation(targetClass, new NamedMember("Member Name", "Descriptor"));

    // Assert
    InjectStrategy.InjectLocation injectLocation = actualAllSuitableInjectionLocation[0];
    assertEquals(0, injectLocation.getOffset());
    assertEquals(1, actualAllSuitableInjectionLocation.length);
    assertTrue(injectLocation.shouldInjectBefore());
  }
}
