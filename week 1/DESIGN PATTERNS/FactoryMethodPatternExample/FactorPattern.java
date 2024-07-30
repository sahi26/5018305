public class FactorPattern {

    public interface Document {
        void open();

        void write();

        void close();
    }

    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Open Word doc");
        }

        @Override
        public void write() {
            System.out.println("Write in Word doc");
        }

        @Override
        public void close() {
            System.out.println("Close Word doc");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Open pdf doc");
        }

        @Override
        public void write() {
            System.out.println("Write in pdf doc");
        }

        @Override
        public void close() {
            System.out.println("Close pdf doc");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Open excel doc");
        }

        @Override
        public void write() {
            System.out.println("Write in excel doc");
        }

        @Override
        public void close() {
            System.out.println("Close excel doc");
        }
    }

    public static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.write();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.write();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.write();
        excelDoc.close();
    }
}
