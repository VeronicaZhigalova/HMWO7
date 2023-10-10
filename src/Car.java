import java.util.Locale;

public class Car {

    private String brand;
    private String model;
    private int currentSpeed;
    private int maxSpeed;
    private int numberOfDoors;
    private FuelType fuel;
    private Colors color;

    private Car(String brand, String model, int maxSpeed, int numberOfDoors, FuelType fuel, Colors color) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.numberOfDoors = numberOfDoors;
        this.fuel = fuel;
        this.color = color;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("Can't find such brand");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && !model.isEmpty()) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Can't find such model");
        }
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            throw new IllegalArgumentException("Max speed can't be less than 0");
        }
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors > 0) {
            this.numberOfDoors = numberOfDoors;
        } else {
            throw new IllegalArgumentException("Doors cannot be less than 0");
        }
    }

    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void acceleration(int total) {
        if (total >= 0) {
            currentSpeed += total;
            if (currentSpeed > maxSpeed) {
                currentSpeed = maxSpeed;
            }
        } else {
            throw new IllegalArgumentException("Acceleration can't be less than 0");
        }
    }

    public void braking(int total) {
        if (total >= 0) {
            currentSpeed -= total;
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        } else {
            throw new IllegalArgumentException("Braking can't be less than 0");
        }
    }

    public String getInformation() {
        return String.format("Brand: %s, Model: %s, Current Speed: %d km/h, Max Speed: %d km/h, Number of Doors: %d,  Fuel: %s,  Color: %s,",
                brand,
                model,
                currentSpeed,
                maxSpeed,
                numberOfDoors,
                fuel.toString(),
                color.toString());


    }

    public static class Builder {
        private String brand;
        private String model;
        private int maxSpeed;
        private int numberOfDoors;
        private FuelType fuel;
        private Colors color;


        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;

        }


        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Builder setNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        public Builder setFuel(FuelType fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder setColor(Colors color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(brand, model, maxSpeed, numberOfDoors, fuel, color);
        }

        public static void main(String[] args) {
            Car car = new Car.Builder("Lamborghini ", "Veyron")
                    .setMaxSpeed(360)
                    .setNumberOfDoors(2)
                    .setFuel(FuelType.HYBRID)
                    .setColor(Colors.BLACK)
                    .build();


            System.out.println(car.getInformation());
        }
    }
}

