package day13;

public class Task1 {
    public static void main(String[] args) {
        //Создаем 3-х пользователей
        User user1 = new User("Tom");
        User user2 = new User("Jerry");
        User user3 = new User("Bob");

        //Отправить 2 сообщения от пользователя 1 пользователю 2
        user1.sendMessage(user2, "Привет, " + user2.getUsername());
        user1.sendMessage(user2, "Как у тебя дела?");

        //Отправить 3 сообщения от пользователя 2 пользователю 1
        user2.sendMessage(user1, "О, привет " + user1.getUsername() + "!");
        user2.sendMessage(user1, "Дела идут хреново, могло бы быть и лучше...");


        //Отправить 3 сообщения от пользователя 3 пользователю 1
        user3.sendMessage(user1, "Здарова, когда долг вернешь?");
        user3.sendMessage(user1, "Вроде договаривались, что через месяц, вот месяц прошел");
        user3.sendMessage(user1, "Я так просто не отстану");


        //Отправить 3 сообщения от пользователя 1 пользователю 3
        user1.sendMessage(user3, "Привет. Извини, что долго не отвечал");
        user1.sendMessage(user3, "Через 15 минут смогу сделать перевод.");
        user1.sendMessage(user3, "Скинь номер карты. Спасибо, что тогда выручил!");


        //Отправить 1 сообщение от пользователя 3 пользователю 1
        user3.sendMessage(user1, "Отлично, вот номер карты 4873 8375 8274 6636");

        MessageDatabase.showDialog(user1, user3);
    }
}
