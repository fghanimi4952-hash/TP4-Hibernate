package test;

import entities.Machine;
import entities.Salle;
import services.MachineService;
import services.SalleService;

public class Test {
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // Création d’une salle
        Salle s1 = new Salle("S1", "Salle Informatique");
        salleService.save(s1);

        // Ajout de machines
        machineService.save(new Machine("M1", "HP", s1));
        machineService.save(new Machine("M2", "DELL", s1));

        // Affichage
        salleService.findAll().forEach(s -> {
            System.out.println("Salle : " + s.getNom());
            s.getMachines().forEach(m ->
                    System.out.println(" - Machine : " + m.getReference() + " (" + m.getMarque() + ")")
            );
        });
    }
}
