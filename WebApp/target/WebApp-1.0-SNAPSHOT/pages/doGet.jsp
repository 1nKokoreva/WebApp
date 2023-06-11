<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get</title>
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
           text-shadow: -1px -1px 0 #ffffff, 1px -1px 0 #ffffff, -1px 1px 0 #1b3f4d, 1px 1px 0 #1b3f4d;">DoGet</h1>
<form method="get" action="doGet">
    <label><strong>***Find a book by from and/or by publication date</strong></label>
    <br>
    <br>
    <label for="bookID">Book id:</label>
    <input type="text" id="bookID" name="BookID" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;" placeholder="id book">
    <br>
    <label for="publicationDate">Publication date:</label>
    <input type="text" id="publicationDate" name="publicationDate" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;" placeholder="yyyy-mm-dd">
    <br><br>
    <button type="submit" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;"> Search </button>
</form>
<p>${result}</p>

<label>-------------------------------------</label>
<form method="get" action="doGet">
    <br>
    <label for="reviewID"><strong>***Find a book review</strong><br><br> Book id: </label>
    <input type="text" id="reviewID" name="BookID2" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;" placeholder="id book">
    <br><br>
    <button type="submit" style="border-radius: 10px; background-color: #ffffff; color: black; box-shadow: 2px 2px 4px #1b3f4d;"> Search </button>
</form>
<p>${reviewResult}</p>

<script>
    function goToHomePage() {
        window.location.href = "index.jsp";
    }
</script>
<a href="index.jsp" class="home-button">
    <img src="ikon/house_38533.png" alt="">
</a>


</body>
</html>
