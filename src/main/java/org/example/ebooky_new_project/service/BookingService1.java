package org.example.ebooky_new_project.service;


//@Service
//public class BookingService {
//    private static final String BOOKS_FILE = "src/main/resources/data/books.json";
//    private final ObjectMapper objectMapper;
//    private List<Booking> books;
//
//    public BookingService(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//        this.books = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void init() {
//        File file = new File(BOOKS_FILE);
//        if (!file.exists()) {
//            initializeDefaultBooks();
//            saveBooks();
//        } else {
//            loadBooks();
//        }
//    }
//
//    private void initializeDefaultBooks() {
//        books.add(new Booking(1, "The Power of Now", "Eckhart Tolle", 2500, "★★★★☆",
//                "https://projectlifemastery.com/wp-content/uploads/2012/06/Eckhart-Tolle-The-Power-Of-Now-Review.jpg",
//                "The Power of Now is a guide to spiritual enlightenment..."));
//        books.add(new Booking(2, "To Kill a Mockingbird", "Harper Lee", 1800, "★★★☆☆",
//                "https://www.harryhartog.com.au/cdn/shop/files/9780099466734.jpg?v=1725013209&width=480",
//                "To Kill a Mockingbird is a novel by Harper Lee..."));
//        books.add(new Booking(3, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", 3200, "★★★★★",
//                "https://media.harrypotterfanzone.com/half-blood-prince-us-childrens-edition-2013-600x0-c-default.jpg",
//                "Harry Potter and the Half-Blood Prince is the sixth novel..."));
//        books.add(new Booking(4, "The Alchemist", "Paulo Coelho", 2100, "★★★★☆",
//                "https://images-na.ssl-images-amazon.com/images/I/71aFt4+OTOL.jpg",
//                "The Alchemist follows a young Andalusian shepherd..."));
//        books.add(new Booking(5, "Ikigai", "Héctor García and Francesc Miralles", 2300, "★★★★☆",
//                "https://images-na.ssl-images-amazon.com/images/I/71tbalAHYCL.jpg",
//                "The people of Japan believe that everyone has an ikigai..."));
//    }
//
//    public List<Booking> getAllBooks() {
//        return new ArrayList<>(books);
//    }
//
//    public Optional<Booking> getBookById(int id) {
//        return books.stream().filter(book -> book.getId() == id).findFirst();
//    }
//
//    public Booking addBook(Booking book) {
//        book.setId(generateId());
//        books.add(book);
//        saveBooks();
//        return book;
//    }
//
//    public Optional<Booking> updateBook(int id, Booking updatedBook) {
//        Optional<Booking> existingBook = getBookById(id);
//        existingBook.ifPresent(book -> {
//            book.setTitle(updatedBook.getTitle());
//            book.setAuthor(updatedBook.getAuthor());
//            book.setPrice(updatedBook.getPrice());
//            book.setRating(updatedBook.getRating());
//            book.setImage(updatedBook.getImage());
//            book.setDescription(updatedBook.getDescription());
//            saveBooks();
//        });
//        return existingBook;
//    }
//
//    public boolean deleteBook(int id) {
//        boolean removed = books.removeIf(book -> book.getId() == id);
//        if (removed) {
//            saveBooks();
//        }
//        return removed;
//    }
//
//    public List<Booking> searchBooks(String title, String author) {
//        return books.stream()
//                .filter(book -> title == null || book.getTitle().toLowerCase().contains(title.toLowerCase()))
//                .filter(book -> author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    private void loadBooks() {
//        try {
//            books = objectMapper.readValue(new File(BOOKS_FILE), new TypeReference<List<Booking>>(){});
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load books from file", e);
//        }
//    }
//
//    private void saveBooks() {
//        try {
//            objectMapper.writeValue(new File(BOOKS_FILE), books);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to save books to file", e);
//        }
//    }
//
//    private int generateId() {
//        return books.stream().mapToInt(Booking::getId).max().orElse(0) + 1;
//    }
//}