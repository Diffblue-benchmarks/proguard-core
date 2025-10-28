package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class Ir2JRegAssignTransformerDiffblueTest {
  /**
   * Method under test:
   * {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Ir2JRegAssignTransformer.Reg[])}
   */
  @Test
  public void testGroupAndCleanUpByType() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Ir2JRegAssignTransformer.Reg reg = new Ir2JRegAssignTransformer.Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = 'A';

    // Act
    Map<Character, List<Ir2JRegAssignTransformer.Reg>> actualGroupAndCleanUpByTypeResult = ir2JRegAssignTransformer
        .groupAndCleanUpByType(new Ir2JRegAssignTransformer.Reg[]{reg});

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Ir2JRegAssignTransformer.Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(1, getResult.size());
    assertSame(reg, getResult.get(0));
  }

  /**
   * Method under test:
   * {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Ir2JRegAssignTransformer.Reg[])}
   */
  @Test
  public void testGroupAndCleanUpByType2() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Ir2JRegAssignTransformer.Reg reg = new Ir2JRegAssignTransformer.Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = '\u0001';

    HashSet<Ir2JRegAssignTransformer.Reg> regSet = new HashSet<>();
    regSet.add(reg);
    Ir2JRegAssignTransformer.Reg reg2 = new Ir2JRegAssignTransformer.Reg();
    reg2.excludes = regSet;
    reg2.prefers = new HashSet<>();
    reg2.type = 'A';

    // Act
    Map<Character, List<Ir2JRegAssignTransformer.Reg>> actualGroupAndCleanUpByTypeResult = ir2JRegAssignTransformer
        .groupAndCleanUpByType(new Ir2JRegAssignTransformer.Reg[]{reg2});

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Ir2JRegAssignTransformer.Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(1, getResult.size());
    assertSame(reg2, getResult.get(0));
  }

  /**
   * Method under test:
   * {@link Ir2JRegAssignTransformer#groupAndCleanUpByType(Ir2JRegAssignTransformer.Reg[])}
   */
  @Test
  public void testGroupAndCleanUpByType3() {
    // Arrange
    Ir2JRegAssignTransformer ir2JRegAssignTransformer = new Ir2JRegAssignTransformer();
    Ir2JRegAssignTransformer.Reg reg = new Ir2JRegAssignTransformer.Reg();
    reg.excludes = new HashSet<>();
    reg.prefers = new HashSet<>();
    reg.type = '\u0001';

    HashSet<Ir2JRegAssignTransformer.Reg> regSet = new HashSet<>();
    regSet.add(reg);
    Ir2JRegAssignTransformer.Reg reg2 = new Ir2JRegAssignTransformer.Reg();
    reg2.excludes = new HashSet<>();
    reg2.prefers = regSet;
    reg2.type = 'A';

    // Act
    Map<Character, List<Ir2JRegAssignTransformer.Reg>> actualGroupAndCleanUpByTypeResult = ir2JRegAssignTransformer
        .groupAndCleanUpByType(new Ir2JRegAssignTransformer.Reg[]{reg2});

    // Assert
    assertEquals(1, actualGroupAndCleanUpByTypeResult.size());
    List<Ir2JRegAssignTransformer.Reg> getResult = actualGroupAndCleanUpByTypeResult.get('A');
    assertEquals(1, getResult.size());
    assertSame(reg2, getResult.get(0));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Ir2JRegAssignTransformer.Reg}
   */
  @Test
  public void testRegNewReg() {
    // Arrange and Act
    Ir2JRegAssignTransformer.Reg actualReg = new Ir2JRegAssignTransformer.Reg();

    // Assert
    assertEquals('\u0000', actualReg.type);
    assertEquals(-1, actualReg.reg);
    assertTrue(actualReg.excludes.isEmpty());
    assertTrue(actualReg.prefers.isEmpty());
  }
}
