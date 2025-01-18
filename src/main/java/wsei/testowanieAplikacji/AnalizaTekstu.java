package wsei.testowanieAplikacji;


public class AnalizaTekstu {

    private String text;

    public AnalizaTekstu(String text) {
        this.text = text;
    }

    public int getLiczbaSlow() {
        String[] slowa = text.split("\\s+");
        return slowa.length;
    }

    public int getLiczbaZdan() {
        String[] zdania = text.split("[.!?]+\\s*");
        return zdania.length;
    }

    public double getSredniaDlugoscSlowa() {
        String[] slowa = text.split("\\s+");
        int dlugoscWszystkichSlow = 0;

        for (String slowo : slowa) {
            dlugoscWszystkichSlow += slowo.length();
        }

        return slowa.length > 0 ? (double) dlugoscWszystkichSlow / slowa.length : 0;
    }

    public int getLiczbaUnikalnychSlow() {
        String[] slowa = text.toLowerCase().replaceAll("[^a-zA-Ząęćłńóśźż\\s]", "").split("\\s+");
        return (int) java.util.Arrays.stream(slowa).distinct().count();
    }

    public int getLiczbaZnakow() {
        return text.replaceAll("\\s", "").length();
    }
}
