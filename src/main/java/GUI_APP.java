import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI_APP extends JFrame{

    private JPanel panel1;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton impartireButton;
    private JButton integralaButton;
    private JButton derivataButton;
    private JTextField textPoly2;
    private JTextField textPoly1;
    private JLabel labelResult;
    private JButton RESETButton;

    public GUI_APP(){
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public JButton getAdunareButton() {
        return adunareButton;
    }

    public JButton getScadereButton() {
        return scadereButton;
    }

    public JButton getInmultireButton() {
        return inmultireButton;
    }

    public JButton getImpartireButton() {
        return impartireButton;
    }

    public JButton getIntegralaButton() {
        return integralaButton;
    }

    public JButton getDerivataButton() {
        return derivataButton;
    }

    public JTextField getTextPoly1() {
        return textPoly1;
    }

    public JTextField getTextPoly2() {
        return textPoly2;
    }

    public void setLabelResultText(String string) {
        this.labelResult.setText(string);
    }

    public JLabel getLabelResult() {
        return labelResult;
    }

    public JButton getRESETButton() {
        return RESETButton;
    }

    public void addAdunareListener(ActionListener listenForAdunareButton){
        adunareButton.addActionListener(listenForAdunareButton);
    }

    public void addScadereListener(ActionListener listenForScadereButton){
        scadereButton.addActionListener(listenForScadereButton);
    }

    public void addInmultireListenere(ActionListener listenForInmultireButton){
        inmultireButton.addActionListener(listenForInmultireButton);
    }

    public void addImpartireListener(ActionListener listenForImpartireButton){
        impartireButton.addActionListener(listenForImpartireButton);
    }

    public void addDerivataListener(ActionListener listenForDerivataButton){
        derivataButton.addActionListener(listenForDerivataButton);
    }

    public void addIntegralaListener(ActionListener listenForIntegralaButton){
        integralaButton.addActionListener(listenForIntegralaButton);
    }

    public void addResetListener(ActionListener listeFofResetButton){
        RESETButton.addActionListener(listeFofResetButton);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
