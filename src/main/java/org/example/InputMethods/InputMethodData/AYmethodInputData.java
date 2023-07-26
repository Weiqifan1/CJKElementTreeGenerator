package org.example.InputMethods.InputMethodData;

import java.util.HashMap;
import java.util.zip.DataFormatException;

import static org.example.InputMethods.CustomStrokeCollections.*;
import static org.example.ObjectTypes.GenericTypes.CJKDescription.OVERLAP;

public class AYmethodInputData {

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
        //If the elememnt match a primitive, the letter will be from the middle row.
        //second letter:
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


        //arrayInputMap.put("", "");
            //q a z
            arrayInspiredElemsV1.put("示", "qa");
            arrayInspiredElemsV1.put("礻", "qa");


        //First column
        //q//left side
        arrayInspiredElemsV1.put("工", "qe"); //q=1+1 e=3+1
        arrayInspiredElemsV1.put("匚", "qs"); //q=1+2 s=2  匚 from 區
        arrayInspiredElemsV1.put("匸", "qs"); //alternative of 匚, 匸 from 區
            arrayInspiredElemsV1.put("厂", "ql"); //z=1+9 l=9  //友反 canNotOverlap
            arrayInspiredElemsV1.put(OUTTOPLEFT2.val(), "ql"); //虍 from 號, taken as alternative to 厂
            arrayInspiredElemsV1.put("𠂆", "ql"); //eg. 所 //alternative form of 厂
            arrayInspiredElemsV1.put("臣", "qd"); //臣


        //a
        arrayInspiredElemsV1.put("一", "a"); //a=1

        //z
            //left side
            arrayInspiredElemsV1.put("示", "zq"); //z=1+8 q=1+3  示 ids 示
            arrayInspiredElemsV1.put("礻", "zq");  // z=1+8 q=1+3 ,礻 from  神

            arrayInspiredElemsV1.put("丆", "zl"); //礙礎 石 must be 1 or 2 codes, 丆 should probably be and element
        arrayInspiredElemsV1.put("⺄", "zk"); //z=1+8  k=8    //⺄  eg. 訊 el 飞
        arrayInspiredElemsV1.put("乁", "zk"); //乁 from 气
            arrayInspiredElemsV1.put("犬", "zh");
        arrayInspiredElemsV1.put("大", "z."); //z=1+8 .=9+8
        arrayInspiredElemsV1.put("犭", "zh"); //犭 left form of 犬 - but taken as short form of 大

            //here, is taken as an alternative to 示

        // Second column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //w s x
            arrayInspiredElemsV1.put("山", "ws");
            arrayInspiredElemsV1.put("凵", "wd");//⿱屮凵
            //arrayInspiredElemsV1.put("女", "ss");
            arrayInspiredElemsV1.put("心", "sk"); //煌惶 //忄金飠 //慢饅
            arrayInspiredElemsV1.put("忄", "sk");
            arrayInspiredElemsV1.put("糸", "xs");
            arrayInspiredElemsV1.put("糹", "xs");
            arrayInspiredElemsV1.put("纟", "xs");
        //w
            //left side
        //arrayInspiredElemsV1.put("女", "wo"); //w=2+1 o=9+1
        //arrayInspiredElemsV1.put("巛", "ww"); //w=2+2 w=2+2
            arrayInspiredElemsV1.put("火", "w."); //,=8+8 .=9+8
            arrayInspiredElemsV1.put("灬", "w."); //short form of 火

        //s
        arrayInspiredElemsV1.put("𡿨", "s"); //from 經
        arrayInspiredElemsV1.put("𠃋", "s"); //𠃋 from 該
        arrayInspiredElemsV1.put("𠃊", "s"); //𠃊 from 網
        arrayInspiredElemsV1.put(DOUBLEBENT_25_WITHHOOK.val(), "s"); //s=2 //eg. 與 or 与
        arrayInspiredElemsV1.put(DOUBLEBENT_25_NOHOOK.val(), "s"); // s=2 //𠃑 from 誤
        arrayInspiredElemsV1.put(RIGHTBENTBUTHOOK_LARGE.val(), "s"); //s=2
        arrayInspiredElemsV1.put(RIGHTBENTBUT_SHARP.val(), "s"); //s=2
        arrayInspiredElemsV1.put(DOWNWITHHOOK.val(), "s"); //DOWNWITHHOOK - related to OLAP3YIANDCHANGBUTTOM
            arrayInspiredElemsV1.put("女", "sa");
        //arrayInputMap.put("几", ""); //s=

