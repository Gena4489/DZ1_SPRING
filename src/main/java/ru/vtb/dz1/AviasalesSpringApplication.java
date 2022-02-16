package ru.vtb.dz1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtb.dz1.model.Premiere;
import ru.vtb.dz1.services.PremiereService;

@SpringBootApplication
public class AviasalesSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AviasalesSpringApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        //Добавили 2-е премьеры
        System.out.println("---------Добавили 2-е премьеры-------------");
        premiereService.addPremiere(new Premiere("Звездные войны", "Фантастическая сага 'В далекой галактике...'", 10, 100));
        premiereService.addPremiere(new Premiere("Пингвиненок Лоло", "Мультфильм о приключениях пингвиненка Лоло", 3, 50));

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getListPremiere().get(i).toString());
        }

        //Изменили кол-во доступных мест в премьере
        System.out.println("---------Изменили кол-во доступных мест в премьере \"Звездные войны\"-------------");
        premiereService.changePremiere("Звездные войны", null, 0, 90);
        //Добавлена новая премьера
        System.out.println("---------Добавлена новая премьера \"Дом у дороги\"-------------");
        premiereService.addPremiere(new Premiere("Дом у дороги", "Драматическая повесть", 14, 30));

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getListPremiere().get(i).toString());
        }

        //Удалена премьера
        System.out.println("---------Удалена премьера \"Звездные войны\"-------------");
        premiereService.deletePremiere("Звездные войны");

        //Куплено 5 билетов на премьеру
        System.out.println("---------Куплено 5 билетов на премьеру \"Дом у дороги\"-------------");
        if (!premiereService.buyTickets("Дом у дороги", 5)) {
            System.out.println("Все билеты на премьру \"Дом у дороги\" выкуплены");
        }

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getListPremiere().get(i).toString());
        }

        //Вернули 2 билета на премьеру
        System.out.println("---------Вернули 2 билета на премьеру \"Дом у дороги\"-------------");
        premiereService.returnTickets("Дом у дороги", 2);

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getListPremiere().get(i).toString());
        }

        //Вывод информации о премьере
        System.out.println("---------Вывод информации о премьере \"Дом у дороги\"-------------");
        System.out.println(premiereService.getPremeiresInfo("Дом у дороги"));

        //Вывод информации обо всех премьерах
        System.out.println("---------Вывод информации обо всех премьерах-------------");
        System.out.println(premiereService.getPremeiresInfo(null));

    }

}
