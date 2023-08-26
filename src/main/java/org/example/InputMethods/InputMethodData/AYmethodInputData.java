package org.example.InputMethods.InputMethodData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.example.InputMethods.CustomStrokeCollections.*;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.OVERLAP;

public class AYmethodInputData {
    //top elements
    public static List<String> topRow = Arrays.asList("q","w","e","r","t","y","u","i","o","p");
    public static List<String> middleRow = Arrays.asList("a","s","d","f","g","h","j","k","l",";");
    public static List<String> bottomRow = Arrays.asList("z","x","c","v","b","n","m",",",".","/");

    public static List<String> listForTopElems = middleRow; //middlerow
    public static List<String> listForOrdinaryElems = topRow; //toprow


    public static String t1 = listForTopElems.get(0);
    public static String t2 = listForTopElems.get(1);
    public static String t3 = listForTopElems.get(2);
    public static String t4 = listForTopElems.get(3);
    public static String t5 = listForTopElems.get(4);
    public static String t6 = listForTopElems.get(5);
    public static String t7 = listForTopElems.get(6);
    public static String t8 = listForTopElems.get(7);
    public static String t9 = listForTopElems.get(8);
    public static String t0 = listForTopElems.get(9);

    //ordinary elements
    public static String o1 = listForOrdinaryElems.get(0);
    public static String o2 = listForOrdinaryElems.get(1);
    public static String o3 = listForOrdinaryElems.get(2);
    public static String o4 = listForOrdinaryElems.get(3);
    public static String o5 = listForOrdinaryElems.get(4);
    public static String o6 = listForOrdinaryElems.get(5);
    public static String o7 = listForOrdinaryElems.get(6);
    public static String o8 = listForOrdinaryElems.get(7);
    public static String o9 = listForOrdinaryElems.get(8);
    public static String o0 = listForOrdinaryElems.get(9);

    //

