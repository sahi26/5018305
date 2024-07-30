public class Computer {
    private String CPU;
    private String RAM;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    /*
     * public String getCPU() {
     * return CPU;
     * }
     * 
     * public String getRAM() {
     * return RAM;
     * }
     * 
     * public String getStorage() {
     * return storage;
     * }
     */

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        /*
         * public Builder setCPU(String CPU) {
         * this.CPU = CPU;
         * return this;
         * 
         * }
         * 
         * public Builder setRAM(String RAM) {
         * this.RAM = RAM;
         * return this;
         * }
         * 
         * public Builder setStorage(String storage) {
         * this.storage = storage;
         * return this;
         * }
         */

        public Computer build() {
            return new Computer(this);
        }
    }

    public String toString() {
        return "Computer - " +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'';
    }

    public static void main(String[] args) {
        Computer comp1 = new Computer.Builder("Intel", "16GB", "1 TB")
                /*
                 * .setCPU("Intel")
                 * .setRAM("16GB")
                 * .setStorage("1 TB")
                 */
                .build();

        System.out.println(comp1);
    }
}
