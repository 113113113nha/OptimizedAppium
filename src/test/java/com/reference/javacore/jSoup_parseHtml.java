package com.reference.javacore;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class jSoup_parseHtml {

    public static void main(String[] args) throws IOException {

        // 1- Simple
        String html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);

        Elements links = doc.select("head");

        // String tagW = links.outerHtml();
        // System.out.println(tagW);
        System.out.println(links.outerHtml());

        // 2- Complex
        String html2 = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc2 = Jsoup.parse(html2);

        Elements link = doc2.select("a");

        String text = doc2.body().text(); // "An example link"
        String linkHref = link.attr("href"); // "http://example.com/"
        String linkText = link.text(); // "example""
        String linkOuterH = link.outerHtml(); // "<a href="http://example.com"><b>example</b></a>"
        String linkInnerH = link.html(); // "<b>example</b>"

        System.out.println("Text: " + text);
        System.out.print("linkHref: " + linkHref);
        System.out.print("linkText: " + linkText);
        System.out.print("linkOuterH" + linkOuterH);
        System.out.print("linkInnerH" + linkInnerH);

        // 3- Connect
        // Document doc_Trial = Jsoup.connect("http://example.com").data("query","Java").userAgent("Mozilla").cookie("auth","token").timeout(3000).get();
        Document doc_Trial = Jsoup.connect("http://tuoitre.vn").data("query", "Java").userAgent("Mozilla").timeout(3000)
                .get();
        String title = doc_Trial.outerHtml();
        System.out.print(title);

        // <div class="block-2">
        System.out.println("------------------------ This divTag ------------------------------");
        Elements divTag = doc2.select("div");
        System.out.print(divTag.outerHtml());

    }

}
/*
 * <div class="block-left block-camera"> <h2 class="title txt-green"> <a
 * href="http://tuoitre.vn/tin/goc-anh" title="G�c ?nh">G�c ?nh</a> <a
 * href="http://tuoitre.vn/tin/media/audio" title="">Audio</a> <a
 * href="http://tuoitre.vn/tin/media/video" title="">Video</a> </h2> <div
 * class="slider-1"> <ul class="slides"> <li> <a title=
 * "Say ??m s?c hoa tr�n �o d�i truy?n th?ng" class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160314/say-dam-sac-hoa-tren-ao-dai-truyen-thong/1066537.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/13/thumbnail-ao-dai-1457868255.jpg"
 * alt="Say ??m s?c hoa tr�n �o d�i truy?n th?ng"> </a> <p class="inner-slider">
 * <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160314/say-dam-sac-hoa-tren-ao-dai-truyen-thong/1066537.html"
 * title="Say ??m s?c hoa tr�n �o d�i truy?n th?ng">Say ??m s?c hoa tr�n �o d�i
 * truy?n th?ng</a> <span><i class="fa fa-camera"></i></span> </p> </li> <li> <a
 * title="?nh cu?c s?ng ??i th??ng ? Tri?u Ti�n" class="img_300_170" href=
 * "http://tuoitre.vn/tin/the-gioi/20160314/anh-chup-len-tiet-lo-cuoc-song-o-trieu-tien/1066942.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/14/trieu-tien-1-1457931988.jpg"
 * alt="?nh cu?c s?ng ??i th??ng ? Tri?u Ti�n"> </a> <p class="inner-slider"> <a
 * href=
 * "http://tuoitre.vn/tin/the-gioi/20160314/anh-chup-len-tiet-lo-cuoc-song-o-trieu-tien/1066942.html"
 * title="?nh cu?c s?ng ??i th??ng ? Tri?u Ti�n">?nh cu?c s?ng ??i th??ng ?
 * Tri?u Ti�n</a> <span><i class="fa fa-camera"></i></span> </p> </li> <li> <a
 * title="Trai l�ng Bu�n ?�n h�ng d?ng c??i voi ?ua" class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160313/trai-buon-don-hung-dung-cuoi-voi-dua/1066513.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/13/hoivoi-dl-1-1457861073.jpg"
 * alt="Trai l�ng Bu�n ?�n h�ng d?ng c??i voi ?ua"> </a> <p
 * class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160313/trai-buon-don-hung-dung-cuoi-voi-dua/1066513.html"
 * title="Trai l�ng Bu�n ?�n h�ng d?ng c??i voi ?ua">Trai l�ng Bu�n ?�n h�ng
 * d?ng c??i voi ?ua</a> <span><i class="fa fa-camera"></i></span> </p> </li>
 * <li> <a title="L? c�ng s?c kho? cho voi" class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160313/le-cung-suc-khoe-cho-voi/1066129.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/12/buondon-7-1457779106.jpg"
 * alt="L? c�ng s?c kho? cho voi"> </a> <p class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160313/le-cung-suc-khoe-cho-voi/1066129.html"
 * title="L? c�ng s?c kho? cho voi">L? c�ng s?c kho? cho voi</a> <span><i class=
 * "fa fa-camera"></i></span> </p> </li> <li> <a title=
 * "?Xe ??p tr�o ?�o v??t su?i" class="img_300_170" href=
 * "http://tuoitre.vn/tin/goc-anh-trang-chu/20160313/xe-dap-treo-deo-vuot-suoi/1066282.html">
 * <img
 * src="http://static.new.tuoitre.vn/tto/i/s440/2016/03/13/11-1457835781.jpg"
 * alt="?Xe ??p tr�o ?�o v??t su?i"> </a> <p class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/goc-anh-trang-chu/20160313/xe-dap-treo-deo-vuot-suoi/1066282.html"
 * title="?Xe ??p tr�o ?�o v??t su?i">?Xe ??p tr�o ?�o v??t su?i</a> <span><i
 * class="fa fa-camera"></i></span> </p> </li> <li> <a title=
 * "B?c tranh ??ng qu� B?c Trung Nam ??p h?n &nbsp;tranh v?" class="img_300_170"
 * href=
 * "http://tuoitre.vn/tin/goc-anh-trang-chu/20160312/buc-tranh-dong-que-tu-bac-toi-nam/1066111.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/12/thung-lung-cao-pha-yen-bai-1457756154.jpg"
 * alt="B?c tranh ??ng qu� B?c Trung Nam ??p h?n &nbsp;tranh v?"> </a> <p
 * class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/goc-anh-trang-chu/20160312/buc-tranh-dong-que-tu-bac-toi-nam/1066111.html"
 * title="B?c tranh ??ng qu� B?c Trung Nam ??p h?n &nbsp;tranh v?">B?c tranh
 * ??ng qu� B?c Trung Nam ??p h?n &nbsp;tranh v?</a> <span><i class=
 * "fa fa-camera"></i></span> </p> </li> <li> <a title=
 * "Rihanna,&nbsp;Tyra Banks, Tri?u Vy,&nbsp;Qu�ch Kh? Doanh... t?ng m?c �o d�i Vi?t"
 * class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160312/rihanna-tyra-banks-trieu-vy-quach-kha-doanh-tung-mac-ao-dai-viet/1061902.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/12/wonder-girl-1457758624.jpg"
 * alt=
 * "Rihanna,&nbsp;Tyra Banks, Tri?u Vy,&nbsp;Qu�ch Kh? Doanh... t?ng m?c �o d�i Vi?t"
 * > </a> <p class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160312/rihanna-tyra-banks-trieu-vy-quach-kha-doanh-tung-mac-ao-dai-viet/1061902.html"
 * title=
 * "Rihanna,&nbsp;Tyra Banks, Tri?u Vy,&nbsp;Qu�ch Kh? Doanh... t?ng m?c �o d�i Vi?t"
 * >Rihanna,&nbsp;Tyra Banks, Tri?u Vy,&nbsp;Qu�ch Kh? Doanh... t?ng m?c �o d�i
 * Vi?t</a> <span><i class="fa fa-play"></i></span> </p> </li> <li> <a title=
 * "G�t h?ng d?u d�ng xoay gi?a khung tr?i&nbsp;" class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160312/got-hong-diu-dang-xoay-giua-khung-troi/1065616.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/11/ao-dai-lien-huong-jpg-1457686686.jpg"
 * alt="G�t h?ng d?u d�ng xoay gi?a khung tr?i&nbsp;"> </a> <p
 * class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160312/got-hong-diu-dang-xoay-giua-khung-troi/1065616.html"
 * title="G�t h?ng d?u d�ng xoay gi?a khung tr?i&nbsp;">G�t h?ng d?u d�ng xoay
 * gi?a khung tr?i&nbsp;</a> <span><i class="fa fa-camera"></i></span> </p>
 * </li> <li> <a title="?Sang tr?ng �o d�i S? Ho�ng " ??i="" 2016""=""
 * class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160310/sang-trong-ao-dai-sy-hoang-doi-2016/1065055.html">
 * <img
 * src="http://static.new.tuoitre.vn/tto/i/s440/2016/03/10/3-jpg-1457607265.jpg"
 * alt="?Sang tr?ng �o d�i S? Ho�ng &quot;??i 2016&quot;"> </a> <p
 * class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160310/sang-trong-ao-dai-sy-hoang-doi-2016/1065055.html"
 * title="?Sang tr?ng �o d�i S? Ho�ng &quot;??i 2016&quot;">?Sang tr?ng �o d�i
 * S? Ho�ng "??i 2016"</a> <span><i class="fa fa-camera"></i></span> </p> </li>
 * <li> <a title="?Nh?ng h�nh ?nh ??p nh?t Tu?n l? th?i trang Paris 2016"
 * class="img_300_170" href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160310/nhung-hinh-anh-dep-nhat-tuan-le-thoi-trang-paris-2016/1064425.html">
 * <img src=
 * "http://static.new.tuoitre.vn/tto/i/s440/2016/03/09/tai-xuong-14-1457514806.jpg"
 * alt="?Nh?ng h�nh ?nh ??p nh?t Tu?n l? th?i trang Paris 2016"> </a> <p
 * class="inner-slider"> <a href=
 * "http://tuoitre.vn/tin/van-hoa-giai-tri/20160310/nhung-hinh-anh-dep-nhat-tuan-le-thoi-trang-paris-2016/1064425.html"
 * title="?Nh?ng h�nh ?nh ??p nh?t Tu?n l? th?i trang Paris 2016">?Nh?ng h�nh
 * ?nh ??p nh?t Tu?n l? th?i trang Paris 2016</a> <span><i class="fa fa-camera"
 * ></i></span> </p> </li> </ul> </div> </div>
 */