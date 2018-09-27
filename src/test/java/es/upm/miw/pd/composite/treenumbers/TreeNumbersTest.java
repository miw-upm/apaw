package es.upm.miw.pd.composite.treenumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreeNumbersTest {

    private TreeNumbers root;

    private TreeNumbers sub11;

    private TreeNumbers leaf;

    @BeforeEach
    void ini() {
        TreeNumbers sub1;
        TreeNumbers sub12;
        this.root = new TreeNumbers("raiz");

        this.leaf = new TreeNumbers(1);
        this.root.add(leaf);
        sub1 = new TreeNumbers("sub1");
        this.root.add(sub1);
        this.root.add(new TreeNumbers(7));

        this.sub11 = new TreeNumbers("sub11");
        sub1.add(sub11);
        sub1.add(new TreeNumbers(4));
        sub12 = new TreeNumbers("sub12");
        sub1.add(sub12);

        this.sub11.add(new TreeNumbers(2));
        this.sub11.add(new TreeNumbers(3));

        sub12.add(new TreeNumbers(-5));
        sub12.add(new TreeNumbers(6));
    }

    @Test
    void testNumberOfTreeNumbersIfLeaf() {
        assertEquals(1, this.leaf.numberOfNodes());
    }

    @Test
    void testNumberOfTreeNumbersIfComposite() {
        assertEquals(3, this.root.numberOfNodes());
        assertEquals(2, this.sub11.numberOfNodes());
    }

    @Test
    void testSumIfLeaf() {
        assertEquals(1, this.leaf.sum());
    }

    @Test
    void testSumIfComposite() {
        assertEquals(18, this.root.sum());
    }

    @Test
    void testHigherIfLeaf() {
        assertEquals(1, this.leaf.higher());
    }

    @Test
    void testHigherIfComposite() {
        assertEquals(7, this.root.higher());
    }

    @Test
    void testAddLeaf() {
        assertThrows(UnsupportedOperationException.class, () -> this.leaf.add(new TreeNumbers(2)));
    }

}
