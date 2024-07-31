class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private String powerSupply;
    private String motherboard;
    private String coolingSystem;
    private boolean isOverclocked;
    private boolean isBluetoothEnabled;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
        this.motherboard = builder.motherboard;
        this.coolingSystem = builder.coolingSystem;
        this.isOverclocked = builder.isOverclocked;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return  "CPU=" + CPU +
                "\nRAM=" + RAM +
                "\nstorage=" + storage +
                "\ngraphicsCard='" + graphicsCard + 
                "\npowerSupply='" + powerSupply + 
                "\nmotherboard='" + motherboard + 
                "\ncoolingSystem='" + coolingSystem + 
                "\nisOverclocked=" + isOverclocked +
                "\nisBluetoothEnabled=" + isBluetoothEnabled + '\n';
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String powerSupply;
        private String motherboard;
        private String coolingSystem;
        private boolean isOverclocked;
        private boolean isBluetoothEnabled;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Builder setOverclocked(boolean isOverclocked) {
            this.isOverclocked = isOverclocked;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .setCoolingSystem("Liquid Cooling")
                .setOverclocked(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGraphicsCard("Integrated Graphics")
                .setPowerSupply("450W")
                .setMotherboard("Gigabyte")
                .setCoolingSystem("Air Cooling")
                .setOverclocked(false)
                .setBluetoothEnabled(false)
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
