public class Student extends Persoon {
    private int studentnummer;
    private String studierichting;

    /**
     * Constructor
     */
    public Student() {

    }

    /**
     * Constructor
     * @param BSN
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     * @param studentnummer
     * @param studierichting
     */
    public Student(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int studentnummer, String studierichting) {
        super(BSN, voornaam, achternaam, geboorteDatum, geslacht);

        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentnummer=" + studentnummer +
                ", studierichting='" + studierichting + '\'' +
                '}';
    }
}
