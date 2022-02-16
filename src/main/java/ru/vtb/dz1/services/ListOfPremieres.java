package ru.vtb.dz1.services;

import org.springframework.stereotype.Component;
import ru.vtb.dz1.model.Premiere;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListOfPremieres {
    private final List<Premiere> list;

    public ListOfPremieres() {
        list = new ArrayList<>();
    }

    public List<Premiere> getList() {
        return list;
    }

    public void addPremiere(Premiere premiere) {
        list.add(premiere);
    }

    public void deletePremiere(String premiereName) {
        for (Premiere p : list) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                list.remove(p);
                return;
            }
        }
    }

    public void changePremiere(String premiereName, String newDescription,
                               Integer newAgeCategory, Integer newNumberOfSeats) {
        for (Premiere p : list) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                if (newDescription != null) {
                    p.setDescription(newDescription);
                }
                if (newAgeCategory > 0) {
                    p.setAgeCategory(newAgeCategory);
                }
                if (newAgeCategory >= 1) {
                    p.setAgeCategory(newAgeCategory);
                }
                if (newNumberOfSeats >= 1) {
                    p.setNumberOfSeats(newNumberOfSeats);
                }
            }
        }

    }

    public boolean buyTickets(String premiereName, Integer numTikets) {
        for (Premiere p : list) {
            if (p.getName().equalsIgnoreCase(premiereName) && p.getNumberOfSeats() - numTikets >= 0) {
                p.setNumberOfSeats(p.getNumberOfSeats() - numTikets);
                return true;
            }
        }
        return false;
    }

    public void returnTickets(String premiereName, Integer numTikets) {
        for (Premiere p : list) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                p.setNumberOfSeats(p.getNumberOfSeats() + numTikets);
            }
        }
    }

    public String getPremeiresInfo(String premiereName) {
        StringBuilder sb = new StringBuilder();
        for (Premiere p : list) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                return p.toString();
            } else {
                sb.append(p.toString()).append("\n");
            }

        }
        return sb.toString();
    }


}
