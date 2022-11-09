package duke.choice;

public class Customer {
    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    private String name;
    private String size;
    private Clothing[] items;

    public void addItems(Clothing[] items) {
        this.items = items;
    }

    public Clothing[] getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSize(int measurement) {
        switch (measurement) {
            case 1:
            case 2:
            case 3:
                this.size = "S";
                break;
            case 4:
            case 5:
            case 6:
                this.size = "M";
                break;
            case 7:
            case 8:
            case 9:
                this.size = "L";
                break;
            default:
                this.size = "XL";
        }
    }

    public double getTotalClothingCost() {
        double total = 0.0;
        for (Clothing item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double getAverageClothingCost() {
        int count = 0, avg = 0;
        for (Clothing item : items) {
            if (item.getSize() == "L") {
                avg += item.getPrice();
                count++;
            }
        }
        try {
            avg = (count == 0) ? 0 : (avg / count);
        } catch (ArithmeticException e) {
            System.out.println("Divide by Zero");
        }
        return avg;
    }
}
