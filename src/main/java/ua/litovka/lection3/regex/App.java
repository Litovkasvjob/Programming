package ua.litovka.lection3.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SergLion on 18.01.2017.
 */
public class App {
    public static void main(String[] args) {

        String s = "<body class=\"flex not-logged b-page_domik_visible b-page_weather_snow i-ua i-bem b-page b-page_expand-on_default\" data-bem=\"{&quot;i-ua&quot;:{}}\"><div class=\"container rows\"><div class=\"rows__bg\"></div><div class=\"row rows__row rows__row_first\">" +
                "<div class=\"col\" role=\"complementary\"><div class=\"b-time-banner__place\"></div><div class=\"container" +
                " headline\"><div class=\"row\"><div class=\"col headline__item headline__leftcorner\"><a href=\"https://yandex.ua" +
                "/tune/geo/?retpath=https%3A%2F%2Fwww.yandex.ua%2F%3Fdomredir%3D1\" class=\"link geolink link_gray_yes link_geosuggest_yes\"" +
                "><div class=\"geolink__button b-ico-geoarrow geolink__button_size_s\"></div><span class=\"geolink__reg\">Харьков</span>" +
                "</a></div><div class=\"col headline__item headline__center\"> </div><div class=\"col headline__item headline__bar\"><div>";


        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {

            System.out.println(matcher.group());


        }

        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Hilestone, "
                + "Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. "
                + "Haggi Hyer, Post bag no 52, Big bank post office, "
                + "Big bank city 56000, ph: 9876501234, Email: .ma.g_-gi.4545@myuniverse.com.123";

        Pattern pattern1 = Pattern.compile("\\b\\d{5}\\b");
        Matcher matcher1 = pattern1.matcher(str);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

        Pattern pattern2 = Pattern.compile("\\w[\\w\\.-]+@[\\w+\\.^_]+\\w{2,6}");
        Matcher matcher2 = pattern2.matcher(str);
        while (matcher2.find()) {
            System.out.println(matcher2.group());
        }

        Pattern pattern3 = Pattern.compile("\\b(\\d{3})(\\d{3})(\\d{2})(\\d{2})\\b");
        Matcher matcher3 = pattern3.matcher(str);
        System.out.println(matcher3.replaceAll("($1) $2-$3-$4"));



    }

}
