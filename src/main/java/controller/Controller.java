package controller;

import entity.Crm;
import entity.Issue;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.User;

@WebServlet("/")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();


        switch (action) {
            case "/UserRegistration":
                UserRegistration(req, resp);
                break;
            case "/loginServ":
                UserLogin(req, resp);
                break;
            case "/UserDisplay":
                UserDisplay(req, resp);
                break;
            case"/AllUserDisplay":
                AllUserDisplay(req,resp);
                break;
            case "/UserLogout":
                UserLogout(req, resp);
                break;
            case "/CrmDisplay":
                CrmDisplay(req, resp);
                break;
            case"/UserDelete":
                UserDelete(req,resp);
                break;
            case"/UserEdit":
                UserEdit(req,resp);
                break;
            case"/UserIssueDisplay":
                UserIssueDisplay(req,resp);
                break;
            case"/UserIssueEdit":
                UserIssueEdit(req,resp);
                break;
            case "/Crmlogout":
                CrmLogout(req, resp);
                break;
            case "/registerCrm":
                CrmRegistration(req, resp);
                break;
            case "/crmUserRegistration":
                crmUserRegistration(req, resp);
                break;
            case "/AddIssue":
                AddIssue(req, resp);
                break;
            case"/AllIssueDisplay":
                AllIssueDisplay(req,resp);
                break;
            case"/CrmDelete":
                CrmDelete(req,resp);
                break;
            case"/IssueDelete":
                IssueDelete(req,resp);
                break;
            case"/CrmEdit":
                CrmEdit(req,resp);
                break;
            case"/CrmUserDisplay":
                CrmUserDisplay(req,resp);
                break;
            case"/CrmIssueDisplay":
                CrmIssueDisplay(req,resp);
                break;
            case"/updateIssueStatus":
                updateIssueStatus(req,resp);
                break;
            


        }
    }

    private void UserIssueEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int issueId = Integer.parseInt(request.getParameter("issue_id"));
        String issueName = request.getParameter("issueName");

        String issueDescription = request.getParameter("issueDescription");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        int id = Integer.parseInt(request.getParameter("issue_id"));
        Issue issue=session.get(Issue.class,id);

        issue.setIssueName(issueName);
        issue.setIssueDescription(issueDescription);

        session.update(issue);

        tx.commit();
        session.close();

        response.sendRedirect("user_issue_display.jsp");

    }

    private void updateIssueStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int issueId = Integer.parseInt(request.getParameter("issueId"));
        String issueStatus = request.getParameter("issueStatus");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Issue issue = session.get(Issue.class, issueId);
        issue.setIssueStatus(issueStatus);
        session.update(issue);

        tx.commit();
        session.close();

        response.sendRedirect("crm_user_issue_display.jsp");

    }

    private void UserIssueDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession();

        int customerId = (int) hs.getAttribute("uid");
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();



        String hql = "FROM Issue WHERE user.customerId = :id";
        List<Issue> issueList = session.createQuery(hql, Issue.class)
                .setParameter("id", customerId)
                .getResultList();

        request.setAttribute("issueList", issueList);

        RequestDispatcher rd = request.getRequestDispatcher("user_issue_display.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();
    }

    private void CrmIssueDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);
        String email = (String) hs.getAttribute("crmEmail");
        int cid = (int) hs.getAttribute("cid");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        String hql = "SELECT i, u FROM Issue i JOIN i.user u WHERE u.crm.crmId = :id";
        List<Object[]> resultList = session.createQuery(hql)
                .setParameter("id", cid)
                .getResultList();

        List<Issue> issueList = new ArrayList<>();
        for (Object[] result : resultList) {
            Issue issue = (Issue) result[0];
            issue.setUser((User) result[1]);
            issueList.add(issue);
        }

        request.setAttribute("issueList", issueList);

        RequestDispatcher rd = request.getRequestDispatcher("crm_user_issue_display.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();

    }

    private void CrmUserDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);
        if(hs==null){
            response.sendRedirect("login.jsp");
        }
        String email = (String) hs.getAttribute("crmEmail");
        int cid= (int) hs.getAttribute("cid");
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM User WHERE crm_crmId = :id ");

        query.setParameter("id",cid);
        List<User> list = query.getResultList();
        for (User u : list
        ) {
            System.out.println(u.getCustomerId());
        }

        request.setAttribute("userList", list);

        RequestDispatcher rd = request.getRequestDispatcher("crm_user_display.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();
    }

    private void UserEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("0");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession hs = request.getSession(false);
        System.out.println("1");
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        System.out.println("2");
        System.out.println("edit user iD " + customerId);
        System.out.println("3");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");

        User user = session.get(User.class, customerId);
        System.out.println(user);
        user.setFullName(fullName);
        user.setAddress(address);
        user.setDob(dob);

        session.update(user);
        tx.commit();

        response.sendRedirect("UserDisplay");

        session.close();
    }
    private void CrmEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession hs = request.getSession(false);

        int crmId = Integer.parseInt(request.getParameter("crmId"));

        String crmPhone = request.getParameter("crmPhone");
        String crmAddress=request.getParameter("address");


        Crm crm=session.get(Crm.class,crmId);
        System.out.println(crmId);
        crm.setAddress(crmAddress);
        crm.setCrmPhone(crmPhone);

        session.update(crm);
        tx.commit();


        session.close();
    }
    private void UserDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession hs = request.getSession(false);

        int cid = Integer.parseInt(request.getParameter("uId"));

        Query query = session.createQuery("FROM User WHERE customerId  = :id", User.class);
        query.setParameter("id", cid);
        User user = (User) query.getSingleResult();

        if (user != null) {
            // Delete the user from the database
            session.delete(user);
            tx.commit();
            out.println("<h4>User with id " + cid + " was deleted successfully.</h4>");
        } else {
            out.println("<h4>User with id " + cid + " was not found.</h4>");
        }

    }
    private void CrmDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession hs = request.getSession(false);

        int id = Integer.parseInt(request.getParameter("crmId"));
        Crm crm = session.get(Crm.class, id);
        session.delete(crm);

        tx.commit();
        session.close();

        response.sendRedirect("crm_list.jsp");
    }
    private void IssueDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession hs = request.getSession(false);

        int id = Integer.parseInt(request.getParameter("issue_id"));
        Issue issue=session.get(Issue.class,id);
        session.delete(issue);

        tx.commit();
        session.close();

        response.sendRedirect("user_issue_display.jsp");
    }



    private void CrmLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String email = (String) session.getAttribute("crmEmail");
            if (email != null) {
                out.println("<h4>You have successfully logged out.</h4>");
                response.sendRedirect("login.jsp");

            } else {
                out.println("<h4>You have successfully logged out.</h4>");
            }
            session.invalidate();
        } else {
            out.println("<h4>You were not logged in.</h4>");
        }
    }

    private void AllIssueDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM Issue ");

        List<Issue> list = query.getResultList();


        request.setAttribute("issueList", list);
        RequestDispatcher rd = request.getRequestDispatcher("all_issue_display.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();
    }



    private void AllUserDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);

        String email = (String) hs.getAttribute("crmEmail");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM User ");

        List<User> list = query.getResultList();
        for (User u : list
        ) {
            System.out.println(u.getCustomerId());
        }

        request.setAttribute("userList", list);

        RequestDispatcher rd = request.getRequestDispatcher("all_user_details.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();
    }

    private void AddIssue(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        HttpSession hs = request.getSession(false);
        if(hs==null){
            response.sendRedirect("login.jsp");
        }
        int customerId = (int) hs.getAttribute("uid");

        String issueName = request.getParameter("issueName");
        String issueDescription = request.getParameter("issueDescription");

        Issue issue = new Issue();
        issue.setIssueName(issueName);
        issue.setIssueDescription(issueDescription);
        issue.setIssueStatus("In Progress");

        User user = session.get(User.class, customerId);
        issue.setUser(user);

        session.save(issue);
        tx.commit();
        session.close();

        RequestDispatcher rd = request.getRequestDispatcher("UserDisplay");
        rd.forward(request, response);
    }

    protected void crmUserRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession hs=request.getSession(false);
        int cid = (int) hs.getAttribute("cid");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setPhone(phone);
        user.setAddress(address);
        user.setGender(gender);
        user.setDob(dob);

        Crm crm = session.get(Crm.class, cid);
        user.setCrm(crm);

        session.save(user);
        tx.commit();
        session.close();

        out.println("<h6 style='color: green;'>Registered Successfully</h6>");
        RequestDispatcher rd = request.getRequestDispatcher("crm.jsp");
        rd.include(request, response);
    }


    private void CrmDisplay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);

        if(hs==null){
            response.sendRedirect("login.jsp");
        }
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM Crm ");

        List<Crm> list = query.getResultList();


        request.setAttribute("crmList", list);

        RequestDispatcher rd = request.getRequestDispatcher("all_crm_display.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();

    }

    private void CrmRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        String crmName = request.getParameter("crmName");
        String crmEmail = request.getParameter("crmEmail");
        String crmPass = request.getParameter("crmPass");
        String crmPhone = request.getParameter("crmPhone");
        String address = request.getParameter("address");

        Crm crm = new Crm();
        crm.setCrmName(crmName);
        crm.setCrmEmail(crmEmail);
        crm.setCrmPass(crmPass);
        crm.setCrmPhone(crmPhone);
        crm.setAddress(address);

        session.save(crm);
        tx.commit();
        session.close();

        out.println("<h6 style='color: green;'>Registered Successfully</h6>");
        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.include(request, response);
    }

    private void UserLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String email = (String) session.getAttribute("uEmail");
            if (email != null) {
                out.println("<h4>You have successfully logged out.</h4>");
                response.sendRedirect("login.jsp");
            } else {
                out.println("<h4>You have successfully logged out.</h4>");
            }
            session.invalidate();
        } else {
            out.println("<h4>You were not logged in.</h4>");
        }


    }


    protected void UserRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        User ci = new User();
        ci.setEmail(email);
        ci.setPassword(password);
        ci.setFullName(fullName);
        ci.setPhone(phone);
        ci.setAddress(address);
        ci.setGender(gender);
        ci.setDob(dob);


        session.save(ci);
        tx.commit();
        session.close();

        out.println("<h6 style='color: green;'>Registered Successfully</h6>");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.include(request, response);
        out.println("<meta http-equiv='refresh' content='1;url=login.jsp'>");

    }

    //user Login verification

    protected void UserLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession();
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

