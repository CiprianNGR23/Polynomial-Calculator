public class Operatii {

    public Operatii(){
        super();
    }

    public void resetElementFundInEachMonomOf(Polynomial poly){
        for(Monomial mono: poly.getListOfMonom()){
            mono.setFound(false);
        }
    }

    public Polynomial adunare(Polynomial poly1, Polynomial poly2){

        resetElementFundInEachMonomOf(poly1);
        resetElementFundInEachMonomOf(poly2);

        Polynomial polyReturn = new Polynomial();
        boolean okAdd = false;

        for(Monomial monoP1: poly1.getListOfMonom()) {
            okAdd = false;
            for (Monomial monoP2 : poly2.getListOfMonom()) {
                if (monoP1.getExp() == monoP2.getExp()) {
                    monoP1.setFound(true); monoP2.setFound(true);
                    if(monoP1.getCoef() - monoP2.getCoef() != 0.0f)
                        polyReturn.addMonomToListOfMonom(new Monomial(monoP1.getExp(), monoP1.getCoef() + monoP2.getCoef()));
                    okAdd = true;
                }
            }
            if(!okAdd){
                polyReturn.addMonomToListOfMonom(new Monomial(monoP1.getExp(), monoP1.getCoef()));
            }
        }
        for(Monomial monoP2: poly2.getListOfMonom()){
            if(!monoP2.isFound()){
                polyReturn.addMonomToListOfMonom(new Monomial(monoP2.getExp(), monoP2.getCoef()));
            }
        }
        polyReturn.sortPolynomial();

        return polyReturn;
    }

    public Polynomial scadere(Polynomial poly1, Polynomial poly2){

        resetElementFundInEachMonomOf(poly1);
        resetElementFundInEachMonomOf(poly2);

        Polynomial polyReturn = new Polynomial();
        boolean okAdd = false;

        for(Monomial monoP1: poly1.getListOfMonom()){
            okAdd = false;
            for(Monomial monoP2: poly2.getListOfMonom()){
                if(monoP1.getExp() == monoP2.getExp()){
                    monoP1.setFound(true); monoP2.setFound(true);
                    if(monoP1.getCoef() - monoP2.getCoef() != 0.0f)
                        polyReturn.addMonomToListOfMonom(new Monomial(monoP1.getExp(), monoP1.getCoef() - monoP2.getCoef()));
                    okAdd = true;
                }
            }
            if(!okAdd){
                polyReturn.addMonomToListOfMonom(new Monomial(monoP1.getExp(), monoP1.getCoef()));
            }
        }
        for(Monomial monoP2: poly2.getListOfMonom()){
            if(!monoP2.isFound()){
                polyReturn.addMonomToListOfMonom(new Monomial(monoP2.getExp(), -monoP2.getCoef()));
            }
        }
        polyReturn.sortPolynomial();

        return polyReturn;
    }

    public Polynomial inmultire(Polynomial poly1, Polynomial poly2){

        resetElementFundInEachMonomOf(poly1);
        resetElementFundInEachMonomOf(poly2);

        Polynomial polyReturn = new Polynomial();
        Polynomial polyProdus = new Polynomial();

        for(Monomial monoP1: poly1.getListOfMonom()){
            for(Monomial monoP2: poly2.getListOfMonom()){
                polyProdus.addMonomToListOfMonom(new Monomial(monoP1.getExp() + monoP2.getExp(), monoP1.getCoef() * monoP2.getCoef()));
            }
        }
        double sum = 0.0f;
        for(Monomial monoPP1: polyProdus.getListOfMonom()){
            sum = monoPP1.getCoef();
            for(Monomial monoPP2: polyProdus.getListOfMonom()){
                if(monoPP1 != monoPP2 && monoPP1.getExp() == monoPP2.getExp() && !monoPP2.isFound()){
                    sum += monoPP2.getCoef();
                    monoPP2.setFound(true);
                }
            }
            if(!monoPP1.isFound()){
                polyReturn.addMonomToListOfMonom(new Monomial(monoPP1.getExp(), sum));
                monoPP1.setFound(true);
            }
        }
        polyReturn.sortPolynomial();

        return polyReturn;
    }

    public Polynomial inmultireMonomialAndPolynomial(Monomial monom, Polynomial poly){

        Polynomial polyReturn = new Polynomial();

        for(Monomial monoP: poly.getListOfMonom()){
            polyReturn.addMonomToListOfMonom(new Monomial(monoP.getExp() + monom.getExp(), monoP.getCoef() * monom.getCoef()));
        }
        polyReturn.sortPolynomial();

        return polyReturn;
    }

    public String impartire(Polynomial poly1, Polynomial poly2) throws Exception {

        resetElementFundInEachMonomOf(poly1);
        resetElementFundInEachMonomOf(poly2);

        poly1.sortPolynomial();
        poly2.sortPolynomial();

        Polynomial polyReturnCat = new Polynomial();

        Monomial firstOfPoly2 = new Monomial();
        Monomial monoP1 = new Monomial();

        if(!poly2.getListOfMonom().isEmpty())
            firstOfPoly2 = poly2.getListOfMonom().getFirst();
        if(!poly1.getListOfMonom().isEmpty())
            monoP1 = poly1.getListOfMonom().getFirst();
        while(monoP1.getExp() >= firstOfPoly2.getExp() && !poly1.getListOfMonom().isEmpty()){

            //System.out.println("monoP1: " + monoP1.getCoef() + "x^" + monoP1.getExp());
            if(firstOfPoly2.getCoef() != 0.0f) {
                Monomial monomAux = new Monomial(monoP1.getExp() - firstOfPoly2.getExp(), monoP1.getCoef() / firstOfPoly2.getCoef());
                //System.out.println("Monom: " + monomAux.getCoef() + "x^" + monomAux.getExp());
                polyReturnCat.addMonomToListOfMonom(monomAux);

                poly1.setListOfMonom(scadere(poly1, inmultireMonomialAndPolynomial(monomAux, poly2)).getListOfMonom());
                //System.out.println("Polinom: " + poly1.toString());
            } else {
                throw new Exception("Eroare la impartirea polinoamelor!");
            }
            if(!poly1.getListOfMonom().isEmpty())
                monoP1 = poly1.getListOfMonom().getFirst();
        }

        return "C: " + polyReturnCat.toString() + "  R: " + poly1.toString();
    }

    public Polynomial integrala(Polynomial poly1){

        Polynomial polyReturn = new Polynomial();

        for(Monomial monom: poly1.getListOfMonom()){
            polyReturn.addMonomToListOfMonom(new Monomial(monom.getExp()+1,
                    Double.parseDouble(String.format("%.2f", monom.getCoef() / (monom.getExp() + 1) ))));
        }
        polyReturn.sortPolynomial();

        return polyReturn;
    }

    public Polynomial derivata(Polynomial poly1){

        Polynomial polyReturn = new Polynomial();

        for(Monomial monom: poly1.getListOfMonom()){
            if(monom.getExp() * monom.getCoef() != 0.0f)
                polyReturn.addMonomToListOfMonom(new Monomial(monom.getExp()-1,
                        Double.parseDouble(String.format("%.2f", monom.getCoef() * monom.getExp() ))));
        }
        polyReturn.sortPolynomial();

        return polyReturn;
    }

    public String resetButtonOp(Polynomial poly1, Polynomial poly2){
        poly1.getListOfMonom().clear();
        poly2.getListOfMonom().clear();
        return "Resetul s-a realizat cu succes!";
    }
}