        //x
            //left side
        arrayInspiredElemsV1.put("厶", "xs"); //x=2+6 s=6
        arrayInspiredElemsV1.put("糸", "xx"); //x=2+8 x=2+6  eg.    //乿	⿰⿱爫糸乚  糸 ⿱幺小  经
        arrayInspiredElemsV1.put("糹", "xx"); //short form of 糸 eg/ 經 ⿰糹巠[GTV]	⿰糸巠[JK]  ⿰纟𢀖
        arrayInspiredElemsV1.put("纟", "xx"); //short form of 纟
        arrayInspiredElemsV1.put("乡", "xx"); //乡 from 響 taken as alternative form of 纟
        arrayInspiredElemsV1.put("爿", "xe"); //x=2+9 e=3+1  //mirror image is 片  as in 肅

        arrayInspiredElemsV1.put("丬", "xe"); //丬 from 将, short form of 爿


        //Third column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //e d c
            arrayInspiredElemsV1.put("門", "ed");
            arrayInspiredElemsV1.put("门", "ed");
            arrayInspiredElemsV1.put("𠁣", "ed"); //t=5+3  q=1+1 𠁣 eg. 門	⿰𠁣𠃛
            arrayInspiredElemsV1.put("𠃛", "ed"); //𠁣 variant //𠃛 eg. 門	⿰𠁣𠃛
            arrayInspiredElemsV1.put("水", "ee"); //氵門
            arrayInspiredElemsV1.put("氵", "ee");
        //e
            //left side
        arrayInspiredElemsV1.put("⺊", "ea");
        arrayInspiredElemsV1.put("止", "eq"); //e=3+1 q=1+3
        arrayInspiredElemsV1.put("刂", "ed"); //e=3+3 d=3
        arrayInspiredElemsV1.put(OLAP3ZHABUT.val(), "eq"); //e=3+1  q=1+1 //button of 乍 or left side of 耳
        arrayInspiredElemsV1.put(OLAP4TWOVERTTWOHORI.key(), "eq");//e=3+3 q=1+1 //example: 其 ⿱⿱⑤一八 and 面/囬

        //d
        arrayInspiredElemsV1.put("丨", "d");
        arrayInspiredElemsV1.put("亅", "d");
        //arrayInspiredElemsV1.put("山", "dw"); //d=3+3 w=2+3
        arrayInspiredElemsV1.put("片", "dz"); //d=3+5 z=1+9 mirro image of 爿,
            // I wanted to give them the same code, but they both are in first 5000

        //c
            //left side

        arrayInspiredElemsV1.put("小", "c."); //c=3+8 .=9+8
        arrayInspiredElemsV1.put("⺌", "c."); //⺌ variant of 小, from 当
        arrayInspiredElemsV1.put("𭕄", "c."); //variant of 小  //𭕄 eg.  学
        arrayInspiredElemsV1.put("𣥂", "cn"); //c=3+9 n=6+9 𣥂 ids 𣥂 from  步
        arrayInspiredElemsV1.put("馬", "cq"); //c=3+6  q=1+3  馬 ids ⿹⑥灬
        arrayInspiredElemsV1.put("马", "cq"); //simplified form of 馬  马  ②

        //Forth coulmn
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //r f v
            arrayInspiredElemsV1.put("廿", "rf"); //r=4+1 d=3+1
            arrayInspiredElemsV1.put("艹", "rf"); //木艹土
            arrayInspiredElemsV1.put("卄", "rf"); //alternative form of 廿 卄 from 龷 黄
            arrayInspiredElemsV1.put("丱", "rf"); //taken as alternative form of 廿
            arrayInspiredElemsV1.put("艹", "rf"); //艹 from 歡
            arrayInspiredElemsV1.put("寸", "fh"); //寸
        //r
            //left side
            arrayInspiredElemsV1.put("龶", "ra");
            arrayInspiredElemsV1.put("匕", "rs"); //q=1+2 s=2 //項頃 overlap

        //f
        arrayInspiredElemsV1.put("十", "f"); //f=4  //十and 龶 /russiancross cant overlap - 勒勤
            arrayInspiredElemsV1.put("𠂇", "fl"); //z=1+9 l=9
        arrayInspiredElemsV1.put(OLAP3RUSSIANCROSS.val(), "fq"); //f=4 q=1+3 //middle side of 生, top side of 龶, top right of 請, midle of
        arrayInspiredElemsV1.put(OVERLAP.desc() + "二丨", "fq"); //OLAP3RUSSIANCROSS full value, //middle side of 生, top side of 龶, top right of 請
        arrayInspiredElemsV1.put(OLAP4NIENBUT.val(), "fq");  //buton side of 年, alternative form of "二丨" //OLAP3RUSSIANCROSS
            arrayInspiredElemsV1.put("土", "fr"); //士土


