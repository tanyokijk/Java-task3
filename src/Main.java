import static java.lang.System.out;


import com.aimiko.task3.Dictionary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("family", Arrays.asList("сім'я"));
        dictionary.addWord("city", Arrays.asList("місто"));
        dictionary.addWord("country", Arrays.asList("країна"));
        dictionary.addWord("language", Arrays.asList("мова"));
        dictionary.addWord("music", Arrays.asList("музика"));
        dictionary.addWord("movie", Arrays.asList("фільм"));
        dictionary.addWord("song", Arrays.asList("пісня"));
        dictionary.addWord("art", Arrays.asList("мистецтво"));
        dictionary.addWord("science", Arrays.asList("наука"));
        dictionary.addWord("history", Arrays.asList("історія"));
        dictionary.addWord("math", Arrays.asList("математика"));
        dictionary.addWord("school", Arrays.asList("школа"));
        dictionary.addWord("teacher", Arrays.asList("вчитель"));
        dictionary.addWord("student", Arrays.asList("студент"));
        dictionary.addWord("love", Arrays.asList("любов"));
        dictionary.addWord("peace", Arrays.asList("мир"));
        dictionary.addWord("happiness", Arrays.asList("щастя"));
        dictionary.addWord("strength", Arrays.asList("сила"));
        dictionary.addWord("knowledge", Arrays.asList("знання"));
        dictionary.addWord("world", Arrays.asList("світ"));
        dictionary.addWord("apple", Arrays.asList("яблуко"));
        dictionary.addWord("book", Arrays.asList("книга"));
        dictionary.addWord("car", Arrays.asList("автомобіль"));
        dictionary.addWord("dog", Arrays.asList("собака"));
        dictionary.addWord("house", Arrays.asList("будинок"));
        dictionary.addWord("computer", Arrays.asList("комп'ютер"));
        dictionary.addWord("tree", Arrays.asList("дерево"));
        dictionary.addWord("water", Arrays.asList("вода"));
        dictionary.addWord("fire", Arrays.asList("вогонь"));
        dictionary.addWord("earth", Arrays.asList("земля"));
        dictionary.addWord("sky", Arrays.asList("небо"));
        dictionary.addWord("sun", Arrays.asList("сонце"));
        dictionary.addWord("moon", Arrays.asList("місяць"));
        dictionary.addWord("star", Arrays.asList("зірка"));
        dictionary.addWord("mountain", Arrays.asList("гора"));
        dictionary.addWord("river", Arrays.asList("річка"));
        dictionary.addWord("forest", Arrays.asList("ліс"));
        dictionary.addWord("ocean", Arrays.asList("океан"));
        dictionary.addWord("food", Arrays.asList("їжа"));
        dictionary.addWord("friend", Arrays.asList("друг"));

        Scanner scanner = new Scanner(System.in);
        out.println("Словник англо-український:");
        while (true) {
            out.println("Меню:\n"
                    + "1. Подивитись топ-10 слів.\n"
                    + "2. Подивитись антитоп-10 слів.\n"
                    + "3. Вводити дані для словника.\n"
                    + "4. Показати переклад для слова.\n"
                    + "5. Додати, замінити або видалити переклад слова.\n"
                    + "6. Додати, замінити або видалити слово.\n"
                    + "0. Вихід.\n"
                    + "Зробіть свій вибір:");
            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    dictionary.displayTop10PopularWords();
                    break;
                case 2:
                    dictionary.displayTop10UnpopularWords();
                    break;
                case 3:
                    while (true) {
                        out.println("1. Додати слово з перекладом.\n"
                                + "0. Завершити додавання слів.\n"
                                + "Зробіть свій вибір:");
                        int choise3 = scanner.nextInt();
                        switch (choise3) {
                            case 1:
                                out.println("Введіть англійське слово:");
                                String inputTest = scanner.nextLine();
                                String inputWord = scanner.nextLine();
                                out.println("Введіть переклад:");
                                String wordTranslation = scanner.nextLine();
                                dictionary.addWord(inputWord, Arrays.asList(wordTranslation));
                                out.println("Слово успішно додане.");
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    break;
                case 4:
                    out.println("Введіть слово яке хочете перекласти:");
                    String inputTest = scanner.nextLine();
                    String inputWord = scanner.nextLine();
                    if (!dictionary.getTranslations(inputWord).isEmpty())
                        out.println("Переклад для слова " + inputWord + ": "
                                + dictionary.getTranslations(inputWord));
                    break;
                case 5:
                    out.println("1. Додати перклад слова.\n"
                            + "2. Змінити переклад слова.\n"
                            + "3. Видалити переклад слова.\n");
                    int choise5 = scanner.nextInt();
                    switch (choise5) {
                        case 1:
                            out.println("Введіть англійське слово до якого додати переклад:");
                            String inputTest5 = scanner.nextLine();
                            String inputWord5 = scanner.nextLine();
                            out.println("Введіть переклад:");
                            String wordTranslation = scanner.nextLine();
                            dictionary.addTranslation(inputWord5, wordTranslation);
                            out.println("Слово успішно додане.");
                            break;
                        case 2:
                            out.println(
                                    "Введіть англійське слово до якого потрібно замінити переклад:");
                            String inputTest5_2 = scanner.nextLine();
                            String inputWord5_2 = scanner.nextLine();
                            out.println("Введіть старий переклад, який хочете замінити:");
                            String wordOldTranslation_5_2 = scanner.nextLine();
                            out.println("Введіть новий переклад:");
                            String wordNewTranslation_5_2 = scanner.nextLine();
                            dictionary.replaceTranslations(inputWord5_2, wordOldTranslation_5_2,
                                    wordNewTranslation_5_2);
                            out.println("Переклад успішно змінений.");
                            break;
                        case 3:
                            out.println(
                                    "Введіть англійське слово для якого поітрбно видалити переклад:");
                            String inputTest5_3 = scanner.nextLine();
                            String inputWord5_3 = scanner.nextLine();
                            out.println("Введіть переклад який необхідно видалити:");
                            String wordTranslation_5_3 = scanner.nextLine();
                            dictionary.removeTranslation(inputWord5_3, wordTranslation_5_3);
                            out.println("Переклад успішно видалиний.");
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                    out.println("1. Додати англійське слово.\n"
                            + "2. Змінити англійське слово.\n"
                            + "3. Видалити англійське слово.\n");
                    int choise6 = scanner.nextInt();
                    switch (choise6) {
                        case 1:
                            out.println("Введіть англійське слово для додавання:");
                            String inputTest6_1 = scanner.nextLine();
                            String inputWord6_1 = scanner.nextLine();
                            out.println("Введіть переклад цього слова:");
                            String inputTranslation6_1 = scanner.nextLine();
                            dictionary.addWord(inputWord6_1, Arrays.asList(inputTranslation6_1));
                            out.println("Слово успішно додане.");
                            break;
                        case 2:
                            out.println("Введіть старе англійське слово для заміни:");
                            String inputTest6_2 = scanner.nextLine();
                            String inputOldWord6_2 = scanner.nextLine();
                            out.println("Введіть нове англійське слово для заміни:");
                            String inputNewWord6_2 = scanner.nextLine();
                            dictionary.replaceWord(inputOldWord6_2, inputNewWord6_2);
                            out.println("Слово успішно змінене");
                            break;
                        case 3:
                            out.println("Введіть англійське слово яке потрібно видалити:");
                            String inputTest6_3 = scanner.nextLine();
                            String inputWord6_3 = scanner.nextLine();
                            dictionary.removeWord(inputWord6_3);
                            out.println("Слово успішно видалене.");
                            break;
                        default:
                            break;
                    }
                    break;
                case 0:
                    out.println("Дякую за роботу. До нових зустрічей.");
                    return;
                default:
                    out.println("Ви зробити не корректний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}