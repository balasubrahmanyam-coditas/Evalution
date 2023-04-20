package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Bill")
public class Bill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        PrintWriter out = resp.getWriter();
//        resp.setContentType("text/html");

        HttpSession session1 = req.getSession();


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Product> products = new ArrayList<Product>();

        int total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }


        out.println("<h1>Your bill is ." + total + "</h1>");
        RequestDispatcher rd = req.getRequestDispatcher("customerlogin.html");
        rd.include(req, resp);

        session.close();
    }
}
