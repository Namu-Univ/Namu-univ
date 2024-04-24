package com.namuuniv.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namuuniv.command.Command;
import com.namuuniv.command.Pro_CheckCommand;
import com.namuuniv.command.Stu_CheckCommand;

//@WebServlet("/controller")
public class FrontControllerCommand extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Map<String, Command> commands;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        commands = new HashMap<String, Command>();
        commands.put("stulist", new Stu_CheckCommand());
        commands.put("prolist", new Pro_CheckCommand());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerCommand doGet() 실행~~~");
        
        String type = request.getParameter("type");
        System.out.println("작업형태 type : " + type);
        
        Command command = commands.get(type);
        String pat = command.exec(request, response);
        request.getRequestDispatcher(pat).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
