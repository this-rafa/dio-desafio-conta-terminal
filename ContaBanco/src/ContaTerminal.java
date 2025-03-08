import java.util.Scanner;

/**
 * Classe que simula a criação de uma conta bancária.
 * 
 * @author Rafael Carvalho
 *         github this-rafa
 * @version 1.0
 * @since 2025-03-07
 */
public class ContaTerminal {

    /**
     * Mensagem de boas-vindas com as informações do cliente.
     */
    public static final String message = "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque";

    /**
     * Construtor padrão da classe ContaTerminal.
     */
    public ContaTerminal() {
        super();
    }

    /**
     * Método principal que executa a simulação da conta bancária.
     * 
     * @param args Argumentos da linha de comando.
     * @throws Exception Se ocorrer um erro durante a execução.
     */
    public static void main(String[] args) throws Exception {

        displayBanner();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o seu nome !");
        String clientName = scanner.nextLine();

        System.out.println("Por favor, digite o número da Agência !");
        String bankBranch = scanner.nextLine();

        System.out.println("Por favor, digite o número da Conta !");
        int accountNumber = (int) scanner.nextInt();

        System.out.println("Por favor, digite o saldo !");
        float balance = (float) scanner.nextFloat();

        clearScreen();

        displayMesaage(message, clientName, bankBranch, accountNumber, balance);
        scanner.close();

    }

    /**
     * Exibe um banner no terminal com uma mensagem de boas-vindas ou outra
     * informação.
     * 
     * Esse método imprime uma mensagem formatada no terminal para destacar uma
     * introdução ou informação importante.
     */
    public static void displayBanner() {
        System.out.println(" ---------------------------- ");
        System.out.println("|          Rafa Bank         |");
        System.out.println(" ---------------------------- ");
    }

    /**
     * Método para exibir a mensagem final.
     * 
     * @param message       A mensagem a ser exibida.
     * @param clientName    O nome do cliente.
     * @param bankBranch    O código da agência bancária.
     * @param accountNumber O número da conta do cliente.
     * @param balance       O saldo da conta do cliente.
     */
    public static void displayMesaage(String message, String clientName, String bankBranch, int accountNumber,
            float balance) {
        System.out.println(String.format(message, clientName, bankBranch, accountNumber, balance));
    }

    /**
     * Limpa a tela do terminal ou console dependendo do sistema operacional.
     * 
     * Esse método verifica o sistema operacional em execução e executa o comando
     * adequado para limpar a tela:
     * - Para sistemas Windows, o comando `cls` é utilizado.
     * - Para sistemas Unix-like (como Linux e macOS), o comando `clear` é
     * utilizado.
     * 
     * @throws Exception Se ocorrer um erro durante a execução.
     */
    public static void clearScreen() throws Exception {

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            return;
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            return;
        }

    }
}
