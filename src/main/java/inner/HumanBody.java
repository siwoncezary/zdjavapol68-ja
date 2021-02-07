package inner;

/**
 * Przykład klasy wewnętrznej niestatycznej
 */
public class HumanBody {
    private Heart heart;

    public HumanBody() {
       heart = new Heart(10);
    }

    public HumanBody(Heart heart) {
        this.heart = heart;
    }

    public void setHeart(Heart heart) {
        this.heart = heart;
    }

    public class Heart{
        double weight;

        public Heart(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Heart{" +
                    "weight=" + weight +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HumanBody{" +
                "heart=" + heart +
                '}';
    }
}
