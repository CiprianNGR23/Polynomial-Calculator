import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatiiTest {

    private Operatii operation = new Operatii();

    @Test
    void testAdunareFun() {

        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();

        poly1.addMonomToListOfMonom(new Monomial(2, 1));
        poly1.addMonomToListOfMonom(new Monomial(0, 2));

        poly2.addMonomToListOfMonom(new Monomial(1, 2));

        assertEquals("Polynomial { +x^2.0+2.0x+2.0 }", operation.adunare(poly1, poly2).toString());
    }

    @Test
    void testScadereFun() {
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();

        poly1.addMonomToListOfMonom(new Monomial(2, 1));
        poly1.addMonomToListOfMonom(new Monomial(0, 2));

        poly2.addMonomToListOfMonom(new Monomial(1, 2));

        assertEquals("Polynomial { +x^2.0-2.0x+2.0 }", operation.scadere(poly1, poly2).toString());
    }

    @Test
    void testInmultireFun() {
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();

        poly1.addMonomToListOfMonom(new Monomial(2, 1));

        poly2.addMonomToListOfMonom(new Monomial(1, 2));

        assertEquals("Polynomial { +2.0x^3.0 }", operation.inmultire(poly1, poly2).toString());
    }

    @Test
    void testImpartireFun() throws Exception {
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();

        poly1.addMonomToListOfMonom(new Monomial(2, 1));
        poly1.addMonomToListOfMonom(new Monomial(0, 2));

        poly2.addMonomToListOfMonom(new Monomial(1, 1));
        poly2.addMonomToListOfMonom(new Monomial(0, 1));

        assertEquals("C: Polynomial { +x-1 }  R: Polynomial { +3.0 }", operation.impartire(poly1, poly2).toString());
    }

    @Test
    void testIntegralaFun() {

        Polynomial poly1 = new Polynomial();

        poly1.addMonomToListOfMonom(new Monomial(2, 6));
        poly1.addMonomToListOfMonom(new Monomial(1, 2));
        poly1.addMonomToListOfMonom(new Monomial(0, 1));

        assertEquals("Polynomial { +2.0x^3.0+x^2.0+x }", operation.integrala(poly1).toString());
    }

    @Test
    void testDerivataFun() {

        Polynomial poly1 = new Polynomial();

        poly1.addMonomToListOfMonom(new Monomial(2, 6));
        poly1.addMonomToListOfMonom(new Monomial(1, 2));
        poly1.addMonomToListOfMonom(new Monomial(0, 1));

        assertEquals("Polynomial { +12.0x+2.0 }", operation.derivata(poly1).toString());

    }
}