<%-- 
    Document   : index
    Created on : 24/06/2019, 10:14:33 PM
    Author     : Administrador
--%>

<!-- libreria JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            font-family: Roboto;
            box-sizing: border-box;
        }
        
        body {
            background-color: rgb(12, 1, 26);
        }
        
        .titulo {
            display: flex;
            justify-content:center;
            align-items: flex-end;
            min-height: 40vh;
            
            animation: drop 1.5s ease-in;
        }
        
        .index-tituto {
            font-weight: normal;
            font-size: 6em;
            color: #fff;
        }
        
        .index-tituto:hover {
            color: lightseagreen;
            transition: all 400ms ease-in;
        }
        
        .listas{
           
           min-height: 40vh;
           padding-top: 70px; 
           animation: drop 1.5s ease-in-out;
        }
        ul {
            display: flex;
            justify-content:center;
            list-style: none;   
        }
        
        li {
            padding: 10px 20px;
            margin: 20px;
        }
        
        .lista {
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            border: 1px solid #fff;
            font-weight: bold;
            font-size: 1.5em;
            transition: all 400ms ease;
            border-radius: 10px;
        }
        
        .lista:hover {
            background-color: rgba(0,0,0,0.5);
            border: 1px solid lightseagreen;
            color: lightseagreen;
        }
        
        @keyframes drop {
            0% {
                opacity: 0;
                transform: translateY(-80px);
                
            }
            100% {
                opacity: 1;
                transform: translateY(0px);
            }
        }
        
        @media (max-width:450px){
            .index-tituto{
                font-size: 4em;
                text-align: center;
            }
            li{

           }
            ul {
                flex-direction:column; 
                align-items:center;
            }
        }
    </style>
    <body>
        <div class="container">
        <div class="titulo">
            <h1 class="index-tituto">Welcome</h1>
        </div>
        
        <div class="listas">
            <ul>
                <li><a class="lista" href="<c:url value='/colegio_findAll'/>">Colegios</a></li>
                <li><a class="lista" href="<c:url value='#'/>">Profesores</a></li>
            </ul>
        </div>
        </div>
    </body>
</html>