        //v
            //left side
        //arrayInspiredElemsV1.put("木", "v."); //v=4+8 .=9+8
            arrayInspiredElemsV1.put("木", "vv");
        arrayInspiredElemsV1.put("𣎳", "vv"); //𣎳 v=4+8 .=9+8 Taken as 十 + 八, or an alternative form of 木, eg. 麼
        arrayInspiredElemsV1.put("朩", "vv");//taken as alternative form of 木, eg. 新
            arrayInspiredElemsV1.put("束", "v;"); //杏束 overlap
            arrayInspiredElemsV1.put("末", "va"); //末未(本)
            arrayInspiredElemsV1.put("棘", "v,"); //棘棗

        //Fifth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //t g b
            //arrayInspiredElemsV1.put("阝", "tg"); //阝尸
            //arrayInspiredElemsV1.put("之", "gg");
            arrayInspiredElemsV1.put("辶", "gg"); //隊遂
            arrayInspiredElemsV1.put("子", "tg");
            arrayInspiredElemsV1.put("尸", "bg");
        //t
            //left side
        arrayInspiredElemsV1.put("阝", "td"); //t=5+3 d=3 //first stroke taken as DOUBLEBENT_55  //隊遂
        arrayInspiredElemsV1.put("卩", "td"); //t=5+3 d=d卩 from 报

        arrayInspiredElemsV1.put(OLAP3HORIFORKLIKE.key(), "tq"); //t=5+1 q=1+1 eg. 事 stroke 6,7,8 or ids 尹 ⿻⿻コ一丿 stroke 1,2,3
        arrayInspiredElemsV1.put("巳", "tq"); //t=5+2 q=1+2  //巳 from 僊 凞 包
        arrayInspiredElemsV1.put(OLAP3LEFTSIDEOFPEOPLE.key(), "tq"); //first 3 strokes of 民, taken as alternative form of 巳

        //g
        arrayInspiredElemsV1.put("乛", "g"); //t=5
        arrayInspiredElemsV1.put(BENTTOPHOOK_LARGE.val(), "g"); //"𠃌" g=5 有万令
        arrayInspiredElemsV1.put(BENTTOP_SHARP.val(), "g"); //𠃍 eg.過
        arrayInspiredElemsV1.put(BENTTOP_ROUND.val(), "g"); //㇇ from 永
        arrayInspiredElemsV1.put(DOUBLEBENT_55.val(), "gb"); // ㇋ DOUBLEBENT_52
        arrayInspiredElemsV1.put(DOUBLEBENT_55_WITHHOOK.val(), "gb"); //DOUBLEBENT_55_WITHHOOK("𠄎", true), //𠄎 eg 仍
        arrayInspiredElemsV1.put(DOUBLEBENT_52WITHHOOK.val(), "gt"); //㇠
        arrayInspiredElemsV1.put(DOUBLEBENT_52NOHOOK.val(), "gt"); //㇈ eg 凹
        arrayInspiredElemsV1.put("已", "gg");  //EXCEPTION //已 -- only used in ids character beyond BMP

        //b
            //left side
        arrayInspiredElemsV1.put("刀", "bl"); //b=5+9 l=9
        arrayInspiredElemsV1.put("又", "bk"); //b=5+8 k=8又 对
        //arrayInspiredElemsV1.put("尸", "bz"); //b=5+9 z=1+9  eg. 所
        arrayInspiredElemsV1.put("𠃜", "bz"); //taken as a variant of 尸, 𠃜 from 声
        arrayInspiredElemsV1.put("艮", "bq"); //b=5+8 q=1+1 艮
        arrayInspiredElemsV1.put(LEFTSIDE5_FLAGWITHMIDDLE.val(), "bq"); //left of 即 //seen as a variatin of  艮
        arrayInspiredElemsV1.put("己", "bb"); //EXCEPTION  = 己 from //巷	⿱共巳[GTK]	⿱共己[J]
        arrayInspiredElemsV1.put("癶", "b,"); // b=5+8 ,=8+9 //ids 癶 ⿰②③ from 發
        arrayInspiredElemsV1.put("廴", "b,");//b=5+8 ,=8 廴 from     建

        //Sixth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //y h n
            arrayInspiredElemsV1.put("言", "yh"); //言-辶-衤  請靖
            arrayInspiredElemsV1.put("訁", "yh");
            arrayInspiredElemsV1.put("讠", "yh");
            arrayInspiredElemsV1.put("衣", "nh");
            arrayInspiredElemsV1.put("衤", "nh");
            arrayInspiredElemsV1.put("心", "hh"); //n=6+6 x=2+6
            arrayInspiredElemsV1.put("忄", "hh"); //忄 short form of 心

