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
            /*
            氵c  扌o  亻.  口;  木v  艹r  言y  糹x  辶n    金i        ?囗  ?? 禾𧾷火广亠貝山  ???米虍

            月   忄n  宀n  土r  女w  日;   竹   彳o  阝t    虫/        -?-  舟

            目u  尸b  犭z  門   車q   衤n   飠   馬c  雨   礻z

            */

            /*  try to organize outer elems by strokes:  tryToAvoid: 冖
            nr1hori: 礻馬-犭-車     nr2Bent: 糹女    nr3vert: 氵門
            nr4cross: 木艹土       nr5Bent: 阝尸     nr6dot:   言-辶-宀衤
            sevenOuterTop:  月目雨    nr8eightStrokes: 金忄飠
            nr9leftSlant: 扌-亻-竹彳   nr10box:  口日虫       */



        //arrayInputMap.put("", "");
        //First column
        //q
            //left side
            arrayInspiredElemsV1.put("車", "qd"); //q=1+3 d=3+5
            arrayInspiredElemsV1.put("车", "qd"); //车 simp fprm of 車

        arrayInspiredElemsV1.put("匕", "qs"); //q=1+2 s=2
        arrayInspiredElemsV1.put("工", "qe"); //q=1+1 e=3+1
        arrayInspiredElemsV1.put("匚", "qs"); //q=1+2 s=2  匚 from 區
        arrayInspiredElemsV1.put("匸", "qs"); //alternative of 匚, 匸 from 區

        //a
        arrayInspiredElemsV1.put("一", "aa"); //a=1

        //z
            //left side
            arrayInspiredElemsV1.put("示", "zq"); //z=1+8 q=1+3  示 ids 示
            arrayInspiredElemsV1.put("礻", "zq");  // z=1+8 q=1+3 ,礻 from  神

        arrayInspiredElemsV1.put("厂", "zl"); //z=1+9 l=9
        arrayInspiredElemsV1.put(OUTTOPLEFT2.val(), "zl"); //虍 from 號, taken as alternative to 厂
        arrayInspiredElemsV1.put("𠂆", "zl"); //eg. 所 //alternative form of 厂
        arrayInspiredElemsV1.put("𠂇", "zl"); //z=1+9 l=9
        arrayInspiredElemsV1.put("⺄", "zk"); //z=1+8  k=8    //⺄  eg. 訊 el 飞
        arrayInspiredElemsV1.put("乁", "zk"); //乁 from 气
        arrayInspiredElemsV1.put("大", "z."); //z=1+8 .=9+8
        arrayInspiredElemsV1.put("犭", "z."); //犭 left form of 犬 - but taken as short form of 大

            //here, is taken as an alternative to 示

        // Second column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //w
            //left side
        arrayInspiredElemsV1.put("女", "wo"); //w=2+1 o=9+1
        arrayInspiredElemsV1.put("巛", "ww"); //w=2+2 w=2+2

        //s
        arrayInspiredElemsV1.put("𡿨", "ss"); //from 經
        arrayInspiredElemsV1.put("𠃋", "ss"); //𠃋 from 該
        arrayInspiredElemsV1.put("𠃊", "ss"); //𠃊 from 網
        arrayInspiredElemsV1.put(DOUBLEBENT_25_WITHHOOK.val(), "ss"); //s=2 //eg. 與 or 与
        arrayInspiredElemsV1.put(DOUBLEBENT_25_NOHOOK.val(), "ss"); // s=2 //𠃑 from 誤
        arrayInspiredElemsV1.put(RIGHTBENTBUTHOOK_LARGE.val(), "ss"); //s=2
        arrayInspiredElemsV1.put(RIGHTBENTBUT_SHARP.val(), "ss"); //s=2
        arrayInspiredElemsV1.put(DOWNWITHHOOK.val(), "ss"); //DOWNWITHHOOK - related to OLAP3YIANDCHANGBUTTOM
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
        //e
            //left side
        arrayInspiredElemsV1.put("⺊", "ea");
        arrayInspiredElemsV1.put("止", "eq"); //e=3+1 q=1+3
        arrayInspiredElemsV1.put("刂", "ed"); //e=3+3 d=3
        arrayInspiredElemsV1.put(OLAP3ZHABUT.val(), "eq"); //e=3+1  q=1+1 //button of 乍 or left side of 耳
        arrayInspiredElemsV1.put(OLAP4TWOVERTTWOHORI.key(), "eq");//e=3+3 q=1+1 //example: 其 ⿱⿱⑤一八 and 面/囬

        //d
        arrayInspiredElemsV1.put("丨", "dd");
        arrayInspiredElemsV1.put("亅", "dd");
        arrayInspiredElemsV1.put("山", "dw"); //d=3+3 w=2+3
        arrayInspiredElemsV1.put("片", "dz"); //d=3+5 z=1+9 mirro image of 爿,
            // I wanted to give them the same code, but they both are in first 5000

        //c
            //left side
            arrayInspiredElemsV1.put("水", "cb"); //c=3+8 b=5+9  //ids: 水	⿲㇇亅⿺乀丿
            arrayInspiredElemsV1.put("氵", "cb"); // 水 short

        arrayInspiredElemsV1.put("小", "c."); //c=3+8 .=9+8
        arrayInspiredElemsV1.put("⺌", "c."); //⺌ variant of 小, from 当
        arrayInspiredElemsV1.put("𭕄", "c."); //variant of 小  //𭕄 eg.  学
        arrayInspiredElemsV1.put("𣥂", "cn"); //c=3+9 n=6+9 𣥂 ids 𣥂 from  步
        arrayInspiredElemsV1.put("馬", "cq"); //c=3+6  q=1+3  馬 ids ⿹⑥灬
        arrayInspiredElemsV1.put("马", "cq"); //simplified form of 馬  马  ②

        //Forth coulmn
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //r
            //left side
            arrayInspiredElemsV1.put("廿", "rd"); //r=4+1 d=3+1
            arrayInspiredElemsV1.put("艹", "rd"); //alternative form of 廿
            arrayInspiredElemsV1.put("卄", "rd"); //alternative form of 廿 卄 from 龷 黄
            arrayInspiredElemsV1.put("丱", "rd"); //taken as alternative form of 廿
            arrayInspiredElemsV1.put("艹", "rd"); //艹 from 歡

        arrayInspiredElemsV1.put("土", "ra"); //r=4+1 a=1


        //f
        arrayInspiredElemsV1.put("十", "ff"); //f=4
        arrayInspiredElemsV1.put(OLAP3RUSSIANCROSS.val(), "fq"); //f=4 q=1+3 //middle side of 生, top side of 龶, top right of 請, midle of
        arrayInspiredElemsV1.put(OVERLAP.desc() + "二丨", "fq"); //OLAP3RUSSIANCROSS full value, //middle side of 生, top side of 龶, top right of 請
        arrayInspiredElemsV1.put(OLAP4NIENBUT.val(), "fq");  //buton side of 年, alternative form of "二丨" //OLAP3RUSSIANCROSS

        //v
            //left side
        arrayInspiredElemsV1.put("木", "v."); //v=4+8 .=9+8
        arrayInspiredElemsV1.put("𣎳", "v."); //𣎳 v=4+8 .=9+8 Taken as 十 + 八, or an alternative form of 木, eg. 麼
        arrayInspiredElemsV1.put("朩", "v.");//taken as alternative form of 木, eg. 新

        //Fifth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //t
            //left side
        arrayInspiredElemsV1.put("阝", "td"); //t=5+3 d=3 //first stroke taken as DOUBLEBENT_55
        arrayInspiredElemsV1.put("卩", "td"); //t=5+3 d=d卩 from 报
        arrayInspiredElemsV1.put("𠁣", "tg"); //t=5+3  q=1+1 𠁣 eg. 門	⿰𠁣𠃛
        arrayInspiredElemsV1.put("𠃛", "tg"); //𠁣 variant //𠃛 eg. 門	⿰𠁣𠃛

        arrayInspiredElemsV1.put(OLAP3HORIFORKLIKE.key(), "tq"); //t=5+1 q=1+1 eg. 事 stroke 6,7,8 or ids 尹 ⿻⿻コ一丿 stroke 1,2,3
        arrayInspiredElemsV1.put("巳", "tq"); //t=5+2 q=1+2  //巳 from 僊 凞 包
        arrayInspiredElemsV1.put(OLAP3LEFTSIDEOFPEOPLE.key(), "tq"); //first 3 strokes of 民, taken as alternative form of 巳

        //g
        arrayInspiredElemsV1.put("乛", "gg"); //t=5
        arrayInspiredElemsV1.put(BENTTOPHOOK_LARGE.val(), "gg"); //"𠃌" g=5 有万令
        arrayInspiredElemsV1.put(BENTTOP_SHARP.val(), "gg"); //𠃍 eg.過
        arrayInspiredElemsV1.put(BENTTOP_ROUND.val(), "gg"); //㇇ from 永
        arrayInspiredElemsV1.put(DOUBLEBENT_55.val(), "gg"); // ㇋ DOUBLEBENT_52
        arrayInspiredElemsV1.put(DOUBLEBENT_55_WITHHOOK.val(), "gg"); //DOUBLEBENT_55_WITHHOOK("𠄎", true), //𠄎 eg 仍
        arrayInspiredElemsV1.put(DOUBLEBENT_52WITHHOOK.val(), "gg"); //㇠
        arrayInspiredElemsV1.put(DOUBLEBENT_52NOHOOK.val(), "gg"); //㇈ eg 凹
        arrayInspiredElemsV1.put("已", "gg");  //EXCEPTION //已 -- only used in ids character beyond BMP
        arrayInspiredElemsV1.put("弓", "ga"); //g=5+5 a=1+5 //弓 from 發

        //b
            //left side
        arrayInspiredElemsV1.put("刀", "bl"); //b=5+9 l=9
        arrayInspiredElemsV1.put("又", "bk"); //b=5+8 k=8又 对
        arrayInspiredElemsV1.put("尸", "bz"); //b=5+9 z=1+9  eg. 所
        arrayInspiredElemsV1.put("𠃜", "bz"); //taken as a variant of 尸, 𠃜 from 声
        arrayInspiredElemsV1.put("艮", "bq"); //b=5+8 q=1+1 艮
        arrayInspiredElemsV1.put(LEFTSIDE5_FLAGWITHMIDDLE.val(), "bq"); //left of 即 //seen as a variatin of  艮
        arrayInspiredElemsV1.put("己", "bb"); //EXCEPTION  = 己 from //巷	⿱共巳[GTK]	⿱共己[J]
        arrayInspiredElemsV1.put("癶", "b,"); // b=5+8 ,=8+9 //ids 癶 ⿰②③ from 發
        arrayInspiredElemsV1.put("廴", "b,");//b=5+8 ,=8 廴 from     建

        //Sixth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //y
            //left side
        arrayInspiredElemsV1.put("言", "yq"); //y=6+1 q=1+1
        arrayInspiredElemsV1.put("讠", "yq"); //言 short
        arrayInspiredElemsV1.put("立", "yz"); //y=6+1 z=1+8

        //h
        arrayInspiredElemsV1.put(DOTLEFT.val(), "hh"); //、 eg. 自
        arrayInspiredElemsV1.put(DOTRIGHT.val(), "hh"); //h=6  // 兎 ⿱丿⿷⑤丶  匆 ⿻勿丶 ⿹勹⿻⿱丿丿丶
        arrayInspiredElemsV1.put("方", "hz"); //h=6+5 z=1+9

        //n
            //left side
        arrayInspiredElemsV1.put("宀", "nd"); //n=6+7 d=3+5    //宀 eg. 家
        arrayInspiredElemsV1.put("之", "nb"); //n=6+8 b=5+8
        arrayInspiredElemsV1.put("辶", "nb"); //n=6+8 g=5+8
        arrayInspiredElemsV1.put("心", "nx"); //n=6+6 x=2+6
        arrayInspiredElemsV1.put("忄", "nx"); //忄 short form of 心
        arrayInspiredElemsV1.put("广", "nz"); //n=6+9  z=1+9 eg. 麼
        arrayInspiredElemsV1.put("衣", "nz"); //n=6+8 z=1+9 //衣 short form 衤 from 被
        arrayInspiredElemsV1.put("衤", "nz"); //short for of 衣
        arrayInspiredElemsV1.put(OLAP3YIANDCHANGBUTTOM.key(), "nz");//similar to 衣 //OLAP3YIANDCHANGBUTTOM butom part of 𧘇 長 丧 喪 𠅕

            //Seventh column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //u
            //left side
        arrayInspiredElemsV1.put("皿", "ue"); //u=7+1 e=3+3
        arrayInspiredElemsV1.put("目", "uq"); //u=0+1  q=1+1
        arrayInspiredElemsV1.put("巾", "ud"); //u=7+3 d=3  巾 part of rain: eg. 電

        //j
        arrayInspiredElemsV1.put("冖", "jj"); //j=5 冖
        arrayInspiredElemsV1.put(OUTER2TOP_STRAIGHT.val(), "jj"); //j=5 冂 from 向 南 or mine: 身
        arrayInspiredElemsV1.put(OUTER2TOP_USEANDMOONE.val(), "jj"); //j=5 ⺆  from 用 周
        //arrayInputMap.put("目", "uq"); u=7+1 q=1+1

        //m
            //left side
        arrayInspiredElemsV1.put("夕", "mh"); //m=7+6 h=6
        arrayInspiredElemsV1.put("𠂊", "mh"); //𠂊 eg 久  taken as an alternative of 夕
        //⿵夙玉 ⿵几⿳一⿴𠂊⺀王
        arrayInspiredElemsV1.put(OLAP4_BENTMOON.val(), "mn"); //m=7+6 n=6+6x  //OLAP4_BENTMOON ⿴𠂊冫
        arrayInspiredElemsV1.put(OLAP4_BENTMOON_ALT.val(), "mn");  //⿴𠂊⺀ eg 㓘	⿵夙玉[G]	⿵几⿳一⿴𠂊⺀王[T]
        arrayInspiredElemsV1.put("貝", "mq"); //m=7+8 q=1+1

        //Eighth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //i
            //left side
        arrayInspiredElemsV1.put("金", "iq"); //i=8+1 q=1+1    //arrayInputMap.put("半", ""); //i=8+3
        arrayInspiredElemsV1.put("钅", "iq"); //钅simp left-side form of 金
        arrayInspiredElemsV1.put("冫", "ik"); //i=6+1 k=1    ?  資

        //k
        arrayInspiredElemsV1.put("㇂", "kk");
        arrayInspiredElemsV1.put("乀", "kk"); //k=8
        arrayInspiredElemsV1.put(RIGHTSLANT_WITHHOOK.val(), "kk"); //RIGHTSLANT_WITHHOOK
        arrayInspiredElemsV1.put("八", "kk"); //k=8 //eg. 卻 stroke 1+2 and 3+4
        arrayInspiredElemsV1.put("丷", "kk"); //丷 --八 variation
        //arrayInputMap.put("人", ""); //l=9 k=8
        arrayInspiredElemsV1.put("入", "kl"); //k=8 l=9

        //,
            //left side
        arrayInspiredElemsV1.put("火", ",."); //,=8+8 .=9+8
        arrayInspiredElemsV1.put("灬", ",."); //short form of 火
        arrayInspiredElemsV1.put("米", ",q"); //,=8+8 q=1+3
        arrayInspiredElemsV1.put(OLAP3_BONESAW.key(), ",."); // ,=8+6 .=9+6  //last 3 stroeks of 戈

        //Nineth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //o
            //left side
        arrayInspiredElemsV1.put("𠂉", "oa"); //𠂉
        arrayInspiredElemsV1.put("手", "oq"); //o=9+3 q=1+3 //I take the last 2 strokes to be 1 and 3, not 4
        arrayInspiredElemsV1.put("扌", "oq"); //手 short
        arrayInspiredElemsV1.put("龵", "oq"); //手 variant //龵 eg. 拜	⿰龵⿱一丰  掰 ⿲龵分手[G]  看	⿱龵目
        arrayInspiredElemsV1.put("斤", "oo"); //o=9+3 o=9+1
        arrayInspiredElemsV1.put("彳", "oo"); //o=9+3 0=9+3  彳 eg. 得
        arrayInspiredElemsV1.put("臼", "oe"); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("𦥑", "oe"); //o=9+1 e=3+1
        arrayInspiredElemsV1.put("隹", "oc"); //o=9+1 c=3+6 //隹 ids 隹

        //l
        arrayInspiredElemsV1.put(LEFTSLANT_HORI.val(), "ll"); //l=9 "㇀"
        arrayInspiredElemsV1.put(LEFTSLANT_SHARP.val(), "ll"); //l=9
        arrayInspiredElemsV1.put(LEFTSlANT_VERT.val(), "ll"); //l=9
        arrayInspiredElemsV1.put("几", "lg"); //l=9+5 g=5  eg. 亢  亮  仉
        arrayInspiredElemsV1.put("𠘧", "lg"); //𠘧  from 没 or 船
        arrayInspiredElemsV1.put("勹", "lg"); //l=9+5 g=5
        //arrayInputMap.put("", "");

        //.
            //left side
        arrayInspiredElemsV1.put("人", ".k"); //.=9+8 k=8
        arrayInspiredElemsV1.put("亻", ".k"); //short 人
        arrayInspiredElemsV1.put("乂", ".k"); //ex. 文
        arrayInspiredElemsV1.put("㐅", ".k"); //ex. 學
        arrayInspiredElemsV1.put("夂", ".b"); //.=9+9 b=5+8 夂  ex. 後
        arrayInspiredElemsV1.put("夊", ".b"); //.=9+9 b=5+8  夊 eg. 後
        arrayInspiredElemsV1.put("𧰨", ".."); // .=9+8  .=9+9  𧰨 from 家
        arrayInspiredElemsV1.put("豸", ".n");//.=9+9 n=6+6 //豸 from 貓
        //arrayInputMap.put("", "");

        //Tenth column
        //1	 2	3	4	5	6	7	8	9	0
        //一 └	〡	十	┐	、	ㄇ	八＼	丿	口
        //p
            //left side
        arrayInspiredElemsV1.put("田", "pq"); //p=0+4 q=1+3
        arrayInspiredElemsV1.put("毌", "pq"); //毌 from 實 and Top of 婁 from 數
            //taken as alternative form of 田
        arrayInspiredElemsV1.put("罒", "pe"); // p=0+3 e=3+3
        arrayInspiredElemsV1.put("甲", "pd"); // p=0+3 d=3 ()  甲 eg. 里

        //;
        arrayInspiredElemsV1.put("日", ";a"); //;=0 a=1
        arrayInspiredElemsV1.put("口", ";;"); //;=0
        arrayInspiredElemsV1.put("囗", ";;"); //;=0

        // /
            //left side
        arrayInspiredElemsV1.put("四", "/."); // /=0+8 .=9+8
        arrayInspiredElemsV1.put("虫", "/e"); // /=0+6 e=3+1

        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        //arrayInputMap.put("", "");
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
