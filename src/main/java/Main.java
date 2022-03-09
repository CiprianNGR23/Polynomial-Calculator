///For update GirLab
///1. git commit -a -m "initial commit"
///2. git push -uf origin main

public class Main {

    public static void main(String[] args){

        GUI_APP view = new GUI_APP();

        Operatii operation = new Operatii();

        Controller theController = new Controller(view, operation);

        view.setVisible(true);

    }

}
