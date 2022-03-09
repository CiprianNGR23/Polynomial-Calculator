import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private GUI_APP view;
    private Operatii operation;
    private Polynomial poly1;
    private Polynomial poly2;

    public Controller(GUI_APP view, Operatii operation){

        this.view = view;
        this.operation = operation;

        this.view.addAdunareListener(new AdunareListener());
        this.view.addScadereListener(new ScadereListener());
        this.view.addInmultireListenere(new InmultireListener());
        this.view.addImpartireListener(new ImpartireListener());
        this.view.addDerivataListener(new DerivataListener());
        this.view.addIntegralaListener(new IntegralaListener());
        this.view.addResetListener(new ResetButtonListener());
    }

    class AdunareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            poly1 = new Polynomial();
            poly2 = new Polynomial();

            try{
                poly1.createMonomFromString(view.getTextPoly1().getText());
                poly2.createMonomFromString(view.getTextPoly2().getText());

                view.setLabelResultText(operation.adunare(poly1, poly2).toString());

            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class ScadereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            poly1 = new Polynomial();
            poly2 = new Polynomial();

            try{
                poly1.createMonomFromString(view.getTextPoly1().getText());
                poly2.createMonomFromString(view.getTextPoly2().getText());

                view.setLabelResultText(operation.scadere(poly1, poly2).toString());

            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class InmultireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            poly1 = new Polynomial();
            poly2 = new Polynomial();

            try{
                poly1.createMonomFromString(view.getTextPoly1().getText());
                poly2.createMonomFromString(view.getTextPoly2().getText());

                view.setLabelResultText(operation.inmultire(poly1, poly2).toString());
            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class ImpartireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            poly1 = new Polynomial();
            poly2 = new Polynomial();

            try{
                poly1.createMonomFromString(view.getTextPoly1().getText());
                poly2.createMonomFromString(view.getTextPoly2().getText());

                view.setLabelResultText(operation.impartire(poly1, poly2));
            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class IntegralaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            poly1 = new Polynomial();
            poly2 = new Polynomial();

            try{
                poly1.createMonomFromString(view.getTextPoly1().getText());

                view.setLabelResultText(operation.integrala(poly1).toString());
            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class DerivataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            poly1 = new Polynomial();
            poly2 = new Polynomial();

            try{
                poly1.createMonomFromString(view.getTextPoly1().getText());

                view.setLabelResultText(operation.derivata(poly1).toString());
            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    class ResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                view.setLabelResultText(operation.resetButtonOp(poly1, poly2));
                view.getTextPoly1().setText("");
                view.getTextPoly2().setText("");
            }
            catch(NumberFormatException ex){
                view.displayErrorMessage("Error 404.");
            } catch (Exception ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }
}
