/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccountrecordgui;

/**
 *
 * @author abdie
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ccountrecordgui.AccountRecordGUI;
public class ReadTextFille extends JFrame{
    private Scanner input;
    private JPanel panelReadFile;
    private ArrayList<JTextArea> dados = new ArrayList<>();
    public ReadTextFille(){
        super("Lendo Arquivo");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        panelReadFile = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panelReadFile);
        add(scrollPane);
        panelReadFile.setLayout(new GridLayout(0,1));
        openFile();
        readRecords();
        closeFile();
        
    }
    public void openFile(){
        try{
            input = new Scanner(new File("clients.txt"));
        }catch(FileNotFoundException fileNotException){
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo","", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    public void readRecords(){
        AccountRecordGUI record = new AccountRecordGUI();
        JTextArea nomeDados = new JTextArea("Conta " + " Primeiro Nome "+ 
                " Último Nome " + " Saldo ");
        nomeDados.setEditable(false);
        panelReadFile.add(nomeDados);
        try{
            while(input.hasNext()){
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());

                // Cria a string formatada
                String formattedText = String.format("%-10d%-12s%-12s%10.2f\n",
                        record.getAccount(), record.getFirstName(),
                        record.getLastName(), record.getBalance());

                // Cria um JTextArea com o texto formatado
                JTextArea textArea = new JTextArea(formattedText);
                textArea.setEditable(false); // Define como não editável
                textArea.setLineWrap(true);  // Quebra linhas automaticamente

                // Adiciona o JTextArea ao ArrayList e ao JPanel
                dados.add(textArea); // Supondo que dados seja um ArrayList<JTextArea>
                panelReadFile.add(new JScrollPane(textArea));
            }
                
        }catch(NoSuchElementException elementException){
            JOptionPane.showMessageDialog(null, "Arquivo não foi prorpriamente formado","", JOptionPane.ERROR_MESSAGE);
            input.close();
            System.exit(1);
        }catch(IllegalStateException stateException){
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.","", JOptionPane.ERROR_MESSAGE);
        }
        add(panelReadFile);
    }
    public void closeFile(){
        if(input != null){
            input.close();
        }
    }
}
