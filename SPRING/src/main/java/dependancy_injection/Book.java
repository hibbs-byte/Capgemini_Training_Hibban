package dependancy_injection;

public class Book {
        private int bookid;
        private String bookname;

        public int getBookid() {
        return bookid;
    }

        public void setBookid(int bookid) {
        this.bookid = bookid;
    }

        public String getBookname() {
        return bookname;
    }

        public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    @Override
    public String toString()
    {
        return "Book{"+"bookid="+bookid+",bookname='"+bookname+'\''+'}';
    }
}