// Check userType
        String userType = request.getParameter("userType");
        if (userType.equals("admin")) {
            if (email.equals("admin@gmail.com") && password.equals("admin")) {
                out.println("<h6 style='color: green;'>Login Successful</h6>");
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h6 style='color: red;'>Login failed ! </h6>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }
        } else if (userType.equals("crm")) {
            Query query = session.createQuery("FROM Crm WHERE crmEmail = '" + email + "' and crmPass = '" + password + "'");
            List<Crm> list = query.getResultList();
            if (list.size() > 0) {
                Crm crm = list.get(0);
                int cid = crm.getCrmId();
                String crmEmail= crm.getCrmEmail();
                hs.setAttribute("cid", cid);
                hs.setAttribute("crmEmail",crmEmail);


                out.println("<h6 style='color: green;'>Login Successful</h6>");
                RequestDispatcher rd = request.getRequestDispatcher("crm.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h6 style='color: red;'>Login failed ! </h6>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }
        } else if (userType.equals("user")) {
            Query query = session.createQuery("FROM User WHERE email = '" + email + "' and password = '" + password + "'");
            List<User> list = query.getResultList();
            if (list.size() > 0) {
                User user = list.get(0);
                int cid = user.getCustomerId();
                String uEmail= user.getEmail();

                hs.setAttribute("uid", cid);
                hs.setAttribute("uEmail",uEmail);

                out.println("<h6 style='color: green;'>Login Successful</h6>");
                RequestDispatcher rd = request.getRequestDispatcher("UserDisplay");
                rd.forward(request, response);
            } else {
                out.println("<h6 style='color: red;'>Login failed ! </h6>");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.include(request, response);
            }
        } else {
            out.println("<h6 style='color: red;'>Invalid user type! </h6>");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.include(request, response);
        }

        tx.commit();
        session.close();
    }

    // User Data Display
    protected void UserDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession hs = request.getSession(false);
        if(hs==null){
            response.sendRedirect("login.jsp");
        }

        String email = (String) hs.getAttribute("uEmail");

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM User WHERE email = :email");
        query.setParameter("email", email);

        List<User> list = query.getResultList();
        for (User u : list
        ) {
            System.out.println(u.getCustomerId());
        }

        request.setAttribute("userList", list);

        RequestDispatcher rd = request.getRequestDispatcher("user_details.jsp");
        rd.forward(request, response);

        tx.commit();
        session.close();
    }
}






