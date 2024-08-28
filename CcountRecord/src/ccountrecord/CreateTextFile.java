/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ccountrecord;

/**
 *
 * @author Aluno
 */
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ccountrecord.AccountRecord;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    private Formatter output;

    public void openFile() {
        try {
            output = new Formatter("clients.txt");
            System.out.println("Arquivo criado com sucesso.");
        } catch (SecurityException securityException) {
            System.err.println("Você não tem acesso a esse arquivo.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao abrir ou criar arquivo.");
            System.exit(1);
        }
    }

    public void addRecords() {
        AccountRecord record = new AccountRecord();
        Scanner input = new Scanner(System.in);

        System.out.printf("%s\n%s\n%s\n%s\n\n",
                "Para encerrar a entrada, digite o indicador de fim de arquivo",
                "Quando for solicitado a digitar.",
                "No UNIX/LINUX/Mac OS X, digite <ctrl> d e pressione Enter",
                "No Windows, digite <ctrl> z e pressione Enter");

        System.out.printf("%s\n%s",
                "Digite o número da conta (> 0), primeiro nome, sobrenome e saldo.", "?");
        while (input.hasNext()) {
            try {
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());

                if (record.getAccount() > 0) {
                    output.format("%d %s %s %.2f\n",
                            record.getAccount(), record.getFirstName(),
                            record.getLastName(), record.getBalance());
                    System.out.println("Adicionado com sucesso.");
                } else {
                    System.out.println("O número da conta deve ser maior que 0.");
                }
            } catch (FormatterClosedException elementException) {
                System.err.println("Erro ao escrever no arquivo.");
                return;
            } catch (NoSuchElementException elementException) {
                System.err.println("Entrada inválida. Por favor, tente novamente.");
                input.nextLine();
            }
            System.out.printf("%s %s\n%s","Enter account number(> 0)",", fistr name, last name and balance.", "?");
        }
    }

    public void closeFile() {
        System.out.println("Cheguei aq.");
        if (output != null) {
            output.close();
            System.out.println("Arquivo fechado com sucesso.");
        }
    }
}
