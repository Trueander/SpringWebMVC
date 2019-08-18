<%-- 
    Document   : colegio_findAll
    Created on : Aug 9, 2019, 10:45:30 PM
    Author     : ANDERSON
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            font-family: Roboto;
        }
        
        
        body {
            background-color: #fff;
        }
        .table-header {
            display:flex;
            justify-content: center;
            color: #009879;
            font-weight: normal;
            font-size: 20px;
            padding: 20px;
            animation: drop 1.5s ease-in-out;
        }
        
        .listas{
           animation: drop 1.5s ease-in-out;
        }
        ul {
            display:flex;
            justify-content:center;
            text-align: center;
            list-style: none;
            margin-bottom: 33px;
            
        }
        li {
            padding: 10px 20px;
        }
        
        .lista {
            
            text-decoration: none;
            border: 1px solid #009879;
            padding: 5px 20px;
            border-radius: 10px;
            background-color: transparent;
            color: rgb(0, 152, 122);
            transition: all 400ms ease;
            font-size: 1.2em;
        }
        
        .lista:hover, .listax:hover  {
            border: 1px solid #009879;
            background: #009879;
            color: #fff;
        }
        
        .container {
            
            animation: drop 1.5s ease-in-out;
            overflow-x: auto;
            margin-bottom: 50px;
        }
        
        table {
            
            border-collapse: collapse;
            font-size: 1em;
            width: 80%;
            border-radius: 6px 6px 0px 0px;
            box-shadow: 0 0 17px rgba(0,0,0,0.4);
            overflow: hidden;
            margin: auto;
        }
        
        thead {
            color: #009879;
            text-transform: uppercase;
            font-size: 15px;
            text-align: left;
        }
        
        th {
	background-color: #009879; 
	color: #fff;
	font-weight: bold;
	text-transform: uppercase;
        padding: 12px 15px;
        }
        
        tbody tr {
            border-bottom: 1px solid #009879;
        }
        
        td {
	padding: 10px 0;
        color:rgba(0,0,0,0.8);
        text-align: left;
        padding-left: 8px;
        }
        
        .link, .opcion{
            text-align: center;
        }
        
        
        .listax {
            border-radius: 10px;
            color:rgba(0,0,0,0.8);
            border: 0.5px solid #009879;
            padding:3px 26px;
        }
        
        a:link{
            text-decoration: none;
        }
        @keyframes drop {
            0% {
                opacity: 0;
                transform: translateX(-80px);
                
            }
            100% {
                opacity: 1;
                transform: translateY(0px);
            }
        }
        
        @media (max-width:550px){
            table,h1,a {
                width:100%;
            }
            h1{
                font-size: 1em;
                text-align: center;
            }
            
            li,thead{
                
                font-size: 0.8em;
            }
            td {
                font-size: 0.8em;
            }
            
            ul {
                flex-direction:column; 
            }
        }
 
    </style>
    <body>
        
        <div class="table-header">
            <h1 class="table-title">Lista de Colegios</h1>
        </div>
        
        <div class="listas">
            <ul>
                <li><a class="lista" href="<c:url value='/index'/>">Home</a></li>
                <li><a class="lista" href="<c:url value='/colegio_insert'/>">Registrar</a></li>
            </ul>
        </div>
            
        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Distrito</th>
                        <th>Tipo</th>
                        <th class="opcion">Opciones</th>
                    </tr>
                </thead>
            <c:forEach var="card" items="${bColegios}">
                <tbody>
                    <tr>
                        <td>${card.id_colegio}</td>
                        <td>${card.nombre}</td>
                        <td>${card.distrito}</td>
                        <td>${card.tipo}</td>
                        <td class="link">
                            <a class="listax" href="<c:url value='/colegio_update/${card.id_colegio}'/>">Actualizar</a>
                            <a class="listax" href="<c:url value='/colegio_delete/${card.id_colegio}'/>">Eliminar</a>
                        </td>
                    </tr>
                </tbody>
            </c:forEach>
            </table>
        </div>
    </body>
</html>
