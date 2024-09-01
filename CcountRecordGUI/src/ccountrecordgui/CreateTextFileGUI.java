/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccountrecordgui;

/**
 *
 * @author abdie
 */
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class CreateTextFileGUI{
    private Formatter output;
    private JTextField resposta;
    private JTextArea displayArea;
    public CreateTextFileGUI() {
        
        // Inicializa o JTextField e JTextArea
        resposta = new JTextField(20);
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        
        // Adiciona componentes ao painel
    }
    public void openFile() {
        try {
            output = new Formatter("clients.txt");
        } catch (SecurityException securityException) {
            JOptionPane.showMessageDialog(null, "Você não tem acesso a esse arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir ou criar arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void addRecords() {
        // Loop para receber entradas do usuário
        while (true) {
            // Mostra uma caixa de entrada para o usuário
            String line = JOptionPane.showInputDialog(null, "Digite o número da conta (> 0), primeiro nome, sobrenome e saldo. Para encerrar a entrada, digite 'sair'.");
            
            if (line == null || line.equalsIgnoreCase("sair")) {
                break;
            }
            
            try {
                String[] inputs = line.split(" ");
                int account = Integer.parseInt(inputs[0]);
                String firstName = inputs[1];
                String lastName = inputs[2];
                double balance = Double.parseDouble(inputs[3]);

                if (account > 0) {
                    output.format("%d %s %s %.2f\n", account, firstName, lastName, balance);
                    displayArea.append(String.format("Conta: %d, Nome: %s %s, Saldo: %.2f\n", account, firstName, lastName, balance));
                } else {
                    JOptionPane.showMessageDialog(null, "O número da conta deve ser maior que 0.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FormatterClosedException formatterClosedException) {
                JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } /*catch (NumberFormatException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }*/
        }
    }

    public void closeFile() {
        if (output != null) {
            output.close();
            String quer = JOptionPane.showInputDialog("Arquivo fechado com sucesso.Deseja verificar os dados?\nSim/Não.");
            if(quer.equalsIgnoreCase("sim")){
                ReadTextFille readFile = new ReadTextFille();
            }
        }
    }
}