        //
            arrayInspiredElemsV1.put("方", "yz"); //h=6+5 z=1+9
            arrayInspiredElemsV1.put("亠", "yy"); //竟親
            //left side
        //arrayInspiredElemsV1.put("言", "yq"); //y=6+1 q=1+1
        //arrayInspiredElemsV1.put("讠", "yq"); //言 short
        //arrayInspiredElemsV1.put("立", "nz"); //y=6+1 z=1+8

        //h
        arrayInspiredElemsV1.put(DOTLEFT.val(), "h"); //、 eg. 自
        arrayInspiredElemsV1.put(DOTRIGHT.val(), "h"); //h=6  // 兎 ⿱丿⿷⑤丶  匆 ⿻勿丶 ⿹勹⿻⿱丿丿丶
            arrayInspiredElemsV1.put(OLAP6TRADCROWOUTSIDE.key(), "hg"); //烏乌 trad And simp crow outerShape
            arrayInspiredElemsV1.put(OLAP3SIMPCROWOUTSIDE.key(), "hg"); //烏乌 trad And simp crow outerShape

        //n
        arrayInspiredElemsV1.put("广", "nz"); //n=6+9  z=1+9 eg. 麼
        arrayInspiredElemsV1.put(OLAP3YIANDCHANGBUTTOM.key(), "nz");//similar to 衣 //OLAP3YIANDCHANGBUTTOM butom part of 𧘇 長 丧 喪 𠅕

            //Seventh column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //u j m  //月目雨
            arrayInspiredElemsV1.put("目", "uj");
            arrayInspiredElemsV1.put("雨", "jj");
            arrayInspiredElemsV1.put("月", "mj");
        //u
            //left side
        arrayInspiredElemsV1.put("皿", "ue"); //u=7+1 e=3+3
            arrayInspiredElemsV1.put("且", "uu");
            arrayInspiredElemsV1.put("宀", "uj"); //n=6+7 d=3+5    //謬寥 言宀 diff  //富幅 宀巾 diff

        //j
        arrayInspiredElemsV1.put("冖", "j"); //j=5 冖
            arrayInspiredElemsV1.put("巾", "jd"); //巾 //富幅 宀巾 diff
        arrayInspiredElemsV1.put(OUTER2TOP_STRAIGHT.val(), "j"); //j=5 冂 from 向 南 or mine: 身
        arrayInspiredElemsV1.put(OUTER2TOP_USEANDMOONE.val(), "j"); //j=5 ⺆  from 用 周

        //m
            //left side
        arrayInspiredElemsV1.put("夕", "mh"); //m=7+6 h=6
        arrayInspiredElemsV1.put("𠂊", "mh"); //𠂊 eg 久  taken as an alternative of 夕
        //⿵夙玉 ⿵几⿳一⿴𠂊⺀王
        arrayInspiredElemsV1.put(OLAP4_BENTMOON.val(), "mn"); //m=7+6 n=6+6x  //OLAP4_BENTMOON ⿴𠂊冫
        arrayInspiredElemsV1.put(OLAP4_BENTMOON_ALT.val(), "mn");  //⿴𠂊⺀ eg 㓘	⿵夙玉[G]	⿵几⿳一⿴𠂊⺀王[T]
            arrayInspiredElemsV1.put("貝", "mk"); //貝

        //Eighth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //i k ,
            arrayInspiredElemsV1.put("金", "ik"); //飲欽  冷鈴 欽炊
            arrayInspiredElemsV1.put("钅", "ik");
            arrayInspiredElemsV1.put("立", "kk"); //請靖 -sayAndStand cant have same first elem
            arrayInspiredElemsV1.put("飠", ",k");  //饅慢 飽炮
            arrayInspiredElemsV1.put("饣", ",k");
        //i
            //left side
        arrayInspiredElemsV1.put("冫", "kk"); //i=6+1 k=1    ?  資   冷鈴
            arrayInspiredElemsV1.put("弓", "kb"); //g=5+5 a=1+5 //弓 from 發 //𠃍弓g 弱羽

