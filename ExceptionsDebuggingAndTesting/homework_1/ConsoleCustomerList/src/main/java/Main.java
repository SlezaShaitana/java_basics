import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            try {
                if (tokens[0].equals("add")) {
                    logger.info(command);
                    executor.addCustomer(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    logger.info("View list");
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    logger.info(command);
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                    logger.info("Quantity request");
                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);
                    logger.info("Request help");
                } else {
                    System.out.println(COMMAND_ERROR);
                    logger.info("Entering a non-existent command");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("Пользователь ввел менее 4 слов");
                System.out.println("Введенная информация неполная");

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                logger.error(e);
            }
        }
    }
}
