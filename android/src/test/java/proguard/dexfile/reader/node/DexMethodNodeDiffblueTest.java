package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexCodeVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

public class DexMethodNodeDiffblueTest {
  /**
   * Test {@link DexMethodNode#DexMethodNode(DexMethodVisitor, int, Method)}.
   *
   * <ul>
   *   <li>When {@link DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#DexMethodNode(DexMethodVisitor, int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexMethodNode.<init>(int, Method)",
    "void DexMethodNode.<init>(DexMethodVisitor, int, Method)"
  })
  public void testNewDexMethodNode_whenDexMethodVisitor() {
    // Arrange
    DexMethodVisitor mv = new DexMethodVisitor();
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    Method method = (new DexMethodNode(mv, 1, new Method("Owner", "Name", proto))).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertSame(proto, method.getProto());
    assertArrayEquals(new String[] {"Parameter Types"}, method.getParameterTypes());
  }

  /**
   * Test {@link DexMethodNode#DexMethodNode(int, Method)}.
   *
   * <ul>
   *   <li>When {@link Method#Method(String, String, Proto)} with {@code Owner} and {@code Name} and
   *       proto is {@link Proto#Proto(String[], String)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#DexMethodNode(int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexMethodNode.<init>(int, Method)",
    "void DexMethodNode.<init>(DexMethodVisitor, int, Method)"
  })
  public void testNewDexMethodNode_whenMethodWithOwnerAndNameAndProtoIsProto() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    Method method = (new DexMethodNode(1, new Method("Owner", "Name", proto))).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertSame(proto, method.getProto());
    assertArrayEquals(new String[] {"Parameter Types"}, method.getParameterTypes());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    DexMethodNode dexMethodNode = new DexMethodNode(1, new Method("Owner", "Name", proto));
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexMethodNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.anns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(proto, dexMethodNode.method.getProto());
    assertSame(dexMethodNode.method, getResult.method);
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv2() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexMethodNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexMethodNodeList.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv3() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    DexMethodNode dexMethodNode = new DexMethodNode(1, new Method("Owner", "Name", proto));
    dexMethodNode.visitParameterAnnotation(1);
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexMethodNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.anns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(proto, dexMethodNode.method.getProto());
    assertSame(dexMethodNode.method, getResult.method);
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassNode#DexClassNode(int, String, String, String[])}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassNode_thenArrayLengthIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    DexMethodNode dexMethodNode = new DexMethodNode(1, new Method("Owner", "Name", proto));

    // Act
    dexMethodNode.accept(
        new DexClassVisitor(
            new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"})));

    // Assert that nothing has changed
    Method method = dexMethodNode.method;
    assertEquals(1, method.getParameterTypes().length);
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassVisitor() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    DexMethodNode dexMethodNode = new DexMethodNode(1, new Method("Owner", "Name", proto));

    // Act
    dexMethodNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    Method method = dexMethodNode.method;
    assertEquals(1, method.getParameterTypes().length);
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link DexMethodNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexMethodNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv_whenDexClassVisitor_thenArrayLengthIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    DexMethodNode dexMethodNode = new DexMethodNode(1, new Method("Owner", "Name", proto));

    // Act
    dexMethodNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    Method method = dexMethodNode.method;
    assertEquals(1, method.getParameterTypes().length);
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link DexMethodNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexMethodNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodNode.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    dexMethodNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexMethodNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexMethodNode#DexMethodNode(int, Method)} with access is one and method is
   *       {@link Method#Method(String, String, Proto)}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodNode.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexMethodNodeWithAccessIsOneAndMethodIsMethod() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexMethodNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexMethodNode#visitCode()}.
   *
   * <p>Method under test: {@link DexMethodNode#visitCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexCodeVisitor DexMethodNode.visitCode()"})
  public void testVisitCode() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    DexCodeVisitor actualVisitCodeResult = dexMethodNode.visitCode();

    // Assert
    DexCodeNode dexCodeNode = dexMethodNode.codeNode;
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode.debugNode);
    assertEquals(-1, dexCodeNode.totalRegister);
    assertSame(((DexCodeNode) actualVisitCodeResult).stmts, dexCodeNode.stmts);
    assertSame(dexMethodNode.codeNode, actualVisitCodeResult);
  }

  /**
   * Test {@link DexMethodNode#visitCode()}.
   *
   * <p>Method under test: {@link DexMethodNode#visitCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexCodeVisitor DexMethodNode.visitCode()"})
  public void testVisitCode2() {
    // Arrange
    DexMethodVisitor mv = new DexMethodVisitor();
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            mv,
            -1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    DexCodeVisitor actualVisitCodeResult = dexMethodNode.visitCode();

    // Assert
    DexCodeNode dexCodeNode = dexMethodNode.codeNode;
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode.debugNode);
    assertEquals(-1, dexCodeNode.totalRegister);
    assertSame(((DexCodeNode) actualVisitCodeResult).stmts, dexCodeNode.stmts);
    assertSame(dexMethodNode.codeNode, actualVisitCodeResult);
  }

  /**
   * Test {@link DexMethodNode#visitCode()}.
   *
   * <p>Method under test: {@link DexMethodNode#visitCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexCodeVisitor DexMethodNode.visitCode()"})
  public void testVisitCode3() {
    // Arrange
    DexMethodNode mv =
        new DexMethodNode(
            -1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    DexMethodNode dexMethodNode =
        new DexMethodNode(
            mv,
            -1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    DexCodeVisitor actualVisitCodeResult = dexMethodNode.visitCode();

    // Assert
    DexCodeNode dexCodeNode = dexMethodNode.codeNode;
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode.debugNode);
    assertEquals(-1, dexCodeNode.totalRegister);
    assertSame(((DexCodeNode) actualVisitCodeResult).stmts, dexCodeNode.stmts);
    assertSame(dexMethodNode.codeNode, actualVisitCodeResult);
  }

  /**
   * Test {@link DexMethodNode#visitParameterAnnotation(int)}.
   *
   * <ul>
   *   <li>Then second element size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#visitParameterAnnotation(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationAble DexMethodNode.visitParameterAnnotation(int)"
  })
  public void testVisitParameterAnnotation_thenSecondElementSizeIsOne() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types", "("}, "Return Type")));

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodNode.visitParameterAnnotation(1).visitAnnotation("foo", Visibility.BUILD);

    // Assert
    List<DexAnnotationNode>[] listArray = dexMethodNode.parameterAnns;
    List<DexAnnotationNode> dexAnnotationNodeList = listArray[1];
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("foo", getResult.type);
    assertNull(listArray[0]);
    assertEquals(2, listArray.length);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
    assertSame(getResult, actualVisitAnnotationResult);
  }
}
