package enums;
public enum Note {
    //deklaracja stałej to jakby zapis Note C = new Note(frequency)
    C(261.6), Cis(100), D(100), Dis(100), E(200), F(300), Fis(400), G(500), Gis(600), A(700), Ais(800), H(900);

    private final double frequency;

    Note(double frequency) {
        this.frequency = frequency;
    }

    public double getFrequency(Octave octave) {
        return frequency * (octave.ordinal() + 1);
    }
}
