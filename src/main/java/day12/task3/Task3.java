package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task3 {

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        ArrayList<MusicBand> listAfter2000 = new ArrayList<>();

        for (MusicBand band : bands) {
            if (band.getAge() > 2000) {
                listAfter2000.add(band);
            }
        }

        return listAfter2000;
    }

    public static void main(String[] args) {

        //Создаем коллекцию и заполняем группами
        List<MusicBand> list = new ArrayList<>();
        list.add(new MusicBand("Банд’Эрос", 2005));
        list.add(new MusicBand("Apocalyptica", 1993));
        list.add(new MusicBand("Backstreet Boys", 1993));
        list.add(new MusicBand("Rock Mafia ", 2010));
        list.add(new MusicBand("ВИА Гра", 2000));
        list.add(new MusicBand("Блестящие", 1995));
        list.add(new MusicBand("Чай вдвоём", 1994));
        list.add(new MusicBand("One Direction", 2010));
        list.add(new MusicBand("Bomfunk MC’s", 1998));
        list.add(new MusicBand("Japandroids", 2012));

        //Перемешивание коллекции
        Collections.shuffle(list);

        //Получаем список групп, основанных после 2000 года
        List<MusicBand> listAfter2000 = groupsAfter2000(list);

        //Вывод на экран содержимого оригинального list
        for (MusicBand band : list) {
            System.out.println(band.getName());
        }

        System.out.println("----------------------");
        //Вывод содержимого listAfter2000
        for (MusicBand band : listAfter2000) {
            System.out.println(band.getName());
        }
    }
}
