<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.06.2023
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <style>
        body {
            background-color: #51c997;
        }

        /* Стили для кнопки на главную страницу */
        .home-button {
            position: fixed;
            top: 10px;
            right: 10px;
            background-color: transparent;
            border: none;
            cursor: pointer;
            outline: none;
            z-index: 9999;
        }

        .home-button img {
            width: 32px;
            height: 32px;
        }

        /* Стили для надписи "Home" */
        .home-text {
            position: fixed;
            top: 16px;
            right: 50px;
            color: #000000;
            font-size: 14px;
        }
    </style>
</head>
<body>
<h1 style="color: #000000;
           text-shadow: -1px -1px 0 #ffffff, 1px -1px 0 #ffffff, -1px 1px 0 #1b3f4d, 1px 1px 0 #1b3f4d;">DoPost</h1>
<form method="post" action="doPost">
    <label><strong>***Add a book to the database.</strong></label>
    <br>
    <br>
    <label for="bookID">Book id:</label>
    <input type="text" id="bookID" name="bookID" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;" placeholder="id book">
    <br>
    <label for="bookTitle">Book title:</label>
    <input type="text" id="bookTitle" name="bookTitle" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;" placeholder="title">
    <br>
    <label for="bookGenre">Book genre:</label>
    <input type="text" id="bookGenre" name="bookGenre" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;" placeholder="genre">
    <br>
    <button type="submit" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;"> Add </button>
</form>
<p>${result}</p>

<label>-------------------------------------</label>
<form method="post" action="doPost">
    <br>
    <label><strong>***View the table of the Book</strong><br><br> </label>
    <button type="submit" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;"> View </button>
</form>
<p>${resultBD}</p>


<script>
    function goToHomePage() {
        window.location.href = "index.jsp";
    }
</script>
<a href="index.jsp" class="home-button" onclick="goToHomePage()">
    <img src="ikon/house_38533.png" alt="">
</a>


</body>
</html>

