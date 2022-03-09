public class Monomial {

    private double exp;
    private double coef;
    private boolean found;

    public Monomial(){
        super();
    }

    public Monomial(double exp, double coef){
        this.exp = exp;
        this.coef = coef;
        this.found = false;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int compareTo(Monomial o2) {
        if(this.getExp() < o2.getExp())
            return 1;
        return -1;
    }
}
