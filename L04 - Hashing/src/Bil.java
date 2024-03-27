import java.util.Objects;

public class Bil {

    private String mærke;
    private String model;
    private String farve;
    private String regNr;

    public Bil(String mærke, String model, String farve, String regNr) {
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
        this.regNr = regNr;
    }

    @Override
    public String toString() {
        return mærke + " " + model + " " + farve;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bil bil = (Bil) o;
        return Objects.equals(mærke, bil.mærke) && Objects.equals(regNr, bil.regNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mærke, regNr);
    }
}
