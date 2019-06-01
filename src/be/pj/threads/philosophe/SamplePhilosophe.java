package be.pj.threads.philosophe;

public class SamplePhilosophe {
    public static void main(String[] args) {
        Spoon spoon = new Spoon();
        Spoon spoon1 = new Spoon();
        Spoon spoon2 = new Spoon();
        Spoon spoon3 = new Spoon();
        Spoon spoon4 = new Spoon();


        Philosophe aristote = new Philosophe("Aristote", 10, spoon, spoon1);
        Philosophe socrate = new Philosophe("Socrate", 10, spoon1, spoon2);
        Philosophe platon = new Philosophe("Platon", 10, spoon2, spoon3);
        Philosophe epicure = new Philosophe("Épicure", 10, spoon3, spoon4);
        Philosophe diogene = new Philosophe("Diogène", 10, spoon4, spoon);


        new Thread(aristote).start();
        new Thread(socrate).start();
        new Thread(platon).start();
        new Thread(epicure).start();
        new Thread(diogene).start();
    }
}
