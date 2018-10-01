<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>

    <meta charset="utf-8">
    <title>Грузовая работа</title>
    <meta content="" name="description">
    <meta content="Documenter v2.0 http://rxa.li/documenter" name="generator">
    <link href="../../resources/assets/css/style.css" media="all" rel="stylesheet">
    <script src="../../resources/assets/js/jquery.js"></script>
    <script src="../../resources/assets/js/jquery.scrollTo.js"></script>
    <script src="../../resources/assets/js/jquery.easing.js"></script>
    <script src="../../resources/assets/js/script.js"></script>
    <script>
        document.createElement('section');
        var duration = '100',
            easing = 'swing';
    </script>
    <style>
        html {
            background-color: #fff;
            color: #333;
        }

        body {
            font-family: open sans;
            font-size: 14px;
            font-weight: 400;
        }

        a {
            color: #9CCC65;
        }

        hr {
            border-bottom: 1px solid #fff;
            border-top: 1px solid #eee;
        }

        #documenter_sidebar, #documenter_sidebar ul a {
            background-color: #333;
            color: #fff;
        }

        #documenter_sidebar ul a {
            border-bottom: 1px solid #555;
            color: #fff;
            font-weight: 400;
        }

        #documenter_sidebar ul li:first-child a {
            border-top: 1px solid #555;
        }

        #documenter_sidebar ul a:hover {
            background: #393939;
            color: #fff;
        }

        #documenter_sidebar ul a.current {
            background: #393939;
            color: #fff;
        }

        #documenter_copyright {
            display: block !important;
            visibility: visible !important;
        }
    </style>
</head>
<body>
<div id="documenter_sidebar">
    <a href="#documenter_cover" id="documenter_logo"></a>
    <ul id="documenter_nav">
        <li><a class="current" href="#documenter_cover">Наличие локомотивов БЧ</a></li>
        <li><a href="#customization" title="Выгрузка вагонов">Выгрузка вагонов</a></li>
        <li><a href="#source_and_credits" title="Source and Credits">Анализ грузовой работы</a></li>
    </ul>
    <div id="documenter_copyright"><a href="https://mail.google.com/mail">Разрабочик lkghost7@gmail.com</a></div>
</div>

<div id="documenter_content">
    <section id="documenter_cover">
        <h1>DeluxHotel - Responsive Bootstrap 4 Template For Hotels</h1>
        <div id="documenter_buttons"></div>
        <hr>


        <table border = "2px" width="100%" cellpadding="5" bgcolor="#f0ffff">
            <thead>
            <tr>
                <th width="70">ID</th>
                <th width="250">Краткое содержание</th>
                <th width="100">Имя</th>
                <th width="200">Фамилия</th>
                <th width="150">Подразделение</th>
                <th>Статус</th>
                <th width="300">Выбрать действие</th>
            </tr>
            </thead>
            <tbody>

            <tr name="taskTableName">
                <td name="taskId">lkl;</td>
                <td name="taskName">kjop;kl;</td>
                <td name="data">kl;kol;k</td>
                <td name="data">kl;kjl;</td>
                <td name="executor">k;kl;kl</td>
                <td name="status_id"><span class="primary Label">jkljkl</span></td>
            </tr>
            </tbody>
        </table>


        <tbody>
        <tr>
            <td class="s6">Дорога дислокации</td>
            <td class="s7">Дислокация</td>
            <td class="s8">Депо приписки</td>
            <td class="s9">Вид тяги</td>
            <td class="s10">Серия локомотива</td>
            <td class="s11">Заводской номер локомотива</td>
            <td class="s12">Дата\время посл. операции</td>
            <td class="s13">Номер поезда</td>
            <td class="s14">Индекс поезда</td>
            <td class="s15">Операция</td>
        </tr>
        <tr>
            <td rowspan="9" class="s16">Латвийская&nbsp;&nbsp;ЖД</td>
            <td class="s17">БГСТ-ДАУГ</td>
            <td class="s17">ТЧ-08</td>
            <td class="s17">Тепловоз</td>
            <td class="s17">2ТЭ10У</td>
            <td class="s17">0333</td>
            <td class="s18">01.10&nbsp;&nbsp;08-30</td>
            <td class="s17">2817</td>
            <td class="s17">1613 041 1100</td>
            <td class="s17">СДЧ4</td>
        </tr>
        </tbody>

        <ul>
            <li>Created: 20/12/2016</li>
            <li>By: <a href="http://themeforest.net/user/Dankov" target="_blank">Dankov</a></li>
            <li>E-mail: <a href="mailto:dankov.theme@gmail.com">dankov.theme@gmail.com</a></li>
        </ul>
    </section>

    <section id="html_structure">
        <div class="page-header"><h3>HTML Structure</h3>
            <hr class="notop">
        </div>
        <p>DeluxHotel is Bootstrap 4 based responsive template. You can use all of bootstrap features. More information
            <a href="https://v4-alpha.getbootstrap.com/">Bootstrap 4</a>.</p>
    </section>

    <section id="customization">
        <div class="page-header"><h3>Customization</h3>
            <hr class="notop">
        </div>
        <p>Template has easy customization features.</p>
        <h2>How to change main color (green)</h2>
        <p>Open style.css file and change default green colors "#9CCC65" to yours.</p>

        <h2>How to change parallax image</h2>
        <p>Open assets/images/parallax and replace slide1.jpg (top) or slide2.jpg to your image</p>

        <h2>How to change address in Map</h2>
        <p>Open assets/js/map.js, find 4 line and change address</p>

        <h2>How to edit count of display testimonials</h2>
        <p>Open assets/js/main.js, find 77 line and change number.</p>

        <h2>How to change main logo</h2>
        <p>Find assets/images/logo and replace logo.png to your image. Also, you can use PSD format of current logo.</p>

        <h2>How to change/edit/add icons on site (includes social link)</h2>
        <p>Go to <a href="http://fontawesome.io/icons/" target="_blank">http://fontawesome.io/icons/</a>, copy icon
            class (example for FB: <a href="http://take.ms/sPbc2" target="_blank">http://take.ms/sPbc2</a>) and insert
            in yours place.</p>

    </section>

    <section id="source_and_credits">
        <div class="page-header"><h3>Source and Credits</h3>
            <hr class="notop">
        </div>
        <ul>
            <li><a href="http://ianlunn.co.uk/plugins/jquery-parallax/">Parallax jQuery</a></li>
            <li><a href="http://owlcarousel2.github.io/OwlCarousel2/">Owl Carousel</a></li>
            <li><a href="http://fontawesome.io/">Font Awesome Icons</a></li>
            <li><a href="https://fonts.google.com/fonts/specimen/Open+Sans">Open Sans Font</a></li>
            <li><a href="https://fonts.google.com/specimen/Montserrat">Montserrat Font</a></li>
        </ul>
    </section>

</div>

<table border="1" width="100%" cellpadding="5">
    <tr>
        <th>Ячейка 1</th>
        <th>Ячейка 2</th>
    </tr>
    <tr>
        <td>Ячейка 3</td>
        <td>Ячейка 4</td>
    </tr>
</table>


</body>
</html>