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


        /*#525252*/

        html {
            background-color: #fff;
            color: #333;
        }

        body {
            font-family: open sans;
            font-size: 14px;
            font-weight: 400;
        }
        #documenter_sidebar #documenter_logo {background-image: url("../../resources/assets/images/logoB4.png");}

        a {
            color: #9CCC65;
        }

        h3 {
            text-align: center;
        }

        hr {
            border-bottom: 1px solid #fff;
            border-top: 1px solid #eee;
        }

        /*#documenter_sidebar, #documenter_sidebar ul a {*/
            /*background-color: #333;*/
            /*color: #fff;*/
        /*}*/

        #documenter_sidebar, #documenter_sidebar ul a {
            background-color: #333;
            color: #fff;
        }

        /*#documenter_sidebar ul a {*/
            /*border-bottom: 1px solid #555;*/
            /*color: #fff;*/
            /*font-weight: 400;*/
        /*}*/
/*сам текст в меню*/
        #documenter_sidebar ul a {
            border-bottom: 1px solid #555;
            color: #ffffff;
            font-weight: 600;
        }

        #documenter_sidebar ul li:first-child a {
            border-top: 1px solid #555;
        }

        /*#documenter_sidebar ul a:hover {*/
            /*background: #393939;*/
            /*color: #fff;*/
        /*}*/

        #documenter_sidebar ul a:hover {
            background: #393939;
            color: aqua;
        }

        #documenter_sidebar ul a.current {
            background: #393939;
            color: #fff;
        }

        #documenter_sidebar ul a.current {
            background: #393939;
            color: white;
        }

        #documenter_copyright {
            display: block !important;
            visibility: visible !important;
        }
    </style>

    <%--<jsp:include page="../jsp/fragments/header.jsp"/>--%>



</head>
<body>
<div id="documenter_sidebar">
    <a href="#documenter_cover" id="documenter_logo"></a>
    <ul id="documenter_nav">
        <li><a class="current" href="#documenter_cover"> Оперативные сведения по грузовой работе</a></li>
        <li><a class="current" href="#documenter_cover2">Суточный план погрузки</a></li>
        <li><a href="#customization" title="Выгрузка вагонов">Анализ грузовой работы</a></li>
        <li><a href="#source_and_credits" title="Анализ грузовой работы в разрезе НОДов">Анализ грузовой работы в разрезе НОДов</a></li>
        <li><a href="#source_and_credits2" title="Погрузка вагонов на себя и на выход">Погрузка вагонов на себя и на выход</a></li>
        <li><a href="#source_and_credits3" title="Отчеты по грузовой работе">Отчеты по грузовой работе</a></li>
        <li><a href="#source_and_credits4" title="Анализ выполнения графика погрузки грузов">Анализ выполнения графика погрузки грузов</a></li>
        <li><a href="#source_and_credits5" title="Анализ погрузки и наличия налива на БЧ">Анализ погрузки и наличия налива на БЧ</a></li>
        <li><a href="#source_and_credits6" title="Анализ грузовой работы">Анализ погрузки лесных грузов на ПКП</a></li>
    </ul>
    <div id="documenter_copyright"><a href="https://mail.google.com/mail">Разрабочик lkghost7@gmail.com</a></div>
</div>

<div id="documenter_content">
    <section id="documenter_cover">
        <h3>Наличие локомотивных составов для ЖД</h3>


        <table border="3" bgcolor="#f0f8ff">
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
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        <tr>
            <td>Латвийская</td>
            <td>БГСТ-ДАУГ</td>
            <td>ТЧ-08</td>
            <td>Тепловоз</td>
            <td>2ТЭ10У</td>
            <td>0333</td>
            <td>08-30</td>
            <td>2817</td>
            <td>1613 041 1100</td>
            <td>СДЧ4</td>
        </tr>

        </tbody>
    </table>
    </section>

    <section id="documenter_cover2">
        <h3>Суточный план погрузки</h3>


        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>

    <section id="customization">
       <h3>Анализ грузовой работы</h3>

        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>


    </section>

    <section id="source_and_credits">
      <h3>Анализ грузовой работы в разрезе НОДов</h3>



        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>


    <section id="source_and_credits2">
        <h3>Погрузка вагонов на себя и на выход</h3>



        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>



    <section id="source_and_credits3">
        <h3>    Отчеты по грузовой работе</h3>



        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>


    <section id="source_and_credits4">
        <h3>Анализ выполнения графика погрузки грузов</h3>



        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>



    <section id="source_and_credits5">
        <h3>Анализ погрузки и наличия на БЧ</h3>



        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>



    <section id="source_and_credits6">
        <h3>Анализ погрузки лечных грузов на ПКП</h3>



        <table border="3" bgcolor="#f0f8ff">
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
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            <tr>
                <td>Латвийская</td>
                <td>БГСТ-ДАУГ</td>
                <td>ТЧ-08</td>
                <td>Тепловоз</td>
                <td>2ТЭ10У</td>
                <td>0333</td>
                <td>08-30</td>
                <td>2817</td>
                <td>1613 041 1100</td>
                <td>СДЧ4</td>
            </tr>

            </tbody>
        </table>
    </section>




</div>

<script> $(document).foundation();</script>
</body>
</html>