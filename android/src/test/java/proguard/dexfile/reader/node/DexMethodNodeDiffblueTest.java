package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexCodeVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

class DexMethodNodeDiffblueTest {
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
  @DisplayName("Test new DexMethodNode(DexMethodVisitor, int, Method); when DexMethodVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.<init>(int, proguard.dexfile.reader.Method)",
    "void proguard.dexfile.reader.node.DexMethodNode.<init>(proguard.dexfile.reader.visitors.DexMethodVisitor, int, proguard.dexfile.reader.Method)"
  })
  void testNewDexMethodNode_whenDexMethodVisitor() {
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
  @DisplayName(
      "Test new DexMethodNode(int, Method); when Method(String, String, Proto) with 'Owner' and 'Name' and proto is Proto(String[], String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.<init>(int, proguard.dexfile.reader.Method)",
    "void proguard.dexfile.reader.node.DexMethodNode.<init>(proguard.dexfile.reader.visitors.DexMethodVisitor, int, proguard.dexfile.reader.Method)"
  })
  void testNewDexMethodNode_whenMethodWithOwnerAndNameAndProtoIsProto() {
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
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv() {
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
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv2() {
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
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv3() {
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
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; when DexClassVisitor(DexClassVisitor) with dcv is DexClassNode(int, String, String, String[]); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassNode_thenArrayLengthIsOne() {
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
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; when DexClassVisitor(DexClassVisitor) with dcv is DexClassVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassVisitor() {
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
  @DisplayName(
      "Test accept(DexClassVisitor) with 'dcv'; when DexClassVisitor(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv_whenDexClassVisitor_thenArrayLengthIsOne() {
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
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationNode} {@link DexAnnotationVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexAnnotationVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given DexAnnotationNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexMethodVisitor)"
  })
  void testAcceptWithMv_givenDexAnnotationNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    DexAnnotationNode dexAnnotationNode = mock(DexAnnotationNode.class);
    doNothing().when(dexAnnotationNode).visitEnd();
    DexMethodVisitor mv = mock(DexMethodVisitor.class);
    when(mv.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(dexAnnotationNode);

    // Act
    dexMethodNode.accept(mv);

    // Assert
    verify(dexAnnotationNode).visitEnd();
    verify(mv).visitAnnotation(eq("Name"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexMethodVisitor) with 'mv'; given DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexMethodVisitor)"
  })
  void testAcceptWithMv_givenDexAnnotationVisitor() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    DexMethodVisitor mv = mock(DexMethodVisitor.class);
    when(mv.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor());

    // Act
    dexMethodNode.accept(mv);

    // Assert
    verify(mv).visitAnnotation(eq("Name"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodNode#accept(DexMethodVisitor)} with {@code mv}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)} with
   *       visitor is {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodNode#accept(DexMethodVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexMethodVisitor) with 'mv'; given DexAnnotationVisitor(DexAnnotationVisitor) with visitor is DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexMethodNode.accept(proguard.dexfile.reader.visitors.DexMethodVisitor)"
  })
  void testAcceptWithMv_givenDexAnnotationVisitorWithVisitorIsDexAnnotationVisitor() {
    // Arrange
    DexMethodNode dexMethodNode =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    dexMethodNode.visitAnnotation("Name", Visibility.BUILD);
    DexMethodVisitor mv = mock(DexMethodVisitor.class);
    when(mv.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationVisitor()));

    // Act
    dexMethodNode.accept(mv);

    // Assert
    verify(mv).visitAnnotation(eq("Name"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexMethodNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.node.DexMethodNode.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation() {
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
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexMethodNode(int, Method) with access is one and method is Method(String, String, Proto)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.node.DexMethodNode.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_givenDexMethodNodeWithAccessIsOneAndMethodIsMethod() {
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
  @DisplayName("Test visitCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor proguard.dexfile.reader.node.DexMethodNode.visitCode()"
  })
  void testVisitCode() {
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
  @DisplayName("Test visitCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor proguard.dexfile.reader.node.DexMethodNode.visitCode()"
  })
  void testVisitCode2() {
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
  @DisplayName("Test visitCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor proguard.dexfile.reader.node.DexMethodNode.visitCode()"
  })
  void testVisitCode3() {
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
  @DisplayName("Test visitParameterAnnotation(int); then second element size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationAble proguard.dexfile.reader.node.DexMethodNode.visitParameterAnnotation(int)"
  })
  void testVisitParameterAnnotation_thenSecondElementSizeIsOne() {
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
