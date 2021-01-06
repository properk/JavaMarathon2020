package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int age;
    private List<MusicArtist> members;


    public MusicBand(String name, int age, List<MusicArtist> members) {
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

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void setMembers(List<MusicArtist> members) {
        this.members = members;
    }

    public void printMembers() {
        for (MusicArtist member : this.members) {
            System.out.println(member.getName() + " " + member.getAge());
        }
    }

    public static void transferMembers(MusicBand bandA, MusicBand bandB) {
        //Финальный список
        List<MusicArtist> finalList = new ArrayList<>();

        //Получаем ссылки на списки групп А и B
        List<MusicArtist> membersA = bandA.getMembers();
        List<MusicArtist> membersB = bandB.getMembers();

        //Добавляем всех участников группы А и B в единый список
        finalList.addAll(membersA);
        finalList.addAll(membersB);

        //Обнуляем первый список (A)
        bandA.setMembers(new ArrayList<>());
        //Устанавливаем новый список группе B
        bandB.setMembers(finalList);
    }
}
