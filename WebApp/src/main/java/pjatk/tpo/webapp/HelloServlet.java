package pjatk.tpo.webapp;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pjatk.tpo.webapp.DBOService;


@WebServlet(name = "helloServlet", value = "/helloServlet")
public class HelloServlet extends HttpServlet {

    DBOService dbService;

    public void init() {
        dbService = new DBOService();
        log("Metod init =)");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void doGet(HttpServletRequest zlecenie, HttpServletResponse odpowiedz) throws IOException, ServletException {
        String id = zlecenie.getParameter("BookID"); // Pobieranie wartości id z parametru zapytania
        String bookID = zlecenie.getParameter("BookID2");
        String date = zlecenie.getParameter("publicationDate");
        String result = dbService.getBooks(id, date);
        String reviewResult = dbService.getReview(bookID);
        ServletContext context = zlecenie.getServletContext();

        context.setAttribute("result", result);
        context.setAttribute("reviewResult", reviewResult);

        getServletContext().getRequestDispatcher("/doGet.jsp").forward(zlecenie, odpowiedz);
    }


    @Override
    protected void doPost(HttpServletRequest zlecenie, HttpServletResponse odpowiedz) throws ServletException, IOException {
        String bookID = zlecenie.getParameter("bookID");
        String bookTitle = zlecenie.getParameter("bookTitle");
        String bookGenre = zlecenie.getParameter("bookGenre");
        String result = dbService.addBook(bookID, bookTitle, bookGenre);
        String resultBD = dbService.getBD();

        ServletContext context = zlecenie.getServletContext();

        context.setAttribute("resultBD", resultBD);
        context.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/doPost.jsp").forward(zlecenie, odpowiedz);

    }
        public void destroy () {
            log("Metod destroy");
        }

}