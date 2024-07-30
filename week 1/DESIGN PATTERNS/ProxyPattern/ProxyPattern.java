public class ProxyPattern {
    public interface Image {
        void display();
    }

    public static class RealImage implements Image {
        private String image;

        public RealImage(String image) {
            this.image = image;
            /// loadImage();
        }

        /*
         * private void loadImage() {
         * System.out.println("Loading image" + image);
         * }
         */

        @Override
        public void display() {
            System.out.println("Image has been displayed:" + image);
        }
    }

    public static class ProxyImage implements Image {
        private String image;
        private RealImage realimage;

        public ProxyImage(String image) {
            this.image = image;
        }

        @Override
        public void display() {
            if (realimage == null) {
                realimage = new RealImage(image);
            }
            realimage.display();
        }
    }

    public static void main(String[] args) {
        Image i1 = new ProxyImage("pic 1");
        Image i2 = new ProxyImage("pic 2");
        i1.display();

        i2.display();
    }

}