        //k
        arrayInspiredElemsV1.put("㇂", "k");
        arrayInspiredElemsV1.put("乀", "k"); //k=8
        arrayInspiredElemsV1.put(RIGHTSLANT_WITHHOOK.val(), "k"); //RIGHTSLANT_WITHHOOK
        arrayInspiredElemsV1.put("八", "k"); //k=8 //eg. 卻 stroke 1+2 and 3+4
        arrayInspiredElemsV1.put("丷", "k"); //丷 --八 variation
        arrayInspiredElemsV1.put("入", "kl"); //k=8 l=9

        //,
            //left side
        arrayInspiredElemsV1.put("䒑", ",a"); ////導遵 --䒑 needs to be an element
        arrayInspiredElemsV1.put("米", ",q"); //,=8+8 q=1+3
        arrayInspiredElemsV1.put(OLAP3_BONESAW.key(), ",."); // ,=8+6 .=9+6  //last 3 stroeks of 戈

        //Nineth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //o l .
            arrayInspiredElemsV1.put("手", "ol"); //扌-亻-
            arrayInspiredElemsV1.put("扌", "ol");
            arrayInspiredElemsV1.put("龵", "ol"); //手 variant //龵 eg. 拜	⿰龵⿱一丰  掰 ⿲龵分手[G]  看	⿱龵目
            arrayInspiredElemsV1.put("竹", "ll");
            arrayInspiredElemsV1.put("人", ".l");
            arrayInspiredElemsV1.put("亻", ".l");
            arrayInspiredElemsV1.put("𠂉", ".a");
        //o
            //left side
        arrayInspiredElemsV1.put("斤", "oo"); //o=9+3 o=9+1
        arrayInspiredElemsV1.put("臼", "oe"); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("𦥑", "oe"); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("隹", "oc"); //o=9+1 c=3+6 //隹 ids 隹
            arrayInspiredElemsV1.put("几", "og"); //l=9+5 g=5  eg. 亢  亮  仉
            arrayInspiredElemsV1.put("𠘧", "og"); //𠘧  from 没 or 船
            arrayInspiredElemsV1.put("殳", "ok"); //穀穀 - 殳 needs to be an element

        //l
        arrayInspiredElemsV1.put(LEFTSLANT_HORI.val(), "l"); //l=9 "㇀"
        arrayInspiredElemsV1.put(LEFTSLANT_SHARP.val(), "l"); //l=9
        arrayInspiredElemsV1.put(LEFTSlANT_VERT.val(), "l"); //l=9
            arrayInspiredElemsV1.put("攵", "l."); //微徵 攵 must be one elem
            arrayInspiredElemsV1.put("乂", "l."); //ex. 文  //兄史
            arrayInspiredElemsV1.put("㐅", "l."); //ex. 學  //兄史
        arrayInspiredElemsV1.put("勹", "lg"); //l=9+5 g=5
            arrayInspiredElemsV1.put("𠂤", "la");
        //arrayInputMap.put("", "");

        //.
            //left side

        arrayInspiredElemsV1.put("夂", ".b"); //.=9+9 b=5+8 夂  ex. 後
        arrayInspiredElemsV1.put("夊", ".b"); //.=9+9 b=5+8  夊 eg. 後
        arrayInspiredElemsV1.put("𧰨", ".."); // .=9+8  .=9+9  𧰨 from 家
        arrayInspiredElemsV1.put("豸", ".n");//.=9+9 n=6+6 //豸 from 貓
        //arrayInputMap.put("", "");

        //Tenth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
            //p  ;  /
            arrayInspiredElemsV1.put("車", "/;"); //車虫
            arrayInspiredElemsV1.put("车", "/;"); //车 simp fprm of 車

            //p
            //left side
        arrayInspiredElemsV1.put("田", "pq"); //p=0+4 q=1+3
        arrayInspiredElemsV1.put("毌", "pq"); //毌 from 實 and Top of 婁 from 數
            //taken as alternative form of 田
        arrayInspiredElemsV1.put("罒", "pe"); // p=0+3 e=3+3
            arrayInspiredElemsV1.put("四", "pe"); // /=0+8 .=9+8 eg. 黑
        arrayInspiredElemsV1.put("甲", "pd"); // p=0+3 d=3 ()  (甲 eg. 里-will create conflicts)   //撞攏-里 cant end in doubleYi --里
            arrayInspiredElemsV1.put("虫", "p;"); // /=0+6 e=3+1 --車虫 哇蛙

        //;
        arrayInspiredElemsV1.put("口", ";"); //;=0 --哇蛙
            arrayInspiredElemsV1.put("只", ";/"); //只叭
        arrayInspiredElemsV1.put("囗", ";/"); //;=0 //固咕 回品 surround cant be mouth and cant be mouth x 2

        // /
            arrayInspiredElemsV1.put("日", "/a"); //;=0 a=1

        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