    public static final HashMap<String, String> arrayInspiredElemsV1 = new HashMap<>();
    static {
        try {
        //theme: I must find a way to distinguis every element below, so they can be written individually.
        //Use a 2-letter system:
        //first letter:
        //use normal array rules => column is decided by first primitive, row by last primitive:
        //(1-4 == top row, 5 == middle row, 6-0 == buttom row).
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //

        //If the elememnt match a primitive, the letter will be from the middle row.
        //second letter:
            //if short cut character - second letter is from same middle row
            //if other character: --
        //take the element and substract the first primitive. If 2+ strokes are left: then use stroke 1 and 2.
        //if one stroke is left: use the relevant middle-row character.
        //if the element match a primitive, the second letter is the first letter.

            //left side elem to letter:

            /*  try to organize outer elems by strokes:                     tryToAvoid: 宀冖火馬
            nr1hori: 礻-犭-車     nr2Bent: 糹女山    nr3vert: 氵門               ?囗  ?? 禾𧾷火广貝山  ???米虍
            nr4cross: 木艹土       nr5Bent: 阝尸     nr6dot:   言-辶-衤       ?囗  ?? 禾𧾷火广貝山  ???米虍
            sevenOuterTop:  月目雨    nr8eightStrokes: 金忄飠
            nr9leftSlant: 扌-亻-竹   nr10box:  口日虫            𠃌亠儿冖厂  */

            //great left side elements

//***************************** if 3+ elems: second To last elem Decide The Letter Column        ************************************************************************
//***************************** else: last elem decide the letter column (only original elems count as elems)
            //q a z
            arrayInspiredElemsV1.put("示", "q" + t1);
            arrayInspiredElemsV1.put("礻", "q" + t1);
            arrayInspiredElemsV1.put("犬", "z" + t1);
            arrayInspiredElemsV1.put("犭", "z" + t1); //犭 left form of 犬 - but taken as short form of 大

        //First column
        //q//left side
        arrayInspiredElemsV1.put("工", "q" + o3); //q=1+1 e=3+1
            arrayInspiredElemsV1.put("臣", "q" + o2); //臣
        arrayInspiredElemsV1.put("匚", "q" + o2); //q=1+2 s=2  匚 from 區
        arrayInspiredElemsV1.put("匸", "q" + o2); //alternative of 匚, 匸 from 區
            arrayInspiredElemsV1.put("厂", "q" + o9); //z=1+9 l=9  //友反 canNotOverlap
            arrayInspiredElemsV1.put("𠂆", "q" + o9); //eg. 所 //alternative form of 厂
            arrayInspiredElemsV1.put("丆", "q" + o9); //礙礎 石 must be 1 or 2 codes, 丆 should probably be and element

        //a
            arrayInspiredElemsV1.put("宀", "a" + o7); //n=6+7 d=3+5    //謬寥 言宀 diff  //富幅 宀巾 diff //宁盯
        arrayInspiredElemsV1.put("一", "a"); //a=1
            arrayInspiredElemsV1.put("⺄", "a"); //z=1+8  k=8    //⺄  eg. 訊 el 飞
            arrayInspiredElemsV1.put("乁", "a"); //乁 from 气

        //z
            //left side
            arrayInspiredElemsV1.put("馬", "z" + o5); //c=3+6  q=1+3  馬 ids ⿹⑥灬
            arrayInspiredElemsV1.put("马", "z" + o5); //simplified form of 馬  马  ②

        // Second column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //w s x

            //arrayInspiredElemsV1.put("女", "ss");
            //arrayInspiredElemsV1.put("心", "ws"); //煌惶 //忄金飠 //慢饅
            //arrayInspiredElemsV1.put("忄", "ws");
            arrayInspiredElemsV1.put("艮", "w" + t2); //b=5+8 q=1+1 艮
            arrayInspiredElemsV1.put(LEFTSIDE5_FLAGWITHMIDDLE.val(), "w" + t2); //left of 即 //seen as a variatin of  艮
            arrayInspiredElemsV1.put("𠁣", "w" + t2); //t=5+3  q=1+1 𠁣 eg. 門	⿰𠁣𠃛
            arrayInspiredElemsV1.put("𠃛", "w" + t2); //𠁣 variant //𠃛 eg. 門	⿰𠁣𠃛
            arrayInspiredElemsV1.put("糸", "s" + t2);
            arrayInspiredElemsV1.put("糹", "s"+ t2);
            arrayInspiredElemsV1.put("纟", "s"+ t2);
            arrayInspiredElemsV1.put("乡", "s"+ t2);
            arrayInspiredElemsV1.put("火", "x"+ t2); //,=8+8 .=9+8
            arrayInspiredElemsV1.put("灬", "x"+ t2); //short form of 火
        //w
            //left side
        //arrayInspiredElemsV1.put("女", "wo"); //w=2+1 o=9+1
        //arrayInspiredElemsV1.put("巛", "ww"); //w=2+2 w=2+2
            arrayInspiredElemsV1.put("爿", "w" + o1); //x=2+9 e=3+1  //mirror image is 片  as in 肅
            arrayInspiredElemsV1.put("丬", "w" + o1); //丬 from 将, short form of 爿 將
            arrayInspiredElemsV1.put("凵", "w" + o3);//⿱屮凵
            arrayInspiredElemsV1.put("山", "w" + o3);

        //s
            arrayInspiredElemsV1.put("女", "s" + o9);
        arrayInspiredElemsV1.put("𡿨", "s"); //from 經
        arrayInspiredElemsV1.put("𠃋", "s"); //𠃋 from 該
        arrayInspiredElemsV1.put("𠃊", "s"); //𠃊 from 網
        arrayInspiredElemsV1.put(RIGHTBENTBUTHOOK_LARGE.val(), "s"); //s=2 //他
        arrayInspiredElemsV1.put(RIGHTBENTBUT_SHARP.val(), "s"); //s=2
        arrayInspiredElemsV1.put(DOWNWITHHOOK.val(), "s"); //DOWNWITHHOOK - related to OLAP3YIANDCHANGBUTTOM
            arrayInspiredElemsV1.put(DOUBLEBENT_25_WITHHOOK.val(), "s" + o5); //s=2 //eg. 與 or 与
            arrayInspiredElemsV1.put(DOUBLEBENT_25_NOHOOK.val(), "s" + o5); // s=2 //𠃑 from 誤
        //arrayInputMap.put("几", ""); //s=

        //x
            //left side
        arrayInspiredElemsV1.put("厶", "x" + o6); //x=2+6 s=6



        //Third column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //e d c
            arrayInspiredElemsV1.put("門", "e" + t3);
            arrayInspiredElemsV1.put("门", "e" + t3);
            arrayInspiredElemsV1.put("長", "d" + t3);
            arrayInspiredElemsV1.put("长", "d" + t3); //--账帐
            arrayInspiredElemsV1.put("水", "c" + t3); //氵門
            arrayInspiredElemsV1.put("氵", "c" + t3);

        //e
            //left side
        arrayInspiredElemsV1.put("⺊", "e" + o1);
            arrayInspiredElemsV1.put(OLAP3ZHABUT.val(), "e" + o1); //e=3+1  q=1+1 //button of 乍 or left side of 耳
            arrayInspiredElemsV1.put(OLAP4TWOVERTTWOHORI.key(), "e" + o1);//e=3+3 q=1+1 //example: 其 ⿱⿱⑤一八 and 面/囬
            arrayInspiredElemsV1.put("止", "e" + o1); //e=3+1 q=1+3


        //d
        arrayInspiredElemsV1.put("丨", "d");
        arrayInspiredElemsV1.put("亅", "d");
            arrayInspiredElemsV1.put("刂", "d"); //e=3+3 d=3
        arrayInspiredElemsV1.put("片", "d" + o1); //d=3+5 z=1+9 mirro image of 爿,
            // I wanted to give them the same code, but they both are in first 5000

        //c
            //left side

        arrayInspiredElemsV1.put("小", "c" + o8); //c=3+8 .=9+8
        arrayInspiredElemsV1.put("⺌", "c" + o8); //⺌ variant of 小, from 当
        arrayInspiredElemsV1.put("𭕄", "c" + o8); //variant of 小  //𭕄 eg.  学
        arrayInspiredElemsV1.put("𣥂", "c" + o8); //c=3+9 n=6+9 𣥂 ids 𣥂 from  步


        //Forth coulmn
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //r f v
            arrayInspiredElemsV1.put("廿", "r" + t4); //r=4+1 d=3+1
            arrayInspiredElemsV1.put("艹", "r" + t4); //木艹土
            arrayInspiredElemsV1.put("卄", "r" + t4); //alternative form of 廿 卄 from 龷 黄
            arrayInspiredElemsV1.put("丱", "r" + t4); //taken as alternative form of 廿
            arrayInspiredElemsV1.put("艹", "r" + t4); //艹 from 歡
            arrayInspiredElemsV1.put("土", "f" + t4); //士土

        //r
            //left side
            arrayInspiredElemsV1.put("夂", "r" +o5); //.=9+9 b=5+8 夂  ex. 後
            arrayInspiredElemsV1.put("夊", "r" +o5); //.=9+9 b=5+8  夊 eg. 後
            arrayInspiredElemsV1.put("攵", "r" +o9); //微徵 攵 must be one elem
            arrayInspiredElemsV1.put("乂", "r" + o8); //ex. 文  //兄史
            arrayInspiredElemsV1.put("㐅", "r" + o8); //ex. 學  //兄史
        //f
            arrayInspiredElemsV1.put("寸", "f" +o4); //寸
        arrayInspiredElemsV1.put("十", "f"); //f=4  //十and 龶 /russiancross cant overlap - 勒勤
            arrayInspiredElemsV1.put("𠂇", "f" +o9); //z=1+9 l=9 --龙尤
        arrayInspiredElemsV1.put(OLAP3RUSSIANCROSS.val(), "f" +o1); //f=4 q=1+3 //middle side of 生, top side of 龶, top right of 請, midle of
        arrayInspiredElemsV1.put(OVERLAP.desc() + "二丨", "f" +o1); //OLAP3RUSSIANCROSS full value, //middle side of 生, top side of 龶, top right of 請
        arrayInspiredElemsV1.put(OLAP4NIENBUT.val(), "f" + o1);  //buton side of 年, alternative form of "二丨" //OLAP3RUSSIANCROSS


        //v
            arrayInspiredElemsV1.put("木", "v" + o8);
        arrayInspiredElemsV1.put("𣎳", "v" +o8); //𣎳 v=4+8 .=9+8 Taken as 十 + 八, or an alternative form of 木, eg. 麼
        arrayInspiredElemsV1.put("朩", "v"+o8);//taken as alternative form of 木, eg. 新
            arrayInspiredElemsV1.put("束", "v"+o0); //杏束 overlap
            arrayInspiredElemsV1.put("末", "v"+o1); //末未(本)
            arrayInspiredElemsV1.put("棘", "v"+o7); //棘棗

        //Fifth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //t g b
            //arrayInspiredElemsV1.put("阝", "tg"); //阝尸
            //arrayInspiredElemsV1.put("之", "gg");
            arrayInspiredElemsV1.put("辶", "g"+t5); //隊遂
            arrayInspiredElemsV1.put("子", "t"+t5);
            arrayInspiredElemsV1.put("尸", "b"+t5);
            //arrayInspiredElemsV1.put("𠃜", "ws"); //taken as a variant of 尸, 𠃜 from 声
        //t
            //left side
        arrayInspiredElemsV1.put("阝", "t"+o3); //t=5+3 d=3 //first stroke taken as DOUBLEBENT_55  //隊遂
        arrayInspiredElemsV1.put("卩", "t"+o3); //t=5+3 d=d卩 from 报
            arrayInspiredElemsV1.put("刀", "t"+o9); //b=5+9 l=9
        arrayInspiredElemsV1.put(OLAP3HORIFORKLIKE.key(), "t"+o1); //t=5+1 q=1+1 eg. 事 stroke 6,7,8 or ids 尹 ⿻⿻コ一丿 stroke 1,2,3
        arrayInspiredElemsV1.put("巳", "t"+o1); //t=5+2 q=1+2  //巳 from 僊 凞 包
        arrayInspiredElemsV1.put(OLAP3LEFTSIDEOFPEOPLE.key(), "t"+o1); //first 3 strokes of 民, taken as alternative form of 巳

        //g
            arrayInspiredElemsV1.put("已", "g" +o1);  //EXCEPTION //已 -- only used in ids character beyond BMP
        arrayInspiredElemsV1.put("乛", "g"); //t=5
        arrayInspiredElemsV1.put(BENTTOPHOOK_LARGE.val(), "g"); //"𠃌" g=5 有万令
        arrayInspiredElemsV1.put(BENTTOP_SHARP.val(), "g"); //𠃍 eg.過
        arrayInspiredElemsV1.put(BENTTOP_ROUND.val(), "g"); //㇇ from 永
        arrayInspiredElemsV1.put(DOUBLEBENT_55.val(), "g"+o5); // ㇋ DOUBLEBENT_52
        arrayInspiredElemsV1.put(DOUBLEBENT_55_WITHHOOK.val(), "g"+o5); //DOUBLEBENT_55_WITHHOOK("𠄎", true), //𠄎 eg 仍
        arrayInspiredElemsV1.put(DOUBLEBENT_52NOHOOK.val(), "g"+o5); //㇈ eg 凹
            arrayInspiredElemsV1.put(DOUBLEBENT_52WITHHOOK.val(), "g"+o5); //㇠

        //b
            //left side
            arrayInspiredElemsV1.put("己", "b"+o1); //EXCEPTION  = 己 from //巷	⿱共巳[GTK]	⿱共己[J]
            arrayInspiredElemsV1.put("力", "b"+o9); //势抛执  --simp
        arrayInspiredElemsV1.put("又", "b"+o8); //b=5+8 k=8又 对

        //Sixth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //y h n
            arrayInspiredElemsV1.put("言", "y"+t6); //言-辶-衤  請靖
            arrayInspiredElemsV1.put("訁", "y"+t6);
            arrayInspiredElemsV1.put("讠", "y"+t6);
            arrayInspiredElemsV1.put("衣", "n"+t6);
            arrayInspiredElemsV1.put("衤", "n"+t6);
            arrayInspiredElemsV1.put("心", "h"+t6); //n=6+6 x=2+6
            arrayInspiredElemsV1.put("忄", "h"+t6); //忄 short form of 心

        //
            arrayInspiredElemsV1.put("方", "y"+o1); //h=6+5 z=1+9
            arrayInspiredElemsV1.put("亠", "y"+o6); //竟親
            //left side

        //h
        arrayInspiredElemsV1.put(DOTLEFT.val(), "h"); //、 eg. 自
        arrayInspiredElemsV1.put(DOTRIGHT.val(), "h"); //h=6  // 兎 ⿱丿⿷⑤丶  匆 ⿻勿丶 ⿹勹⿻⿱丿丿丶
            arrayInspiredElemsV1.put(OLAP6TRADCROWOUTSIDE.key(), "h"+o5); //烏乌 trad And simp crow outerShape
            arrayInspiredElemsV1.put(OLAP3SIMPCROWOUTSIDE.key(), "h"+o5); //烏乌 trad And simp crow outerShape

        //n
        arrayInspiredElemsV1.put("广", "n"+o3); //n=6+9  z=1+9 eg. 麼 --长广
            arrayInspiredElemsV1.put("大", "n"+o9); //z=1+8 .=9+8

            //Seventh column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //u j m  //月目雨
            arrayInspiredElemsV1.put("目", "u"+t7);
            arrayInspiredElemsV1.put("雨", "j"+t7);
            arrayInspiredElemsV1.put("月", "m"+t7);
        //u
            //left side
        arrayInspiredElemsV1.put("皿", "u"+o3); //u=7+1 e=3+3
            arrayInspiredElemsV1.put("且", "u"+o7);
            arrayInspiredElemsV1.put("几", "j"+o5); //l=9+5 g=5  eg. 亢  亮  仉
            arrayInspiredElemsV1.put("𠘧", "j"+o5); //𠘧  from 没 or 船
            arrayInspiredElemsV1.put("殳", "j"+o8); //穀穀 - 殳 needs to be an element

        //j
            arrayInspiredElemsV1.put("貝", "j"+o8); //貝
            arrayInspiredElemsV1.put("贝", "j"+o8);
            arrayInspiredElemsV1.put("冖", "j"); //j=5 冖
        arrayInspiredElemsV1.put(OUTER2TOP_STRAIGHT.val(), "j"); //j=5 冂 from 向 南 or mine: 身
        arrayInspiredElemsV1.put(OUTER2TOP_USEANDMOONE.val(), "j"); //j=5 ⺆  from 用 周

        //m
            //left side
        arrayInspiredElemsV1.put("夕", "m"+o5); //m=7+6 h=6
        arrayInspiredElemsV1.put("𠂊", "m"+o5); //𠂊 eg 久  taken as an alternative of 夕 --免兔
            arrayInspiredElemsV1.put(OLAP2_BENTTOP_UNITED.val(), "m"+o5); //⺈ 角 ⿱⿻丿𠃍⿵⺆土 --触蟹 simp
            arrayInspiredElemsV1.put(OLAP2_BENTTOP_SPLIT.val(), "m"+o5);  //⺈ 角 ⿱⿻丿𠃍⿵⺆土  --触蟹 simp
        //⿵夙玉 ⿵几⿳一⿴𠂊⺀王
        arrayInspiredElemsV1.put(OLAP4_BENTMOON.val(), "m"+o5); //m=7+6 n=6+6x  //OLAP4_BENTMOON ⿴𠂊冫
        arrayInspiredElemsV1.put(OLAP4_BENTMOON_ALT.val(), "m"+o5);  //⿴𠂊⺀ eg 㓘	⿵夙玉[G]	⿵几⿳一⿴𠂊⺀王[T]


        //Eighth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //i k ,
            arrayInspiredElemsV1.put("金", "i"+ t8); //飲欽  冷鈴 欽炊
            arrayInspiredElemsV1.put("钅", "i"+ t8);
            arrayInspiredElemsV1.put("立", "k"+ t8); //請靖 -sayAndStand cant have same first elem -况竞兑
            arrayInspiredElemsV1.put("飠", ","+ t8);  //饅慢 飽炮
            arrayInspiredElemsV1.put("饣", ","+ t8);
        //i
            //left side

            arrayInspiredElemsV1.put("儿", "i" + o2); //麼魔
            arrayInspiredElemsV1.put("弓", "k" + o5); //g=5+5 a=1+5 //弓 from 發 //𠃍弓g 弱羽

        //k
            arrayInspiredElemsV1.put("冫", "k"+o1); //i=6+1 k=1    ?  資   冷鈴 --况竞兑
        arrayInspiredElemsV1.put("㇂", "k");
        arrayInspiredElemsV1.put("乀", "k"); //k=8
        arrayInspiredElemsV1.put(RIGHTSLANT_WITHHOOK.val(), "k"); //RIGHTSLANT_WITHHOOK
        arrayInspiredElemsV1.put("八", "k"); //k=8 //eg. 卻 stroke 1+2 and 3+4
        arrayInspiredElemsV1.put("丷", "k"); //丷 --八 variation -况竞兑
        arrayInspiredElemsV1.put("入", "k" + o9); //k=8 l=9

        //,
            //left side
        arrayInspiredElemsV1.put("䒑", "," + o1); ////導遵 --䒑 needs to be an element
        arrayInspiredElemsV1.put("米", "," + o1); //,=8+8 q=1+3
        arrayInspiredElemsV1.put(OLAP3_BONESAW.key(), "," + o9); // ,=8+6 .=9+6  //last 3 stroeks of 戈

        //Nineth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //o l .
            arrayInspiredElemsV1.put("手", "o" + t9); //扌-亻-
            arrayInspiredElemsV1.put("扌", "o" + t9);
            arrayInspiredElemsV1.put("龵", "o" + t9); //手 variant //龵 eg. 拜	⿰龵⿱一丰  掰 ⿲龵分手[G]  看	⿱龵目
            arrayInspiredElemsV1.put("竹", "l" + t9);
            arrayInspiredElemsV1.put("人", "." + t9);
            arrayInspiredElemsV1.put("亻", "." + t9);
        //o
            //left side

            arrayInspiredElemsV1.put("匕", "o" + o2); //q=1+2 s=2 //項頃 overlap
        arrayInspiredElemsV1.put("斤", "o" + o9); //o=9+3 o=9+1
        arrayInspiredElemsV1.put("臼", "o" + o3); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("𦥑", "o" + o3); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("隹", "o" + o3); //o=9+1 c=3+6 //隹 ids 隹


        //l
        arrayInspiredElemsV1.put(LEFTSLANT_HORI.val(), "l"); //l=9 "㇀"
        arrayInspiredElemsV1.put(LEFTSLANT_SHARP.val(), "l"); //l=9
        arrayInspiredElemsV1.put(LEFTSlANT_VERT.val(), "l"); //l=9
        arrayInspiredElemsV1.put("勹", "l" + o5); //l=9+5 g=5
            arrayInspiredElemsV1.put("𠂉", "l" + o5);
            arrayInspiredElemsV1.put("𠂤", "l" + o5);
        //arrayInputMap.put("", "");

        //.
            //left side

        arrayInspiredElemsV1.put("𧰨", "." + o9); // .=9+8  .=9+9  𧰨 from 家
        arrayInspiredElemsV1.put("豸", "." + o6);//.=9+9 n=6+6 //豸 from 貓
        //arrayInputMap.put("", "");

        //Tenth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //p  ;  /
            arrayInspiredElemsV1.put("車", "p" + t0); //車虫
            arrayInspiredElemsV1.put("车", "p" + t0); //车 simp fprm of 車
            arrayInspiredElemsV1.put("田", "/" + t0); //p=0+4 q=1+3
            arrayInspiredElemsV1.put("毌", "/" + t0); //毌 from 實 and Top of 婁 from 數  //taken as alternative form of 田

            //p
            //left side
            arrayInspiredElemsV1.put("日", "p" + o1); //;=0 a=1

            //;
        arrayInspiredElemsV1.put("口", ";"); //;=0 --哇蛙
            arrayInspiredElemsV1.put("只", ";" + o0); //只叭
        arrayInspiredElemsV1.put("囗", ";" + o0); //;=0 //固咕 回品 surround cant be mouth and cant be mouth x 2

        // /
            arrayInspiredElemsV1.put("罒", "/" + o6); // p=0+3 e=3+3
            arrayInspiredElemsV1.put("四", "/" + o6); // /=0+8 .=9+8 eg. 黑
            arrayInspiredElemsV1.put("甲", "/" + o3); // p=0+3 d=3 ()  (甲 eg. 里-will create conflicts)   //撞攏-里 cant end in doubleYi --里
            arrayInspiredElemsV1.put("虫", "/" + o8); // /=0+6 e=3+1 --車虫 哇蛙

        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
