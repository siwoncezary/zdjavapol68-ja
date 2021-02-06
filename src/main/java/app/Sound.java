package app;

interface Sound{
    double A_NOTE = 440;

    String getGenerator();

    static double getANote(int octave){
        return A_NOTE*octave;
    }

    private String generateNote(double note){
        return getGenerator() + ": " + note;
    }

    default String generate(){
        return generateNote(getANote(2));
    }
}
