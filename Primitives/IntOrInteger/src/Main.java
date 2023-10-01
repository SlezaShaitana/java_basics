public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        for (char i = 'А'; i <= 'я'; i ++) {
                int c = i;
                System.out.println(c + " - " + i);
        }

        char lowercaseLetterYo = 'ё';
        char uppercaseLetterYo = 'Ё';

        int lowercaseLetterYoCode = lowercaseLetterYo;
        int uppercaseLetterYoCode = uppercaseLetterYo;
        System.out.println(lowercaseLetterYoCode + " - " + lowercaseLetterYo);
        System.out.println( uppercaseLetterYoCode + " - " + uppercaseLetterYo);



        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    }
}
