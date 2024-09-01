/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ccountrecordgui;

/**
 *
 * @author abdie
 */
import javax.swing.JFrame;
public class CcountRecordGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CreateTextFileGUI aplicacao = new CreateTextFileGUI();
        aplicacao.openFile();
        aplicacao.addRecords();
        aplicacao.closeFile();
    }
}
