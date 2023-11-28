import java.sql.*;
import java.util.Scanner;
public class Books extends Function {

    protected  String jdbc = "jdbc:mysql://localhost:3306/bookProgramming";
    protected String username = "root";
    protected  String password = "";
    protected Connection connection;
    public Books() throws SQLException{
        connection = DriverManager.getConnection(jdbc, username, password);
        Statement statement = connection.createStatement();
    }
    protected void showBooksMenu() {
        System.out.println("1. Add new books");
        System.out.println("2. Update books");
        System.out.println("3. Delete books");
        System.out.println("4. Show all the books");
        System.out.println("0. Back menu");
        System.out.print("Choose a function: ");
    }
    // ISBN , book title , author , publication year ,genre ,publisher ,selling price, page number

    protected void insertBooks(String ISBN_code, String bookTitle,String author,String publicationYear, String genre, String publisher, double selling_price, int page_number){
        String sql = "INSERT INTO books " +
                "(ISBN_code,book_title,author,publication_year,genre,publisher,selling_price,page_number)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,ISBN_code);
            statement.setString(2,bookTitle);
            statement.setString(3,author);
            statement.setString(4,publicationYear);
            statement.setString(5,genre);
            statement.setString(6,publisher);
            statement.setDouble(7,selling_price);
            statement.setInt(8,page_number);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Create new departments successfully! ");
            }
            else{
                System.out.println("Create new departments fail! ");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    protected  void addBooks(Scanner input){
        System.out.print("Number of books add: ");
        int sum = input.nextInt();
        input.nextLine();
        while (sum <= 0){
            System.out.print("Retype sum of books: ");
            sum = input.nextInt();
            input.nextLine();
        }
        // ISBN , book title , author , publication year ,genre ,publisher ,selling price, page number
        for (int i = 0 ; i < sum ;i++){
            System.out.println("Insert info books " + ( i + 1 ));
            System.out.print("Typing books code: ");
            String IBSN_code = input.nextLine();
            System.out.print("Typing books name: ");
            String bookTitle = input.nextLine();
            System.out.print("Typing book author: ");
            String author = input.nextLine();
            System.out.print("Typing book publication year: ");
            String publicationYear = input.nextLine();
            System.out.print("Typing book genre: ");
            String genre = input.nextLine();
            System.out.print("Typing book publishers: ");
            String publishers = input.nextLine();
            System.out.print("Typing book price: ");
            double selling_price = input.nextDouble();
            System.out.print("Typing book page_number: ");
            int page_number = input.nextInt();
            insertBooks(IBSN_code,bookTitle,author,publicationYear,genre,publishers,selling_price,page_number);
        }
    }
    protected void updateBookBookTitle(String bookTitle,String ISBN_code){
        String sql = "UPDATE books SET book_title = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,bookTitle);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void updateBookAuthor(String author, String ISBN_code){
        String sql ="UPDATE books SET author = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,author);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void updateBookPublicationYear(String publication_year, String ISBN_code){
        String sql ="UPDATE books SET publication_year = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,publication_year);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void updateBookGenre(String genre, String ISBN_code){
        String sql ="UPDATE books SET genre = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,genre);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void updateBookPublishers(String publisher, String ISBN_code){
        String sql ="UPDATE books SET publisher = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,publisher);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void updateBookPrice(double selling_price, String ISBN_code){
        String sql ="UPDATE books SET selling_price = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1,selling_price);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void updateBookPageNumber(int page_number, String ISBN_code){
        String sql = "UPDATE books SET page_number = ? WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,page_number);
            statement.setString(2,ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("Update books successfully! ");
            }
            else{
                System.out.println("Update books fail! ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void chooseWhereToUpdateBooks(Scanner input){
        input.nextLine();
        System.out.print("What is ISBN_code of the book for the updating: ");
        String isbnCode = input.nextLine();
        /*System.out.print("Typing books name: ");
        String bookTitle = input.nextLine();
        System.out.print("Typing book author: ");
        String author = input.nextLine();
        System.out.print("Typing book publication year: ");
        String publicationYear = input.nextLine();
        System.out.print("Typing book genre: ");
        String genre = input.nextLine();  
        System.out.print("Typing book publishers: ");
        String publishers = input.nextLine();
        System.out.print("Typing book price: ");
        double selling_price = input.nextDouble();
        System.out.print("Typing book page_number: ");
        int page_number = input.nextInt();
        updateBooks(bookTitle,author,publicationYear,genre,publishers,selling_price,page_number,isbnCode);*/
        System.out.println("1. Book Title");
        System.out.println("2. Author");
        System.out.println("3. Publication Year");
        System.out.println("4. Genre");
        System.out.println("5. Publishers");
        System.out.println("6. Price");
        System.out.println("7. Page Number");
        System.out.print("What to update: ");
        int option = input.nextInt();
        input.nextLine();
        switch (option){
            case 1:
                System.out.print("Enter book title: ");
                String book_title = input.nextLine();
                updateBookBookTitle(book_title,isbnCode);
        }
    }


    protected void deleteBooks(String ISBN_code){
        String sql = "DELETE FROM books WHERE ISBN_code = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ISBN_code);
            int check = statement.executeUpdate();
            if (check == 1){
                System.out.println("DELETE successful");
            }
            else{
                System.out.println("DELETE unsuccessful");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void chooseWhereToDeleteBooks(Scanner input){
        input.nextLine();
        System.out.print("Where to delete departments: ");
        String ISBN_code = input.nextLine();
        deleteBooks(ISBN_code);
    }
    protected  void showBooks(){
        String sql = "SELECT * FROM books";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.isBeforeFirst() ) {
                System.out.println("No data");
            }else {
                System.out.println("ISBN_CODE \t| Name \t| Author\t| Publication_Year \t| Genre \t| Publisher \t| Selling_Price \t| Page_Number");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("ISBN_code") + "\t");
                    System.out.print(resultSet.getString("book_title") + "\t");
                    System.out.print(resultSet.getString("author") + "\t");
                    System.out.print(resultSet.getDate("publication_year") + "\t");
                    System.out.print(resultSet.getString("genre") + "\t");
                    System.out.print(resultSet.getString("publisher") + "\t");
                    System.out.print(resultSet.getDouble("selling_price") + "\t");
                    System.out.print(resultSet.getInt("page_number") + "\t \n");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void books(int m, Scanner input) {
        switch(m) {
            case 1:
                addBooks(input);
                break;
            case 2:
                chooseWhereToUpdateBooks(input);
                break;
            case 3:
                chooseWhereToDeleteBooks(input);
                break;
            case 4:
                showBooks();
                break;
        }
        if(m != 0) {
            System.out.print("Click 1 return menu, click 0 back to main menu: ");
            m = input.nextInt();
            while(m < 0 || m > 1) {
                System.out.print("Click 1 return menu, click 0 back to main menu: ");
                m = input.nextInt();
            }
            this.m = m;
        }
    }
    protected void returnBooksMenu(Scanner input) {
        do{
            showBooksMenu();
            m = input.nextInt();
            checkM(m, input);
            books(m, input);
        }while(m != 0);
    }
}