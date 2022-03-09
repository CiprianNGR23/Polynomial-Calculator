import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private LinkedList<Monomial> listOfMonom;

    public Polynomial() {
        this.listOfMonom = new LinkedList<Monomial>();
    }

    public Polynomial(LinkedList<Monomial> listOfMonom) {
        this.listOfMonom = listOfMonom;
    }

    public void addMonomToListOfMonom(Monomial monom) {
        listOfMonom.add(monom);
    }

    public boolean checkStringForErrors(String string){
        String standard = "x^1234567890-+";
        for(String index: string.split("")){
            if(!standard.contains(index)){
                return false;
            }
        }
        return true;
    }

    public void createMonomFromString(String string) throws Exception {
        final String regex = "([+-]?\\d*)x(\\^(\\d+))?|([+-]?\\d+)";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        if(!checkStringForErrors(string)){
            throw new Exception("Polinomul introdus este incorect!");
        }

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                double coef = matcher.group(1).equals("") ? 1 : matcher.group(1).equals("-") ? -1 : matcher.group(1).equals("+") ? +1 : Double.parseDouble(matcher.group(1));
                double exp = matcher.group(3) == null ? 1 : Double.parseDouble(matcher.group(3));
                addMonomToListOfMonom(new Monomial(exp, coef));
            } else if(matcher.group(3) != null){
                addMonomToListOfMonom(new Monomial(matcher.group(3).equals("") ? 1 : Double.parseDouble(matcher.group(3)), 0));
            } else {
                addMonomToListOfMonom(new Monomial(0, Double.parseDouble(matcher.group(4))));
            }
        }

    }

    public void setListOfMonom(LinkedList<Monomial> listOfMonom) {
        this.listOfMonom = listOfMonom;
    }

    public LinkedList<Monomial> getListOfMonom() {
        return listOfMonom;
    }

    public void sortPolynomial(){
        Collections.sort(listOfMonom, new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Override
    public String toString() {
        String polyPrint = "";
        for(Monomial m: getListOfMonom()){
            polyPrint += (m.getCoef() < 0 && m.getCoef() != -1.0f ? m.getCoef()
                    : m.getCoef() < 0.0f && m.getCoef() == -1.0f && m.getExp() == 0.0f ? "-1"
                    : m.getCoef() < 0.0f && m.getCoef() == -1.0f && m.getExp() != 0.0f ? "-"
                    : m.getCoef() == 1.0f && m.getExp() != 0.0f ? "+"
                    : m.getCoef() == 1.0f && m.getExp() == 0.0f ? "+1" : "+" + m.getCoef()) +
                    (m.getExp() > 1.0f ? "x^"+m.getExp() : m.getExp() > 0.0f ? "x" : "" );
        }
        return "Polynomial { " +
                polyPrint
                +" }";
    }
}
