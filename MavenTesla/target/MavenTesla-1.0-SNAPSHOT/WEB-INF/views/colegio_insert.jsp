<%-- 
    Document   : colegio_insert
    Created on : Aug 9, 2019, 10:17:42 PM
    Author     : ANDERSON
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar</title>
    </head>
    <style>
        * {
            padding:0px;
            margin:0px;
           -webkit-box-sizing:border-box;
           -moz-box-sizing: border-box;
            box-sizing: border-box;
            font-family: Roboto;
        }
        body {
            background-color: rgb(255,255,255);
        }
        
        .form-title {
            font-size: 1.9em;
            font-weight: normal;
            text-align: center;
            font-family: sans-serif;
            color: #009879;
            padding:10px;
        } 
        
        .container {
            margin-top:30px;
            animation: drop 1.5s ease;
        }
        
        .formulario {
            background: rgb(255,255,255);
            width: 90%;
            max-width: 350px;
            margin: auto;
            padding: 20px 35px;
            margin-top: 20px;
            padding-bottom: 30px;
            border-radius: 3px;
            border: 2px solid rgba(0, 152, 122,0.8);
            box-shadow: 0 0 17px rgba(0,0,0,0.4);
        }

        .form-label {
                display: block;
                color: #009879;
                font-size: 1em;
                font-weight: bold;
                font-family:Roboto;
                padding-bottom: 5px;
                position: relative;
        }

        .btn-submit {
            font-family: Roboto;
            outline: none;
            background: transparent;
            font-size: 1em;
            border:1px solid #009879;
            color: #009879;
            padding:5px 20px;
            cursor: pointer;
            transition: all 400ms ease;
            margin: 10px 10px;
            border-radius: 10px;
        }
        
        .form-input {
            border: none;
            outline: none;
            border: 1px solid rgba(0, 152, 122,0.8);
            width: 100%;
            padding-top: 3px;
            padding-bottom: 7px;
            padding-left: 8px;
            margin-bottom: 20px;
            color: #000;
            border-radius: 4px;
            font-size: 1em;
            font-family: Roboto;
            }
        
        .btns {
            display: flex;
            align-items:center;
            justify-content:center;
            
        }
        
        .btn-submit:hover {
            transform: scale(1.1);
            border: 1px solid #009879;
            background: #009879;
            color: #fff;
        }
        option {
            color:#009879;
        }
        .select {
            color:#009879;
            background-color: white;
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
        
        @media(max-width:360px) {
            .formulario {
                width:100%;
            }
            .btns {
                flex-direction:column;
                
            }
            .btn-submit{
                font-size: 0.8em;
            }
            .form-title {
                font-size: 1.7em;
            }
            .form-label, .form-input {
                font-size: 1em;
            }
        }
    </style>
    <body>
        <div class="container">
            <form:form class="formulario" name="" method="post" modelAttribute="colegio">
                <div class="form-header">
                    <h1 class="form-title">Registrar Colegio</h1>
                    
                    <label for="nombre" class="form-label">Nombre</label>
                    <form:input class="form-input" type="text" path="nombre" placeholder="Ingrese el nombre"/>
                    
                    <label for="distrito" class="form-label">Distrito</label>
                    <form:input class="form-input" type="text" path="distrito" placeholder="Ingrese el distrito"/>
                    
                    <label for="nombre" class="form-label">Tipo</label>
                    <div class="box">
                    <form:select class="form-input select" path="tipo">
                        <form:option value="Privado">Privado</form:option>
                        <form:option value="Publico">Público</form:option>
                    </form:select>
                    </div>    
                </div>
                    
                <div class="btns">
                    <button type="submit" class="btn-submit">Registrar</button>
                    <button type="button" class="btn-submit" onclick='location.href="<c:url value="/colegio_findAll"/>"'>Cancelar</button>
		</div>        
            </form:form>
        </div>
    </body>
</html>
