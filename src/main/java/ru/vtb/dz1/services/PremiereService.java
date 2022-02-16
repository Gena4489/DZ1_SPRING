package ru.vtb.dz1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtb.dz1.model.Premiere;

import java.util.List;

@Service
public class PremiereService {

    private final ListOfPremieres listPremiere;

    @Autowired
    public PremiereService(ListOfPremieres listPremiere) {
        this.listPremiere = listPremiere;
    }

    public void addPremiere(Premiere premiere) {
        listPremiere.addPremiere(premiere);
    }

    public void deletePremiere(String premiereName) {
        listPremiere.deletePremiere(premiereName);
    }


    public void changePremiere(String premiereName, String newDescription,
                               Integer newAgeCategory, Integer newNumberOfSeats) {
        listPremiere.changePremiere(premiereName, newDescription, newAgeCategory, newNumberOfSeats);
    }


    public boolean buyTickets(String premiereName, Integer numTikets) {
        return listPremiere.buyTickets(premiereName, numTikets);
    }

    public void returnTickets(String premiereName, Integer numTikets) {
        listPremiere.returnTickets(premiereName, numTikets);
    }


    public List<Premiere> getListPremiere() {
        return listPremiere.getList();
    }

    public int getListPremiereSize() {
        return listPremiere.getList().size();
    }

    public String getPremeiresInfo(String premiereName) {
        return listPremiere.getPremeiresInfo(premiereName);
    }
}
