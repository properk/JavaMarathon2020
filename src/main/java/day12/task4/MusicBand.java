package day12.task4;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int age;
    private List<String> members;


    public MusicBand(String name, int age, List<String> members) {
        this.name = name;
        this.age = age;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public void printMembers() {
        for (String member : this.members) {
            System.out.println(member);
        }
    }

    public static void transferMembers(MusicBand bandA, MusicBand bandB) {
        //Финальный список
        List<String> finalList = new ArrayList<>();

        //Получаем ссылки на списки групп А и B
        List<String> membersA = bandA.getMembers();
        List<String> membersB = bandB.getMembers();

        //Добавляем всех участников группы А и B в единый список
        finalList.addAll(membersA);
        finalList.addAll(membersB);

        //Обнуляем первый список (A)
        bandA.setMembers(new ArrayList<>());
        //Устанавливаем новый список группе B
        bandB.setMembers(finalList);
    }
}
