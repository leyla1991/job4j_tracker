package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже" + System.lineSeparator() + "Пешеходы по лужам," + System.lineSeparator()
                    + "А вода - по асфальту рекой." + System.lineSeparator() + "И неясно прохожим" + System.lineSeparator()
                    + "В этот день непогожий," + System.lineSeparator() + "Почему я веселый такой." + System.lineSeparator()
                    + "Припев:" + System.lineSeparator() + "Я играю на гармошке" + System.lineSeparator() + "У прохожих на виду..." + System.lineSeparator()
                    + "К сожаленью, день рожденья" + System.lineSeparator() + "Только раз в году." + System.lineSeparator()
                    + "К сожаленью, день рожденья" + System.lineSeparator() + "Только раз в году." + System.lineSeparator()
                    + "Прилетит вдруг волшебник" + System.lineSeparator() + "В голубом вертолете" + System.lineSeparator()
                    + "И бесплатно покажет кино," + System.lineSeparator() + "С днем рожденья поздравит" + System.lineSeparator()
                    + "И, наверно, оставит" + System.lineSeparator() + "Мне в подарок пятьсот \"эскимо\"." + System.lineSeparator());
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят," + System.lineSeparator()
                    + "Одеяла и подушки ждут ребят." + System.lineSeparator() + "Даже сказка спать ложится," + System.lineSeparator()
                    + "Чтобы ночью нам присниться." + System.lineSeparator() + "Ты ей пожелай: «Баю-бай!»" + System.lineSeparator()
                    + "В сказке можно покататься на Луне," + System.lineSeparator() + "И по радуге промчаться на коне," + System.lineSeparator()
                    + "Со слонёнком подружиться," + System.lineSeparator() + "И поймать перо Жар — птицы," + System.lineSeparator()
                    + "Ты ей пожелай — Баю — бай." + System.lineSeparator() + "Баю-бай, должны все люди ночью спать." + System.lineSeparator()
                    + "Баю-баю, завтра будет день опять." + System.lineSeparator() + "За день мы устали очень," + System.lineSeparator()
                    + "Скажем всем: «Спокойной ночи!»" + System.lineSeparator() + "Глазки закрывай! Баю-бай!" + System.lineSeparator());
        } else {
            System.out.println("Песня не найдена" + System.lineSeparator());
        }
    }

    public static void main(String[] args) {
        Jukebox box = new Jukebox();
        box.music(2);
        box.music(5);
        box.music(1);
    }

}
