import java.sql.*;
import java.util.Scanner;
public class Function {
    protected int m;
    protected  String jdbc = "jdbc:mysql://localhost:3306/bookProgramming";
    protected String username = "root";
    protected  String password = "";
    protected Connection connection;
    // Ket noi database?
    public Function() throws SQLException {
        connection = DriverManager.getConnection(jdbc, username, password);
        Statement statement = connection.createStatement();
    }
    //  MENU
    protected void showFunctionMenu() {
        System.out.println("1. Filter books by author");
        System.out.println("2. Filter books by category");
        System.out.println("3. Sort books by publication year in descending order");
        System.out.println("4. Sort books by descending price");
        System.out.println("0. Back menu");
        System.out.print("Choose a function: ");
    }
    protected void checkM(int m, Scanner input) {
        while(m < 0 || m > 4) {
            System.out.print("Function not yet developed, choose again: ");
            m = input.nextInt();
        }
        this.m = m;
    }
    protected void filterBookByAuthors(String author){
        String sql = "SELECT * FROM books WHERE author = ? ";
        try{
            // Nhap tac gia can` tim`
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author);
            // ResultSet dung` de thuc thi query? xong tien the lay thong bang getString?
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst() ) {
                // Cai nay de loc neu nhap tac gi khong ton` tai ?
                System.out.println("There is no such authors");
            }else{
            System.out.println("ISBN_CODE \t| Name \t| Author\t| Publication_Year \t| Genre \t| Publisher \t| Selling_Price \t| Page_Number");
            while (resultSet.next()) {
                // In thong tin ra
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
    protected void chooseWhatAuthorsToSearchFor(Scanner input){
        input.nextLine();
        System.out.print("Enter authors name: ");
        String searchFor = input.nextLine();
        filterBookByAuthors(searchFor);
    }
    protected void filterBookByGenre(String genre){
        String sql = "SELECT * FROM books WHERE genre = ? ";
        try{
            // Nhap tac gia can` tim`
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, genre);
            // ResultSet dung` de thuc thi query? xong tien the lay thong bang getString?
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst() ) {
                // Cai nay de loc neu nhap co the loai day khong ton` tai ?
                System.out.println("There is no such genre");
            }else{
                System.out.println("ISBN_CODE \t| Name \t| Author\t| Publication_Year \t| Genre \t| Publisher \t| Selling_Price \t| Page_Number");
                while (resultSet.next()) {
                    // In thong tin ra
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
    protected void chooseWhatGenreToSearchFor(Scanner input){
        input.nextLine();
        System.out.print("Enter genre name: ");
        String searchFor = input.nextLine();
        filterBookByAuthors(searchFor);
    }
    protected  void sortBookByPublicationYearDesc(){
        String sql = "SELECT * FROM books ORDER BY publication_year DESC";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("ISBN_CODE \t| Name \t| Author\t| Publication_Year \t|" +
                        "Genre \t| Publisher \t| Selling_Price \t| Page_Number");
                while (resultSet.next()){
                    // In thong tin ra
                    System.out.print(resultSet.getString("ISBN_code") + "\t");
                    System.out.print(resultSet.getString("book_title") + "\t");
                    System.out.print(resultSet.getString("author") + "\t");
                    System.out.print(resultSet.getDate("publication_year") + "\t");
                    System.out.print(resultSet.getString("genre") + "\t");
                    System.out.print(resultSet.getString("publisher") + "\t");
                    System.out.print(resultSet.getDouble("selling_price") + "\t");
                    System.out.print(resultSet.getInt("page_number") + "\t \n");
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void sortByPriceDesc() {
        String sql = "SELECT * FROM books ORDER BY selling_price DESC";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("ISBN_CODE \t| Name \t| Author\t| Publication_Year \t|" +
                    "Genre \t| Publisher \t| Selling_Price \t| Page_Number");
            while(resultSet.next()){
                System.out.print(resultSet.getString("ISBN_code") + "\t");
                System.out.print(resultSet.getString("book_title") + "\t");
                System.out.print(resultSet.getString("author") + "\t");
                System.out.print(resultSet.getDate("publication_year") + "\t");
                System.out.print(resultSet.getString("genre") + "\t");
                System.out.print(resultSet.getString("publisher") + "\t");
                System.out.print(resultSet.getDouble("selling_price") + "\t");
                System.out.print(resultSet.getInt("page_number") + "\t \n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void function(int m, Scanner input) {
        switch(m) {
            case 1:
                chooseWhatAuthorsToSearchFor(input);
                break;
            case 2:
                chooseWhatGenreToSearchFor(input);
                break;
            case 3:
                sortBookByPublicationYearDesc();
                break;
            case 4:
                sortByPriceDesc();
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
    protected void returnFunctionMenu(Scanner input) {
        do{
            showFunctionMenu();
            m = input.nextInt();
            checkM(m, input);
            function(m, input);
        }while(m != 0);
    }
}