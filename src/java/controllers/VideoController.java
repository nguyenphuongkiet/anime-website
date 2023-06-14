/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import entity.CategoryEntity;
import entity.FilmEntity;
import entity.VideoEntity;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import service.CategoryService;
import service.FilmService;
import service.VideoService;

/**
 *
 * @author admin
 */
@WebServlet(name = "VideoController", urlPatterns = {"/video"})
public class VideoController extends HttpServlet {

    private FilmService fs = new FilmService();
    private VideoService vs = new VideoService();
    private CategoryService cs = new CategoryService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        HttpSession session = request.getSession();
        try {
            switch (action) {
                case "anime":
                    ArrayList<FilmEntity> list = new ArrayList<>();
                    list = fs.getAll();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                    break;
                case "anime-detail": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    ArrayList<FilmEntity> list1 = new ArrayList<>();
                    list1 = fs.getSideBar();
                    FilmEntity fe = new FilmEntity();
                    fe = fs.getDetail(id);
                    request.setAttribute("detail", fe);
                    request.setAttribute("sideBar", list1);
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                    break;
                }
                case "anime-watching": {
                    int id = Integer.parseInt(request.getParameter("fid"));
                    ArrayList<VideoEntity> fullList = vs.getVideoByFilmId(id); // store the full list of videos
                    VideoEntity ve = vs.getVideo(id);
                    request.setAttribute("video", ve);

                    // check if a specific episode has been selected
                    String episodeIdParam = request.getParameter("episodeId");
                    if (episodeIdParam != null) {
                        // extract the ID of the selected episode
                        int episodeId = Integer.parseInt(episodeIdParam);
                        // get details for the selected episode
                        ve = vs.getVideoByFilmIdAndEpisode(id, episodeId);
                        request.setAttribute("video", ve);
                    }

                    // set the list of episodes for display
                    request.setAttribute("list", fullList);
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                    break;
                }

            }
        } catch (SQLException ex) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
