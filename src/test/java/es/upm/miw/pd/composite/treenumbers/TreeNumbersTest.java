package es.upm.miw.pd.composite.treenumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.pd.composite.treenumbers.TreeNumbers;

public class TreeNumbersTest {
    private TreeNumbers root;

    private TreeNumbers sub1;

    private TreeNumbers sub11;

    private TreeNumbers sub12;

    private TreeNumbers leaf;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void ini() {
        this.root = new TreeNumbers("raiz");

        this.leaf = new TreeNumbers(1);
        this.root.add(leaf);
        this.sub1 = new TreeNumbers("sub1");
        this.root.add(sub1);
        this.root.add(new TreeNumbers(7));

        this.sub11 = new TreeNumbers("sub11");
        this.sub1.add(sub11);
        this.sub1.add(new TreeNumbers(4));
        this.sub12 = new TreeNumbers("sub12");
        this.sub1.add(sub12);

        this.sub11.add(new TreeNumbers(2));
        this.sub11.add(new TreeNumbers(3));

        this.sub12.add(new TreeNumbers(-5));
        this.sub12.add(new TreeNumbers(6));
    }

    @Test
    public void testNumberOfTreeNumbersIfLeaf() {
        assertEquals(1, this.leaf.numberOfTreeNumbers());
    }

    @Test
    public void testNumberOfTreeNumbersIfComposite() {
        assertEquals(3, this.root.numberOfTreeNumbers());
        assertEquals(2, this.sub11.numberOfTreeNumbers());
    }

    @Test
    public void testSumIfLeaf() {
        assertEquals(1, this.leaf.sum());
    }

    @Test
    public void testSumIfComposite() {
        assertEquals(18, this.root.sum());
    }

    @Test
    public void testHigherIfLeaf() {
        assertEquals(1, this.leaf.higher());
    }

    @Test
    public void testHigherIfComposite() {
        assertEquals(7, this.root.higher());
    }

    @Test
    public void testAddLeaf() {
        exception.expect(UnsupportedOperationException.class);
        this.leaf.add(new TreeNumbers(2));
    }

}
